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

//tijdelijke login
    String user = "test";
    String pw = "admin";
    String checkUser, checkPw;

    //voegt alle controls, scenes, panes en stages toe
    Text loginerror;
    TextField username;
    PasswordField password;
    Button loginbtn, logoutbtn, statbtn, lostbtn, foundbtn, lostterugmenu, foundterugmenu, statterugmenu;
    ImageView logologin;
    StackPane inlogschermpane, menupane, lostpane, foundpane, statpane;
    Scene loginscherm, menu, lost, found, stat;
    Stage thestage;

    @Override
    public void start(Stage primaryStage) {

        thestage = primaryStage; //verklaart toegoevoegde stage

        //BEGIN CONTROLS
        //inlogscherm
        username = new TextField();                 //text die gebruikersnaam print bij inlogscherm
        username.setPromptText("Username");
        username.setFont(Font.font("Verdana", 20));
        username.setTranslateY(-20);
        username.setMaxWidth(220);
        username.getText();

        password = new PasswordField();        //veld om wachtwoord in te vullen
        password.setPromptText("Password");
        password.setMaxWidth(220);
        password.setFont(Font.font("Verdana", 20));
        password.setTranslateY(30);
        password.getText();

        //verklaren alle toegevoegde controls
        loginerror = new Text();
        loginerror.setText("username or password are wrong, contact administrator if you cannot login");
        loginerror.setTranslateY(210);
        loginerror.setVisible(false);
        loginerror.setFont(Font.font("Verdana"));
        loginerror.setFill(Color.RED);

        logologin = new ImageView("download.png");       //voegt corendon logo toe aan loginscherm
        logologin.setTranslateY(-120);

        loginbtn = new Button();
        loginbtn.setText("Login");                                           //inlog button
        loginbtn.setPrefSize(200, 50);
        loginbtn.setTranslateY(90);
        loginbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");

        loginbtn.setOnAction((ActionEvent event) -> {

            checkUser = username.getText().toString();
            checkPw = password.getText().toString();
            if (checkUser.equals(user) && checkPw.equals(pw)) {

                thestage.setScene(menu);

            } else {

                loginerror.setVisible(true);

            }

        });

        //menu
        logoutbtn = new Button();
        logoutbtn.setText("Logout");                                           //logoutbutton
        logoutbtn.setPrefSize(200, 50);
        logoutbtn.setTranslateY(-370);
        logoutbtn.setTranslateX(700);
        logoutbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        logoutbtn.setOnAction((ActionEvent event) -> {
            thestage.setScene(loginscherm);

        });

        lostbtn = new Button();
        lostbtn.setText("Lost");                                           //lost button
        lostbtn.setPrefSize(200, 50);
        lostbtn.setTranslateX(-500);
        lostbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostbtn.setOnAction((ActionEvent event) -> {

            thestage.setScene(lost);

        });

        foundbtn = new Button();
        foundbtn.setText("Found");                                           //lost button
        foundbtn.setPrefSize(200, 50);
        foundbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundbtn.setOnAction((ActionEvent event) -> {

            thestage.setScene(found);

        });

        statbtn = new Button();
        statbtn.setText("Statistics");                                           //lost button
        statbtn.setPrefSize(200, 50);
        statbtn.setTranslateX(500);
        statbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        statbtn.setOnAction((ActionEvent event) -> {

            thestage.setScene(stat);

        });

        //lost
        lostterugmenu = new Button();
        lostterugmenu.setText("Back");                                           //logoutbutton
        lostterugmenu.setPrefSize(200, 50);
        lostterugmenu.setTranslateY(-370);
        lostterugmenu.setTranslateX(700);
        lostterugmenu.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostterugmenu.setOnAction((ActionEvent event) -> {
            thestage.setScene(menu);

        });

        //found
        foundterugmenu = new Button();
        foundterugmenu.setText("Back");                                           //logoutbutton
        foundterugmenu.setPrefSize(200, 50);
        foundterugmenu.setTranslateY(-370);
        foundterugmenu.setTranslateX(700);
        foundterugmenu.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundterugmenu.setOnAction((ActionEvent event) -> {
            thestage.setScene(menu);

        });

        //stat
        statterugmenu = new Button();
        statterugmenu.setText("Back");                                           //logoutbutton
        statterugmenu.setPrefSize(200, 50);
        statterugmenu.setTranslateY(-370);
        statterugmenu.setTranslateX(700);
        statterugmenu.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        statterugmenu.setOnAction((ActionEvent event) -> {
            thestage.setScene(menu);

        });

        //EINDE CONTROLS
        //geeft controls aan verschillende panes
        inlogschermpane = new StackPane();                        //Stackpane inlogscherm
        inlogschermpane.getChildren().add(loginbtn);                        //toevoegen button
        inlogschermpane.getChildren().add(username);                   //toevoegen username text
        inlogschermpane.getChildren().add(password);
        inlogschermpane.getChildren().add(logologin);
        inlogschermpane.getChildren().add(loginerror);
        inlogschermpane.setStyle("-fx-background-color:#FFFFFF");

        menupane = new StackPane();
        menupane.getChildren().add(logoutbtn);
        menupane.getChildren().add(lostbtn);
        menupane.getChildren().add(foundbtn);
        menupane.getChildren().add(statbtn);
        menupane.setStyle("-fx-background-color:#FFFFFF");

        lostpane = new StackPane();
        lostpane.setStyle("-fx-background-color:#FFFFFF");
        lostpane.getChildren().add(lostterugmenu);

        foundpane = new StackPane();
        foundpane.setStyle("-fx-background-color:#FFFFFF");
        foundpane.getChildren().add(foundterugmenu);

        statpane = new StackPane();
        statpane.setStyle("-fx-background-color:#FFFFFF");
        statpane.getChildren().add(statterugmenu);

        //geeft alle scenes in
        loginscherm = new Scene(inlogschermpane, 1600, 800);
        menu = new Scene(menupane, 1600, 800);
        lost = new Scene(lostpane, 1600, 800);
        found = new Scene(foundpane, 1600, 800);
        stat = new Scene(statpane, 1600, 800);

        primaryStage.setTitle("Applicatie naam");
        primaryStage.setScene(loginscherm);
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
