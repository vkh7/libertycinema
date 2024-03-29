package com.java.gwt.libertycinema.server.models;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


@PersistenceCapable
public class StaticData {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
    
    @Persistent
    private String menuName;

    @Persistent
    private String menuDescription;
    
    @Persistent
    private Date lastUpdated;
    
    public StaticData(String menuName, String menuDescription) {
        this.menuName = menuName;
        this.menuDescription = menuDescription;
        this.setLastUpdated(new Date());
        this.setKey(KeyFactory.createKey(StaticData.class.getSimpleName(), menuName));
    }

    // Accessors for the fields. JDO doesn't use these, but your application does.
    public String getMenuName() {
        return menuName;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}