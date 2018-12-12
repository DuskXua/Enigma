/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.LinkedList;

/**
 *
 * @author mfaux02
 */
public class Enigma{
    Rotor rotor1;
    Rotor rotor2;
    Rotor rotor3;
    Reflector reflect;
    LinkedList<Plug> plugs;
    
    Enigma(int firstRotorID, int secondRotorID, int thirdRotorID, char 
            reflectorID){
        rotor1 = new Rotor(firstRotorID);
        rotor2 = new Rotor(secondRotorID);
        rotor3 = new Rotor(thirdRotorID);
        reflect = new Reflector(reflectorID);
        plugs = new LinkedList<>();
    }
    
    /**
     * Sends a string of text into the enigma machine and returns the encoded 
     * Text.
     * @param text
     * @return 
     */
    public String translateText(String text){
        text = text.toUpperCase();
        char[] letters = text.toCharArray();
        String output = "";
        for(int i = 0; i < letters.length; i++){
            output = output + translate(letters[i]);
        }
        return output;
    }
    
    public void moveRotorTO(int rotorID, int moveTo){
        switch(rotorID){
            case 1:
                rotor1.moveTo(moveTo);
                break;
            case 2:
                rotor2.moveTo(moveTo);
                break;
            case 3:
                rotor3.moveTo(moveTo);
                break;
            default:
                break;
        }
    }
    
    public void changeRotorOne(int newRotorID){
        System.out.println("Rotor 1 changed to " + newRotorID);
        rotor1 = new Rotor(newRotorID);
    }
    
    public void changeRotorTwo(int newRotorID){
        System.out.println("Rotor 2 changed to " + newRotorID);
        rotor2 = new Rotor(newRotorID);
    }
    
    public void changeRotorThree(int newRotorID){
        System.out.println("Rotor 3 changed to " + newRotorID);
        rotor3 = new Rotor(newRotorID);
    }
    
    public void changeReflector(char newReflectorID){
        System.out.println("Reflector changed to " + newReflectorID);
        reflect = new Reflector(newReflectorID);
    }
    
    /**
     * Sends one letter into the enigma machine and returns the encoded letter.
     * Any character other than A-Z will be converted to a ~
     * @param letter To be encoded
     * @return The encoded letter
     */
    public char translate(char letter){
        int input1 = convertTo(transmute(letter));
        if(input1 == 0){
            return '~';
        }
        int input2 = rotor3.transmute(input1, false);
        int input3 = rotor2.transmute(input2, false);
        int input4 = rotor1.transmute(input3, false);
        int input5 = reflect.transmute(input4);
        int input6 = rotor1.transmute(input5, true);
        int input7 = rotor2.transmute(input6, true);
        int input8 = rotor3.transmute(input7, true);
        char output = convertFrom(input8);
        return transmute(output);
    }
    
    public void step(){
        if(rotor1.rotate()){
            if(rotor2.rotate()){
                rotor3.rotate();
            }
        }
    }
    
    /**
     * Sends a letter through the plugboard, may not change depending on plugs.
     * @param letter the letter to send through the plugboard.
     * @return The letter returned by the plugboard.
     */
    public char transmute(char letter){
        int index = plugs.indexOf(letter);
        if(index != -1){
            return plugs.get(index).transmute(letter);
        }else{
            return letter;
        }
    }
    
    /**
     * Adds a plug between letterOne and letterTwo. Removes any plug in either 
     * slot.
     * @param letterOne The first end of a plug
     * @param letterTwo the second end of a plug
     */
    public void addPlug(char letterOne, char letterTwo){
        if(plugs.contains(letterOne) | plugs.contains(letterTwo)){
            int indexOne = plugs.indexOf(letterOne);
            if(indexOne != -1){
                plugs.remove(indexOne);
            }
            int indexTwo = plugs.indexOf(letterTwo);
            if(indexTwo != -1){
                plugs.remove(indexTwo);
            }
            plugs.add(new Plug(letterOne,letterTwo));
        }else{
            plugs.add(new Plug(letterOne,letterTwo));
        }
    }
    
    /**
     * Takes a letter and removes the related plug, if any, returns true if 
     * removed, false if not found.
     * @param letter the letter on either end of a plug.
     * @return whether or not a plug was removed
     */
    public boolean removePlug(char letter){
        if(plugs.contains(letter)){
            int index = plugs.indexOf(letter);
            plugs.remove(index);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Converts a letter to its numeric value 
     * @param letter A-Z letter, must be capitalized.
     * @return numeric value of a character
     */
    public static int convertTo(char letter){
        switch(letter){
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;
            case 'I':
                return 9;
            case 'J':
                return 10;
            case 'K':
                return 11;
            case 'L':
                return 12;
            case 'M':
                return 13;
            case 'N':
                return 14;
            case 'O':
                return 15;
            case 'P':
                return 16;
            case 'Q':
                return 17;
            case 'R':
                return 18;
            case 'S':
                return 19;
            case 'T':
                return 20;
            case 'U':
                return 21;
            case 'V':
                return 22;
            case 'W':
                return 23;
            case 'X':
                return 24;
            case 'Y':
                return 25;
            case 'Z':
                return 26;
            default:
                return 0;
        }
    }

    /**
     * Converts a numeric value to its corresponding letter.
     * @param letter 1-26 int
     * @return character at the corresponding value.
     */
    public static char convertFrom(int letter){
        switch(letter){
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'D';
            case 5:
                return 'E';
            case 6:
                return 'F';
            case 7:
                return 'G';
            case 8:
                return 'H';
            case 9:
                return 'I';
            case 10:
                return 'J';
            case 11:
                return 'K';
            case 12:
                return 'L';
            case 13:
                return 'M';
            case 14:
                return 'N';
            case 15:
                return 'O';
            case 16:
                return 'P';
            case 17:
                return 'Q';
            case 18:
                return 'R';
            case 19:
                return 'S';
            case 20:
                return 'T';
            case 21:
                return 'U';
            case 22:
                return 'V';
            case 23:
                return 'W';
            case 24:
                return 'X';
            case 25:
                return 'Y';
            case 26:
                return 'Z';
            default:
                return 0;
        }
    }
}
