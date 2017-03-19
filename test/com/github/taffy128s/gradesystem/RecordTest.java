/**
 * Class RecordTest: test Class Record.
 * 
 * Bugs: none known.
 * 
 * @author Taffy Cheng
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
        int[] scores1 = record1.getScores();
        String ans1 = record1.getName() + "成績：\n";
        for (int i = 0; i < Record.mColumnNum; i++)
            if (scores1[i] < 60) ans1 += "    " + Record.mColumnNames[i] + ": " + scores1[i] + "*\n";
            else ans1 += "    " + Record.mColumnNames[i] + ": " + scores1[i] + "\n";
        ans1 += "    total grade: " + record1.getWeightedScore();
        assertEquals(ans1, record1.toString());
        int [] scores2 = record2.getScores();
        String ans2 = record2.getName() + "成績：\n";
        for (int i = 0; i < Record.mColumnNum; i++)
            if (scores2[i] < 60) ans2 += "    " + Record.mColumnNames[i] + ": " + scores2[i] + "*\n";
            else ans2 += "    " + Record.mColumnNames[i] + ": " + scores2[i] + "\n";
        ans2 += "    total grade: " + record1.getWeightedScore();
        assertEquals(ans2, record2.toString());
    }
    
}
