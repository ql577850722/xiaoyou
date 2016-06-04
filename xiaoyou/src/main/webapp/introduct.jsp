<%@page import="xiaoyou.biz.impl.InformationBizImpl"%>
<%@page import="xiaoyou.po.photoPO"%>
<%@ page import="xiaoyou.utils.SessionAttributeNames"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.println(basePath);
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>蜜柚网</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" />
<link href="css/introduct.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script src="js/introduct.js" type="text/javascript"></script>
<script type="text/javascript" src="js/showpic.js"></script>
<script type="text/javascript" src="js/basic.js"></script>
<script>
	/*点击菜单栏显示下面的div*/
	function show_bottomDiv(num) {
		console.info($(".content-right_sex_head li").length);
		for ( var i = 1; i <= $(".content-right_sex_head li").length; i++) {
			if (num == i) {
				$("#bottomDiv_" + num).css("display", "block");
			} else {
				$("#bottomDiv_" + i).css("display", "none");
			}
		}
	}
</script>
<%
	Object uid = session.getAttribute(SessionAttributeNames.u_id);
	Object u_name = session.getAttribute(SessionAttributeNames.u_name);
%>
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


<!-- body内容部分 -->
	<div id="content">
		<!--固定右边滚动条-->
	    <div class="tool_bar">
	    	<ul>
	        	<li><a target="_blank" href="#" title="在线咨询"></a></li>
	            <li><a target="_blank" href="#" title="扫一扫"></a></li>
	            <li><a target="_blank" href="#" title="意见反馈"></a></li>
	            <li><a href="#" title="回顶部"></a></li>
	        </ul>
	    </div>
		<div class="content_left">
			<div class="myimages">
				<img src="images/no_pic.jpg"
					id ="myImages" style="width:100px;height:100px;border-radius:100px" />
			</div>
			<div class="myinform">
				<div class="upload">
					<p><a href="javascript:show_bottomDiv(4)">上传照片</a></p>
				</div>
				<div class="compile">
					<p><a href="javascript:show_bottomDiv(1)">编辑资料</a></p>
				</div>
			</div>

			<div class="information">
				<ul>
					<li>小柚子</li>
					<li>普通会员</li>
					<li>10柚子</li>
				</ul>
			</div>

			<div class="function">
				<img src="images/camera.jpg" id="li1" style="float:left;height:35px;width:35px;border-radius:35px;margin-top:10px;margin-left:15px"/>
				<img src="images/camera.png" id="li1" style="float:left;height:35px;width:35px;border-radius:35px;margin-top:10px;margin-left:15px"/>
				<img src="images/camera_1.png" id="li1"style="float:left;height:35px;width:35px;border-radius:35px;margin-top:10px;margin-left:15px"/>
				<img src="images/gou.png" id="li1"style="float:left;height:35px;width:35px;border-radius:35px;margin-top:10px;margin-left:15px"/>
				<img src="images/love_1.jpg" id="li1"style="float:left;height:35px;width:35px;border-radius:35px;margin-top:10px;margin-left:15px"/>
				<img src="images/love_2.jpg" id="li1"style="float:left;height:35px;width:35px;border-radius:35px;margin-top:10px;margin-left:15px"/>
				<img src="images/login_1.png" id="li1"style="float:left;height:35px;width:35px;border-radius:35px;margin-top:10px;margin-left:15px"/>
				<img src="images/next.png" id="li1"style="float:left;height:35px;width:35px;border-radius:35px;margin-top:10px;margin-left:15px"/>
			</div>

			<div class="integral">
				<p>蜜柚:    10柚子</p>
			</div>
		</div>
		<div class="content_right">
			<div class="content_right_head">
				<div class="content_right_head_left">
					<li>个人中心</li>
				</div>
			</div>
			<div class="content_right_sex">
				<div class="content-right_sex_head">
					<ul>
						<li><a class="active" href="javascript:show_bottomDiv(1)"
							style="text-decoration:none"><img src="images/error_01.png" />基本资料</a>
						</li>
						<li><a class="active" href="javascript:show_bottomDiv(2)"
							style="text-decoration:none"><img src="images/error_01.png">我的头像</a>
						</li>
						<li><a class="active" href="javascript:show_bottomDiv(3)"
							style="text-decoration:none"><img src="images/error_01.png">交友宣言</a>
						</li>
						<li><a class="active" href="javascript:show_bottomDiv(4)"
							style="text-decoration:none"><img src="images/error_01.png">个人相册</a>
						</li>
					</ul>
				</div>
				<div class="content_right_content1" id="bottomDiv_1"
					style="display:block">
					<div class="explain">
						<img src="images/icon_02.gif">
						完整的基本资料不仅能让更多的人初步的了解您，更是搜索到您的重要保证，补充以下未填信息资料完整度增加<span
							class="orange">5%</span>哦！
					</div>
					<form method="post">
						<div class="content_right_content_left">
							<li style="margin-top:10px">基本资料</li>
							<span class="h2">为了保证资料真实有效，灰色字体信息不得随意修改</span>
						</div>
						<div class="content_right_contet_right"></div>
						<div class="content_right_content_left">
							<li>联系信息</li>
							<span class="h2">以下资料只有高级会员才能够看到</span>
						</div>
						<div class="content_right_contet_right1"></div>
						<div class="flash3">
							<input type="button"
								style="color:#F00;width:80px;height:30px;font-size:18px;background:#F0F"
								value="保存" onclick="save()" />
						</div>
					</form>
				</div>

				<div class="content_right_content2" id="bottomDiv_2"
					style="display:none">
					<div class="explain">
						<img src="images/icon_02.gif">
						有照片的会员征友成功率比没照片的高出8倍，上传照片资料完整度增加<span class="orange">20%</span>！
					</div>
					<div class="content_right_content_left">
						<li>上传头像</li>
						<span class="h2">请选择清晰美观的个人近照，作为您的形象照</span>
					</div>
					<div class="showPhoto">
						<div class="photo">
							<div class="myPhoto">
								<video id="video" width="250px" height="300px" autoplay></video>
							</div>
							<div class="flash1">
								<canvas id="canvas1" name="canvas1" width="130px" height="150px"></canvas>
								<img id="myImg" width="80px" height="120px" />

							</div>
							<!--
                        <div class="flash2">
                        	<canvas id="canvas2" width="80px" height="120px"></canvas>
                        </div>
                        -->
							<div class="flash3">
								<table>
									<tr>
										<td><input id="openVideo" type="button"
											style="color:#F00;width:60px;height:50px;margin-top:20px;font-size:18px;background:#F0F;float:left"
											value="开启" />
										</td>
										<td><input id="snapPhoto" type="button"
											style="color:#F00;width:60px;height:50px;margin-top:20px;font-size:18px;background:#F0F;float:left"
											value="保存" />
										</td>
										<td><input id="sentPortrait" type="button"
											style="color:#F00;width:100px;height:50px;margin-top:20px;font-size:18px;background:#F0F;float:left"
											value="上传头像" onclick="sentPortrait()" />
										</td>
									</tr>
									</tr>
								</table>
							</div>
						</div>
						<div class="flash4">
							<table>
								<tr colspan="3">
									<td><label class="sex">错误示范</label>
									</td>
								</tr>
								<tr>
									<td><span class="photoone"><img
											src="images/pic_08.jpg">非本人照片</span>
									</td>
									<td><span class="photoone"><img
											src="images/pic_09.jpg">照片模糊/></span>
									</td>
									<td><span class="photoone"><img
											src="images/pic_10.jpg">倾斜颠倒</span>
									</td>
								</tr>
								<tr>
									<td><span class="photoone"><img
											src="images/pic_11.jpg">非头部位置</span>
									</td>
									<td><span class="photoone"><img
											src="images/pic_12.jpg">裸露不文明</span>
									</td>
									<td><span class="photoone"><img
											src="images/pic_13.jpg">墨镜遮挡</span>
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td><label class="sex1">正确示范</label>
									</td>
								</tr>
								<tr>
									<td><span class="photoone1"><img
											src="images/pic_14.jpg">
									</span>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>

				<div class="content_right_content3" id="bottomDiv_3"
					style="display:none">
					<div class="explain">
						<img src="images/icon_02.gif">完善自我介绍，您的资料完整度增加10%！
					</div>
					<form method="post">
						<textarea id="u_text" length="1000" rows="10" cols="70" name=""
							placeholder="您可以通过自我介绍描述自己的生活、校园、以及对未来的憧憬，真诚的自我介绍最能打动对方，大部分人的交往就是从这里开始的"
							width="600px" height="200px" maxlength="300"></textarea>
						<p id="textLength" class="cbd">
							您还可以写<span id="saying"></span>
						</p>
					</form>
					<input type="button"
						style="color:#F00;width:100px;height:50px;margin-top:20px;font-size:18px;background:#FCC;text-align:center"
						value="保存" onclick="updateWrite()" />
				</div>

				<div class="content_right_content4" id="bottomDiv_4" style="display:none">
					<div class="explain">
						<img src="images/icon_02.gif">上传照片，您的资料完整度增加<span
							class="orange">10%</span>!
					</div>
					<div style="float:left;width:380px;">
						<table width="700px">
							<tr>
								<td>
									<fieldset id="pic_show" width:380px;>
										<legend>图片预览</legend>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
								<label style="font-size:16px;color:#F0F">我的相册</label>
								</td>
							</tr>
							<tr>
								<td>
									<li>上传照片:</li>
									<input type="file" id="myPhoto" name="pic" multiple="multiple"
										onchange="previewMultipleImage(this,'pic_show')" />
									</td>
								<td>
									<input type="button" id="sentPhoto" name="sentPhoto"
									width="100px" height="50px" value="确认上传" onclick="sentPhoto()" />
								</td>
							</tr>
						</table>
					</div>
					<div style="float:left;width:700px;">
									<%
								int u_id = 10001;
								InformationBizImpl biz = new InformationBizImpl();
								List<photoPO> list = biz.searchPhoto(u_id);
								if (list != null && list.size() > 0) {
									for (int i = 0; i < list.size(); i++) {
										photoPO po = list.get(i);

										String[] photoPath = po.getPhoto_path().split(",");
										System.out.println(photoPath.length);
							%>

							<%
								for (int j = 0; j < photoPath.length; j++) {
							%>
							<img src="<%=basePath%>/<%=photoPath[j]%>"
								style="width:200px;height:250px;border:1px solid red;">

							<%
								}
									}
								}
							%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--尾部-->
	<div id="footer">
		<p id="line"></p>
		<div class="footer">
			<ul id="footer_li">
				<li><a href="###">关于我们</a>
				</li>
				<li class="line">|</li>
				<li><a href="###">联系我们</a>
				</li>
				<li class="line">|</li>
				<li><a href="###">友情链接</a>
				</li>
				<li class="line">|</li>
				<li><a href="###">交友信息</a>
				</li>
				<li class="line">|</li>
				<li><a href="###">帮助中心</a>
				</li>
				<li class="line">|</li>
				<li><a href="###">安全中心</a>
				</li>

			</ul>
			<p class="footer_p1">我们的宗旨是：做最好的校园交友网站&nbsp;&nbsp;&nbsp;&nbsp;让校园交友更简单</p>
			<p class="footer_p2">@版权所有：YC-20班创新小组</p>
		</div>
	</div>
</body>
</html>
