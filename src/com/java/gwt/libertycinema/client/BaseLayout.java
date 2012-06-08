package com.java.gwt.libertycinema.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;

public class BaseLayout extends Composite {

    private DockLayoutPanel layout = new DockLayoutPanel(Unit.EM);
    private HeaderBar headerBar;
    private MainPanel mainPanel;

    public BaseLayout() {
        headerBar = new HeaderBar(this);
        mainPanel = new MainPanel(this);

        layout.addNorth(headerBar, 5);
        layout.add(mainPanel);

        initWidget(layout);
    }

    public DockLayoutPanel getLayout() {
        return layout;
    }

    public void setLayout(DockLayoutPanel layout) {
        this.layout = layout;
    }

    public HeaderBar getHeaderBar() {
        return headerBar;
    }

    public void setHeaderBar(HeaderBar headerBar) {
        this.headerBar = headerBar;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
