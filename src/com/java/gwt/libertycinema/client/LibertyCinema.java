package com.java.gwt.libertycinema.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import com.java.gwt.libertycinema.client.MainPanel;


public class LibertyCinema implements EntryPoint {

    public void onModuleLoad() {
        RootLayoutPanel.get().add(new MainPanel());
    }
}
