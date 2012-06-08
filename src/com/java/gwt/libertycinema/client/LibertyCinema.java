package com.java.gwt.libertycinema.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;


public class LibertyCinema implements EntryPoint {

    public void onModuleLoad() {
        RootLayoutPanel.get().add(new BaseLayout());
    }
}
