$(function() {
	$
			.post(
					"information.do",
					{
						op : "perfectUserinfo"
					},
					function(data) {
						var str = "";
						var str1 = ""
						$
								.each(
										data.userInfo,
										function(index, item) {
											str += '<li class="h1" >昵称：<input id="name" type="text" name="name" value="'
													+ item.u_name
													+ '" id="name" style="height:25px" disabled><span style="display:none">*至少两位以上</span></li>';
											str += '<li class="h1">年级:<input id="grade" type="text" maxlength="30" style="height:25px" value="'
													+ item.u_grade
													+ '"disabled></li>';
											str += '<li class="h1">性别:<label id="gendar">&nbsp;'
													+ item.u_sex
													+ '</label></li>';
											str += '<li class="h1">学校:<input id="school" type="text" maxlength="30" style="height:25px" value="'
													+ item.u_school
													+ '"disabled></li>';
											str += '<li class="h1">生日:<input id="birth" type="text" maxlength="30" style="height:25px" value="'
													+ item.u_birth
													+ '"disabled></li>';
											str += '<li class="h1">学院:<select id="collage" style="width:150px;height:25px" disabled><option>'
													+ item.u_academy
													+ '</option></select></li>';
											str += '<li class="h1">年龄:<label id="age">21</label></li>';
											str += ' <li class="h1">身高:<input type="text" id="height" style="width:150px;height:25px" value="'
													+ item.u_stature
													+ '"/></li>';
											str += '<li class="h1">星座:<label id="constellation ">金牛座</label></li>';
											str += '<li class="h1">体重:<input id="weight" style="width:150px;height:25px"value="'
													+ item.u_weight
													+ '"/></li>';
											str += '<li class="h1">地区:<select style="width:60px;height:25px"disabled><option>'
													+ item.u_province
													+ '</option></select>';
											str += '<select style="width:60px;height:25px"disabled><option>'
													+ item.u_city
													+ '</option></select>';
											str += '<select style="width:60px;height:25px"disabled><option>'
													+ item.u_area
													+ '</option></select></li>';
											str += '<li class="h1">血型:<input id="blood" type="text" maxlength="30" style="height:25px" value="'
													+ item.u_blood + '"></li> ';

											str1 += '<li class="h1">邮箱:<input id="email" type="text" name="youxiang" style="height:25px" value="'
													+ item.u_email
													+ '"disabled></li>';
											str1 += '<li class="h1">手机号:<input id="phone" type="text" name="phone" style="height:25px" value="'
													+ item.u_tel + '"></li>';
											str1 += ' <li class="h1">QQ号:<input id="qq" type="text" name="qq" style="height:25px" value="'
													+ item.u_qq + '"></li>';
											str1 += ' <li class="h1">微信号:<input id="weChat" type="text" name="weixin" style="height:25px" value="'
													+ item.u_wechat + '"></li>';

										});

						$(".content_right_contet_right").html(str);
						$(".content_right_contet_right1").html(str1);
					}, "json");
});

// 保存个人信息
function save() {
	var u_stature = $("#height").val();
	var u_weight = $("#weight").val();
	var u_blood = $("#blood").val();
	var u_tel = $("#phone").val();
	var u_qq = $("#qq").val();
	var u_wechat = $("#weChat").val();
	// $.ajaxFileUpload({
	// url:"information.do?op=updateUserinfo",
	// secureuri:false,
	// fileElementID:["btn_file"],
	// //contentType : "application/json",
	// //dataType:"json",
	// data:{u_stature:u_stature,u_weight:u_weight,u_blood:u_blood,u_tel:u_tel,u_qq:u_qq,u_wechat:u_wechat},
	// success:function(data,status){
	// if(data>0){
	// alert("保存成功");
	// }
	// }
	// });
	//	
	$.post("information.do", {
		op : "updateUserinfo",
		u_stature : u_stature,
		u_weight : u_weight,
		u_blood : u_blood,
		u_tel : u_tel,
		u_qq : u_qq,
		u_wechat : u_wechat
	}, function(data) {
		if (data > 0) {
			alert("保存成功");
		}
	});
}

