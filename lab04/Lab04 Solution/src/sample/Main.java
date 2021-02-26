package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab04 Solution");


        GridPane myGrid = new GridPane();
        myGrid.setAlignment(Pos.CENTER);
        myGrid.setHgap(10);
        myGrid.setVgap(10);
        myGrid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(myGrid, 300, 275);




        Label userName = new Label("User Name:");
        myGrid.add(userName, 0, 1);

        TextField userNameField = new TextField();
        myGrid.add(userNameField, 1, 1);

        Label password = new Label("Password:");
        myGrid.add(password, 0, 2);

        PasswordField pwField = new PasswordField();
        myGrid.add(pwField, 1, 2);
        primaryStage.setScene(scene);

        Label fullName = new Label("Full Name:");
        myGrid.add(fullName, 0, 3);

        TextField fullNameField = new TextField();
        myGrid.add(fullNameField,1,3);

        Label email = new Label("E-Mail:");
        myGrid.add(email, 0, 4);

        TextField emailField = new TextField();
        myGrid.add(emailField,1,4);

        Label phoneNumber = new Label("Phone #:");
        myGrid.add(phoneNumber, 0, 5);

        TextField pnField = new TextField();
        myGrid.add(pnField,1,5);

        Label dateBirth = new Label("Date of Birth:");
        myGrid.add(dateBirth, 0, 6);

        DatePicker dateBirthField = new DatePicker();
        myGrid.add(dateBirthField,1,6);




        Button btn = new Button("Register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        myGrid.add(hbBtn, 1, 7);

        btn.setOnAction(e ->{
            System.out.println(userNameField.getText());
            System.out.println(pwField.getText());
            System.out.println(fullNameField.getText());
            System.out.println(emailField.getText());
        });




        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
