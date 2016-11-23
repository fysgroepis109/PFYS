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

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) {

        Button btn = new Button();
        btn.setText("Login");                                           //inlog button
        btn.setPrefSize(200, 50);
        btn.setTranslateY(90);
        btn.setStyle("-fx-base:darkcyan;-fx-border-color:black");

        window = primaryStage;
        btn.setOnAction((ActionEvent event) -> {
            window.setScene(scene2);
        });

        //scene1
        VBox layout1 = new VBox(20);
        scene1 = new Scene(layout1, 200, 200);

        //scene2
        StackPane layout2 = new StackPane();
        scene2 = new Scene(layout2, 200, 200);

        TextField username = new TextField();                 //text die gebruikersnaam print bij inlogscherm
        username.setPromptText("Username");
        username.setFont(Font.font("Verdana", 20));
        username.setTranslateY(-20);
        username.setMaxWidth(220);

        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        password.setMaxWidth(220);
        password.setFont(Font.font("Verdana", 20));
        password.setTranslateY(30);

        Pane root = new StackPane();
        root.getChildren().add(btn);                        //toevoegen button
        root.getChildren().add(username);                   //toevoegen username text
        root.getChildren().add(password);

        root.setStyle("-fx-background-color:#FFFFFF");

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Applicatie naam");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
