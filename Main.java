/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.Controller;
import utils.InputUtils;

/**
 *
 * @author ducta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Controller controler = new Controller();
        Menu menu = new Menu();
        menu.Add("======Calculator program======");
        menu.Add("1. Addition Matrix");
        menu.Add("2. Subtraction");
        menu.Add("3. Multiplication Matrix");
        menu.Add("4. Quit");
        int choose = 0;
        do {
            menu.Display();
            choose = InputUtils.inputNum("Your choice: ");
            switch (choose) {
                case 1:
                    System.out.println("--------Addition--------");
                    controler.addMatrix();
                    break;
                case 2:
                    System.out.println("--------Subtraction--------");
                    controler.subtracMatrix();
                    break;
                case 3:
                    System.out.println("--------Multiplication--------");
                    controler.mulMatrix();
                    break;
                case 4:
                    break;
            }
        } while (choose != 4);
    }

}
