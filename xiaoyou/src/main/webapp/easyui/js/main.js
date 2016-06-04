$(function(){
	//window.main_panel=$("content_lydia");
	$("#content_index").tabs("add",{
		title:'小柚信息管理中心',
		selected:true,
		closable:false,
		href:''
	});
	
	
	$("#menu_tree").tree({
		onClick:function(node){
			var obj=$("#content_index");
			if(node.id=='admin_content'){//说明是管理员信息管理
				//判断管理员界面是否展开
				if(obj.tabs('exists','管理员信息管理')){
					obj.tabs('select','管理员信息管理');
				}else{
					$("#content_index").tabs("add",{
						title:'管理员信息管理',
						selected:true,
						closable:true,
						href:'admin.html'
					});
					
				}
			}else if(node.id=='userInfo_content'){
				if(obj.tabs('exists','用户信息管理')){
					obj.tabs('select','用户信息管理');
					
				}else{
					$("#content_index").tabs("add",{
						title:'用户信息管理',
						selected:true,
						closable:true,
						href:'userInfo.html'
					});
				}
			}else if(node.id=='photo_content'){
				if(obj.tabs('exists','上传照片管理')){
					obj.tabs('select','上传照片管理');
				}else{
					$("#content_index").tabs("add",{
						title:'上传照片管理',
						selected:true,
						closable:true,
						href:'photo.html'
					});
				}
				
			}else if(node.id=='talk_content'){
				if(obj.tabs('exists','说说内容管理')){
					obj.tabs('select','说说内容管理');
				}else{
					$("#content_index").tabs("add",{
						title:'说说内容管理',
						selected:true,
						closable:true,
						href:'talk.html'
					});
				}
				
			}else if(node.id=='addActive_content'){
				if(obj.tabs('exists','申请审核的活动')){
					obj.tabs('select','申请审核的活动');
				}else{
					$("#content_index").tabs("add",{
						title:'申请审核的活动',
						selected:true,
						closable:true,
						href:'addActive.html'
					});
				}
			}else if(node.id=='okActive_content'){
				if(obj.tabs('exists','已通过的活动')){
					obj.tabs('select','已通过的活动');
				}else{
					$("#content_index").tabs("add",{
						title:'已通过的活动',
						selected:true,
						closable:true,
						href:'okActive.html'
					});
				}
			}else if(node.id=='noActive_content'){
				if(obj.tabs('exists','未通过的活动')){
					obj.tabs('select','未通过的活动');
				}else{
					$("#content_index").tabs("add",{
						title:'未通过的活动',
						selected:true,
						closable:true,
						href:'noActive.html'
					});
				}
			}
		}
	});
});


	
	
	
