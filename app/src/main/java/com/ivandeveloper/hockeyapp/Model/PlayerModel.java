package com.ivandeveloper.hockeyapp.Model;

import com.google.gson.annotations.SerializedName;

public class PlayerModel {
    @SerializedName("PlayerID")
    private Integer playerID;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("Status")
    private String status;
    @SerializedName("TeamID")
    private Integer teamID;
    @SerializedName("Team")
    private String team;
    @SerializedName("Position")
    private String position;
    @SerializedName("Jersey")
    private Integer jersey;
    @SerializedName("Catches")
    private String catches;
    @SerializedName("Shoots")
    private String shoots;
    @SerializedName("Height")
    private Integer height;
    @SerializedName("Weight")
    private Integer weight;
    @SerializedName("BirthDate")
    private String birthDate;
    @SerializedName("BirthCity")
    private String birthCity;
    @SerializedName("BirthState")
    private Object birthState;
    @SerializedName("PhotoUrl")
    private String photoUrl;
    @SerializedName("SportRadarPlayerID")
    private String sportRadarPlayerID;
    @SerializedName("RotoworldPlayerID")
    private Integer rotoworldPlayerID;
    @SerializedName("RotoWirePlayerID")
    private Integer rotoWirePlayerID;
    @SerializedName("FantasyAlarmPlayerID")
    private Integer fantasyAlarmPlayerID;
    @SerializedName("StatsPlayerID")
    private Integer statsPlayerID;
    @SerializedName("SportsDirectPlayerID")
    private Integer sportsDirectPlayerID;
    @SerializedName("XmlTeamPlayerID")
    private Object xmlTeamPlayerID;
    @SerializedName("InjuryStatus")
    private String injuryStatus;
    @SerializedName("InjuryBodyPart")
    private String injuryBodyPart;
    @SerializedName("InjuryStartDate")
    private Object injuryStartDate;
    @SerializedName("InjuryNotes")
    private String injuryNotes;
    @SerializedName("FanDuelPlayerID")
    private Integer fanDuelPlayerID;
    @SerializedName("DraftKingsPlayerID")
    private Integer draftKingsPlayerID;
    @SerializedName("YahooPlayerID")
    private Integer yahooPlayerID;
    @SerializedName("FanDuelName")
    private String fanDuelName;
    @SerializedName("DraftKingsName")
    private String draftKingsName;
    @SerializedName("YahooName")
    private String yahooName;
    @SerializedName("DepthChartPosition")
    private Object depthChartPosition;
    @SerializedName("DepthChartOrder")
    private Object depthChartOrder;
    @SerializedName("GlobalTeamID")
    private Integer globalTeamID;
    @SerializedName("FantasyDraftName")
    private Object fantasyDraftName;
    @SerializedName("FantasyDraftPlayerID")
    private Object fantasyDraftPlayerID;
    @SerializedName("UsaTodayPlayerID")
    private Integer usaTodayPlayerID;
    @SerializedName("UsaTodayHeadshotUrl")
    private String usaTodayHeadshotUrl;
    @SerializedName("UsaTodayHeadshotNoBackgroundUrl")
    private String usaTodayHeadshotNoBackgroundUrl;
    @SerializedName("UsaTodayHeadshotUpdated")
    private String usaTodayHeadshotUpdated;
    @SerializedName("UsaTodayHeadshotNoBackgroundUpdated")
    private String usaTodayHeadshotNoBackgroundUpdated;

    public PlayerModel(Integer playerID, String firstName, String lastName, String position, Integer jersey, String photoUrl) {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.jersey = jersey;
        this.photoUrl = photoUrl;
    }

    public PlayerModel(Integer playerID, String team, String photoUrl) {
        this.playerID = playerID;
        this.photoUrl = photoUrl;
    }

    public PlayerModel(Integer playerID, String firstName, String lastName, String team, String position, Integer jersey, String photoUrl) {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.position = position;
        this.jersey = jersey;
        this.photoUrl = photoUrl;
    }

