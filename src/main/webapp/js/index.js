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
		},
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			var $show = $("#show-text")
			$show.empty()
			$show.html(data["message"])
		},
		error : function(xhr, textStatus) {
		},
		complete : function() {
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
		},
		success : function(data, textStatus, jqXHR) {
			console.log(data)
			if (data["exists"] == 1) {
				var $show = $("#show-text")
				$show.empty()
				$show.html("user has existsed")
			} else {
				var $show = $("#show-text")
				$show.empty()
				$show.html(data["message"])
			}
		},
		error : function(xhr, textStatus) {
		},
		complete : function() {
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
		},
		success : function(data, textStatus, jqXHR) {
			var rsData = data
			if (rsData["null"] == null) {
				var $show = $("#show-text")
				$show.empty()
				$show.html(rsData["user"])
			} else {
				var $show = $("#show-text")
				$show.empty()
				$show.html("not find")
			}
		},
		error : function(xhr, textStatus) {
		},
		complete : function() {
		}
	})
}