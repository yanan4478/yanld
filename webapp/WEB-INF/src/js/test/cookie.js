/**
 * Created by xgz on 15/12/11.
 */

import cookie from 'react-cookie';

var expiryDate = new Date(Number(new Date()) - 10000);

console.log(expiryDate)

cookie.save("test","testd",{expires:expiryDate,path:"/"})

let test = cookie.load("test")



console.log(cookie)