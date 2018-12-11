/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 *
 * @author eliza
 */
public class Light {
    StackPane stack;
    Circle cir;
    Text text;
    
    public void createLight(String letter){
        cir = new Circle(28);
        text = new Text(letter);
        text.setStyle("-fx-fill: #ffffff; -fx-font-size: 30px;-fx-font-weight: bold; ");
        stack = new StackPane();
        stack.getChildren().addAll(cir,text);
    }
    
    public StackPane getStack(){
        return stack;
    }
}