package application;
	
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		Firefox();
		//launch(args);
		
	}
	public static void Firefox(){
		//---------------INICIAR FIREFOX----------//
		String exe = "*\\geckodriver.exe";
		System.setProperty("webdriver.firefox.marionette", exe);
		DesiredCapabilities capacidad = DesiredCapabilities.firefox();
		capacidad.setCapability("marionette", true);
		@SuppressWarnings("deprecation")
		WebDriver controlador = new FirefoxDriver(capacidad);	
		controlador.get("https://www.elcorteingles.es/");		
		controlador.manage().window().maximize();
		WebDriverWait waitingCookiesCI = new WebDriverWait(controlador, 20);		
		waitingCookiesCI.until(ExpectedConditions.presenceOfElementLocated(By.id("cookies-policy-close") ) );
		controlador.findElement(By.id("cookies-policy-close")).click();
		String buscador = "cafeteras" + '\n';
		WebElement cajaBusqueda = controlador.findElement(By.id("search-box"));
		cajaBusqueda.sendKeys(buscador);
		controlador.findElement(By.className("facet-popup")).click();
		WebDriverWait waitingCafeterasCI = new WebDriverWait(controlador, 20);		
		waitingCafeterasCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(2) > li:nth-child(2) > a:nth-child(2)") ) );
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
		WebDriverWait waitingCafetrasCapsulasCI = new WebDriverWait(controlador, 20);		
		waitingCafetrasCapsulasCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)") ) );
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
		WebDriverWait waitingBoschCI = new WebDriverWait(controlador, 20);		
		waitingBoschCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > a:nth-child(2)") ) );
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		
		//---------------BOSCH CAPSULAS----------//
		
		ArrayList<Cafetera> cafeterasCapsulasBoschCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasBoschNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasCapsulasBoschPreCI = new ArrayList<WebElement>();
		cafeterasCapsulasBoschNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasCapsulasBoschPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasCapsulasBoschNomCI);
		//borrarInecesarios(cafeterasCapsulasBoschPreCI);
		cafeterasCapsulasBoschPreCI.remove(1);
		cafeterasCapsulasBoschCI = llenarLista(cafeterasCapsulasBoschNomCI, cafeterasCapsulasBoschPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasBoschCI);
		//----------
		
		//---------------DELONGHI CAPSULAS----------//
		
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();	
		((JavascriptExecutor) controlador).executeScript("arguments[0].scrollIntoView();",controlador.findElement(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")));
		((JavascriptExecutor) controlador).executeScript("window.scrollBy(0,-200)");
		WebDriverWait waitingScroll = new WebDriverWait(controlador, 20);
		waitingScroll.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)") ) );
		ArrayList<Cafetera> cafeterasCapsulasDeLonghiCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasDeLonghiNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		ArrayList<WebElement> cafeterasCapsulasDeLonghiPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		//borrarInecesarios(cafeterasCapsulasDeLonghiNomCI);
		//borrarInecesarios(cafeterasCapsulasDeLonghiPreCI);
		cafeterasCapsulasDeLonghiCI = llenarLista(cafeterasCapsulasDeLonghiNomCI, cafeterasCapsulasDeLonghiPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasDeLonghiCI);
		//----------
				
		WebDriverWait waitingSiguiente = new WebDriverWait(controlador, 20);
		waitingSiguiente.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)") ) );	
		controlador.findElement(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")).click();
		ArrayList<Cafetera> cafeterasCapsulasDeLonghi2CI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasDeLonghiNom2CI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		ArrayList<WebElement> cafeterasCapsulasDeLonghiPre2CI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasCapsulasDeLonghiNom2CI);
		//borrarInecesarios(cafeterasCapsulasDeLonghiPre2CI);
		cafeterasCapsulasDeLonghi2CI = llenarLista(cafeterasCapsulasDeLonghiNom2CI, cafeterasCapsulasDeLonghiPre2CI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasDeLonghi2CI);
		//----------
		cafeterasCapsulasDeLonghiCI.addAll(cafeterasCapsulasDeLonghi2CI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasDeLonghiCI);
		//----------
		
		//---------------DIGRATO CAPSULAS----------//
		controlador.findElement(By.cssSelector("a.selected")).click();
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasCapsulasDigratoCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasDigratoNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasCapsulasDigratoPreCI = new ArrayList<WebElement>();
		cafeterasCapsulasDigratoNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasCapsulasDigratoPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasCapsulasDigratoNomCI);
		//borrarInecesarios(cafeterasCapsulasDigratoPreCI);
		cafeterasCapsulasDigratoCI = llenarLista(cafeterasCapsulasDigratoNomCI, cafeterasCapsulasDigratoPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasDigratoCI);
		//----------
		
		//---------------KRUPS CAPSULAS----------//
		controlador.findElement(By.cssSelector("a.selected")).click();
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasCapsulasKrupsCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasKrupsNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasCapsulasKrupsPreCI = new ArrayList<WebElement>();
		cafeterasCapsulasKrupsNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasCapsulasKrupsPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasCapsulasKrupsNomCI);
		//borrarInecesarios(cafeterasCapsulasKrupsPreCI);
		cafeterasCapsulasKrupsCI = llenarLista(cafeterasCapsulasKrupsNomCI, cafeterasCapsulasKrupsPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasKrupsCI);
		//----------
		
		
				
		/*@SuppressWarnings("deprecation")
		WebDriver controlador2 = new FirefoxDriver(capacidad);
		controlador2.get("https://www.mediamarkt.es/");
		controlador2.manage().window().maximize();
		WebDriverWait waitingCookiesMM = new WebDriverWait(controlador2, 10);
		waitingCookiesMM.until(ExpectedConditions.presenceOfElementLocated(By.id("close-cookies-law")));
		controlador2.findElement(By.id("close-cookies-law")).click();
		WebElement cajaBusquedaMM = controlador2.findElement(By.name("query"));
		cajaBusquedaMM.click();
		cajaBusquedaMM.sendKeys(buscador);*/
		
		
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
	public static void printRes(ArrayList<Cafetera> listaElementos){
		for(Cafetera c : listaElementos){
			System.out.println("Cafeteras :" + c.getNombre() + " " + c.getPrecio());
		}
		System.out.println("ResultadosCapsulasCI " + listaElementos.size());
	}
	public static void printResNom(ArrayList<WebElement> listaElementos){
		for(WebElement c : listaElementos){
			System.out.println("Nombre :" + c.getAttribute("title"));
		}
		System.out.println("ResultadosCapsulasCI " + listaElementos.size());
		
	}
	public static void printResPre(ArrayList<WebElement> listaElementos){
		for(WebElement c : listaElementos){
			System.out.println("Precio :" + c.getText());
		}
		System.out.println("ResultadosCapsulasCI " + listaElementos.size());
		
	}
}
