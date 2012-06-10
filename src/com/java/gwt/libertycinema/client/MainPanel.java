package com.java.gwt.libertycinema.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


public class MainPanel extends Composite {

    private BaseLayout baseLayout;
    private ScrollPanel contentHolder = new ScrollPanel();
    private VerticalPanel verticalPanel = new VerticalPanel();
    private Label title = new Label();

    public MainPanel(BaseLayout baseLayout) {
        this.setBaseLayout(baseLayout);
        title.setStyleName("contentTitle");
        contentHolder.setStyleName("contentMain");
        verticalPanel.add(title);
        verticalPanel.setStyleName("contentTable");
        contentHolder.setWidget(verticalPanel);
        initWidget(contentHolder);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void clearContent() {
        verticalPanel.clear();
    }

    public void setContent(Widget widget) {
        verticalPanel.add(widget);
    }

    public BaseLayout getBaseLayout() {
        return baseLayout;
    }

    public void setBaseLayout(BaseLayout baseLayout) {
        this.baseLayout = baseLayout;
    }
}