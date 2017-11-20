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
	public static CheckBox MM;
	public static CheckBox CI;
	
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
				tipos = newValue;
				
			}		
		} 
		);
		marca.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				marcas = newValue;
				
			}
		}  );
		MM.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {				
				MM.setSelected(newValue);
			}
			
		});
		CI.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {				
				CI.setSelected(newValue);
			}
			
		});
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
	
	
	public static CheckBox getMediaMarkt(){
		return MM;
	}
	public static CheckBox getCorteIngles(){
		return CI;
	}
	
	
}
