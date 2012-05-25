package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HTML;


public class FooterBar {

    private DockLayoutPanel main;
    private VerticalPanel body;

    private HorizontalPanel panel = new HorizontalPanel();

    public FooterBar(DockLayoutPanel main, VerticalPanel body) {
	this.main = main;
	this.body = body;
    }

    public void setUpFooter() {
	this.main.addSouth(new HTML("Copyright Liberty Cinema (2012)"), 2);
    }
}