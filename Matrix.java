/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiy;

import static utils.InputUtils.inputNum;

/**
 *
 * @author ducta
 */
public class Matrix {

    private int row;
    private int col;
    private int[][] matrix;

    public Matrix() {
        row = 0;
        col = 0;
        matrix = new int[row][col];
    }

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        matrix = new int[row][col];
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void inputMatrix(String matrixName) {
        row = inputNum("Enter Row " + matrixName + ": ");
        col = inputNum("Enter Row " + matrixName + ": ");
        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = inputNum("Enter " + matrixName + "[" + (i + 1) + "," + (j + 1) + "]=");
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    private Matrix addOrSub(Matrix matrix2, boolean isAdd) throws Exception {
        if (col == matrix2.getCol() && row == matrix2.getRow()) {
            Matrix ret = new Matrix(getRow(), getCol());
            for (int i = 0; i < getRow(); i++) {
                for (int j = 0; j < getCol(); j++) {
                    ret.getMatrix()[i][j] = isAdd ? matrix[i][j] + matrix2.getMatrix()[i][j]
                            : matrix[i][j] - matrix2.getMatrix()[i][j];
                }
            }
            return ret;
        }
        throw new Exception("The number of rows and columns must be equal!");
    }

    public Matrix add(Matrix matrix2) throws Exception {
        return addOrSub(matrix2, true);
    }

    public Matrix subtrac(Matrix matrix2) throws Exception {
        return addOrSub(matrix2, false);
    }

    public Matrix mul(Matrix matrix2) throws Exception {
        if (col == matrix2.getCol() && row == matrix2.getRow()) {
            Matrix mulMatrix = new Matrix(getRow(), matrix2.getCol());
            for (int i = 0; i < getRow(); i++) {
                for (int j = 0; j < matrix2.getCol(); j++) {
                    mulMatrix.getMatrix()[i][j] = 0;
                    for (int k = 0; k < getCol(); k++) {
                        mulMatrix.getMatrix()[i][j] += matrix[i][k] * matrix2.getMatrix()[k][j];
                    }
                }
            }
            return mulMatrix;
        }
        throw new Exception("The number of rows Matrix 1 and columns Matrix 2 must be equal!");
    }
    
}
