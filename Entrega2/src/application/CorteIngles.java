package application;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorteIngles {
	public static ArrayList<Cafetera> cafeteras= new ArrayList<Cafetera>();
	public static ArrayList<WebElement> cafeterasNom = new ArrayList<WebElement>();
	public static ArrayList<WebElement> cafeterasPre = new ArrayList<WebElement>();
	
	public static ArrayList<Cafetera> boschCapsulas(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		ArrayList<Cafetera> cafeterasCapsulasBoschCI = new ArrayList<Cafetera>();
		ArrayList<WebElement> cafeterasCapsulasBoschNomCI = new ArrayList<WebElement>();
		ArrayList<WebElement> cafeterasCapsulasBoschPreCI = new ArrayList<WebElement>();
		Main.waitForPageLoad(controlador);
		cafeterasCapsulasBoschNomCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasCapsulasBoschPreCI = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));		
		Main.borrarInecesarios(cafeterasCapsulasBoschNomCI);
		Main.borrarInecesarios(cafeterasCapsulasBoschPreCI);
		cafeterasCapsulasBoschPreCI.remove(3);
		cafeterasCapsulasBoschCI = Main.llenarLista(cafeterasCapsulasBoschNomCI, cafeterasCapsulasBoschPreCI);
		controlador.quit();
		return cafeterasCapsulasBoschCI;
	}
	public static ArrayList<Cafetera> deLonghiCapsulas(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;		
	}
	public static ArrayList<Cafetera> digratoCapsulas(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;		
	}
	public static ArrayList<Cafetera> krupsCapsulas(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> boschGoteo(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> deLonghiGoteo(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> mondialGoteo(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> rushellGoteo(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> saivodGoteo(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(5) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> severinGoteo(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> taurusGoteo(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(7) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> ufesaGoteo(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(8) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> boschSuper(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> deLonghiSuper(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> juraSuper(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> krupsSuper(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> mieleSuper(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(5) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> philipsSuper(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> saecoSuper(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(7) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> deLonghiManual(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> osterManual(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> saecoManual(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(3) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> saivodManual(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(4) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> smegManual(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(5) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> solacManual(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(6) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> ufesaManual(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(7) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> deLonghiItalianaElectrica(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(6) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(1) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	public static ArrayList<Cafetera> saivodElectrica(){
		WebDriver controlador = inicioFirefox();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("li.sliding:nth-child(2) > ul:nth-child(2) > li:nth-child(6) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(3) > li:nth-child(2) > a:nth-child(2)")).click();
		Main.waitForPageLoad(controlador);
		cafeterasNom = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'js-product-click event')]"));
		cafeterasPre = (ArrayList<WebElement>) controlador.findElements(By.xpath("//*[contains(@class, 'current ')]"));
		Main.borrarInecesarios(cafeterasNom);
		Main.borrarInecesarios(cafeterasPre);
		cafeteras = Main.llenarLista(cafeterasNom, cafeterasPre);
		controlador.quit();
		return cafeteras;
	}
	
	
	public static WebDriver inicioFirefox(){
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
		Main.waitForPageLoad(controlador);
		controlador.findElement(By.cssSelector("ul.dimensions:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
		return controlador;
	}
}
