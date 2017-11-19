package application;
	
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application { 
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
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
		ArrayList<Cafetera> listaCafeteras = new ArrayList<Cafetera>();
		for(int a = 0; a<listaNombre.size(); a++){
			cafetera = new Cafetera(listaNombre.get(a).getAttribute("title"), listaPrecio.get(a).getText());			
			listaCafeteras.add(cafetera);
		}
		return listaCafeteras;
	}
	public static ArrayList<Cafetera> llenarListaMM(ArrayList<WebElement> listaNombre, ArrayList<WebElement> listaPrecio){
		Cafetera cafetera = new Cafetera();
		ArrayList<Cafetera> listaCafeteras = new ArrayList<Cafetera>();
		for(int a = 0; a<listaNombre.size(); a++){			
			cafetera = new Cafetera(listaNombre.get(a).getText(), listaPrecio.get(a).getAttribute("content"));			
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
}
