// JavaScript Document

//排行榜与说说达人的交换
$(function(){
	$("#change1").click(function(){
		document.getElementById("conten1").style.display='block';
		document.getElementById("conten2").style.display='none';

	});	
	$("#change").click(function(){
		document.getElementById("conten1").style.display='none';
			
		document.getElementById("conten2").style.display='block';
	});
});
//点击评论，评论块显示
$(function(){
		$("#comment_display").click(function(){
			document.getElementById("sky_center_comment").style.display='block';	
		
		});
});
//点击评论此图片，评论块隐藏

//点击回复
$(function(){
	$("#reply_a1").click(function(){
		document.getElementById("sky_center_answers").style.display='block';
		
	});	
	$("#answer_img2").click(function(){
		document.getElementById("sky_center_answers").style.display='none';
		
	});	
	
});