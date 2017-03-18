package com.github.taffy128s.gradesystem;

public class Record {
    
    public static final int mColumnNum = 5;
    public static final String[] mColumnNames = {"lab1", "lab2", "lab3", "mid-term", "final exam"};
    private String mID, mName;
    private int[] mScores;
    private int mWeightedScore;
    
    public Record(String id, String name, int[] scores) {
        mID = id;
        mName = name;
        mScores = scores;
        mWeightedScore = -1;
    }
    
    public String getID() {
        return mID;
    }
    
    public String getName() {
        return mName;
    }
    
    public int[] getScores() {
        return mScores;
    }
    
    public int getWeightedScore() {
        return mWeightedScore;
    }
    
    public void reweight(int[] weights) {
        int temp = 0;
        for (int i = 0; i < mColumnNum; i++)
            temp += mScores[i] * weights[i];
        mWeightedScore = temp / 100;
    }
    
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mName + "成績：\n");
        for (int i = 0; i < mColumnNum; i++)
            if (mScores[i] < 60) stringBuilder.append("    " + mColumnNames[i] + ": " + mScores[i] + "*\n");
            else stringBuilder.append("    " + mColumnNames[i] + ": " + mScores[i] + "\n");
        stringBuilder.append("    total grade: " + mWeightedScore);
        return stringBuilder.toString();
    }
    
}
