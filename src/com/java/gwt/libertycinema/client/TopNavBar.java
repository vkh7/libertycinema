package com.java.gwt.libertycinema.client;


import java.lang.Throwable;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.java.gwt.libertycinema.client.BodyPanel;
import com.java.gwt.libertycinema.client.services.LoginService;
import com.java.gwt.libertycinema.client.services.LoginServiceAsync;
import com.java.gwt.libertycinema.client.views.HomeLinkCommand;
import com.java.gwt.libertycinema.client.views.ImageUpload;
import com.java.gwt.libertycinema.client.views.StaticPages;
import com.java.gwt.libertycinema.shared.LoginInfo;


public class TopNavBar {

    private BodyPanel body;

    private VerticalPanel headerPanel = new VerticalPanel();
    private final MenuBar menu = new MenuBar();

    public TopNavBar(BodyPanel body) {
        this.body = body;
    }

    private void setUpTopNavButtons() {
        menu.addItem("Home", new HomeLinkCommand(body));
        menu.addItem("Gallery", new HomeLinkCommand(body));
        menu.addItem("Testimonials", new HomeLinkCommand(body));
        menu.addItem("Permissions", new HomeLinkCommand(body));
        menu.addItem("Technical Details", new HomeLinkCommand(body));
        menu.addItem("Contact Us", new HomeLinkCommand(body));

        LoginServiceAsync loginService = GWT.create(LoginService.class);
        loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo> () {
                public void onFailure(Throwable e) {
                    Window.alert("Ajax request failed, couldn't load admin module");
                }

                public void onSuccess(LoginInfo loginInfo) {
                    if(loginInfo.isAdminUser()) {
                        Window.alert(loginInfo.getLoginUrl());
                        menu.addItem("Admin", getAdminMenu());
                    }
                }
            });
        headerPanel.add(menu);
    }

    private void setUpTopNavLogo() {
        Label header = new Label("Liberty Cinema");
        headerPanel.add(header);
    }

    public VerticalPanel getTopBarPanel() {
        setUpTopNavLogo();
        setUpTopNavButtons();
        headerPanel.setWidth("100%");
        headerPanel.setStyleName("topNavDiv");
        return headerPanel;
    }

    private MenuBar getAdminMenu() {
        MenuBar adminMenu = new MenuBar(true);
        adminMenu.addItem("Static Pages", new StaticPages(body));
        adminMenu.addItem("Images", new ImageUpload(body));
        return adminMenu;
    }
}