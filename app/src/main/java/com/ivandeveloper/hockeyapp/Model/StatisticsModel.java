package com.ivandeveloper.hockeyapp.Model;

import com.google.gson.annotations.SerializedName;

public class StatisticsModel {
    @SerializedName("StatID")
    private String statID;
    @SerializedName("TeamID")
    private String teamID;
    @SerializedName("SeasonType")
    private String seasonType;
    @SerializedName("Season")
    private String season;
    @SerializedName("Name")
    private String name;
    @SerializedName("Team")
    private String team;
    @SerializedName("Wins")
    private String wins;
    @SerializedName("Losses")
    private String losses;
    @SerializedName("OvertimeLosses")
    private String overtimeLosses;
    @SerializedName("OpponentPosition")
    private Object opponentPosition;
    @SerializedName("GlobalTeamID")
    private String globalTeamID;
    @SerializedName("Updated")
    private String updated;
    @SerializedName("Games")
    private String games;
    @SerializedName("FantasyPoints")
    private Double fantasyPoints;
    @SerializedName("FantasyPointsFanDuel")
    private Double fantasyPointsFanDuel;
    @SerializedName("FantasyPointsDraftKings")
    private Double fantasyPointsDraftKings;
    @SerializedName("FantasyPointsYahoo")
    private Double fantasyPointsYahoo;
    @SerializedName("Minutes")
    private String minutes;
    @SerializedName("Seconds")
    private String seconds;
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
    private String goaltendingMinutes;
    @SerializedName("GoaltendingSeconds")
    private String goaltendingSeconds;
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
    private Object started;
    @SerializedName("BenchPenaltyMinutes")
    private Double benchPenaltyMinutes;
    @SerializedName("GoaltendingOvertimeLosses")
    private Double goaltendingOvertimeLosses;
    @SerializedName("FantasyPointsFantasyDraft")
    private Double fantasyPointsFantasyDraft;
    @SerializedName("OpponentStat")
    private StatisticsModel opponentStat;

    public StatisticsModel(String statID, String teamID, String seasonType, String season, String name, String team, String wins, String losses, String overtimeLosses, Object opponentPosition, String globalTeamID, String updated, String games, Double fantasyPoints, Double fantasyPointsFanDuel, Double fantasyPointsDraftKings, Double fantasyPointsYahoo, String minutes, String seconds, Double goals, Double assists, Double shotsOnGoal, Double powerPlayGoals, Double shortHandedGoals, Double emptyNetGoals, Double powerPlayAssists, Double shortHandedAssists, Double hatTricks, Double shootoutGoals, Double plusMinus, Double penaltyMinutes, Double blocks, Double hits, Double takeaways, Double giveaways, Double faceoffsWon, Double faceoffsLost, Double shifts, String goaltendingMinutes, String goaltendingSeconds, Double goaltendingShotsAgainst, Double goaltendingGoalsAgainst, Double goaltendingSaves, Double goaltendingWins, Double goaltendingLosses, Double goaltendingShutouts, Object started, Double benchPenaltyMinutes, Double goaltendingOvertimeLosses, Double fantasyPointsFantasyDraft, StatisticsModel opponentStat) {
        this.statID = statID;
        this.teamID = teamID;
        this.seasonType = seasonType;
        this.season = season;
        this.name = name;
        this.team = team;
        this.wins = wins;
        this.losses = losses;
        this.overtimeLosses = overtimeLosses;
        this.opponentPosition = opponentPosition;
        this.globalTeamID = globalTeamID;
        this.updated = updated;
        this.games = games;
        this.fantasyPoints = fantasyPoints;
        this.fantasyPointsFanDuel = fantasyPointsFanDuel;
        this.fantasyPointsDraftKings = fantasyPointsDraftKings;
        this.fantasyPointsYahoo = fantasyPointsYahoo;
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
        this.shifts = shifts;
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
        this.goaltendingOvertimeLosses = goaltendingOvertimeLosses;
        this.fantasyPointsFantasyDraft = fantasyPointsFantasyDraft;
        this.opponentStat = opponentStat;
    }

    public StatisticsModel(String statID, String teamID, String seasonType, String season, String name, String team, String wins, String losses, String overtimeLosses, Object opponentPosition, String globalTeamID, String updated, String games, Double fantasyPoints, Double fantasyPointsFanDuel, Double fantasyPointsDraftKings, Double fantasyPointsYahoo, String minutes, String seconds, Double goals, Double assists, Double shotsOnGoal, Double powerPlayGoals, Double shortHandedGoals, Double emptyNetGoals, Double powerPlayAssists, Double shortHandedAssists, Double hatTricks, Double shootoutGoals, Double plusMinus, Double penaltyMinutes, Double blocks, Double hits, Double takeaways, Double giveaways, Double faceoffsWon, Double faceoffsLost, Double shifts, String goaltendingMinutes, String goaltendingSeconds, Double goaltendingShotsAgainst, Double goaltendingGoalsAgainst, Double goaltendingSaves, Double goaltendingWins, Double goaltendingLosses, Double goaltendingShutouts, Object started, Double benchPenaltyMinutes, Double goaltendingOvertimeLosses, Double fantasyPointsFantasyDraft) {
        this.statID = statID;
        this.teamID = teamID;
        this.seasonType = seasonType;
        this.season = season;
        this.name = name;
        this.team = team;
        this.wins = wins;
        this.losses = losses;
        this.overtimeLosses = overtimeLosses;
        this.opponentPosition = opponentPosition;
        this.globalTeamID = globalTeamID;
        this.updated = updated;
        this.games = games;
        this.fantasyPoints = fantasyPoints;
        this.fantasyPointsFanDuel = fantasyPointsFanDuel;
        this.fantasyPointsDraftKings = fantasyPointsDraftKings;
        this.fantasyPointsYahoo = fantasyPointsYahoo;
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
        this.shifts = shifts;
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
        this.goaltendingOvertimeLosses = goaltendingOvertimeLosses;
        this.fantasyPointsFantasyDraft = fantasyPointsFantasyDraft;
    }

    public String getStatID() {
        return statID;
    }

    public String getTeamID() {
        return teamID;
    }

    public String getSeasonType() {
        return seasonType;
    }

    public String getSeason() {
        return season;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getWins() {
        return wins;
    }

    public String getLosses() {
        return losses;
    }

    public String getOvertimeLosses() {
        return overtimeLosses;
    }

    public Object getOpponentPosition() {
        return opponentPosition;
    }

    public String getGlobalTeamID() {
        return globalTeamID;
    }

    public String getUpdated() {
        return updated;
    }

    public String getGames() {
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

    public String getMinutes() {
        return minutes;
    }

    public String getSeconds() {
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

    public String getGoaltendingMinutes() {
        return goaltendingMinutes;
    }

    public String getGoaltendingSeconds() {
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

    public Object getStarted() {
        return started;
    }

    public Double getBenchPenaltyMinutes() {
        return benchPenaltyMinutes;
    }

    public Double getGoaltendingOvertimeLosses() {
        return goaltendingOvertimeLosses;
    }

    public Double getFantasyPointsFantasyDraft() {
        return fantasyPointsFantasyDraft;
    }

    public StatisticsModel getOpponentStat() {
        return opponentStat;
    }
}
