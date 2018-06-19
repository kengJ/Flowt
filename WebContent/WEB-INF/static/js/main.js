$(document).ready(function(){
	
	$('.menu-item').click(function(){
		$('#main').empty();		
		FetData(baseUrl+'/Page/'+$(this).attr('data-page'),{},function(data){
			$('#main').append(data);
		},'GET')
		
	});
});