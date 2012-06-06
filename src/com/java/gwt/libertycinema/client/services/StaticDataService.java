package com.java.gwt.libertycinema.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.java.gwt.libertycinema.shared.StaticDataInfo;


@RemoteServiceRelativePath("staticdata")
public interface StaticDataService extends RemoteService {
    
    public StaticDataInfo putMenuItem(String menuName, String menuDescription);
    
    public List<StaticDataInfo> getAllMenus();
    
    public StaticDataInfo getMenuItem(String menuName);
    
}