package com.share.domain;

import java.util.Date;
import java.util.List;

public class Dynamic {
    private long id;
    private long userId;
    private String imagePath;
    private String imageDescription;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Dynamic{" +
                "id=" + id +
                ", userId=" + userId +
                ", imagePath='" + imagePath + '\'' +
                ", imageDescription='" + imageDescription + '\'' +
                ", date=" + date +
                '}';
    }
}
