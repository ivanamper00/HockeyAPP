package com.ivandeveloper.hockeyapp.Model;

import com.google.gson.annotations.SerializedName;

public class PlayerStatsModel {
    @SerializedName("StatID")
    private Integer statID;
    @SerializedName("TeamID")
    private Integer teamID;
    @SerializedName("PlayerID")
    private Integer playerID;
    @SerializedName("SeasonType")
    private Integer seasonType;
    @SerializedName("Season")
    private Integer season;
    @SerializedName("Name")
    private String name;
    @SerializedName("Team")
    private String team;
    @SerializedName("Position")
    private String position;
    @SerializedName("GlobalTeamID")
    private Integer globalTeamID;
    @SerializedName("Updated")
    private String updated;
    @SerializedName("Games")
    private Integer games;
    @SerializedName("FantasyPoints")
    private Double fantasyPoints;
    @SerializedName("FantasyPointsFanDuel")
    private Double fantasyPointsFanDuel;
    @SerializedName("FantasyPointsDraftKings")
    private Double fantasyPointsDraftKings;
    @SerializedName("FantasyPointsYahoo")
    private Double fantasyPointsYahoo;
    @SerializedName("Minutes")
    private Integer minutes;
    @SerializedName("Seconds")
    private Integer seconds;
    @SerializedName("Goals")
    private Double goals;
    @SerializedName("Assists")
    private Double assists;
    @SerializedName("ShotsOnGoal")
    private Double shotsOnGoal;
    @SerializedName("PowerPlayGoals")
    private Double powerPlayGoals;
    @SerializedName("ShortHandedGoals")
    private Double shortHandedGoals;
    @SerializedName("EmptyNetGoals")
    private Double emptyNetGoals;
    @SerializedName("PowerPlayAssists")
    private Double powerPlayAssists;
    @SerializedName("ShortHandedAssists")
    private Double shortHandedAssists;
    @SerializedName("HatTricks")
    private Double hatTricks;
    @SerializedName("ShootoutGoals")
    private Double shootoutGoals;
    @SerializedName("PlusMinus")
    private Double plusMinus;
    @SerializedName("PenaltyMinutes")
    private Double penaltyMinutes;
    @SerializedName("Blocks")
    private Double blocks;
    @SerializedName("Hits")
    private Double hits;
    @SerializedName("Takeaways")
    private Double takeaways;
    @SerializedName("Giveaways")
    private Double giveaways;
    @SerializedName("FaceoffsWon")
    private Double faceoffsWon;
    @SerializedName("FaceoffsLost")
    private Double faceoffsLost;
    @SerializedName("Shifts")
    private Double shifts;
    @SerializedName("GoaltendingMinutes")
    private Integer goaltendingMinutes;
    @SerializedName("GoaltendingSeconds")
    private Integer goaltendingSeconds;
    @SerializedName("GoaltendingShotsAgainst")
    private Double goaltendingShotsAgainst;
    @SerializedName("GoaltendingGoalsAgainst")
    private Double goaltendingGoalsAgainst;
    @SerializedName("GoaltendingSaves")
    private Double goaltendingSaves;
    @SerializedName("GoaltendingWins")
    private Double goaltendingWins;
    @SerializedName("GoaltendingLosses")
    private Double goaltendingLosses;
    @SerializedName("GoaltendingShutouts")
    private Double goaltendingShutouts;
    @SerializedName("Started")
    private Integer started;
    @SerializedName("BenchPenaltyMinutes")
    private String benchPenaltyMinutes;
    @SerializedName("GoaltendingOvertimeLosses")
    private Double goaltendingOvertimeLosses;
    @SerializedName("FantasyPointsFantasyDraft")
    private Double fantasyPointsFantasyDraft;
    String playerPic;
    String playerTeamPic;

