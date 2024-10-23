package com.example.fetchlinkapi.model;

public class LinkPreview {
    private String url;
    private String title;
    private String mainPhoto;
    private String subtitle;
    private String price;
    private String logo;
    private String description;


    public LinkPreview(String url, String title, String mainPhoto, String subtitle, String price, String logo, String description) {
        this.url = url;
        this.title = title;
        this.mainPhoto = mainPhoto;
        this.subtitle = subtitle;
        this.price = price;
        this.logo = logo;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
