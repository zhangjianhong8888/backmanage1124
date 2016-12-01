
function validateRegexBlue(elename,regex){
    var obj = document.getElementById(elename);
    var msg = document.getElementById(elename+"Msg");
    if(regex.test(obj.value)){
        return true;
    }else{
        msg.innerHTML = "内容输入格式不正确";
        return false;
    }
}


function validateRegexFocus(elename,regex){
    var obj = document.getElementById(elename);
    var msg = document.getElementById(elename+"Msg");
    if(regex.test(obj.value)){
        return true;
    }else{
        msg.innerHTML = "";
        return false;
    }
}

function isEmptyBlue(elename){
    var obj = document.getElementById(elename);
    var msg = document.getElementById(elename+"Msg");
    if(obj.value!=""){
        return true;
    }else{
        msg.innerHTML = "内容输入不能为空";
        return false;
    }
}
function isEmptyFocus(elename){
    var obj = document.getElementById(elename);
    var msg = document.getElementById(elename+"Msg");
    if(obj.value!=""){
        msg.innerHTML = "";
        return true;
    }else{
        msg.innerHTML = "";
        return false;
    }
}

window.onload = function(){

    document.getElementById("admin.name").addEventListener("blur",validateNameBlue,false);
    document.getElementById("admin.name").addEventListener("focus",validateNameFocus,false);
    document.getElementById("admin.loginName").addEventListener("blur",validateLoginNameBlue,false);
    document.getElementById("admin.loginName").addEventListener("focus",validateLoginNameFocus,false);
    document.getElementById("admin.password").addEventListener("blur",validatePasswordBlue,false);
    document.getElementById("admin.password").addEventListener("focus",validatePasswordFocus,false);
    document.getElementById("admin.tel").addEventListener("blur",validateTelBlue,false);
    document.getElementById("admin.tel").addEventListener("focus",validateTelFocus,false);

}


function validateNameBlue(){
    return isEmptyBlue("admin.name");
}
function validateNameFocus(){
    return isEmptyFocus("admin.name");
}
function validateLoginNameBlue(){
    return isEmptyBlue("admin.loginName");
}
function validateLoginNameFocus(){
    return isEmptyFocus("admin.loginName");
}
function validatePasswordBlue(){
    return isEmptyBlue("admin.password");
}
function validatePasswordFocus(){
    return isEmptyFocus("admin.password");
}
function validateTelBlue(){
    return validateRegexBlue("admin.tel",/(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/);
}
function validateTelFocus(){
    return validateRegexFocus("admin.tel",/(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/);
}


function validateAdmin(){
    return  validateNameBlue()&&
        validateLoginNameBlue()&&
    validatePasswordBlue()&&
    validateTelBlue();

}









/*function validateGoodprice(){
    return validateRegex("gooprice",/^\d+(\.\d{1,2})?$/);
}*/
