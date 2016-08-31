/**
 * Created by wangqiqi on 16/8/31.
 */
function handleLoginClick(e){
    console.log(e.target.id)
    if(e.target.id=="btn_login"){
        $("#loginModal").attr("class","modal_open");
        $("#mask").attr("class","mask");
    }else if(e.target.id=="modal_close"){
        $("#loginModal").attr("class","modal_close");
        $("#mask").attr("class","mask_hidden");
    }

}