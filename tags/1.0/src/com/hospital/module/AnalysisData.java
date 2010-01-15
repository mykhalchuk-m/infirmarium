package com.hospital.module;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;

@Entity
@Table(name="analysisdata_tbl")
@PrimaryKeyJoinColumn(name="id")
public class AnalysisData extends ModuleData {
	
	@CollectionOfElements//(fetch=FetchType.EAGER)
	@JoinTable(name = "parameters_analysis_data_tbl", joinColumns = @JoinColumn(name = "id"))
	@MapKey(columns = @Column(name = "norm_parameter_name", length = 70))
	@Column(name="norm_parameter_value")
	private Map<String, Double> normParameters = new HashMap<String, Double>();

	public Map<String, Double> getNormParameters() {
		return normParameters;
	}

	public void setNormParameters(Map<String, Double> normParameters) {
		this.normParameters = normParameters;
	}

	public void addParameter(String normParameterName, Double normParameterValue) {
		this.normParameters.put(normParameterName, normParameterValue);
	}

}
