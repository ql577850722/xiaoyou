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
<title>蜜柚聊天</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" />
<link href="css/chat.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/basic.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script src="js/chat.js" type="text/javascript"></script>

<%
	Object uid=session.getAttribute(SessionAttributeNames.u_id);
	Object u_name=session.getAttribute(SessionAttributeNames.u_name);
 %>
 <script type="text/javascript">
	
</script>
</head>

<body>
<!--头部-->
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
                   <input type="text" value=""  id="s_name" placeholder="请输入您要查找的内容"/>
                    <input type="button" name="button" value="搜索" id="second_z_two" onclick="search()" /> 
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
                <li class="third_li"><a href="active.jsp">柚子活动</a></li>
                <li class="third_li"><a href="nearby.jsp">附近的人</a></li>
            </ul>
    	</div>
    </div>
</div>
<!--固定右边滚动条-->
    <div class="tool_bar">
    	<ul>
        	<li><a target="_blank" href="#" title="在线咨询"></a></li>
            <li><a target="_blank" href="#" title="扫一扫"></a></li>
            <li><a target="_blank" href="#" title="意见反馈"></a></li>
            <li><a href="#" title="回顶部"></a></li>
        </ul>
    </div>
<!-- 聊天部分 -->
<div id="chat">
	
	<div class="chat-left">
    	<div class="cleft-top">
        <table>
        	<tr>
            	<td><img src="images/basic1<%=session.getAttribute(SessionAttributeNames.u_id) %>.png" style="width:80px;height:80px;border-radius:80px;"/></td>
                <td><p>呢称:</p></td>
               	<td><p><%=u_name %></p></td>
            </tr>
            
                <td style="border-bottom:1px solid #000"> <input id="conv_search" type="text" placeholder="搜索" value="" name="search" style="width:150px;height:20px;text-align:center;"/></td>
                <td style="border-bottom:1px solid #000"><input type="button" name="search" id="search"/ style="width:50px;height:30px;" value="搜索"></td>
           </table>  
        <div class="cleft-content"> 
        	<form method="post">
		        <table style="width:300px" id="friendInfo">
		        </table>   
		    </form>       
          </div>      
        </div>
    </div>
    <div class="chat-right">
    	<div class="cright-top">
        	<table>
            	<tr>
                	<td><p>聊聊看喽</p></td>
                </tr>
                <tr>
                	<td>&nbsp;</td>
                </tr>
                <tr>
                	<td>&nbsp;</td>
                </tr>
                <tr>
                	<td><textarea id="" length="1000" rows="20" cols="70" name="" placeholder="用心交流，方得始终" width="600px" height="200px" margin-top="30px"></textarea></td>
                </tr>
                <tr>
                	<td><input type="text" style="width:500px;height:60px" name="chat" id="chat"><input type="button" name="send" id="send" value="发送" style="width:80px;height:50px;font-size:16px"></td>
                </tr>
            </table>
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

