package pyfs;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
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

    /* Code is ingedeeld per sectie (login, menu, lost, found en stat)
    Aan het begin worden alle controls aangeroepen, dit is zo ingedeeld dat je
    snel kan onderscheiden welke control op welke pagina zit. Verder in de code zijn
    alle secties onderscheidde doormiddel van comments. Door control f te doen kan je snel naar de juiste sectie
    springen. Alle eens sectie meerder paginas heeft wordt dit doormiddel van een numering gedaan bijv. lost (eerste pag) lost1, lost2, lost 3 & lostfinal (laatste pag)
     */
//tijdelijke login
    String user = "admin";
    String pw = "test";
    String checkUser, checkPw;

    //voegt alle controls, scenes, panes en stages toe
    Stage thestage;

    //Loginscherm
    Text loginerror;
    TextField username;
    PasswordField password;
    Button loginbtn;
    ImageView logologin;
    StackPane inlogschermpane;
    Scene loginscherm;

    //Menu
    Button statbtn, lostbtn, foundbtn, logoutbtn;
    StackPane menupane;
    Scene menu;

    //Lost
    Button lostterugmenu, lostnext, lostnext2, lostback, lostback2, search, lostterugfinal, lostnext3;
    TextField time, naam, adres, city, zip, country, phone, mail,/**/ labelnr, flightnr, destin,/**/ lugtype, lugbrand, lugcolor, lugweight;
    ComboBox airport;
    TextArea lugspef;
    DatePicker date;
    StackPane lostpane, lost2pane, lost3pane, lost4pane, lostfinalpane;
    Scene lost, lost2, lost3, lost4, lostfinal;

    //Found
    Button foundterugmenu, foundnext, foundnext2,foundnext3, find, foundback, foundback2;
    TextField ftime, flabelnr, fflightnr, fdest, nametrav;
    DatePicker fdate;
    ComboBox fairport;
    StackPane foundpane, found2pane, found3pane, foundfinalpane;
    Scene found, found2, found3, foundfinal;

    //Stat
    Button statterugmenu;
    StackPane statpane;
    Scene stat;

    @Override
    public void start(Stage primaryStage) {

        thestage = primaryStage; //verklaart toegoevoegde stage

        //BEGIN CONTROLS
        //Loginscherm
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
        //Menu
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

        date = new DatePicker();
        date.setPromptText("Date");
        date.setMaxWidth(220);
        date.setTranslateY(-50);

        time = new TextField();                 //text voor tijd invullen
        time.setPromptText("Time (HH:MM)");
        time.setFont(Font.font("Verdana", 20));
        time.setMaxWidth(220);
        time.setTranslateY(0);

        airport = new ComboBox();                 //text voor vliegveld
        airport.setPromptText("Airport");
        airport.setTranslateY(50);
        airport.setMaxWidth(220);
        airport.getItems().addAll(
                "Schiphol",
                "Ankara Esenboga"
        );

        lostnext = new Button();
        lostnext.setText("Next");                                           //logoutbutton
        lostnext.setPrefSize(120, 50);
        lostnext.setTranslateY(105);
        lostnext.setTranslateX(55);
        lostnext.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostnext.setOnAction((ActionEvent event) -> {

            thestage.setScene(lost2);

            time.getText();

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
        naam.setTranslateY(-250);

        adres = new TextField();                 //text voor adres invullen
        adres.setPromptText("Adress");
        adres.setFont(Font.font("Verdana", 20));
        adres.setMaxWidth(220);
        adres.setTranslateY(-200);

        city = new TextField();                 //text voor woonplaats invullen
        city.setPromptText("City");
        city.setFont(Font.font("Verdana", 20));
        city.setMaxWidth(220);
        city.setTranslateY(-150);

        zip = new TextField();
        zip.setPromptText("Zip code");
        zip.setFont(Font.font("Verdana", 20));
        zip.setMaxWidth(220);
        zip.setTranslateY(-100);

        country = new TextField();
        country.setPromptText("Country");
        country.setFont(Font.font("Verdana", 20));
        country.setMaxWidth(220);
        country.setTranslateY(-50);

        phone = new TextField();
        phone.setPromptText("Phone number");
        phone.setFont(Font.font("Verdana", 20));
        phone.setMaxWidth(220);
        phone.setTranslateY(0);

        mail = new TextField();
        mail.setPromptText("E-mail");
        mail.setFont(Font.font("Verdana", 20));
        mail.setMaxWidth(220);
        mail.setTranslateY(50);

        lostnext2 = new Button();
        lostnext2.setText("Next");                                           //logoutbutton
        lostnext2.setPrefSize(120, 50);
        lostnext2.setTranslateY(105);
        lostnext2.setTranslateX(55);
        lostnext2.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostnext2.setOnAction((ActionEvent event) -> {

            thestage.setScene(lost3);

            naam.getText();
            adres.getText();
            city.getText();
            zip.getText();
            country.getText();
            phone.getText();
            mail.getText();

        });

        // lost 3
        lugtype = new TextField();                 //text voor tijd invullen
        lugtype.setPromptText("Lugage type");
        lugtype.setFont(Font.font("Verdana", 20));
        lugtype.setMaxWidth(300);
        lugtype.setTranslateY(-200);

        lugbrand = new TextField();                 //text voor adres invullen
        lugbrand.setPromptText("Lugage brand");
        lugbrand.setFont(Font.font("Verdana", 20));
        lugbrand.setMaxWidth(300);
        lugbrand.setTranslateY(-150);

        lugcolor = new TextField();                 //text voor woonplaats invullen
        lugcolor.setPromptText("Lugage color");
        lugcolor.setFont(Font.font("Verdana", 20));
        lugcolor.setMaxWidth(300);
        lugcolor.setTranslateY(-100);

        lugweight = new TextField();                 //text voor woonplaats invullen
        lugweight.setPromptText("Lugage weight");
        lugweight.setFont(Font.font("Verdana", 20));
        lugweight.setMaxWidth(300);
        lugweight.setTranslateY(-50);

        lugspef = new TextArea();
        lugspef.setPromptText("Lugage specifications");
        lugspef.setFont(Font.font("Verdana", 20));
        lugspef.setMaxSize(300, 160);
        lugspef.setTranslateY(60);

        lostback2 = new Button();
        lostback2.setText("Back");                                           //logoutbutton
        lostback2.setPrefSize(200, 50);
        lostback2.setTranslateY(-370);
        lostback2.setTranslateX(700);
        lostback2.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostback2.setOnAction((ActionEvent event) -> {
            thestage.setScene(lost2);

        });

        lostnext3 = new Button();
        lostnext3.setText("Next");                                           //logoutbutton
        lostnext3.setPrefSize(120, 50);
        lostnext3.setTranslateY(175);
        lostnext3.setTranslateX(92);
        lostnext3.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostnext3.setOnAction((ActionEvent event) -> {

            thestage.setScene(lost4);
        });

        //lost 4
        labelnr = new TextField();                 //text voor tijd invullen
        labelnr.setPromptText("Label number");
        labelnr.setFont(Font.font("Verdana", 20));
        labelnr.setMaxWidth(220);
        labelnr.setTranslateY(-50);

        flightnr = new TextField();                 //text voor adres invullen
        flightnr.setPromptText("Lugage brand");
        flightnr.setFont(Font.font("Verdana", 20));
        flightnr.setMaxWidth(220);
        flightnr.setTranslateY(0);

        destin = new TextField();                 //text voor woonplaats invullen
        destin.setPromptText("Lugage color");
        destin.setFont(Font.font("Verdana", 20));
        destin.setMaxWidth(220);
        destin.setTranslateY(50);

        search = new Button();
        search.setText("Next");                                           //logoutbutton
        search.setPrefSize(120, 50);
        search.setTranslateY(175);
        search.setTranslateX(92);
        search.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        search.setOnAction((ActionEvent event) -> {

            thestage.setScene(lostfinal);
        });

        //lost final
        lostterugfinal = new Button();
        lostterugfinal.setText("Menu");                                           //lost terug menu
        lostterugfinal.setPrefSize(200, 50);
        lostterugfinal.setTranslateY(-370);
        lostterugfinal.setTranslateX(700);
        lostterugfinal.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostterugfinal.setOnAction((ActionEvent event) -> {
            thestage.setScene(menu);

        });

        //found
        fdate = new DatePicker();
        fdate.setPromptText("Date");
        fdate.setMaxWidth(220);
        fdate.setTranslateY(-50);

        ftime = new TextField();                 //text voor tijd invullen
        ftime.setPromptText("Time (HH:MM)");
        ftime.setFont(Font.font("Verdana", 20));
        ftime.setMaxWidth(220);
        ftime.setTranslateY(0);

        fairport = new ComboBox();                 //text voor vliegveld
        fairport.setPromptText("Airport");
        fairport.setTranslateY(50);
        fairport.setMaxWidth(220);
        fairport.getItems().addAll(
                "Schiphol",
                "Ankara Esenboga"
        );

        foundterugmenu = new Button();
        foundterugmenu.setText("Back");                                           //logoutbutton
        foundterugmenu.setPrefSize(200, 50);
        foundterugmenu.setTranslateY(-370);
        foundterugmenu.setTranslateX(700);
        foundterugmenu.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundterugmenu.setOnAction((ActionEvent event) -> {
            thestage.setScene(menu);

        });

        foundnext = new Button();
        foundnext.setText("Next");                                           //logoutbutton
        foundnext.setPrefSize(120, 50);
        foundnext.setTranslateY(105);
        foundnext.setTranslateX(55);
        foundnext.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundnext.setOnAction((ActionEvent event) -> {

            thestage.setScene(found2);

            ftime.getText();

        });

        //found 2
        flabelnr = new TextField();                 //text voor labelnr invullen
        flabelnr.setPromptText("Label Number");
        flabelnr.setFont(Font.font("Verdana", 20));
        flabelnr.setMaxWidth(220);
        flabelnr.setTranslateY(-250);

        fflightnr = new TextField();                 //text voor flightnr invullen
        fflightnr.setPromptText("Flight Number");
        fflightnr.setFont(Font.font("Verdana", 20));
        fflightnr.setMaxWidth(220);
        fflightnr.setTranslateY(-200);

        fdest = new TextField();                 //text voor plaats invullen
        fdest.setPromptText("Destination");
        fdest.setFont(Font.font("Verdana", 20));
        fdest.setMaxWidth(220);
        fdest.setTranslateY(-150);

        nametrav = new TextField();             //text voor naam invullen
        nametrav.setPromptText("Name Traveller");
        nametrav.setFont(Font.font("Verdana", 20));
        nametrav.setMaxWidth(220);
        nametrav.setTranslateY(-100);
        
        foundback = new Button();
        foundback.setText("Back");                                           //logoutbutton
        foundback.setPrefSize(200, 50);
        foundback.setTranslateY(-370);
        foundback.setTranslateX(700);
        foundback.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundback.setOnAction((ActionEvent event) -> {
            thestage.setScene(found);

        });

        foundnext2 = new Button();
        foundnext2.setText("Next");                                           //nextbutton
        foundnext2.setPrefSize(120, 50);
        foundnext2.setTranslateY(105);
        foundnext2.setTranslateX(55);
        foundnext2.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundnext2.setOnAction((ActionEvent event) -> {

            thestage.setScene(found3);

        });
        
        

        //found 3
        
        lugtype = new TextField();                 //text voor tijd invullen
        lugtype.setPromptText("Lugage type");
        lugtype.setFont(Font.font("Verdana", 20));
        lugtype.setMaxWidth(300);
        lugtype.setTranslateY(-200);

        lugbrand = new TextField();                 //text voor adres invullen
        lugbrand.setPromptText("Lugage brand");
        lugbrand.setFont(Font.font("Verdana", 20));
        lugbrand.setMaxWidth(300);
        lugbrand.setTranslateY(-150);

        lugcolor = new TextField();                 //text voor woonplaats invullen
        lugcolor.setPromptText("Lugage color");
        lugcolor.setFont(Font.font("Verdana", 20));
        lugcolor.setMaxWidth(300);
        lugcolor.setTranslateY(-100);

        lugweight = new TextField();                 //text voor woonplaats invullen
        lugweight.setPromptText("Lugage weight");
        lugweight.setFont(Font.font("Verdana", 20));
        lugweight.setMaxWidth(300);
        lugweight.setTranslateY(-50);

        lugspef = new TextArea();
        lugspef.setPromptText("Lugage specifications");
        lugspef.setFont(Font.font("Verdana", 20));
        lugspef.setMaxSize(300, 160);
        lugspef.setTranslateY(60);

        foundback2 = new Button();
        foundback2.setText("Back");                                           //logoutbutton
        foundback2.setPrefSize(200, 50);
        foundback2.setTranslateY(-370);
        foundback2.setTranslateX(700);
        foundback2.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundback2.setOnAction((ActionEvent event) -> {
            thestage.setScene(found2);

        });

        foundnext3 = new Button();
        foundnext3.setText("Next");                                           //logoutbutton
        foundnext3.setPrefSize(120, 50);
        foundnext3.setTranslateY(175);
        foundnext3.setTranslateX(92);
        foundnext3.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundnext3.setOnAction((ActionEvent event) -> {

            thestage.setScene(foundfinal);
        });
        
        //foundfinal
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
        //PANES
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
        lost2pane.getChildren().add(zip);
        lost2pane.getChildren().add(country);
        lost2pane.getChildren().add(phone);
        lost2pane.getChildren().add(mail);
        lost2pane.getChildren().add(lostnext2);

        lost3pane = new StackPane();
        lost3pane.setStyle("-fx-background-color:#FFFFFF");
        lost3pane.getChildren().add(lugtype);
        lost3pane.getChildren().add(lugbrand);
        lost3pane.getChildren().add(lugcolor);
        lost3pane.getChildren().add(lugspef);
        lost3pane.getChildren().add(lugweight);
        lost3pane.getChildren().add(lostback2);
        lost3pane.getChildren().add(lostnext3);

        lost4pane = new StackPane();
        lost4pane.setStyle("-fx-background-color:#FFFFFF");
        lost4pane.getChildren().add(labelnr);
        lost4pane.getChildren().add(flightnr);
        lost4pane.getChildren().add(destin);
        lost4pane.getChildren().add(search);

        lostfinalpane = new StackPane();
        lostfinalpane.setStyle("-fx-background-color:#FFFFFF");
        lostfinalpane.getChildren().add(lostterugfinal);

        foundpane = new StackPane();
        foundpane.setStyle("-fx-background-color:#FFFFFF");
        foundpane.getChildren().add(foundterugmenu);
        foundpane.getChildren().add(fdate);
        foundpane.getChildren().add(ftime);
        foundpane.getChildren().add(fairport);
        foundpane.getChildren().add(foundnext);

        found2pane = new StackPane();
        found2pane.setStyle("-fx-background-color:#FFFFFF");
        found2pane.getChildren().add(flabelnr);
        found2pane.getChildren().add(fflightnr);
        found2pane.getChildren().add(fdest);
        found2pane.getChildren().add(nametrav);
        found2pane.getChildren().add(foundback);
        found2pane.getChildren().add(foundnext2);

        found3pane = new StackPane();
        found3pane.setStyle("-fx-background-color:#FFFFFF");
        found3pane.getChildren().add(lugtype);
        found3pane.getChildren().add(lugbrand);
        found3pane.getChildren().add(lugcolor);
        found3pane.getChildren().add(lugspef);
        found3pane.getChildren().add(lugweight);
        found3pane.getChildren().add(foundback2);
        found3pane.getChildren().add(foundnext3);

        foundfinalpane = new StackPane();
        foundfinalpane.setStyle("-fx-background-color:#FFFFFF");

        statpane = new StackPane();
        statpane.setStyle("-fx-background-color:#FFFFFF");
        statpane.getChildren().add(statterugmenu);

        //geeft alle scenes in
        loginscherm = new Scene(inlogschermpane, 1600, 800);
        menu = new Scene(menupane, 1600, 800);
        lost = new Scene(lostpane, 1600, 800);
        lost2 = new Scene(lost2pane, 1600, 800);
        lost3 = new Scene(lost3pane, 1600, 800);
        lost4 = new Scene(lost4pane, 1600, 800);
        lostfinal = new Scene(lostfinalpane, 1600, 800);
        found = new Scene(foundpane, 1600, 800);
        found2 = new Scene(found2pane, 1600, 800);
        found3 = new Scene(found3pane, 1600, 800);
        foundfinal = new Scene(foundfinalpane, 1600, 800);
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
