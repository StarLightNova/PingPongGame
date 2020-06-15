import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Player extends Pane{
	private long score;
	private Pane pane;
	private Rectangle shape;
	private double X;
	private double Y;

	public Player(int x, int y, int w, int h){
		pane = new Pane();
		shape = new Rectangle(x, y, w, h);
		shape.setFill(Color.WHITE);
		pane.getChildren().add(shape);
		getChildren().add(pane);
	}

}