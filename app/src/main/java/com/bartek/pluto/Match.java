package com.bartek.pluto;

import java.io.Serializable;

public class Match implements Serializable{

    private String teamAName;
    private String teamBName;
    private String date;
    private String place;
    private String result;
    private int[][] resultsOfSets;

    public Match(String teamAName, String teamBName, String date, String place, String result, int[][] resultsOfSets) {
        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.date = date;
        this.place = place;
        this.result = result;
        this.resultsOfSets = resultsOfSets;
    }

    public String getTeamAName(){
        return teamAName;
    }

    public String getTeamBName(){
        return teamBName;
    }

    public String getDate(){
        return date;
    }

    public String getPlace(){
        return place;
    }

    public String getResult(){
        return result;
    }

    public int[][] getResultsOfSets(){
        return resultsOfSets;
    }

}
