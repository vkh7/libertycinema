package com.java.gwt.libertycinema.client.services;


import com.google.gwt.user.client.rpc.AsyncCallback;

import com.java.gwt.libertycinema.shared.LoginInfo;


public interface LoginServiceAsync {
  public void login(String requestUri, AsyncCallback<LoginInfo> async);
}