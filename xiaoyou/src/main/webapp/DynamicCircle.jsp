<%@page import="xiaoyou.utils.SessionAttributeNames"%>
<%@ page language="java" import="java.util.*,xiaoyou.po.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>动态圈</title>
    
	<link href="css/basic.css" rel="stylesheet" type="text/css"/>
	<link href="css/DynamicCircle.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/DynamicCircle.js"></script>
	<script type="text/javascript" src="js/basic.js"></script>
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="js/uploadPreview.js"></script>
	<%
		Object uid=session.getAttribute(SessionAttributeNames.u_id);
		Object u_name=session.getAttribute(SessionAttributeNames.u_name);
 	%>

	<script type="text/javascript">
		
	$(function(){ 
		
		selectAll();
	});
	//查看所有的说说和评论
	function selectAll(){
				var hideid=0;
				$.post("log_publish.action",function(data){
				//var	json =eval("("+data+")");
				//var talks = json.TalkCommentsList;
				//console.info(talks);
				var str;
				
				for(var i = 0; i < data.length; i++){<%--for(var index in items)--%>
				hideid=data[i].talk_id;
   				str='<div class="sky_center_column_display_div1">'
           		<%--+'<div class="div1_1">'--%>
                	+'<p><img src="images/MM6.jpg" class="small_imgCircle" /></p>'
               <%--+'</div>'--%> 
               //后添加
                +'<div class="sky_center_part">'
                    //图像名称
                    //昵称  日期 与发表文字 
                    +'<div class="div1_2">'
                       +'<a href="#" class="a_style">'+data[i].u_name+'</a>' 
                        +'<p class="p2">'+data[i].talk_time+'</p>'
                        +'<p>'+data[i].talk_content+'</p>'
					+'</div>'
                    +'<div class="div1_3">'
                            +'<img src="'+data[i].talk_image_path+'" width="150px" height="180px" / >'
                    +'</div>'
                    +'<div class="div1_4">'
                        +'<ul>'
                            +'<li><img src="images/comment.png"/></li>'
                            +'<li class="display_li"><a href="javascript:void(0)" class="comments_alert a_style " id="comment_display">评论</a></li>'
                            +'<li><img src="images/dispatcher.png"/></li>'
                            +'<li class="display_li"><a href="#" class="a_style">转发</a></li>'
                            +'<li><img src="images/dianzan.png"/></li>'
                            +'<li class="display_li"><a href="#" class="a_style">赞(<span>3</span>)</a></li>'
                            +'<li><img src="images/delete.png"/></li>'
                            +'<li class="display_li"><a href="#" class="a_style">删除</a></li>'
                        +'</ul>'
                    +'</div>'
                   //评论说说
                    +'<div class="sky_center_comment" id="sky_center_comment" style="display:none;">'
                    	+'<textarea class="textarea_comment" id="textarea_comment" rows="2" cols="70" maxlength="120" name="content"></textarea>'
                        +'<div class="sky_comment_div">'
                        	+'<ul>'
                            	+'<li><img src="images/biaoqing.png" class="img_1"/></li>'
                            	+'<li><span id="wordSpan">您还可以输入<strong>120</strong>字</span></li>'
                                +'<li><img src="images/recall.png" class="img_2 comments_fabu" id="recall" hideid="'+data[i].talk_id+'"/></li>'
                            +'</ul>'
                       +'</div>' 
                    +'</div>';
                    <%--评论说说1--%>
                    var str1=""; 
                    for(var j=0;j<data[i].comments.length;j++){
						//alert(i+"-----"+data[i].comments[j].c_text);
						if(data[i].comments[j].talking_id!=""){
							str1+=' <div class="sky_center_reply_1" style="display:block">'
                  			  +'<img src="'+data[i].comments[j].talk_image_path+'" class="img_style"/>'
				                  +'<div class="reply_div_1">'
				                  +'<a>'+data[i].comments[j].talking_id+'</a>:<span>'+data[i].comments[j].c_text+'</span>'
				                  +' <p>'+data[i].comments[j].c_time+'<a id="reply_a1"></a><a></a></p>'
				                  +'</div>'
                 		 		+'</div>'
							
						}
						
					}
                    str+=str1;
                    <%--回复--%>
                    <%--评论说说2--%>
                  +'</div>'
               +'</div>'
					$("#talk_show").prepend(str);
				}
					
				
				$(".comments_alert").bind("click", function(){
					   $(this).parents(".div1_4").next().css('display','block');
					});
				
				$(".comments_fabu").click(function(){
					var textarea=$(this).parents(".sky_comment_div").prev().val();
					var hideid=$(this).attr("hideid");//说说编号
					//此处 为获取说说人的编号
					var talking_id=10002;
					$(this).parents(".sky_center_comment").css('display','none');
					var obj=$(this);
					$.ajax({
					  type: "POST",
					  dataType:"JSON",
					  url: "comments_insert.action",
					  data:{
						  "c_text":textarea,
					  	   "talk_id":hideid,
					  	   "talking_id":talking_id
					  },
					  success:function(data){
						  /* selectAll(); */
						  alert(1);
						  window.location.href="DynamicCircle.jsp";
						   /* var obj=data[i].comments[j]; */
						  // alert(data);
					    	/* var str1=' <div class="sky_center_reply_1" style="display:block">'
			        			  +'<img src="'+data[i].comments[j].talk_image_path+'" class="img_style"/>'
				                  +'<div class="reply_div_1">'
				                  +'<a>'+data[i].comments[j].talking_id+'</a>:<span>'+data[i].comments[j].c_text+'</span>'
				                  +' <p>'+data[i].comments[j].c_time+'<a id="reply_a1"></a><a></a></p>'
				                  +'</div>'
			       		 		+'</div>';
						    	obj.parents("#sky_center_comment").after(str1);
						    	$("#textarea_comment").val(""); */
						  }
					});
				});
					
			});
		}
	

	</script>
  </head>


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
<!--内容-->
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
	<div id="sky_left">
    	<!--登录名称-->
    	<div class="sky_left_name">
        	<!--登录图像-->
            <div class="sky_left_name_div1">
        		<div class="sky_left_name_img">
                	<p ><img src="images/MM6.jpg" class="img_circle"/></p>
            	</div>
            </div>
            <!--名称的显示-->
       	   <div class="sky_left_name_div2">
           		<span  style="padding-left:25px;">呢称:<a href="#" class="a_style" style="color:grey"><%=u_name %></a></span>
           </div>
           <!--状态显示-->
           <div class="sky_left_name_div3">
           		<ul>
                	<li class="log">说说<strong>1</strong></li>
                    <li class="line">|</li>
                    <li class="friend">朋友<strong>113</strong></li>
                </ul>
           </div>
        </div>
        <!--说说排行榜-->
        <div class="sky_left_rank">
        	<div class="sky_left_classify">
            	<table width="270px" height="40px" cellspacing="0">
                	<tr>
                    	<td><a href="javascript:void(0)" class="a_style" id="change1">排行榜</a></td>
                        <td><a href="javascript:void(0)" class="a_style" id="change">说说达人</a></td>
                    </tr>
                </table>
            </div>
            <!--排行榜-->
            <div class="sky_left_rank_1" style="display:block" id="conten1">
                <ul>
                    
                    <li><img src="images/MM8.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">给我一首歌的时间</span></li>
                    <li><img src="images/MM9.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">豆浆油条</span></li>
                    <li><img src="images/MM10.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">你丫闭嘴</span></li>
                    <li><img src="images/MM11.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">随波逐流</span></li>
                    <li><img src="images/MM12.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">不潮不用花钱</span></li>
                    <li><img src="images/MM13.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">仰望星空</span></li>
                    <li><img src="images/MM14.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">sugar</span></li>
                    <li><img src="images/MM15.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">给我一</span></li>
                </ul>
            </div>
            <!--说说达人-->
             <div class="sky_left_rank_2" style="display:none" id="conten2">
                <ul>
                    <li><img src="images/MM10.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">你丫闭嘴</span></li>
                    <li><img src="images/MM11.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">随波逐流</span></li>
                    <li><img src="images/MM12.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">不潮不用花钱</span></li>
                    <li><img src="images/MM13.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">仰望星空</span></li>
                    <li><img src="images/MM14.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">sugar</span></li>
                    <li><img src="images/MM15.jpg" class="small_imgCircle_2"/>
                        <span class="span_1">给我一</span></li>
                </ul>
            </div>
        </div>

    </div>
    <!--发表动态-->
	<div id="sky_center">
    	<!--发表内容栏-->
    	<div class="sky_center_column">
        	<div class="sky_center_column_img">
            	<img src="images/weibo.png" />
            </div>
            <textarea id="textarea" rows="4" cols="82" maxlength="120" name="content"></textarea><!--文本区数字不能超过120-->
            <div class="sky_center_column_publish">
                    <ul>
                        <li><img src="images/biaoqing.png" /></li>
                        <li>表情</li>
                        <li><img src="images/zhaopian.png" /></li>
                        <li>照片</li> 
                        <input type="file" id="sendPhoto" style="height:30px" name="image"/>
                       	<span id="zishu">您还可以输入<strong>120</strong>字</span> 
                        <span ><img src="images/fabu.png" class="fabu" id="fabu" onclick="sendIamge()"/></span>
                    </ul>
            </div>
        </div>
        <script>
        	//发布说说
			$(function(){
				var userId = '<%=session.getAttribute(SessionAttributeNames.u_id)%>'; 
				var u_id = userId;
				//字数的设置
				var str4="";
				$("#textarea").bind("keyup",function(){
					var str3=120-($("#textarea").val().length);
					str4='您还可以输入<strong>'+str3+'</strong>字';
					$("#zishu").html(str4);
				});
				
				//图片预览 按钮绑定
				new uploadPreview({ UpBtn: "sendPhoto", DivShow: "photoDiv", ImgShow: "imageDiv" });
			});
			
			function sendIamge(){
				var u_id =10001;
				var talk_content=$("#textarea").val(); 
				$.ajaxFileUpload({
  				url:"log_add.action",
  				secureuri:false,//上传的时候是否使用安全协议https而不是使用http
  				type:"POST",
  				dataType:"JSON",
  				fileElementId:"sendPhoto",//上传的文件域的id
  				data:{u_id:u_id,talk_content:talk_content},//不能用$("#MyForm").serialize(),
  				success:function(data){
							$("#textarea").val("");
							$("#talk_show").html("");
							str4='您还可以输入<strong>120</strong>字';
							$("#zishu").html(str4);
							selectAll();
						
							document.getElementById("sky_center_new").style.display='none';
							
  				}
  			});
			}
			
        </script>
 
        <!--更新内容显示    有1条内容更新，点击查看-->
        <div class="sky_center_new" id="sky_center_new">
        	<div id="photoDiv">
        		<img id="imageDiv"/>
        	</div>
        </div>
        
        <!--动态展示:用户1-->
    	<div class="sky_center_column_display" id="talk_show">
        	
         </div>
   </div>
    <!--链接部分-->
	<div id="sky_right">
    	<div class="sky_right_rank">
        	<ul>
                <li><a href="#" class="a_style">首页</a></li>
                <li><a href="#" class="a_style">好友动态</a></li>
                <li><a href="#" class="a_style">我的说说</a></li>
                <li><a href="#" class="a_style">我的评论</a></li>
                <li><a href="#" class="a_style">与我相关</a></li>
                <li><a href="#" class="a_style">收藏</a></li>
                <li><a href="#" class="a_style">赞</a></li>
      		</ul>
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
            <li></li>
        </ul>
        <p class="footer_p1">我们的宗旨是：做最好的校园交友网站&nbsp;&nbsp;&nbsp;&nbsp;让校园交友更简单</p>
        <p class="footer_p2">@版权所有：YC-20班创新小组</p>
    </div>
</div>
</body>
</html>
