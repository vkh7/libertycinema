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
    private VerticalPanel header = new VerticalPanel();
    private HorizontalPanel headerHtml = new HorizontalPanel();
    private HorizontalPanel headerButtons = new HorizontalPanel();
    private HorizontalPanel body = new HorizontalPanel();
    private FooterBar footer;

    public void onModuleLoad() {
	headerHtml.add(new HTML("<h2>Liberty Cinema</h2>"));

	Button home = new Button("Home");
	Button contactUs = new Button("Contact Us");

	headerButtons.add(home);
	headerButtons.add(contactUs);


	header.add(headerHtml);

	header.add(headerButtons);


	main.addNorth(header, 7);

	// Setup footer
	footer = new FooterBar(main);
	footer.setUpFooter();

	main.add(new HTML("asd"));

	RootLayoutPanel.get().add(main);

    }
}
