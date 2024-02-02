
//login_id
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