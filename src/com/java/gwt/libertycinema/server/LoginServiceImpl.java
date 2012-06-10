package com.java.gwt.libertycinema.server;


import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.java.gwt.libertycinema.shared.LoginInfo;
import com.java.gwt.libertycinema.client.services.LoginService;


public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

    public LoginInfo login(String requestUri) {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        LoginInfo loginInfo = new LoginInfo();

        if (user != null) {
            loginInfo.setLoggedIn(true);
            loginInfo.setEmailAddress(user.getEmail());
            loginInfo.setNickname(user.getNickname());
            loginInfo.setAdminUser(userService.isUserAdmin());
        } else {
            loginInfo.setLoggedIn(false);
            loginInfo.setAdminUser(false);
        }

        loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
        loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
        return loginInfo;
    }
}
