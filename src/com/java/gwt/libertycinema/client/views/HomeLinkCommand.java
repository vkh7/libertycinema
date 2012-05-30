package com.java.gwt.libertycinema.client.views;


import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HTML;

import com.java.gwt.libertycinema.client.BodyPanel;


public class HomeLinkCommand implements Command {

    BodyPanel body;

    public HomeLinkCommand(BodyPanel body) {
	this.body = body;
    }

    public void execute() {
	body.getBodyPanel().clear();
	body.getBodyPanel().add(new HTML("test"));
	body.getBodyPanel().add(new HTML("test5"));
    }

    public void getHomeScreenData() {
    }

    public void getHomeScreenPanel() {
    }
}