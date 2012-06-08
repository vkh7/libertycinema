package com.java.gwt.libertycinema.client;


import java.lang.Throwable;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.java.gwt.libertycinema.client.MainPanel;
import com.java.gwt.libertycinema.client.services.LoginService;
import com.java.gwt.libertycinema.client.services.LoginServiceAsync;
import com.java.gwt.libertycinema.client.views.HomeLinkCommand;
import com.java.gwt.libertycinema.client.views.ImageUpload;
import com.java.gwt.libertycinema.client.views.StaticPages;
import com.java.gwt.libertycinema.shared.LoginInfo;


public class HeaderBar extends Composite {

    private VerticalPanel headerPanel = new VerticalPanel();
    private Label mainLogo = new Label("Liberty Cinema - Mumbai");
    private final MenuBar mainMenu = new MenuBar();
    private MenuBar adminMenu = new MenuBar(true);

    private MainPanel mainPanel;

    public HeaderBar(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        setUpMainMenu();
        headerPanel.add(mainLogo);
        headerPanel.add(mainMenu);
        headerPanel.setWidth("100%");
        headerPanel.setStyleName("topNavDiv");
        initWidget(headerPanel);
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public VerticalPanel getHeaderPanel() {
        return headerPanel;
    }

    public void setHeaderPanel(VerticalPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public Label getMainLogo() {
        return mainLogo;
    }

    public void setMainLogo(Label mainLogo) {
        this.mainLogo = mainLogo;
    }

    public MenuBar getMainMenu() {
        return mainMenu;
    }

    public void setAdminMenu(MenuBar adminMenu) {
        this.adminMenu = adminMenu;
    }

    private MenuBar getAdminMenu() {
        return adminMenu;
    }

    private void setUpMainMenu() {
        mainMenu.addItem("Home", new HomeLinkCommand(mainPanel));
        mainMenu.addItem("Gallery", new HomeLinkCommand(mainPanel));
        mainMenu.addItem("Testimonials", new HomeLinkCommand(mainPanel));
        mainMenu.addItem("Permissions", new HomeLinkCommand(mainPanel));
        mainMenu.addItem("Technical Details", new HomeLinkCommand(mainPanel));;
        mainMenu.addItem("Contact Us", new HomeLinkCommand(mainPanel));
        mainMenu.addItem("Login", new HomeLinkCommand(mainPanel));

        LoginServiceAsync loginService = GWT.create(LoginService.class);
        loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo> () {
                public void onFailure(Throwable e) {
                    Window.alert("Ajax request failed, couldn't load admin module");
                }

                public void onSuccess(LoginInfo loginInfo) {
                    if(loginInfo.isAdminUser()) {
                        setUpAdminMenu();
                        mainMenu.addItem("Admin", getAdminMenu());
                    }
                }
            });
    }

    private void setUpAdminMenu() {
        adminMenu.addItem("Static Pages", new StaticPages(mainPanel));
        adminMenu.addItem("Images", new ImageUpload(mainPanel));
    }
}