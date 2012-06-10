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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String key = request.getParameter("id");
        Boolean thumbnail = Boolean.valueOf(request.getParameter("thumbnail"));
        if (key != null && thumbnail != null) {
            GalleryImage image = getImage(key);
            if (image != null) {
                response.setContentType(image.getImageType());
                if (thumbnail.equals(true)) {
                    response.getOutputStream().write(image.getThumbnail());
                } else {
                    response.getOutputStream().write(image.getImage());
                }
            } else {
                imageNotFound(response);
            }
        } else {
            imageNotFound(response);
        }
    }

    public GalleryImage getImage(String key) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        GalleryImage image = pm.getObjectById(GalleryImage.class, key);
        if (image == null) {
            return null;
        } else {
            return image;
        }
    }

    public void imageNotFound(HttpServletResponse response) throws IOException {
        response.sendRedirect("/static/noimage.png");
    }
}
