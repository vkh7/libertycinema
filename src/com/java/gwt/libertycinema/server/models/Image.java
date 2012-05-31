package com.java.gwt.libertycinema.server.models;


import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

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
    private Date created;

    @Persistent
    private Date updated;

    @Persistent
    private Blob image;

    public Image(String title, String description, Date created, Blob image) {
        this.title = title;
        this.description = description;
	this.created = created;
	this.image = image;
    }

    // Accessors for the fields. JDO doesn't use these, but your application does.

    public Key getKey() {
        return key;
    }

    public byte[] getImage() {
        if (image == null) {
            return null;
        }

        return image.getBytes();
    }

    public void setImage(byte[] bytes) {
        this.image = new Blob(bytes);
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

    public Date getCreated() {
	return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
	return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}