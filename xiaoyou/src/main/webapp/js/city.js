
	window.onload=function(){
		var dom;
		if(window.DOMParser&&!window.ActiveXObject){
			var xmlhttp=new XMLHttpRequest();
			xmlhttp.open("GET","city.xml",false);
			xmlhttp.send(null);
			if(xmlhttp.readyState==4){
				dom=xmlhttp.responseXML.documentElement;
			}
		}else{
			dom=xmlDom();
			dom.async=false;
			dom.load("city.xml");
		}
		
		//获取显示三级级联的三个下拉对象
		var pro=document.getElementById("province");
		var city=document.getElementById("city");
//		var area=document.getElementById("area");
		
		//获取所有的省份
		var pros=dom.getElementsByTagName("province");
		
		for(var i=0;i<pros.length;i++){
			addOption(pros[i],pro);
		}
		
		//当省份发生改变时，后面的城市跟着改变,所以给省份的下拉对象添加一个onchange事件
		pro.onchange=function(){
			//获取当前选中的省份的编号
			var flag=pro.value;
			
			//清空以前的数据
		city.length=1;
//			area.length=1;
			for(var i=0;i<pros.length;i++){
				//如果选中的省份的编号跟当前循环的对象编号一样
				if(pros[i].nodeType==1&&flag==pros[i].getAttribute("postcode")){
					//取出该省份下的所有市
					var cities=pros[i].childNodes;
					for(var j=0;j<cities.length;j++){
						if(cities[j].nodeType==1){
							addOption(cities[j],city);
						}
					}
					break;
				}
			}
		}
		
		//当城市发生变化的时候
//		city.onchange=function(){
//			var num=pro.value; //获取当前选中的省份
//			var code=city.value; //获取当前选中的城市的编号
//			area.length=1;//清空县下拉对象中原有的数据
//			
//			for(var i=0;i<pros.length;i++){
//				//如果选中的省份的编号跟当前循环的对象编号一样
//				if(pros[i].nodeType==1&&num==pros[i].getAttribute("postcode")){
//					//获取当前省份下面的所有市
//					var cities=pros[i].childNodes;
//					
//					
//					//当前循环的城市跟选中的城市相同
//					for(var j=0;j<cities.length;j++){
//						if(cities[j].nodeType==1&&cities[j].getAttribute("postcode")==code){
//							//获取当前城市下的所有地区
//							var areas=cities[j].childNodes;
//							
//							for(var k=0;k<areas.length;k++){
//								if(areas[k].nodeType==1){
//									addOption(areas[k],area);
//								}
//							}
//						}
//					}
//				}
//			}
//			
//		}
		
	}

	//第一个是要添加的节点对象，第二个是要添加到的对象
	function addOption(node,obj){
		if(node.nodeType==1){
			var opt=document.createElement("option");
			opt.appendChild( document.createTextNode( node.getAttribute("name") ) );
			opt.setAttribute("value",node.getAttribute("postcode"));
			obj.appendChild(opt);
			//<option value=''>湖南省</option>
		}
	}