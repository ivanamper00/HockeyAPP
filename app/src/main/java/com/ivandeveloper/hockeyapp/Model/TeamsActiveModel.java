package com.ivandeveloper.hockeyapp.Model;

import com.google.gson.annotations.SerializedName;

public class TeamsActiveModel {
    @SerializedName("TeamID")
    private int teamID;
    @SerializedName("Key")
    private String key;
    @SerializedName("Active")
    private Boolean active;
    @SerializedName("City")
    private String city;
    @SerializedName("Name")
    private String name;
    @SerializedName("StadiumID")
    private int stadiumID;
    @SerializedName("Conference")
    private String conference;
    @SerializedName("Division")
    private String division;
    @SerializedName("PrimaryColor")
    private String primaryColor;
    @SerializedName("SecondaryColor")
    private String secondaryColor;
    @SerializedName("TertiaryColor")
    private String tertiaryColor;
    @SerializedName("QuaternaryColor")
    private String quaternaryColor;
    @SerializedName("WikipediaLogoUrl")
    private String wikipediaLogoUrl;
    @SerializedName("WikipediaWordMarkUrl")
    private String wikipediaWordMarkUrl;
    @SerializedName("GlobalTeamID")
    private int globalTeamID;

    public TeamsActiveModel(int teamID, String key, Boolean active, String city, String name, int stadiumID, String conference, String division, String primaryColor, String secondaryColor, String tertiaryColor, String quaternaryColor, String wikipediaLogoUrl, String wikipediaWordMarkUrl, int globalTeamID) {
        this.teamID = teamID;
        this.key = key;
        this.active = active;
        this.city = city;
        this.name = name;
        this.stadiumID = stadiumID;
        this.conference = conference;
        this.division = division;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.tertiaryColor = tertiaryColor;
        this.quaternaryColor = quaternaryColor;
        this.wikipediaLogoUrl = wikipediaLogoUrl;
        this.wikipediaWordMarkUrl = wikipediaWordMarkUrl;
        this.globalTeamID = globalTeamID;
    }

    public TeamsActiveModel(String key, String wikipediaLogoUrl) {
        this.key = key;
        this.wikipediaLogoUrl = wikipediaLogoUrl;
    }

    public TeamsActiveModel(String key, String name, String conference, String division, String primaryColor, String secondaryColor, String tertiaryColor, String wikipediaLogoUrl, String city) {
        this.key = key;
        this.name = name;
        this.conference = conference;
        this.division = division;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.tertiaryColor = tertiaryColor;
        this.wikipediaLogoUrl = wikipediaLogoUrl;
        this.city = city;
    }

    public TeamsActiveModel(String primaryColor, String secondaryColor, String tertiaryColor) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.tertiaryColor = tertiaryColor;
    }

    public int getTeamID() {
        return teamID;
    }

    public String getKey() {
        return key;
    }

    public Boolean getActive() {
        return active;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public int getStadiumID() {
        return stadiumID;
    }

    public String getConference() {
        return conference;
    }

    public String getDivision() {
        return division;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public String getTertiaryColor() {
        return tertiaryColor;
    }

    public String getQuaternaryColor() {
        return quaternaryColor;
    }

    public String getWikipediaLogoUrl() {
        return wikipediaLogoUrl;
    }

    public String getWikipediaWordMarkUrl() {
        return wikipediaWordMarkUrl;
    }

    public int getGlobalTeamID() {
        return globalTeamID;
    }
}
