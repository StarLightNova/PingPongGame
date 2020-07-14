import javafx.scene.layout.Pane;

class MyPlayer extends Player implements IMoveable{
	private Pane primary;
	private Double Player_W = 25.00;
	private Double Player_H = 100.00;
	private Double Center = Math.sqrt(Math.pow(this.Player_H, 2) + Math.pow(this.Player_W, 2)) / 2;
	private Double speed = 25.25;

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

	public void setSpeed(Double speed){
		this.speed = speed;
	}

	public Double getSpeed(){
		return this.speed;
	}

	public Double getMyPlayerH(){
		return this.Player_H;
	}

	public Double getMyPlayerW(){
		return this.Player_W;
	}

	public Double getMyYCoor(){
		return this.primary.getTranslateY();
	}

	@Override
	public void moveUp(){
		this.primary.setTranslateY(this.primary.getTranslateY() - this.speed);
	}

	@Override
	public void moveDown(){
		this.primary.setTranslateY(this.primary.getTranslateY() + this.speed);
	}

	public void TranslateToZero(){
		this.primary.setTranslateY(0);
	}

	public void TranslateToWindowHeight(Double height){
		this.primary.setTranslateY(height);
	}

}
