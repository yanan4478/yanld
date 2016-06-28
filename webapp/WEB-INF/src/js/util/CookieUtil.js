/**
 * Created by xgz on 15/12/28.
 */

import cookie from "react-cookie"

var getCookieParam = (name)=>{

    let value = cookie.load(name);

    return value == undefined? -1:value;
}

var getAgentType = (agentid)=>{
    return getCookieParam(`${agentid}__agent_type`)
}

var isFWH = (agentid)=>{

    var _ag = agentid || getAgentid();

    var d = getAgentType(_ag);

    console.log("a_t",d)

    return d == 0 || d== -1;
}

var getWxopenid = ()=>{
    return getCookieParam("wxopenid")
}

var getDataid = ()=>{
    return getCookieParam("dataid")
}

var getChannelid = ()=>{
    return getCookieParam("channel")
}

var getAgentid = ()=>{
    return getCookieParam("agentid")
}

var getProductid = ()=>{
    return getCookieParam("productid")
}

var saveCookieParam = (name,value)=>{
    cookie.save(name,value)
}

export{
    getChannelid,
    getWxopenid,
    getDataid,
    getAgentid,
    saveCookieParam,
    getProductid,
    getAgentType,
    isFWH
}