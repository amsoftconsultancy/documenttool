package deniz.document;

import deniz.document.model.CSVDocument;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;



import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Hello world!
 *
 */
public class App //extends Application
{




    public static void main( String[] args ) throws  Exception
    {
        System.out.println("Enter the path for the file");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        CSVDocument csvFile = new CSVDocument(filePath);

       csvFile.addHeader("am","memeler");
        csvFile.saveTmpFile();


   }



//    public void start(Stage primaryStage) {
//        final StackPane root = new StackPane();
//        final Button button = new Button("Click Me");
//
//        final Color startColor = Color.web("#e08090");
//        final Color endColor = Color.web("#80e090");
//
//        final ObjectProperty<Color> color = new SimpleObjectProperty<Color>(startColor);
//
//        // String that represents the color above as a JavaFX CSS function:
//        // -fx-body-color: rgb(r, g, b);
//        // with r, g, b integers between 0 and 255
//        final StringBinding cssColorSpec = Bindings.createStringBinding(new Callable<String>() {
//
//            public String call() throws Exception {
//                return String.format("-fx-body-color: rgb(%d, %d, %d);",
//                        (int) (256*color.get().getRed()),
//                        (int) (256*color.get().getGreen()),
//                        (int) (256*color.get().getBlue()));
//            }
//        }, color);
//
//        // bind the button's style property
//        button.styleProperty().bind(cssColorSpec);
//
//        final Timeline timeline = new Timeline(
//                new KeyFrame(Duration.ZERO, new KeyValue(color, startColor)),
//                new KeyFrame(Duration.seconds(1), new KeyValue(color, endColor)));
//
//        button.setOnAction(new EventHandler<ActionEvent>() {
//
//            public void handle(ActionEvent event) {
//                timeline.play();
//            }
//        });
//
//        // Create a rotating rectangle and set it as the graphic for the button
//        final Rectangle rotatingRect = new Rectangle(5,5,10,6);
//        rotatingRect.setFill(Color.CORNFLOWERBLUE);
//        final Pane rectHolder = new Pane();
//        rectHolder.setMinSize(20, 16);
//        rectHolder.setPrefSize(20, 16);
//        rectHolder.setMaxSize(20, 16);
//        rectHolder.getChildren().add(rotatingRect);
//        final RotateTransition rotate = new RotateTransition(Duration.seconds(1), rotatingRect);
//        rotate.setByAngle(360);
//        rotate.setCycleCount(Animation.INDEFINITE);
//        rotate.setInterpolator(Interpolator.LINEAR);
//
//        button.setGraphic(rectHolder);
//
//        // make the rectangle rotate when the mouse hovers over the button
//        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
//
//            public void handle(MouseEvent event) {
//                rotate.play();
//            }
//        });
//
//        button.setOnMouseExited(new EventHandler<MouseEvent>() {
//
//            public void handle(MouseEvent event) {
//                rotate.stop();
//                rotatingRect.setRotate(0);
//            }
//        });
//
//
//        root.getChildren().addAll(button);
//
//        final Scene scene = new Scene(root, 300, 175);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }


//    public void start(final Stage primaryStage) throws Exception {
//          AnchorPane anchorPane = new AnchorPane();
//          anchorPane.setPrefSize(600,400);
//          SplitPane splitPane = new SplitPane();
//          splitPane.setOrientation(Orientation.VERTICAL);
//          splitPane.setDividerPositions(0.5);
//          splitPane.setPrefSize(600,400);
//
//          AnchorPane upperPane = new AnchorPane();
//          AnchorPane bottomPane = new AnchorPane();
//          upperPane.setPrefSize(160,100);
//          bottomPane.setPrefSize(160,100);
//          upperPane.setStyle("-fx-background-color: #e0f9c7;");
//          bottomPane.setStyle("-fx-background-color: #f5f9c7;");
//          final TextField filePath = new TextField();
//          Button openFileButton = new Button();
//          openFileButton.setText("Open CSV File");
//          openFileButton.setStyle("-fx-background-color: #f1f9f7;");
//          final FileChooser fileChooser = new FileChooser();
//
//          openFileButton.setOnAction(new EventHandler<ActionEvent>() {
//
//              public void handle(final ActionEvent e) {
//                  File file =
//                          fileChooser.showOpenDialog(primaryStage);
//                  if (file != null) {
//                    filePath.setText(file.getAbsolutePath());
//                  }
//              }
//          });
//
//          upperPane.getChildren().add(0,openFileButton);
//        upperPane.getChildren().add(1,filePath);
//          splitPane.getItems().add(0, upperPane);
//          splitPane.getItems().add(1,bottomPane);
//          anchorPane.getChildren().add(0, splitPane);
//          primaryStage.setScene(new Scene(anchorPane));
//          primaryStage.show();
//
//    }
}
