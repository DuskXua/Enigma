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
public class Reflector {
    private byte[] wiring = new byte[26];
    private char iD;
    
    public int transmute(int letterNum){
        int letter = letterNum - 1;
        int letterReturn = wiring[letter];
        return letterReturn;
    }
    
    Reflector(char reflector){
        iD = reflector;
        String letter;
        
        switch(reflector){
            case 'A': 
                letter = "EJMZALYXVBWFCRQUONTSPIKHGD";
                break;
            case 'B': 
                letter = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
                break;
            case 'C':
                letter = "FVPJIAOYEDRZXWGCTKUQSBNMHL";
                break;
            default: 
                letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
        }
        
        char[] letters = letter.toCharArray();
        
        for(int i = 0; i < 26; i++){
            wiring[i] = (byte)Enigma.convertTo(letters[i]);
        }
    }

    /**
     * @return the iD
     */
    public char getiD() {
        return iD;
    }
}
