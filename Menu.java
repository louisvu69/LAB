package ui;

import entity.Worker;
import utils.Validation;
import controller.WorkerManagerController;

public class Menu {

    boolean isExit;
    private WorkerManagerController controller = new WorkerManagerController();

    public void displayMenu() {
        System.out.println("========= Worker Managerment =========");
        System.out.println("    1.Add Worker");
        System.out.println("    2.Increase salary for worker.");
        System.out.println("    3.Decrease for worker.");
        System.out.println("    4.Show adjusted salary worker information.");
        System.out.println("    5.Exit");
    }

    public int getChoice() {
        return Validation.getInt("", "Invalid input", "Please enter from 1 to 5 ", 1, 5);
    }

    public void run(int choice) throws Exception {

        try {
            switch (choice) {
                case 1:
                    try {
                        do {
                            Worker addWorker = controller.addWorker();
                            if (addWorker != null) {
                                System.err.println("Add success!");
                                System.out.println(addWorker);
                            }
                        } while (Validation.pressYNtoContinue("Do you want to continue? (Y/N): "));
                    } catch (Exception e) {

                    }
                    break;
                case 2:
                    try {
                        Worker increseWorkerSalary = controller.increaseWokerSalary();
                        System.err.println("Update success!");
                        System.out.println(increseWorkerSalary);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Worker decreaseWorkerSalary = controller.decreaseWorkerSalary();
                        System.out.println("Update success!");
                        System.out.println(decreaseWorkerSalary);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 4:
                    controller.displayAdjustedWorkerList();
                    break;
                case 5:
                    isExit = true;
                    System.out.println("Latta boi!");
                    return;
            }
        } catch (Exception e) {
//                e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

}
