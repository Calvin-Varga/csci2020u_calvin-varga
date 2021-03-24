package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab8");


        TableView table = new TableView();

        ObservableList<StudentRecord> marks = DataSource.getAllMarks();

        TableColumn<StudentRecord, String> column1 = new TableColumn<>("SID");
        column1.setCellValueFactory(new PropertyValueFactory<>("sid"));

        TableColumn<StudentRecord, Float> column2 = new TableColumn<>("Assignments");
        column2.setCellValueFactory(new PropertyValueFactory<>("Assignments"));

        TableColumn<StudentRecord, Float> column3 = new TableColumn<>("Midterm");
        column3.setCellValueFactory(new PropertyValueFactory<>("Midterm"));

        TableColumn<StudentRecord, Float> column4 = new TableColumn<>("Final Exam");
        column4.setCellValueFactory(new PropertyValueFactory<>("finalExam"));

        TableColumn<StudentRecord, Double> column5 = new TableColumn<>("Final Mark");
        column5.setCellValueFactory(new PropertyValueFactory<>("finalMark"));

        TableColumn<StudentRecord, String> column6 = new TableColumn<>("Letter Grade");
        column6.setCellValueFactory(new PropertyValueFactory<>("Letter Grade"));



        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        table.getColumns().add(column4);
        table.getColumns().add(column5);
        table.getColumns().add(column6);

        Menu fileMenu = new Menu("File");

        MenuItem newTab = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem saveAs = new MenuItem("Save As");
        MenuItem exit = new MenuItem("Exit");


        //File currentFilename = new File();

        newTab.setOnAction(e -> {
            table.getItems().clear();
        });

//        newTab.setOnAction(e -> {
//            table.getItems().clear();
//        });

        exit.setOnAction(e -> {
            System.exit(0);
        });

        fileMenu.getItems().add(newTab);
        fileMenu.getItems().add(open);
        fileMenu.getItems().add(save);
        fileMenu.getItems().add(saveAs);
        fileMenu.getItems().add(exit);



        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().add(fileMenu);


        table.setItems(marks);

        VBox vbox = new VBox(menuBar,table);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
