import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class BoardPane extends Pane{
	private Double Window_W = 640.00;	//Standart Window Resolutions Height and Width
	private Double Window_H = 480.00;
	BallPane ball;
	Pane primaryPane;

	public BoardPane(){
		this.primaryPane = new Pane();
		this.ball = new BallPane();
		this.ball.setTranslateX(this.Window_W / 2 - this.ball.getMyCenter()); // Move to the center
		this.ball.setTranslateY(this.Window_H / 2 - this.ball.getMyCenter());
		this.primaryPane.setPrefSize(this.Window_W, this.Window_H);	//Set Screen to Standart
		this.primaryPane.setStyle("-fx-background-color: BLACK");	//Change pane background
		this.primaryPane.getChildren().add(this.ball);					//Add ball to board
		getChildren().add(this.primaryPane);
	}

	//Width getter
	public Double getMyWidth(){
		return this.Window_W;
	}

	//Height getter
	public Double getMyHeight(){
		return this.Window_H;
	}

	//Move ball using BoardPane
	public void StartBallMovement(){
		this.ball.moveBall();
	}
}
