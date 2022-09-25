/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.DoctorInputer;
import bo.DoctorManagement;
import entity.Doctor;
import java.util.ArrayList;
import ultils.Validation;
/**
 *
 * @author My PC
 */
public class DoctorManagerController {

    private DoctorInputer doctorInputer;
    private DoctorManagement doctorManager;

    public DoctorManagerController(){
        doctorManager = new DoctorManagement();
    }
    
    private Doctor inputDoctor(Doctor d) {
        doctorInputer = new DoctorInputer();
        doctorInputer.inputCommonInformation();
        d = doctorInputer.getDoctor();
        doctorManager.addDoctor(d);
        return d;
    }

    private Doctor inputInDoctor() {
        Doctor d = new Doctor();
        inputDoctor(d);
        return d;
    }

    public void addDoctor() {
        ArrayList<Doctor> ret = new ArrayList<>();
        do {
            ret.add(inputInDoctor());
        } while (Validation.pressYNtoContinue("Do you want to continue? (Y/N): "));
    }
    
    private void displayAllDoctor() {
        System.out.println("List of Doctor:");
        System.out.println(doctorManager);
    }
    
    public void searching() {
        System.out.println("Enter text: ");
        String text = Validation.inputString();
        ArrayList<Doctor> listFound = doctorManager.searchByNameAndCode(text);
        if (listFound.isEmpty()) {
            System.out.println("Not found!");
        } else {
            System.out.println("The Doctors found:");
            for (Doctor c : listFound) {
                System.out.println(c);
            }
        }

    }
    
}
