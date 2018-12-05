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
public class Plug {
    char endOne;
    char endTwo;
    
    Plug(char one, char two){
        endOne = one;
        endTwo = two;
    }
    
    public char transmute(char letter){
        if(letter == endOne){
            return endTwo;
        }else if(letter == endTwo){
            return endOne;
        }else{
            return letter;
        }
    }
    
    @Override
    public boolean equals(Object e){
        if(endOne == (Character)e | endTwo == (Character)e){
            return true;
        } 
        return false;
    }
}
