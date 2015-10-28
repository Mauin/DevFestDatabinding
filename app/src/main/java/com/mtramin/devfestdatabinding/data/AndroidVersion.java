package com.mtramin.devfestdatabinding.data;

/**
 * TODO: JAVADOC
 */
public class AndroidVersion {
    public String name;
    public int apiLevel;
    public String versionCode;
    public String releaseDate;
    private String imageUrl;


    public AndroidVersion( String name, String versionCode, int apiLevel, String releaseDate, String imageUrl) {
        this.versionCode = versionCode;
        this.releaseDate = releaseDate;
        this.name = name;
        this.imageUrl = imageUrl;
        this.apiLevel = apiLevel;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
