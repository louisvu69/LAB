package controller;

import bo.WorkerInputter;
import bo.WorkerManager;
import entity.Worker;
import java.util.ArrayList;
import utils.Validation;

public class WorkerManagerController {

    private WorkerInputter workerInputter;
    private WorkerManager workerManager;

    public WorkerManagerController() {
        workerManager = new WorkerManager();
    }

    public Worker inputWorker() {
        workerInputter = new WorkerInputter();
        Worker w = workerInputter.inputInformation();
        return w;
    }

    public Worker addWorker() throws Exception {
        Worker s = inputWorker();
        if (workerManager.addWorker(s)) {
            return s;
        }
        throw new Exception("Add fail!");
    }

    public Worker increaseWokerSalary() throws Exception {
        String ID = Validation.intputSring("Enter the ID you wanna update: ", "Invalid Fomat");
        Worker w = workerManager.getWorkerById(ID);
        Double money = Validation.inputDouble("Enter amout of money: ", 0.0000001, Double.MAX_VALUE);
        return workerManager.increaseWokerSalary(ID, w, money);
    }

    public Worker decreaseWorkerSalary() throws Exception {
        String ID = Validation.intputSring("Enter the ID you wanna update: ", "Invalid Fomat");
        Worker w = workerManager.getWorkerById(ID);
        Double money = Validation.inputDouble("Enter amout of money: ", 0.0000001, Double.MAX_VALUE);
        return workerManager.decreaseWokerSalary(ID, w, money);
    }

    public void displayAdjustedWorkerList() {
        ArrayList<Worker> listWorkers = workerManager.getWorkerList();
        System.out.println(Worker.DISPLAY_HEADER);
        for (Worker listWorker : listWorkers) {
            System.out.println(listWorker);
        }
    }
}
