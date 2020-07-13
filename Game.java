import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application{

	@Override
	public void start(Stage primary){
		BoardPane board = new BoardPane();
		//board.StartBallMovement();
		Scene scene = new Scene(board, board.getMyWidth(), board.getMyHeight());
		primary.setTitle("Alpha Test");
		primary.setScene(scene);
		primary.show();
	}
}
