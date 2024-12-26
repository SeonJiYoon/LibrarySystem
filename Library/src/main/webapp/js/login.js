window.onload=function() {
	document.querySelector("input[type=submit]").onclick=function(event) {
		event.preventDefault();
		
		var idIsc = document.getElementsByName("id")[0].title;
		if(idIsc == 'y') {
			alert("회원가입 진행합니다");
			document.getElementsByName("id")[0].disable;
			document.forms[0].submit();
		}
	}
	
	var inputTest = document.querySelectorAll("input[type=text], input[type=password]");
	for(let i=1; i<inputTest.length; i++) {
		inputTest[i].onclick = idConfirm;
	}
	
}

var idConfirm = function() {
	var idChecked = document.getElementsByName("id")[0];
	if(idChecked.title == 'n') {
		alert("아이디 중복 검사를 먼저 진행해 주세요.");
		idChecked.focus();
	}
}

function idCheck() {
	var id = document.getElementsByName("id")[0];
	if(id.value == '') {
		alert("아이디를 입력해 주세요.");
		id.focus();
		return;
	}
	window.open("./duplicateId.do?id="+id.value,"","width=300px, height=500px");
}

