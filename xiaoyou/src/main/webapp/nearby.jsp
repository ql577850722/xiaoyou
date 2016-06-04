<%@page import="xiaoyou.utils.SessionAttributeNames"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>附近的人</title>
<link href="css/basic.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<style type="text/css">
ul li{
	list-style:none;
}
body, html{
	background-color:#FFF;
	width: 100%;
	height: 100%;
	margin:0;
	font-family:"微软雅黑";
	font-size:14px;
}
#body{
	width:100%;
	height:900px;
}
#allmap{
	margin-top:30px;
	margin-right:80px;
	height:400px;
	width:70%;
	overflow: hidden;
	font-family:"微软雅黑";
	float:right;
	border:1px solid black;
}
#r-result{
	margin-top:30px;
	margin-left:70px;
	width:220px;
	height:400px;
	float:left;
	background-color:#FCC;
}
#personal .stitle{
	width:100%;
	height:30px;
}
#personal .photo{ 
	position:relative;
	top:20px;
	left:57px;
	/*border:1px solid #f60; width:100px; height:100px; margin:0 auto;
	-webkit-border-radius:50px;
	-moz-border-radius:50px;
	-o-border-radius:50px;
	border-radius:50px;*/
	float:left;
	width:100px; height:100px; border-radius:50%; overflow:hidden;
}
#personal .img{
	width:100px;
	height:100px;	
}
#personal .input{
	margin-top:40px;
	width:100%;
	height:100px;
	float:left;
}
#personal ul li{
	padding-left:20px;
	margin-bottom:40px;
}
#people{
	margin-left:68px;
	margin-top:30px;
	width:1200px;
	height:430px;
	float:left;
	background-color:#F9C;
}
#people .p_nav{
	width:100%;
	height:50px;
	background-color:#FC9;
}
#people .p_nav_li{
	line-height:50px;
	width:100px;
	height:50px;
	text-align:center;
	list-style:none;
	float:left;	
}
#people a{
	text-decoration:none;
	font-size:16px;
	font-weight:bold;
	color:#999;
}
#people a:hover{
	text-decoration:line;
	font-size:17px;
	font-weight:bold;
	color:#FFF;
}
#people .person{
	margin-left:16px;
	margin-top:25px;
	width:220px;
	height:320px;
	background-color:#FFF;
	border:#CCC;
	float:left;
}
#people img{
	width:200px;
	height:200px;
}
#people .img{
	margin-top:10px;
	position:relative;width:200px; height:200px;
}

#people .img:hover{
	cursor:pointer;
}
#people .img span{
	display:none; 
	text-decoration:none;
}
#people .img:hover span{
	display:block;
	position:absolute;
	bottom:0; 
	left:0;
	color:#FFF;
	width:200px; 
    z-index:10;
	height:36px; 
	line-height:36px; 
	background:#000;
	filter:alpha(opacity=60);
	-moz-opacity:0.5;
	opacity: 0.5;
}

#people ul li{
	padding-left:10px;
}
#people .name{
	font-weight:bold;
	color:#0FF;
}
#people .grade{
	font-size:12px;
	color:#666;
}
#people .dec{
	font-size:12px;
	color:#666;
}
#people .span{
	font-size:14px;
	font-weight:bold;
	color:#333;
}
#people .p_photo{
	width:20px;
	height:20px;
	border-radius:50%; 
	overflow:hidden;
	position:relative;
	top:8px;
	display:block; 
	margin:0 auto;
}
#people .p_photo:hover{
	cursor:pointer;
}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=0cCjBxdsl1k5DEAVgrvQgpF8"></script>
<script type="text/javascript" src="js/basic.js"></script>
<script>
function change_love(){
	var p1="images/love_1.jpg";
	var p2="images/love_2.jpg";
	alert(document.getElementsByClassName("p_photo")[0].src);
	//alert(document.getElementsByClassName("p_photo")[0].src);
	for(var i=0;i>0;i++){
		if(i%2==0){
			document.getElementsByClassName("p_photo")[0].src="images/love_2.jpg";	
		}else{
			document.getElementsByClassName("p_photo")[0].src="images/love_1.jpg";	
		}
	}
	
}
</script>
<%
	Object uid=session.getAttribute(SessionAttributeNames.u_id);
	Object u_name=session.getAttribute(SessionAttributeNames.u_name);
 %>
