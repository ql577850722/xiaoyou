$(function(){
	$.post("indexServlet",{op:"snamefind1"},function(data){
	var str="";
		$.each(data.sname,function(index,item){
//			alert(item.U_NAME);
			str+='<div class="person"><div  class="img"><img src="'+item.U_PHOTO+'" onclick="javascript:getUname('+item.U_ID+')"/><br/>';
			str+='<span><img src="images/love_1.jpg" class="p_photo" /></span></div><ul>';
			str+='<li class="name">'+item.U_NAME+'</li><li class="grade">'+item.U_GRADE+'级  '+item.U_SCHOOL+'&nbsp;&nbsp;'+item.U_SEX+'</li><br/>';
			str+='<li class="dec"><span class="span">交友宣言：</span>'+item.U_TEXT+'</li></ul></div>';
		});
	$("#p_person").html(str);
	
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

//获取点击的用户id
function getUname(u_id){
//	alert(u_id);
	$.post("userInfo.do",{op:"getUid",u_id:u_id},function(data){
		
		if(data.num!=0){
			window.open("userHomepage.jsp");
		}
	});
	
}

