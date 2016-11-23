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
public class BSA320 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int AANTAL_VAKKEN = 7;
        Vak[] vakken = new Vak[AANTAL_VAKKEN];
        vakken[0] = new Vak("Fasten Your seatbelts", 12);
        vakken[1] = new Vak("Programming", 3);
        vakken[2] = new Vak("Databases", 3);
        vakken[3] = new Vak("Personal skills", 2);
        vakken[4] = new Vak("Project skills", 2);
        vakken[5] = new Vak("User intraction", 3);
        vakken[6] = new Vak("OOB1", 3);

        for (Vak vak : vakken) {
            System.out.print("Wat is je Cijfer voor " + vak.getNaam() + " : ");
            vak.setCijfer(input.nextDouble());
            
        }
    }

}
