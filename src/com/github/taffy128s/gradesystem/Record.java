/**
 * Class Record: contains the data in a record.
 * 
 * Bugs: none known.
 * 
 * @author  Taffy Cheng
 */
package com.github.taffy128s.gradesystem;

public class Record {
    
    public static final int mColumnNum = 5;
    public static final String[] mColumnNames = {"lab1", "lab2", "lab3", "mid-term", "final exam"};
    private String mID, mName;
    private int[] mScores;
    private int mWeightedScore;
    
    /**
     * Constructor Record: construct a new Record.
     * 
     * @param id: the id of the record.
     * @param name: the name of the record.
     * @param scores: the scores of the record.
     */
    public Record(String id, String name, int[] scores) {
        mID = id;
        mName = name;
        mScores = scores;
        mWeightedScore = -1;
    }
    
    /**
     * Method getID: get the ID of the record.
     * 
     * @return mID.
     * 
     * Pseudo code:
     * 1. return mID.
     * 
     * Complexity:
     * O(1).
     */
    public String getID() {
        return mID;
    }
    
    /**
     * Method getName: get the name of the record.
     * 
     * @return mName.
     * 
     * Pseudo code:
     * 1. return mName.
     * 
     * Complexity:
     * O(1).
     */
    public String getName() {
        return mName;
    }
    
    /**
     * Method getScores: get the scores of the record.
     * 
     * @return mScores.
     * 
     * Pseudo code:
     * 1. return mScores.
     * 
     * Complexity:
     * O(1).
     */
    public int[] getScores() {
        return mScores;
    }
    
    /**
     * Method getWeightedScore: get the weighted score of this record.
     * 
     * @return mWeightedScore.
     * 
     * Pseudo code:
     * 1. return mWeightedScore.
     * 
     * Complexity:
     * O(1).
     */
    public int getWeightedScore() {
        return mWeightedScore;
    }
    
    /**
     * Method reweight: reweight the mWeightedScore in this record.
     * 
     * @param weights: the given weights to use.
     * 
     * Pseudo code:
     * 1. allocate a temporary integer and set it to 0.
     * 2. loop for mColumnNum times, every time we add mScores[i] * weights[i] to the temporary integer.
     * 3. divide the temporary integer by 100 to get the weighted score.
     * 
     * Complexity:
     * O(1) because mColumnNum is constant.
     */
    public void reweight(int[] weights) {
        int temp = 0;
        for (int i = 0; i < mColumnNum; i++)
            temp += mScores[i] * weights[i];
        mWeightedScore = temp / 100;
    }
    
    /**
     * Method toString: provide a way that makes the record a String.
     * 
     * Pseudo code:
     * 1. new a StringBuilder.
     * 2. append the title "scores:\n".
     * 3. loop for mColumnNum times.
     * 4. append the column names and the scores, '*' is needed when < 60 for sure.
     * 5. append the weighted score in the end.
     * 6. return stringBuilder.toString.
     * 
     * Complexity:
     * O(1).
     */
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
