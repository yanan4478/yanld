/**
 * Created by xgz on 15/11/8.
 */

var assert = require("assert");
import * as im from 'immutable'

var js = im.fromJS([1,2,3]);

Object.prototype.print = function(){
    console.log(this)
    return this;
}

describe("im-list", function () {
    describe("List.isList",function(){

        it("should isList is true",function(){
            im.List.isList(js).print();
        })

        it("create list from array",function(){
            var list = im.List.of([1,2,3]).print();
            var list2 = list.set(1,4);
            //assert.equal()
            list.print();
            list2.print();
        })

        it("should set not equal",function(){
            //var list = im.fromJS({a:1,b:2,c:3});
            //console.log(list.get("a"))

            var list = im.List.of([1,2,3]);
            //console.log(list.get());
        })

    })
})

console.log(js);