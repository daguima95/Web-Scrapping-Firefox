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
		//borrarInecesarios(cafeterasCapsulasBoschNomCI,6);
		//borrarInecesarios(cafeterasCapsulasBoschPreCI,6);
		cafeterasCapsulasBoschPreCI.remove(1);
		cafeterasCapsulasBoschCI = llenarLista(cafeterasCapsulasBoschNomCI, cafeterasCapsulasBoschPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasBoschCI);
		//----------
		
		//---------------DELONGHI CAPSULAS----------//
		
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		WebDriverWait waitingDeLonghiCCI = new WebDriverWait(controlador, 10);
		waitingDeLonghiCCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();	
		((JavascriptExecutor) controlador).executeScript("arguments[0].scrollIntoView();",controlador.findElement(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")));
		((JavascriptExecutor) controlador).executeScript("window.scrollBy(0,-200)");
		WebDriverWait waitingScroll = new WebDriverWait(controlador, 20);
		waitingScroll.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pagination > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)") ) );
		ArrayList<Cafetera> cafeterasCapsulasDeLonghiCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasDeLonghiNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		ArrayList<WebElement> cafeterasCapsulasDeLonghiPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		//borrarInecesarios(cafeterasCapsulasDeLonghiNomCI,24);
		//borrarInecesarios(cafeterasCapsulasDeLonghiPreCI,24);
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
		//borrarInecesarios(cafeterasCapsulasDeLonghiNom2CI,4);
		//borrarInecesarios(cafeterasCapsulasDeLonghiPre2CI,4);
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
		WebDriverWait waitingDigratoCCI = new WebDriverWait(controlador, 10);
		waitingDigratoCCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(3) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasCapsulasDigratoCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasDigratoNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasCapsulasDigratoPreCI = new ArrayList<WebElement>();
		cafeterasCapsulasDigratoNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasCapsulasDigratoPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasCapsulasDigratoNomCI,4);
		//borrarInecesarios(cafeterasCapsulasDigratoPreCI,4);
		cafeterasCapsulasDigratoCI = llenarLista(cafeterasCapsulasDigratoNomCI, cafeterasCapsulasDigratoPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasDigratoCI);
		//----------
		
		//---------------KRUPS CAPSULAS----------//
		controlador.findElement(By.cssSelector("a.selected")).click();
		WebDriverWait waitingKrupsCCI = new WebDriverWait(controlador, 10);
		waitingKrupsCCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(4) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasCapsulasKrupsCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasKrupsNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasCapsulasKrupsPreCI = new ArrayList<WebElement>();
		cafeterasCapsulasKrupsNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasCapsulasKrupsPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasCapsulasKrupsNomCI,19);
		//borrarInecesarios(cafeterasCapsulasKrupsPreCI,19);
		cafeterasCapsulasKrupsCI = llenarLista(cafeterasCapsulasKrupsNomCI, cafeterasCapsulasKrupsPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasCapsulasKrupsCI);
		//----------
		
		
		//-------CAMBIANDO A GOTEO----------//
		controlador.findElement(By.id("1")).click();
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(2)")).click();
		
		//-------BOSCH GOTEO--------//
		WebDriverWait waitingBoschGCI = new WebDriverWait(controlador, 10);
		waitingBoschGCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoBoschCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoBoschNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoBoschPreCI = new ArrayList<WebElement>();
		cafeterasGoteoBoschNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoBoschPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasGoteoBoschNomCI,1);
		//borrarInecesarios(cafeterasGoteoBoschPreCI,1);
		cafeterasGoteoBoschCI = llenarLista(cafeterasGoteoBoschNomCI, cafeterasGoteoBoschPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoBoschCI);
		//----------
		
		//-------RUSHELL HOBS GOTEO--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingRushelGCI = new WebDriverWait(controlador, 10);
		waitingRushelGCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoRushellCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoRushellNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoRushellPreCI = new ArrayList<WebElement>();
		cafeterasGoteoRushellNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoRushellPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasGoteoRushellNomCI,3);
		//borrarInecesarios(cafeterasGoteoRushellPreCI,3);
		cafeterasGoteoRushellCI = llenarLista(cafeterasGoteoRushellNomCI, cafeterasGoteoRushellPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoRushellCI);
		//----------
		
		//-------SAIVOD GOTEO--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingSaivodGCI = new WebDriverWait(controlador, 10);
		waitingSaivodGCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(3) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoSaivodCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoSaivodNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoSaivodPreCI = new ArrayList<WebElement>();
		cafeterasGoteoSaivodNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoSaivodPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasGoteoSaivodNomCI,4);
		//borrarInecesarios(cafeterasGoteoSaivodPreCI,4);
		cafeterasGoteoSaivodCI = llenarLista(cafeterasGoteoSaivodNomCI, cafeterasGoteoSaivodPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoSaivodCI);
		//----------
		
		//-------SEVERIN GOTEO--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingSeverinGCI = new WebDriverWait(controlador, 10);
		waitingSeverinGCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(4) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoSeverinCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoSeverinNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoSeverinPreCI = new ArrayList<WebElement>();
		cafeterasGoteoSeverinNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoSeverinPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasGoteoSeverinNomCI,4);
		//borrarInecesarios(cafeterasGoteoSeverinPreCI,4);
		cafeterasGoteoSeverinCI = llenarLista(cafeterasGoteoSeverinNomCI, cafeterasGoteoSeverinPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoSeverinCI);
		//----------
		
		//-------TAURUS GOTEO--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingTaurusGCI = new WebDriverWait(controlador, 10);
		waitingTaurusGCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(5) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(5) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoTaurusCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoTaurusNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoTaurusPreCI = new ArrayList<WebElement>();
		cafeterasGoteoTaurusNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoTaurusPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasGoteoTaurusNomCI,4);
		//borrarInecesarios(cafeterasGoteoTaurusPreCI,4);
		cafeterasGoteoTaurusCI = llenarLista(cafeterasGoteoTaurusNomCI, cafeterasGoteoTaurusPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoTaurusCI);
		//----------
		
		//-------UFESA GOTEO--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingUfesaGCI = new WebDriverWait(controlador, 10);
		waitingUfesaGCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasGoteoUfesaCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasGoteoUfesaNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasGoteoUfesaPreCI = new ArrayList<WebElement>();
		cafeterasGoteoUfesaNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasGoteoUfesaPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasGoteoUfesaNomCI,4);
		//borrarInecesarios(cafeterasGoteoUfesaPreCI,4);
		cafeterasGoteoUfesaCI = llenarLista(cafeterasGoteoUfesaNomCI, cafeterasGoteoUfesaPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasGoteoUfesaCI);
		//----------
				
		
		//-------CAMBIANDO A SEMIAUTOMATICAS----------//
		controlador.findElement(By.id("1")).click();
		////--------------------AQUI VA UN WAIT--------------------------------
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(2)"));
		
		//-------BOSCH SEMIAUTOMATICAS--------//
		WebDriverWait waitingBoschSCI = new WebDriverWait(controlador, 10);
		waitingBoschSCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSemiBoschCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSemiBoschNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSemiBoschPreCI = new ArrayList<WebElement>();
		cafeterasSemiBoschNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSemiBoschPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasSemiBoschNomCI,1);
		//borrarInecesarios(cafeterasSemiBoschPreCI,1);
		cafeterasSemiBoschCI = llenarLista(cafeterasSemiBoschNomCI, cafeterasSemiBoschPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSemiBoschCI);
		//----------


		//-------DELONGHI SEMIAUTOMATICAS--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingDeLonghiSCI = new WebDriverWait(controlador, 10);
		waitingDeLonghiSCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSemiDeLonghiCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSemiDeLonghiNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSemiDeLonghiPreCI = new ArrayList<WebElement>();
		cafeterasSemiDeLonghiNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSemiDeLonghiPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasSemiDeLonghiNomCI,3);
		//borrarInecesarios(cafeterasSemiDeLonghiPreCI,3);
		cafeterasSemiDeLonghiCI = llenarLista(cafeterasSemiDeLonghiNomCI, cafeterasSemiDeLonghiPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSemiDeLonghiCI);
		//----------
		
		//-------JURA SEMIAUTOMATICA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingJuraSCI = new WebDriverWait(controlador, 10);
		waitingJuraSCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(3) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSemiJuraCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSemiJuraNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSemiJuraPreCI = new ArrayList<WebElement>();
		cafeterasSemiJuraNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSemiJuraPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasSemiJuraNomCI,3);
		//borrarInecesarios(cafeterasSemiJuraPreCI,3);
		cafeterasSemiJuraCI = llenarLista(cafeterasSemiJuraNomCI, cafeterasSemiJuraPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSemiJuraCI);
		//----------
		
		//-------KRUPS SEMIAUTOMATICA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingKrupsSCI = new WebDriverWait(controlador, 10);
		waitingKrupsSCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(4) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSemiKrupsCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSemiKrupsNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSemiKrupsPreCI = new ArrayList<WebElement>();
		cafeterasSemiKrupsNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSemiKrupsPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasSemiKrupsNomCI,3);
		//borrarInecesarios(cafeterasSemiKrupsPreCI,3);
		cafeterasSemiKrupsCI = llenarLista(cafeterasSemiKrupsNomCI, cafeterasSemiKrupsPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSemiKrupsCI);
		//----------
		
		//-------MIELE SEMIAUTOMATICA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingMieleSCI = new WebDriverWait(controlador, 10);
		waitingMieleSCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(5) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(5) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSemiMieleCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSemiMieleNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSemiMielePreCI = new ArrayList<WebElement>();
		cafeterasSemiMieleNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSemiMielePreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasSemiMieleNomCI,3);
		//borrarInecesarios(cafeterasSemiMielePreCI,3);
		cafeterasSemiMieleCI = llenarLista(cafeterasSemiMieleNomCI, cafeterasSemiMielePreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSemiMieleCI);
		//----------
		
		//-------PHILIPS SEMIAUTOMATICA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingPhilSCI = new WebDriverWait(controlador, 10);
		waitingPhilSCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSemiPhilCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSemiPhilNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSemiPhilPreCI = new ArrayList<WebElement>();
		cafeterasSemiPhilNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSemiPhilPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasSemiPhilNomCI,3);
		//borrarInecesarios(cafeterasSemiPhilPreCI,3);
		cafeterasSemiPhilCI = llenarLista(cafeterasSemiPhilNomCI, cafeterasSemiPhilPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSemiPhilCI);
		//----------
		
		//-------SAECO SEMIAUTOMATICA--------//
		controlador.findElement(By.cssSelector(".selected")).click();
		WebDriverWait waitingSaecoSCI = new WebDriverWait(controlador, 10);
		waitingSaecoSCI.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")));
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasSemiSaecoCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasSemiSaecoNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasSemiSaecoPreCI = new ArrayList<WebElement>();
		cafeterasSemiSaecoNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasSemiSaecoPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		//borrarInecesarios(cafeterasSemiSaecoNomCI,3);
		//borrarInecesarios(cafeterasSemiSaecoPreCI,3);
		cafeterasSemiSaecoCI = llenarLista(cafeterasSemiSaecoNomCI, cafeterasSemiSaecoPreCI);
		//BORRAR LOS PRINT
		printRes(cafeterasSemiSaecoCI);
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
	public static ArrayList<WebElement> borrarInecesarios(ArrayList<WebElement> listaElementos, int numeroElementos){
		if(numeroElementos != listaElementos.size()){
			for(int j = 0; j<4; j++){
				listaElementos.remove(listaElementos.size()-1);
			}
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
