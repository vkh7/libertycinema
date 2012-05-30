package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;


public class BodyPanel extends VerticalPanel {

    public BodyPanel() {
	super();
	this.add(new HTML ("test panel"));
    }

    public BodyPanel getBodyPanel() {
	return this;
    }
}