package com.java.gwt.libertycinema.client.views;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;

public class Logout implements Command {

    String logoutUrl;

    public Logout(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }
    @Override
    public void execute() {
        Window.Location.assign(logoutUrl);
    }
}
