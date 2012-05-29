package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HTML;


public class FooterBar {

    private VerticalPanel body;

    private HorizontalPanel panel = new HorizontalPanel();

    public FooterBar(VerticalPanel body) {
	this.body = body;
    }

    public HTML getFooterPanel() {
	HTML html = new HTML("Copyright Liberty Cinema (2012)");
	return html;
    }
}