package application;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;


public class SampleGController {
	@FXML
	protected static ComboBox<String> tipos;
	@FXML
	protected static ComboBox<String> marcas;
	@FXML
	protected static CheckBox mediaMarkt;
	@FXML
	protected static CheckBox corteIngles;
	
	private Main main;
	public SampleGController(){	
	}
	
	@FXML
	private void initialize(){
		System.out.println(1);
		tipos.getItems().addAll("capsulas","goteo","superautomáticas","espresso","italianas");
		System.out.println(1);
		tipos.getSelectionModel().select("capsulas");
		System.out.println(1);
		marcas.getItems().addAll("bosch", "deLonghi", "digrato", "krups", "monsial", "rushell", "saivod", "severin", "taurus", "ufesa", "jura", "miele", "philips", "saeco", "oster", "smeg", "solac", "tassimo", "jata", "orbegozo", "whirlpool", "illi", "moulinex", "ok", "electrolux", "wmf", "tristar", "menz&konecke");
		System.out.println(1);
		marcas.getSelectionModel().select("bosch");
		
	}
	public void setMain(Main main){
		this.main = main;
		
	}
	public static String getTipo(){
		return tipos.getSelectionModel().getSelectedItem();
	}
	public static String getMarca(){
		return marcas.getSelectionModel().getSelectedItem();
		
	}
	public static CheckBox getMediaMarkt(){
		return mediaMarkt;
	}
	public static CheckBox getCorteIngles(){
		return corteIngles;
	}
}
