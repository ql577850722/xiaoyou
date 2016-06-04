// JavaScript Document
//nav图片轮播
var index=0;
var mytime;
function show(id){
	if(Number(id)){
		index=id;
		window.clearInterval(mytime);
	}else{
		index=index%4+1;
	}
	$("#bg_img").attr("src","images/index_nav"+index+".jpg");
	$("#nav_dots_li li").attr("class","out");
	$("#nav_dots_li li").eq(index-1).attr("class","over");
}
function start(){
	mytime=window.setInterval("show()",1000);
}
$(function(){
	mytime=window.setInterval("show()",1000);	
})

