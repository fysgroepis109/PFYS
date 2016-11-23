/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsa3.pkg2.pkg0;

/**
 *
 * @author Jaros
 */
public class Vak {
    
    private String naam;
    private int punten;
    private double cijfer;
    
    Vak(String naam, int punten){
        this.naam = naam;
        this.punten = punten;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public int getPunten(){
        return punten;
    }
    
    public double getCijfer(){
        return cijfer;
    }
    
    public void setCijfer(double cijfer){
        this.cijfer = cijfer;
    }
    
    public int gehaaldePunten(){
       
        
        return this.punten;
    }
    
    
    
    
    
    
}
