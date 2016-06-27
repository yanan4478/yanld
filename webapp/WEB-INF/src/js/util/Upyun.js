/**
 * Created by xgz on 15/12/9.
 */

var md5 = require("md5")

var toplevelList = ['signature', 'policy', 'form_api_secret', 'endpoint', 'host'];

export default class Upyun {

    constructor(NProgress){
        this.events = {};
        this.configs = this.initDefaultConfigs();
        //this.NProgress = NProgress;
        //this.NProgressExist = NProgress && NProgress.start && NProgress.done;

        this.set('bucket','albumdata');
        this.set('form_api_secret', 'YFTFjWdkpMgXSG8Im06MvR84vSs=');

        this.set('x-gmkerl-rotate',"auto");

        console.log(this.configs)
    }

    set = (k, v)=> {
        if (k && v) {
            if (toplevelList.indexOf(k) > -1)
                this.configs[k] = v;
            else
                this.configs.params[k] = v;
        }

        return this;
    }

    on = (event, callback)=> {
        if (event && callback)
            this.events[event] = callback;

        return this;
    }

    initDefaultConfigs() {
        return {
            form_api_secret: '',
            params: {
                expiration: (new Date().getTime()) + 60,
                'save-key': '/{year}/{mon}/{day}/upload_{filemd5}{.suffix}',
                'allow-file-type': 'jpg,jpeg,png',
                'x-gmkerl-rotate': 'auto',
                //'x-gmkerl-type':'get_meta'
            }
        };
    }

    upload = (params,index, callback) => {
        // Check dependencies when `upload` method are trigged.
        console.log(params)
        if (!window.JSON)
            throw new Error('JSON is required.');
        if (!window.FormData)
            throw new Error('FormData is required.');
        if (!window.XMLHttpRequest)
            throw new Error('XMLHttpRequest is required.');
        if (!callback || typeof(callback) !== 'function')
            throw new Error('Callback function is required.');

        var self = this;
        var req = new XMLHttpRequest();
        var uploadByForm = typeof(params) === 'string';

        // If upload by form name,
        // All params must be input's value.
        var data = uploadByForm ?
            new FormData(document.forms.namedItem(params)) :
            new FormData();

        var b = new Buffer(JSON.stringify(self.configs.params));

        var policy = b.toString('base64');
        var apiendpoint = self.configs.endpoint || 'http://v0.api.upyun.com/' + self.configs.params.bucket;
        var imageHost = self.configs.host || 'http://' + self.configs.params.bucket + '.b0.upaiyun.com';

        // By default, if not upload files by form,
        // File object will be parse as `params`
        if (!uploadByForm)
            data.append('file', params);

        // Append `policy` and create `signature`
        data.append('policy', policy);
        data.append('signature', self.configs.signature || md5(policy + '&' + self.configs.form_api_secret));

        // Open a request
        req.open('POST', apiendpoint, true);

        //console.log("data",data)

        // Error event
        req.addEventListener('error', function(err) {
            return callback(err);
        }, false);

        // When server response
        req.addEventListener('load', function(result) {
            //if (this.NProgressExist) this.NProgress.done();
            var statusCode = result.target.status;

            // Try to parse JSON
            if (statusCode !== 200)
                return callback(new Error(result.target.status), result.target);

            try {
                var image = JSON.parse(this.responseText);
                image.absUrl = imageHost + image.url;
                image.absUri = image.absUrl;
                let _exif = null
                if(image['EXIF'] != undefined && image['EXIF'] != null){

                    _exif = image['EXIF']
                }

                console.log("Exif",_exif,image)

                return callback(null,index, result.target, image);
            } catch (err) {
                return callback(err);
            }
        }, false);

        // Upload progress monitor
        req.upload.addEventListener('progress', function(pe) {
            if (!pe.lengthComputable) return;
            if (!self.events.uploading || typeof(self.events.uploading) !== 'function')
                return;
            self.events.uploading(Math.round(pe.loaded / pe.total * 100));
        });

        // Send data to server
        req.send(data);
    }
}