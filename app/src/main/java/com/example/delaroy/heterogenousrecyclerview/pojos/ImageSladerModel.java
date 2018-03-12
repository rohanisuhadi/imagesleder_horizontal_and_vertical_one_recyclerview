package com.example.delaroy.heterogenousrecyclerview.pojos;

/**
 * Created by rohani-suhadi on 2/24/2018.
 */

public class ImageSladerModel {

    private String name;
    private String url;

    public ImageSladerModel() {
    }

    public ImageSladerModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
