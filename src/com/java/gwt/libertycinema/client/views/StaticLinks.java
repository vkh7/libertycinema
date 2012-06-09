package com.java.gwt.libertycinema.client.views;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.java.gwt.libertycinema.client.BaseLayout;
import com.java.gwt.libertycinema.client.services.StaticDataService;
import com.java.gwt.libertycinema.client.services.StaticDataServiceAsync;
import com.java.gwt.libertycinema.shared.StaticDataInfo;


public class StaticLinks implements Command {

    BaseLayout baseLayout;

    public StaticLinks(BaseLayout baseLayout) {
        this.baseLayout = baseLayout;
    }

    public void execute() {
        // baseLayout.getMainPanel().clear();
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
                // baseLayout.add(new HTML(data.getMenuDescription()));
            }
        });
    }
}