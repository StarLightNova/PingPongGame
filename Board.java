import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Board extends Pane{
	private final int screen_width = 500;
	private final int screen_height = 250;
	private Pane board;

	public Board(){
		board = new Pane();
		getChildren().add(board);
	}

	public int getW(){
		return this.screen_width;
	}

	public int getH(){
		return this.screen_height;
	}
}