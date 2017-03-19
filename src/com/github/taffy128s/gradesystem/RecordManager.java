/**
 * Class RecordManager: manage the records that stores scores.
 * 
 * Bugs: none known.
 * 
 * @author  Taffy Cheng
 */
package com.github.taffy128s.gradesystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class RecordManager {
    
    public static final String mFileName = "gradeinput.txt";
    public static final int[] defaultWeights = {10, 10, 10, 30, 40};
    private LinkedList<Record> mList;
    private int[] mWeights;
    
    /**
     * Constructor RecordManager: construct a new RecordManager.
     */
    public RecordManager() {
        mList = new LinkedList<>();
        loadRecords();
        reweightAll(defaultWeights);
    }
    
    /**
     * Method getRecord: get a record using id.
     * 
     * @param id: use it to search for a record that contains this id.
     * @return record if found, null if not found.
     * 
     * Pseudo code:
     * 1. search the mList for the record that contains the given id.
     * 2. if found, return the record.
     * 3. else return null.
     * 
     * Complexity:
     * O(n).
     */
    public Record getRecord(String id) {
        for (Record record : mList)
            if (record.getID().equals(id))
                return record;
        return null;
    }
    
    /**
     * Method getRank: get the rank of inputRecord.
     * 
     * @param inputRecord: the record to be ranked.
     * @return the rank of given record.
     * 
     * Pseudo code:
     * 1. initial rank is 1.
     * 2. loop over mList.
     * 3. if there is a record whose weighted score is higher than inputRecord, rank increases by 1.
     * 4. return the rank number.
     * 
     * Complexity:
     * O(n).
     */
    public int getRank(Record inputRecord) {
        int rank = 1;
        for (Record record : mList)
            if (record.getWeightedScore() > inputRecord.getWeightedScore())
                rank++;
        return rank;
    }
    
    /**
     * Method getAverages: get the averages of the scores.
     * 
     * @return an array that contains the average of scores.
     * 
     * Pseudo code:
     * 1. new an array that has the same size of Record.mColumnNum.
     * 2. loop over the mList, add the corresponding scores to the array.
     * 3. loop over the array, divide the averages by the size of mList.
     * 4. return the averages of scores.
     * 
     * Complexity:
     * O(n) because Record.mColumnNum is constant.
     */
    public int[] getAverages() {
        int[] averages = new int[Record.mColumnNum];
        for (Record record : mList)
            for (int i = 0; i < Record.mColumnNum; i++)
                averages[i] += record.getScores()[i];
        for (int i = 0; i < Record.mColumnNum; i++)
            averages[i] /= mList.size();
        return averages;
    }
    
    /**
     * Method getWeights: get the weights of the scores.
     * 
     * @return mWeights.
     * 
     * Pseudo code:
     * 1. return mWeights.
     * 
     * Complexity:
     * O(1).
     */
    public int[] getWeights() {
        return mWeights;
    }
    
    /**
     * Method reweightAll: reweight all of the records.
     * 
     * @param weights: the new weights given to reweight.
     * 
     * Pseudo code:
     * 1. loop over the mList and call reweight.
     * 
     * Complexity:
     * O(n).
     */
    public void reweightAll(int[] weights) {
        mWeights = weights;
        for (Record record : mList)
            record.reweight(weights);
    }
    
    /**
     * Method loadRecords: load the records from the gradeinput.txt.
     * 
     * Pseudo code:
     * 1. read the text file line by line.
     * 2. split the line into tokens by space.
     * 3. call loadSingleRecord.
     * 
     * Complexity:
     * O(n).
     */
    private void loadRecords() {
        try {
            FileReader fr = new FileReader(mFileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                loadSingleRecord(tokens);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + mFileName);
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Read file error: " + mFileName);
            System.exit(0);
        }
    }
    
    /**
     * Method loadSingleRecord: add the record into mList using the given token.
     * 
     * @param tokens: the data of a single record.
     * 
     * Pseudo code:
     * 1. handle the strange character at the beginning.
     * 2. new a integer array called scores with size Record.mColumnNum.
     * 3. loop for Record.mColumnNum times to get the scores from the token.
     * 4. new a Record and construct it.
     * 5. add it to mList.
     * 
     * Complexity:
     * O(1)
     */
    private void loadSingleRecord(String[] tokens) {
        if (tokens[0].length() == 10) tokens[0] = tokens[0].substring(1, 10);
        int[] scores = new int[Record.mColumnNum];
        for (int i = 0; i < Record.mColumnNum; i++)
            scores[i] = Integer.parseInt(tokens[i + 2]);
        Record record = new Record(tokens[0], tokens[1], scores);
        mList.add(record);
    }
    
}
