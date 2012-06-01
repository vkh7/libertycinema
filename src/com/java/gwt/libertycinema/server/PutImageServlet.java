package com.java.gwt.libertycinema.server;


import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.gwt.libertycinema.server.models.Image;
import com.java.gwt.libertycinema.server.models.PMF;


@SuppressWarnings("serial")
public class PutImageServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        // byte[] bytes = request.getContent();
        
        Image image = new Image();
        image.setTitle(title);
        
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.makePersistent(image);        
    }
}
