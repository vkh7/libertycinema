package com.java.gwt.libertycinema.client.views;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;

import com.java.gwt.libertycinema.client.MainPanel;
import com.java.gwt.libertycinema.client.services.StaticDataService;
import com.java.gwt.libertycinema.client.services.StaticDataServiceAsync;
import com.java.gwt.libertycinema.shared.StaticDataInfo;


public class HomeLinkCommand implements Command {

    MainPanel body;

    public HomeLinkCommand(MainPanel body) {
        this.body = body;
    }

    public void execute() {
        body.getMainPanel().clear();
        getHomeScreenData();
    }

    public void getHomeScreenData() {
        StaticDataServiceAsync sdService =
                (StaticDataServiceAsync) GWT.create(StaticDataService.class);
        sdService.getMenuItem("Home", new AsyncCallback<StaticDataInfo> () {
            public void onFailure(Throwable caught) {
                Window.alert(caught.toString());
            }

            public void onSuccess(StaticDataInfo data) {
                body.add(new HTML(data.getMenuDescription()));
            }
        });
    }
}