import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class BallPane extends Pane{
	private Double side = 12.5;
	private Pane primary;

	public BallPane(){
		this.primary = new Pane();
		this.primary.setPrefSize(this.side, this.side);	//set size to rectangle
		this.primary.setStyle("-fx-background-color: WHITE");
		getChildren().add(this.primary);
	}

	//getter of the pane width and height
	public Double getMySide(){
		return this.side;
	}

	public Double getMyCenter(){
		return Math.sqrt(Math.pow(this.side, 2) + Math.pow(this.side, 2)) / 2; //Finds the center of the rectangle by Pythagoras Theorem / 2
	}

	//Move the ball
	public void moveBall(){
		new Thread(new Runnable(){
			@Override
			public void run(){
				try{
					while(true){
						primary.setTranslateX(primary.getTranslateX() + 1.75);
						//System.out.println("Is moved");
						if(primary.getTranslateX() >= 100){
							break;
						}

						Thread.sleep(500);
					}
				}
				catch(InterruptedException e){}
			}
		}).start();

	}

}
