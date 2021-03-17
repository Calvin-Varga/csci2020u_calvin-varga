package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Main extends Application {
    private double flashFloodCount = 0;
    private double severeThunderstormCount = 0;
    private double specialMarineCount = 0;
    private double tornadoCount = 0;
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 600);


        canvas = new javafx.scene.canvas.Canvas();
        canvas.widthProperty().bind(primaryStage.widthProperty());
        canvas.heightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(canvas);

        primaryStage.setTitle("Lab 7 Solution");
        primaryStage.setScene(scene);


        File inFile = new File("weatherwarnings-2015.csv");



        try{
            BufferedReader reader = new BufferedReader(new FileReader(inFile));

            String line = reader.readLine();
            String[] cells = line.split(",");
            String label = cells[5];
            while ((line = reader.readLine())!= null){
                cells = line.split(",");
                String weather = cells[5].strip();


                //I understand this is an extremely odd way to check, but doing it normally was having unexpected errors

                if (weather.charAt(0)=='F'){
                    flashFloodCount += 1;
                }
                if (weather.charAt(0)=='T'){
                    tornadoCount += 1;
                }
                if (weather.charAt(0)=='S'){
                    if (weather.charAt(1)=='E'){
                        severeThunderstormCount+=1;
                    }
                    if (weather.charAt(1)=='P'){
                        specialMarineCount+=1;
                    }
                }

            }

        }
        catch (Exception e){
            System.out.println("Error");
            return;
        }

        GraphicsContext gc = canvas.getGraphicsContext2D();

        primaryStage.show();


        double sum = tornadoCount + specialMarineCount + severeThunderstormCount + flashFloodCount;
        System.out.println(tornadoCount);

        double position = 0;

        for (int i = 0; i < 4; i ++){
            if (i == 0){
                double size = (tornadoCount/sum) * 360;
                gc.setFill(Color.GREEN);
                gc.fillArc(500,100,400,400,position,size, ArcType.ROUND);
                position += size;
                gc.fillRect(50,50,75,50);
                gc.setFill(Color.BLACK);
                gc.fillText("Tornado",140,75);

            }
            if (i == 1){
                double size = (specialMarineCount/sum) * 360;
                gc.setFill(Color.BLUE);
                gc.fillArc(500,100,400,400,position,size, ArcType.ROUND);
                position += size;
                gc.fillRect(50,100,75,50);
                gc.setFill(Color.BLACK);
                gc.fillText("Special Marine",140,125);

            }
            if (i == 2){
                double size = (severeThunderstormCount/sum) * 360;
                gc.setFill(Color.RED);
                gc.fillArc(500,100,400,400,position,size, ArcType.ROUND);
                position += size;
                gc.fillRect(50,150,75,50);
                gc.setFill(Color.BLACK);
                gc.fillText("Severe Thunderstorm",140,175);
            }
            if (i == 3){
                double size = (flashFloodCount/sum) * 360;
                gc.setFill(Color.YELLOW);
                gc.fillArc(500,100,400,400,position,size, ArcType.ROUND);
                position += size;
                gc.fillRect(50,200,75,50);
                gc.setFill(Color.BLACK);
                gc.fillText("Flash Flood",140,225);

            }

        }



    }


    public static void main(String[] args) {
        launch(args);
    }
}
