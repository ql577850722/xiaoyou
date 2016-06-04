<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<!--登录页面-->
<title>登录</title>
<link href="css/login.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>

</head>
<script type="text/javascript">
//登录验证
function doLogin(){
	var pwd=$("#p").val();
	var email=$("#u").val();
	var l_code=$("#y").val();
	$.post("userInfo.do",{op:"userLogin",u_email:email,u_pwd:pwd,l_code:l_code},function(data){
	//alert(data.num);
	var num=parseInt($.trim(data.num));
		if(num==1){
			location.href="index.jsp";
		}else if(num==2){	
				$("#error_p").html("帐号与密码不匹配");
				$("#error_p").css("color","red");
				$("#error_p").css("font-size","14px");
		}else	if(email==null||email==""){
				$("#error_p").html("请输入帐号");
				$("#error_p").css("color","red");
				$("#error_p").css("font-size","14px");						
		}else{
				$("#error_p").html("验证码错误");
				$("#error_p").css("color","red");
				$("#error_p").css("font-size","14px");
		}
		setTimeout('$("#error_p").html("");',1000);	
	},'json');
	
}

function repImg(obj){
	  $("#yan img").attr("src","CodeServlet.do?t="+Math.random() );//改变验证码图片  	
}


</script>
<body>
<!--登录页面背景-->
<div id="bg_img" class="bg_img" style="width:1366px;height:625px;">
	<img src="images/bg_2.jpg"   style="height:625px;width:1364px;" />
</div>
<div id="bg" class="main">
	<div class="head">
    	<div class="head_log">
            <div class="log">
             	<img src="images/login_1.png" />
                <div class="form">
                 	 <h2>会员登录</h2>                   
                    <form action="userInfo_login.action" method="post" accept-charset="UTF-8">
                    	<div class="error"><p id="error_p" style="color:red;">${sessionScope.loginMsg}</p></div>
                    	<div id="userName" class="user">
                        	<label style="width:20px;"><span style="font-size:16px;">帐&nbsp;&nbsp;号</span></label>&nbsp;&nbsp;
                            <input  id="u" class="users_input" type="text" name="u_email"  placeholder="请输入注册邮箱" style="width:200px;height:30px;"/>
                        </div>
                        <div id="userPwd" class="user">
                        	<label style="width:20px;"><span style="font-size:16px">密&nbsp;&nbsp;码</span></label>&nbsp;&nbsp;
                            <input  id="p" class="users_input" type="password" name="u_pwd"  placeholder="请输入密码" style="width:200px;height:30px;"/>
                        </div>
                        <div id="yan" class="user">  
                        	<label style="width:20px;margin-left:-20px;"><span style="font-size:16px">验证码</span></label> &nbsp;&nbsp;                     	
                            <input  id="y" type="text" placeholder="请输入验证码" style="width:80px;height:30px;"/>	                         
	                         <img     style="width:80px;height:25px;"  />
	                         <label style="width:40px;height:60px;"><span   style="font-size:14px;color:blue">换一张</span></label>	                         	                           	                         
                        </div>                        
                        <div class="login_button">
                        	<input type="submit"  value="登录"  />
                        </div>
                        <div class="forget_pwd">
                        	<div class="forget_pwd_a"><a href="updataPwd.jsp">忘记密码</a> | <a href="register.jsp">注册会员</a></div>
                        </div>
                    </form>                  
          	  	</div>
            </div>           
        </div>
    </div>
	<!--尾部-->
    <div id="footer">
        <p id="line"></p>
        <div class="footer">
            <ul id="footer_li">
                <li><a href="###">关于我们</a></li>
                <li class="line">|</li>
                <li><a href="###">联系我们</a></li>
                 <li class="line">|</li>  
                <li><a href="###">友情链接</a></li>
                 <li class="line">|</li>
                <li><a href="###">交友信息</a></li>
                 <li class="line">|</li>
                <li><a href="###">帮助中心</a></li>
                 <li class="line">|</li>
                <li><a href="###">安全中心</a></li>
                <li><a href="###"></a></li>
            </ul>
            <p class="footer_p1">我们的宗旨是：做最好的校园交友网站&nbsp;&nbsp;&nbsp;&nbsp;让校园交友更简单</p>
            <p class="footer_p2">@版权所有：YC-20班创新小组</p>
        </div>
	</div>
    <!-- 尾部 -->
</div>


</body>
</html>



</body>
</html>

