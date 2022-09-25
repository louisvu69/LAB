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
    private DoctorManagement functions = new DoctorManagement();
    private DoctorManagerController controller = new DoctorManagerController();
    public void displayMenu() {
        System.out.println("======== Student Management ========");
        System.out.println("   1. Create");
        System.out.println("   2. Show all ");
        System.out.println("   3. Update/Delete ");
        System.out.println("   4. Report ");
        System.out.println("   5. Exit");
    }

    public int getChoice() {
        return Validation.inputInt();
    }

    public void run(int choice) {
        switch (choice) {
            case 1:
                controller.addDoctor();
                break;
            case 2:
                controller.searching();
                break;
            case 3:
               
                break;
            case 4:
               
                break;
            case 5:
                isExit = true;
                break;
        }
    }
}
