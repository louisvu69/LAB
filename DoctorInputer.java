/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;
import entity.Doctor;
import ultils.Validation;



public class DoctorInputer {
    
    private Doctor d;

    public Doctor getDoctor() {
        return d;
    }
    
    public DoctorInputer (){
        d = new Doctor();
    }
    
    public Doctor inputCommonInformation(){
        System.out.print("Enter code: ");
        d.setCode(Validation.inputString());
        d.setName(Validation.getStringByRegex("Enter name: ", "Character only! ", "[A-Za-z ]+"));
        d.setAvailability(Validation.getInt("Enter availability: ", "Integer only!", "Please enter from [0-9]", 0, 9));
        d.setSpecialization(Validation.getStringByRegex("Enter specialization: ", "Character only! ", "[A-Za-z ]+"));
        return d;
    }
    
}
