package com.infirmarium.client.components.elements.screens;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.infirmarium.client.components.events.GetPersonDetailsEvent;
import com.infirmarium.client.components.events.GetPersonsEvent;
import com.infirmarium.client.components.events.handlers.PersonDetailsEventHandler;
import com.infirmarium.client.components.events.handlers.PersonsEventHandler;
import com.infirmarium.client.components.model.records.PersonRecord;
import com.infirmarium.client.core.components.elements.screens.TitleScreen;
import com.infirmarium.client.gin.GinManager;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.server.shared.GetPersonDetailsCommand;
import com.infirmarium.server.shared.GetPersonsCommand;
import com.infirmarium.server.shared.results.GetPersonDetailsCommandResult;
import com.infirmarium.server.shared.results.GetPersonsCommandResult;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;

public class PatientScreen extends TitleScreen {

	private static final String SCREEN_STYLE_NAME = "inf-patient-screen";

	private static PatientScreenUiBinder uiBinder = GWT
			.create(PatientScreenUiBinder.class);

	interface PatientScreenUiBinder extends UiBinder<Widget, PatientScreen> {
	}

	private static final String DESCRIPTION = GinManager.get()
			.InfirmariumMessages().patientsScreenDescription();

	private static final String TITLE = GinManager.get().InfirmariumMessages()
			.patientsScreenTitle();

	@UiField
	public VerticalPanel content;
	@UiField
	public ListGrid list;

	@Inject
	public PatientScreen() {
		super(TITLE, SCREEN_STYLE_NAME, DESCRIPTION);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void init() {
		list.setWidth(910);
		list.setHeight("50%");
		list.setShowAllRecords(true);

		ListGridField nameField = new ListGridField(
				PersonRecord.Attributes.name);
		ListGridField birthField = new ListGridField(
				PersonRecord.Attributes.birthDay);
		list.setFields(nameField, birthField);

		getLayout().contentSlot.add(content);
		addControlLink("inf-small-icon-add", "add new user", null);
		addControlLink("inf-small-icon-add", "remove all", null);
		addControlLink("inf-small-icon-add", "print", null);
		list.addRecordClickHandler(new RecordClickHandler() {
			public void onRecordClick(RecordClickEvent event) {
				int selectedRow = event.getRecordNum();

				if (selectedRow >= 0) {
					Integer id = selectedRow;
					getPersonDetails(id);
				}

			}
		});

		eventBus.addHandler(GetPersonsEvent.TYPE, new PersonsEventHandler() {
			@Override
			public void onGetPersons(GetPersonsEvent event) {
				GetPersonsCommandResult result = event.getResult();
				List<Person> personList = result.getPerson();
				RecordList personRecordList = new RecordList();
				for (Person person : personList) {
					personRecordList.add(new PersonRecord(person));
				}
				list.setData(personRecordList);
				list.redraw();
			}
		});
		eventBus.addHandler(GetPersonDetailsEvent.TYPE,
				new PersonDetailsEventHandler() {

					@Override
					public void onGetPersonDetails(
							final GetPersonDetailsEvent event) {
						SC.say(event.getResult().getName(), event.getResult()
								.getMessage());
					}

				});

		getPersons();
		super.init();
	}

	/**
	 * Try to get person details
	 */
	private void getPersonDetails(Integer id) {
		dispatcher.execute(new GetPersonDetailsCommand(id),
				new AsyncCallback<GetPersonDetailsCommandResult>() {

					@Override
					public void onFailure(Throwable arg0) {
						Window.alert(SERVER_ERROR);
					}

					@Override
					public void onSuccess(GetPersonDetailsCommandResult result) {
						eventBus.fireEvent(new GetPersonDetailsEvent(result));
					}

				});
	}

	private void getPersons() {
		dispatcher.execute(new GetPersonsCommand(0),
				new AsyncCallback<GetPersonsCommandResult>() {
					@Override
					public void onFailure(Throwable e) {
						Log.error("Connection to server failed.", e);
					}

					@Override
					public void onSuccess(GetPersonsCommandResult result) {
						eventBus.fireEvent(new GetPersonsEvent(result));
					}

				});
	}

}
