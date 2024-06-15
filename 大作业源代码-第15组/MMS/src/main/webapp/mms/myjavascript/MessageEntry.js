// 信息录入begin
// <!-- 信息录入-ECM-EAM-EMM+MessageEntry   -->
// 录入顾客信息begin
function ECMclick(){
        if(access.indexOf("信息录入功能") < 0 ){
            $.messager.alert('警告','该用户没有此功能');
            event.stopPropagation();    
         }
    	if(!$('#output').tabs('exists','录入顾客信息')) {
				     $('#output').tabs('add',{ 
				     	// id:'ECM',   
					    title:'录入顾客信息',    
					      // fit:true,
					     href:'./tabs/client/Entry.html',
					    closable:true
					});
				 }
        else
        {
        $('#output').tabs('select', '录入顾客信息');
        }
}


// 录入顾客信息end
// 录入经办人信息begin
function EAMclick(){
        if(access.indexOf("信息录入功能") < 0 ){
            $.messager.alert('警告','该用户没有此功能');
            event.stopPropagation();    
         }
    	if(!$('#output').tabs('exists','录入经办人信息')) {
				     $('#output').tabs('add',{ 
					    title:'录入经办人信息',    
					     href:'./tabs/agency/Entry.html',
					    closable:true
					});
				 }
        else
        {
        $('#output').tabs('select', '录入经办人信息');
        }
}

// 录入经办人信息end

// 录入服装信息begin
function EMMclick(){
        if(access.indexOf("信息录入功能") < 0 ){
            $.messager.alert('警告','该用户没有此功能');
            event.stopPropagation();    
         }
    	if(!$('#output').tabs('exists','录入服装信息')) {
				     $('#output').tabs('add',{ 
				     	// id:'ECM',   
					    title:'录入服装信息',    
					      // fit:true,
					    href:'./tabs/cloth/Entry.html',
					    closable:true
					});
				 }
        else
        {
        $('#output').tabs('select', '录入服装信息');
        }
 }

// 录入服装信息end
// 信息录入end