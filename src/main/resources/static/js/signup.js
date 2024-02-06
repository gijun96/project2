
//valiedation LoginId
$("#validBtn").click(()=>{
var userID = $("#login_id").val();
    console.log("userID : " +userID);

$.ajax({
    type:"GET",
    url:"/api/checkById",
    data: {
        "userId": userID
    },
    // 요청 성공 시 실행
   statusCode: {
   200: function(){
    var msg = "사용 가능한 아이디 입니다.";
    alert(msg);
   },
   400: function(){
    var msg = "사용중인 아이디 입니다.";
    alert(msg);
   }

   }
});

});

// Password check
    $("#password2").blur(()=>{
        var password1 = $("#password").val();
        var password2 = $("#password2").val();
        console.log(password1);
        console.log(password2);
        if(password1 === password2){
            $("#passValidation").text("비밀번호 확인!");
        }else{
            $("#passValidation").text("비밀번호를 확인해주세요!");
        }
    });

const token = $("meta[name='_csrf']").attr("content")
const header = $("meta[name='_csrf_header']").attr("content");


$("#valid_phone").click(()=>{
    console.log("버튼 클릭!");
    var phone = $("#phone").val();
$.ajax({
    type:"POST",
    url:"/api/send-one",
    data: {
        "phone": phone
    },
    beforeSend : function(xhr){
        xhr.setRequestHeader(header, token);
    },
    StatusCode:{
    200: function(){
        alert("인증번호가 발송되었습니다.");
    },
    400: function(){
        alert("인증번호 발송중 에러가 발생하였습니다.");
    },
    2000: function(){
        alert("인증번호 발송, 2000");
    }
    }
});

})




