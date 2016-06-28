/**
 * Created by xgz on 15/11/7.
 */

var assert = require("assert");
var Immutable = require('immutable');

var items = Immutable.fromJS({count:13,items:[{localid:1},{localid:2}]})

items = items.update("items",(list)=>{

    list = list.update(0,(item)=>{
        console.log(item)
        return item.set("url","2")
        //return Immutable.fromJS({localid:15})
    })
    console.log(list)

    return list
})

var list = Immutable.List.of([1,2,3])

var list2 = list.push(4)

console.log(items)

