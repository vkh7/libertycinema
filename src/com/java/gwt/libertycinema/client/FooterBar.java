package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;


public class FooterBar extends Composite {

    private Label footer = new Label("Copyright Liberty Cinema (2012)");

    public FooterBar(MainPanel mainPanel) {
        initWidget(footer);
    }

    public Label getFooter() {
        return footer;
    }

    public void setFooter(Label footer) {
        this.footer = footer;
    }
}