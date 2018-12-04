/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

/**
 *
 * @author mfaux02
 */
public class Rotor {
    private byte[] wiring = new byte[26];
    private byte[] wiringMirror = new byte[26];
    private byte position;
    private final byte ROLLOVERONE;
    private final byte ROLLOVERTWO;
    //ABCDEFGHIJKLMNOPQRSTUVWXYZ
    
    /**
     * Takes a positional value 1-26 and a boolean and runs it through the rotor wiring. Returns the positional value for the coded letter.
     * @param letterNum The numeric value of a particular letter/position
     * @param isMirror Whether or not the signal is coming from the reversed side
     * @return The value of the position after it has gone through
     */
    public int transmute(int letterNum, boolean isMirror){
        System.out.print(letterNum + ":");
        if(!isMirror){
            int letter = (letterNum - 1) + (position - 1);
            if(letter > 25){
                letter -= 26;
            }   
            int letterReturn = wiring[letter] - (position - 1);
            if(letterReturn < 1){
                letterReturn += 26;
            }
            System.out.print(letterReturn + " ");
            return letterReturn;
        }else{
            int letter = (letterNum - 1) + (position - 1);
            if(letter > 25){
                letter -= 26;
            }   
            int letterReturn = (wiringMirror[letter]) - (position - 1);
            if(letterReturn < 1){
                letterReturn += 26;
            }
            System.out.print(letterReturn + " ");
            return letterReturn;
        }
    }
    
    /**
     * Rotates the rotor in sequence. Usually done after a single letter is sent through the enigma system.
     * @return whether or not it would trigger the next rotor in sequence.
     */
    public boolean rotate(){
        position++;
        if(position > 26){
            position = 1;
        }
        return position == ROLLOVERONE | position == ROLLOVERTWO;
    }
    
    /**
     * Move the rotor an amount in any direction.
     * @param amount the amount to move.
     */
    public void turn(int amount){
        position += amount;
        while(position < 1){
            position += 26;
        }
        while(position > 25){
            position -= 26;
        }
    }
    
    private void createRotor(char[] letters){
        for(int i = 0; i < 26; i++){
            wiring[i] = convertTo(letters[i]);
        }
        
        for(int i = 0; i < 26; i++){
            int temp = convertTo(letters[i]) - 1;
            wiringMirror[temp] = (byte)(i + 1);
        }
    }
    
    private static byte convertTo(char letter){
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
     * Takes a number 1-8 and creates the corresponding rotor.
     * @param number The Rotor #
     */
    Rotor(int number){
        String letter;
        switch(number){
            case 1:
                letter = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
                System.out.println("Rotor 1");
                System.out.println("");
                ROLLOVERONE = 17;
                ROLLOVERTWO = 27;
                break;
            case 2:
                letter = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
                System.out.println("Rotor 2");
                System.out.println("");
                ROLLOVERONE = 5;
                ROLLOVERTWO = 27;
                break;
            case 3:
                letter = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
                System.out.println("Rotor 3");
                System.out.println("");
                ROLLOVERONE = 22;
                ROLLOVERTWO = 27;
                break;
            case 4:
                letter = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
                System.out.println("Rotor 4");
                System.out.println("");
                ROLLOVERONE = 9;
                ROLLOVERTWO = 27;
                break;
            case 5:
                letter = "VZBRGITYUPSDNHLXAWMJQOFECK";
                System.out.println("Rotor 5");
                System.out.println("");
                ROLLOVERONE = 25;
                ROLLOVERTWO = 27;
                break;
            case 6:
                letter = "JPGVOUMFYQBENHZRDKASXLICTW";
                System.out.println("Rotor 6");
                System.out.println("");
                ROLLOVERONE = 12;
                ROLLOVERTWO = 25;
                break;
            case 7:
                letter = "NZJHGRCXMYSWBOUFAIVLPEKQDT";
                System.out.println("Rotor 7");
                System.out.println("");
                ROLLOVERONE = 12;
                ROLLOVERTWO = 25;
                break;
            case 8:
                letter = "FKQHTLXOCBJSPDZRAMEWNIUYGV";
                System.out.println("Rotor 8");
                System.out.println("");
                ROLLOVERONE = 12;
                ROLLOVERTWO = 25;
                break;
            default:
                letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                System.out.println("Rotor default");
                System.out.println("");
                ROLLOVERONE = 1;
                ROLLOVERTWO = 27;
                break;
        }
        char[] letters = letter.toCharArray();
        createRotor(letters);
        position = 1;
    }

    /**
     * @return the position 1-26 with 1 being the starting position.
     */
    public int getPosition() {
        return position;
    }
}
