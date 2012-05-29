package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;


public class HomeLinkCommand implements Command {

    VerticalPanel body;

    public HomeLinkCommand(VerticalPanel body) {
	this.body = body;
    }

    public void execute() {
	body.clear();
    }
}