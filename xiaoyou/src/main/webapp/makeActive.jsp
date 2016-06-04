<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>发起活动申请</title>
<link rel="stylesheet" type="text/css" href="css/text.css" />
<link href="css/makeActive.css" rel="stylesheet" type="text/css"/>

<script src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/makeActive.js"></script>
<script type="text/javascript" src="js/city.js"></script>
<script type="text/javascript" charset="utf-8" src="js/showpic.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<!--编辑器-->
<script type="text/javascript" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" src="ueditor/lang/zh-cn/zh-cn.js"></script>
<!-- 日历插件  -->
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

<script>
//实例化编辑器
var ue=UE.getEditor('editor');

</script>
</head>

<body>
<div id="body">
	
	<h4>发布活动</h4>
    <div id="left">
        <h5>活动名称：</h5><input id="active_name" type="text" name="a_name" />&nbsp;<lable id="active_name_msg" style="color:red;height:10px;">*</lable><br/>
		<h5>开始时间：</h5><input id="active_time" type="text" name="a_date" onClick="WdatePicker()" />&nbsp;<lable id="active_time_msg" style="color:red;">*</lable><br/>        <h5>活动地点：</h5><input id="active_place" type="text" name="a_place" />&nbsp;<lable id="active_place_msg"  style="color:red;">*</lable><br/>
        <h5>活动类别：</h5><select id="active_type" name="a_type" style="width:100px;">
        					<option>其他</option>
				            <option>户外</option>
				            <option>旅游</option>
				            <option>舞会</option>
				            <option>聚餐</option>
        				</select><br/>
        <h5>每人花销：</h5><input id="active_expend" type="text" name="a_money" />元&nbsp;<lable id="active_expend_msg"  style="color:red;">*</lable><br/>
    </div>
    <div id="dashed"></div>
    <div id="right">
    	 <!-- <h5>所在城市：</h5><input id="active_city" type="text" name="a_city" /><br/>-->
    	 <div class="intbox">
            <h5>所在城市：</h5><select id="province" class="selmar" name="province" tips="省份" rule="required" status="success">
                <option>--请选择省--</option>
            </select>
            <select id="city" class="selmar" name="city" tips="城市" rule="required" status="success">
                <option>--请选择市、区--</option>
            </select>
        </div>
            <label id="city_msg" class="labelbox"></label>
        <h5>需要人数：</h5><input id="active_person" type="text" name="a_peple" />&nbsp;<lable id="active_person_msg"  style="color:red;">*</lable><br/>
        <h5>征集截止日期：</h5></br><input id="active_date" type="text" name="a_lastdate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'active_time\')}'})" style="margin-left:20px;"/>&nbsp;<lable id="active_date_msg"  style="color:red;">*</lable><br/>
        <h5>选择图片:</h5><input id="btn_file" type="file" accept="image/png,image/jpeg" name="image" onchange="previewMultipleImage(this,'pic',200,200)" style="height:30px;">
    </div>
    <div id="pic"></div>
	<div id="footer">
    	<div>
        	<script id="editor" type="text/plain" style="width:800px;height:170px;"></script>
 		 </div>
 		     <input type="button" value="申请发起活动"  style="margin-top:35px;margin-left:0px;" onClick="javascript:makeActive()"/>
 		 
    </div>
    <div id="cue">
    	<img src="images/cue1.png" />
    </div>
</div>

</body>
</html>


