// JavaScript Document
function choose_partner_show(){
	var img=document.getElementById('choose_partner');
	var sortDiv=document.getElementById('sky_insert');
	if('none'==sortDiv.style.display){
		sortDiv.style.display='block';
		img.src='images/product_page_up.gif';
	}else{
		sortDiv.style.display='none';	
		img.src='images/product_page_down.gif';	
	}
}

$(function(){
	$("#sky_insert_a").click(function(){
		document.getElementById("sky_left_pairs").style.display='block';	
		document.getElementById("sky_left_names").style.display='none';
		document.getElementById("sky_insert").style.display='none';
		
	});

	
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