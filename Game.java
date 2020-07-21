import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Game extends Application{

	@Override
	public void start(Stage primary){
		BoardPane board = new BoardPane();
		//board.StartBallMovement();

		double coin = Math.random();
		double dx = 0.0;
		if(coin > 0.5)
			dx = 1;
		else
			dx = -1;

		board.randomDirection(dx, 0);
		Scene scene = new Scene(board, board.getMyWidth(), board.getMyHeight());
		primary.setTitle("Alpha Test");
		primary.setScene(scene);
		primary.show();


		board.requestFocus();

		new Thread(new Runnable(){
			@Override
			public void run(){
				board.setOnKeyPressed(e -> {

					// System.out.println(board.leftPlayer.getMyYCoor());
					// System.out.println(board.rightPlayer.getMyYCoor());

					if(e.getCode() == KeyCode.W){
						if(board.leftPlayer.getMyYCoor() - board.leftPlayer.getSpeed() >= 0 )
							board.leftPlayer.moveUp();	
						else
							board.leftPlayer.TranslateToZero();
					}

					if(e.getCode() == KeyCode.S){
						if(board.leftPlayer.getMyYCoor() + board.leftPlayer.getSpeed() + board.leftPlayer.getMyPlayerH() <= board.getMyHeight())
							board.leftPlayer.moveDown();	
						else
							board.leftPlayer.TranslateToWindowHeight(board.getMyHeight() - board.leftPlayer.getMyPlayerH());
					}

					if(e.getCode() == KeyCode.UP){
						if(board.rightPlayer.getMyYCoor() - board.rightPlayer.getSpeed() >= 0 )
							board.rightPlayer.moveUp();	
						else
							board.rightPlayer.TranslateToZero();
					}

					if(e.getCode() == KeyCode.DOWN){
						if(board.rightPlayer.getMyYCoor() + board.rightPlayer.getSpeed() + board.rightPlayer.getMyPlayerH() <= board.getMyHeight())
							board.rightPlayer.moveDown();	
						else
							board.rightPlayer.TranslateToWindowHeight(board.getMyHeight() - board.rightPlayer.getMyPlayerH());
					}
				});

				

			}
		}).start();
	}
}
