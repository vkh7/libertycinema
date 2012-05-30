package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.java.gwt.libertycinema.client.BodyPanel;
import com.java.gwt.libertycinema.client.views.HomeLinkCommand;


public class TopNavBar {

    private BodyPanel body;

    private VerticalPanel headerPanel = new VerticalPanel();

    public TopNavBar(BodyPanel body) {
	this.body = body;
    }

    private MenuBar setUpTopNavButtons() {
	MenuBar menu = new MenuBar();
	menu.addItem("foo", new HomeLinkCommand(body));
	menu.addItem("bar", new HomeLinkCommand(body));
	return menu;
    }

    private HorizontalPanel setUpTopNavLogo() {
	HorizontalPanel logoPanel = new HorizontalPanel();
	logoPanel.add(new HTML("<h2>Liberty Cinema</h2>"));
	return logoPanel;
    }

    public VerticalPanel getTopBarPanel() {
	headerPanel.add(setUpTopNavLogo());
	headerPanel.add(setUpTopNavButtons());
	return headerPanel;
    }
}