package com.infirmarium.client.core.components.elements.simple;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Grid;

public class ControlLinkSheetWidget extends Grid {

	private int linksAmount = 0;

	@UiConstructor
	public ControlLinkSheetWidget(int maxCols, int maxRows) {
		super(maxRows, maxCols);
	}

	public <L extends IconedLinkWidget> void addControlLink(L newLink) {
		int elements = 0;
		for (int c = getColumnCount() - 1; c > 0; c--) {
			for (int r = 0; r < getRowCount(); r++) {
				if (elements == linksAmount) {
					linksAmount++;
					setWidget(r, c, newLink);
					return;
				} else {
					elements++;
				}
			}
		}
	}
}