    public PlayerStatsModel(String name, String team, String position, Integer minutes, Integer seconds, Double goals, Double assists, Double shotsOnGoal, Double powerPlayGoals, Double shortHandedGoals, Double emptyNetGoals, Double powerPlayAssists, Double shortHandedAssists, Double hatTricks, Double shootoutGoals, Double plusMinus, Double penaltyMinutes, Double blocks, Double hits, Double takeaways, Double giveaways, Double faceoffsWon, Double faceoffsLost, Integer goaltendingMinutes, Integer goaltendingSeconds, Double goaltendingShotsAgainst, Double goaltendingGoalsAgainst, Double goaltendingSaves, Double goaltendingWins, Double goaltendingLosses, Double goaltendingShutouts, Integer started, String benchPenaltyMinutes, String playerPic , String playerTeamPic) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.minutes = minutes;
        this.seconds = seconds;
        this.goals = goals;
        this.assists = assists;
        this.shotsOnGoal = shotsOnGoal;
        this.powerPlayGoals = powerPlayGoals;
        this.shortHandedGoals = shortHandedGoals;
        this.emptyNetGoals = emptyNetGoals;
        this.powerPlayAssists = powerPlayAssists;
        this.shortHandedAssists = shortHandedAssists;
        this.hatTricks = hatTricks;
        this.shootoutGoals = shootoutGoals;
        this.plusMinus = plusMinus;
        this.penaltyMinutes = penaltyMinutes;
        this.blocks = blocks;
        this.hits = hits;
        this.takeaways = takeaways;
        this.giveaways = giveaways;
        this.faceoffsWon = faceoffsWon;
        this.faceoffsLost = faceoffsLost;
        this.goaltendingMinutes = goaltendingMinutes;
        this.goaltendingSeconds = goaltendingSeconds;
        this.goaltendingShotsAgainst = goaltendingShotsAgainst;
        this.goaltendingGoalsAgainst = goaltendingGoalsAgainst;
        this.goaltendingSaves = goaltendingSaves;
        this.goaltendingWins = goaltendingWins;
        this.goaltendingLosses = goaltendingLosses;
        this.goaltendingShutouts = goaltendingShutouts;
        this.started = started;
        this.benchPenaltyMinutes = benchPenaltyMinutes;
        this.playerPic = playerPic;
        this.playerTeamPic = playerTeamPic;
    }


    public Integer getStatID() {
        return statID;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public Integer getPlayerID() {
        return playerID;
    }

    public Integer getSeasonType() {
        return seasonType;
    }

    public Integer getSeason() {
        return season;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public Integer getGlobalTeamID() {
        return globalTeamID;
    }

    public String getUpdated() {
        return updated;
    }

    public Integer getGames() {
        return games;
    }

    public Double getFantasyPoints() {
        return fantasyPoints;
    }

    public Double getFantasyPointsFanDuel() {
        return fantasyPointsFanDuel;
    }

    public Double getFantasyPointsDraftKings() {
        return fantasyPointsDraftKings;
    }

    public Double getFantasyPointsYahoo() {
        return fantasyPointsYahoo;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public Double getGoals() {
        return goals;
    }

    public Double getAssists() {
        return assists;
    }

    public Double getShotsOnGoal() {
        return shotsOnGoal;
    }

    public Double getPowerPlayGoals() {
        return powerPlayGoals;
    }

    public Double getShortHandedGoals() {
        return shortHandedGoals;
    }

    public Double getEmptyNetGoals() {
        return emptyNetGoals;
    }

    public Double getPowerPlayAssists() {
        return powerPlayAssists;
    }

    public Double getShortHandedAssists() {
        return shortHandedAssists;
    }

    public Double getHatTricks() {
        return hatTricks;
    }

    public Double getShootoutGoals() {
        return shootoutGoals;
    }

    public Double getPlusMinus() {
        return plusMinus;
    }

    public Double getPenaltyMinutes() {
        return penaltyMinutes;
    }

    public Double getBlocks() {
        return blocks;
    }

    public Double getHits() {
        return hits;
    }

    public Double getTakeaways() {
        return takeaways;
    }

    public Double getGiveaways() {
        return giveaways;
    }

    public Double getFaceoffsWon() {
        return faceoffsWon;
    }

    public Double getFaceoffsLost() {
        return faceoffsLost;
    }

    public Double getShifts() {
        return shifts;
    }

    public Integer getGoaltendingMinutes() {
        return goaltendingMinutes;
    }

    public Integer getGoaltendingSeconds() {
        return goaltendingSeconds;
    }

    public Double getGoaltendingShotsAgainst() {
        return goaltendingShotsAgainst;
    }

    public Double getGoaltendingGoalsAgainst() {
        return goaltendingGoalsAgainst;
    }

    public Double getGoaltendingSaves() {
        return goaltendingSaves;
    }

    public Double getGoaltendingWins() {
        return goaltendingWins;
    }

    public Double getGoaltendingLosses() {
        return goaltendingLosses;
    }

    public Double getGoaltendingShutouts() {
        return goaltendingShutouts;
    }

    public Integer getStarted() {
        return started;
    }

    public String getBenchPenaltyMinutes() {
        return benchPenaltyMinutes;
    }

    public Double getGoaltendingOvertimeLosses() {
        return goaltendingOvertimeLosses;
    }

    public Double getFantasyPointsFantasyDraft() {
        return fantasyPointsFantasyDraft;
    }

    public String getPlayerPic() {
        return playerPic;
    }

    public String getPlayerTeamPic() {
        return playerTeamPic;
    }
}
