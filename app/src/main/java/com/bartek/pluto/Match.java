package com.bartek.pluto;

import java.io.Serializable;

public class Match implements Serializable {

    private String teamAName;
    private String teamBName;
    private int pointsA;
    private int pointsB;
    private int setsA;
    private int setsB;
    private int[] actualSetPoints;
    private int[][] resultsOfSets;

    public Match(String teamAName,
                 String teamBName,
                 int pointsA,
                 int pointsB,
                 int setsA,
                 int setsB,
                 int[] actualSetPoints,
                 int[][] resultsOfSets) {
        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.pointsA = pointsA;
        this.pointsB = pointsB;
        this.setsA = setsA;
        this.setsB = setsB;
        this.actualSetPoints = actualSetPoints;
        this.resultsOfSets = resultsOfSets;
    }

    public String getTeamAName() {return teamAName;}
    public String getTeamBName() {return teamBName;}
    public int getPointsA() { return pointsA; }
    public int getPointsB() {return pointsB;}
    public int getSetsA() {return setsA;}
    public int getSetsB() {return setsB;}
    public int[] getActualSetPoints() {return actualSetPoints;}
    public int[][] getResultsOfSets() {return resultsOfSets;}

    public void pointForA() {
        actualSetPoints[pointsA + pointsB] = 1;
        pointsA += 1;
        endOfSet();
    }

    public void pointForB() {
        actualSetPoints[pointsA + pointsB] = 2;
        pointsB += 1;
        endOfSet();
    }

    public void undo(){
        if (actualSetPoints[pointsA + pointsB - 1] == 1){
            pointsA -= 1;
        }
        else if (actualSetPoints[pointsA + pointsB - 1] == 2){
            pointsB -= 1;
        }
    }

    private void resetPoints(){
        resultsOfSets[setsA + setsB][0] = pointsA;
        resultsOfSets[setsA + setsB][1] = pointsB;
        pointsA = 0;
        pointsB = 0;
    }

    private void endOfSet() {
        if (pointsA >= 25 & pointsA - pointsB >= 2) {
            resetPoints();
            setsA += 1;
        }
        if (pointsB >= 25 & pointsB - pointsA >= 2) {
            resetPoints();
            setsB += 1;
        }
    }

    public boolean endOfMatch(){
        return setsA == 3 || setsB == 3;
    }
}
