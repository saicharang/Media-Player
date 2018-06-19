package application;
import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	Player player;
	FileChooser filechooser;
	public void start(final Stage primaryStage) {
		MenuItem open=new MenuItem("open");
		Menu file=new Menu("file");
		MenuBar menu=new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		
		filechooser=new FileChooser();
		
		open.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				player.hai();
				File file=filechooser.showOpenDialog(primaryStage);
				if(file != null) {
					try {
						player=new Player(file.toURI().toURL().toExternalForm());
						Scene scene=new Scene(player,720,535,javafx.scene.paint.Color.BLACK);
						primaryStage.setScene(scene);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				}	
			}
		});
		Player player=new Player("file:///C:/sai.mp4");
		player.setTop(menu);
		Scene scene=new Scene(player,720,535,javafx.scene.paint.Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
