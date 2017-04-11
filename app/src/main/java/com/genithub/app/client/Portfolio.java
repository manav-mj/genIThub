package com.genithub.app.client;

/**
 * Created by YourFather on 11-04-2017.
 */

public class Portfolio {
    String name;
    String type;
    String imgUrl;
    String projectLink;

    public Portfolio(String name, String type, String imgUrl, String projectLink) {
        this.name = name;
        this.type = type;
        this.imgUrl = imgUrl;
        this.projectLink = projectLink;
    }
}
