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
		try {
			FirefoxMM();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		//launch(args);
		
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
