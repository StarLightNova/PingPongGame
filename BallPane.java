import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.util.Duration;
import javafx.scene.shape.Circle;

public class BallPane extends Pane{
	private final double radius = 12.5;
	private double x = this.radius, y = this.radius;
	private double dx = 1, dy = 1;
	private Timeline animation;
	private Circle circle = new Circle(this.x, this.y, this.radius);
	private Double main_window_H;
	private Double main_window_W;

	public BallPane(){
		circle.setFill(Color.WHITE);
		getChildren().add(circle);

		this.animation = new Timeline(
			new KeyFrame(Duration.millis(20), e -> moveBall()));
		this.animation.setCycleCount(Timeline.INDEFINITE);
		this.animation.play();
	}

	public void setH(Double h){
		this.main_window_H = h;
	}

	public void setW(Double w){
		this.main_window_W = w;
	}

	public void setX(double x){
		this.x = x;
	}

	public void setY(double y){
		this.y = y;
	}

	public void play(){
		this.animation.play();
	}

	public void pause(){
		this.animation.pause();
	}

	public void increaseSpeed(){
		this.animation.setRate(this.animation.getRate() + 0.1);
	}

	public void decreaseSpeed(){
		this.animation.setRate(
			this.animation.getRate() > 0 ? this.animation.getRate() - 0.1 : 0);
	}

	public DoubleProperty rateProperty(){
		return this.animation.rateProperty();
	}

	//getter of the pane width and height
	public Double getMyRadius(){
		return this.radius;
	}

	public void setDX(double x){
		this.dx = x;
	}

	public void setDY(double y){
		this.dy = y;
	}


	//Move the ball
	public void moveBall(){
		//chech boundaries
		
		if(x < radius || x > main_window_W - radius || x > main_window_W)
			dx *= -1;
		
		if(y < radius || y > main_window_H - radius || y > main_window_H)
			dy *= -1;

		x += dx;
		y += dy;
		
		circle.setCenterX(x);
		circle.setCenterY(y);

		increaseSpeed();

	}

}
