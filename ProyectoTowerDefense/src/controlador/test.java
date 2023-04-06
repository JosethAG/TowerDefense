/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Random;

/**
 *
 * @author araya
 */
public class test {
      public static void main(String[] args) {
        // TODO code application logic here
        int i = 1;
        int camino;
        Random azar = new Random();
        while (i < 5) {
            i++;
            camino = azar.nextInt(1, 3);
            System.out.println(camino);
        }
      }
}
