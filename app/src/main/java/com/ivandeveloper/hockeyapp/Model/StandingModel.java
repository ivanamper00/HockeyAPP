package com.ivandeveloper.hockeyapp.Model;

import com.google.gson.annotations.SerializedName;

public class StandingModel {
    @SerializedName("Season")
    private Integer season;
    @SerializedName("SeasonType")
    private Integer seasonType;
    @SerializedName("TeamID")
    private Integer teamID;
    @SerializedName("Key")
    private String key;
    @SerializedName("City")
    private String city;
    @SerializedName("Name")
    private String name;
    @SerializedName("Conference")
    private String conference;
    @SerializedName("Division")
    private String division;
    @SerializedName("Wins")
    private Integer wins;
    @SerializedName("Losses")
    private Integer losses;
    @SerializedName("OvertimeLosses")
    private Integer overtimeLosses;
    @SerializedName("Percentage")
    private Double percentage;
    @SerializedName("ConferenceWins")
    private Integer conferenceWins;
    @SerializedName("ConferenceLosses")
    private Integer conferenceLosses;
    @SerializedName("DivisionWins")
    private Integer divisionWins;
    @SerializedName("DivisionLosses")
    private Integer divisionLosses;
    @SerializedName("ShutoutWins")
    private Integer shutoutWins;
    @SerializedName("GlobalTeamID")
    private Integer globalTeamID;
    private String teamPicture;

    public StandingModel(Integer season, Integer seasonType, Integer teamID, String key, String city, String name, String conference, String division, Integer wins, Integer losses, Integer overtimeLosses, Double percentage, Integer conferenceWins, Integer conferenceLosses, Integer divisionWins, Integer divisionLosses, Integer shutoutWins, Integer globalTeamID) {
        this.season = season;
        this.seasonType = seasonType;
        this.teamID = teamID;
        this.key = key;
        this.city = city;
        this.name = name;
        this.conference = conference;
        this.division = division;
        this.wins = wins;
        this.losses = losses;
        this.overtimeLosses = overtimeLosses;
        this.percentage = percentage;
        this.conferenceWins = conferenceWins;
        this.conferenceLosses = conferenceLosses;
        this.divisionWins = divisionWins;
        this.divisionLosses = divisionLosses;
        this.shutoutWins = shutoutWins;
        this.globalTeamID = globalTeamID;
    }

    public StandingModel(Integer season, Integer seasonType, Integer teamID, String key, String city, String name, String conference, String division, Integer wins, Integer losses, Integer overtimeLosses, Double percentage, Integer conferenceWins, Integer conferenceLosses, Integer divisionWins, Integer divisionLosses, Integer shutoutWins, Integer globalTeamID, String teamPicture) {
        this.season = season;
        this.seasonType = seasonType;
        this.teamID = teamID;
        this.key = key;
        this.city = city;
        this.name = name;
        this.conference = conference;
        this.division = division;
        this.wins = wins;
        this.losses = losses;
        this.overtimeLosses = overtimeLosses;
        this.percentage = percentage;
        this.conferenceWins = conferenceWins;
        this.conferenceLosses = conferenceLosses;
        this.divisionWins = divisionWins;
        this.divisionLosses = divisionLosses;
        this.shutoutWins = shutoutWins;
        this.globalTeamID = globalTeamID;
        this.teamPicture = teamPicture;
    }

    public StandingModel(String key, String name, String conference, String division, Integer wins, Integer losses) {
        this.key = key;
        this.name = name;
        this.conference = conference;
        this.division = division;
        this.wins = wins;
        this.losses = losses;
    }

    public StandingModel(String key, String name, String conference, String division, Integer wins, Integer losses, String teamPicture, int season) {
        this.key = key;
        this.name = name;
        this.conference = conference;
        this.division = division;
        this.wins = wins;
        this.losses = losses;
        this.teamPicture = teamPicture;
        this.season = season;
    }

    public String getTeamPicture() {
        return teamPicture;
    }

    public Integer getSeason() {
        return season;
    }

    public Integer getSeasonType() {
        return seasonType;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public String getKey() {
        return key;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getConference() {
        return conference;
    }

    public String getDivision() {
        return division;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public Integer getOvertimeLosses() {
        return overtimeLosses;
    }

    public Double getPercentage() {
        return percentage;
    }

    public Integer getConferenceWins() {
        return conferenceWins;
    }

    public Integer getConferenceLosses() {
        return conferenceLosses;
    }

    public Integer getDivisionWins() {
        return divisionWins;
    }

    public Integer getDivisionLosses() {
        return divisionLosses;
    }

    public Integer getShutoutWins() {
        return shutoutWins;
    }

    public Integer getGlobalTeamID() {
        return globalTeamID;
    }
}
