$(function(){
	var u_email=$("#u_email").val();
	$("#u_email").blur(function(){
		var reg=/^\w+@\w+\.[a-zA-Z]{2,3}$/;
		var reg1=/^\s*$/;
		if(reg1.test(u_email)){
			$("#u_email_span").html("<i>*</i>请输入您的邮箱帐号");
		}else	if(!reg.test(u_email)){
			$("#u_email_span").html("<i>*</i>您输入的邮箱有误");
		}else{
			$("#u_email_span").html("");
		}
	});
	
	var u_pwd=$("#u_pwd").val();
	$("#u_pwd").blur(function(){
		var reg=/^\w{6,15}$/;
		var reg1=/^\s*$/;
		var u_pwd=$("#u_pwd").val();
		if(reg1.test(u_pwd)){
			$("#u_pwd_span").html("<i>*</i>密码不能为空");
		}else if(!reg.test(u_pwd)){
			$("#u_pwd_span").html("<i>*</i>密码长度为6至15个字符");
		}else{
			$("#u_pwd_span").html('');
		}	
	});
	
	var rep_u_pwd=$("#rep_u_pwd").val();
	$("#rep_u_pwd").blur(function(){
		if(rep_u_pwd==u_pwd){
			$("#rep_u_pwd_span").html('');
		}else{
			$("#rep_u_pwd_span").html('<i>*</i>两次密码不一致');
		}
	});
	var l_code=$("#y").val();
	
	$.post("userInfo.do",{op:"userPwdBack",u_email:u_email,u_pwd:u_pwd,l_code:l_code},function(data){
		if(data==1){
			alert("密码修改成功");
			window.location.href='login.jsp';
		}else if(data==0){
			alert("密码修改失败");
		}else{
			$("#checkcode_span").html("<i>*</i>验证码错误");
			
		}
		
		
	})
		
});