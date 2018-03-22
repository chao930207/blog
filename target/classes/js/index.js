$(document).ready(function() {
	console.info("load");
})

function loginU() {

	var name = $("#name").val();
	var password = $("#password").val();

	$.ajax({
		url : 'user/login',
		type : 'POST',
		async : true,
		contentType : 'application/json',
		data : JSON.stringify({
			name : name,
			password : password
		}),
		timeout : 5000,
		dataType : 'json',
		beforeSend : function(xhr) {
			console.log(xhr)
			console.log('发送前')
		},
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			console.log(textStatus)
			console.log(jqXHR)
		},
		error : function(xhr, textStatus) {
			console.log('错误')
			console.log(xhr)
			console.log(textStatus)
		},
		complete : function() {
			console.log('结束')
		}
	})
}

function registerU() {
	var name = $("#nameR").val();

	$.ajax({
		url : 'user/register',
		type : 'POST',
		async : true,
		data : {
			"name" : name
		},
		timeout : 5000, //超时时间
		dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
		beforeSend : function(xhr) {
			console.log(xhr)
			console.log('发送前')
		},
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			console.log(textStatus)
			console.log(jqXHR)
		},
		error : function(xhr, textStatus) {
			console.log('错误')
			console.log(xhr)
			console.log(textStatus)
		},
		complete : function() {
			console.log('结束')
		}
	})
}

function queryU() {
	var name = $("#nameQ").val();

	$.ajax({
		url : 'user/userInfo',
		type : 'POST',
		async : true,
		data : {
			"name" : name
		},
		timeout : 5000, //超时时间
		dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
		beforeSend : function(xhr) {
			console.log(xhr)
			console.log('发送前')
		},
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			console.log(textStatus)
			console.log(jqXHR)	
		},
		error : function(xhr, textStatus) {
			console.log('错误')
			console.log(xhr)
			console.log(textStatus)
		},
		complete : function() {
			console.log('结束')
		}
	})
}