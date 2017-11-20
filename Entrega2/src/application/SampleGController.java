package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;


public class SampleGController{
	@FXML
	protected ComboBox<String> tipo;
	@FXML
	protected ComboBox<String> marca;
	@FXML
	protected CheckBox mediaMarkt;
	@FXML
	protected CheckBox corteIngles;
	public static String tipos;
	public static String marcas;
	
	@SuppressWarnings("unused")
	private Main main;
	
	public SampleGController(){	
	}
	
	@FXML
	private void initialize(){
		tipo.getItems().clear();
		tipo.getItems().addAll("capsulas","goteo","superautomáticas","espresso","italianas");
		tipo.getSelectionModel().select("capsulas");
		marca.getItems().clear();
		marca.getItems().addAll("bosch", "deLonghi", "digrato", "krups", "monsial", "rushell", "saivod", "severin", "taurus", "ufesa", "jura", "miele", "philips", "saeco", "oster", "smeg", "solac", "tassimo", "jata", "orbegozo", "whirlpool", "illi", "moulinex", "ok", "electrolux", "wmf", "tristar", "menz&konecke");
		marca.getSelectionModel().select("bosch");
		mediaMarkt.setSelected(false);
		corteIngles.setSelected(false);
		tipo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				
			}
		
				
			
		}  );
			
		}
	
		
	
	public void setMain(Main main){
		this.main = main;
		
	}
	
	public static String getTipo(){
		return tipos;
	}
	public static String getMarca(){
		return marcas;
		
	}
	
	/*
	public static CheckBox getMediaMarkt(){
		return mediaMarkt;
	}
	public static CheckBox getCorteIngles(){
		return corteIngles;
	}
	*/
	
}
