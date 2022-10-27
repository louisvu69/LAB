/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author My PC
 */
import entity.Worker;
import utils.Validation;

public class WorkerInputter {

    private Worker w;

    public WorkerInputter() {
        w = new Worker();
    }

    public Worker getWorker() {
        return w;
    }

    public Worker inputInformation() {
        w.setID(Validation.intputSring("Enter ID: ", "Eror Format"));
        w.setName(Validation.intputSring("Enter Name: ", "Eror Format"));
        w.setAge(Validation.inputChoice("Enter Age: ", 18, 50));
        w.setSalary(Validation.inputDouble("Enter Salary: ", 0.0000001, Double.MAX_VALUE));
        w.setWorkLocation(Validation.intputSring("Enter Location: ", "Eror Format"));
        w.setStatus("Normal");

        return w;
    }

}
