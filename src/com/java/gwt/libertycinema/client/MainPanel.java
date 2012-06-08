package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;


public class MainPanel extends Composite {

    private ScrollPanel contentHolder = new ScrollPanel();

    public MainPanel() {
        initWidget(contentHolder);
    }

    public MainPanel getBodyPanel() {
        return this;
    }
}