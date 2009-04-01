package com.hospital.module;

import java.util.HashMap;
import java.util.Map;

public class AnalysisData extends ModuleData {

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
