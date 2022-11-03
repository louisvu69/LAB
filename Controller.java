/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entiy.Matrix;
import java.math.BigInteger;
import utils.InputUtils;

/**
 *
 * @author ducta
 */
public class Controller {

    public Controller() {
    }

    public void addMatrix() throws Exception {
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        Matrix sumMatrix = new Matrix();
        matrix1.inputMatrix("Matrix1");
        matrix2.inputMatrix("Matrix2");
        try {
            sumMatrix = matrix1.add(matrix2);
            System.out.println("--------Reult--------");
            sumMatrix.displayMatrix();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void subtracMatrix() throws Exception {
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        Matrix subMatrix = new Matrix();
        matrix1.inputMatrix("Matrix1");
        matrix2.inputMatrix("Matrix2");
        try {
            subMatrix = matrix1.subtrac(matrix2);
            System.out.println("--------Reult--------");
            subMatrix.displayMatrix();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void mulMatrix() throws Exception {
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        Matrix multipMatrix = new Matrix();
        matrix1.inputMatrix("Matrix1");
        matrix2.inputMatrix("Matrix2");
        try {
            multipMatrix = matrix1.mul(matrix2);
            System.out.println("--------Reult--------");
            multipMatrix.displayMatrix();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
