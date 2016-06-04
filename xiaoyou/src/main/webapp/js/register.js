$(function (){	
	/*呢称*/
	$("#u_name").blur(function (){
		var reg=/^\w{4,10}$/;
		var reg1=/^\s*$/;		
		var u_name=$("#u_name").val();
		if(reg1.test(u_name)){
				$("#uname_span").html("<i>*</i>呢称不能为空");				
		}else if(!reg.test(u_name)){
				$("#uname_span").html("<i>*</i>请输入至少四位以上字符");
		}else{
				$.post("userInfo.do",{op:"userNameReg",u_name:u_name},function(data){				
					if(data==0){
						$("#uname_span").html('<i><img src="images/error_03.png"/></i>');
					}else{
						$("#uname_span").html("<i>*</i>该呢称已被占用");					
					}
				});		
		}	
	});	
	/*密码*/
	$("#u_pwd").blur(function(){
		var reg=/^\w{6,15}$/;
		var reg1=/^\s*$/;
		var u_pwd=$("#u_pwd").val();
		if(reg1.test(u_pwd)){
			$("#pwd_span").html("<i>*</i>密码不能为空");
		}else if(!reg.test(u_pwd)){
			$("#pwd_span").html("<i>*</i>密码长度为6至15个字符");
		}else{
			$("#pwd_span").html('<i><img src="images/error_03.png"/></i>');
		}	
	});	
	/*确认密码*/
	$("#repwd").blur(function(){
		var u_pwd=$("#u_pwd").val();
		var repwd=$("#repwd").val();
		if(u_pwd==repwd && u_pwd!=0){
			$("#repwd_span").html('<i><img src="images/error_03.png"/></i>');

		}else{
			$("#repwd_span").html("<i>*</i>密码错误");
		}
		
	});
	

	
	/*出生日期*/
	$("#age_month").blur(function(){
			var month=$("#age_month").val();
			if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
				$("#age_day").html('<option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option>'+
								'<option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option>'+
								'<option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option>'+
								'<option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option>'+
								'<option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option>'+
								'<option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option>'+
								'<option value="31">31</option>');
			}else if(month==4 || month==6 || month==9 || month==11){
				$("#age_day").html('<option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option>'+
						'<option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option>'+
						'<option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option>'+
						'<option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option>'+
						'<option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option>'+
						'<option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option>');
			}else if(month==2){
				var year=$("#age_year").val();
				if(year%400==0 || (year%4==0 && year%100!=0)){
					$("#age_day").html('<option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option>'+
							'<option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option>'+
							'<option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option>'+
							'<option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option>'+
							'<option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option>'+
							'<option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option>');				
				}else{
					$("#age_day").html('<option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option>'+
							'<option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option>'+
							'<option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option>'+
							'<option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option>'+
							'<option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option>'+
							'<option value="26">26</option><option value="27">27</option><option value="28">28</option>');				
				}				
			}			
	});
	$("#age_year").blur(function(){
		$("#birthday").html('');
	});
	
	$("#academy_span").blur(function(){
		$("#academy_span").html('<i><img src="images/error_03.png"/></i>');	
	});
	
	$("#xuexiao").blur(function(){
		$("#xuexiao_span").html('');	
	});
	$("#academy").blur(function(){
		$("#academy_span").html('');		
	})
	$(".nianji").blur(function(){
		$("#nianji_span").html('');	
	});
	
	
	
	/*邮箱验证*/
	$("#email").blur(function (){
		var reg=/^\w+@\w+\.[a-zA-Z]{2,3}$/;
		var u_email=$("#email").val();
		if(u_email!=""){
			if(!reg.test(u_email)){
					$("#email_span").html("<i>*</i>邮箱格式不对");				
			}else{
					$.post("userInfo.do",{op:"userEmailReg",u_email:u_email},function(data){				
						if(data==0){
							$("#email_span").html('<i><img src="images/error_03.png"/></i>');
						}else{
							$("#email_span").html("<i>*</i>该邮箱已被注册");					
						}
					});		
			}	
		}else{
			$("#email_span").html("<i>*</i>请输入邮箱");
		}
	});		
});

	/*注册*/
	function  doReg(){
		var u_name=$("#u_name").val();
		var u_email=$("#email").val();
		var u_pwd=$("#u_pwd").val();
		var u_sex=$('#sex_div input[name="sex"]:checked').val();
		var year=$("#age_year").val();
		var month=$("#age_month").val();
		var day=$("#age_day").val();	
		var u_birth=year+'-'+month+'-'+day;
		var u_province=$(".prov").val();
		var u_city=$(".city").val();
		var u_area=$(".dist").val();
		var u_school=$("#xuexiao").val();
		var u_academy=$("#academy").val();
		var u_grade=$("#grade").val();
		var l_code=$("#y").val();
		//alert(u_name+'--'+u_email+'--'+u_pwd+'--'+u_sex+'--'+u_birth+'--'+u_province+'--'+u_city+'--'+u_area+u_school+'--'+u_academy+'--'+u_grade);
		
			$.post("userInfo.do",{op:"userRegister",u_name:u_name,u_email:u_email,u_pwd:u_pwd,u_sex:u_sex,u_birth:u_birth,u_province:u_province,u_city:u_city,u_area:u_area,u_school:u_school,u_academy:u_academy,u_grade:u_grade,l_code:l_code},function(data){
				if(data==1){
					alert("恭喜您，注册成功");
					window.location.href='login.jsp';
				}else if(data==0){
					alert("您输入的信息有误");
				}else{
					$("#email_check_span").html("<i>*</i>验证码错误");
					
				}
			})
		
	}













