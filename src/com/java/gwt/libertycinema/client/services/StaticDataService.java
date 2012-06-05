package com.java.gwt.libertycinema.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("staticdata")
public interface StaticDataService extends RemoteService {
    
    public String putData(String menuName, String menuDescription);
}