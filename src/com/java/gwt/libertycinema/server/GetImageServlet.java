package com.java.gwt.libertycinema.server;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.gwt.libertycinema.server.models.Image;
import com.java.gwt.libertycinema.server.models.PMF;

@SuppressWarnings("serial")
public class GetImageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        if (title != null) {
            PersistenceManager pm = PMF.get().getPersistenceManager();
            Image image = pm.getObjectById(Image.class, title);
            if (image != null) {
                response.setContentType(image.getImageType());
                response.getOutputStream().write(image.getImage());
            } else {
                response.sendRedirect("/static/noimage.png");
            }
        } else {
            response.sendRedirect("/static/noimage.png");
        }
    }
}
