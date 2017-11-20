package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	
	@FXML 
	protected Button buscar;
	public static String tipos;
	public static String marcas;
	public static Boolean MM;
	public static Boolean CI;
	
	@SuppressWarnings("unused")
	private Main main;
	
	public SampleGController(){	
	}
	
	@FXML
	private void initialize(){
		tipo.getItems().clear();
		tipo.getItems().addAll(" ","capsulas","goteo","superautomaticas","espresso","italianas");
		tipo.getSelectionModel().select(" ");
		marca.getItems().clear();
		marca.getItems().addAll(" ","bosch", "deLonghi", "digrato", "krups", "monsial", "rushell", "saivod", "severin", "taurus", "ufesa", "jura", "miele", "philips", "saeco", "oster", "smeg", "solac", "tassimo", "jata", "orbegozo", "whirlpool", "illi", "moulinex", "ok", "electrolux", "wmf", "tristar", "menz&konecke");
		marca.getSelectionModel().select(" ");
		mediaMarkt.setSelected(false);
		corteIngles.setSelected(false);
			 
	}
	private void handleButtonAction(ActionEvent event) throws Exception {
       tipos = tipo.getSelectionModel().getSelectedItem();
       marcas = marca.getSelectionModel().getSelectedItem();
       MM = mediaMarkt.isSelected();
       CI = corteIngles.isSelected();
       Main.mostrarLista(tipos, marcas, MM, CI);
             
    }
	
		
	
	public void setMain(Main main){
		this.main = main;
		
	}
	
	
}
