package application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {
	Media media;
	MediaPlayer player;
	MediaView view;
	Pane mpane;
	Mediabar bar;
	public Player(String file) {
		media=new Media(file);
		player=new MediaPlayer(media);
		view=new MediaView(player);
		mpane=new Pane();
		mpane.getChildren().add(view);
		setCenter(mpane);
		bar=new Mediabar(player);
		setBottom(bar);
		//setStyle(".fx.background-color: #bfc2c?");
		player.play();	
	}
	public void hai() {
		player.pause();
	}
}
