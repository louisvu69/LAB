/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import entity.Doctor;
import ultils.Validation;

/**
 *
 * @author My PC
 */
public class DoctorManagement {

    private ArrayList<Doctor> doctors;

    public DoctorManagement() {
        doctors = new ArrayList<>();
    }

    public void report() {
        System.out.printf("%-22s%-22s%-22s%-22s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor doctor : doctors) {
            System.out.printf("%-22s%-22s%-22s%-22d\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
        }
    }

    public DoctorManagement(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Doctor addDoctor(Doctor c) {
        doctors.add(c);
        return c;
    }

    public Doctor updateDoctor(String code, Doctor c) throws Exception {
        int index = searchByCode(code);
        if (index != -1) {
            c.setCode(code);
            doctors.set(index, c);
            return c;
        }
        throw new Exception("Doctor not found!");
    }

    public Doctor deleteDoctorByCode(String code) throws Exception {
        int index = searchByCode(code);
        if (index != -1) {
            return doctors.remove(index);
        }
        throw new Exception("Doctor does not exist!");
    }

    private int searchByCode(String code) {
        for (int index = 0; index < doctors.size(); index++) {
            if (doctors.get(index).getCode() == null ? code == null : doctors.get(index).getCode().equals(code)) {
                return index;
            }
        }
        return -1;
    }

    public Doctor getDoctorByCode(String code) throws Exception {
        int index = searchByCode(code);
        if (index != -1) {
            return doctors.get(index);
        }
        throw new Exception("Id not found");
    }

    public ArrayList<Doctor> searchByNameAndCode(String text) {
        ArrayList<Doctor> ret = new ArrayList<>();
        for (Doctor c : doctors) {
            if ((c.getName().toLowerCase().contains(text.toLowerCase())) && (c.getCode().toLowerCase().contains(text.toLowerCase()))) {
                ret.add(c);
            }
        }
        return ret;
    }

}
