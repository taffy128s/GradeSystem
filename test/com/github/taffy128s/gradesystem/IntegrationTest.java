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
        System.setIn(new ByteArrayInputStream("975002039\nG\nE\nQ\n".getBytes()));
        UI ui1 = new UI();
        ui1.promptID();
        String expected = "";
        expected += "輸入ID或Q: Welcome 許琇筑.\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\n";
        expected += "　　　　 3) A 顯示平均 (Average)\n";
        expected += "　　　　 4) W 更新配分 (Weight)\n";
        expected += "　　　　 5) E 離開選單 (Exit)\n";
        expected += ">> ";
        expected += "許琇筑成績：\n";
        expected += "    lab1: 97\n";
        expected += "    lab2: 84\n";
        expected += "    lab3: 87\n";
        expected += "    mid-term: 99\n";
        expected += "    final exam: 89\n";
        expected += "    total grade: 92\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\n";
        expected += "　　　　 3) A 顯示平均 (Average)\n";
        expected += "　　　　 4) W 更新配分 (Weight)\n";
        expected += "　　　　 5) E 離開選單 (Exit)\n";
        expected += ">> ";
        expected += "輸入ID或Q: ";
        expected += "程式結束。\n";
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
        System.setIn(new ByteArrayInputStream("975002039\nR\nE\nQ\n".getBytes()));
        UI ui1 = new UI();
        ui1.promptID();
        String expected = "";
        expected += "輸入ID或Q: Welcome 許琇筑.\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\n";
        expected += "　　　　 3) A 顯示平均 (Average)\n";
        expected += "　　　　 4) W 更新配分 (Weight)\n";
        expected += "　　　　 5) E 離開選單 (Exit)\n";
        expected += ">> ";
        expected += "許琇筑排名: 10\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\n";
        expected += "　　　　 3) A 顯示平均 (Average)\n";
        expected += "　　　　 4) W 更新配分 (Weight)\n";
        expected += "　　　　 5) E 離開選單 (Exit)\n";
        expected += ">> ";
        expected += "輸入ID或Q: ";
        expected += "程式結束。\n";
        assertEquals(expected, outContent.toString());
    }
    
    @Test
    public void showAverageTest() {
        System.setIn(new ByteArrayInputStream("975002039\nA\nE\nQ\n".getBytes()));
        UI ui1 = new UI();
        ui1.promptID();
        String expected = "";
        expected += "輸入ID或Q: Welcome 許琇筑.\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\n";
        expected += "　　　　 3) A 顯示平均 (Average)\n";
        expected += "　　　　 4) W 更新配分 (Weight)\n";
        expected += "　　　　 5) E 離開選單 (Exit)\n";
        expected += ">> ";
        expected += "各項成績平均：\n";
        expected += "    lab1平均: 90\n";
        expected += "    lab2平均: 87\n";
        expected += "    lab3平均: 89\n";
        expected += "    mid-term平均: 89\n";
        expected += "    final exam平均: 89\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\n";
        expected += "　　　　 3) A 顯示平均 (Average)\n";
        expected += "　　　　 4) W 更新配分 (Weight)\n";
        expected += "　　　　 5) E 離開選單 (Exit)\n";
        expected += ">> ";
        expected += "輸入ID或Q: ";
        expected += "程式結束。\n";
        assertEquals(expected, outContent.toString());
    }
    
    @Test
    public void reweightTest() {
        System.setIn(new ByteArrayInputStream("975002039\nW\n20\n20\n20\n20\n20\nY\nE\nQ\n".getBytes()));
        UI ui1 = new UI();
        ui1.promptID();
        String expected = "";
        expected += "輸入ID或Q: Welcome 許琇筑.\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\n";
        expected += "　　　　 3) A 顯示平均 (Average)\n";
        expected += "　　　　 4) W 更新配分 (Weight)\n";
        expected += "　　　　 5) E 離開選單 (Exit)\n";
        expected += ">> ";
        expected += "舊配分\n";
        expected += "    lab1 10%\n";
        expected += "    lab2 10%\n";
        expected += "    lab3 10%\n";
        expected += "    mid-term 30%\n";
        expected += "    final exam 40%\n";
        expected += "輸入新配分\n";
        expected += "    lab1 ";
        expected += "    lab2 ";
        expected += "    lab3 ";
        expected += "    mid-term ";
        expected += "    final exam ";
        expected += "請確認新配分\n";
        expected += "    lab1 20%\n";
        expected += "    lab2 20%\n";
        expected += "    lab3 20%\n";
        expected += "    mid-term 20%\n";
        expected += "    final exam 20%\n";
        expected += "以上正確嗎? Y (Yes) 或 N (No)\n";
        expected += ">> ";
        expected += "更改成功。\n";
        expected += "輸入指令 1) G 顯示成績 (Grade)\n";
        expected += "　　　　 2) R 顯示排名 (Rank)\n";
        expected += "　　　　 3) A 顯示平均 (Average)\n";
        expected += "　　　　 4) W 更新配分 (Weight)\n";
        expected += "　　　　 5) E 離開選單 (Exit)\n";
        expected += ">> ";
        expected += "輸入ID或Q: ";
        expected += "程式結束。\n";
        assertEquals(expected, outContent.toString());
    }

}
