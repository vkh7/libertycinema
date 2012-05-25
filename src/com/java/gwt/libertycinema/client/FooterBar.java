package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;


public class FooterBar {

    private DockLayoutPanel main;
    private VerticalPanel panel = new VerticalPanel();

    public FooterBar(DockLayoutPanel main) {
	this.main = main;
    }

    public void setUpFooter() {
	panel.add(new HTML("Copyright Liberty Cinema (2012)"));
	this.main.addSouth(panel, 2);
    }
}