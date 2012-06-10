package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


public class MainPanel extends Composite {

    private BaseLayout baseLayout;
    private ScrollPanel contentHolder = new ScrollPanel();
    private VerticalPanel titlePanel = new VerticalPanel();
    private VerticalPanel contentPanel = new VerticalPanel();
    private VerticalPanel mainPanel = new VerticalPanel();
    private Label title = new Label();

    public MainPanel(BaseLayout baseLayout) {
        this.setBaseLayout(baseLayout);
        title.setStyleName("contentTitle");
        contentHolder.setStyleName("contentMain");
        titlePanel.add(title);
        titlePanel.setStyleName("titlePanel");
        contentPanel.setStyleName("contentPanel");
        mainPanel.add(titlePanel);
        mainPanel.add(contentPanel);
        mainPanel.setStyleName("mainPanel");
        contentHolder.setWidget(mainPanel);
        initWidget(contentHolder);
    }

    public void setContent(String title, Widget widget) {
        contentPanel.clear();
        this.title.setText(title);
        contentPanel.add(widget);
    }

    public VerticalPanel getContent() {
        return contentPanel;
    }

    public BaseLayout getBaseLayout() {
        return baseLayout;
    }

    public void setBaseLayout(BaseLayout baseLayout) {
        this.baseLayout = baseLayout;
    }
}