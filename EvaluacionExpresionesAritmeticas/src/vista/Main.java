/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import java.util.List;
import static modelo.InfijaAPostfija.evaluarExpresionPostfija;
import static modelo.InfijaAPostfija.infijaAPostfija;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String expresionInfija = "a*(b+c-(d/e^f)-g)-h";

        List<Character> expresionPostfija = infijaAPostfija(expresionInfija.toString());
        System.out.println("Expresion Infija: " + expresionInfija);
        System.out.println("Expresion Postfija: " + expresionPostfija);
        System.out.println("Resultado: " + evaluarExpresionPostfija(expresionPostfija));
    }
    
}
