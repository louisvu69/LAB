package ui;

import controller.WorkerManagerController;
import entity.Worker;

public class Main {

    public static void main(String[] args) throws Exception {
        Menu menuList = new Menu();
        do {
            menuList.displayMenu();
            int choice = menuList.getChoice();
            menuList.run(choice);
        } while (!menuList.isExit);
    }

}
