package com.java.gwt.libertycinema.server;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.gwt.libertycinema.server.models.GalleryImage;
import com.java.gwt.libertycinema.server.models.PMF;

@SuppressWarnings("serial")
public class GetImageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key = request.getParameter("id");
        if (key != null) {
            PersistenceManager pm = PMF.get().getPersistenceManager();
            GalleryImage image = pm.getObjectById(GalleryImage.class, key);
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
