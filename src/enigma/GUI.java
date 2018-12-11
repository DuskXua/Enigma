/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
/**
 *
 * @author eliza
 */
public class GUI extends Application{
    static Enigma enigma;
    static Scene enigmaMachine;
    
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        enigma = new Enigma(1,2,3,'B');
        launch(args);
    }
    
    public void start(Stage primaryStage){
        primaryStage.setTitle("Faux Enigma Machine"); 
        Button keyA = createKey("A");
        Button keyB = createKey("B");
        Button keyC = createKey("C");
        Button keyD = createKey("D");
        Button keyE = createKey("E");
        Button keyF = createKey("F");
        Button keyG = createKey("G");
        Button keyH = createKey("H");
        Button keyI = createKey("I");
        Button keyJ = createKey("J");
        Button keyK = createKey("K");
        Button keyL = createKey("L");
        Button keyM = createKey("M");
        Button keyN = createKey("N");
        Button keyO = createKey("O");
        Button keyP = createKey("P");
        Button keyQ = createKey("Q");
        Button keyR = createKey("R");
        Button keyS = createKey("S");
        Button keyT = createKey("T");
        Button keyU = createKey("U");
        Button keyV = createKey("V");
        Button keyW = createKey("W");
        Button keyX = createKey("X");
        Button keyY = createKey("Y");
        Button keyZ = createKey("Z");
        
        HBox keyRow1 = makeHBox();
        HBox keyRow2 = makeHBox();
        HBox keyRow3 = makeHBox();
        keyRow1.getChildren().addAll(keyQ,keyW,keyE,keyR,keyT,keyZ,keyU,keyI,keyO);
        keyRow2.getChildren().addAll(keyA,keyS,keyD,keyF,keyG,keyH,keyJ,keyK);
        keyRow3.getChildren().addAll(keyP,keyY,keyX,keyC,keyV,keyB,keyN,keyM,keyL);
        VBox keyBoardBox = new VBox(30);
        keyBoardBox.getChildren().addAll(keyRow1,keyRow2,keyRow3);
        
        Light lightA = createLight("A");
        Light lightB = createLight("B");
        Light lightC = createLight("C");
        Light lightD = createLight("D");
        Light lightE = createLight("E");
        Light lightF = createLight("F");
        Light lightG = createLight("G");
        Light lightH = createLight("H");
        Light lightI = createLight("I");
        Light lightJ = createLight("J");
        Light lightK = createLight("K");
        Light lightL = createLight("L");
        Light lightM = createLight("M");
        Light lightN = createLight("N");
        Light lightO = createLight("O");
        Light lightP = createLight("P");
        Light lightQ = createLight("Q");
        Light lightR = createLight("R");
        Light lightS = createLight("S");
        Light lightT = createLight("T");
        Light lightU = createLight("U");
        Light lightV = createLight("V");
        Light lightW = createLight("W");
        Light lightX = createLight("X");
        Light lightY = createLight("Y");
        Light lightZ = createLight("Z");
        
        
        HBox lightRow1 = makeHBox();
        HBox lightRow2 = makeHBox(); 
        HBox lightRow3 = makeHBox();
        lightRow1.getChildren().addAll(lightQ.getStack(),lightW.getStack(),
                lightE.getStack(),lightR.getStack(),lightT.getStack(),
                lightZ.getStack(),lightU.getStack(),lightI.getStack(),
                lightO.getStack());
        lightRow2.getChildren().addAll(lightA.getStack(),lightS.getStack(),
                lightD.getStack(),lightF.getStack(),lightG.getStack(),
                lightH.getStack(),lightJ.getStack(),lightK.getStack());
       lightRow3.getChildren().addAll(lightP.getStack(),lightY.getStack(),
                lightX.getStack(),lightC.getStack(),lightV.getStack(),
                lightB.getStack(),lightN.getStack(),lightM.getStack(),
                lightL.getStack());
        VBox lightBoardBox = new VBox(30);
        lightBoardBox.getChildren().addAll(lightRow1,lightRow2,lightRow3);
        
        VBox enigmaBody = new VBox(80);
        enigmaBody.getChildren().addAll(lightBoardBox,keyBoardBox);
        enigmaMachine = new Scene(enigmaBody,900,900 );
        primaryStage.setScene(enigmaMachine);
        primaryStage.show();
    }
    
    public Button createKey(String letter){
        Button btn = new Button(letter);
        btn.setShape(new Circle (30));
        btn.setMinSize(60,60);
        btn.setMaxSize(60,60);
        btn.setStyle("-fx-background-color: #000000;  -fx-text-fill: #ffffff;"
                + " -fx-border-color: #aaafb7; -fx-border-width: 6px; "
                + "-fx-font-family: 'Able'; -fx-font-size: 25px; ");
        return btn;
    }
    
    public Light createLight(String txt){
        Light light = new Light();
        light.createLight(txt);
        return light;
    }
    
    public HBox makeHBox(){
        HBox spacedRow = new HBox(30);
        spacedRow.setAlignment(Pos.CENTER);
        return spacedRow;
        
    }
    
    public void clickButtonHandler(Button key){
        key.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
            }    
        }
        );          
    }
    
    public void lightSwitchOn(){
        
    }
    
    public void lightSwitchOff(){
        //enigmaMachine.setOnMouseRelease(){
        
    }
    }


