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
        switch(reflector){
            case 'A': 
                wiring[0] = 5;      //A - E
                wiring[1] = 10;     //B - J
                wiring[2] = 14;     //C - M
                wiring[3] = 26;     //D - Z
                wiring[4] = 1;      //E - A
                wiring[5] = 12;     //F - L
                wiring[6] = 25;     //G - Y
                wiring[7] = 24;     //H - X
                wiring[8] = 22;     //I - V
                wiring[9] = 2;      //J - B
                wiring[10] = 23;    //K - W
                wiring[11] = 6;     //L - F
                wiring[12] = 3;     //M - C
                wiring[13] = 18;    //N - R
                wiring[14] = 17;    //O - Q
                wiring[15] = 21;    //P - U
                wiring[16] = 15;    //Q - O
                wiring[17] = 14;    //R - N
                wiring[18] = 20;    //S - T
                wiring[19] = 19;    //T - S
                wiring[20] = 16;    //U - P
                wiring[21] = 9;     //V - I
                wiring[22] = 11;    //W - K
                wiring[23] = 8;     //X - H
                wiring[24] = 7;     //Y - G
                wiring[25] = 4;     //Z - D
                break;
            case 'B': 
                wiring[0] = 5;      //A - E
                wiring[1] = 10;     //B - J
                wiring[2] = 14;     //C - M
                wiring[3] = 26;     //D - Z
                wiring[4] = 1;      //E - A
                wiring[5] = 12;     //F - L
                wiring[6] = 25;     //G - Y
                wiring[7] = 24;     //H - X
                wiring[8] = 22;     //I - V
                wiring[9] = 2;      //J - B
                wiring[10] = 23;    //K - W
                wiring[11] = 6;     //L - F
                wiring[12] = 3;     //M - C
                wiring[13] = 18;    //N - R
                wiring[14] = 17;    //O - Q
                wiring[15] = 21;    //P - U
                wiring[16] = 15;    //Q - O
                wiring[17] = 14;    //R - N
                wiring[18] = 20;    //S - T
                wiring[19] = 19;    //T - S
                wiring[20] = 16;    //U - P
                wiring[21] = 9;     //V - I
                wiring[22] = 11;    //W - K
                wiring[23] = 8;     //X - H
                wiring[24] = 7;     //Y - G
                wiring[25] = 4;     //Z - D
                break;
            case 'Z': 
                wiring[0] = 1;      //A - E
                wiring[1] = 2;     //B - J
                wiring[2] = 3;     //C - M
                wiring[3] = 4;     //D - Z
                wiring[4] = 5;      //E - A
                wiring[5] = 6;     //F - L
                wiring[6] = 7;     //G - Y
                wiring[7] = 8;     //H - X
                wiring[8] = 9;     //I - V
                wiring[9] = 10;      //J - B
                wiring[10] = 11;    //K - W
                wiring[11] = 12;     //L - F
                wiring[12] = 13;     //M - C
                wiring[13] = 14;    //N - R
                wiring[14] = 15;    //O - Q
                wiring[15] = 16;    //P - U
                wiring[16] = 17;    //Q - O
                wiring[17] = 18;    //R - N
                wiring[18] = 19;    //S - T
                wiring[19] = 20;    //T - S
                wiring[20] = 21;    //U - P
                wiring[21] = 22;     //V - I
                wiring[22] = 23;    //W - K
                wiring[23] = 24;     //X - H
                wiring[24] = 25;     //Y - G
                wiring[25] = 26;     //Z - D
                break;
        }
    }

    /**
     * @return the iD
     */
    public char getiD() {
        return iD;
    }
}
