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
    private byte iD;
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
            wiring[i] = (byte)Enigma.convertTo(letters[i]);
        }
        
        for(int i = 0; i < 26; i++){
            int temp = (byte)Enigma.convertTo(letters[i]) - 1;
            wiringMirror[temp] = (byte)(i + 1);
        }
    }
    
    /**
     * Takes a number 1-8 and creates the corresponding rotor.
     * @param number The Rotor #
     */
    Rotor(int number){
        String letter;
        iD = (byte)number;
        switch(number){
            case 1:
                letter = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
                ROLLOVERONE = 17;
                ROLLOVERTWO = 27;
                break;
            case 2:
                letter = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
                ROLLOVERONE = 5;
                ROLLOVERTWO = 27;
                break;
            case 3:
                letter = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
                ROLLOVERONE = 22;
                ROLLOVERTWO = 27;
                break;
            case 4:
                letter = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
                ROLLOVERONE = 9;
                ROLLOVERTWO = 27;
                break;
            case 5:
                letter = "VZBRGITYUPSDNHLXAWMJQOFECK";
                ROLLOVERONE = 25;
                ROLLOVERTWO = 27;
                break;
            case 6:
                letter = "JPGVOUMFYQBENHZRDKASXLICTW";
                ROLLOVERONE = 12;
                ROLLOVERTWO = 25;
                break;
            case 7:
                letter = "NZJHGRCXMYSWBOUFAIVLPEKQDT";
                ROLLOVERONE = 12;
                ROLLOVERTWO = 25;
                break;
            case 8:
                letter = "FKQHTLXOCBJSPDZRAMEWNIUYGV";
                ROLLOVERONE = 12;
                ROLLOVERTWO = 25;
                break;
            default:
                letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
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

    /**
     * @return the iD
     */
    public byte getiD() {
        return iD;
    }
}
