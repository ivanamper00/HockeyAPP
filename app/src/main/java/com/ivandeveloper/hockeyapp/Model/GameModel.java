package com.ivandeveloper.hockeyapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameModel {
    @SerializedName("GameID")
    private int gameID;
    @SerializedName("Season")
    private int season;
    @SerializedName("SeasonType")
    private int seasonType;
    @SerializedName("Status")
    private String status;
    @SerializedName("Day")
    private String day;
    @SerializedName("DateTime")
    private String dateTime;
    @SerializedName("Updated")
    private String updated;
    @SerializedName("IsClosed")
    private Boolean isClosed;
    @SerializedName("AwayTeam")
    private String awayTeam;
    @SerializedName("HomeTeam")
    private String homeTeam;
    @SerializedName("AwayTeamID")
    private int awayTeamID;
    @SerializedName("HomeTeamID")
    private int homeTeamID;
    @SerializedName("StadiumID")
    private int stadiumID;
    @SerializedName("Channel")
    private String channel;
    @SerializedName("Attendance")
    private Object attendance;
    @SerializedName("AwayTeamScore")
    private int awayTeamScore;
    @SerializedName("HomeTeamScore")
    private int homeTeamScore;
    @SerializedName("Period")
    private Object period;
    @SerializedName("TimeRemainingMinutes")
    private Object timeRemainingMinutes;
    @SerializedName("TimeRemainingSeconds")
    private Object timeRemainingSeconds;
    @SerializedName("AwayTeamMoneyLine")
    private int awayTeamMoneyLine;
    @SerializedName("HomeTeamMoneyLine")
    private int homeTeamMoneyLine;
    @SerializedName("PointSpread")
    private Double pointSpread;
    @SerializedName("OverUnder")
    private Double overUnder;
    @SerializedName("GlobalGameID")
    private int globalGameID;
    @SerializedName("GlobalAwayTeamID")
    private int globalAwayTeamID;
    @SerializedName("GlobalHomeTeamID")
    private int globalHomeTeamID;
    @SerializedName("PointSpreadAwayTeamMoneyLine")
    private int pointSpreadAwayTeamMoneyLine;
    @SerializedName("PointSpreadHomeTeamMoneyLine")
    private int pointSpreadHomeTeamMoneyLine;
    @SerializedName("LastPlay")
    private Object lastPlay;
    @SerializedName("GameEndDateTime")
    private String gameEndDateTime;
    @SerializedName("HomeRotationNumber")
    private Object homeRotationNumber;
    @SerializedName("AwayRotationNumber")
    private Object awayRotationNumber;
    @SerializedName("NeutralVenue")
    private Object neutralVenue;
    @SerializedName("Periods")
    private List<Object> periods = null;

    public GameModel(int gameID, int season, int seasonType, String status, String day, String dateTime, String updated, Boolean isClosed, String awayTeam, String homeTeam, int awayTeamID, int homeTeamID, int stadiumID, String channel, Object attendance, int awayTeamScore, int homeTeamScore, Object period, Object timeRemainingMinutes, Object timeRemainingSeconds, int awayTeamMoneyLine, int homeTeamMoneyLine, Double pointSpread, Double overUnder, int globalGameID, int globalAwayTeamID, int globalHomeTeamID, int pointSpreadAwayTeamMoneyLine, int pointSpreadHomeTeamMoneyLine, Object lastPlay, String gameEndDateTime, Object homeRotationNumber, Object awayRotationNumber, Object neutralVenue, List<Object> periods) {
        this.gameID = gameID;
        this.season = season;
        this.seasonType = seasonType;
        this.status = status;
        this.day = day;
        this.dateTime = dateTime;
        this.updated = updated;
        this.isClosed = isClosed;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.awayTeamID = awayTeamID;
        this.homeTeamID = homeTeamID;
        this.stadiumID = stadiumID;
        this.channel = channel;
        this.attendance = attendance;
        this.awayTeamScore = awayTeamScore;
        this.homeTeamScore = homeTeamScore;
        this.period = period;
        this.timeRemainingMinutes = timeRemainingMinutes;
        this.timeRemainingSeconds = timeRemainingSeconds;
        this.awayTeamMoneyLine = awayTeamMoneyLine;
        this.homeTeamMoneyLine = homeTeamMoneyLine;
        this.pointSpread = pointSpread;
        this.overUnder = overUnder;
        this.globalGameID = globalGameID;
        this.globalAwayTeamID = globalAwayTeamID;
        this.globalHomeTeamID = globalHomeTeamID;
        this.pointSpreadAwayTeamMoneyLine = pointSpreadAwayTeamMoneyLine;
        this.pointSpreadHomeTeamMoneyLine = pointSpreadHomeTeamMoneyLine;
        this.lastPlay = lastPlay;
        this.gameEndDateTime = gameEndDateTime;
        this.homeRotationNumber = homeRotationNumber;
        this.awayRotationNumber = awayRotationNumber;
        this.neutralVenue = neutralVenue;
        this.periods = periods;
    }

    public GameModel(int gameID, int season, String day, String awayTeam, String homeTeam, int awayTeamID, int homeTeamID, int awayTeamScore, int homeTeamScore) {
        this.gameID = gameID;
        this.season = season;
        this.day = day;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.awayTeamID = awayTeamID;
        this.homeTeamID = homeTeamID;
        this.awayTeamScore = awayTeamScore;
        this.homeTeamScore = homeTeamScore;
    }

    public int getGameID() {
        return gameID;
    }

    public int getSeason() {
        return season;
    }

    public int getSeasonType() {
        return seasonType;
    }

    public String getStatus() {
        return status;
    }

    public String getDay() {
        return day;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getUpdated() {
        return updated;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getAwayTeamID() {
        return awayTeamID;
    }

    public int getHomeTeamID() {
        return homeTeamID;
    }

    public int getStadiumID() {
        return stadiumID;
    }

    public String getChannel() {
        return channel;
    }

    public Object getAttendance() {
        return attendance;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public Object getPeriod() {
        return period;
    }

    public Object getTimeRemainingMinutes() {
        return timeRemainingMinutes;
    }

    public Object getTimeRemainingSeconds() {
        return timeRemainingSeconds;
    }

    public int getAwayTeamMoneyLine() {
        return awayTeamMoneyLine;
    }

    public int getHomeTeamMoneyLine() {
        return homeTeamMoneyLine;
    }

    public Double getPointSpread() {
        return pointSpread;
    }

    public Double getOverUnder() {
        return overUnder;
    }

    public int getGlobalGameID() {
        return globalGameID;
    }

    public int getGlobalAwayTeamID() {
        return globalAwayTeamID;
    }

    public int getGlobalHomeTeamID() {
        return globalHomeTeamID;
    }

    public int getPointSpreadAwayTeamMoneyLine() {
        return pointSpreadAwayTeamMoneyLine;
    }

    public int getPointSpreadHomeTeamMoneyLine() {
        return pointSpreadHomeTeamMoneyLine;
    }

    public Object getLastPlay() {
        return lastPlay;
    }

    public String getGameEndDateTime() {
        return gameEndDateTime;
    }

    public Object getHomeRotationNumber() {
        return homeRotationNumber;
    }

    public Object getAwayRotationNumber() {
        return awayRotationNumber;
    }

    public Object getNeutralVenue() {
        return neutralVenue;
    }

    public List<Object> getPeriods() {
        return periods;
    }

    public class CurrentGame{
        boolean isGameOngoing;

        public CurrentGame(boolean isGameOngoing) {
            this.isGameOngoing = isGameOngoing;
        }
        public boolean isGameOngoing() {
            return isGameOngoing;
        }
    }
}

