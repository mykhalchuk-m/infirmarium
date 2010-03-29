package com.infirmarium.client.gin;

import com.google.gwt.core.client.GWT;

public class GinManager {
	private static InfirmariumGinjector ginjector = GWT
			.create(InfirmariumGinjector.class);

	public static InfirmariumGinjector get() {
		return ginjector;
	}
}
