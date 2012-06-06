package com.java.gwt.libertycinema.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.java.gwt.libertycinema.client.services.StaticDataService;
import com.java.gwt.libertycinema.server.models.PMF;
import com.java.gwt.libertycinema.server.models.StaticData;
import com.java.gwt.libertycinema.shared.StaticDataInfo;


@SuppressWarnings("serial")
public class StaticDataServiceImpl extends RemoteServiceServlet implements StaticDataService {

    @Override
    public StaticDataInfo putMenuItem(String menuName, String menuDescription) {
        StaticData data = new StaticData(menuName, menuDescription);
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.makePersistent(data);

        StaticDataInfo sd = new StaticDataInfo();
        sd.setMenuName(menuName);
        sd.setMenuDescription(menuDescription);
        return sd;
    }

    @Override
    public List getAllMenus() {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query q = pm.newQuery(StaticData.class);
        List<StaticData> results = (List<StaticData>) q.execute();
        
        List newResults = new ArrayList();
        for (StaticData r: results) {
            StaticDataInfo sd = new StaticDataInfo();
            sd.setMenuName(r.getMenuName());
            sd.setMenuDescription(r.getMenuDescription());
            newResults.add(sd);
        }
        
        return newResults;
    }

    @Override
    public StaticDataInfo getMenuItem(String menuName) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query q = pm.newQuery(StaticData.class, "menuName == menuNameParam");
        q.declareParameters("String menuNameParam");

        List<StaticData> results = (List<StaticData>) q.execute(menuName);
        StaticData r = results.get(0);

        StaticDataInfo sd = new StaticDataInfo();

        sd.setMenuName(r.getMenuName());
        sd.setMenuDescription(r.getMenuDescription());
        return sd;
    }
}
