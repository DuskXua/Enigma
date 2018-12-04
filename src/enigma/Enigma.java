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
public class Enigma{
    static Rotor rotor1 = new Rotor(1);
    static Rotor rotor2 = new Rotor(2);
    static Rotor rotor3 = new Rotor(3);
    static Reflector reflect = new Reflector('Z');
    
    /**
     * Sends a string of text into the enigma machine and returns the encoded Text.
     * @param text
     * @return 
     */
    public static String translateText(String text){
        text = text.toUpperCase();
        char[] letters = text.toCharArray();
        String output = "";
        for(int i = 0; i < letters.length; i++){
            output = output + translate(letters[i]);
        }
        return output;
    }
    
    /**
     * Sends one letter into the enigma machine and returns the encoded letter.
     * Any character other than A-Z will be converted to a ~
     * @param letter To be encoded
     * @return The encoded letter
     */
    public static char translate(char letter){
        int input1 = convertTo(letter);
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
        System.out.print(input8 + " ");
        char output = convertFrom(input8);
        System.out.println(output);
        if(rotor3.rotate()){
            if(rotor2.rotate()){
                rotor1.rotate();
            }
        }
        return output;
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
