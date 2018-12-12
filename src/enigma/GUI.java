/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.text.Text;
/**
 *
 * @author eliza
 */
public class GUI extends Application{
    static Enigma enigma;
    static Scene enigmaMachine;
    
    static ComboBox viewRotor1;
    static ComboBox viewRotor2;
    static ComboBox viewRotor3;
    
    public static String clickKeyFormat = "-fx-background-color: #000000; -fx-text-fill: "
            + "#c9c9c9; -fx-border-color: #888c93; -fx-border-width: 6px; "
            + "-fx-font-family: 'Able'; -fx-font-size: 25px";
    public static String releaseKeyFormat = "-fx-background-color: #303030;  -fx-text-fill: "
            + "#ffffff; -fx-border-color: #aaafb7; -fx-border-width: 6px; "
            + "-fx-font-family: 'Able'; -fx-font-size: 25px;";
    static Bulb lightArray[] = new Bulb[26];
    static Button keyArray[] = new Button[26];
    static String letterArray[] = {"A","B","C","D","E","F","G","H","I","J","K","L",
            "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    static Lighting lighting;
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
        
        
        
        Light.Distant light = new Light.Distant();
        light.setAzimuth(300);
        light.setElevation(50);
        
        lighting = new Lighting();
        lighting.setLight(light);
        
        
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
       lightRow2.getChildren().addAll(lightArray[0].getStack(),lightArray[1].
                getStack(),lightArray[18].getStack(),lightArray[3].getStack(),
                lightArray[5].getStack(),lightArray[6].getStack(),lightArray[7]
                .getStack(),lightArray[9].getStack(),lightArray[10].getStack());
       lightRow3.getChildren().addAll(lightArray[15].getStack(),lightArray[24].
               getStack(),lightArray[23].getStack(),lightArray[2].getStack(),
               lightArray[21].getStack(),lightArray[1].getStack(),lightArray[13]
                .getStack(),lightArray[12].getStack(),lightArray[11].
                getStack());
        VBox lightBoardBox = new VBox(30);
        lightBoardBox.getChildren().addAll(lightRow1,lightRow2,lightRow3);
        ObservableList<String> rotorList =
                FXCollections.observableArrayList("Rotor I","Rotor II",
                        "Rotor III","Rotor IV","Rotor V","Rotor VI",
                        "Rotor VII","Rotor VIII");
        
        List<String> list = Arrays.<String>asList(letterArray);
        ObservableList<String> obLetterList = FXCollections.observableArrayList();
        obLetterList.addAll(list);
        
        HBox rotorScrollBox = makeHBox();
        ComboBox rotor1ID = createRotorSelect(0,rotorList);
        viewRotor1 = createLetterSelect(0,obLetterList);
        ComboBox rotor2ID = createRotorSelect(1,rotorList);
        viewRotor2 = createLetterSelect(1,obLetterList);
        ComboBox rotor3ID = createRotorSelect(2,rotorList);
        viewRotor3 = createLetterSelect(2,obLetterList);
        Text label1 = new Text("1");
        Text label2 = new Text("2");
        Text label3 = new Text("3");
        VBox rotor1Elements = new VBox();
        VBox rotor2Elements = new VBox();
        VBox rotor3Elements = new VBox();
        
        rotor1ID.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                switch((String)((ComboBox)event.getSource()).getValue()){
                    case "Rotor I":
                        enigma.changeRotorOne(1);
                        break;
                    case "Rotor II":
                        enigma.changeRotorOne(2);
                        break;
                    case "Rotor III":
                        enigma.changeRotorOne(3);
                        break;
                    case "Rotor IV":
                        enigma.changeRotorOne(4);
                        break;
                    case "Rotor V":
                        enigma.changeRotorOne(5);
                        break;
                    case "Rotor VI":
                        enigma.changeRotorOne(6);
                        break;
                    case "Rotor VII":
                        enigma.changeRotorOne(7);
                        break;
                    case "Rotor VIII":
                        enigma.changeRotorOne(8);
                        break;
                }
            }
        });
        
        viewRotor1.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                enigma.moveRotorTO(1, Enigma.convertTo(((String)((ComboBox)event.getSource()).getValue()).charAt(0)));
            }
        });
        
        rotor2ID.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                switch((String)((ComboBox)event.getSource()).getValue()){
                    case "Rotor I":
                        enigma.changeRotorTwo(1);
                        break;
                    case "Rotor II":
                        enigma.changeRotorTwo(2);
                        break;
                    case "Rotor III":
                        enigma.changeRotorTwo(3);
                        break;
                    case "Rotor IV":
                        enigma.changeRotorTwo(4);
                        break;
                    case "Rotor V":
                        enigma.changeRotorTwo(5);
                        break;
                    case "Rotor VI":
                        enigma.changeRotorTwo(6);
                        break;
                    case "Rotor VII":
                        enigma.changeRotorTwo(7);
                        break;
                    case "Rotor VIII":
                        enigma.changeRotorTwo(8);
                        break;
                }
            }
        });
        
        viewRotor2.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                enigma.moveRotorTO(2, Enigma.convertTo(((String)((ComboBox)event.getSource()).getValue()).charAt(0)));
            }
        });
        
        rotor3ID.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                switch((String)((ComboBox)event.getSource()).getValue()){
                    case "Rotor I":
                        enigma.changeRotorThree(1);
                        break;
                    case "Rotor II":
                        enigma.changeRotorThree(2);
                        break;
                    case "Rotor III":
                        enigma.changeRotorThree(3);
                        break;
                    case "Rotor IV":
                        enigma.changeRotorThree(4);
                        break;
                    case "Rotor V":
                        enigma.changeRotorThree(5);
                        break;
                    case "Rotor VI":
                        enigma.changeRotorThree(6);
                        break;
                    case "Rotor VII":
                        enigma.changeRotorThree(7);
                        break;
                    case "Rotor VIII":
                        enigma.changeRotorThree(8);
                        break;
                }
            }
        });
        
        viewRotor3.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                enigma.moveRotorTO(3, Enigma.convertTo(((String)((ComboBox)event.getSource()).getValue()).charAt(0)));
            }
        });
        
        rotor1Elements.getChildren().addAll(label1,rotor1ID,viewRotor1);
        rotor2Elements.getChildren().addAll(label2,rotor2ID,viewRotor2);
        rotor3Elements.getChildren().addAll(label3,rotor3ID,viewRotor3);
        rotorScrollBox.getChildren().addAll(rotor1Elements,rotor2Elements,rotor3Elements);
        
        
        VBox keyLightAlign = new VBox(80);
        StackPane enigmaBody = new StackPane();
        ImageView iv = new ImageView(new Image(this.getClass().getResourceAsStream("blackBackgroundImage.png")));
        iv.setFitWidth(825);
        iv.setFitHeight(800);
        enigmaBody.getChildren().addAll(iv,keyLightAlign);
        keyLightAlign.getChildren().addAll(rotorScrollBox,lightBoardBox,keyBoardBox);
        enigmaMachine = new Scene(enigmaBody,900,900 );
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("E icon.png")));
        primaryStage.setScene(enigmaMachine);
        primaryStage.show();
    }
    
    public Button createKey(String letter){
        Button btn = new Button(letter);
        btn.setShape(new Circle (30));
        btn.setMinSize(60,60);
        btn.setMaxSize(60,60);
        btn.setStyle(releaseKeyFormat);
        btn.setEffect(lighting);
        return btn;
    }
    
    public Bulb createLight(String txt){
        Bulb lightBulb = new Bulb();
        lightBulb.createLight(txt);
        return lightBulb;
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
                stepEnigma();
            }
        });
    }
    
    public void stepEnigma(){
        enigma.step();
        viewRotor1.setValue(Enigma.convertFrom(enigma.rotor1.getPosition()) + "");
        viewRotor2.setValue(Enigma.convertFrom(enigma.rotor2.getPosition()) + "");
        viewRotor3.setValue(Enigma.convertFrom(enigma.rotor3.getPosition()) + "");
    }
    
    public ComboBox createLetterSelect(int firstSet, ObservableList<String> list){
        ComboBox letterSelect = new ComboBox(list);
        letterSelect.getSelectionModel().select(firstSet);
        letterSelect.setStyle("-fx-fill: #000000; -fx-font-size: 25px;");
        //letterSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>);
        return letterSelect;
    }
    
    public ComboBox createRotorSelect(int selectRotor, ObservableList<String> list){
        
        ComboBox rotorSelect = new ComboBox(list);
        rotorSelect.getSelectionModel().select(selectRotor);
        return rotorSelect;
    }
    
}

