package bo;

import entity.Worker;
import java.util.ArrayList;

public class WorkerManager {

    private ArrayList<Worker> workerlist;

    public WorkerManager() {
        workerlist = new ArrayList<>();
    }

    public ArrayList<Worker> getWorkerList() {
        return workerlist;
    }

    public boolean isDupplicate(Worker w) {
        for (int i = 0; i < workerlist.size(); i++) {
            if (workerlist.get(i).getID().contains(w.getID())) {
                return true;
            }
        }
        return false;
    }

    public boolean addWorker(Worker w) throws Exception {
        if (!isDupplicate(w)) {
            return workerlist.add(w);
        }
        throw new Exception("Dupplicate id!");
    }

    private int searchById(String id) {
        for (int index = 0; index < workerlist.size(); index++) {
            if (workerlist.get(index).getID().equalsIgnoreCase(id)) {
                return index;
            }
        }
        return -1;
    }

    public Worker getWorkerById(String id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return workerlist.get(index);
        }
        throw new Exception("Id not found");
    }

    public Worker increaseWokerSalary(String ID, Worker w, double money) throws Exception {
        String status = "";
        double moneyAfterUpdate = 0;
        moneyAfterUpdate = w.getSalary() + money;
        status = "UP";
        w.setSalary(moneyAfterUpdate);
        w.setStatus(status);
        return w;
    }

    public Worker decreaseWokerSalary(String ID, Worker w, double money) throws Exception {
        String status = "";
        double moneyAfterUpdate = 0;
        if (w.getSalary() > money) {
            moneyAfterUpdate = w.getSalary() - money;
            status = "Down";
        } else {
            moneyAfterUpdate = 0;
            throw new Exception("The amout of salary must be greater than the money");
        }
        w.setSalary(moneyAfterUpdate);
        w.setStatus(status);
        return w;
    }

}
