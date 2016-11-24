package pyfs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;

/**
 *
 * @author IS109-Groep 5
 */
public class pyfs extends Application {

    //voegt alle controls, scenes, panes en stages toe
    TextField username;
    PasswordField password;
    Button btn, btn2;
    ImageView loginlogo;
    StackPane inlogscherm;
    StackPane pane2;     
    Scene scene, scene2;
    Stage thestage;

    @Override
    public void start(Stage primaryStage) {

        thestage = primaryStage; //verklaart toegoevoegde stage

        
        //verklaren alle toegevoegde controls
        btn = new Button();
        btn.setText("Login");                                           //inlog button
        btn.setPrefSize(200, 50);
        btn.setTranslateY(90);
        btn.setStyle("-fx-base:darkcyan;-fx-border-color:black");

        btn.setOnAction((ActionEvent event) -> {
            thestage.setScene(scene2);
        });

        btn2 = new Button();
        btn2.setText("Terug");                                           //inlog button
        btn2.setPrefSize(200, 50);
        btn2.setTranslateY(90);
        btn2.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        btn2.setOnAction((ActionEvent event) -> {
            thestage.setScene(scene);
        });

        username = new TextField();                 //text die gebruikersnaam print bij inlogscherm
        username.setPromptText("Username");
        username.setFont(Font.font("Verdana", 20));
        username.setTranslateY(-20);
        username.setMaxWidth(220);

        password = new PasswordField();        //veld om wachtwoord in te vullen
        password.setPromptText("Password");
        password.setMaxWidth(220);
        password.setFont(Font.font("Verdana", 20));
        password.setTranslateY(30);

        loginlogo = new ImageView("download.png");       //voegt corendon logo toe aan loginscherm
        loginlogo.setTranslateY(-120);

        
        //geeft controls aan verschillende panes
        inlogscherm = new StackPane();                        //Stackpane inlogscherm
        inlogscherm.getChildren().add(btn);                        //toevoegen button
        inlogscherm.getChildren().add(username);                   //toevoegen username text
        inlogscherm.getChildren().add(password);
        inlogscherm.getChildren().add(loginlogo);
        inlogscherm.setStyle("-fx-background-color:#FFFFFF");
        
        pane2 = new StackPane();
        pane2.getChildren().add(btn2);
        pane2.setStyle("-fx-background-color:#FFFFFF");

        //geeft alle scenes in
        scene = new Scene(inlogscherm, 1600, 800);
        scene2 = new Scene(pane2, 1600, 800);

        primaryStage.setTitle("Applicatie naam");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
