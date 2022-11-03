/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author ducta
 */
public class Menu {
    int Num;
    String [] item = new String[10];

    public Menu() {
        Num=0;
    }
    public void Add(String s){
        item[Num++]=s;
    }
    public void Display(){
        for (int i=0;i<Num;i++){
            System.out.println(item[i]);
        }
    }
}
