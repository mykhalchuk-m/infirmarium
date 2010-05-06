package com.infirmarium.client.core.components.elements.simple;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;

public class ModalWindowWidget extends Composite {

	private static ModalWindowWidgetUiBinder uiBinder = GWT
			.create(ModalWindowWidgetUiBinder.class);

	interface ModalWindowWidgetUiBinder extends
			UiBinder<Widget, ModalWindowWidget> {
	}

	@UiField
	public HTMLPanel container;
	@UiField
	public FlowPanel content;

	public ModalWindowWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		HLayout layout = new HLayout(20);

		final DynamicForm form = new DynamicForm();
		form.setWidth(250);

		TextItem usernameItem = new TextItem();
		usernameItem.setTitle("Username");
		usernameItem.setRequired(true);
		usernameItem.setDefaultValue("bob");

		TextItem emailItem = new TextItem();
		emailItem.setTitle("Email");
		emailItem.setRequired(true);
		emailItem.setDefaultValue("bob@isomorphic.com");

		PasswordItem passwordItem = new PasswordItem();
		passwordItem.setTitle("Password");
		passwordItem.setRequired(true);

		PasswordItem password2Item = new PasswordItem();
		password2Item.setTitle("Password again");
		password2Item.setRequired(true);
		password2Item.setType("password");

		form.setFields(new FormItem[] { usernameItem, emailItem, passwordItem,
				password2Item });

		layout.addMember(form);

		layout.draw();
	}

}
