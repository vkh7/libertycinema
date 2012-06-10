package com.java.gwt.libertycinema.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootLayoutPanel;


public class LibertyCinema implements EntryPoint {

    public void onModuleLoad() {
        History.newItem("main");
        RootLayoutPanel.get().add(new BaseLayout());
    }
}
