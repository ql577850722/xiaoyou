<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>小柚资料</title>
 	<link href="css/basic.css" rel="stylesheet" type="text/css" />
 	<link href="css/userHomepage.css" rel="stylesheet" type="text/css" />
 	<script src="js/jquery-1.11.1.min.js"></script>
 	<script src="js/userHomepage.js"></script>
 	
 	
 	
 	<script>
	$(function(){
		for(var i=0;i<$(".morePhoto ul li").length;i++){
			$(".morePhoto ul li").eq(i).click(function(){
				var large_src=$(this).find("img").attr("src");
				$(".photoInfo img").attr("src",large_src);
			})
		}	
		/*相册点击左右箭头*/
		/*$(".page_next i").click(function(){
			$("#scrollPic").animate({left:"-150px"},300);
			
		});*/
		
		//相册点击左右箭头
		var img_total=$("#scrollPic ul li").length;//图片总数
		$("#page_pre").click(function(){
			var scrollRight=0;//向右滚动的距离
			if($("#scrollPic").scrollLeft()>(5*66)){
				scrollRight=$("#mem_div1").scrollLeft()-(4*60);
			}else{
				scrollRight=0;
			}
			$("#scrollPic").animate({scrollLeft:scrollRight},1000);
		});
		$("#page_next").click(function(){
			var scrollLeft=0;//向左滚动的距离
			if($("#scrollPic").scrollLeft()<((img_total-parseInt(img_total%5))*60)){
				scrollLeft=$("#scrollPic").scrollLeft()+(4*60);
			}else{
				scrollLeft=img_total*60;
			}
			$("#scrollPic").animate({scrollLeft:scrollLeft},1000);
		});
		
	});
	
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
                    <li class="first_left_a"><span style="color:#fff">欢迎：</span><a href="###">小小柚</a></li>
                    <li class="first_left_a"><span style="color:#fff">ID：</span><a href="###">1001</a></li>
                    <li class="first_left_a"><a href="###">退出</a></li>
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
                <li class="third_li"><a href="love.jsp">秀恩爱</a></li>
                <li class="third_li"><a href="active.jsp">柚子活动</a></li>
                <li class="third_li"><a href="nearby.jsp">附近的人</a></li>
            </ul>
    	</div>
    </div>
</div>
<!-- 主页 -->
	<article>
   		<div class="info_head">
        	<!--相册-->
            <div class="leftInfo">
           <!-- <div class="product-img-box">
                 <a href='images/zoom1.jpg' class = 'cloud-zoom' id='zoom1'
            rel=""> <img style="max-height:400px; width:400px;" src="images/zoom1.jpg" alt='' title="" /> </a> 
                </div>-->
                <div class="photoInfo">
                	<a href='images/search/3_11.jpg' class = 'cloud-zoom' id='zoom1' >
                    	<img src="images/search/3_11.jpg" style="max-height:325px; width:290px; display:block" />
                    </a>
                </div>
                <div class="morePhoto">
                        <div id="scrollPic">
                            <ul>
                                 <li><img src="images/search/3_11.jpg"/></li>
                                 <li><img src="images/search/3_12.jpg"/></li>
                                 <li><img src="images/search/3_13.jpg"/></li>
                                 <li><img src="images/search/3_14.jpg"/></li>
                                 <li><img src="images/search/3_15.jpg"/></li>
                                 <li><img src="images/search/3_11.jpg"/></li>
                                 <li><img src="images/search/3_12.jpg"/></li>
                                 <li><img src="images/search/3_13.jpg"/></li>
                            </ul>
                    </div>
                    <!--左边箭头-->
                    <div class="arrow page_pre" id="page_pre">
                        <em></em><i></i>
                    </div>
                    <!--右边箭头-->
                    <div class="arrow page_next" id="page_next">
                        <em></em><i></i>
                    </div>
                </div>
            </div>
            
            <!--右边详细信息-->
            <div class="rightInfo">
            	<p class="xiao_name">
                	<div class="xiao_icons">
                        <a target="_blank" title="已上传头像" href="#"></a>
                        <a target="_blank" title="已完善资料" href="#"></a>
                        <a target="_blank" title="已验证邮箱" href="#"></a>
                        <a target="_blank" title="已验证手机" href="#"></a>
                        <a target="_blank" title="未通过身份验证" href="#"></a>
                        <a target="_blank" title="小柚会员" href="#"></a>
                        <a target="_blank" title="会员特权" href="#"></a>
                        <a target="_blank" title="诚信认证" href="#"></a>
                    </div>
                </p>
                <p class="xiao_info"></p>
                
                <div class="midlle_info">
                <!--  	<table>
                    	<tr>
                        	<td>年龄:<span>20岁</span></td>
                            <td>年级:<span>2012级</span></td>
                            <td>学校:<span>湖南工学院</span></td>
                        </tr>
                        <tr>
                        	<td>身高:<span>165cm</span></td>
                            <td>体重:<span>50kg</span></td>
                            <td>学院:<span>软件工程</span></td>
                        </tr>
                        <tr>
                        	<td>星座:<span>水瓶座</span></td>
                            <td>血型:<span>O型</span></td>
                            <td>地区:<span>湖南衡阳</span></td>
                        </tr>
                    </table>-->
                </div>
                
                <div class="signature">
                    <!--  <em>交友宣言：</em>
                    <span>别人再好，也是别人，我虽不完美，不可复制，努力把自己做到更好，一生足矣</span>-->
                </div>
                <div class="send_mess">
                	<a target="_blank" href="#">在线聊天</a>
                    <a target="_blank" onclick="makeFriend()">加好友</a>
                    <a target="_blank" href="#">打招呼</a>
                </div>
            </div>
        </div>
      </article>  
    <!-- InstanceEndEditable -->
    
    <!--固定右边滚动条-->
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
            
        </ul>
        <p class="footer_p1">我们的宗旨是：做最好的校园交友网站&nbsp;&nbsp;&nbsp;&nbsp;让校园交友更简单</p>
        <p class="footer_p2">@版权所有：YC-20班创新小组</p>
    </div>
</div>
  </body>
</html>
