package com.java.gwt.libertycinema.server.models;


import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class GalleryImage {

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
    private Blob thumbnail;

    @Persistent
    private String imageType;

    public GalleryImage(String title, String description, Blob image, String imageType) {
        this.setTitle(title);
        this.setDescription(description);
        this.setImageType(imageType);
        this.setImage(image);
        this.setUpdated(new Date());
        this.setKey(KeyFactory.createKey(GalleryImage.class.getSimpleName(), title));
        updateThumbnail();
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

    public byte[] getThumbnail() {
        if (image == null) {
            return null;
        } else {
            return thumbnail.getBytes();
        }
    }

    public void setThumbnail(Blob thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void updateThumbnail() {
        ImagesService imagesService = ImagesServiceFactory.getImagesService();
        Image oldImage = ImagesServiceFactory.makeImage(getImage());
        Transform resize = ImagesServiceFactory.makeResize(200, 300);
        Image newImage = imagesService.applyTransform(resize, oldImage);
        setThumbnail(new Blob(newImage.getImageData()));
    }
}