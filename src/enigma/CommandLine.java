/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.Scanner;

/**
 *
 * @author Mafau
 */
public class CommandLine {
    static Enigma enigma;
    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu(){
        Scanner scan = new Scanner(System.in);
        String resp;
        
        boolean run = true;
        
        System.out.println("Hello! Welcome to the Enigma machine.");
        System.out.println("");
        System.out.println("Preloading Enigma with reflector \"B\" and Rotors 1,2, and 3.");
        System.out.println("Continue?");
        System.out.println("Yes/No");
        resp = scan.nextLine();
        if(resp.toUpperCase().charAt(0) == 'N'){
            loadNew();
        }else{
            enigma = new Enigma(1,2,3,'B');
            System.out.println("");
            System.out.println("Loaded!");
            System.out.println("");
            printConfig();
        }
        
        while(run){
            System.out.println("---Main Menu---");
            System.out.println("(E)ncode");
            System.out.println("(S)et Ket");
            System.out.println("(C)hange Config");
            System.out.println("(Q)uit");
            System.out.println("");
            
            resp = scan.nextLine();
            switch(resp.toUpperCase().charAt(0)){
                case 'E':
                    encode();
                    break;
                case 'S':
                    setKey();
                    break;
                case 'C':
                    changeConfig();
                    break;
                case 'Q':
                    System.out.println("");
                    System.out.println("Bye!");
                    run = false;
                    break;
                default:
                    System.out.println("");
                    System.out.println("Not a valid Option.");
                    break;
            }
        }
    }
    
    public static void printConfig(){
        Enigma.convertFrom(enigma.rotor1.getPosition());
        System.out.println("--------------------");
        System.out.println("--- " + enigma.reflect.getiD() + " - " + enigma.rotor1.getiD()  + " - " + enigma.rotor2.getiD()  + " - " + enigma.rotor3.getiD()  + " ---");
        System.out.println("--------------------");
        System.out.println("--- - - " + Enigma.convertFrom(enigma.rotor1.getPosition())  + " - " + Enigma.convertFrom(enigma.rotor2.getPosition())  + " - " + Enigma.convertFrom(enigma.rotor3.getPosition())  + " ---");
        System.out.println("--------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
    public static void encode(){
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        String code;
        
        while(run){
            System.out.println("");
            System.out.println("Enter Text to encode/decode.");
            System.out.println("Enter ~ to exit");
            code = scan.nextLine();
            if(code.charAt(0) == '~'){
                run = false;
            }
            
            System.out.println("");
            System.out.println(enigma.translateText(code));
        }
    }
    
    public static void setKey(){
        
    }
    
    public static void changeConfig(){
        
    }
    
    public static void loadNew(){
        
    }
}
