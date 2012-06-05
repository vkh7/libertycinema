package com.java.gwt.libertycinema.server;

import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.java.gwt.libertycinema.client.services.StaticDataService;
import com.java.gwt.libertycinema.server.models.PMF;
import com.java.gwt.libertycinema.server.models.StaticData;


@SuppressWarnings("serial")
public class StaticDataServiceImpl extends RemoteServiceServlet implements StaticDataService {

	public String putData(String menuName, String menuDescription) {
	    StaticData data = new StaticData(menuName, menuDescription);
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.makePersistent(data);  
	    return "Success";
	}
}
