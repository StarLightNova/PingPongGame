import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class BoardPane extends Pane{
	private Double Window_W = 640.00;	//Standart Window Resolutions Height and Width
	private Double Window_H = 480.00;
	private BallPane ball;
	private Pane primaryPane;
	protected MyPlayer leftPlayer, rightPlayer;
	protected Wall left_wall, right_wall;
	protected Text left_score_text, right_score_text;

	public BoardPane(){
		this.primaryPane = new Pane();
		this.ball = new BallPane();
		this.left_wall = new Wall(true);
		this.right_wall = new Wall(false);

		this.leftPlayer = new MyPlayer(this.Window_W / 4, this.Window_H / 2);
		this.rightPlayer = new MyPlayer(this.Window_W - this.Window_W / 4 + this.leftPlayer.getMyPlayerCenter() , this.Window_H / 2);
		this.leftPlayer.setSpeed((this.Window_H / this.leftPlayer.getMyPlayerH() + this.Window_W / this.leftPlayer.getMyPlayerW()));
		this.rightPlayer.setSpeed((this.Window_H / this.rightPlayer.getMyPlayerH() + this.Window_W / this.rightPlayer.getMyPlayerW()));

		this.left_wall.installWall(this.Window_W / 8, this.Window_H);
		this.right_wall.installWall(this.Window_W / 8, this.Window_H);
		//this.right_wall.moveWallbyX(this.Window_W - this.Window_W / 4 + this.leftPlayer.getMyPlayerCenter() + this.ball.getMyCenter() * 2);
		this.right_wall.moveWallbyX(this.Window_W - this.Window_W / 8);

		this.primaryPane.setPrefSize(this.Window_W, this.Window_H);	//Set Screen to Standart
		this.primaryPane.setStyle("-fx-background-color: BLACK");	//Change pane background
		this.ball.setH(this.Window_H);
		this.ball.setW(this.Window_W);
		this.ball.setX(this.Window_W / 2);
		this.ball.setY(this.Window_H / 2);
		
		this.left_score_text = new Text(this.Window_W / 4, 50.00, "PLAYER 1: 0");
		this.left_score_text.setFill(Color.WHITE);
		this.right_score_text = new Text(this.Window_W - this.Window_W / 4 + this.leftPlayer.getMyPlayerCenter(), 50.00, "PLAYER 2: 0");
		this.right_score_text.setFill(Color.WHITE);


		this.primaryPane.getChildren().addAll(this.ball, this.leftPlayer, this.rightPlayer, this.left_wall, this.right_wall, this.left_score_text, this.right_score_text);	//Add ball and Players to the board
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
	public void randomDirection(double x, double y){
		this.ball.setDX(x);
		this.ball.setDY(y);
	}
}
