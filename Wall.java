import javafx.scene.layout.Pane;

public class Wall extends Pane{
	private Pane primary;
	private boolean left_or_right;

	public Wall(boolean left_or_right){
		this.primary = new Pane();
		this.left_or_right = left_or_right;
		//this.primary.setStyle("-fx-background-color: WHITE");
		getChildren().add(this.primary);
	}

	public boolean isThisLeftOrRight(){
		return this.left_or_right;
	}

	public void installWall(Double w, Double h){
		this.primary.setPrefSize(w, h);
	}

	public void moveWallbyX(Double x){
		Double center = Math.pow(this.primary.getWidth(), 2) + Math.pow(this.primary.getHeight(), 2) / 2;
		this.primary.setTranslateX(x);
	}
}