package com.java.gwt.libertycinema.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface StaticDataServiceAsync {

    void putData(String menuName, String menuDescription, AsyncCallback<String> callback);

}
