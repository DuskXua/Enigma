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
import javafx.scene.effect.Glow;
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
    public static String clickKeyFormat = "-fx-background-color: #000000; -fx-text-fill: "
            + "#c9c9c9; -fx-border-color: #888c93; -fx-border-width: 6px; "
            + "-fx-font-family: 'Able'; -fx-font-size: 25px";
    public static String releaseKeyFormat = "-fx-background-color: #303030;  -fx-text-fill: "
            + "#ffffff; -fx-border-color: #aaafb7; -fx-border-width: 6px; "
            + "-fx-font-family: 'Able'; -fx-font-size: 25px;";
    static Light lightArray[] = new Light[26];
    static Button keyArray[] = new Button[26];
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        enigma = new Enigma(1,2,3,'B');
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Faux Enigma Machine"); 
        
        String letterArray[] = {"A","B","C","D","E","F","G","H","I","J","K","L",
            "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        
        for(int loop =0 ;loop<26;loop++){
            keyArray[loop] = createKey(letterArray[loop]);
            lightArray[loop]=createLight(letterArray[loop]);
            keyHandler(keyArray[loop]);
            lightSwitchOff(keyArray[loop]);
        }
        
        HBox keyRow1 = makeHBox();
        HBox keyRow2 = makeHBox();
        HBox keyRow3 = makeHBox();
        keyRow1.getChildren().addAll(keyArray[16],keyArray[22],keyArray[4],
                keyArray[17],keyArray[19],keyArray[25],keyArray[20],keyArray[8]
                ,keyArray[14]);
        keyRow2.getChildren().addAll(keyArray[0],keyArray[1],keyArray[18],keyArray[3],
                keyArray[5],keyArray[6],keyArray[7],keyArray[9],keyArray[10]);
        keyRow3.getChildren().addAll(keyArray[15],keyArray[24],keyArray[23],
                keyArray[2],keyArray[21],keyArray[1],keyArray[13],keyArray[12],
                keyArray[11]);
        VBox keyBoardBox = new VBox(30);
        keyBoardBox.getChildren().addAll(keyRow1,keyRow2,keyRow3);        
        
        HBox lightRow1 = makeHBox();
        HBox lightRow2 = makeHBox(); 
        HBox lightRow3 = makeHBox();
        lightRow1.getChildren().addAll(lightArray[16].getStack(),lightArray[22]
                .getStack(),lightArray[4].getStack(),lightArray[17].getStack()
                ,lightArray[19].getStack(),lightArray[25].getStack(),
                lightArray[20].getStack(),lightArray[8].getStack(),
                lightArray[14].getStack());
       lightRow2.getChildren().addAll(lightArray[0].getStack(),lightArray[1].getStack(),lightArray[18]
               .getStack(),lightArray[3].getStack(),lightArray[5].getStack(),
               lightArray[6].getStack(),lightArray[7].getStack(),lightArray[9]
               .getStack(),lightArray[10].getStack());
       lightRow3.getChildren().addAll(lightArray[15].getStack(),lightArray[24].
               getStack(),lightArray[23].getStack(),lightArray[2].getStack(),
               lightArray[21].getStack(),lightArray[1].getStack(),lightArray[13]
                .getStack(),lightArray[12].getStack(),lightArray[11].
                getStack());
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
        btn.setStyle(releaseKeyFormat);
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
    
    public void keyHandler(Button key){
        key.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                key.setStyle(clickKeyFormat);
                lightArray[enigma.convertTo(enigma.translate(key.getText().charAt(0)))-1].lightOn();
            }    
        }
        );          
    }
    
    public void lightSwitchOff(Button clickedKey){
        clickedKey.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clickedKey.setStyle(releaseKeyFormat);
                lightArray[enigma.convertTo(enigma.translate(clickedKey.
                        getText().charAt(0)))-1].lightOff();
                enigma.step();
            }
        });
    }
    
}