</head>

<body>
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
        <div id="allmap"></div>
        <div id="r-result">
        	<div id="personal">
            	<div class="stitle"><ul><li>我的资料</li></ul></div>
            	<div class="photo">
                	<img src="images/27.jpg" class="img"/><br/>  
                </div>  
                <div class="input">
                	<!-- <ul>
                    	<li>您的位置：衡阳市</li>
                        <li><p>如需获取更准确定位，您可在下方文本框内进行手动搜索。</p></li>
                        <li>请输入：<input type="text" id="suggestId" size="20" value="百度" style="width:150px;" /></li>
                	</ul>     --> 
                </div> 
            </div> 
        </div>
        <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
        <div id="people">
        	<!--<div class="p_nav">
            	<ul>
                	<li class="p_nav_li"><a href="">同城的人</a></li>
                    <li class="p_nav_li"><a href="">附近的人</a></li>
                </ul>
            </div>
        	  <div class="person">
            	<div  class="img">
                	<img src="images/1.jpg"/><br/>
                	<span><img src="images/love_1.jpg" class="p_photo" onClick="change_love()" /></span>
                </div>
                <ul>
                	<li class="name">小柚子</li>
                    <li class="grade">2012级 湖南工学院</li><br/>
                    <li class="dec"><span class="span">交友宣言：</span>此人很懒，还没有写呢。</li>
                </ul>
            </div>
            <div class="person">
            	<div  class="img">
                	<img src="images/2.jpg"/><br/>
                	<span><img src="images/love_1.jpg" class="p_photo" /></span>
                </div>
                <ul>
                	<li class="name">Anny</li>
                    <li class="grade">2012级 衡阳师范学院</li><br/>
                    <li class="dec"><span class="span">交友宣言：</span>此人很懒，还没有写呢。</li>
                </ul>
            </div>
            <div class="person">
            	<div  class="img">
                	<img src="images/3.jpg"/><br/>
                	<span><img src="images/love_1.jpg" class="p_photo" /></span>
                </div>
                <ul>
                	<li class="name">You</li>
                    <li class="grade">2012级 衡阳师范学院</li><br/>
                    <li class="dec"><span class="span">交友宣言：</span>此人很懒，还没有写呢。</li>
                </ul>
            </div>
            <div class="person">
            	<div  class="img">
                	<img src="images/4.jpg"/><br/>
                	<span><img src="images/love_1.jpg" class="p_photo" /></span>
                </div>
                <ul>
                	<li class="name">蓝胖子</li>
                    <li class="grade">2015级 南华大学</li><br/>
                    <li class="dec"><span class="span">交友宣言：</span>此人很懒，还没有写呢。</li>
                </ul>
            </div>
            <div class="person">
            	<div  class="img">
                	<img src="images/5.jpg"/><br/>
                	<span><img src="images/love_1.jpg" class="p_photo" /></span>
                </div>
                <ul>
                	<li class="name">小强</li>
                    <li class="grade">2014级 湖南科技经贸职业学院</li><br/>
                    <li class="dec"><span class="span">交友宣言：</span>此人很懒，还没有写呢。</li>
                </ul>
            </div>-->
            
        </div>
    </div>
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
<script type="text/javascript">
//获取点击的用户id
function getUname(u_id){
//	alert(u_id);
	$.post("userInfo.do",{op:"getUid",u_id:u_id},function(data){
		
		if(data.num!=0){
			window.open("userHomepage.jsp");
		}
	});
	
}

	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(116.331398,39.897445);
	map.centerAndZoom(point,12);

	var geolocation = new BMap.Geolocation();
	var gc = new BMap.Geocoder();
	geolocation.getCurrentPosition(function(r){
		if(this.getStatus() == BMAP_STATUS_SUCCESS){
			
			//通过Geolocation类的getStatus()可以判断是否成功定位。  
            var pt = r.point; 
            var str="";   
            gc.getLocation(pt, function(rs){    
                var addComp = rs.addressComponents;    
                alert(addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber);    
            	var ncity=addComp.city;
            	
            	$.post("activeServlet",{op:"getCityName",ncity:ncity},function(data){
		
					if(data.num!=0){
						$.post("activeServlet",{op:"cityFind",ncity:ncity},function(data){
							var str1="";
							$.each(data.cityPerson,function(index,item){
								str1+="<div class='p_nav'><ul><li class='p_nav_li'><a href=''>同城的人</a></li></ul></div>";
								str1+="<div class='person'><div  class='img'><img src='"+item.U_PHOTO+"' onclick='javascript:getUname("+item.U_ID+")'/><br/>";
					    		str1+="<span><img src='images/love_1.jpg' class='p_photo' /></span></div>";
					    		str1+="<ul><li class='name'>"+item.U_NAME+"</li><li class='grade'>"+item.U_GRADE+item.U_SCHOOL+"</li><br/>";
					    		str1+="<li class='dec'><span class='span'>交友宣言：</span>"+item.U_TEXT+"。</li></ul></div>";
							});
							$("#people").html(str1);
				
						},"json");
					}
				});
            	
            	str="<ul><li>您的位置："+addComp.province + addComp.city+"</li><li><p>如需获取更准确定位，您可在下方文本框内进行手动搜索。</p></li>";
            	str+="<li>请输入：<input type='text' id='suggestId' size='20' value='百度' style='width:150px;' /></li></ul></ul>";
                
           		$(".input").html(str);
            });  
				
			
			var mk = new BMap.Marker(r.point);
			map.addOverlay(mk);
			map.panTo(r.point);
			//alert('您的位置：'+r.point.lng+','+r.point.lat);
		}
		else {
			alert('failed'+this.getStatus());
		}        
	},{enableHighAccuracy: true});
	
	
	
	
	//var mPoint=new BMap.Point(r.point.lng,r.point.lat);
	//var circle = new BMap.Circle(mPoint,1000,{fillColor:"blue", strokeWeight: 1 ,fillOpacity: 0.3, strokeOpacity: 0.3});
	//关于状态码
	//BMAP_STATUS_SUCCESS	检索成功。对应数值“0”。
	//BMAP_STATUS_CITY_LIST	城市列表。对应数值“1”。
	//BMAP_STATUS_UNKNOWN_LOCATION	位置结果未知。对应数值“2”。
	//BMAP_STATUS_UNKNOWN_ROUTE	导航结果未知。对应数值“3”。
	//BMAP_STATUS_INVALID_KEY	非法密钥。对应数值“4”。
	//BMAP_STATUS_INVALID_REQUEST	非法请求。对应数值“5”。
	//BMAP_STATUS_PERMISSION_DENIED	没有权限。对应数值“6”。(自 1.1 新增)
	//BMAP_STATUS_SERVICE_UNAVAILABLE	服务不可用。对应数值“7”。(自 1.1 新增)
	//BMAP_STATUS_TIMEOUT	超时。对应数值“8”。(自 1.1 新增)
	

	// 百度地图API功能
	function G(id) {
		return document.getElementById(id);
	}

	var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "suggestId"
		,"location" : map
	});

	ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
	var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		
		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		G("searchResultPanel").innerHTML = str;
	});

	var myValue;
	ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	var _value = e.item.value;
		myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		
		G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
		
		setPlace();
		
	});

	function setPlace(){
		map.clearOverlays();    //清除地图上所有覆盖物
		function myFun(){
			var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
			map.centerAndZoom(pp, 18);
			map.addOverlay(new BMap.Marker(pp));    //添加标注
		}
		var local = new BMap.LocalSearch(map, { //智能搜索
		  onSearchComplete: myFun
		});
		local.search(myValue);
		
	}
</script>
