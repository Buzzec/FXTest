package net.buzzec.fxTest;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ColorfulCircles extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();

        Scene scene = new Scene(root, 1920, 1200, Color.BLACK);


        Group circles = new Group();
        for(int x = 0; x < 100; x++){
            Circle circle = new Circle(150, Color.web("white", 0.05));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.16));
            circle.setStrokeWidth(4);
            circle.setEffect(new BoxBlur(10, 10, 3));
            circles.getChildren().add(circle);
        }

        Rectangle colors = new Rectangle(
                scene.getWidth(),
                scene.getHeight(),
                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#F8BD55")),
                        new Stop(0.14, Color.web("#C0FE56")),
                        new Stop(0.28, Color.web("#5DFBC1")),
                        new Stop(0.43, Color.web("#64C2F8")),
                        new Stop(0.57, Color.web("#BE4AF7")),
                        new Stop(0.71, Color.web("#ED5FC2")),
                        new Stop(0.85, Color.web("#EF504C")),
                        new Stop(1, Color.web("#F2660F"))
                )
        );
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());

        Group blendModeGroup = new Group(
                new Group(
                        new Rectangle(scene.getWidth(), scene.getHeight(), Color.BLACK),
                        circles
                ),
                colors
        );
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);

        primaryStage.setScene(scene);

        Timeline timeline = new Timeline();
        for(Node circle : circles.getChildren()){
            timeline.getKeyFrames().addAll(
                    new KeyFrame(
                            Duration.ZERO,
                            new KeyValue(circle.translateXProperty(), Math.random() * scene.getWidth()),
                            new KeyValue(circle.translateYProperty(), Math.random() * scene.getHeight())
                    ),
                    new KeyFrame(
                            new Duration(40000),
                            new KeyValue(circle.translateXProperty(), Math.random() * scene.getWidth()),
                            new KeyValue(circle.translateYProperty(), Math.random() * scene.getHeight())
                    )
            );
        }

        timeline.play();

        primaryStage.setMaximized(true);

        primaryStage.show();
    }
}
