package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;


public class FooterBar {

    private DockLayoutPanel main;
    private HorizontalPanel panel = new HorizontalPanel();

    public FooterBar(DockLayoutPanel main) {
	this.main = main;
    }

    public void setUpFooter() {
	this.main.addSouth(new HTML("Copyright Liberty Cinema (2012)"), 2);
    }
}