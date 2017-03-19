/**
 * Class UI: contains user interface that interact with users.
 * 
 * Bugs: none known.
 * 
 * @author  Taffy Cheng
 */
package com.github.taffy128s.gradesystem;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UI {
    
    private Scanner scanner;
    private RecordManager rm;
    
    /**
     * Constructor UI: construct a new UI.
     */
    public UI() {
        scanner = new Scanner(System.in);
        rm = new RecordManager();
    }
    
    /**
     * Method promptID: let user input ID or "Q".
     * 
     * Pseudo code:
     * 1. loop forever if there exists a new line.
     * 2. check if the input string is "Q", then program ends if so.
     * 3. if not, check if the input string is a valid ID, then show welcome message, call promptCommand if so.
     * 4. if not, show error message and loop again.
     * 
     * Complexity:
     * It takes O(n) to check if the ID exists or not.
     */
    public void promptID() {
        String input;
        System.out.print("輸入ID或Q: ");
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.equals("Q")) {
                System.out.println("程式結束。");
                break;
            } else {
                Record record = rm.getRecord(input);
                if (record != null) {
                    System.out.println("Welcome " + record.getName() + ".");
                    promptCommand(record);
                } else System.out.println("ID不存在。");
            }
            System.out.print("輸入ID或Q: ");
        }
    }
    
    /**
     * Method promptCommand: let user input commands.
     * 
     * Pseudo code:
     * 1. show commands.
     * 2. loop forever if there is a new line.
     * 3. check if the input equals to "G", then show record content if so.
     * 4. if not, check if it equals to "R", then show student rank if so.
     * 5. if not, check if it equals to "A", then call showAverages if so.
     * 6. if not, check if it equals to "W", then call tryToReweight if so.
     * 7. if not, check if it equals to "E", then break if so.
     * 8. if not, show "unknown command".
     * 9. show commands and continue.
     * 
     * Complexity:
     * It takes O(n) to show averages or reweight all the records.
     */
    public void promptCommand(Record record) {
        String input;
        showCommand();
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.equals("G")) System.out.println(record);
            else if (input.equals("R")) System.out.println(record.getName() + "排名: " + rm.getRank(record));
            else if (input.equals("A")) showAverages();
            else if (input.equals("W")) tryToReweight();
            else if (input.equals("E")) break;
            else System.out.println("未知的指令。");
            showCommand();
        }
    }   
    
    /**
     * Method tryToReweight: try to reweight the total score in every record.
     * 
     * Pseudo code:
     * 1. show present weights.
     * 2. let the user key in five new weights.
     * 3. flush the scanner.
     * 4. check if the weights are valid, then call showWeights, askForReweight if so.
     * 5. if not, print error message "sum must be 100".
     * 6. catches InputMismatchException, show "please input valid number" and flush scanner.
     * 7. catches NoSuchElementException, show "EOF detected".
     * 
     * Complexity:
     * it spends O(n) to update the score weights in method askForReweight.
     */
    private void tryToReweight() {
        showWeights(rm.getWeights(), "舊配分");
        System.out.println("輸入新配分");
        try {
            int[] weights = new int[Record.mColumnNum];
            for (int i = 0; i < Record.mColumnNum; i++) {
                System.out.print("    " + Record.mColumnNames[i] + " ");
                weights[i] = scanner.nextInt();
            }
            scanner.nextLine();
            if (checkValidWeights(weights)) {
                showWeights(weights, "請確認新配分");
                askForReweight(weights);
            } else System.out.println("和必須是100。");
        } catch (InputMismatchException e) {
            System.out.println("請輸入合法數字。");
            scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("偵測到EOF。");
        }
    }
    
    /**
     * Method askForReweight: ask user for reweighting.
     * 
     * @param weights: the weights of the scores, must be summed up to 100.
     * 
     * Pseudo code:
     * 1. print the confirmation request message.
     * 2. check if there is a new line and the input equals to "Y".
     * 3. if so, update the score weights of all records and print "modify successfully".
     * 3. if not, print "modification canceled".
     * 
     * Complexity:
     * O(n) to update the score weights of all records.
     */
    private void askForReweight(int[] weights) {
        System.out.println("以上正確嗎? Y (Yes) 或 N (No)");
        System.out.print(">> ");
        if (scanner.hasNextLine()) {
            if (scanner.nextLine().equals("Y")) {
                rm.reweightAll(weights);
                System.out.println("更改成功。");
            } else System.out.println("取消更改。");
        } else System.out.println("偵測到EOF。");
    }
    
    /**
     * Method checkValidWeights: check if the weights can be summed up to 100 or not.
     * 
     * @param weights: the weights of scores.
     * @return true if weights can be summed up to 100, false if not.
     * 
     * Pseudo code:
     * 1. sum up all of the weights.
     * 2. check if they are 100, return true if so.
     * 3. if not, return false.
     * 
     * Complexity:
     * the number of weights is constant, so it takes O(1) to check.
     */
    private boolean checkValidWeights(int[] weights) {
        int temp = 0;
        for (int i = 0; i < weights.length; i++)
            temp += weights[i];
        if (temp == 100) return true;
        else return false;
    }
    
    /**
     * Method showWeights: show the given weights, and the header string.
     * 
     * @param weights: weights to show.
     * @param header: header string to show.
     * 
     * Pseudo code:
     * 1. print the header string.
     * 2. loop over the weights.
     * 3. show the column names and the weights.
     * 
     * Complexity:
     * O(1) because Record.mColumnNum is constant.
     */
    private void showWeights(int[] weights, String header) {
        System.out.println(header);
        for (int i = 0; i < Record.mColumnNum; i++)
            System.out.println("    " + Record.mColumnNames[i] + " " + weights[i] + "%");
    }
    
    /**
     * Method showAverages: show the averages of all the scores.
     * 
     * Pseudo code:
     * 1. print "The averages of all the scores".
     * 2. get the averages from RecordManager.
     * 3. show the column names and average scores.
     * 
     * Complexity:
     * O(n) to calculate averages from all the records.
     */
    private void showAverages() {
        System.out.println("各項成績平均：");
        int[] averages = rm.getAverages();
        for (int i = 0; i < Record.mColumnNum; i++)
            System.out.println("    " + Record.mColumnNames[i] + "平均: " + averages[i]);
    }
    
    /**
     * Method showCommand: show the valid commands.
     * 
     * Pseudo code:
     * 1. print all of the valid commands.
     * 
     * Complexity:
     * O(1).
     */
    private void showCommand() {
        System.out.println("輸入指令 1) G 顯示成績 (Grade)");
        System.out.println("　　　　 2) R 顯示排名 (Rank)");
        System.out.println("　　　　 3) A 顯示平均 (Average)");
        System.out.println("　　　　 4) W 更新配分 (Weight)");
        System.out.println("　　　　 5) E 離開選單 (Exit)");
        System.out.print(">> ");
    }
    
}
