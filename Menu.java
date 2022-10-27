/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import ultils.Validation;
import bo.MatrixCaculator;
import entity.Matrix;

/**
 *
 * @author My PC
 */
public class Menu {

    boolean isExit;
    private MatrixCaculator calculator = new MatrixCaculator();
    private Matrix m1 = new Matrix();
    private Matrix m2 = new Matrix();

    public void displayMenu() {
        System.out.println("=========Calculator program===========");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
    }

    public int getChoice() {
        return Validation.getInt("", "Invalid input", "Please enter from 1 to 4 ", 1, 4);
    }

    public void run(int choice) throws Exception {
        try {

            switch (choice) {
                case 1:
                    System.out.println("Enter your matrix's data: ");
                    m1.inputMatrix("1");
                    m2.inputMatrix("2");
                    if (calculator.checkIfAddable(m1, m2)) {
                        calculator.displayAdditionResult(m1, m2);
                    } else {
                        System.err.println("Two matrices are not the same!");
                    }
                    break;
                case 2:
                    System.out.println("Enter your matrix's data: ");
                    m1.inputMatrix("1");
                    m2.inputMatrix("2");
                    if (calculator.checkIfSubtractable(m1, m2)) {
                        calculator.displaySubtractionResult(m1, m2);
                    } else {
                        System.err.println("Two matrices are not the same!");
                    }
                    break;
                case 3:
                    System.out.println("Enter your matrix's data: ");
                    m1.inputMatrix("1");
                    m2.inputMatrix("2");
                    if (calculator.checkIfMultiplicable(m1, m2)) {
                        calculator.displayMultiplicationResult(m1, m2);
                    } else {
                        System.err.println("Matrix 1's column does not match with matrix 2's row!");
                    }
                    break;
                case 4:
                    isExit = true;
                    break;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
