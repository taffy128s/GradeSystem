/**
 * Class RecordTest: test Class Record, two tests every method.
 * 
 * Bugs: none known.
 * 
 * @author  Taffy Cheng
 */
package com.github.taffy128s.gradesystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecordTest {

    private Record record1, record2;
    
    /**
     * Method setUpTest: this method will run before any test method.
     * 
     * Pseudo code:
     * 1. new two Records.
     * 
     * Complexity:
     * O(1).
     */
    @Before
    public void setUpTest() {
        record1 = new Record("94879487", "習大大", new int[] {59, 60, 70, 80, 30});
        record2 = new Record("08570857", "金胖子", new int[] {40, 25, 58, 99, 66});
    }

    /**
     * Method getIDTest: test getID.
     * 
     * Pseudo code:
     * 1. check if the specified IDs are equal.
     * 
     * Complexity:
     * O(1).
     */
    @Test
    public void getIDTest() {
        assertEquals("94879487", record1.getID());
        assertEquals("08570857", record2.getID());
    }
    
    /**
     * Method getNameTest: test getName.
     * 
     * Pseudo code:
     * 1. check if the specified names are equal.
     * 
     * Complexity:
     * O(1).
     */
    @Test
    public void getNameTest() {
        assertEquals("習大大", record1.getName());
        assertEquals("金胖子", record2.getName());
    }
    
    /**
     * Method getScoresTest: test getScores.
     * 
     * Pseudo code:
     * 1. get the scores from both the records.
     * 2. loop over the arrays and check if they have same values.
     * 
     * Complexity:
     * O(1).
     */
    @Test
    public void getScoresTest() {
        int[] ans1 = {59, 60, 70, 80, 30}, ans2 = {40, 25, 58, 99, 66};
        int[] test1 = record1.getScores(), test2 = record2.getScores();
        for (int i = 0; i < Record.mColumnNum; i++) {
            assertEquals(ans1[i], test1[i]);
            assertEquals(ans2[i], test2[i]);
        }
    }
    
    /**
     * Method getWeightedScoreTest: test getWeightedScore.
     * 
     * Pseudo code:
     * 1. check if the specified values are the same.
     * 
     * Complexity:
     * O(1).
     */
    @Test
    public void getWeightedScoreTest() {
        assertEquals(-1, record1.getWeightedScore());
        assertEquals(-1, record2.getWeightedScore());
    }
    
    /**
     * Method reweightTest: test reweight.
     * 
     * Pseudo code:
     * 1. reweight both the records.
     * 2. check if they are equal to the answers calculated by hand.
     * 
     * Complexity:
     * O(1).
     */
    @Test
    public void reweightTest() {
        record1.reweight(new int[] {10, 20, 30, 20, 20});
        record2.reweight(new int[] {0, 0, 0, 100, 0});
        assertEquals(60, record1.getWeightedScore());
        assertEquals(99, record2.getWeightedScore());
    }

    /**
     * Method toStringTest: test toString.
     * 
     * Pseudo code:
     * 1. construct strings that supposed to have the same contents.
     * 2. check if they are equal.
     * 
     * Complexity:
     * O(1).
     */
    @Test
    public void toStringTest() {
        String ans1 = "";
        ans1 += "習大大成績：\n";
        ans1 += "    " + Record.mColumnNames[0] + ": 59*\n";
        ans1 += "    " + Record.mColumnNames[1] + ": 60\n";
        ans1 += "    " + Record.mColumnNames[2] + ": 70\n";
        ans1 += "    " + Record.mColumnNames[3] + ": 80\n";
        ans1 += "    " + Record.mColumnNames[4] + ": 30*\n";
        ans1 += "    total grade: -1";
        assertEquals(ans1, record1.toString());
        String ans2 = "";
        ans2 += "金胖子成績：\n";
        ans2 += "    " + Record.mColumnNames[0] + ": 40*\n";
        ans2 += "    " + Record.mColumnNames[1] + ": 25*\n";
        ans2 += "    " + Record.mColumnNames[2] + ": 58*\n";
        ans2 += "    " + Record.mColumnNames[3] + ": 99\n";
        ans2 += "    " + Record.mColumnNames[4] + ": 66\n";
        ans2 += "    total grade: -1";
        assertEquals(ans2, record2.toString());
    }
    
}
