package com.company.client.ui.common;


import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.widgetideas.client.ProgressBar;
import com.google.gwt.widgetideas.client.ProgressBar.TextFormatter;

public class ProgressBarPopup extends PopupPanel {

    private ProgressBar progressBar;
	protected boolean progressBarCancelled;

    /**
     * Create and show
     */
    public ProgressBarPopup () {
        super(false,true);  //autohide==false, modal==true
        VerticalPanel panel = new VerticalPanel();
        panel.setBorderWidth(3);
       
        panel.add(new Label("Please Wait (Notice that this is modal!)"));
        
        progressBar = new ProgressBar();
        progressBar.setWidth("300");
           
        panel.add(progressBar);
        this.add(panel);
        this.center();
    }
    
    public void setText(final String statusText) {
        progressBar.setTextFormatter(new TextFormatter(){

			@Override
			protected String getText(ProgressBar bar, double curProgress) {
				return statusText;
			}});
    }
    
    public void resetAndClose() {
        progressBarCancelled=true;
        this.hide();
    }
    
    public void show() {
        //start that sucker up and let it run until we resetAndClose it
        Timer t = new Timer() {
			public void run() {
				if (progressBarCancelled) {
					cancel();
				}
				double progress = progressBar.getProgress() + 4;
				if (progress > 100) {
					progress = 0; //start over
				}
				progressBar.setProgress(progress);
			}
		};
		t.scheduleRepeating(400); //how fast we update progress
 
        super.show();
    }
    
}
