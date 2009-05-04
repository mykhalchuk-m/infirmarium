var valuesAmounts=new Array();
var paramsAmount = 0;
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
		$(this).parent().prev().append('<div class="parametrVariant"><input name="value_'+paramId+'_'+valueId+'"><span class="deleteButtonSmall"></div>');
		reinitDeleteSmall();
		valuesAmounts[paramId]++;
	});
}
function enableVariants(paramId){
	$('#paramBlock_'+paramId+' input[name=type_'+paramId+']:radio').change(function(){
		
		switch ($(this).val()){
			case 'field':				
				$("#paramEdit_"+paramId).hide();
				break;
			case 'variants':
				$("#paramEdit_"+paramId).show();
				break;
		}
	});
	
}
$(document).ready( function() {
	reinitDeleteSmall();
	
	$('.addButtonParam').click(function(){
		newParamBlock =$(this).parent().prev(); 
		newParamBlock.append('<div class="parametr" id="paramBlock_'+paramsAmount+'"><div class="deleteParametr"></div><div class="parametrName">Name <input name="param_'+paramsAmount+'"></div><div class="parametrType"><input type="radio" name="type_'+paramsAmount+'" value="field">Field<input type="radio" name="type_'+paramsAmount+'" value="variants" checked="checked" >Variants</div><div id="paramEdit_'+paramsAmount+'">	<div class="parametrVariants"></div><div><span class="addButtonSmall"></div></div></div>');
		reinitAdd(paramsAmount);
		valuesAmounts[paramsAmount]=0;
		enableVariants(paramsAmount);
		paramsAmount++;
		reinitDeleteSmall();
	});
	
});

