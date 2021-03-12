package sample;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;



public class Main extends Application {
    private Canvas canvas;

    private static double[] avgHousingPricesByYear = { 247381.0,264171.4,287715.3,294736.1, 308431.4,322635.9,340253.0,363153.7};
    private static double[] avgCommercialPricesByYear = { 1121585.3,1219479.5,1246354.2,1295364.8, 1335932.6,1472362.0,1583521.9,1613246.3};

    private static String[] ageGroups = { "18-25", "26-35", "36-45", "46-55", "56-65", "65+"};
    private static int[] purchasesByAgeGroup = { 648, 1021, 2453, 3173, 1868, 2247};
    private static Color[] pieColours = { Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 600);


        canvas = new Canvas();
        canvas.widthProperty().bind(primaryStage.widthProperty());
        canvas.heightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(canvas);

        primaryStage.setTitle("Lab 6 Solution");
        primaryStage.setScene(scene);
        primaryStage.show();

        draw(root);
    }

    private void draw(Group root) {
        GraphicsContext gc = canvas.getGraphicsContext2D();



        for (int i = 0; i < avgCommercialPricesByYear.length; i++){

            int size = (int)avgCommercialPricesByYear[i]/3000;
            gc.setFill(Color.BLUE);
            gc.fillRect((i*50)+50,50+(520-size),15,size);
        }

        for (int i = 0; i < avgHousingPricesByYear.length; i++){

            int size = (int)avgHousingPricesByYear[i]/3000;
            gc.setFill(Color.RED);
            gc.fillRect((i*50)+35,50+(520-size),15,size);
        }




        double sum = 0;

        for (int i = 0; i < purchasesByAgeGroup.length; i++){
            sum += purchasesByAgeGroup[i];
        }

        double position = 0;


        for (int i = 0; i < ageGroups.length; i++){

            double size = (purchasesByAgeGroup[i]/sum)*360;


            gc.setFill(pieColours[i]);
            gc.fillArc(500,100,400,400,position,size,ArcType.ROUND);
            position += size;
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}

