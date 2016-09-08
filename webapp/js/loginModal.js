/**
 * Created by wangqiqi on 16/8/31.
 */
function handleLoginClick(id){
    if(id=="btn_login"){
        $("#loginModal").attr("class","modal_open");
        $("#mask").attr("class","mask");
    }else if(id=="modal_close"){
        $("#loginModal").attr("class","modal_close");
        $("#mask").attr("class","mask_hidden");
    }
}