    public PlayerModel(Integer playerID, String firstName, String lastName, String status, Integer teamID, String team, String position, Integer jersey, String catches, String shoots, Integer height, Integer weight, String birthDate, String birthCity, Object birthState, String photoUrl, String sportRadarPlayerID, Integer rotoworldPlayerID, Integer rotoWirePlayerID, Integer fantasyAlarmPlayerID, Integer statsPlayerID, Integer sportsDirectPlayerID, Object xmlTeamPlayerID, String injuryStatus, String injuryBodyPart, Object injuryStartDate, String injuryNotes, Integer fanDuelPlayerID, Integer draftKingsPlayerID, Integer yahooPlayerID, String fanDuelName, String draftKingsName, String yahooName, Object depthChartPosition, Object depthChartOrder, Integer globalTeamID, Object fantasyDraftName, Object fantasyDraftPlayerID, Integer usaTodayPlayerID, String usaTodayHeadshotUrl, String usaTodayHeadshotNoBackgroundUrl, String usaTodayHeadshotUpdated, String usaTodayHeadshotNoBackgroundUpdated) {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.teamID = teamID;
        this.team = team;
        this.position = position;
        this.jersey = jersey;
        this.catches = catches;
        this.shoots = shoots;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
        this.birthCity = birthCity;
        this.birthState = birthState;
        this.photoUrl = photoUrl;
        this.sportRadarPlayerID = sportRadarPlayerID;
        this.rotoworldPlayerID = rotoworldPlayerID;
        this.rotoWirePlayerID = rotoWirePlayerID;
        this.fantasyAlarmPlayerID = fantasyAlarmPlayerID;
        this.statsPlayerID = statsPlayerID;
        this.sportsDirectPlayerID = sportsDirectPlayerID;
        this.xmlTeamPlayerID = xmlTeamPlayerID;
        this.injuryStatus = injuryStatus;
        this.injuryBodyPart = injuryBodyPart;
        this.injuryStartDate = injuryStartDate;
        this.injuryNotes = injuryNotes;
        this.fanDuelPlayerID = fanDuelPlayerID;
        this.draftKingsPlayerID = draftKingsPlayerID;
        this.yahooPlayerID = yahooPlayerID;
        this.fanDuelName = fanDuelName;
        this.draftKingsName = draftKingsName;
        this.yahooName = yahooName;
        this.depthChartPosition = depthChartPosition;
        this.depthChartOrder = depthChartOrder;
        this.globalTeamID = globalTeamID;
        this.fantasyDraftName = fantasyDraftName;
        this.fantasyDraftPlayerID = fantasyDraftPlayerID;
        this.usaTodayPlayerID = usaTodayPlayerID;
        this.usaTodayHeadshotUrl = usaTodayHeadshotUrl;
        this.usaTodayHeadshotNoBackgroundUrl = usaTodayHeadshotNoBackgroundUrl;
        this.usaTodayHeadshotUpdated = usaTodayHeadshotUpdated;
        this.usaTodayHeadshotNoBackgroundUpdated = usaTodayHeadshotNoBackgroundUpdated;
    }

    public PlayerModel(String firstName) {
        this.firstName = firstName;
    }

    public Integer getPlayerID() {
        return playerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStatus() {
        return status;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public Integer getJersey() {
        return jersey;
    }

    public String getCatches() {
        return catches;
    }

    public String getShoots() {
        return shoots;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public Object getBirthState() {
        return birthState;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getSportRadarPlayerID() {
        return sportRadarPlayerID;
    }

    public Integer getRotoworldPlayerID() {
        return rotoworldPlayerID;
    }

    public Integer getRotoWirePlayerID() {
        return rotoWirePlayerID;
    }

    public Integer getFantasyAlarmPlayerID() {
        return fantasyAlarmPlayerID;
    }

    public Integer getStatsPlayerID() {
        return statsPlayerID;
    }

    public Integer getSportsDirectPlayerID() {
        return sportsDirectPlayerID;
    }

    public Object getXmlTeamPlayerID() {
        return xmlTeamPlayerID;
    }

    public String getInjuryStatus() {
        return injuryStatus;
    }

    public String getInjuryBodyPart() {
        return injuryBodyPart;
    }

    public Object getInjuryStartDate() {
        return injuryStartDate;
    }

    public String getInjuryNotes() {
        return injuryNotes;
    }

    public Integer getFanDuelPlayerID() {
        return fanDuelPlayerID;
    }

    public Integer getDraftKingsPlayerID() {
        return draftKingsPlayerID;
    }

    public Integer getYahooPlayerID() {
        return yahooPlayerID;
    }

    public String getFanDuelName() {
        return fanDuelName;
    }

    public String getDraftKingsName() {
        return draftKingsName;
    }

    public String getYahooName() {
        return yahooName;
    }

    public Object getDepthChartPosition() {
        return depthChartPosition;
    }

    public Object getDepthChartOrder() {
        return depthChartOrder;
    }

    public Integer getGlobalTeamID() {
        return globalTeamID;
    }

    public Object getFantasyDraftName() {
        return fantasyDraftName;
    }

    public Object getFantasyDraftPlayerID() {
        return fantasyDraftPlayerID;
    }

    public Integer getUsaTodayPlayerID() {
        return usaTodayPlayerID;
    }

    public String getUsaTodayHeadshotUrl() {
        return usaTodayHeadshotUrl;
    }

    public String getUsaTodayHeadshotNoBackgroundUrl() {
        return usaTodayHeadshotNoBackgroundUrl;
    }

    public String getUsaTodayHeadshotUpdated() {
        return usaTodayHeadshotUpdated;
    }

    public String getUsaTodayHeadshotNoBackgroundUpdated() {
        return usaTodayHeadshotNoBackgroundUpdated;
    }
}
