// 信息删除begin
// <!-- 信息删除-DCM-DUM-DMM+MessageDelete  -->
// 删除顾客信息begin
function DCMclick(){
		if(access.indexOf("信息删除功能") < 0 ){
            $.messager.alert('警告','该用户没有此功能');
            event.stopPropagation();	
         }
    	if(!$('#output').tabs('exists','删除顾客信息')) {
				     $('#output').tabs('add',{ 
				     	// id:'ECM',   
					    title:'删除顾客信息',    
					      // fit:true,
					    href:'./tabs/client/Delete.html',
					    closable:true
					});
				 }
		else
		{
		$('#output').tabs('select', '删除顾客信息');
		}
}

// 删除顾客信息end
// 删除经办人信息begin
function DAMclick(){
		if(access.indexOf("信息删除功能") < 0 ){
            $.messager.alert('警告','该用户没有此功能');
            event.stopPropagation();	
         }
    	if(!$('#output').tabs('exists','删除经办人信息')) {
				     $('#output').tabs('add',{ 
				     	// id:'ECM',   
					    title:'删除经办人信息',    
					      // fit:true,
					    href:'./tabs/agency/Delete.html',
					    closable:true
					});
				 }
		else
		{
		$('#output').tabs('select', '删除经办人信息');
		}
}

// 删除经办人信息end

// 删除服装信息begin
function DMMclick(){
		if(access.indexOf("信息删除功能") < 0 ){
            $.messager.alert('警告','该用户没有此功能');
            event.stopPropagation();	
         }

    	if(!$('#output').tabs('exists','删除服装信息')) {
				     $('#output').tabs('add',{ 
				     	// id:'ECM',   
					    title:'删除服装信息',    
					      // fit:true,
					    href:'./tabs/cloth/Delete.html',
					    closable:true
					});
				 }
		else
		{
		$('#output').tabs('select', '删除服装信息');
		}
}

// 删除药品信息end
// 信息录入end