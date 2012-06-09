package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;


public class MainPanel extends Composite {

    private BaseLayout baseLayout;
    private ScrollPanel contentHolder = new ScrollPanel();
    private Label title = new Label();

    public MainPanel(BaseLayout baseLayout) {
        title.setStyleName("contentTitle");
        this.setBaseLayout(baseLayout);
        initWidget(contentHolder);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setContent(Widget widget) {
        contentHolder.clear();
        contentHolder.setWidget(widget);
    }

    public BaseLayout getBaseLayout() {
        return baseLayout;
    }

    public void setBaseLayout(BaseLayout baseLayout) {
        this.baseLayout = baseLayout;
    }
}