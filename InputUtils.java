/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author ducta
 */
public class InputUtils {

    static Scanner scan = new Scanner(System.in);

    public static int inputNum(String msg) {
        int value = 0;
        String str = null;
        boolean check = true;
        do {
            check = true;
            try {
                System.out.print(msg);
                str = scan.nextLine();
                value = Integer.parseInt(str);
            } catch (Exception e) {
                System.err.println("Please enter an integer!");
                check = false;
            }
        } while (!check);
        return value;
    }
    
}
