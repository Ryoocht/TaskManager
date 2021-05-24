/**
 * 
 */
$(function(){
	let doneCount = $("#complete-table").children("tr").length;
	$("#done_count").text(doneCount);
	
	$('.todo input').change(function(){
		const todo = $(this).parents('.todo');
		const id = todo.find('input[name="id"]');
		const title = todo.find('input[name="title"]');
		const timeLimit = todo.find('input[name="due_date"]');
		const isDone = todo.find('input[name="done_flag"]').prop("checked");
		let doneFlg;
		if(isDone == true) {
	  	doneFlg = 1;
		}else{
	 	 doneFlg = 0;
		}

		const params = {
			id : id.val(),
			title : title.val(),
			due_date : timeLimit.val(),
			done_flag : doneFlg
		}
		$.post("/update",params);
		
	doneCount =  $('#done_count').text();

	if($(this).prop('name') == "done_flag"){
	  if(isDone == true){
	    $(todo).appendTo('#complete-table');
	    todo.find('input[name="due_date"]').hide();
	    doneCount ++;
	  }else{
	    $(todo).appendTo('#incomplete-table');
	    todo.find('input[name="due_date"]').show()
	    doneCount --;
	  }

	  $("#done_count").text(doneCount);
	}
	})
})