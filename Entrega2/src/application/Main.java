package application;
	
import java.util.ArrayList;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
		FirefoxCI();
		/*try {
			FirefoxMM();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}*/
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
		controlador2.findElement(By.cssSelector("#world_hogar-jardin > a:nth-child(1)")).click();
		WebDriverWait waitingCafeMM = new WebDriverWait(controlador2, 10);
		waitingCafeMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#category_hogar-jardin--ctg-cafe > a:nth-child(1)")));
		controlador2.findElement(By.cssSelector("#category_hogar-jardin--ctg-cafe > a:nth-child(1)")).click();
		
		//--------MONODOSIS-------//
		
		WebDriverWait waitingMonoMM = new WebDriverWait(controlador2, 10);
		waitingMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.categoryTreeFirst")));
		controlador2.findElement(By.cssSelector("a.categoryTreeFirst")).click();
		WebDriverWait waitingFilterMM = new WebDriverWait(controlador2, 10);
		waitingFilterMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.filterElement:nth-child(2)")));
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		WebDriverWait waitingFilterNeleMM = new WebDriverWait(controlador2, 10);
		waitingFilterNeleMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")));
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		
		//-----------KRUPS-------//
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();
		ArrayList<Cafetera> listaKrupMonoMM = new ArrayList<Cafetera>();
		System.out.println("EMPIEZA LA MAGIA");		
		ArrayList<WebElement> listaNom = new ArrayList<WebElement>();
		ArrayList<WebElement> listaPre = new ArrayList<WebElement>();
		System.out.println("ESPERANDO");
		WebDriverWait waitingStale = new WebDriverWait(controlador2, 10);
		waitingStale.until(ExpectedConditions.visibilityOfAllElements(controlador2.findElements(By.xpath("//*[contains(@class, 'lazy loaded')]"))));
		System.out.println("COGIENDO ELEMENTOS");		
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));	
		/*printResNomMM(listaNom);
		printResPreMM(listaPre);	*/				
		listaKrupMonoMM = llenarListaMM(listaNom, listaPre);
		printRes(listaKrupMonoMM);		
		
		
		//----------DELONGHI------//
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();
		
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
	public static ArrayList<Cafetera> llenarListaMM(WebDriver controlador2){
		System.out.println("DENTRO");
		Cafetera cafetera = new Cafetera();
		ArrayList<Cafetera> listaCafetera = new ArrayList<Cafetera>();
		ArrayList<WebElement> listaContador = new ArrayList<WebElement>();
		ArrayList<WebElement> listaNom = new ArrayList<WebElement>();
		ArrayList<WebElement> listaPre = new ArrayList<WebElement>();
		System.out.println("ESPERANDO");
		WebDriverWait waitingStale = new WebDriverWait(controlador2, 10);
		waitingStale.until(ExpectedConditions.visibilityOfAllElements(controlador2.findElements(By.xpath("//*[contains(@class, 'lazy loaded')]"))));
		System.out.println("COGIENDO ELEMENTOS");
		listaContador = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'lazy loaded')]"));
		int contador = 0;
		System.out.println("VA EL FOR");
		for(WebElement c : listaContador){
			System.out.println("DENTRO FOR");
			WebDriverWait waitingRefresh = new WebDriverWait(controlador2, 10);
			waitingRefresh.until(ExpectedConditions.visibilityOfAllElements(controlador2.findElements(By.xpath("//*[contains(@class, 'product')]"))));
			System.out.println("REFRESH");
			c.click();
			System.out.println("CLICK");
			WebDriverWait waitingStaleNom = new WebDriverWait(controlador2, 10);
			waitingStaleNom.until(ExpectedConditions.visibilityOf(controlador2.findElement(By.xpath("//*[contains(@class, 'mm-text--truncate mm-text--truncate-fallback')]"))));
			System.out.println("VA EL NOMBRE");
			listaNom.add(controlador2.findElement(By.xpath("//*[contains(@class, 'mm-text--truncate mm-text--truncate-fallback')]")));
			System.out.println("NOMBRE ADDED");
			WebDriverWait waitingStalePre = new WebDriverWait(controlador2, 10);
			waitingStalePre.until(ExpectedConditions.visibilityOf(controlador2.findElement(By.xpath("//*[contains(@class, 'mm-price media__price bigprices active)]"))));
			System.out.println("VA EL PRECIO");
			listaPre.add(controlador2.findElement(By.xpath("//*[contains(@class, 'mm-price media__price bigprices active)]")));
			System.out.println("PRECIO ADDED");
			//MAGIA//
			System.out.println("Nombre: " + listaNom.get(contador).getText());
			System.out.println("Precio: " + listaPre.get(contador).getText());
			cafetera.setNombre(listaNom.get(contador).getText());
			cafetera.setPrecio(listaPre.get(contador).getText());
			listaCafetera.add(cafetera);
			contador++;
		}
		return listaCafetera;
	}
	static void waitForPageLoad(WebDriver wdriver) {
		new WebDriverWait(wdriver, 20).until(
		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		}
}
