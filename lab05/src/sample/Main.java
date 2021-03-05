package sample;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab05 Solution");


//        GridPane myGrid = new GridPane();
//        myGrid.setAlignment(Pos.CENTER);
//        myGrid.setHgap(10);
//        myGrid.setVgap(10);
//        myGrid.setPadding(new Insets(25, 25, 25, 25));
//
//        Scene scene = new Scene(myGrid, 300, 275);

        ObservableList<StudentRecord> marks = DataSource.getAllMarks();




        TableView table = new TableView();

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


        table.setItems(marks);

        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);



        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


