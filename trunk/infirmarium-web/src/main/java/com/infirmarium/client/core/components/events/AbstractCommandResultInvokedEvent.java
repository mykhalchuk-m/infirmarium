package com.infirmarium.client.core.components.events;

import net.customware.gwt.dispatch.shared.Result;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public abstract class AbstractCommandResultInvokedEvent<C extends Result, EH extends EventHandler>
		extends GwtEvent<EH> {
	private C result;

	public AbstractCommandResultInvokedEvent(C result) {
		super();
		this.result = result;
	}

	public C getResult() {
		return result;
	}

	public void setResult(C result) {
		this.result = result;
	}

}
