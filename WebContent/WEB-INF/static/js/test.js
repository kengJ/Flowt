$(document).ready(function(){
		$('#btn_tijiao').click(function(){
			var result = $('#form1').serialize();
			if(CheckMemo($('input[name="Memo').val())){
				alert("不能使用该备注");
			}else{
				$.ajax({
					url:'${APP_PATH}/SqlMessage/AddSqlMessage',
					data:result,
					success:function(data){
						$('#result').text(data);
					}
				});
			}
		});
		
		$('input[name="Memo"]').change(function(){
			if(CheckMemo($(this).val())){
				alert("不能使用该备注");
			}
		});
		
		function CheckMemo(Memo){
			var result = false;
			$.ajax({
				url:'${APP_PATH}/SqlMessage/CheckMemoIsCreate',
				data:{'Memo':Memo},
				success:function(data){
					result = data;
				}
			});
			return result;
		}
		
		function FindSqlMessage(){
			var result = null;
			$.ajax({
				url:'${APP_PATH}/SqlMessage/FindSqlMessages',
				success:function(data){
					result = data;
				}
			});
			return result;
		}
		function createSelect(target){
			var html = '';
			var result = null;
			$.ajax({
				url:'${APP_PATH}/SqlMessage/FindSqlMessages',
				success:function(data){
					for(var key in data){
						$(target).append('<option value="'+data[key].id+'">'+data[key].memo+'</option>');
					}
				}
			});
		}
		createSelect('#form2 > select');
		
		
		$('#form_btn').click(function(){
			//form2
			$.ajax({
				url:'${APP_PATH}/ExcelTable/AddExcelTable',
				data:$('#form2').serialize(),
				success:function(data){
					$('#result2').text(data);
				}
			});
		});
		
		/**$('#form3_btn').click(function(){
			/**$.ajax({
				url:'${APP_PATH}/Test1',
				data:$('#form3').serialize(),
				success:function(data){
					$('#result2').text(data);
				}
			});
			window.open('${APP_PATH}/Test1');
		});**/
		
		function createSelect1(target){
			var html = '';
			var result = null;
			$.ajax({
				url:'${APP_PATH}/ExcelTable/FindExcelTables',
				success:function(data){
					for(var key in data){
						$(target).append('<option value="'+data[key].id+'">'+data[key].tableName+'</option>');
					}
				}
			});
		}
		createSelect1('#form3 > select');
	});