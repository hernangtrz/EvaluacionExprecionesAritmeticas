/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class InfijaAPostfija {

    public static boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^';
    }

    public static int prioridad(char operador) {
        if (operador == '^') {
            return 3;
        }
        if (operador == '*' || operador == '/') {
            return 2;
        }
        if (operador == '+' || operador == '-') {
            return 1;
        }
        return 0;
    }

    public static List<Character> infijaAPostfija(String expresion) {
        Stack<Character> pilaOperadores = new Stack<>();
        List<Character> exPostfija = new ArrayList<>();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if ((esOperador(caracter) == false) && (caracter != '(') && (caracter != ')')) {
                exPostfija.add(caracter);
            }
            if (caracter == '(') {
                pilaOperadores.push(caracter);
            }
            if (caracter == ')') {
                while (!pilaOperadores.isEmpty() && pilaOperadores.peek() != '(') {
                    char operador = pilaOperadores.pop();
                    exPostfija.add(operador);
                }
                pilaOperadores.pop(); // Descartar '('

            }
            if (esOperador(caracter)) {
                while (!pilaOperadores.isEmpty() && prioridad(caracter) <= prioridad(pilaOperadores.peek())) {
                    char operador = pilaOperadores.pop();
                    exPostfija.add(operador);
                }
                pilaOperadores.push(caracter);
            }
        }

        while (!pilaOperadores.isEmpty()) {
            char operador = pilaOperadores.pop();
            exPostfija.add(operador);
        }

        return exPostfija;
    }

    public static Double evaluarExpresionPostfija(List<Character> expresionPostfija) {
        Stack<Double> pila = new Stack<>();
        Scanner s = new Scanner(System.in);
        for (char caracter : expresionPostfija) {
            if (esOperador(caracter) == false) {
                System.out.println("Digite un valor para: " + caracter);
                double valor = s.nextDouble();
                pila.push(valor);
            } else if (esOperador(caracter)) {
                double x = pila.pop();
                double y = pila.pop();
                double z = realizarOperacion(y, x, caracter);
                pila.push(z);
            }
        }

        return pila.pop();
    }

    private static double realizarOperacion(double y, double x, char operador) {
        double resultado = 0;
        switch (operador) {
            case '+':
                resultado = y + x;
                break;
            case '-':
                resultado = y - x;
                break;
            case '*':
                resultado = y * x;
                break;
            case '/':
                resultado = y / x;
                break;
            case '^':
                resultado = Math.pow(y,x);
                break;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
        return resultado;
    }
}
