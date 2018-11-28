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
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author mfaux02
 */
public class Enigma extends Application {
    static Rotor rotor1 = new Rotor(1);
    static Rotor rotor2 = new Rotor(2);
    static Rotor rotor3 = new Rotor(3);
    static Reflector reflect = new Reflector('Z');
    
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
                        outputString = outputString + translate(inputArray[i]);
                    }
                }
                output.setText(outputString);
                System.out.println(outputString);
                input.setText("");
                position.setText(convertFrom(rotor3.getPosition()) + " " + convertFrom(rotor2.getPosition()) + " " + convertFrom(rotor1.getPosition()));
            }
        });
        
        position.setText(convertFrom(rotor3.getPosition()) + " " + convertFrom(rotor2.getPosition()) + " " + convertFrom(rotor1.getPosition()));
        
        FlowPane root = new FlowPane(Orientation.VERTICAL);
        
        HBox keyline1 = new HBox(10);
        HBox keyline2 = new HBox(10);
        HBox keyline3 = new HBox(10);
        
        keyline1.getChildren().addAll(btnQ,btnW,btnE,btnR,btnT,btnZ,btnU,btnI,btnO);
        keyline2.getChildren().addAll(btnA,btnS,btnD,btnF,btnG,btnH,btnJ,btnK);
        keyline3.getChildren().addAll(btnP,btnY,btnX,btnC,btnV,btnB,btnN,btnM,btnL);
        
        VBox keyboard = new VBox();
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
    
    private static int convertTo(char letter){
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

    private static char convertFrom(int letter){
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
        launch(args);
    }
    
}
