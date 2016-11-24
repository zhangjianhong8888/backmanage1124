$(document).ready(function(){

    $("#authId").blur(function(){
        $("#authIdMsg").load("customer/findCustomerByAuthId/"+$("#authId").val(),
            function(responseTxt){
                if(responseTxt=="yes")
                    $("#authIdMsg").html("");
                if(responseTxt=="no")
                    $("#authIdMsg").html("该账户不存在！");
            });
    });

    $("#authIdAdd").blur(function(){
        $("#authIdAddMsg").load("customer/findCustomerByAuthIdAdd/"+$("#authIdAdd").val(),
            function(responseTxt){
                if(responseTxt=="yes")
                    $("#authIdAddMsg").html("该账户已存在！");
                if(responseTxt=="no")
                    $("#authIdAddMsg").html("");
            });
    });

});

function add(){
    var oTr = document.getElementById("addDiv");
    var newTr = oTr.cloneNode(true);
    document.getElementById("cloneAddDiv").appendChild(newTr);
}



function isEmpty(elename){
    var obj = document.getElementById(elename);
    var msg = document.getElementById(elename+"Msg");
    if(obj.value!=""){
        return true;
    }else{
        msg.innerHTML = "内容输入不能为空";
       //obj.value = "内容输入不能为空";
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
        //obj.value = "内容输入格式不正确";
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
