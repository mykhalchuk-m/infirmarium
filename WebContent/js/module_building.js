var paramsAmount = 0;
var valuesAmounts = new Array();

function reinitDeleteSmall(){
	$('.deleteParametr, .deleteButtonSmall').click( function() {
		$(this).parent().css('display', 'block').hide(500, function() {
			$(this).remove();
		});
	});
}
function reinitAdd(paramId){
	$('#paramBlock_'+paramId+' .addButtonSmall').click(function(){		
		valueId=valuesAmounts[paramId];
		$(this).parent().prev().append('<div class="parametrVariant"><input name="module.parameters['+paramId+'].values['+valueId+']"><span class="deleteButtonSmall"></div>');
		reinitDeleteSmall();
		valuesAmounts[paramId]++;
	});
}
function enableVariants(paramId){
	$('#paramBlock_'+paramId+' input[name=types['+paramId+']]:radio').change(function(){
		
		switch ($(this).val()){
			case 'TEXTBOX':				
				$("#paramEdit_"+paramId).hide();
				break;
			case 'SELECTBOX':
				$("#paramEdit_"+paramId).show();
				break;
		}
	});
	
}
$(document).ready( function() {
	reinitDeleteSmall();
	
	$('.addButtonParam').click(function(){
		newParamBlock =$(this).parent().prev(); 
		newParamBlock.append('<div class="parametr" id="paramBlock_'+paramsAmount+'"><div class="deleteParametr"></div><div class="parametrName">Назва параметра <input name="module.parameters['+paramsAmount+'].name"></div><div class="parametrType"><input type="radio" name="types['+paramsAmount+']" value="TEXTBOX">TEXTBOX<input type="radio" name="types['+paramsAmount+']" value="SELECTBOX" checked="checked" >SELECTBOX</div><div id="paramEdit_'+paramsAmount+'">	<div class="parametrVariants"></div><div><span class="addButtonSmall"></div></div></div>');
		reinitAdd(paramsAmount);
		valuesAmounts[paramsAmount]=0;
		enableVariants(paramsAmount);
		paramsAmount++;
		reinitDeleteSmall();
	});
	
});

