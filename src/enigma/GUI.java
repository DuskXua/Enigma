/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author mfaux02
 */
public class GUI extends Application {
    static Enigma enigma;
    
    @Override
    public void start(Stage primaryStage) {
        Button btnA = makeButton("A");
        Button btnB = makeButton("B");
        Button btnC = makeButton("C");
        Button btnD = makeButton("D");
        Button btnE = makeButton("E");
        Button btnF = makeButton("F");
        Button btnG = makeButton("G");
        Button btnH = makeButton("H");
        Button btnI = makeButton("I");
        Button btnJ = makeButton("J");
        Button btnK = makeButton("K");
        Button btnL = makeButton("L");
        Button btnM = makeButton("M");
        Button btnN = makeButton("N");
        Button btnO = makeButton("O");
        Button btnP = makeButton("P");
        Button btnQ = makeButton("Q");
        Button btnR = makeButton("R");
        Button btnS = makeButton("S");
        Button btnT = makeButton("T");
        Button btnU = makeButton("U");
        Button btnV = makeButton("V");
        Button btnW = makeButton("W");
        Button btnX = makeButton("X");
        Button btnY = makeButton("Y");
        Button btnZ = makeButton("Z");
        TextField input = new TextField();
        Label output = new Label();
        Label position = new Label();
        
        Button translate = new Button("Enigma!");
        
        translate.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                char[] inputArray = input.getText().toUpperCase().toCharArray();
                String outputString = "";
                for(int i = 0; i < inputArray.length; i++){
                    if(inputArray[i] != ' '){
                        outputString = outputString + enigma.translate(inputArray[i]);
                    }
                }
                output.setText(outputString);
                System.out.println(outputString);
                input.setText("");
                position.setText(Enigma.convertFrom(enigma.rotor3.getPosition()) + " " + Enigma.convertFrom(enigma.rotor2.getPosition()) + " " + Enigma.convertFrom(enigma.rotor1.getPosition()));
            }
        });
        
        position.setText(Enigma.convertFrom(enigma.rotor3.getPosition()) + " " + Enigma.convertFrom(enigma.rotor2.getPosition()) + " " + Enigma.convertFrom(enigma.rotor1.getPosition()));
        
        FlowPane root = new FlowPane(Orientation.VERTICAL);
        
        HBox keyline1 = new HBox(10);
        HBox keyline2 = new HBox(10);
        HBox keyline3 = new HBox(10);
        
        keyline1.getChildren().addAll(btnQ,btnW,btnE,btnR,btnT,btnZ,btnU,btnI,btnO);
        keyline2.getChildren().addAll(btnA,btnS,btnD,btnF,btnG,btnH,btnJ,btnK);
        keyline3.getChildren().addAll(btnP,btnY,btnX,btnC,btnV,btnB,btnN,btnM,btnL);
        
        root.getChildren().add(keyline1);
        root.getChildren().add(keyline2);
        root.getChildren().add(keyline3);
        root.getChildren().add(input);
        root.getChildren().add(translate);
        root.getChildren().add(output);
        root.getChildren().add(position);
        
        
        
        Scene scene = new Scene(root, 1200, 850);
        
        primaryStage.setTitle("Enigma Machine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * 
     * @param txt 
     * @return Button with the desired txt on it
     */
    private static Button makeButton(String txt){
        Button btn = new Button(txt);
        btn.setShape(new Circle(30));
        btn.setMinSize(60, 60);
        btn.setMaxSize(60, 60);
        
        btn.setStyle("-fx-background-color: #000000;  -fx-text-fill: #ffffff; -fx-border-color: #393939; -fx-border-width: 4px;");
        
        btn.setOnAction(new EventHandler<ActionEvent>(){
            
            
            @Override
            public void handle(ActionEvent event) {
                
                
            }
        });
        
        return btn;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        enigma = new Enigma(1,2,3,'B');
        launch(args);
    }
    
}
