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
import java.util.Collections;
import ultils.Validation;

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
        if (doctorManager.checkIsExist(d)) {
            return d;
        } else {
            System.err.println("Dupplicate code!");
            System.out.println("Enter again");
            return inputDoctor();
        }
    }

    public Doctor addAllDoctor() throws Exception {
        if (doctorManager.addDoctor(inputDoctor())) {
            return doctorInputer.getDoctor();
        }
        throw new Exception("Add Fail");
    }

    public void displayAllDocotor() {
        for (Doctor o : doctorManager.getDoctorsList()) {
            System.out.println(o);
        }
    }

    public void deleteDoctor() throws Exception {

        doctorInputer = new DoctorInputer();
        Doctor d = doctorInputer.inputDoctorCodeToDelete();
        try {
            if (!doctorManager.checkIsExist(d)) {
                doctorManager.deleteDoctorByCode(d.getCode());
                System.out.println("Delete successful!");
            } else {
                System.err.println("Not found or something went wrong with the code!");
                System.out.println("Enter again!");
                deleteDoctor();
            }
        } catch (Exception e) {
            System.err.println("Not found!");
            deleteDoctor();
        }

    }

    public void updateDoctor() {
        System.out.println("Enter doctor's code you want to update: ");
        String code = Validation.inputString();
        ArrayList<Doctor> list = doctorManager.searchByNameAndCode(code);
        if (list.isEmpty()) {
            System.out.println("Doctor's code not found!");
        } else {
            try {
                System.out.println("Found " + list.size() + " doctor(s) with code " + code);
                report(list);
                int choose = Validation.getInt("Choose doctor you want to update (from [1] to [...]: ", "Integer only!", "Enter from 1 to [" + String.valueOf(list.size()) + "]", 0, list.size());
                Doctor doctor = list.get(choose - 1);
                doctorInputer.updateDoctorInformation(doctor);
            } catch (Exception e) {
                System.err.println("Something went wrong with the input!");
            }
        }
    }

    private void sort(ArrayList<Doctor> list) {
        Collections.sort(list, (Doctor s1, Doctor s2) -> s1.getName().compareTo(s2.getName()));
    }

    private void report(ArrayList<Doctor> doctors) {
        System.out.printf("\t%-22s%-22s%-22s%-22s\n", "Code", "Name", "Specialization", "Availability");
        int index = 0;
        for (Doctor doctor : doctors) {
            index++;
            System.out.printf("[" + "%d" + "]\t" + "%-22s%-22s%-22s%-22d\n", index, doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
        }
    }

    public void searchingDoctor() {
        System.out.println("Enter text: ");
        String text = Validation.inputString();
        ArrayList<Doctor> listFound = doctorManager.searchByNameAndCode(text);
        if (listFound.isEmpty()) {
            System.out.println("Not found!");
        } else {
            System.out.println("The Doctors found:");
            sort(listFound);
            report(listFound);
        }

    }

}
