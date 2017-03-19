/**
 * Class RecordManagerTest: test Class RecordManager, two tests per method.
 *                          must be modified if input file is changed.
 * 
 * Bugs: none known.
 * 
 * @author  Taffy Cheng
 */
package com.github.taffy128s.gradesystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecordManagerTest {

    private RecordManager rm;
    
    /**
     * Method setUp: this method will run before any testing method.
     * 
     * Pseudo code:
     * 1. new a RecordManager.
     * 
     * Complexity:
     * O(1).
     */
    @Before
    public void setUp() {
        rm = new RecordManager();
    }

    /**
     * Method getRecordTest: test getRecord.
     * 
     * Pseudo code:
     * 1. get specified record by ID.
     * 2. if null or the name is not the same, then fail.
     * 3. if the condition above is not true, then pass.
     * 
     * Complexity:
     * O(n) to find the specified ID.
     */
    @Test
    public void getRecordTest() {
        Record record1 = rm.getRecord("985002003");
        if (record1 == null || !record1.getID().equals("985002003"))
            fail();
        Record record2 = rm.getRecord("985002027");
        if (record2 == null || !record2.getID().equals("985002027"))
            fail();
    }
    
    /**
     * Method getRankTest: test getRank.
     * 
     * Pseudo code:
     * 1. get the rank using specified record.
     * 2. check if the output is equal to the answer calculated by hand.
     * 
     * Complexity:
     * O(n).
     */
    @Test
    public void getRankTest() {
        if (rm.getRank(rm.getRecord("985002002")) != 10)
            fail();
        if (rm.getRank(rm.getRecord("985002027")) != 10)
            fail();
    }
    
    /**
     * Method getAveragesTest: test getAverages.
     * 
     * Pseudo code:
     * 1. get the averages.
     * 2. check if the values inside the array are same as answer calculated by hand.
     * 
     * Complexity:
     * O(n);
     */
    @Test
    public void getAveragesTest() {
        int[] averages = rm.getAverages();
        if (averages[0] != 90)
            fail();
        if (averages[1] != 87)
            fail();
    }
    
    /**
     * Method reweightAllTest: test reweightAll.
     * 
     * Pseudo code:
     * 1. reweight the records using specified weights.
     * 2. check if the output is equal to the answer calculated by hand.
     * 
     * Complexity:
     * O(n).
     */
    @Test
    public void reweightAllTest() {
        rm.reweightAll(new int[] {100, 0, 0, 0, 0});
        if (rm.getRank(rm.getRecord("985002002")) != 1)
            fail();
        rm.reweightAll(new int[] {0, 0, 0, 0, 100});
        if (rm.getRank(rm.getRecord("985002027")) != 1)
            fail();
    }
    
    /**
     * Method getWeightsTest: test getWeights.
     * 
     * Pseudo code:
     * 1. set up new weights.
     * 2. call reweightAll.
     * 3. if the values don't match, then fail.
     * 4. if match, pass.
     * 
     * Complexity:
     * O(n) because reweightAll does O(n).
     */
    @Test
    public void getWeightsTest() {
        int[] weights1 = {10, 20, 30, 40, 0}, weights2 = {40, 30, 20, 0, 10};
        rm.reweightAll(weights1);
        for (int i = 0; i < Record.mColumnNum; i++)
            if (rm.getWeights()[i] != weights1[i])
                fail();
        rm.reweightAll(weights2);
        for (int i = 0; i < Record.mColumnNum; i++)
            if (rm.getWeights()[i] != weights2[i])
                fail();
    }
    
}
