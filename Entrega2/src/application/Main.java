package application;
	
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application { 
	private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<String> tipos = FXCollections.observableArrayList();
    private ObservableList<String> marcas = FXCollections.observableArrayList();
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Buscador de Cafeteras");
        initRootLayout();
        showSample();
        

	}
	
	
	
	
	private void initRootLayout() {
		try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();          
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}




	private void showSample() {
		try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Sample.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            
            rootLayout.setCenter(personOverview);
            
            SampleGController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	public static void main(String[] args) throws Exception {
		
		launch(args);
		
	}			
	public static ArrayList<WebElement> borrarInecesarios(ArrayList<WebElement> listaElementos){
			for(int j = 0; j<4; j++){
				listaElementos.remove(listaElementos.size()-1);
			}		
		return listaElementos;
	}
	public static ArrayList<Cafetera> llenarLista(ArrayList<WebElement> listaNombre, ArrayList<WebElement> listaPrecio){
		Cafetera cafetera = new Cafetera();
		String nombre;
		String precio;
		ArrayList<Cafetera> listaCafeteras = new ArrayList<Cafetera>();
		for(int a = 0; a<listaNombre.size(); a++){
			nombre = "El Corte Ingles: " + listaNombre.get(a).getAttribute("title");
			System.out.println(nombre);
			precio = listaPrecio.get(a).getText();
			System.out.println(precio);
			cafetera = new Cafetera(nombre, precio);			
			listaCafeteras.add(cafetera);
		}
		return listaCafeteras;
	}
	public static ArrayList<Cafetera> llenarListaMM(ArrayList<WebElement> listaNombre, ArrayList<WebElement> listaPrecio){
		Cafetera cafetera = new Cafetera();
		ArrayList<Cafetera> listaCafeteras = new ArrayList<Cafetera>();
		String nombre;
		String precio;
		for(int a = 0; a<listaNombre.size(); a++){
			nombre = "Media Markt: " + listaNombre.get(a).getText();
			System.out.println(nombre);
			precio = listaPrecio.get(a).getAttribute("content");
			System.out.println(precio);
			cafetera = new Cafetera(nombre, precio);											
			listaCafeteras.add(cafetera);
		}
		return listaCafeteras;
	}
	public static void printRes(ArrayList<Cafetera> listaElementos){
		for(Cafetera c : listaElementos){
			System.out.println("Cafeteras :" + c.getNombre() + " " + c.getPrecio());
		}
		System.out.println("ResultadosCapsulas " + listaElementos.size());
	}
	public static void printResNomCI(ArrayList<WebElement> listaElementos){
		for(WebElement c : listaElementos){
			System.out.println("Nombre :" + c.getAttribute("title"));
		}
		System.out.println("ResultadosCapsulasCI " + listaElementos.size());
		
	}
	public static void printResNomMM(ArrayList<WebElement> listaElementos){
		for(WebElement c : listaElementos){
			System.out.println("Nombre :" + c.getText());
		}
		System.out.println("ResultadosCapsulasMM" + listaElementos.size());
		
	}
	public static void printResPreCI(ArrayList<WebElement> listaElementos){
		for(WebElement c : listaElementos){
			System.out.println("Precio :" + c.getText());
		}
		System.out.println("ResultadosCapsulasCI " + listaElementos.size());
		
	}
	public static void printResPreMM(ArrayList<WebElement> listaElementos){
		for(WebElement c : listaElementos){
			System.out.println("Precio :" + c.getAttribute("content"));
		}
		System.out.println("ResultadosCapsulasMM " + listaElementos.size());
		
	}
	static void waitForPageLoad(WebDriver wdriver) {
		new WebDriverWait(wdriver, 20).until(
		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		}
	public static void comprobarDom(WebElement element, WebDriver controlador2){
		if (!element.isDisplayed()) {				
			System.out.println("No está el elemento en la página en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		
	}
	public ObservableList<Cafetera> mostrarLista(){
		ArrayList<Cafetera> solucion = new ArrayList<Cafetera>();
		String tipos = SampleGController.getTipo();
		String marcas = SampleGController.getMarca();
		CheckBox MM = SampleGController.getMediaMarkt();
		CheckBox CI = SampleGController.getCorteIngles();
		if(tipos == "capsulas"){
			if(MM.isSelected()){
				
				
			}else if(CI.isSelected()){
				
			}else{
				
				
			}
		}
		
		return null;
		
		
	}
	public String escogerMarca(String marca){
		
		
		
		return null;
		
	}
}
