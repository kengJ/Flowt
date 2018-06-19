function FetData(FetUrl,FetData,func,type){
	$.ajax({
		url:FetUrl,
		data:FetData,
		type:type,
		success:function(data){
			func(data);
		}
	});
}

function GetFormData(key){
	return $(key).serialize();
}