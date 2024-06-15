// 信息浏览begin
// <!-- 数据报表-RCM-RAM-RMM+MessageReport  -->
// 浏览顾客信息begin
function RCMclick(){
		if(access.indexOf("数据报表功能") < 0 ){
            $.messager.alert('警告','该用户没有此功能');
            event.stopPropagation();	
         }
    	if(!$('#output').tabs('exists','顾客数据报表')) {
				     $('#output').tabs('add',{ 
				     	// id:'ECM',   
					    title:'顾客数据报表',    
					      // fit:true,
					     href:'./tabs/client/Report.html',
					    closable:true
					});
				 }
		else
		{
		$('#output').tabs('select', '顾客数据报表');
		}
}

// 浏览顾客信息end
// 浏览经办人信息begin
function RAMclick(){
		if(access.indexOf("数据报表功能") < 0 ){
            $.messager.alert('警告','该用户没有此功能');
            event.stopPropagation();	
         }
    	if(!$('#output').tabs('exists','经办人数据报表')) {
				     $('#output').tabs('add',{ 
				     	// id:'ECM',   
					    title:'经办人数据报表',    
					      // fit:true,
					     href:'./tabs/agency/Report.html',
					    closable:true
					});
				 }
		else
		{
		$('#output').tabs('select', '经办人数据报表');
		}
}

// 浏览经办人信息end
// 浏览服装信息begin
function RMMclick(){
		if(access.indexOf("数据报表功能") < 0 ){
            $.messager.alert('警告','该用户没有此功能');
            event.stopPropagation();	
         }
    	if(!$('#output').tabs('exists','服装数据报表')) {
				     $('#output').tabs('add',{ 
				     	// id:'ECM',   
					    title:'服装数据报表',    
					      // fit:true,
					     href:'./tabs/cloth/Report.html',
					    closable:true
					});
				 }
		else
		{
		$('#output').tabs('select', '服装数据报表');
		}
}

// 浏览服装信息end
// 信息浏览end