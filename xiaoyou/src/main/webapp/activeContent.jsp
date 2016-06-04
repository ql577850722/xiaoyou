<%@page import="xiaoyou.utils.SessionAttributeNames"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>活动详情</title>
<link href="css/basic.css" rel="stylesheet" type="text/css"/> 
<link href="css/activeContent.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script  src="js/activeContent.js" type="text/javascript"></script>
<script type="text/javascript" src="js/basic.js"></script>
<%
	Object uid=session.getAttribute(SessionAttributeNames.u_id);
	Object u_name=session.getAttribute(SessionAttributeNames.u_name);
 %>
 <script type="text/javascript">
	
</script>

</head>

<body>
<!--头部-->
<div  id="header">
	<div class="header-frist">
        <div id="first">
            <div id="first_left">       		
                <ul id="first_left_a" class="first_ul">            	
                    <li class="first_left_a"><a href="###" class="first_left_aa">收藏本站</a></li>    
                    <%if(!"".equals(uid)&&null!=uid){ %>        
                     	<li class="first_left_a" id="login_li"><span style="color:#fff">欢迎：</span><a href=""  id="login" style="color:#F69;"><%=u_name %></a></li>  
                    <%} else{%>               
                       	<li class="first_left_a"  id="login_li"><span style="color:#fff">[</span><a href="login.jsp"  id="login">登录</a><span style="color:#fff">]</span></li>                       
                     <%} %>
                    <li class="first_left_a"><span style="color:#fff">[</span><a href="register.jsp">注册新会员</a><span style="color:#fff">]</span></li>
                    <li class="first_left_a"><span style="color:#fff">[</span><a onclick="exit()">退出</a><span style="color:#fff">]</span></li>
                </ul>
            </div>
            <div id="first_right">
                <ul id="first_right_b" class="first_ul">                
                    <li class="first_right_b"><a href="###">消息</a></li>
                    <li class="first_right_b"><a href="###">好友动态</a></li>
                    <li class="first_right_b"><a href="###">我的动态</a></li>
                    <li class="first_right_b"><a href="###">个人信息</a></li>
               </ul>
            </div>
        </div>
     </div>
     <div class="header-second">
        <div id="second">
            <div id="second_left"><a href="###"><img src="images/1.png" width="150" height="120" /></a></div>
            <div id="second_z">
                <div class="second_zz">
                    <input type="text" value="请输入您要查找的内容"  id="second_z_one"/>
                    <input type="button" name="button" value="搜索" id="second_z_two"  />  
                </div>          
            </div>
            <div id="second_right"><img src="images/5.png" width="150" height="120" /></div>
        </div>
     </div>
     <div class="header-third">
        <div id="third">
           <ul id="third_li">
                <li class="third_li"><a href="index.jsp">首页</a></li>
                <li class="third_li"><a href="introduct.jsp">个人中心</a></li>
                <li class="third_li"><a href="chat.jsp">聊天</a></li>
                <li class="third_li"><a href="DynamicCircle.jsp">动态圈</a></li>
                <li class="third_li"><a href="love.jsp">秀恩爱</a></li>
                <li class="third_li"><a href="active.jsp">柚子活动</a></li>
                <li class="third_li"><a href="nearby.jsp">附近的人</a></li>
            </ul>
    	</div>
    </div>
</div>
<!--body部分-->
<div id="body">
	<div id="title">
    	<div id="t_title">
        	<!-- <center>
        		<li>化装舞会</li>
            </center>-->
        </div>
    </div>
    <div id="content_img">
    	<img src="images/biankuang.png" />
        <div id="content">
    		<!--  <ul>
            	<li>活动时间：</li>
                <li>所在城市：</li>
                <li>活动地点：</li>
                <li>每人花销：</li>
                <li>需要人数：</li>
                <li>活动详情：</li>
                <p>正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文</p>
                <li class="li_last">活动报名截止日期：</li>
                <li class="li_last">活动发起人：<a href="#">小柚子</a></li>
            </ul>-->
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
</body>
</html>

