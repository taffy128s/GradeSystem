package com.github.taffy128s.gradesystem;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UI {
    
    private Scanner scanner;
    private RecordManager rm;
    
    public UI() {
        scanner = new Scanner(System.in);
        rm = new RecordManager();
    }
    
    public void promptID() {
        String input;
        System.out.print("輸入ID或Q: ");
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.equals("Q")) {
                System.out.println("程式結束。");
                System.exit(0);
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
    
    private void askForReweight(int[] weights) {
        System.out.println("以上正確嗎? Y (Yes) 或 N (No)");
        System.out.print(">> ");
        if (scanner.hasNextLine()) {
            if (scanner.nextLine().equals("Y")) {
                rm.reweightAll(weights);
                System.out.println("更改成功。");
            } else System.out.println("取消更改。");
        } else System.out.println("取消更改。");
    }
    
    private void tryToReweight() {
        showPresentWeights();
        System.out.println("輸入新配分");
        try {
            int[] weights = new int[Record.mColumnNum];
            for (int i = 0; i < Record.mColumnNum; i++) {
                System.out.print("    " + Record.mColumnNames[i] + " ");
                weights[i] = scanner.nextInt();
            }
            scanner.nextLine();
            showTempWeights(weights);
            askForReweight(weights);
        } catch (InputMismatchException e) {
            System.out.println("請輸入合法數字。");
            scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("偵測到EOF。");
        }
    }
    
    private void showTempWeights(int[] weights) {
        System.out.println("請確認新配分");
        for (int i = 0; i < Record.mColumnNum; i++)
            System.out.println("    " + Record.mColumnNames[i] + " " + weights[i] + "%");
    }
    
    private void showPresentWeights() {
        System.out.println("舊配分");
        int[] weights = rm.getWeights();
        for (int i = 0; i < Record.mColumnNum; i++)
            System.out.println("    " + Record.mColumnNames[i] + " " + weights[i] + "%");
    }
    
    private void showAverages() {
        System.out.println("各項成績平均：");
        int[] averages = rm.getAverages();
        for (int i = 0; i < Record.mColumnNum; i++)
            System.out.println("    " + Record.mColumnNames[i] + "平均: " + averages[i]);
    }
    
    private void showCommand() {
        System.out.print("輸入指令 ");
        System.out.println("1) G 顯示成績 (Grade)");
        System.out.print("　　　　 ");
        System.out.println("2) R 顯示排名 (Rank)");
        System.out.print("　　　　 ");
        System.out.println("3) A 顯示平均 (Average)");
        System.out.print("　　　　 ");
        System.out.println("4) W 更新配分 (Weight)");
        System.out.print("　　　　 ");
        System.out.println("5) E 離開選單 (Exit)");
        System.out.print(">> ");
    }
    
}
