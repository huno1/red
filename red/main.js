function opentopic(thid){
	var cloak = document.getElementById("t"+thid).getElementsByClassName("cloak")[0];
	if(cloak.style.display!="block"){
		cloak.style.display="block";
	}else{
		cloak.style.display="none";
	}
}
function openaccount(){
	var cloak = document.getElementById("newaccountwrap");
	if(cloak.style.display!="block"){
		cloak.style.display="block";
	}else{
		cloak.style.display="none";
	}
}
function check(){
	if(document.getElementById("nID").value.length < 2){
		alert("2文字以下はだめです");
	}else if(document.getElementById("nPW").value!=document.getElementById("nPWPW").value){
		alert("パスワードが一致しません");
	}else{
		document.newaccount.submit();
		return true;
	}
}
function checktopic(){
	if(document.getElementById("nTOPIC").value.length < 1){
		return false;
	}else if(document.getElementById("nTOPIC").value.length > 40){
		alert("40文字まで入力可能です。");
	}else{
		document.newtopic.submit();
		return true;
	}
}
function checkcontent(){
	if(document.writeContent.content.value.length < 1){
		return false;
	}else if(document.getElementById("nTOPIC").value.length > 2000){
		alert("2000文字まで入力可能です。");
	}else{
		document.writeContent.submit();
		return true;
	}
}
function checkdeletetopic(){
	if(confirm("スレを削除します")){
		document.deletetopic.submit();
		return true;
	}
}
function checkdeletecontent(){
	if(confirm("レスを削除します")){
		document.deletecontent.submit();
		return true;
	}
}
window.onload = function(){
	var thid = window.location.href.split("#t");
	opentopic(thid[1]);
}