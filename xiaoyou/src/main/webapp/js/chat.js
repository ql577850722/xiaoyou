//显示好友列表
$(function(){
	$.post("userHomepage.do",{op:"showFriend"},function(data){	
		var str = "";
		$.each(data.showFriend, function(index, item){
			console.info(item.friend_name+"   "+item.u_id);
			str += '<tr>'
				+'<td style="border-bottom:1px solid #000"><img src="images/search/8_17.jpg" style="width:80px;height:80px;border-radius:80px;"/></td>'
                +'<td style="border-bottom:1px solid #000"><p>呢称:</p><p>'+item.friend_name+'</p></td>'
                +'</tr>';				
		});
		$("#friendInfo").html(str);
	},"json");
	
});


