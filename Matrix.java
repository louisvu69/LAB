/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import ultils.Validation;

/**
 *
 * @author My PC
 */
public class Matrix {

    private int row;
    private int column;
    private int[][] data;

    public Matrix() {
    }

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.data = new int[row][column];
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getData() {
        return data;
    }

    public void inputMatrix(String m) {
        this.row = Validation.getInt("Enter row number of matrix " + m + " : ", "Integer only!", "Please enter from range "
                + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.column = Validation.getInt("Enter column number of matrix " + m + " : ", "Integer only!", "Please enter from range "
                + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        data = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter number of " + m + "[" + i + "][" + j + "]: ");
                this.data[i][j] = Validation.checkInputInt();
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print("[" + this.data[i][j] + "]");
            }
            System.out.println();
        }
    }

}
