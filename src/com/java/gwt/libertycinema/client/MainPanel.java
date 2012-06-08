package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;


public class MainPanel extends Composite {

    private BaseLayout baseLayout;
    private ScrollPanel contentHolder = new ScrollPanel();

    public MainPanel(BaseLayout baseLayout) {
        this.setBaseLayout(baseLayout);
        initWidget(contentHolder);
    }

    public MainPanel getBodyPanel() {
        return this;
    }

    public BaseLayout getBaseLayout() {
        return baseLayout;
    }

    public void setBaseLayout(BaseLayout baseLayout) {
        this.baseLayout = baseLayout;
    }
}