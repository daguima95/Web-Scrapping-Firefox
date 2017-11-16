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
		
		//---------------LLEGAR A CAFETERAS----------//
		ArrayList<Cafetera> cafeterasCapsulasBoschCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasBoschNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasCapsulasBoschPreCI = new ArrayList<WebElement>();
		cafeterasCapsulasBoschNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		
		for(int a = 0; a<cafeterasCapsulasBoschNomCI.size(); a++){
			Cafetera cafetera = new Cafetera(cafeterasCapsulasBoschNomCI.get(a).getAttribute("title"), null);
			
			cafeterasCapsulasBoschCI.add(cafetera);
		}
		//BORRAR LOS PRINT
		for(WebElement c : cafeterasCapsulasBoschNomCI){
			System.out.println("Cafeteras Capsulas Bosch CI :" + c.getAttribute("title"));
		}
		System.out.println("ResultadosCapsulasBoschCI " + cafeterasCapsulasBoschNomCI.size());
		//----------
		
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();	
		((JavascriptExecutor) controlador).executeScript("arguments[0].scrollIntoView();",controlador.findElement(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")));
		((JavascriptExecutor) controlador).executeScript("window.scrollBy(0,-200)");
		WebDriverWait waitingScroll = new WebDriverWait(controlador, 20);
		waitingScroll.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)") ) );			
		ArrayList<WebElement> cafeterasCapsulasDeLonghiCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		for(int j = 0; j<4; j++){
			cafeterasCapsulasDeLonghiCI.remove(cafeterasCapsulasDeLonghiCI.size()-1);
		}
		//BORRAR LOS PRINT
				for(WebElement c : cafeterasCapsulasDeLonghiCI){
					System.out.println("Cafeteras Capsulas Aux CI :" + c.getAttribute("title"));
				}
				System.out.println("ResultadosCapsulasAuxCI " + cafeterasCapsulasDeLonghiCI.size());
				//----------
				
		System.out.println("OK1");
		WebDriverWait waitingSiguiente = new WebDriverWait(controlador, 20);
		System.out.println("OK2");
		waitingSiguiente.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)") ) );	
		System.out.println("OK3");
		controlador.findElement(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")).click();
		System.out.println("OK4");
		ArrayList<WebElement> cafeterasCapsulasAuxCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		for(WebElement c : cafeterasCapsulasAuxCI){
			WebElement aux = c;
			cafeterasCapsulasDeLonghiCI.add(aux);			
		}
		System.out.println("OK5");
		System.out.println("OK6");		
		System.out.println("ResultadosCapsulasDeLonghiCI " + cafeterasCapsulasDeLonghiCI.size());
		//----------
		/*do{	
			((JavascriptExecutor) controlador).executeScript("arguments[0].scrollIntoView();",controlador.findElement(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")));
			((JavascriptExecutor) controlador).executeScript("window.scrollBy(0,-200)");
			ArrayList<WebElement> cafeterasCapsulasAux = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
			for(int i = 0; i<4; i++){
				cafeterasCapsulasAux.remove(cafeterasCapsulasAux.size()-1);
			}
			for(WebElement c : cafeterasCapsulasAux){
				System.out.println(c.getText());
			}
			System.out.println("Resultados " + cafeterasCapsulasAux.size());
			cafeterasCapsulas.addAll(cafeterasCapsulasAux);			
			controlador.findElement(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")).click();
		}while(controlador.findElement(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")).isEnabled() != false);
		*/
				
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
}
