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
		alert("2�����ȉ��͂��߂ł�");
	}else if(document.getElementById("nPW").value!=document.getElementById("nPWPW").value){
		alert("�p�X���[�h����v���܂���");
	}else{
		document.newaccount.submit();
		return true;
	}
}
function checktopic(){
	if(document.getElementById("nTOPIC").value.length < 1){
		return false;
	}else if(document.getElementById("nTOPIC").value.length > 40){
		alert("40�����܂œ��͉\�ł��B");
	}else{
		document.newtopic.submit();
		return true;
	}
}
function checkcontent(){
	if(document.writeContent.content.value.length < 1){
		return false;
	}else{
		document.writeContent.submit();
		return true;
	}
}
function checkdeletetopic(){
	if(confirm("�X�����폜���܂�")){
		document.deletetopic.submit();
		return true;
	}
}
function checkdeletecontent(){
	if(confirm("���X���폜���܂�")){
		document.deletecontent.submit();
		return true;
	}
}