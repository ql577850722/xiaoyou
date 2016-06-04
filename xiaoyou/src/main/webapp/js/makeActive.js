
//界面加载完成后就一直执行
$(function(){
	//活动名称失焦
	$("#active_name").blur(function(){
		var reg=/^\S{1,10}$/;
		var active_name=$.trim($("#active_name").val());
		$("#active_name_msg").text("");
		console.info(reg.test(active_name));
		if(active_name==""){
			$("#active_name_msg").text("* 活动名称不能为空").css("color","red");
		}else if(!reg.test(active_name)){
			$("#active_name_msg").text("* 活动名称为1-10位字符").css("color","red");
		}else{
			$("#active_name_msg").html("<img src='images/ok_a.png'/>");
		}
	});
	
	//开始时间失焦
	$("#active_time").blur(function(){
		var active_time=$.trim($("#active_time").val());
		//alert(active_time);
		$("#active_time_msg").text("");
		if(active_time==""){
			$("#active_time_msg").html("<img src='images/ok_a.png'/>");
		}else{
			$("#active_time_msg").html("<img src='images/ok_a.png'/>");
		}
	}); 
	
	//活动地点
	$("#active_place").blur(function(){
		var active_place=$.trim($("#active_place").val());
		//alert(active_place);
		$("#active_place_msg").text("");
		if(active_place==""){
			$("#active_place_msg").text("* 活动地点不能为空").css("color","red");
		}else{
			$("#active_place_msg").html("<img src='images/ok_a.png'/>");
		}
	});
	
	//每人花销
	$("#active_expend").blur(function(){
		var reg=/^\d+(\.\d+)?$/;
		var active_expend=$.trim($("#active_expend").val());
		//alert(active_place);
		$("#active_expend_msg").text("");
		if(active_expend==""){
			$("#active_expend_msg").text("* 每人花销不能为空").css("color","red");
		}else if(!reg.test(active_expend)){
			$("#active_expend_msg").text("* 花销不能为负数").css("color","red");
		}{
			$("#active_expend_msg").html("<img src='images/ok_a.png'/>");
		}
	});
	
	//所在城市
//	$("#active_place").blur(function(){
//		var active_place=$.trim($("#active_place").val());
//		//alert(active_place);
//		$("#active_place_msg").text("");
//		if(active_place==""){
//			$("#active_place_msg").text("活动地点不能为空").css("color","red");
//		}else{
//			$("#active_place_msg").html("<img src='images/ok_a.png'/>");
//		}
//	});
	//需要人数
	$("#active_person").blur(function(){
		var active_person=$.trim($("#active_person").val());
		//alert(active_place);
		$("#active_person_msg").text("");
		if(active_person==""){
			$("#active_person_msg").text("* 需要人数不能为空").css("color","red");
		}else{
			$("#active_person_msg").html("<img src='images/ok_a.png'/>");
		}
	});
	
	//征集截止日期
	$("#active_date").blur(function(){
		var active_date=$.trim($("#active_date").val());
		//alert(active_place);
		$("#active_date_msg").text("");
		if(active_date==""){
			$("#active_date_msg").html("<img src='images/ok_a.png'/>");
		}else{
			$("#active_date_msg").html("<img src='images/ok_a.png'/>");
		}
	});
});




//点击申请活动后
function makeActive(){
	var active_name=$.trim($("#active_name").val());
	var active_time=$.trim($("#active_time").val());
	var active_place=$.trim($("#active_place").val());
	var active_type=$.trim($("#active_type").val());
	var active_expend=$.trim($("#active_expend").val());
//	var active_city=$.trim($("#active_city").val());
	var active_city=$.trim($("#province").find("option:selected").text()+$("#city").find("option:selected").text());
	var active_person=$.trim($("#active_person").val());
	var active_date=$.trim($("#active_date").val());
	var active_content=UE.getEditor('editor').getContent();

	if(active_name==""){
		alert("活动名称不能为空");
	}else if(active_time==""){
		alert("开始时间不能为空");
	}else if(active_place==""){
		alert("活动地点不能为空");
	}else if(active_type==""){
		alert("活动类别不能为空");
	}else if(active_expend==""){
		alert("花销不能为空");
	}else if(active_city==""){
		alert("城市不能为空");
	}else if(active_person==""){
		alert("请设定人数");
	}else if(active_date==""){
		alert("请选择截止日期");
	}else{
		$.ajaxFileUpload({
			url:"activeServlet?op=addActive",
			secureuri:false,
			fileElementId:["btn_file"],
			dataType:"json",
			data:{"aname":active_name,"astarttime":active_time,"aadd":active_place,"atype":active_type,"aexpend":active_expend,"acity":active_city,"aperson":active_person,"adate":active_date,"acontent":active_content},
			success:function(data,status){
				if(data!=isNaN){
					alert("活动申请成功，管理员将在3个工作日内审核您的活动，请耐心等待。^_^");
				}else{
					alert("上传失败");
				}
				window.close();
			}
		});
	}
	
}