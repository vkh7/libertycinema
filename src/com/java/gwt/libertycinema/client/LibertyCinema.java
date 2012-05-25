package com.java.gwt.libertycinema.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.dom.client.Style.Unit;


public class LibertyCinema implements EntryPoint {

    private DockLayoutPanel main = new DockLayoutPanel(Unit.EM);
    private VerticalPanel body = new VerticalPanel();

    private FooterBar footer;
    private TopNavBar header;

    public void onModuleLoad() {
	header = new TopNavBar(main, body);
	header.setUpTopNavBar();

	// Setup footer
	footer = new FooterBar(main, body);
	footer.setUpFooter();

	main.add(new HTML("asd"));

	RootLayoutPanel.get().add(main);
    }
}
