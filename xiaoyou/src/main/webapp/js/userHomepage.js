$(function(){
	$.post("userInfo.do",{op:"uidFindall"},function(data){
		var str="";
		var name="";
		var id="";
		var talk="";
		$.each(data.uid,function(index,item){
			var birth=item.U_BIRTH;
			var strs=new Array();
			strs=birth.split("-");
			var myDate = new Date();
			var date=myDate.getFullYear();
			var age=date-strs[0];
			str='<table><tr><td>年龄:<span>'+age+'岁</span></td><td>年级:<span>'+item.U_GRADE+'级</span></td>';
			str+='<td>学校:<span>'+item.U_SCHOOL+'</span></td></tr><tr><td>身高:<span>'+item.U_STATURE+'</span></td>';
			str+='<td>体重:<span>'+item.U_WEIGHT+'</span></td><td>学院:<span>'+item.U_ACADEMY+'</span></td></tr>';
			str+='<td>血型:<span>'+item.U_BLOOD+'</span></td><td>地区:<span>'+item.U_PROVINCE+item.U_CITY+item.U_AREA+'</span></td></tr></table>';
		
			name='<a href="#">'+item.U_NAME+'</a><span>在线</span>';
		
			id='<span>ID:'+item.U_ID+'</span>';
		
			talk='<em>交友宣言：</em><span>'+item.U_TEXT+'</span>';
		
		});
		$(".midlle_info").html(str);
		$(".xiao_name").html(name);
		$(".xiao_info").html(id);
		$(".signature").html(talk);
	
	},"json");
});

//搜索框
function search(){
	var s_name=$.trim($("#s_name").val());
//	alert(s_name);
	$.post("indexServlet",{op:"snamefind",s_name:s_name},function(data){
		if(data.num!=0){
			
			window.open("search.jsp");
		}
		
	});
	$("#s_name").text("");
}

//添加好友
function makeFriend(){
	var uid = session.getAttribute(SessionAttributeNames.u_id);
	var u_id = uid;
	var friend_id = $(".xiao_info span").text();
	friend_id = friend_id.split(":")[1];
	//alert(friend_id+"!!!!");
	var friend_name = $(".xiao_name a").text();
	//alert(friend_name);
	$.post("userHomepage.do",{
		op : "makeFriendInfo",
		u_id : u_id,
		f_id : friend_id,
		f_name : friend_name,
	},function(data){
		if(data>0){
			alert("添加信息已经发送");
		}
	});
}


