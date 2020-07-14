import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class BoardPane extends Pane{
	private Double Window_W = 640.00;	//Standart Window Resolutions Height and Width
	private Double Window_H = 480.00;
	private BallPane ball;
	private Pane primaryPane;
	protected MyPlayer leftPlayer, rightPlayer;

	public BoardPane(){
		this.primaryPane = new Pane();
		this.ball = new BallPane();

		this.leftPlayer = new MyPlayer(this.Window_W / 4, this.Window_H / 2);
		this.rightPlayer = new MyPlayer(this.Window_W - this.Window_W / 4 + this.leftPlayer.getMyPlayerCenter() + this.ball.getMyCenter() * 2 , this.Window_H / 2);
		this.leftPlayer.setSpeed((this.Window_H / this.leftPlayer.getMyPlayerH() + this.Window_W / this.leftPlayer.getMyPlayerW()));
		this.rightPlayer.setSpeed((this.Window_H / this.rightPlayer.getMyPlayerH() + this.Window_W / this.rightPlayer.getMyPlayerW()));

		this.ball.setTranslateX(this.Window_W / 2 - this.ball.getMyCenter()); // Move to the center
		this.ball.setTranslateY(this.Window_H / 2 - this.ball.getMyCenter());
		this.primaryPane.setPrefSize(this.Window_W, this.Window_H);	//Set Screen to Standart
		this.primaryPane.setStyle("-fx-background-color: BLACK");	//Change pane background
		
		this.primaryPane.getChildren().addAll(this.ball, this.leftPlayer, this.rightPlayer);	//Add ball and Players to the board
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
