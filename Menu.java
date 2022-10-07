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
import entity.Doctor;
import java.util.ArrayList;

/**
 *
 * @author My PC
 */
public class Menu {

    public Boolean isExit = false;
    private DoctorManagerController controller = new DoctorManagerController();
    private DoctorManagement doctorManager = new DoctorManagement();

    public void displayMenu() {
        System.out.println("============== Doctor Management ==============");
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
    }

    public int getChoice() {
        return Validation.getInt("", "Integer only!", "Please enter from [1] to [5] ", 1, 5);
    }

    public void run(int choice) throws Exception {

        try {
            switch (choice) {
                case 1:
                    do {
                        Doctor addDoctor = controller.addDoctor();
                        if (addDoctor == null) {
                            System.err.println("Add doctor fail!");
                        } else {
                            System.err.println("Add doctor success!");
                            System.out.println(addDoctor);
                        }
                    } while (Validation.pressYNtoContinue("Do you want to add more? (Y/N): "));
                    break;
                case 2:
                    System.out.println("Enter doctor's code you want to update: ");
                    String codeUpdate = Validation.inputString();
                    try {
                        Doctor updateDoctor = controller.updateDoctor(codeUpdate);
                        if (updateDoctor == null) {
                            throw new Exception();
                        } else {
                            System.err.println("Update doctor success!");
                            System.out.println(updateDoctor);
                        }
                    } catch (Exception e) {
                        System.err.println("Update doctor fail!");
                    }
                    break;
                case 3:
                    System.out.println("Enter doctor's code you want to delete: ");
                    String codeDelete = Validation.inputString();
                    try {
                        Doctor deleteDoctor = controller.deleteDoctor(codeDelete);
                        if (deleteDoctor == null) {
                            throw new Exception();
                        } else {
                            System.err.println("Delete success full!");
                            System.out.println(deleteDoctor);
                        }
                    } catch (Exception e) {
                        System.err.println("Delete doctor fail!");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Enter text: ");
                        String text = Validation.inputString();
                        System.out.println("The Doctors found:");
                        controller.searchingDoctor(text);
                    } catch (Exception e) {
                        System.err.println("Not found!");
                    }
//                    controller.displayAllDocotor();
                    break;
                case 5:
                    isExit = true;
                    break;
            }
        } catch (Exception e) {
//                e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
