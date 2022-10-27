/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Matrix;

/**
 *
 * @author My PC
 */
public class MatrixCaculator {

    private Matrix addition(Matrix m1, Matrix m2) {
        Matrix result = new Matrix(m1.getRow(), m2.getColumn());
        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m2.getColumn(); j++) {
                result.getData()[i][j] = m1.getData()[i][j] + m2.getData()[i][j];
            }
        }
        return result;
    }

    private Matrix subtraction(Matrix m1, Matrix m2) {
        Matrix result = new Matrix(m1.getRow(), m2.getColumn());
        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m2.getColumn(); j++) {
                result.getData()[i][j] = m1.getData()[i][j] - m2.getData()[i][j];
            }
        }
        return result;
    }

    private Matrix multiplication(Matrix m1, Matrix m2) {
        Matrix result = new Matrix(m1.getRow(), m2.getColumn());
        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m2.getColumn(); j++) {
                result.getData()[i][j] = 0;
                for (int k = 0; k < m1.getColumn(); k++) {
                    result.getData()[i][j] += m1.getData()[i][k] * m2.getData()[k][j];
                }
            }
        }
        return result;
    }

    public boolean checkIfAddable(Matrix matrix1, Matrix matrix2) {
        return matrix1.getRow() == matrix2.getRow() && matrix1.getColumn() == matrix2.getColumn();
    }

    public boolean checkIfSubtractable(Matrix matrix1, Matrix matrix2) {
        return matrix1.getRow() == matrix2.getRow() && matrix1.getColumn() == matrix2.getColumn();
    }

    public boolean checkIfMultiplicable(Matrix matrix1, Matrix matrix2) {
        return matrix1.getColumn() == matrix2.getRow();
    }

    public void displayCalculation(Matrix m1, Matrix m2, String operator) {
        m1.displayMatrix();
        System.out.println(operator);
        m2.displayMatrix();
        System.out.println(" = ");
    }

    public void displayAdditionResult(Matrix m1, Matrix m2) {
        Matrix result = addition(m1, m2);
        displayCalculation(m1, m2, " + ");
        result.displayMatrix();
    }

    public void displaySubtractionResult(Matrix m1, Matrix m2) {
        Matrix result = subtraction(m1, m2);
        displayCalculation(m1, m2, " - ");
        result.displayMatrix();
    }

    public void displayMultiplicationResult(Matrix m1, Matrix m2) {
        Matrix result = multiplication(m1, m2);
        displayCalculation(m1, m2, " * ");
        result.displayMatrix();
    }
    
    
}
