package com.java.gwt.libertycinema.client.views;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;

public class Login implements Command {

    String loginUrl;

    public Login(String loginUrl) {
        this.loginUrl = loginUrl;
    }
    @Override
    public void execute() {
        Window.open(loginUrl, "_self", "");
    }
}
