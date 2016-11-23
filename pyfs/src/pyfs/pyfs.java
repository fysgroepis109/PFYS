package pyfs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;

/**
 *
 * @author IS109-Groep 5
 */
public class pyfs extends Application {

    @Override
    public void start(Stage primaryStage) {

        Text username = new Text();                 //text die gebruikersnaam print bij inlogscherm
        username.setText("Username");
        username.setFont(Font.font("Verdana", 20));
        username.setFill(Color.BLACK);
        username.setTranslateY(-110);

        TextField UsernameText = new TextField();
        UsernameText.setMaxWidth(220);                           //invoer voor username
        UsernameText.setTranslateY(-70);

        TextField PasswordText = new TextField();
        PasswordText.setMaxWidth(220);                        //invoer voor wachtwoord
        PasswordText.setTranslateY(20);

        Text password = new Text();
        password.setText("Password");
        password.setFont(Font.font("Verdana", 20));
        password.setFill(Color.BLACK);
        password.setTranslateY(-20);

        Button btn = new Button();
        btn.setText("Login");                                           //inlog button
        btn.setPrefSize(200, 50);
        btn.setTranslateY(90);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
        });

        Pane root = new StackPane();
        root.getChildren().add(btn);                        //toevoegen button
        root.getChildren().add(username);                    //toevoegen username text
        root.getChildren().add(password);

        root.getChildren().add(UsernameText);  //toevoegen Username text
        root.getChildren().add(PasswordText);  //toevoegen password text

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Applicatie naam");
        primaryStage.setScene(scene);
        primaryStage.show();
<<<<<<< HEAD

=======
        
        //test
        //hallo
>>>>>>> origin/master
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
