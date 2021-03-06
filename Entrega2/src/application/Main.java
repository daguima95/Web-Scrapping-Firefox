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
		//FirefoxCI();
		try {
			FirefoxMM();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		//launch(args);
		
	}
	public static void FirefoxCI(){
		//---------------INICIAR FIREFOX----------//
		String exe = "*\\geckodriver.exe";
		System.setProperty("webdriver.firefox.marionette", exe);
		DesiredCapabilities capacidad = DesiredCapabilities.firefox();
		capacidad.setCapability("marionette", true);
		@SuppressWarnings("deprecation")
		WebDriver controlador = new FirefoxDriver(capacidad);	
		controlador.get("https://www.elcorteingles.es/");		
		controlador.manage().window().maximize();
		WebDriverWait waitCookie = new WebDriverWait(controlador, 20);
		waitCookie.until(ExpectedConditions.presenceOfElementLocated(By.id("cookies-policy-close")));
		controlador.findElement(By.id("cookies-policy-close")).click();
		String buscador = "cafeteras" + '\n';
		WebElement cajaBusqueda = controlador.findElement(By.id("search-box"));
		cajaBusqueda.sendKeys(buscador);
		controlador.findElement(By.className("facet-popup")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		
		//---------------BOSCH CAPSULAS----------//
		
		ArrayList<Cafetera> cafeterasCapsulasBoschCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasBoschNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasCapsulasBoschPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasCapsulasBoschNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasCapsulasBoschPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasCapsulasBoschNomCI);
		borrarInecesarios(cafeterasCapsulasBoschPreCI);
		cafeterasCapsulasBoschPreCI.remove(3);
		cafeterasCapsulasBoschCI = llenarLista(cafeterasCapsulasBoschNomCI, cafeterasCapsulasBoschPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasBoschCI);
		//----------
		
		//---------------DELONGHI CAPSULAS----------//
		
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();	
		ArrayList<Cafetera> cafeterasCapsulasDeLonghiCI = new ArrayList<Cafetera>();
		waitForPageLoad(controlador);
		ArrayList<WebElement> cafeterasCapsulasDeLonghiNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		ArrayList<WebElement> cafeterasCapsulasDeLonghiPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		borrarInecesarios(cafeterasCapsulasDeLonghiNomCI);
		borrarInecesarios(cafeterasCapsulasDeLonghiPreCI);
		cafeterasCapsulasDeLonghiCI = llenarLista(cafeterasCapsulasDeLonghiNomCI, cafeterasCapsulasDeLonghiPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasDeLonghiCI);
		//----------
				
		
		//---------------DIGRATO CAPSULAS----------//
		controlador.findElement(By.cssSelector("a.selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasCapsulasDigratoCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasDigratoNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasCapsulasDigratoPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasCapsulasDigratoNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasCapsulasDigratoPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasCapsulasDigratoNomCI);
		borrarInecesarios(cafeterasCapsulasDigratoPreCI);
		cafeterasCapsulasDigratoCI = llenarLista(cafeterasCapsulasDigratoNomCI, cafeterasCapsulasDigratoPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasDigratoCI);
		//----------
		
		//---------------KRUPS CAPSULAS----------//
		controlador.findElement(By.cssSelector("a.selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasCapsulasKrupsCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasKrupsNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasCapsulasKrupsPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasCapsulasKrupsNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasCapsulasKrupsPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasCapsulasKrupsNomCI);
		borrarInecesarios(cafeterasCapsulasKrupsPreCI);
		cafeterasCapsulasKrupsCI = llenarLista(cafeterasCapsulasKrupsNomCI, cafeterasCapsulasKrupsPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasKrupsCI);
		//----------
		
		
		//-------CAMBIANDO A GOTEO----------//
		controlador.findElement(By.id("1")).click();
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(2)")).click();
		
		//-------BOSCH GOTEO--------//
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoBoschCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoBoschNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoBoschPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasGoteoBoschNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoBoschPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasGoteoBoschNomCI);
		borrarInecesarios(cafeterasGoteoBoschPreCI);
		cafeterasGoteoBoschCI = llenarLista(cafeterasGoteoBoschNomCI, cafeterasGoteoBoschPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoBoschCI);
		//----------
		
		//-------RUSHELL HOBS GOTEO--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoRushellCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoRushellNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoRushellPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasGoteoRushellNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoRushellPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasGoteoRushellNomCI);
		borrarInecesarios(cafeterasGoteoRushellPreCI);
		cafeterasGoteoRushellCI = llenarLista(cafeterasGoteoRushellNomCI, cafeterasGoteoRushellPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoRushellCI);
		//----------
		
		//-------SAIVOD GOTEO--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		ArrayList<Cafetera> cafeterasGoteoSaivodCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoSaivodNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoSaivodPreCI = new ArrayList<WebElement>();
		cafeterasGoteoSaivodNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoSaivodPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasGoteoSaivodNomCI);
		borrarInecesarios(cafeterasGoteoSaivodPreCI);
		cafeterasGoteoSaivodCI = llenarLista(cafeterasGoteoSaivodNomCI, cafeterasGoteoSaivodPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoSaivodCI);
		//----------
		
		//-------SEVERIN GOTEO--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoSeverinCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoSeverinNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoSeverinPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasGoteoSeverinNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoSeverinPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasGoteoSeverinNomCI);
		borrarInecesarios(cafeterasGoteoSeverinPreCI);
		cafeterasGoteoSeverinCI = llenarLista(cafeterasGoteoSeverinNomCI, cafeterasGoteoSeverinPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoSeverinCI);
		//----------
		
		//-------TAURUS GOTEO--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(5) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoTaurusCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoTaurusNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoTaurusPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasGoteoTaurusNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoTaurusPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasGoteoTaurusNomCI);
		borrarInecesarios(cafeterasGoteoTaurusPreCI);
		cafeterasGoteoTaurusCI = llenarLista(cafeterasGoteoTaurusNomCI, cafeterasGoteoTaurusPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoTaurusCI);
		//----------
		
		//-------UFESA GOTEO--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoUfesaCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoUfesaNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoUfesaPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasGoteoUfesaNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoUfesaPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasGoteoUfesaNomCI);
		borrarInecesarios(cafeterasGoteoUfesaPreCI);
		cafeterasGoteoUfesaCI = llenarLista(cafeterasGoteoUfesaNomCI, cafeterasGoteoUfesaPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoUfesaCI);
		//----------
				
		
		//-------CAMBIANDO A SUPERAUTOMATICAS----------//
		controlador.findElement(By.id("1")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(4)")).click();
		
		
		//-------BOSCH SUPERAUTOMATICAS--------//
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSuperBoschCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSuperBoschNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSuperBoschPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasSuperBoschNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSuperBoschPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasSuperBoschNomCI);
		borrarInecesarios(cafeterasSuperBoschPreCI);
		cafeterasSuperBoschCI = llenarLista(cafeterasSuperBoschNomCI, cafeterasSuperBoschPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSuperBoschCI);
		//----------


		//-------DELONGHI SUPERAUTOMATICAS--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSuperDeLonghiCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSuperDeLonghiNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSuperDeLonghiPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasSuperDeLonghiNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSuperDeLonghiPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasSuperDeLonghiNomCI);
		borrarInecesarios(cafeterasSuperDeLonghiPreCI);
		cafeterasSuperDeLonghiCI = llenarLista(cafeterasSuperDeLonghiNomCI, cafeterasSuperDeLonghiPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSuperDeLonghiCI);
		//----------
		
		//-------JURA SUPERAUTOMATICA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSuperJuraCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSuperJuraNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSuperJuraPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasSuperJuraNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSuperJuraPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		borrarInecesarios(cafeterasSuperJuraNomCI);
		borrarInecesarios(cafeterasSuperJuraPreCI);
		cafeterasSuperJuraCI = llenarLista(cafeterasSuperJuraNomCI, cafeterasSuperJuraPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSuperJuraCI);
		//----------
		
		//-------KRUPS SUPERAUTOMATICA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSuperKrupsCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSuperKrupsNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSuperKrupsPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasSuperKrupsNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSuperKrupsPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasSuperKrupsNomCI);
		borrarInecesarios(cafeterasSuperKrupsPreCI);
		cafeterasSuperKrupsCI = llenarLista(cafeterasSuperKrupsNomCI, cafeterasSuperKrupsPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSuperKrupsCI);
		//----------
		
		//-------MIELE SUPERAUTOMATICA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(5) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSuperMieleCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSuperMieleNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSuperMielePreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasSuperMieleNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSuperMielePreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasSuperMieleNomCI);
		borrarInecesarios(cafeterasSuperMielePreCI);
		cafeterasSuperMieleCI = llenarLista(cafeterasSuperMieleNomCI, cafeterasSuperMielePreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSuperMieleCI);
		//----------
		
		//-------PHILIPS SUPERAUTOMATICA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSuperPhilCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSuperPhilNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSuperPhilPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasSuperPhilNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSuperPhilPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasSuperPhilNomCI);
		borrarInecesarios(cafeterasSuperPhilPreCI);
		cafeterasSuperPhilCI = llenarLista(cafeterasSuperPhilNomCI, cafeterasSuperPhilPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSuperPhilCI);
		//----------
		
		//-------SAECO SUPERAUTOMATICA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(7) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSuperSaecoCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSuperSaecoNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSuperSaecoPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasSuperSaecoNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSuperSaecoPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasSuperSaecoNomCI);
		borrarInecesarios(cafeterasSuperSaecoPreCI);
		cafeterasSuperSaecoCI = llenarLista(cafeterasSuperSaecoNomCI, cafeterasSuperSaecoPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSuperSaecoCI);
		//----------
		
		//-------CAMBIANDO A EXPRESO MANUAL----------//
		controlador.findElement(By.id("1")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(2)")).click();
		
		//-------DELONGHI MANUAL--------//
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasManLonghiCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasManLonghiNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasManLonghiPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasManLonghiNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasManLonghiPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasManLonghiNomCI);
		borrarInecesarios(cafeterasManLonghiPreCI);
		cafeterasManLonghiCI = llenarLista(cafeterasManLonghiNomCI, cafeterasManLonghiPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasManLonghiCI);
		//----------
		
		//-------OSTER MANUAL--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasManOsterCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasManOsterNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasManOsterPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasManOsterNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasManOsterPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasManOsterNomCI);
		borrarInecesarios(cafeterasManOsterPreCI);
		cafeterasManOsterCI = llenarLista(cafeterasManOsterNomCI, cafeterasManOsterPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasManOsterCI);
		//----------
		
		//-------SAECO MANUAL--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasManSaecoCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasManSaecoNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasManSaecoPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasManSaecoNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasManSaecoPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasManSaecoNomCI);
		borrarInecesarios(cafeterasManSaecoPreCI);
		cafeterasManSaecoCI = llenarLista(cafeterasManSaecoNomCI, cafeterasManSaecoPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasManSaecoCI);
		//----------
		
		//-------SAIVOD MANUAL--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasManSaivodCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasManSaivodNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasManSaivodPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasManSaivodNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasManSaivodPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasManSaivodNomCI);
		borrarInecesarios(cafeterasManSaivodPreCI);
		cafeterasManSaivodCI = llenarLista(cafeterasManSaivodNomCI, cafeterasManSaivodPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasManSaivodCI);
		//----------
		
		//-------SMEG MANUAL--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(5) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasManSmegCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasManSmegNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasManSmegPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasManSmegNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasManSmegPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasManSmegNomCI);
		borrarInecesarios(cafeterasManSmegPreCI);
		cafeterasManSmegCI = llenarLista(cafeterasManSmegNomCI, cafeterasManSmegPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasManSmegCI);
		//----------
		
		//-------SOLAC MANUAL--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasManSolacCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasManSolacNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasManSolacPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasManSolacNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasManSolacPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasManSolacNomCI);
		borrarInecesarios(cafeterasManSolacPreCI);
		cafeterasManSolacCI = llenarLista(cafeterasManSolacNomCI, cafeterasManSolacPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasManSolacCI);
		//----------
		
		//-------UFESA MANUAL--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(7) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasManUfesaCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasManUfesaNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasManUfesaPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasManUfesaNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasManUfesaPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasManUfesaNomCI);
		borrarInecesarios(cafeterasManUfesaPreCI);
		cafeterasManUfesaCI = llenarLista(cafeterasManUfesaNomCI, cafeterasManUfesaPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasManUfesaCI);
		//----------
				
		//-------CAMBIANDO A ITALIANAS ELECTRICAS----------//
		controlador.findElement(By.id("1")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(6) > a:nth-child(2)")).click();
		
		//-------DELONGHI ITALIANA--------//
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasLonghiIECI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasLonghiIENomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasLonghiIEPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasLonghiIENomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasLonghiIEPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasLonghiIENomCI);
		borrarInecesarios(cafeterasLonghiIEPreCI);
		cafeterasLonghiIECI = llenarLista(cafeterasLonghiIENomCI, cafeterasLonghiIEPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasLonghiIECI);
		//----------
		
		//-------SAIVOD ITALIANA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSaivodIECI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSaivodIENomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSaivodIEPreCI = new ArrayList<WebElement>();
		waitForPageLoad(controlador);
		cafeterasSaivodIENomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSaivodIEPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		borrarInecesarios(cafeterasManUfesaNomCI);
		borrarInecesarios(cafeterasManUfesaPreCI);
		cafeterasSaivodIECI = llenarLista(cafeterasSaivodIENomCI, cafeterasSaivodIEPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSaivodIECI);
		//----------	
		controlador.quit();
	}
	
	
	
	
	///-------------MEDIA MARKT------------------/////
	
	
	
	public static void FirefoxMM() throws InterruptedException{
		//---------------INICIAR FIREFOX----------//
		String exe = "*\\geckodriver.exe";
		System.setProperty("webdriver.firefox.marionette", exe);
		DesiredCapabilities capacidad = DesiredCapabilities.firefox();
		capacidad.setCapability("marionette", true);
		@SuppressWarnings("deprecation")
		WebDriver controlador2 = new FirefoxDriver(capacidad);
		controlador2.get("https://www.mediamarkt.es/");
		controlador2.manage().window().maximize();
		WebDriverWait waitingCookiesMM = new WebDriverWait(controlador2, 10);
		waitingCookiesMM.until(ExpectedConditions.presenceOfElementLocated(By.id("close-cookies-law")));
		controlador2.findElement(By.id("close-cookies-law")).click();
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#world_hogar-jardin > a:nth-child(1)")).click();
		WebDriverWait waitingCafeMM = new WebDriverWait(controlador2, 10);
		waitingCafeMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#category_hogar-jardin--ctg-cafe > a:nth-child(1)")));
		controlador2.findElement(By.cssSelector("#category_hogar-jardin--ctg-cafe > a:nth-child(1)")).click();
		
		//--------MONODOSIS-------//
		
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.categoryTreeFirst")).click();
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		
		//-----------KRUPS-------//
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();
		System.out.println("Demn Krups1");
		ArrayList<Cafetera> listaKrupMonoMM = new ArrayList<Cafetera>();	
		ArrayList<WebElement> listaNom = new ArrayList<WebElement>();
		ArrayList<WebElement> listaPre = new ArrayList<WebElement>();
		System.out.println("Demn Krups2");
		waitForPageLoad(controlador2);	
		System.out.println("Demn Krups3");
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		System.out.println("Demn Krups5");
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		System.out.println("Demn Krups5");
		waitForPageLoad(controlador2);
		listaKrupMonoMM = llenarListaMM(listaNom, listaPre);
		printRes(listaKrupMonoMM);
		System.out.println("Demn Krups6");
		
		
		//----------DELONGHI------//
		System.out.println("Demn Longhi1");
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();		
		System.out.println("Demn Longhi2");
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)")).click();
		System.out.println("Demn Longhi3");
		ArrayList<Cafetera> listaLonghiMonoMM = new ArrayList<Cafetera>();
		System.out.println("Demn Longhi4");
		waitForPageLoad(controlador2);
		System.out.println("Demn Longhi5");
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		System.out.println("Demn Longhi6");
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));	
		System.out.println("Demn Longhi7");
		waitForPageLoad(controlador2);
		listaLonghiMonoMM = llenarListaMM(listaNom, listaPre);
		System.out.println("Demn Longhi8");
		printRes(listaLonghiMonoMM);
		
		//----------BOSCH------//
		System.out.println("Demn Bosch1");
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)")).click();		
		System.out.println("Demn Bosch2");
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)")).click();
		System.out.println("Demn Bosch3");
		ArrayList<Cafetera> listaBoschMonoMM = new ArrayList<Cafetera>();
		System.out.println("Demn Bosch4");
		waitForPageLoad(controlador2);
		System.out.println("Demn Bosch5");
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		System.out.println("Demn Bosch6");
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));			
		System.out.println("Demn Bosch7");
		waitForPageLoad(controlador2);
		listaBoschMonoMM = llenarListaMM(listaNom, listaPre);
		System.out.println("Demn Bosch8");
		printRes(listaBoschMonoMM);
		
		
		//----------PHILIPS------//
		System.out.println("Demn Phil1");
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)")).click();		
		System.out.println("Demn Phil2");
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)")).click();
		System.out.println("Demn Phil3");
		ArrayList<Cafetera> listaPhilMonoMM = new ArrayList<Cafetera>();
		System.out.println("Demn Phil4");
		waitForPageLoad(controlador2);
		System.out.println("Demn Phil5");
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		System.out.println("Demn Phil6");
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));
		System.out.println("Demn Phil7");
		waitForPageLoad(controlador2);
		System.out.println("Demn Phil8");
		waitForPageLoad(controlador2);
		listaPhilMonoMM = llenarListaMM(listaNom, listaPre);
		System.out.println("Demn Phil9");
		printRes(listaPhilMonoMM);
		
		//----------TASSIMO------//
		waitForPageLoad(controlador2);
		System.out.println("Demn Tas1");
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)")).click();			
		System.out.println("Demn Tas2");
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)")).click();
		System.out.println("Demn Tas3");
		ArrayList<Cafetera> listaTasMonoMM = new ArrayList<Cafetera>();
		System.out.println("Demn Tas4");
		waitForPageLoad(controlador2);
		System.out.println("Demn Tas5");
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		System.out.println("Demn Tas6");
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));	
		System.out.println("Demn Tas7");
		waitForPageLoad(controlador2);;
		listaTasMonoMM = llenarListaMM(listaNom, listaPre);
		System.out.println("Demn Tas8");
		printRes(listaTasMonoMM);
		
		
		//-----------CAMBIANDO CATEGORIA------------//
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.categoryPathReferrer")).click();
		
		//----------SUPERAUTOMATICAS---------------//
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_730 > a:nth-child(1)")).click();
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		
		//----------KRUPS------------//
		
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();
		ArrayList<Cafetera> listaSuperKrupsMM = new ArrayList<Cafetera>();;
		waitForPageLoad(controlador2);
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));	
		waitForPageLoad(controlador2);;
		listaSuperKrupsMM = llenarListaMM(listaNom, listaPre);
		printRes(listaSuperKrupsMM);
		
		//---------SAECO------//
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();		
		waitForPageLoad(controlador2);		
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)")).click();
		ArrayList<Cafetera> listaSuperSaecoMM = new ArrayList<Cafetera>();;
		waitForPageLoad(controlador2);
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));	
		waitForPageLoad(controlador2);;
		listaSuperSaecoMM = llenarListaMM(listaNom, listaPre);
		printRes(listaSuperSaecoMM);
		
		
		//---------DELONGHI---------//
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)")).click();		
		waitForPageLoad(controlador2);		
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)")).click();
		ArrayList<Cafetera> listaSuperLonghiMM = new ArrayList<Cafetera>();;
		waitForPageLoad(controlador2);
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));	
		waitForPageLoad(controlador2);;
		listaSuperLonghiMM = llenarListaMM(listaNom, listaPre);
		printRes(listaSuperLonghiMM);
		
		//-----BOSCH------------//
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)")).click();		
		waitForPageLoad(controlador2);		
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)")).click();
		ArrayList<Cafetera> listaSuperBoschMM = new ArrayList<Cafetera>();;
		waitForPageLoad(controlador2);
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));	
		waitForPageLoad(controlador2);;
		listaSuperBoschMM = llenarListaMM(listaNom, listaPre);
		printRes(listaSuperBoschMM);
		
		//----JURA-----------//
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)")).click();		
		waitForPageLoad(controlador2);		
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)")).click();
		ArrayList<Cafetera> listaSuperJuraMM = new ArrayList<Cafetera>();;
		waitForPageLoad(controlador2);
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));	
		waitForPageLoad(controlador2);;
		listaSuperJuraMM = llenarListaMM(listaNom, listaPre);
		printRes(listaSuperJuraMM);
		
		//-------PHILIPS--------//
		waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)")).click();		
		waitForPageLoad(controlador2);		
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(6) > a:nth-child(2)")).click();
		ArrayList<Cafetera> listaSuperPhilMM = new ArrayList<Cafetera>();;
		waitForPageLoad(controlador2);
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));	
		waitForPageLoad(controlador2);;
		listaSuperPhilMM = llenarListaMM(listaNom, listaPre);
		printRes(listaSuperPhilMM);
		
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
