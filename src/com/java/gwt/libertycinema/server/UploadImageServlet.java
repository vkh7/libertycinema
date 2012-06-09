package com.java.gwt.libertycinema.server;


import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.IOUtils;

import com.google.appengine.api.datastore.Blob;
import com.java.gwt.libertycinema.server.models.Image;
import com.java.gwt.libertycinema.server.models.PMF;


@SuppressWarnings("serial")
public class UploadImageServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String title = null;
        String description = null;
        Blob imageBlob = null; 

        ServletFileUpload upload = new ServletFileUpload();
        FileItemIterator iter;
        try {
            iter = upload.getItemIterator(request);
            while (iter.hasNext()) {
                FileItemStream item = iter.next();
                if (!item.isFormField() && item.getFieldName() == "image") {
                    imageBlob = new Blob(IOUtils.toByteArray(item.openStream()));
                } else if (item.isFormField() && item.getFieldName() == "title") {
                    title = Streams.asString(item.openStream());
                } else if (item.isFormField() && item.getFieldName() == "description") {
                    description = Streams.asString(item.openStream());
                }
            }

            Image image = new Image(title, description, imageBlob);
            PersistenceManager pm = PMF.get().getPersistenceManager();
            pm.makePersistent(image);
            pm.close();

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}