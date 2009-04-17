$(document).ready( function() {
	$('.deleteParametr, .deleteButtonSmall').click( function() {
		//$(this).effect("highlight", {}, 1000);
		$(this).parent().css('display', 'block').hide(500, function () {
	        $(this).remove();
	      });

	});	
});