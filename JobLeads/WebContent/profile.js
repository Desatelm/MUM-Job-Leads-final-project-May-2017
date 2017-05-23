
$(function(){
	$("#signup").click(passWardConfirm);
	
	});

function passWardConfirm(event){
var pw = $("#pw").val();
var cPw = $("#cPw").val();

if (!(pw == cPw)){
	$("#pwCheck").text("Both passwards must be equal!!");
	event.preventDefault();
}

}