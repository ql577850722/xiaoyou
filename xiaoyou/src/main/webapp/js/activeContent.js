$(function(){
	$.post("activityContentServlet",{op:"getActiveid"},function(data){
		
		var str="";
		var str1="";
		$.each(data.activeid,function(index,item){
			str='<ul><li>活动时间：'+item.astarttime+'</li><li>所在城市：'+item.acity+'</li>';
			str+='<li>活动地点：'+item.aadd+'</li><li>每人花销：'+item.aexpend+'</li><li>需要人数：'+item.aperson+'</li>';
			str+='<li>活动详情：</li>'+item.acontent+'<li class="li_last">活动报名截止日期：'+item.adate+'</li>';
			str+='<li class="li_last">活动发起人：<a href="#">'+item.u_name+'</a></li></ul>';
			
			str1='<center><li>'+item.aname+'</li></center>';
		});
		$("#content").html(str);
		$("#t_title").html(str1);
	
	},"json");
});
