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
<title>柚子活动</title>
<link href="css/basic.css" rel="stylesheet" type="text/css"/>
<link href="css/active.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="css/hzw-city-picker.css">
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/pagination.css" />


<script type="text/javascript" src="js/lib/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/city-data.js"></script>
<script type="text/javascript" src="js/hzw-city-picker.min.js"></script>
<script type="text/javascript" src="js/active.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>


<script type="text/javascript">

</script>
<script>
function move(){
	document.getElementById('make').style.top=(document.documentElement.scrollTop+document.body.scrollTop+530)+'px';	
	document.getElementById('make').style.left=(document.documentElement.scrollLeft+document.body.scrollLeft+1149)+'px';
//	console.info(document.body.clientWidth);
}

window.onscroll=function(){
	move();//窗口滚动事件,当页面滚动时调用move	
}
</script>

<%
	Object uid=session.getAttribute(SessionAttributeNames.u_id);
	Object u_name=session.getAttribute(SessionAttributeNames.u_name);
 %>
 <script type="text/javascript">
	
</script>

</head>

<body>
<a href="makeActive.jsp" target="_blank"><div id="make"></div></a>
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
	<div id="b_nav">
    	<div class="title">
    		<h2>柚子活动</h2>
        </div>
    </div>
    <div id="a_nav">
    	&nbsp;筛选城市：<input type="text" id="cityChoice" style=" width:80px; height:30px;margin: 15px 0 0 30px; background-color:#999; border:1px solid #FFF; text-align:center; cursor:pointer;" />
        <a id="back" href="javascript:backAll()" style="margin-left:800px;">返回查看所有活动</a>
        <script>
		///////////////城市菜单/////////////////
		var cityPicker = new HzwCityPicker({
			data: data,
			target: 'cityChoice',
			valType: 'k-v',
			hideCityInput: {
				name: 'city',
				id: 'city'
			},
			hideProvinceInput: {
				name: 'province',
				id: 'province'
			},
			callback: function(){
				//alert('OK');
				var str=$('#city').val();
				var strs=new Array();
				strs=str.split("-");
				var cityChoice=strs[1];
				//alert(cityChoice);
			//	alert(current_page);
				
				$.post("activeServlet",{op:"getCityChoice",cityChoice:cityChoice},function(data){
					var str="";
					$.each(data.cityActivity,function(index,item){
						//alert(item.ACID);
						str+='<a href="javascript:getAcid('+item.ACID+')"><div class="content"><div class="grid"><figure class="effect-julia">';
			    		str+='<img src="'+item.APHOTO+'" alt="img22"/><figcaption><h2>'+item.ANAME+'</h2><div><p>活动：'+item.ANAME+'</p><br/>';
			    		str+='<p>地点：'+item.AADD+'</p><br/><p>时间：'+item.ASTARTTIME+'</p></div></figcaption></figure></div></div></a>';
					});
					$("#active").html(str);
					$.post("activeServlet",{op:"getPages1"},function(data){
					var allPages=Math.ceil(data/9);
		//			alert(data);
					var str1="";
					str1+="<div class='pages'><div id='Pagination'></div><div class='searchPage'><span class='page-sum'>共<strong class='allPage'>"+allPages+"</strong>页</span>";
					str1+="<span class='page-go'>跳转<input type='text'>页</span>";
					str1+="<a href='javascript:goPage();' class='page-btn'>GO</a></div></div> <div style='text-align:center;margin:0; font:normal 14px/24px 'MicroSoft YaHei';'>";
					$("#page").html(str1);
					
					$(document).ready(function() {
						$("#Pagination").pagination(allPages);
					});
			
				});
				},"json");
				
				
			}
		});
		
		cityPicker.init();
		
		
		</script>
    </div>
    <div id="active">
    	<!--  <div class="content">
        	<div class="grid">
                <figure class="effect-julia" onClick="javascript:add(0)">
                    <img src="images/dance.jpg" alt="img22"/>
                    <figcaption>
                        <h2>假面舞会</h2>
                        <div>
                            <p>活动：假面舞会</p><br/>
                            <p>地点：湖南工学院</p><br/>
                            <p>时间：2015-11-30</p>
                        </div>
                    </figcaption>			
                </figure>
			</div>
        </div>
        <div class="content">
        	<div class="grid">
                <figure class="effect-julia">
                    <img src="images/dance.jpg" alt="img22"/>
                    <figcaption>
                        <h2>假面舞会</h2>
                        <div>
                            <p>活动：假面舞会</p><br/>
                            <p>地点：湖南工学院</p><br/>
                            <p>时间：2015-11-30</p>
                        </div>
                    </figcaption>			
                </figure>
			</div>
        </div>
        <div class="content">
        	<div class="grid">
                <figure class="effect-julia">
                    <img src="images/dance.jpg" alt="img22"/>
                    <figcaption>
                        <h2>假面舞会</h2>
                        <div>
                            <p id="active_name">活动：假面舞会</p><br/>
                            <p id="active_place">地点：湖南工学院</p><br/>
                            <p id="active_time">时间：2015-11-30</p>
                        </div>
                    </figcaption>			
                </figure>
			</div>
        </div>
        <div class="content">
        	<div class="grid">
                <figure class="effect-julia">
                    <img src="images/dance.jpg" alt="img22"/>
                    <figcaption>
                        <h2>假面舞会</h2>
                        <div>
                            <p>活动：假面舞会</p><br/>
                            <p>地点：湖南工学院</p><br/>
                            <p>时间：2015-11-30</p>
                        </div>
                    </figcaption>			
                </figure>
			</div>
        </div>-->
    </div>
    <div id="page">
    
    
    <!-- 分页脚本 -->
    <!-- <div class="pages">
        <div id="Pagination"></div>
        <div class="searchPage">
          <span class="page-sum">共<strong class="allPage">15</strong>页</span>
          <span class="page-go">跳转<input type="text">页</span>
          <a href="javascript:;" class="page-btn">GO</a>
        </div>
    </div>
    <div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
    -->
    
    
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


