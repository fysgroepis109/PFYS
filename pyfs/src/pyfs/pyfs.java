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
    TextField date, time, airport,/**/ naam, adres, city, zip, country, phone, mail,/**/ labelnr, flightnr, destin,/**/ lugtype, lugbrand, lugcolor, lugspef;/*Textfields Lost: */
    PasswordField password;
    Button loginbtn, logoutbtn, statbtn, lostbtn, foundbtn, lostterugmenu, foundterugmenu, statterugmenu, lostnext, lostback;
    ImageView logologin;
    StackPane inlogschermpane, menupane, lostpane, foundpane, statpane, lost2pane;
    Scene loginscherm, menu, lost, lost2, found, stat;
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
        //lost 1
        lostterugmenu = new Button();
        lostterugmenu.setText("Back");                                           //lost terug menu
        lostterugmenu.setPrefSize(200, 50);
        lostterugmenu.setTranslateY(-370);
        lostterugmenu.setTranslateX(700);
        lostterugmenu.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostterugmenu.setOnAction((ActionEvent event) -> {
            thestage.setScene(menu);

        });

        date = new TextField();                 //text voor datum invullen
        date.setPromptText("Date");
        date.setFont(Font.font("Verdana", 20));
        date.setTranslateY(-50);
        date.setMaxWidth(220);

        time = new TextField();                 //text voor tijd invullen
        time.setPromptText("Time");
        time.setFont(Font.font("Verdana", 20));
        time.setMaxWidth(220);
        time.setTranslateY(0);

        airport = new TextField();                 //text voor vliegveld
        airport.setPromptText("Airport");
        airport.setFont(Font.font("Verdana", 20));
        airport.setTranslateY(50);
        airport.setMaxWidth(220);

        lostnext = new Button();
        lostnext.setText("Next");                                           //logoutbutton
        lostnext.setPrefSize(120, 50);
        lostnext.setTranslateY(105);
        lostnext.setTranslateX(55);
        lostnext.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostnext.setOnAction((ActionEvent event) -> {

            thestage.setScene(lost2);

            date.getText();
            time.getText();
            airport.getText();

        });
        
        //lost 2
        
           lostback = new Button();
        lostback.setText("Back");                                           //logoutbutton
        lostback.setPrefSize(200, 50);
        lostback.setTranslateY(-370);
        lostback.setTranslateX(700);
        lostback.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostback.setOnAction((ActionEvent event) -> {
            thestage.setScene(lost);
            
            });
            
            naam = new TextField();                 //text voor tijd invullen
        naam.setPromptText("Name");
        naam.setFont(Font.font("Verdana", 20));
        naam.setMaxWidth(220);
        naam.setTranslateY(-300);

        adres = new TextField();                 //text voor adres invullen
        adres.setPromptText("Adress");
        adres.setFont(Font.font("Verdana", 20));
        adres.setMaxWidth(220);
        adres.setTranslateY(-250);
 
        city = new TextField();                 //text voor woonplaats invullen
        city.setPromptText("City");
        city.setFont(Font.font("Verdana", 20));
        city.setMaxWidth(220);
        city.setTranslateY(-200);

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
        lostpane.getChildren().add(date);
        lostpane.getChildren().add(time);
        lostpane.getChildren().add(airport);
        lostpane.getChildren().add(lostnext);
        
        
        lost2pane = new StackPane();
        lost2pane.setStyle("-fx-background-color:#FFFFFF");
        lost2pane.getChildren().add(lostback);
        lost2pane.getChildren().add(naam);
        lost2pane.getChildren().add(adres);
        lost2pane.getChildren().add(city);

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
        lost2 = new Scene(lost2pane, 1600, 800);
        found = new Scene(foundpane, 1600, 800);
        stat = new Scene(statpane, 1600, 800);

        primaryStage.setTitle("Applicatie naam");
        primaryStage.setScene(lost);
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
