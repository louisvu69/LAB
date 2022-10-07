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
/**
 *
 * @author My PC
 */
public class DoctorManagerController {

    private DoctorInputer doctorInputer;
    private DoctorManagement doctorManager;

    public DoctorManagerController() {
        doctorManager = new DoctorManagement();
    }

    private Doctor inputDoctor() {
        doctorInputer = new DoctorInputer();
        Doctor d = doctorInputer.inputCommonInformation();
        return d;
    }

    public Doctor addDoctor() throws Exception {
        Doctor d = inputDoctor();
        if (doctorManager.addDoctor(d)) {
            return d;
        }
        throw new Exception("Add fail!");
    }

    public void displayAllDocotor() {
        for (Doctor o : doctorManager.getDoctorsList()) {
            System.out.println(o);
        }
    }

    public Doctor deleteDoctor(String code) throws Exception {
        doctorInputer = new DoctorInputer();
        Doctor d = doctorManager.getDoctorByCode(code);
        if (d != null) {
            return doctorManager.deleteDoctorByCode(code);
        }
        return null;
    }

    public Doctor updateDoctor(String code) throws Exception {
        doctorInputer = new DoctorInputer();
        Doctor d = doctorManager.getDoctorByCode(code);
        if (d != null) {
            return doctorInputer.updateDoctorInformation(d);
        }
        return null;
    }

    public void searchingDoctor(String text) throws Exception {
        ArrayList<Doctor> listFound = doctorManager.searchByNameAndCode(text);
        if (listFound.isEmpty()) {
            throw new Exception();
        } else {
            doctorManager.report(listFound);
        }

    }
//
//    public void addAllDoctor() throws Exception {
//        try {
//            do {
//                if (doctorManager.addDoctor(inputDoctor())) {
//                    doctorInputer.getDoctor();
//                }
//            } while (Validation.pressYNtoContinue("Do you want to add more? (Y/N): "));
//        } catch (Exception e) {
//            System.err.println("Add fail!");
//            System.err.println("Enter again!");
//        }
//    }

}
