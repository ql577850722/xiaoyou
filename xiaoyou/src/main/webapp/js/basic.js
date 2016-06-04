function  exit(){
		var u_name=$("#login").text();
		$.post("userInfo.do",{op:"exit",u_name:u_name}, function(data){
			if(data==1){
				window.location.href="index.jsp";
			}else{
				$("#login_li").html("<span style=\"color:#fff\">[</span><a href=\"login.jsp\"  id=\"login\">登录</a><span style=\"color:#fff\">]</span>");
			}
		})
	}

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