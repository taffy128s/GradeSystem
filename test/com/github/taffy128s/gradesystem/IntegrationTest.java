/**
 * Class IntegrationTest: test one main function per method.
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

public class IntegrationTest {

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
     * Method showGradeTest: test main function "show grade".
     * 
     * Pseudo code:
     * 1. give the specified input.
     * 2. check if the output matches the answer written by hand.
     * 
     * Complexity:
     * O(1).
     */
    @Test
    public void showGradeTest() {
        System.setIn(new ByteArrayInputStream("975002039\r\nG\r\nE\r\nQ\r\n".getBytes()));
        UI ui1 = new UI();
        ui1.promptID();
        String expected = "";
        expected += "輸入ID或Q: Welcome 許琇筑.\r\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected += ">> ";
        expected += "許琇筑成績：\r\n";
        expected += "    lab1: 97\r\n";
        expected += "    lab2: 84\r\n";
        expected += "    lab3: 87\r\n";
        expected += "    mid-term: 99\r\n";
        expected += "    final exam: 89\r\n";
        expected += "    total grade: 92\r\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected += ">> ";
        expected += "輸入ID或Q: ";
        expected += "程式結束。\r\n";
        assertEquals(expected, outContent.toString());
    }
    
    /**
     * Method showRankTest: test main function "show rank".
     * 
     * Pseudo code:
     * 1. give the specified input.
     * 2. check if the output matches the answer written by hand.
     * 
     * Complexity:
     * O(n).
     */
    @Test
    public void showRankTest() {
        System.setIn(new ByteArrayInputStream("975002039\r\nR\r\nE\r\nQ\r\n".getBytes()));
        UI ui1 = new UI();
        ui1.promptID();
        String expected = "";
        expected += "輸入ID或Q: Welcome 許琇筑.\r\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected += ">> ";
        expected += "許琇筑排名: 10\r\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected += ">> ";
        expected += "輸入ID或Q: ";
        expected += "程式結束。\r\n";
        assertEquals(expected, outContent.toString());
    }
    
    /**
     * Method showAvergeTest: test main function "show average".
     * 
     * Pseudo code:
     * 1. give the specified input.
     * 2. check if the output matches the answer written by hand.
     * 
     * Complexity:
     * O(n).
     */
    @Test
    public void showAverageTest() {
        System.setIn(new ByteArrayInputStream("975002039\r\nA\r\nE\r\nQ\r\n".getBytes()));
        UI ui1 = new UI();
        ui1.promptID();
        String expected = "";
        expected += "輸入ID或Q: Welcome 許琇筑.\r\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected += ">> ";
        expected += "各項成績平均：\r\n";
        expected += "    lab1平均: 90\r\n";
        expected += "    lab2平均: 87\r\n";
        expected += "    lab3平均: 89\r\n";
        expected += "    mid-term平均: 89\r\n";
        expected += "    final exam平均: 89\r\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected += ">> ";
        expected += "輸入ID或Q: ";
        expected += "程式結束。\r\n";
        assertEquals(expected, outContent.toString());
    }
    
    /**
     * Method reweightTest: test main function "reweight".
     * 
     * Pseudo code:
     * 1. give the specified input.
     * 2. check if the output matches the answer written by hand.
     * 
     * Complexity:
     * O(n).
     */
    @Test
    public void reweightTest() {
        System.setIn(new ByteArrayInputStream("975002039\r\nW\r\n20\r\n20\r\n20\r\n20\r\n20\r\nY\r\nE\r\nQ\r\n".getBytes()));
        UI ui1 = new UI();
        ui1.promptID();
        String expected = "";
        expected += "輸入ID或Q: Welcome 許琇筑.\r\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected += ">> ";
        expected += "舊配分\r\n";
        expected += "    lab1 10%\r\n";
        expected += "    lab2 10%\r\n";
        expected += "    lab3 10%\r\n";
        expected += "    mid-term 30%\r\n";
        expected += "    final exam 40%\r\n";
        expected += "輸入新配分\r\n";
        expected += "    lab1 ";
        expected += "    lab2 ";
        expected += "    lab3 ";
        expected += "    mid-term ";
        expected += "    final exam ";
        expected += "請確認新配分\r\n";
        expected += "    lab1 20%\r\n";
        expected += "    lab2 20%\r\n";
        expected += "    lab3 20%\r\n";
        expected += "    mid-term 20%\r\n";
        expected += "    final exam 20%\r\n";
        expected += "以上正確嗎? Y (Yes) 或 N (No)\r\n";
        expected += ">> ";
        expected += "更改成功。\r\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\r\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\r\n";
        expected += "　　　　 3) A 顯示平均 (Average)\r\n";
        expected += "　　　　 4) W 更新配分 (Weight)\r\n";
        expected += "　　　　 5) E 離開選單 (Exit)\r\n";
        expected += ">> ";
        expected += "輸入ID或Q: ";
        expected += "程式結束。\r\n";
        assertEquals(expected, outContent.toString());
    }

}
