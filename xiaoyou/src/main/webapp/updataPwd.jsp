<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="css/updataPwd.css" />
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/updataPwd.js"></script>
</head>
<script>
function repImg(obj){
	  $("#yan img").attr("src","CodeServlet.do?t="+Math.random() );//改变验证码图片  	
	}
</script>

<body>
	<div id="register">
		<div id="div_h1">
        <h1>找回密码</h1>
        </div>
        <form>
        	<div class="box box_1">
            	<div class="a">帐号</div>
                <div class="c">
                	 <input type="text"  name="u_email" id="u_email"/>
                </div>
                <div class="error r"><span id="u_email_span" class="warning"><i>*</i>输入您的邮箱帐号</span></div>
            </div>
            <div class="box box_2">
            	<div class="a">验证码</div>
                <div class="c" id="yan">
                	 <input  id="y" type="text"  style="width:100px;height:30px;"/>	                         
	                <img  src="CodeServlet.do"   style="width:80px;height:25px;"  onclick="repImg(this)"/>
                </div>
                <div class="error r"><span id="checkcode_span" class="warning"><i>*</i>输入验证码</span></div>
            </div>
            <div class="box box_3">
            	<div class="a">设置密码</div>
                <div class="c">
                	 <input type="password"  name="u_pwd" id="u_pwd"/>
                </div>
                <div class="error r"><span id="u_pwd_span" class="warning"><i>*</i>输入新密码(6-15位)</span></div>
            </div>
            <div class="box box_4">
            	<div class="a">确认密码</div>
                <div class="c">
                	 <input type="password"  name="rep_u_pwd"  id="rep_u_pwd"/>
                </div>
                <div class="error r"><span id="rep_u_pwd_span" class="warning"><i>*</i>请再次输入密码</span></div>
            </div>
            <div class="box box_5">
            	<div class="a"></div>
                <div class="c">
                	 <input type="button" value="确   认" name="submit" id="submit" />
                </div>
                <div class="error r"><span id="submit_span" class="warning"></span></div>                
            </div>
            <div id="back_login"><a href="login.jsp"><span>返回登陆</span></a></div>
        </form>      
	</div>
	  <!--尾部-->
    <div id="footer">       
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

</body>
</html>

  
 
