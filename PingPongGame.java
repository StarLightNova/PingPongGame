import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class PingPongGame extends Application{
	@Override
	public void start(Stage primaryStage){
		Board board = new Board();
		board.setStyle("-fx-background-color: BLACK;");

		Ball ball = new Ball(board.getW()/2, board.getH()/2, 6.25);

		Player p1 = new Player(50,100,10,40);
		Player p2 = new Player(board.getW()-50,100,10,40);

		board.getChildren().addAll(ball, p1, p2);

		p1.setOnKeyPressed( e -> {
			switch(e.getCode()){
				case UP: p1.setY(p1.getY() - 0.5); break;
				case DOWN: p1.setY(p1.getY() + 0.5); break;
			}
		});

		Scene scene = new Scene(board, board.getW(), board.getH());
		primaryStage.setTitle("Testing");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}