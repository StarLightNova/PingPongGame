import javafx.scene.layout.Pane;

class MyPlayer extends Player implements IMoveable{
	private Pane primary;
	private Double Player_W = 25.00;
	private Double Player_H = 100.00;
	private Double Center = Math.sqrt(Math.pow(this.Player_H, 2) + Math.pow(this.Player_W, 2)) / 2;

	public MyPlayer(Double x, Double y){
		this.primary = new Pane();
		this.primary.setPrefSize(this.Player_W, this.Player_H);
		this.primary.setStyle("-fx-background-color: WHITE");
		this.primary.setTranslateX(x - this.Center);
		this.primary.setTranslateY(y - this.Center);
		getChildren().add(this.primary);
	}

	public Double getMyPlayerCenter(){
		return this.Center;
	}
	
	@Override
	public int getScore(){
		return this.score;
	}

	@Override
	public void setScore(int other){
		this.score = other;
	}

	@Override
	public void addScore(){
		this.score++;
	}

	@Override
	public void moveUp(){}

	@Override
	public void moveDown(){}

}