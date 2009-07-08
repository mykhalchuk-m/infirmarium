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
		$(this).parent().prev().append('<div class="parametrVariant"><input name="analysis.parameters['+paramId+'].values['+valueId+']"><span class="deleteButtonSmall"></div>');
		reinitDeleteSmall();
		valuesAmounts[paramId]++;
	});
}
function enableVariants(paramId){
	$('#paramBlock_'+paramId+' input[name=types['+paramId+']]:radio').change(function(){
		
		switch ($(this).val()){
			case 'TEXTBOX':				
				$("#paramEdit_"+paramId).hide();
				$("#normEdit_"+paramId).hide();
				$("#gendNormEdit_"+paramId).hide();
				break;
			case 'NORM':		
				$("#paramEdit_"+paramId).hide();
				$("#normEdit_"+paramId).show();
				$("#gendNormEdit_"+paramId).hide();
				break;
			case 'SEX_NORM':			
				$("#paramEdit_"+paramId).hide();
				$("#normEdit_"+paramId).hide();
				$("#gendNormEdit_"+paramId).show();
				break;
			case 'SELECTBOX':
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
		newParamBlock.append('<div class="parametr" id="paramBlock_'+paramsAmount+'"><div class="deleteParametr"></div><div class="parametrName">Назва параметра <input name="analysis.parameters['+paramsAmount+'].name"></div><div class="parametrType"><input type="radio" name="types['+paramsAmount+']" value="TEXTBOX">TEXTBOX<input type="radio" name="types['+paramsAmount+']" value="SELECTBOX" checked="checked" >SELECTBOX<input type="radio" name="types['+paramsAmount+']" value="NORM">NORM<input type="radio" name="types['+paramsAmount+']" value="SEX_NORM">SEX_NORM</div><div id="paramEdit_'+paramsAmount+'">	<div class="parametrVariants"></div><div><span class="addButtonSmall"></div></div><div id="normEdit_'+paramsAmount+'"><br/>Верхня межа:<input name="analysis.parameters['+paramsAmount+'].norm.maxValue"> Нижня межа:<input name="analysis.parameters['+paramsAmount+'].norm.minValue"><br/><br/> Одиниця вимірювання:<input name="analysis.parameters['+paramsAmount+'].norm.unit"></div><div id="gendNormEdit_'+paramsAmount+'"><br/>Верхня межа для чоловіків:<input name="analysis.parameters['+paramsAmount+'].sexNorm.maxMaleValue"> Нижня межа для чоловіків:<input name="analysis.parameters['+paramsAmount+'].sexNorm.minMaleValue"><br/><br/>Верхня межа для жінок:<input name="analysis.parameters['+paramsAmount+'].sexNorm.maxFemaleValue"> Нижня межа для жінок:<input name="analysis.parameters['+paramsAmount+'].sexNorm.minFemaleValue"><br/><br/> Одиниця вимірювання:<input name="analysis.parameters['+paramsAmount+'].sexNorm.unit"></div></div>');
		$("#normEdit_"+paramsAmount).hide();
		$("#gendNormEdit_"+paramsAmount).hide();
		reinitAdd(paramsAmount);
		valuesAmounts[paramsAmount]=0;
		enableVariants(paramsAmount);
		paramsAmount++;
		reinitDeleteSmall();
	});
	
});

