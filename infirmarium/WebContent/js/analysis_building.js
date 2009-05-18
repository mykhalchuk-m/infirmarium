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
				$("#normEdit_"+paramId).hide();
				$("#gendNormEdit_"+paramId).hide();
				break;
			case 'norm':		
				$("#paramEdit_"+paramId).hide();
				$("#normEdit_"+paramId).show();
				$("#gendNormEdit_"+paramId).hide();
				break;
			case 'genderNorm':			
				$("#paramEdit_"+paramId).hide();
				$("#normEdit_"+paramId).hide();
				$("#gendNormEdit_"+paramId).show();
				break;
			case 'variants':
				$("#paramEdit_"+paramId).show();
				$("#normEdit_"+paramId).hide();
				$("#gendNormEdit_"+paramId).hide();
				break;
			//ou shit!
		}
	});
	
}
$(document).ready( function() {
	reinitDeleteSmall();
	
	$('.addButtonParam').click(function(){
		newParamBlock =$(this).parent().prev(); 
		newParamBlock.append('<div class="parametr" id="paramBlock_'+paramsAmount+'"><div class="deleteParametr"></div><div class="parametrName">Name <input name="param_'+paramsAmount+'"></div><div class="parametrType"><input type="radio" name="type_'+paramsAmount+'" value="field">Field<input type="radio" name="type_'+paramsAmount+'" value="variants" checked="checked" >Variants<input type="radio" name="type_'+paramsAmount+'" value="norm">Norm<input type="radio" name="type_'+paramsAmount+'" value="genderNorm">Gender norm</div><div id="paramEdit_'+paramsAmount+'">	<div class="parametrVariants"></div><div><span class="addButtonSmall"></div></div><div id="normEdit_'+paramsAmount+'">Upper:<input name="high_'+paramsAmount+'"> Lower:<input name="low_'+paramsAmount+'"></div><div id="gendNormEdit_'+paramsAmount+'">Upper male:<input name="highm_'+paramsAmount+'">Lower male:<input name="lowm_'+paramsAmount+'"><br>Upper female:<input name="highf_'+paramsAmount+'">Lower female:<input name="lowf_'+paramsAmount+'"></div></div>');
		$("#normEdit_"+paramsAmount).hide();
		$("#gendNormEdit_"+paramsAmount).hide();
		reinitAdd(paramsAmount);
		valuesAmounts[paramsAmount]=0;
		enableVariants(paramsAmount);
		paramsAmount++;
		reinitDeleteSmall();
	});
	
});

