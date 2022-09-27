/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bo.DoctorInputer;
import ultils.Validation;
import controller.DoctorManagerController;
import bo.DoctorManagement;

/**
 *
 * @author My PC
 */
public class Menu {

    public Boolean isExit = false;
    private DoctorManagerController controller = new DoctorManagerController();

    public void displayMenu() {
        System.out.println("============== Doctor Management ==============");
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
    }

    public int getChoice() {
        return Validation.inputInt();
    }

    public void run(int choice) throws Exception {
        switch (choice) {
            case 1:
                controller.addAllDoctor();
                break;
            case 2:
                controller.updateDoctor();
                break;
            case 3:
                controller.deleteDoctor();
                break;
            case 4:
                controller.searchingDoctor();
                break;
            case 5:
                isExit = true;
                break;
        }
    }
}
