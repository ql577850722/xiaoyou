<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<link href="css/index.css" rel="stylesheet" type="text/css"/>
<link href="css/basic.css" rel="stylesheet" type="text/css"/> 
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/default.css">
<link rel="stylesheet" href="css/screen.css" type="text/css">


<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script src="http://libs.useso.com/js/jquery/1.9.1/jquery.min.js"></script>
<script src="http://libs.useso.com/js/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
<script src="photo/data.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script  src="js/index.js" type="text/javascript"></script>
<script type="text/javascript" src="js/basic.js"></script>


 <script type="text/javascript">
</script>
<style>
.grid {
	width: 1000px; height: 300px; margin: 100px auto 50px auto;
	perspective: 500px; /*For 3d*/
}
.grid img {width: 83.3px; height: 80px; display: block; float: left;}

.animate {
	text-transform: uppercase;
	background: rgb(0, 100, 0); color: white;
	padding: 10px 20px; border-radius: 5px;
	cursor: pointer;margin:10px auto;width:100px;text-align:center;
}
.animate:hover {background: rgb(0, 75, 0);}
</style>
</head>

<body>
<!--头部-->
<div  id="header">
	<div class="header-frist">
        <div id="first">
            <div id="first_left">       		
                <ul id="first_left_a" class="first_ul">            	
                    <li class="first_left_a"><a href="###" class="first_left_aa">收藏本站</a></li> 
                    <c:choose>
	                    <c:when test="${sessionScope.userInfo.u_name eq null }">
	                    	<li class="first_left_a"  id="login_li" style="color:#fff">[<a href="login.jsp"  id="login">登录</a>]</li>
	                    </c:when>
	                    <c:otherwise>
	                    	<li class="first_left_a"  id="login_li"><span style="color:#fff">您好：</span><a href=""  id="login" style="color:#F69;">${sessionScope.userInfo.u_name}</a></li>
	                    </c:otherwise>
	                 </c:choose>
                    <li class="first_left_a"><span style="color:#fff">[</span><a href="register.jsp">注册新会员</a><span style="color:#fff">]</span></li>
                    <li class="first_left_a"><span style="color:#fff">[</span><a onclick="exit()" href="userInfo_exit.action">退出</a><span style="color:#fff">]</span></li>
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
<!--body内容-->
<div id="body">
	<!--固定右边滚动条-->
    <div class="tool_bar">
    	<ul>
        	<li><a target="_blank" href="#" title="在线咨询"></a></li>
            <li><a target="_blank" href="#" title="扫一扫"></a></li>
            <li><a target="_blank" href="#" title="意见反馈"></a></li>
            <li><a href="#" title="回顶部"></a></li>
        </ul>
    </div>
	<!--body第一部分，图片轮播-->
	<div id="nav">
		<img src="images/index_nav1.jpg" id="bg_img"/>
       <div id="nav_dots">
       		<ul id="nav_dots_li">
            	<li onMouseOver="show(1)" onMouseOut="start()"></li>
               	<li onMouseOver="show(2)" onMouseOut="start()"></li>  
                <li onMouseOver="show(3)" onMouseOut="start()"></li>     
                <li onMouseOver="show(4)" onMouseOut="start()"></li>
            </ul>
       </div>
	</div>

    <div id="bno">
    	<div id="bno_left" class="bno_p">	
        	<p>没有勾心斗角，没有尔虞尔诈</p>
            <p>流着眼泪播种，带着笑容收割</p>
        </div>
        <div id="bon_z" class="bno_p">
        	<p>嗨，你是我要找的哪个人吗？</p>
            <p>小柚，用心打造最好的校园交友网站</p>
        </div>
        <div id="bno_right" class="bno_p">
        	<p>茫茫人海中，记住时刻关注你的那个她</p>
            <p>赶紧加入我们吧...</p>
        </div>
    </div>
    <div id="read">
        <div id="mv_div">
            <video  controls  src="mv1.mp4"  poster="URL" id="mv">
            </video>
        </div>
    </div>
    <div id="active">
    	<h1>总有新奇在身边</h1>
        <p>进入小柚的世界，各种各样的活动等着你</p>
        <ul id="active_ul">
        	<li><img src="images/MM2.jpg" /></li>
            <li><img src="images/GG4.jpg" /></li>
            <li><img src="images/MM9.jpg" /></li>
            <li><img src="images/MM10.jpg" /></li>	
        </ul>
    </div>
    <div id="person">
    	<div id="main">
			<div class="demo">
				<div class="grid"></div>
				<div class="animate">换一批</div>
			</div>
		</div>
<script>
//Creating 50 thumbnails inside .grid
//the images are stored on the server serially. So we can use a loop to generate the HTML.
	var images = "", count = 48;
	for(var i = 1; i <= count; i++)
		images += '<img src="http://thecodeplayer.com/u/uifaces/'+i+'.jpg" />';
		
	//appending the images to .grid
	$(".grid").append(images);
	
	var d = 0; //delay
	var ry, tz, s; //transform params
	
	//animation time
	$(".animate").on("click", function(){
		//fading out the thumbnails with style
		$("img").each(function(){
			d = Math.random()*1000; //1ms to 1000ms delay
			$(this).delay(d).animate({opacity: 0}, {
				step: function(n){
					s = 1-n; //scale - will animate from 0 to 1
					$(this).css("transform", "scale("+s+")");
				}, 
				duration: 1000, 
			})
		}).promise().done(function(){
			//after *promising* and *doing* the fadeout animation we will bring the images back
			storm();
		})
	})
	//bringing back the images with style
	function storm()
	{
		$("img").each(function(){
			d = Math.random()*1000;
			$(this).delay(d).animate({opacity: 1}, {
				step: function(n){
					//rotating the images on the Y axis from 360deg to 0deg
					ry = (1-n)*360;
					//translating the images from 1000px to 0px
					tz = (1-n)*1000;
					//applying the transformation
					$(this).css("transform", "rotateY("+ry+"deg) translateZ("+tz+"px)");
				}, 
				duration: 3000, 
				//some easing fun. Comes from the jquery easing plugin.
				easing: 'easeOutQuint', 
			})
		})
	}
</script>
    </div>
    <div id="active_c">
    	<div class="htmleaf-container" onselectstart="return false;">
		
		<div class="wrap" id="wrap">
		    <div class="photo photo_front" id="photo_{{index}}" onclick="turn(this)">
		      <div class="photo-wrap">
		        <div class="side side-front">
		          <p class="image"><img src="photo/{{img}}"></p>
		          <p class="caption">{{caption}}</p>
		        </div>
		        <div class="side side-back">
		          <p class="desc">{{desc}}</p>
		        </div>
		      </div>
		    </div>
			 </div>
		
		</div>
    </div>
</div>

<div class="tool_bar">
    	<ul>
        	<li><a target="_blank" href="#" title="在线咨询"></a></li>
            <li><a target="_blank" href="#" title="扫一扫"></a></li>
            <li><a target="_blank" href="#" title="意见反馈"></a></li>
            <li><a href="#" title="回顶部"></a></li>
        </ul>
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

