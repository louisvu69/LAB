/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import entity.Doctor;
import java.util.Collections;

public class DoctorManagement {

    private ArrayList<Doctor> doctors;

    public DoctorManagement() {
        doctors = new ArrayList<>();
    }

    public ArrayList<Doctor> getDoctorsList() {
        return doctors;
    }

    public boolean addDoctor(Doctor d) throws Exception {
        if (!checkIsExist(d)) {
           return doctors.add(d);
        }
        throw new Exception("Doctor code already exist");
    }

    public boolean checkIsExist(Doctor d) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getCode().contains(d.getCode())) {
                return true;
            }
        }
        return false;
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

    public int searchByCode(String code) {
        for (int index = 0; index < doctors.size(); index++) {
            if (doctors.get(index).getCode().equals(code)) {
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
        throw new Exception();

    }

    public ArrayList<Doctor> searchByNameAndCode(String text) {
        ArrayList<Doctor> ret = new ArrayList<>();
        for (Doctor c : doctors) {
            if ((c.getName().toLowerCase().contains(text.toLowerCase())) || (c.getCode().toLowerCase().contains(text.toLowerCase()))) {
                ret.add(c);
            }
        }
        return ret;
    }
    
    private void sort(ArrayList<Doctor> list) {
        Collections.sort(list, (Doctor s1, Doctor s2) -> s1.getName().compareTo(s2.getName()));
    }

    public void report(ArrayList<Doctor> doctors) {
        System.out.printf("\t%-22s%-22s%-22s%-22s\n", "Code", "Name", "Specialization", "Availability");
        int index = 0;
        sort(doctors);
        for (Doctor doctor : doctors) {
            index++;
            System.out.printf("[" + "%d" + "]\t" + "%-22s%-22s%-22s%-22d\n", index, doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
        }
    }
}
