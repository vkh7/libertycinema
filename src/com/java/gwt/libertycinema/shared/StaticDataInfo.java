package com.java.gwt.libertycinema.shared;

import java.io.Serializable;
import java.util.Date;

public class StaticDataInfo implements Serializable {

    private String menuName;
    private String menuDescription;
    private Date lastUpdated;
    
    public String getMenuName() {
        return menuName;
    }
    
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    
    public String getMenuDescription() {
        return menuDescription;
    }
    
    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }    
}
