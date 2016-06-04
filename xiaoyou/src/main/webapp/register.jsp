<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>会员注册</title>
<link rel="stylesheet" type="text/css" href="css/register.css" /> 
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<script type="text/javascript" src="js/jquery.cityselect.js"></script>
<script type="text/javascript" src="js/allunivlist.js"></script>
<script type="text/javascript">
//省、市、县
	$(function(){
		$("#city_div").citySelect({
				prov:"北京", 
				city:"东城区",
				dist:"",
				nodata:"none"
		});
	});
	function school(){	
		var json=allUnivList[0];
		var obj=json.provs;//取出所有省份和大学
		var obj1;//取出对应省份的大学
		var str='';
		$.each(obj,function(index,item){
			if(item.name==$(".prov").val()){
				obj1=obj[index]['univs'];
			}			
		});		
			$.each(obj1,function(index,item){
				var school=item['name'];
				str+="<option  value=\""+school+"\"  class=\"option\">"+school+"</option>";				
			});
			
			$("#xuexiao").html(str);
						
	}
	function repImg(obj){
	  $("#yan img").attr("src","CodeServlet.do?t="+Math.random() );//改变验证码图片  	
	}
</script>
</head>
  
<body>  
    <div id="register">
		<div>
        <h1>会员注册</h1>
        </div>
        <form method="post">
        	<div class="box box_1">
            	<div class="a">呢称</div>
                <div class="c">
                	<input type="text" maxlength="26" name="u_name" id="u_name" />
                </div>
                <div class="error r"><span id="uname_span" class="warning"><i>*</i>昵称由4位以上的字母、数字或下划线组成</span></div>
            </div>
            <div class="box box_2">
            	<div class="a">密码</div>
                <div class="c">
                	<input type="password" maxlength="26"  name="u_pwd"  id="u_pwd" />
                </div>
                <div class="error r"><span id="pwd_span" class="warning"><i>*</i>密码由6~15位的字母、数字或下划线组成</span></div>
            </div>
            <div class="box box_3">
            	<div class="a">确定密码</div>
                <div class="c">
                	<input type="password" name="repwd" maxlength="26"  id="repwd" />
                </div>
                <div class="error r"><span id="repwd_span" class="warning"><i>*</i>请再次输入密码</span></div>
            </div>
            <div class="box box_4">
            	<div class="a">性别</div>
                <div class="c" class="sex_div" id="sex_div">
                	<input type="radio" name="sex" id="sex" class="sex" value="男"  checked />男
                	<input type="radio" name="sex" id="sex" class="sex" value="女"/>女
                </div>
                <div class="error r"><span class="sex_span" class="warning"><i></i></span></div>
            </div>
            <div class="box box_5">
            	<div class="a">出生日期</div>
                <div class="c">                	 
                       		<select id="age_year">
                            	<option value="0" selected="selected"  disabled="disabled">-</option>
                                <option value="2016">2016</option>
                                <option value="2015">2015</option>
                                <option value="2014">2014</option>
                                <option value="2013">2013</option>
                                <option value="2012">2012</option>
                                <option value="2011">2011</option>  
                                <option value="2010">2010</option>                               
                                <option value="2009">2009</option>
                                <option value="2008">2008</option>
                                <option value="2007">2007</option>
                                <option value="2006">2006</option>
                                <option value="2005">2005</option>
                                <option value="2004">2004</option>
                            </select>
                            <select id="age_month">
                            	<option value="0" selected="selected"  disabled="disabled">-</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>  
                                <option value="7">7</option>                               
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                            <select id="age_day">
                            	<option value="0">-</option>
                            </select>
                     
                </div>
                <div class="error r"><span id="birthday" class="warning"><i>*</i>必填</span></div>
            </div>            
            <div class="box box_6">
            	<div class="a">所在地区</div>
                <div class="c" id="city_div">
                	 <select class="prov" onClick="school()"></select> 
					<select class="city" disabled="disabled"></select>
					<select class="dist" disabled="disabled"></select>
                </div>
                <div class="error r"><span id="" class="warning"><i></i></span></div>
            </div><div class="box box_7">
            	<div class="a">学校</div>
                <div class="c">
                	 <select class="xuexiao"  id="xuexiao">
                			 
					</select>
                </div>
                <div class="error r"><span id="xuexiao_span" class="warning"><i>*</i>必填</span></div>
            </div>
            <div class="box box_8">
            	<div class="a">学院</div>
                <div class="c">
                	<select class="xueyuan" id="academy">
                			<option value="0" selected="selected"  disabled="disabled">-</option>
                        	<option value="计算机与信息科学学院">计算机与信息科学学院</option>
                        	<option value="机械工程学院">机械工程学院</option>
                        	<option value="安全与环境工程学院">安全与环境工程学院</option>
                        	<option value="经济与管理学院">经济与管理学院</option>
                        	<option value="外国语学院">外国语学院</option>
                        	<option value="电气与信息工程学院">电气与信息工程学院</option>
                        	<option value="材料与化学工程学院">材料与化学工程学院</option>
                    </select>
                </div>
                <div class="error r"><span id="academy_span" class="warning"><i>*</i>必填</span></div>
            </div>            
            <div class="box box_10">
            	<div class="a">入学时间</div>
                <div class="c">
                	<select class="nianji"  style="text-algin:center" id="grade">
                        	<option value="0" selected="selected"  disabled="disabled">-</option>
                        	<option value="2016">2016</option>
                            <option value="2015">2015</option>
                            <option value="2014">2014</option>
                            <option value="2013">2013</option>
                            <option value="2012">2012</option>
                            <option value="2011">2011</option>
                            <option value="2010">2010</option>
                            <option value="2009">2009</option>
                        </select>
                </div>
                <div class="error r"><span id="nianji_span" class="warning"><i>*</i>必填</span></div>
            </div>
            <div class="box box_11">
            	<div class="a">邮箱</div>
                <div class="c">
                	<input type="text" name="email"  id="email" maxlength="26" />
                </div>
                <div class="error r"><span id="email_span" class="warning"><i>*</i>请输入常用邮箱作为帐号</span></div>
            </div>
            <div class="box box_12">
            	<div class="a">验证码</div>
                <div class="c" id="yan">
                	<input  id="y" type="text"  style="width:100px;height:30px;"/>	                         
	                <img  src="CodeServlet.do"   style="width:80px;height:25px;"  onclick="repImg(this)"/>
                </div>
                <div class="error r"><span id="email_check_span" class="warning"><i>*</i>请输入验证码</span></div>
            </div>
            <div class="box box_13">
            	<div class="a"></div>
                <div class="c">
                	<input type="button"  name="submit" value="立即注册" id="submit" class="submit" onClick="doReg()"/>
                </div>
                <div class="error r"></div>
            </div>
            <div id="back_login"><a href="login.jsp"><span>返回登录</span></a></div>
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
