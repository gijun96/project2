
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