$(function() {
	// var openVideo=$("#openVideo");//获得一个打开视频按钮的对象;
	// var snapPhoto=$("#snapPhoto");//获得一个拍照按钮的对象
	// var canvas=document.getElementById("canvas");
	// var context=canvas.getContext("2d");
	var context = document.getElementById("canvas1").getContext("2d");
	// var context1 = document.getElementById("canvas2").getContext("2d");
	// getContext()方法创建一个在画布上绘图的环境，它里面的参数指定了你要绘制的图形的类型
	var video = document.getElementById("video");

	$("#openVideo").click(
			function() {
				// 这个函数主要是用来实现通过getUserMedia()这个方法来调用摄像头；
				// 解决浏览器的兼容问题；Chrome21,Opera 18和Firefox
				// 17支持该方法，目前IE还不支持，上面代码中的msGetUserMedia只是为了确保将来的兼容
				navigator.getMedia = (navigator.getMedia
						|| navigator.webkitGetuserMedia || // 谷歌21,opera18
						navigator.mozGetUserMedia || // 火狐17
				navigator.msGetUserMedia);
				navigator.getMedia(
				// 1.约束对象，用来指定你要访问的媒体类型
				{
					video : true,
					audio : false,
				},
				// 2.成功回调函数
				function(localMediaStream) {
					// 绑定本地媒体流到video标签用户输出
					video.src = window.URL.createObjectURL(localMediaStream);
					// 注：在这里我们并没有使用video元素的src属性值，而是为video元素指定了一个引用媒体文件url地址
					video.onloademetadata = function(e) {
						// 对视频的处理方法
					};
				},
				// 失败回调函数
				function(err) {
					console.log("The following error occured:" + err);
					// 1.PERMISSION_DENIED 用户解决了浏览器请求媒体的权限
					// 2.NOT_SUPPORTED_ERROR constraint中指定的媒体类型不被支持
					// 3.MANDATORY_UNSATISFIED_ERROR 指定的媒体类型未收到媒体流
				});

			});
	// 添加一个点击事件，来实现抓图；
	$("#snapPhoto").click(function() {
		// 将视频中的内容捕捉到画布上
		// 在画布上放置图像的x坐标位置。
		context.drawImage(video, 0, 0, 130, 150);// 控制照片的大小
		// context1.drawImage(video, 0, 0, 80, 120);
		getData();
	});

});

function getData() {

	var pic = document.getElementById("canvas1").toDataURL("image/png");
	// console.info(pic);
	return pic;
}
// 上传图片
function sentPhoto() {
	$.ajaxFileUpload({
		url : "information.do?op=sentPhoto",
		fileElementId : "myPhoto",
		secureuri : false,
		dataType : "json",
		success : function(data, status) {
			if (data == 1) {// 上传成功
				alert("上传成功");
			} else {
				alert("上传失败");
			}
		}
	});
}

// 上传头像
function sentPortrait() {
	var pic = getData().toString();
//	$.ajax({
//		type : "POST",
//		url : "information.do",
//		data : {
//			op : pic
//		},
//		dataType : "json"
//	})
	 $.ajaxFileUpload({
		type : "POST",
		url : "information.do?op=sentPortrait",
		// fileElementId:"picFile",
		data : {
			"pic" : pic.substring(22)
		},
		dataType : "JSON",
		success : function(data) {	
			$("#myImages").attr("src",data);	
			alert("上传成功");
		}
	});

}
// 修改交友宣言
function updateWrite() {
	var u_text = $("#u_text").val();
	$.post("information.do", {
		op : "updateWrite",
		u_text : u_text
	}, function(data) {
		if (data > 0) {
			alert("保存成功");
		} else {
			alert("保存失败");
		}
	});
}

$(function() {
	
//	$("#u_text").onchange( function() { var str1 = "<span class='orange' id='orange'>"
//		+ (300 - ($("#u_text").val().length)) + "字</span>";
//	 $("#saying").html(str); 
//	 });
	 

	$("#u_text").bind(
			"keyup",
			function() {
				var str = 300 - ($("#u_text").val().length);
					var str1 = "<span class='orange' id='orange'>"
						+ str + "字</span>";
					$("#saying").html(str1);			
			});
});