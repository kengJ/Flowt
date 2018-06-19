$(document).ready(function(){
	$('#UserName').change(
		function(){
			if($('#UserName').val()){
				FetData(baseUrl+'/Login/CheckUserName',{UserName:$('#UserName').val()},function(data){
					if(data.key=="error") alert(data.value);
					//console.log(data);
				},'GET');
			}
		}
	);
	
	$('#button').click(function(){
		var UserName = $('#UserName').val();
		var Password = $('#Password').val();
		console.log(UserName);
		console.log(Password);
		if(UserName!=""&Password!=""){
			/**FetData(baseUrl+'/Login/CheckUserName',{UserName:$('#UserName').val()},function(data){
				alert(data.value);
				//console.log(data);
			},'GET');**/
			//self.location.href=baseUrl+'/Login/Login?UserName='+UserName+'&Password='+Password;
			CreateForm(baseUrl+'/Login/Login',{'UserName':UserName,'Password':Password},'POST');
		}else{
			alert('账号密码不能为空');
		}
	});
	
	function CreateForm(Url,Data,Method){
		console.log(Url,Data,Method);
		form = $("<form></form>")
	    form.attr('action',Url)
	    form.attr('method',Method)
	    for(var key in Data){
	    	input1 = $("<input type='hidden' name='"+key+"' value='"+Data[key]+"' />");
	    	form.append(input1);
	    }
	    form.appendTo("body");
	    form.css('display','none');
	    form.submit();
	} 
	
	
});