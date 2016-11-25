


function isEmpty(elename){
    var obj = document.getElementById(elename);
    var msg = document.getElementById(elename+"Msg");
    if(obj.value!=""){
        return true;
    }else{
        msg.innerHTML = "内容输入不能为空";
        return false;
    }
}
function validateRegex(elename,regex){
    var obj = document.getElementById(elename);
    var msg = document.getElementById(elename+"Msg");
    if(regex.test(obj.value)){
        return true;
    }else{
        msg.innerHTML = "内容输入格式不正确";
        return false;
    }
}

window.onload = function(){

    document.getElementById("name").addEventListener("blur",validateName,false);
    document.getElementById("authIdAdd").addEventListener("blur",validateAuthIdAdd,false);
}

function validateName(){
    return isEmpty("name");
}

function validateAuthIdAdd(){
    return isEmpty("authIdAdd");
}

function validateCustomer(){
    return  validateName()&&
        validateAuthIdAdd();
}



/*function validateGoodprice(){
    return validateRegex("gooprice",/^\d+(\.\d{1,2})?$/);
}*/
