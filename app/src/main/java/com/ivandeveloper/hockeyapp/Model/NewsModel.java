package com.ivandeveloper.hockeyapp.Model;

import com.google.gson.annotations.SerializedName;

public class NewsModel {

    @SerializedName("NewsID")
    private int newsID;
    @SerializedName("PlayerID")
    private int playerID;
    @SerializedName("TeamID")
    private int teamID;
    @SerializedName("Team")
    private String team;
    @SerializedName("Title")
    private String title;
    @SerializedName("Content")
    private String content;
    @SerializedName("Url")
    private String url;
    @SerializedName("Source")
    private String source;
    @SerializedName("TermsOfUse")
    private String termsOfUse;
    @SerializedName("Updated")
    private String updated;
    private String playerPic;
    private String playerTeamPic;

    public NewsModel(int newsID, int playerID, int teamID, String team, String title, String content, String url, String source, String termsOfUse, String updated) {
        super();
        this.newsID = newsID;
        this.playerID = playerID;
        this.teamID = teamID;
        this.team = team;
        this.title = title;
        this.content = content;
        this.url = url;
        this.source = source;
        this.termsOfUse = termsOfUse;
        this.updated = updated;
    }

    public NewsModel(int newsID, int playerID, int teamID, String team, String title, String content, String url, String source, String termsOfUse, String updated, String playerPic, String playerTeamPic) {
        super();
        this.newsID = newsID;
        this.playerID = playerID;
        this.teamID = teamID;
        this.team = team;
        this.title = title;
        this.content = content;
        this.url = url;
        this.source = source;
        this.termsOfUse = termsOfUse;
        this.updated = updated;
        this.playerPic = playerPic;
        this.playerTeamPic = playerTeamPic;
    }

    public String getPlayerPic() {
        return playerPic;
    }

    public String getPlayerTeamPic() {
        return playerTeamPic;
    }

    public int getNewsID() {
        return newsID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public int getTeamID() {
        return teamID;
    }

    public String getTeam() {
        return team;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public String getSource() {
        return source;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public String getUpdated() {
        return updated;
    }
}
