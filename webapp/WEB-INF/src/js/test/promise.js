/**
 * Created by xgz on 15/12/13.
 */
Promise.resolve([1]).then(
    (item)=>{
        new Promise((resolve,reject)=>{
            resolve([2])
        }).then((res)=>{
                console.log(res)
            }).catch((e)=>{
                console.log(e)
            })

    }
).then((res)=>{
        console.log(res)
        //alert(res)
    }).catch((err)=>{
        console.log(err)
    })