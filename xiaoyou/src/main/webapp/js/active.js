function add(){
	$("#light1").css("display","block");
}

function zhifuguanbi(){
	$("#light1").css("display","none");
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

//页面加载完成后自动执行
//$(function(){
//	$.post("activeServlet",{op:"getAllactive"},function(data){
//		
//		var str="";
//		$.each(data.allactivity,function(index,item){
////			alert(item.acid);
//			str+='<a href="javascript:getAcid('+item.acid+')"><div class="content"><div class="grid"><figure class="effect-julia">';
//    		str+='<img src="'+item.aphoto+'" alt="img22"/><figcaption><h2>'+item.aname+'</h2><div><p>活动：'+item.aname+'</p><br/>';
//    		str+='<p>地点：'+item.aadd+'</p><br/><p>时间：'+item.astarttime+'</p></div></figcaption></figure></div></div></a>';
//		});
//		$("#active").html(str);
//	
//	},"json");
//	
//	var str1="";
//	var pageNo=1;
//	str1='<center><a href="javascript:pageNo1('+pageNo+')">上一页</a>&nbsp&nbsp |&nbsp&nbsp 第 &nbsp;<span>'+pageNo+'</span>&nbsp 页&nbsp&nbsp |&nbsp&nbsp <a href="javascript:pageNo2('+pageNo+')">下一页</a></center>';
//	$("#page").html(str1);
//
//
//});






//脚本部分
$(function(){
	
	$.post("activeServlet",{op:"getAllactive"},function(data){
		
		var str="";
		$.each(data.allactivity,function(index,item){
//			alert(item.acid);
			str+='<a href="javascript:getAcid('+item.acid+')"><div class="content"><div class="grid"><figure class="effect-julia">';
    		str+='<img src="'+item.aphoto+'" alt="img22"/><figcaption><h2>'+item.aname+'</h2><div><p>活动：'+item.aname+'</p><br/>';
    		str+='<p>地点：'+item.aadd+'</p><br/><p>时间：'+item.astarttime+'</p></div></figcaption></figure></div></div></a>';
		
		});
		$("#active").html(str);
	
		$.post("activeServlet",{op:"getPages"},function(data){
			var allPages=Math.ceil(data/9);
//			alert(data);
			var str1="";
			str1+='<div class="pages"><div id="Pagination"></div><div class="searchPage"><span class="page-sum">共<strong class="allPage">'+allPages+'</strong>页</span>';
			str1+='<span class="page-go">跳转<input type="text">页</span>';
			str1+='<a href="javascript:;" class="page-btn">GO</a></div></div> <div style="text-align:center;margin:0; font:normal 14px/24px "MicroSoft YaHei";">';
			$("#page").html(str1);
			
			$(document).ready(function() {
				$("#Pagination").pagination(allPages);
			});
		
		});
	},"json");
});

////跳转页面
//function goPage(){
//	
//	 var goPage = $(".page-go input").val();
//	 alert(goPage);
//   	$.post("activeServlet",{op:"getAllactive1",new_current_page:goPage},function(data){
//			var str='';
//			$.each(data.allactivity1,function(index,item){
//		////		alert(item.acid);
//				str+='<a href="javascript:getAcid('+item.acid+')"><div class="content"><div class="grid"><figure class="effect-julia">';
//				str+='<img src="'+item.aphoto+'" alt="img22"/><figcaption><h2>'+item.aname+'</h2><div><p>活动：'+item.aname+'</p><br/>';
//				str+='<p>地点：'+item.aadd+'</p><br/><p>时间：'+item.astarttime+'</p></div></figcaption></figure></div></div></a>';
//			});
//			$("#active").html(str);
//		},"json");
//   	scrollTo(0,250);
//}

//返回查看所有活动
function backAll(){

	$("#cityChoice").val("");
	
	$.post("activeServlet",{op:"getAllactive"},function(data){
			
			var str="";
			$.each(data.allactivity,function(index,item){
	//			alert(item.acid);
				str+='<a href="javascript:getAcid('+item.acid+')"><div class="content"><div class="grid"><figure class="effect-julia">';
	    		str+='<img src="'+item.aphoto+'" alt="img22"/><figcaption><h2>'+item.aname+'</h2><div><p>活动：'+item.aname+'</p><br/>';
	    		str+='<p>地点：'+item.aadd+'</p><br/><p>时间：'+item.astarttime+'</p></div></figcaption></figure></div></div></a>';
			
			});
			$("#active").html(str);
		
			$.post("activeServlet",{op:"getPages"},function(data){
				var allPages=Math.ceil(data/9);
	//			alert(data);
				var str1="";
				str1+='<div class="pages"><div id="Pagination"></div><div class="searchPage"><span class="page-sum">共<strong class="allPage">'+allPages+'</strong>页</span>';
				str1+='<span class="page-go">跳转<input type="text">页</span>';
				str1+='<a href="javascript:goPage();" class="page-btn">GO</a></div></div> <div style="text-align:center;margin:0; font:normal 14px/24px "MicroSoft YaHei";">';
				$("#page").html(str1);
				
				$(document).ready(function() {
					$("#Pagination").pagination(allPages);
				});
			
			});
		},"json");
}

//获取活动id
function getAcid(acid){
	
	$.post("activeServlet",{op:"getActiveid",acid:acid},function(data){
		
		if(data.num!=0){
			window.open("activeContent.jsp");
		}
	});
	
}