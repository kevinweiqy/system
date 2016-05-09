function login(){
		var formData = $("#loginForm").serialize();
		$.ajax({
				url : "login/login.action",
				type : "post",
				data : formData,
				dataType : "json",
				success : function(data) {
					if (data.flag == 0) {
						$.messager.alert('错误', '账号密码错误');
					}
				}
			});
}