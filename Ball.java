import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Ball extends Pane{
	private Circle ball;
	private Pane pane;

	public Ball(double x, double y, double r){
		ball = new Circle(x, y, r);
		pane = new Pane();
		ball.setFill(Color.WHITE);
		pane.getChildren().add(ball);
		getChildren().add(pane);
	}

}