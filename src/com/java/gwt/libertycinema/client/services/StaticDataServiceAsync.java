package com.java.gwt.libertycinema.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.java.gwt.libertycinema.shared.StaticDataInfo;


public interface StaticDataServiceAsync {

    void getAllMenus(AsyncCallback<List<StaticDataInfo>> asyncCallback);

    void putMenuItem(String menuName, String menuDescription, AsyncCallback<StaticDataInfo> asyncCallback);

    void getMenuItem(String menuName, AsyncCallback<StaticDataInfo> callback);

}
