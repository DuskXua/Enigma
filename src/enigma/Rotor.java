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
    private final byte ROLLOVER;
    //ABCDEFGHIJKLMNOPQRSTUVWXYZ
    
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
    
    public boolean rotate(){
        position++;
        if(position > 26){
            position = 1;
        }
        return position == ROLLOVER;
    }
    
    public void turn(int amount){
        position += amount;
        while(position < 1){
            position += 26;
        }
        while(position > 25){
            position -= 26;
        }
    }
    
    Rotor(int number){
        switch(number){
            case 1: 
                wiring[0] = 5;          //A - E
                wiring[1] = 11;         //B - K
                wiring[2] = 13;         //C - M
                wiring[3] = 6;          //D - F
                wiring[4] = 12;         //E - L
                wiring[5] = 7;          //F - G
                wiring[6] = 4;          //G - D
                wiring[7] = 17;         //H - Q
                wiring[8] = 22;         //I - V
                wiring[9] = 26;         //J - Z
                wiring[10] = 14;        //K - N
                wiring[11] = 20;        //L - T
                wiring[12] = 15;        //M - O
                wiring[13] = 23;        //N - W
                wiring[14] = 25;        //O - Y
                wiring[15] = 8;         //P - H
                wiring[16] = 24;        //Q - X
                wiring[17] = 21;        //R - U
                wiring[18] = 19;        //S - S
                wiring[19] = 16;        //T - P
                wiring[20] = 1;         //U - A
                wiring[21] = 9;         //V - I
                wiring[22] = 2;         //W - B
                wiring[23] = 18;        //X - R
                wiring[24] = 3;         //Y - C
                wiring[25] = 10;        //Z - J
                
                wiringMirror[0] = 21;   //A - U
                wiringMirror[1] = 23;   //B - W
                wiringMirror[2] = 25;   //C - Y
                wiringMirror[3] = 7;    //D - G
                wiringMirror[4] = 1;    //E - A
                wiringMirror[5] = 4;    //F - D
                wiringMirror[6] = 6;    //G - F
                wiringMirror[7] = 16;   //H - P
                wiringMirror[8] = 22;   //I - V
                wiringMirror[9] = 26;   //J - Z
                wiringMirror[10] = 2;   //K - B
                wiringMirror[11] = 5;   //L - E
                wiringMirror[12] = 3;   //M - C
                wiringMirror[13] = 11;  //N - K
                wiringMirror[14] = 13;  //O - M
                wiringMirror[15] = 20;  //P - T
                wiringMirror[16] = 8;   //Q - H
                wiringMirror[17] = 24;  //R - X
                wiringMirror[18] = 19;  //S - S
                wiringMirror[19] = 12;  //T - L
                wiringMirror[20] = 18;  //U - R
                wiringMirror[21] = 9;   //V - I
                wiringMirror[22] = 14;  //W - N
                wiringMirror[23] = 17;  //X - Q
                wiringMirror[24] = 15;  //Y - O
                wiringMirror[25] = 10;  //Z - J
                
                ROLLOVER = 17;
                break;
            case 2:
                wiring[0] = 1;          //A - A
                wiring[1] = 10;         //B - J
                wiring[2] = 4;          //C - D
                wiring[3] = 11;         //D - K
                wiring[4] = 19;         //E - S
                wiring[5] = 9;          //F - I
                wiring[6] = 18;         //G - R
                wiring[7] = 21;         //H - U
                wiring[8] = 24;         //I - X
                wiring[9] = 2;          //J - B
                wiring[10] = 12;        //K - L
                wiring[11] = 8;         //L - H
                wiring[12] = 23;        //M - W
                wiring[13] = 20;        //N - T
                wiring[14] = 13;        //O - M
                wiring[15] = 3;         //P - C
                wiring[16] = 17;        //Q - Q
                wiring[17] = 7;         //R - G
                wiring[18] = 26;        //S - Z
                wiring[19] = 14;        //T - N
                wiring[20] = 16;        //U - P
                wiring[21] = 25;        //V - Y
                wiring[22] = 6;         //W - F
                wiring[23] = 22;        //X - V
                wiring[24] = 15;        //Y - O
                wiring[25] = 5;         //Z - E
                
                wiringMirror[0] = 1;    //A - A
                wiringMirror[1] = 10;   //B - J
                wiringMirror[2] = 16;   //C - P
                wiringMirror[3] = 3;    //D - C
                wiringMirror[4] = 26;   //E - Z
                wiringMirror[5] = 23;   //F - W
                wiringMirror[6] = 18;   //G - R
                wiringMirror[7] = 12;   //H - L
                wiringMirror[8] = 6;    //I - F
                wiringMirror[9] = 2;    //J - B
                wiringMirror[10] = 4;   //K - D
                wiringMirror[11] = 11;  //L - K
                wiringMirror[12] = 15;  //M - O
                wiringMirror[13] = 20;  //N - T
                wiringMirror[14] = 25;  //O - Y
                wiringMirror[15] = 21;  //P - U
                wiringMirror[16] = 17;  //Q - Q
                wiringMirror[17] = 7;   //R - G
                wiringMirror[18] = 5;   //S - E
                wiringMirror[19] = 14;  //T - N
                wiringMirror[20] = 8;   //U - H
                wiringMirror[21] = 24;  //V - X
                wiringMirror[22] = 13;  //W - M
                wiringMirror[23] = 9;   //X - I
                wiringMirror[24] = 22;  //Y - V
                wiringMirror[25] = 19;  //Z - S
                
                ROLLOVER = 5;
                break;
            case 3:
                wiring[0] = 2;          //A - B
                wiring[1] = 4;          //B - D
                wiring[2] = 6;          //C - F
                wiring[3] = 8;          //D - H
                wiring[4] = 10;         //E - J
                wiring[5] = 12;         //F - L
                wiring[6] = 3;          //G - C
                wiring[7] = 16;         //H - P
                wiring[8] = 18;         //I - R
                wiring[9] = 20;         //J - T
                wiring[10] = 24;        //K - X
                wiring[11] = 22;        //L - V
                wiring[12] = 26;        //M - Z
                wiring[13] = 14;        //N - N
                wiring[14] = 25;        //O - Y
                wiring[15] = 5;         //P - E
                wiring[16] = 9;         //Q - I
                wiring[17] = 23;        //R - W
                wiring[18] = 7;         //S - G
                wiring[19] = 1;         //T - A
                wiring[20] = 11;        //U - K
                wiring[21] = 13;        //V - M
                wiring[22] = 21;        //W - U
                wiring[23] = 19;        //X - S
                wiring[24] = 17;        //Y - Q
                wiring[25] = 15;        //Z - O
                
                wiringMirror[0] = 20;   //A - T
                wiringMirror[1] = 1;    //B - A
                wiringMirror[2] = 7;    //C - G
                wiringMirror[3] = 2;    //D - B
                wiringMirror[4] = 16;   //E - P
                wiringMirror[5] = 3;    //F - C
                wiringMirror[6] = 19;   //G - S
                wiringMirror[7] = 4;    //H - D
                wiringMirror[8] = 17;   //I - Q
                wiringMirror[9] = 5;    //J - E
                wiringMirror[10] = 21;  //K - U
                wiringMirror[11] = 6;   //L - F
                wiringMirror[12] = 22;  //M - V
                wiringMirror[13] = 14;  //N - N
                wiringMirror[14] = 26;  //O - Z
                wiringMirror[15] = 8;   //P - H
                wiringMirror[16] = 25;  //Q - Y
                wiringMirror[17] = 9;   //R - I
                wiringMirror[18] = 24;  //S - X
                wiringMirror[19] = 10;  //T - J
                wiringMirror[20] = 23;  //U - W
                wiringMirror[21] = 12;  //V - L
                wiringMirror[22] = 18;  //W - R
                wiringMirror[23] = 11;  //X - K
                wiringMirror[24] = 15;  //Y - O
                wiringMirror[25] = 13;  //Z - M
                
                ROLLOVER = 22;
                break;
            case 4:
                ROLLOVER = 1;
                break;
            case 5:
                ROLLOVER = 1;
                break;
            case 6:
                ROLLOVER = 1;
                break;
            case 7:
                ROLLOVER = 1;
                break;
            default:
                ROLLOVER = 1;
                break;
        }
        position = 1;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }
}
