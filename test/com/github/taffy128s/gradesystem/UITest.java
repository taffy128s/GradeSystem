/**
 * Class UITest: test Class UI, two tests every method.
 *               must be modified if input file is changed.
 * 
 * Bugs: none known.
 * 
 * @author  Taffy Cheng
 */
package com.github.taffy128s.gradesystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class UITest {

    private ByteArrayOutputStream outContent;
    
    /**
     * Method setUp: this method will run before any test method.
     * 
     * Pseudo code:
     * 1. new a ByteArrayOutputStream.
     * 2. redirect output stream.
     * 
     * Complexity:
     * O(1).
     */
    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Method promptIDTest: test promptID.
     * 
     * Pseudo code:
     * 1. give the specified input.
     * 2. check if the output is equal to the expected answer.
     * 
     * Complexity:
     * O(n) because RecordManager will be constructed while constructing UI.
     */
    @Test
    public void promptIDTest() {
        System.setIn(new ByteArrayInputStream("Q".getBytes()));
        UI ui1 = new UI();
        ui1.promptID();
        assertEquals("輸入ID或Q: 程式結束。\r\n", outContent.toString());
        outContent.reset();
        System.setIn(new ByteArrayInputStream("94879487\r\nQ".getBytes()));
        UI ui2 = new UI();
        ui2.promptID();
        assertEquals("輸入ID或Q: ID不存在。\r\n輸入ID或Q: 程式結束。\r\n", outContent.toString());
        outContent.reset();
    }
    
    /**
     * Method promptCommandTest: test promptCommand.
     * 
     * Pseudo code:
     * 1. new a Record with valid arguments.
     * 2. construct a string that we expect.
     * 3. give the specified command to promptCommand.
     * 4. check if the output is equal to the answer expected.
     * 
     * Complexity:
     * O(n) because we are using getAverages in RecordManager.
     */
    @Test
    public void promptCommandTest() {
        Record record = new Record("985002012", "史易秦", new int[] {94, 80, 84, 86, 86});
        String expected1 = "";
        expected1 += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected1 += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected1 += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected1 += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected1 += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected1 += ">> ";
        expected1 += "各項成績平均：\r\n";
        expected1 += "    " + Record.mColumnNames[0] + "平均: 90\r\n";
        expected1 += "    " + Record.mColumnNames[1] + "平均: 87\r\n";
        expected1 += "    " + Record.mColumnNames[2] + "平均: 89\r\n";
        expected1 += "    " + Record.mColumnNames[3] + "平均: 89\r\n";
        expected1 += "    " + Record.mColumnNames[4] + "平均: 89\r\n";
        expected1 += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected1 += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected1 += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected1 += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected1 += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected1 += ">> ";
        System.setIn(new ByteArrayInputStream("A".getBytes()));
        UI ui1 = new UI();
        ui1.promptCommand(record);
        assertEquals(expected1, outContent.toString());
        outContent.reset();
        String expected2 = "";
        expected2 += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected2 += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected2 += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected2 += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected2 += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected2 += ">> ";
        System.setIn(new ByteArrayInputStream("".getBytes()));
        UI ui2 = new UI();
        ui2.promptCommand(record);
        assertEquals(expected2, outContent.toString());
    }

}
