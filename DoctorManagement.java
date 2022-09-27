/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import entity.Doctor;

public class DoctorManagement {

    private ArrayList<Doctor> doctors;

    public DoctorManagement() {
        doctors = new ArrayList<>();
    }

    public ArrayList<Doctor> getDoctorsList() {
        return doctors;
    }

    public boolean addDoctor(Doctor d) {
        if (!checkIsExist(d)) {
            doctors.add(d);
        }
        return doctors.add(d);
    }

    public boolean checkIsExist(Doctor d) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getCode().contains(d.getCode())) {
                return false;
            }
        }
        return true;
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
        try {
            if (index != -1) {
                return doctors.get(index);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Code not found!");
        }
        return null;
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

}
