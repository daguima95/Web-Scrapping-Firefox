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
import javafx.scene.media.Media;


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
			System.out.println("No est� el elemento en la p疊ina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		
	}
	
	public static ObservableList<Cafetera> mostrarLista(String tipo, String marca, Boolean mediaMarkt, Boolean corteIngles) throws Exception{
		ArrayList<Cafetera> solucion = new ArrayList<Cafetera>();
		String tipos = tipo;
		String marcas = marca;
		Boolean MM = mediaMarkt;
		Boolean CI = corteIngles;
		if(MM == true){
			if(tipo == "capsulas"){		
				
				if(marcas == "bosch") {
					solucion.addAll(MediaMarkt.boschMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(MediaMarkt.deLonghiMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "krups") {
					solucion.addAll(MediaMarkt.krupsMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "philips") {
					solucion.addAll(MediaMarkt.philipsMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "tassimo") {
					solucion.addAll(MediaMarkt.tassimoMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == ""){
					solucion.addAll(MediaMarkt.boschMono());
					solucion.addAll(MediaMarkt.deLonghiMono());
					solucion.addAll(MediaMarkt.krupsMono());
					solucion.addAll(MediaMarkt.philipsMono());
					solucion.addAll(MediaMarkt.tassimoMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}else if(tipo == "goteo"){
				
				if(marcas == "bosch") {
					solucion.addAll(MediaMarkt.boschGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(MediaMarkt.deLonghiGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "rushell") {
					solucion.addAll(MediaMarkt.rushellGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "taurus") {
					solucion.addAll(MediaMarkt.taurusGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "ufesa") {
					solucion.addAll(MediaMarkt.ufesaGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "philips") {
					solucion.addAll(MediaMarkt.philipsGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "jata") {
					solucion.addAll(MediaMarkt.jataGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "moulinex") {
					solucion.addAll(MediaMarkt.moulinexGoteo());
					return (ObservableList<Cafetera>) solucion;
					
					
				}else if(marcas == "ok") {
					solucion.addAll(MediaMarkt.okGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "electrolux") {
					solucion.addAll(MediaMarkt.electroGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "wmf") {
					solucion.addAll(MediaMarkt.wmfGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "tristar") {
					solucion.addAll(MediaMarkt.tristarGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas ==" ") {
					solucion.addAll(MediaMarkt.boschGoteo());
					solucion.addAll(MediaMarkt.deLonghiGoteo());
					solucion.addAll(MediaMarkt.rushellGoteo());
					solucion.addAll(MediaMarkt.taurusGoteo());
					solucion.addAll(MediaMarkt.ufesaGoteo());
					solucion.addAll(MediaMarkt.philipsGoteo());
					solucion.addAll(MediaMarkt.jataGoteo());
					solucion.addAll(MediaMarkt.moulinexGoteo());
					solucion.addAll(MediaMarkt.okGoteo());
					solucion.addAll(MediaMarkt.electroGoteo());
					solucion.addAll(MediaMarkt.wmfGoteo());
					solucion.addAll(MediaMarkt.tristarGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}else if(tipo == "superautomaticas") {
				
				if(marcas == "bosch") {
					solucion.addAll(MediaMarkt.boschSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(MediaMarkt.deLonghiSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "krups") {
					solucion.addAll(MediaMarkt.krupsSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "philips") {
					solucion.addAll(MediaMarkt.philipsSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "saeco") {
					solucion.addAll(MediaMarkt.saecoSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "jura") {
					solucion.addAll(MediaMarkt.juraSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas ==" ") {
					solucion.addAll(MediaMarkt.boschSuper());
					solucion.addAll(MediaMarkt.deLonghiSuper());
					solucion.addAll(MediaMarkt.krupsSuper());
					solucion.addAll(MediaMarkt.philipsSuper());
					solucion.addAll(MediaMarkt.saecoSuper());
					solucion.addAll(MediaMarkt.juraSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}else if(tipo == "expresso") {
				
				if(marcas == "deLonghi") {
					solucion.addAll(MediaMarkt.deLonghiExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "krups") {
					solucion.addAll(MediaMarkt.krupsExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "ufesa") {
					solucion.addAll(MediaMarkt.ufesaExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "saeco") {
					solucion.addAll(MediaMarkt.saecoExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "oster") {
					solucion.addAll(MediaMarkt.osterExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "solac") {
					solucion.addAll(MediaMarkt.solacExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "jata") {
					solucion.addAll(MediaMarkt.jataExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "orbegozo") {
					solucion.addAll(MediaMarkt.orbegozoExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "whirlpool") {
					solucion.addAll(MediaMarkt.whirlpoolExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas ==" ") {
					solucion.addAll(MediaMarkt.deLonghiExpress());
					solucion.addAll(MediaMarkt.krupsExpress());
					solucion.addAll(MediaMarkt.ufesaExpress());
					solucion.addAll(MediaMarkt.saecoExpress());
					solucion.addAll(MediaMarkt.osterExpress());
					solucion.addAll(MediaMarkt.solacExpress());
					solucion.addAll(MediaMarkt.jataExpress());
					solucion.addAll(MediaMarkt.orbegozoExpress());
					solucion.addAll(MediaMarkt.whirlpoolExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}else if(tipo == "italianas") {
				
				if(marcas == "jata") {
					solucion.addAll(MediaMarkt.jataTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "taurus") {
					solucion.addAll(MediaMarkt.taurusTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "menz&konecke") {
					solucion.addAll(MediaMarkt.menzTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas ==" ") {
					solucion.addAll(MediaMarkt.jataTradicional());
					solucion.addAll(MediaMarkt.taurusTradicional());
					solucion.addAll(MediaMarkt.menzTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
			}else {
				if(marcas == "bosch") {
					solucion.addAll(MediaMarkt.boschGoteo());
					solucion.addAll(MediaMarkt.boschMono());
					solucion.addAll(MediaMarkt.boschSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(MediaMarkt.deLonghiExpress());
					solucion.addAll(MediaMarkt.deLonghiGoteo());
					solucion.addAll(MediaMarkt.deLonghiMono());
					solucion.addAll(MediaMarkt.deLonghiSuper());
					return (ObservableList<Cafetera>) solucion;
				
				}else if(marcas == "krups") {
					solucion.addAll(MediaMarkt.krupsExpress());
					solucion.addAll(MediaMarkt.krupsMono());
					solucion.addAll(MediaMarkt.krupsSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "rushell") {
					solucion.addAll(MediaMarkt.rushellGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "taurus") {
					solucion.addAll(MediaMarkt.taurusGoteo());
					solucion.addAll(MediaMarkt.taurusTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "ufesa") {
					solucion.addAll(MediaMarkt.ufesaExpress());
					solucion.addAll(MediaMarkt.ufesaGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "philips") {
					solucion.addAll(MediaMarkt.philipsGoteo());
					solucion.addAll(MediaMarkt.philipsMono());
					solucion.addAll(MediaMarkt.philipsSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "saeco") {
					solucion.addAll(MediaMarkt.saecoExpress());
					solucion.addAll(MediaMarkt.saecoSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "oster") {
					solucion.addAll(MediaMarkt.osterExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "solac") {
					solucion.addAll(MediaMarkt.solacExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "tassimo") {
					solucion.addAll(MediaMarkt.tassimoMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "jata") {
					solucion.addAll(MediaMarkt.jataExpress());
					solucion.addAll(MediaMarkt.jataGoteo());
					solucion.addAll(MediaMarkt.jataTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "orbegozo") {
					solucion.addAll(MediaMarkt.orbegozoExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "whirlpool") {
					solucion.addAll(MediaMarkt.whirlpoolExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "illi") {
					solucion.addAll(MediaMarkt.illiExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "moulinex") {
					solucion.addAll(MediaMarkt.moulinexGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "ok") {
					solucion.addAll(MediaMarkt.okGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "electrolux") {
					solucion.addAll(MediaMarkt.electroGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "wmf") {
					solucion.addAll(MediaMarkt.wmfGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "tristar") {
					solucion.addAll(MediaMarkt.tristarGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas =="menz&konecke") {
					solucion.addAll(MediaMarkt.menzTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == " "){
					solucion.addAll(MediaMarkt.boschGoteo());
					solucion.addAll(MediaMarkt.boschMono());
					solucion.addAll(MediaMarkt.boschSuper());
					solucion.addAll(MediaMarkt.deLonghiExpress());
					solucion.addAll(MediaMarkt.deLonghiGoteo());
					solucion.addAll(MediaMarkt.deLonghiMono());
					solucion.addAll(MediaMarkt.deLonghiSuper());
					solucion.addAll(MediaMarkt.krupsExpress());
					solucion.addAll(MediaMarkt.krupsMono());
					solucion.addAll(MediaMarkt.krupsSuper());
					solucion.addAll(MediaMarkt.rushellGoteo());
					solucion.addAll(MediaMarkt.taurusGoteo());
					solucion.addAll(MediaMarkt.taurusTradicional());
					solucion.addAll(MediaMarkt.ufesaExpress());
					solucion.addAll(MediaMarkt.ufesaGoteo());
					solucion.addAll(MediaMarkt.philipsGoteo());
					solucion.addAll(MediaMarkt.philipsMono());
					solucion.addAll(MediaMarkt.philipsSuper());
					solucion.addAll(MediaMarkt.saecoExpress());
					solucion.addAll(MediaMarkt.saecoSuper());
					solucion.addAll(MediaMarkt.osterExpress());
					solucion.addAll(MediaMarkt.solacExpress());
					solucion.addAll(MediaMarkt.tassimoMono());
					solucion.addAll(MediaMarkt.jataExpress());
					solucion.addAll(MediaMarkt.jataGoteo());
					solucion.addAll(MediaMarkt.jataTradicional());
					solucion.addAll(MediaMarkt.orbegozoExpress());
					solucion.addAll(MediaMarkt.whirlpoolExpress());
					solucion.addAll(MediaMarkt.illiExpress());
					solucion.addAll(MediaMarkt.moulinexGoteo());
					solucion.addAll(MediaMarkt.okGoteo());
					solucion.addAll(MediaMarkt.electroGoteo());
					solucion.addAll(MediaMarkt.wmfGoteo());
					solucion.addAll(MediaMarkt.tristarGoteo());
					solucion.addAll(MediaMarkt.menzTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}
				
		}else if(CI == true){
			
			if(tipo == "capsulas"){	
				
				if(marcas == "bosch") {
					solucion.addAll(CorteIngles.boschCapsulas());
					return (ObservableList<Cafetera>) solucion;					
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiCapsulas());
					return (ObservableList<Cafetera>) solucion;		
					
					
				}else if(marcas == "digrato") {
					solucion.addAll(CorteIngles.digratoCapsulas());
					return (ObservableList<Cafetera>) solucion;		
					
				}else if(marcas == "krups") {
					solucion.addAll(CorteIngles.krupsCapsulas());
					return (ObservableList<Cafetera>) solucion;		
					
				}else if(marcas ==" ") {
					solucion.addAll(CorteIngles.boschCapsulas());					
					solucion.addAll(CorteIngles.deLonghiCapsulas());
					solucion.addAll(CorteIngles.digratoCapsulas());
					solucion.addAll(CorteIngles.krupsCapsulas());
					return (ObservableList<Cafetera>) solucion;	
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}else if(tipo == "goteo"){
				
				if(marcas == "bosch") {
					solucion.addAll(CorteIngles.boschGoteo());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiGoteo());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "mondial") {
					solucion.addAll(CorteIngles.mondialGoteo());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "rushell") {
					solucion.addAll(CorteIngles.rushellGoteo());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "saivod") {
					solucion.addAll(CorteIngles.saivodGoteo());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "severin") {
					solucion.addAll(CorteIngles.severinGoteo());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "taurus") {
					solucion.addAll(CorteIngles.taurusGoteo());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "ufesa") {
					solucion.addAll(CorteIngles.ufesaGoteo());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas ==" ") {
					solucion.addAll(CorteIngles.boschGoteo());
					solucion.addAll(CorteIngles.deLonghiGoteo());
					solucion.addAll(CorteIngles.mondialGoteo());
					solucion.addAll(CorteIngles.rushellGoteo());
					solucion.addAll(CorteIngles.saivodGoteo());
					solucion.addAll(CorteIngles.severinGoteo());
					solucion.addAll(CorteIngles.taurusGoteo());
					solucion.addAll(CorteIngles.ufesaGoteo());
					return (ObservableList<Cafetera>) solucion;	
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}else if(tipo == "superautomaticas") {
				
				if(marcas == "bosch") {
					solucion.addAll(CorteIngles.boschSuper());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiSuper());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "jura") {
					solucion.addAll(CorteIngles.juraSuper());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "krups") {
					solucion.addAll(CorteIngles.krupsSuper());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "miele") {
					solucion.addAll(CorteIngles.mieleSuper());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "philips") {
					solucion.addAll(CorteIngles.philipsSuper());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "saeco") {
					solucion.addAll(CorteIngles.saecoSuper());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas ==" ") {
					solucion.addAll(CorteIngles.boschSuper());
					solucion.addAll(CorteIngles.deLonghiSuper());
					solucion.addAll(CorteIngles.juraSuper());
					solucion.addAll(CorteIngles.krupsSuper());
					solucion.addAll(CorteIngles.mieleSuper());
					solucion.addAll(CorteIngles.philipsSuper());
					solucion.addAll(CorteIngles.saecoSuper());
					return (ObservableList<Cafetera>) solucion;	
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}else if(tipo == "expresso") {
				
				if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiManual());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "saivod") {
					solucion.addAll(CorteIngles.saivodManual());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "saeco") {
					solucion.addAll(CorteIngles.saecoManual());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "oster") {
					solucion.addAll(CorteIngles.osterManual());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "smeg") {
					solucion.addAll(CorteIngles.smegManual());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "solac") {
					solucion.addAll(CorteIngles.solacManual());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "ufesa") {
					solucion.addAll(CorteIngles.ufesaManual());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas ==" ") {
					solucion.addAll(CorteIngles.deLonghiManual());
					solucion.addAll(CorteIngles.saivodManual());
					solucion.addAll(CorteIngles.saecoManual());
					solucion.addAll(CorteIngles.osterManual());
					solucion.addAll(CorteIngles.smegManual());
					solucion.addAll(CorteIngles.solacManual());
					solucion.addAll(CorteIngles.ufesaManual());
					return (ObservableList<Cafetera>) solucion;	
					
				}else {return (ObservableList<Cafetera>) solucion;}
			}else if(tipo == "italianas") {
				
				if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiItalianaElectrica());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas ==" ") {
					solucion.addAll(CorteIngles.deLonghiItalianaElectrica());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
			}else {
				if(marcas == "bosch") {
					solucion.addAll(CorteIngles.boschCapsulas());					
					solucion.addAll(CorteIngles.boschGoteo());
					solucion.addAll(CorteIngles.boschSuper());					
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiGoteo());					
					solucion.addAll(CorteIngles.deLonghiCapsulas());
					solucion.addAll(CorteIngles.deLonghiItalianaElectrica());
					solucion.addAll(CorteIngles.deLonghiManual());
					solucion.addAll(CorteIngles.deLonghiSuper());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "digrato") {
					solucion.addAll(CorteIngles.digratoCapsulas());					
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "krups") {
					solucion.addAll(CorteIngles.krupsSuper());					
					solucion.addAll(CorteIngles.krupsCapsulas());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "mondial") {
					solucion.addAll(CorteIngles.mondialGoteo());					
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "rushell") {
					solucion.addAll(CorteIngles.rushellGoteo());										
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "saivod") {
					solucion.addAll(CorteIngles.saivodElectrica());					
					solucion.addAll(CorteIngles.saivodGoteo());
					solucion.addAll(CorteIngles.saivodManual());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "severin") {
					solucion.addAll(CorteIngles.severinGoteo());										
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "taurus") {
					solucion.addAll(CorteIngles.taurusGoteo());					
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "ufesa") {
					solucion.addAll(CorteIngles.ufesaGoteo());					
					solucion.addAll(CorteIngles.ufesaManual());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "philips") {
					solucion.addAll(CorteIngles.philipsSuper());					
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "saeco") {
					solucion.addAll(CorteIngles.saecoManual());					
					solucion.addAll(CorteIngles.saecoSuper());
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "oster") {
					solucion.addAll(CorteIngles.osterManual());					
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "smeg") {
					solucion.addAll(CorteIngles.smegManual());					
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "solac") {
					solucion.addAll(CorteIngles.solacManual());					
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas == "jura") {
					solucion.addAll(CorteIngles.juraSuper());					
					return (ObservableList<Cafetera>) solucion;	
					
				}else if(marcas ==" ") {
					solucion.addAll(CorteIngles.boschCapsulas());					
					solucion.addAll(CorteIngles.deLonghiCapsulas());
					solucion.addAll(CorteIngles.digratoCapsulas());
					solucion.addAll(CorteIngles.krupsCapsulas());
					solucion.addAll(CorteIngles.boschGoteo());
					solucion.addAll(CorteIngles.deLonghiGoteo());
					solucion.addAll(CorteIngles.mondialGoteo());
					solucion.addAll(CorteIngles.rushellGoteo());
					solucion.addAll(CorteIngles.saivodGoteo());
					solucion.addAll(CorteIngles.severinGoteo());
					solucion.addAll(CorteIngles.taurusGoteo());
					solucion.addAll(CorteIngles.ufesaGoteo());					
					solucion.addAll(CorteIngles.boschSuper());
					solucion.addAll(CorteIngles.deLonghiSuper());
					solucion.addAll(CorteIngles.juraSuper());
					solucion.addAll(CorteIngles.krupsSuper());
					solucion.addAll(CorteIngles.mieleSuper());
					solucion.addAll(CorteIngles.philipsSuper());
					solucion.addAll(CorteIngles.saecoSuper());
					solucion.addAll(CorteIngles.deLonghiManual());
					solucion.addAll(CorteIngles.saivodManual());
					solucion.addAll(CorteIngles.saecoManual());
					solucion.addAll(CorteIngles.osterManual());
					solucion.addAll(CorteIngles.smegManual());
					solucion.addAll(CorteIngles.solacManual());
					solucion.addAll(CorteIngles.ufesaManual());
					solucion.addAll(CorteIngles.deLonghiItalianaElectrica());
					return (ObservableList<Cafetera>) solucion;	
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}
				
		}else {
			if(tipo == "capsulas"){
				
				if(marcas == "bosch") {
					solucion.addAll(CorteIngles.boschCapsulas());
					solucion.addAll(MediaMarkt.boschMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiCapsulas());
					solucion.addAll(MediaMarkt.deLonghiMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "digrato") {
					solucion.addAll(CorteIngles.digratoCapsulas());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "krups") {
					solucion.addAll(CorteIngles.krupsCapsulas());
					solucion.addAll(MediaMarkt.krupsMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "philips") {
					solucion.addAll(MediaMarkt.philipsMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "tassimo") {
					solucion.addAll(MediaMarkt.tassimoMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas ==" ") {
					solucion.addAll(CorteIngles.boschCapsulas());
					solucion.addAll(MediaMarkt.boschMono());
					solucion.addAll(CorteIngles.deLonghiCapsulas());
					solucion.addAll(MediaMarkt.deLonghiMono());
					solucion.addAll(CorteIngles.digratoCapsulas());
					solucion.addAll(CorteIngles.krupsCapsulas());
					solucion.addAll(MediaMarkt.krupsMono());
					solucion.addAll(CorteIngles.krupsCapsulas());
					solucion.addAll(MediaMarkt.krupsMono());
					solucion.addAll(MediaMarkt.philipsMono());
					solucion.addAll(MediaMarkt.tassimoMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
			}else if(tipo == "goteo"){
				
				if(marcas == "bosch") {
					solucion.addAll(CorteIngles.boschGoteo());
					solucion.addAll(MediaMarkt.boschGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiGoteo());
					solucion.addAll(MediaMarkt.deLonghiGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "mondial") {
					solucion.addAll(CorteIngles.mondialGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "rushell") {
					solucion.addAll(CorteIngles.boschGoteo());
					solucion.addAll(MediaMarkt.boschGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "saivod") {
					solucion.addAll(CorteIngles.saivodGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "severin") {
					solucion.addAll(CorteIngles.severinGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "taurus") {
					solucion.addAll(CorteIngles.taurusGoteo());
					solucion.addAll(MediaMarkt.taurusGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "ufesa") {
					solucion.addAll(CorteIngles.ufesaGoteo());
					solucion.addAll(MediaMarkt.ufesaGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "philips") {
					solucion.addAll(MediaMarkt.philipsGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "jata") {
					solucion.addAll(MediaMarkt.jataGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "moulinex") {
					solucion.addAll(MediaMarkt.moulinexGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "ok") {
					solucion.addAll(MediaMarkt.okGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "electrolux") {
					solucion.addAll(MediaMarkt.electroGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "wmf") {
					solucion.addAll(MediaMarkt.wmfGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "tristar") {
					solucion.addAll(MediaMarkt.tristarGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas ==" ") {
					solucion.addAll(CorteIngles.boschGoteo());
					solucion.addAll(MediaMarkt.boschGoteo());
					solucion.addAll(CorteIngles.deLonghiGoteo());
					solucion.addAll(MediaMarkt.deLonghiGoteo());
					solucion.addAll(CorteIngles.mondialGoteo());
					solucion.addAll(CorteIngles.boschGoteo());
					solucion.addAll(MediaMarkt.boschGoteo());
					solucion.addAll(CorteIngles.saivodGoteo());
					solucion.addAll(CorteIngles.severinGoteo());
					solucion.addAll(CorteIngles.taurusGoteo());
					solucion.addAll(MediaMarkt.taurusGoteo());
					solucion.addAll(CorteIngles.ufesaGoteo());
					solucion.addAll(MediaMarkt.ufesaGoteo());
					solucion.addAll(MediaMarkt.philipsGoteo());
					solucion.addAll(MediaMarkt.jataGoteo());
					solucion.addAll(MediaMarkt.okGoteo());
					solucion.addAll(MediaMarkt.moulinexGoteo());
					solucion.addAll(MediaMarkt.electroGoteo());
					solucion.addAll(MediaMarkt.wmfGoteo());
					solucion.addAll(MediaMarkt.tristarGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}else if(tipo == "superautomaticas") {
				
				if(marcas == "bosch") {
					solucion.addAll(CorteIngles.boschSuper());
					solucion.addAll(MediaMarkt.boschSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiSuper());
					solucion.addAll(MediaMarkt.deLonghiSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "jura") {
					solucion.addAll(CorteIngles.juraSuper());
					solucion.addAll(MediaMarkt.juraSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "krups") {
					solucion.addAll(CorteIngles.krupsSuper());
					solucion.addAll(MediaMarkt.krupsSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "miele") {
					solucion.addAll(CorteIngles.mieleSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "philips") {
					solucion.addAll(CorteIngles.philipsSuper());
					solucion.addAll(MediaMarkt.philipsSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "saeco") {
					solucion.addAll(CorteIngles.saecoSuper());
					solucion.addAll(MediaMarkt.saecoSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas ==" ") {
					solucion.addAll(CorteIngles.boschSuper());
					solucion.addAll(MediaMarkt.boschSuper());
					solucion.addAll(CorteIngles.deLonghiSuper());
					solucion.addAll(MediaMarkt.deLonghiSuper());
					solucion.addAll(CorteIngles.juraSuper());
					solucion.addAll(MediaMarkt.juraSuper());
					solucion.addAll(CorteIngles.krupsSuper());
					solucion.addAll(MediaMarkt.krupsSuper());
					solucion.addAll(CorteIngles.mieleSuper());
					solucion.addAll(CorteIngles.philipsSuper());
					solucion.addAll(MediaMarkt.philipsSuper());
					solucion.addAll(CorteIngles.saecoSuper());
					solucion.addAll(MediaMarkt.saecoSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
			}else if(tipo == "expresso") {
				
				if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiManual());
					solucion.addAll(MediaMarkt.deLonghiExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "krups") {
					solucion.addAll(MediaMarkt.krupsExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "saivod") {
					solucion.addAll(CorteIngles.saivodManual());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "ufesa") {
					solucion.addAll(CorteIngles.ufesaManual());
					solucion.addAll(MediaMarkt.ufesaExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "saeco") {
					solucion.addAll(CorteIngles.saecoManual());
					solucion.addAll(MediaMarkt.saecoExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "oster") {
					solucion.addAll(CorteIngles.osterManual());
					solucion.addAll(MediaMarkt.osterExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "smeg") {
					solucion.addAll(CorteIngles.smegManual());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "solac") {
					solucion.addAll(CorteIngles.solacManual());
					solucion.addAll(MediaMarkt.solacExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "jata") {
					solucion.addAll(MediaMarkt.jataExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "orbegozo") {
					solucion.addAll(MediaMarkt.orbegozoExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "whirlpool") {
					solucion.addAll(MediaMarkt.whirlpoolExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "illi") {
					solucion.addAll(MediaMarkt.illiExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas ==" ") {
					solucion.addAll(CorteIngles.deLonghiManual());
					solucion.addAll(MediaMarkt.deLonghiExpress());
					solucion.addAll(MediaMarkt.krupsExpress());
					solucion.addAll(CorteIngles.saivodManual());
					solucion.addAll(CorteIngles.ufesaManual());
					solucion.addAll(MediaMarkt.ufesaExpress());
					solucion.addAll(CorteIngles.saecoManual());
					solucion.addAll(MediaMarkt.saecoExpress());
					solucion.addAll(CorteIngles.osterManual());
					solucion.addAll(MediaMarkt.osterExpress());
					solucion.addAll(CorteIngles.smegManual());
					solucion.addAll(CorteIngles.solacManual());
					solucion.addAll(MediaMarkt.solacExpress());
					solucion.addAll(MediaMarkt.jataExpress());
					solucion.addAll(MediaMarkt.orbegozoExpress());
					solucion.addAll(MediaMarkt.whirlpoolExpress());
					solucion.addAll(MediaMarkt.illiExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
			}else if(tipo == "italianas") {
				
				if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiItalianaElectrica());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "taurus") {
					solucion.addAll(MediaMarkt.taurusTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "jata") {
					solucion.addAll(MediaMarkt.jataTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas =="menz&konecke") {
					solucion.addAll(MediaMarkt.menzTradicional());
					return (ObservableList<Cafetera>) solucion;
				}else if(marcas == " ") {
					solucion.addAll(CorteIngles.deLonghiItalianaElectrica());
					solucion.addAll(MediaMarkt.taurusTradicional());
					solucion.addAll(MediaMarkt.jataTradicional());
					solucion.addAll(MediaMarkt.menzTradicional());
					return (ObservableList<Cafetera>) solucion;
				}else {
					return (ObservableList<Cafetera>) solucion;
					
					
				}
			}else {
				if(marcas == "bosch") {
					solucion.addAll(CorteIngles.boschCapsulas());
					solucion.addAll(CorteIngles.boschGoteo());
					solucion.addAll(CorteIngles.boschSuper());
					solucion.addAll(MediaMarkt.boschGoteo());
					solucion.addAll(MediaMarkt.boschMono());
					solucion.addAll(MediaMarkt.boschSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "deLonghi") {
					solucion.addAll(CorteIngles.deLonghiCapsulas());
					solucion.addAll(CorteIngles.deLonghiGoteo());
					solucion.addAll(CorteIngles.deLonghiItalianaElectrica());
					solucion.addAll(CorteIngles.deLonghiManual());
					solucion.addAll(CorteIngles.deLonghiSuper());
					solucion.addAll(MediaMarkt.deLonghiExpress());
					solucion.addAll(MediaMarkt.deLonghiGoteo());
					solucion.addAll(MediaMarkt.deLonghiMono());
					solucion.addAll(MediaMarkt.deLonghiSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "digrato") {
					solucion.addAll(CorteIngles.digratoCapsulas());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "krups") {
					solucion.addAll(CorteIngles.krupsCapsulas());
					solucion.addAll(CorteIngles.krupsSuper());
					solucion.addAll(MediaMarkt.krupsExpress());
					solucion.addAll(MediaMarkt.krupsMono());
					solucion.addAll(MediaMarkt.krupsSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "mondial") {
					solucion.addAll(CorteIngles.mondialGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "rushell") {
					solucion.addAll(CorteIngles.rushellGoteo());
					solucion.addAll(MediaMarkt.rushellGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "saivod") {
					solucion.addAll(CorteIngles.saivodElectrica());
					solucion.addAll(CorteIngles.saivodGoteo());
					solucion.addAll(CorteIngles.saivodManual());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "severin") {
					solucion.addAll(CorteIngles.severinGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "taurus") {
					solucion.addAll(CorteIngles.taurusGoteo());
					solucion.addAll(MediaMarkt.taurusGoteo());
					solucion.addAll(MediaMarkt.taurusTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "ufesa") {
					solucion.addAll(CorteIngles.ufesaGoteo());
					solucion.addAll(CorteIngles.ufesaManual());
					solucion.addAll(MediaMarkt.ufesaExpress());
					solucion.addAll(MediaMarkt.ufesaGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "philips") {
					solucion.addAll(CorteIngles.philipsSuper());
					solucion.addAll(MediaMarkt.philipsGoteo());
					solucion.addAll(MediaMarkt.philipsMono());
					solucion.addAll(MediaMarkt.philipsSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "saeco") {
					solucion.addAll(CorteIngles.saecoManual());
					solucion.addAll(CorteIngles.saecoSuper());
					solucion.addAll(MediaMarkt.saecoExpress());
					solucion.addAll(MediaMarkt.saecoSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "oster") {
					solucion.addAll(CorteIngles.osterManual());
					solucion.addAll(MediaMarkt.osterExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "smeg") {
					solucion.addAll(CorteIngles.smegManual());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "solac") {
					solucion.addAll(CorteIngles.solacManual());
					solucion.addAll(MediaMarkt.solacExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "tassimo") {
					solucion.addAll(MediaMarkt.tassimoMono());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "jata") {
					solucion.addAll(MediaMarkt.jataExpress());
					solucion.addAll(MediaMarkt.jataGoteo());
					solucion.addAll(MediaMarkt.jataTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "orbegozo") {
					solucion.addAll(MediaMarkt.orbegozoExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "whirlpool") {
					solucion.addAll(MediaMarkt.whirlpoolExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "illi") {
					solucion.addAll(MediaMarkt.illiExpress());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "moulinex") {
					solucion.addAll(MediaMarkt.moulinexGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "ok") {
					solucion.addAll(MediaMarkt.okGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "electrolux") {
					solucion.addAll(MediaMarkt.electroGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "wmf") {
					solucion.addAll(MediaMarkt.wmfGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "tristar") {
					solucion.addAll(MediaMarkt.tristarGoteo());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "menz&konecke") {
					solucion.addAll(MediaMarkt.menzTradicional());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "miele") {
					solucion.addAll(CorteIngles.mieleSuper());
					return (ObservableList<Cafetera>) solucion;
					
				}else if(marcas == "jura") {
					solucion.addAll(CorteIngles.juraSuper());
					solucion.addAll(MediaMarkt.juraSuper());
					return (ObservableList<Cafetera>) solucion;
				}else if(marcas == " ") {
					solucion.addAll(CorteIngles.boschCapsulas());
					solucion.addAll(CorteIngles.boschGoteo());
					solucion.addAll(CorteIngles.boschSuper());
					solucion.addAll(MediaMarkt.boschGoteo());
					solucion.addAll(MediaMarkt.boschMono());
					solucion.addAll(MediaMarkt.boschSuper());
					solucion.addAll(CorteIngles.deLonghiCapsulas());
					solucion.addAll(CorteIngles.deLonghiGoteo());
					solucion.addAll(CorteIngles.deLonghiItalianaElectrica());
					solucion.addAll(CorteIngles.deLonghiManual());
					solucion.addAll(CorteIngles.deLonghiSuper());
					solucion.addAll(MediaMarkt.deLonghiExpress());
					solucion.addAll(MediaMarkt.deLonghiGoteo());
					solucion.addAll(MediaMarkt.deLonghiMono());
					solucion.addAll(MediaMarkt.deLonghiSuper());
					solucion.addAll(CorteIngles.krupsCapsulas());
					solucion.addAll(CorteIngles.krupsSuper());
					solucion.addAll(MediaMarkt.krupsExpress());
					solucion.addAll(MediaMarkt.krupsMono());
					solucion.addAll(MediaMarkt.krupsSuper());
					solucion.addAll(CorteIngles.mondialGoteo());
					solucion.addAll(CorteIngles.rushellGoteo());
					solucion.addAll(MediaMarkt.rushellGoteo());
					solucion.addAll(CorteIngles.saivodElectrica());
					solucion.addAll(CorteIngles.saivodGoteo());
					solucion.addAll(CorteIngles.saivodManual());
					solucion.addAll(CorteIngles.severinGoteo());
					solucion.addAll(CorteIngles.severinGoteo());
					solucion.addAll(CorteIngles.taurusGoteo());
					solucion.addAll(MediaMarkt.taurusGoteo());
					solucion.addAll(MediaMarkt.taurusTradicional());
					solucion.addAll(CorteIngles.ufesaGoteo());
					solucion.addAll(CorteIngles.ufesaManual());
					solucion.addAll(MediaMarkt.ufesaExpress());
					solucion.addAll(MediaMarkt.ufesaGoteo());
					solucion.addAll(CorteIngles.philipsSuper());
					solucion.addAll(MediaMarkt.philipsGoteo());
					solucion.addAll(MediaMarkt.philipsMono());
					solucion.addAll(MediaMarkt.philipsSuper());
					solucion.addAll(CorteIngles.saecoManual());
					solucion.addAll(CorteIngles.saecoSuper());
					solucion.addAll(MediaMarkt.saecoExpress());
					solucion.addAll(MediaMarkt.saecoSuper());
					solucion.addAll(CorteIngles.osterManual());
					solucion.addAll(MediaMarkt.osterExpress());
					solucion.addAll(CorteIngles.smegManual());
					solucion.addAll(CorteIngles.solacManual());
					solucion.addAll(MediaMarkt.solacExpress());
					solucion.addAll(MediaMarkt.tassimoMono());
					solucion.addAll(MediaMarkt.tassimoMono());
					solucion.addAll(MediaMarkt.jataExpress());
					solucion.addAll(MediaMarkt.jataGoteo());
					solucion.addAll(MediaMarkt.jataTradicional());
					solucion.addAll(MediaMarkt.orbegozoExpress());
					solucion.addAll(MediaMarkt.whirlpoolExpress());
					solucion.addAll(MediaMarkt.illiExpress());
					solucion.addAll(MediaMarkt.moulinexGoteo());
					solucion.addAll(MediaMarkt.okGoteo());
					solucion.addAll(MediaMarkt.electroGoteo());
					solucion.addAll(MediaMarkt.wmfGoteo());
					solucion.addAll(MediaMarkt.tristarGoteo());
					solucion.addAll(MediaMarkt.menzTradicional());
					solucion.addAll(CorteIngles.mieleSuper());
					solucion.addAll(CorteIngles.juraSuper());
					solucion.addAll(MediaMarkt.juraSuper());				
					return (ObservableList<Cafetera>) solucion;
					
				}else {return (ObservableList<Cafetera>) solucion;}
				
			}	
				
		}
		
		
	}
	
}
