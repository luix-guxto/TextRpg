//feramentas de parar execucao por um tempo e pular numero de linhas
package com.rpg;
import java.util.Scanner;

public class Ferramentas{
    public void linhas(int numeroLinhas){
        for(int loop=0; loop<numeroLinhas;loop++) {
            System.out.println();
        }
    }
    public void para(){
        System.out.println("Digite algo para continuar!");
        new Scanner(System.in).nextLine();
    }
}
