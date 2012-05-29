package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;


public class TopNavBar {

    private VerticalPanel body;

    private VerticalPanel headerPanel = new VerticalPanel();

    public TopNavBar(VerticalPanel body) {
	this.body = body;
    }

    private HorizontalPanel setUpTopNavButtons() {
	HorizontalPanel buttonsPanel = new HorizontalPanel();
	buttonsPanel.add(new Button("Home"));
	buttonsPanel.add(new Button("Gallery"));
	buttonsPanel.add(new Button("Testimonials"));
	buttonsPanel.add(new Button("Contact Us"));
	return buttonsPanel;
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