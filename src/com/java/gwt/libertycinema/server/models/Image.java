package com.java.gwt.libertycinema.server.models;


import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Image {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String title;

    @Persistent
    private String description;

    @Persistent
    private Date updated;

    @Persistent
    private Blob image;

    @Persistent
    private String imageType;

    public Image(String title, String description, Blob image, String imageType) {
        this.setTitle(title);
        this.setDescription(description);
        this.setImageType(imageType);
        this.setImage(image);
        this.setUpdated(new Date());
        this.setKey(KeyFactory.createKey(Image.class.getSimpleName(), title));
    }

    // Accessors for the fields. JDO doesn't use these, but your application does.
    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public byte[] getImage() {
        if (image == null) {
            return null;
        } else {
            return image.getBytes();
        }
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}