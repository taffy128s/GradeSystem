package com.github.taffy128s.gradesystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class RecordManager {
    
    public static final String mFileName = "gradeinput.txt";
    private static final double[] defaultWeights = {0.1, 0.1, 0.1, 0.3, 0.4};
    private LinkedList<Record> mList;
    private double[] mWeights;
    
    public RecordManager() {
        mList = new LinkedList<>();
        loadRecords();
        reweightAll(defaultWeights);
    }
    
    public Record getRecord(String id) {
        for (Record record : mList)
            if (record.getID().equals(id))
                return record;
        return null;
    }
    
    public int getRank(Record inputRecord) {
        int rank = 1;
        for (Record record : mList)
            if (record.getWeightedScore() > inputRecord.getWeightedScore())
                rank++;
        return rank;
    }
    
    public int[] getAverages() {
        int[] averages = new int[Record.mColumnNum];
        for (Record record : mList)
            for (int i = 0; i < Record.mColumnNum; i++)
                averages[i] += record.getScores()[i];
        for (int i = 0; i < Record.mColumnNum; i++)
            averages[i] /= mList.size();
        return averages;
    }
    
    public double[] getWeights() {
        return mWeights;
    }
    
    public void reweightAll(double[] weights) {
        mWeights = weights;
        for (Record grade : mList)
            grade.reweight(weights);
    }
    
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
    
    private void loadSingleRecord(String[] tokens) {
        if (tokens[0].length() == 10) tokens[0] = tokens[0].substring(1, 10);
        int[] scores = new int[Record.mColumnNum];
        for (int i = 0; i < Record.mColumnNum; i++)
            scores[i] = Integer.parseInt(tokens[i + 2]);
        Record record = new Record(tokens[0], tokens[1], scores);
        mList.add(record);
    }
    
}
