import javafx.scene.layout.Pane;
abstract class Player extends Pane{
	protected int score = 0;
	abstract int getScore();
	abstract void setScore(int other);
	abstract void addScore();
}
