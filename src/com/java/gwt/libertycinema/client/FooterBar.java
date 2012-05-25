package com.java.gwt.libertycinema.client;

import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.core.client.GWT;


public class FooterBar {
    private DockLayoutPanel main;

    public FooterBar(DockLayoutPanel main) {
	this.main = main;
    }

    public void setUpFooter() {
	HTML credits = new HTML("Copyright Liberty Cinema (2012)");
	this.main.addSouth(credits, 2);
    }
}