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

public class MediaMarkt {
	public static ArrayList<Cafetera> listaCafetera = new ArrayList<Cafetera>();	
	public static ArrayList<WebElement> listaNom = new ArrayList<WebElement>();
	public static ArrayList<WebElement> listaPre = new ArrayList<WebElement>();
	
	public static ArrayList<Cafetera> krupsMono() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.categoryTreeFirst")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> deLonghiMono() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.categoryTreeFirst")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> boschMono() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.categoryTreeFirst")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> philipsMono() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.categoryTreeFirst")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> tassimoMono() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.categoryTreeFirst")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> krupsSuper() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_730 > a:nth-child(1")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> saecoSuper() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_730 > a:nth-child(1")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> deLonghiSuper() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_730 > a:nth-child(1")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> boschSuper() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_730 > a:nth-child(1")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> juraSuper() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_730 > a:nth-child(1")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> philipsSuper() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_730 > a:nth-child(1")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(6) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(6) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> krupsExpress() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_731 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> saecoExpress() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_731 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> deLonghiExpress() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_731 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> ufesaExpress() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_731 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> jataExpress() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_731 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> orbegozoExpress() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_731 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(6) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(6) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> whirlpoolExpress() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_731 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(7) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(7) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> illiExpress() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_731 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(8) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(8) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> osterExpress() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_731 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(9) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(9) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> solacExpress() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_731 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(10) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(10) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> deLonghiGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> boschGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)"));
		WebElement element = controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)"));
		Main.comprobarDom(element, controlador2);
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)"));
		element = controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)"));
		Main.comprobarDom(element, controlador2);
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)"));
		element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)"));
		Main.comprobarDom(element, controlador2);
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> philipsGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> moulinexGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(4) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> taurusGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(5) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> ufesaGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(6) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(6) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> jataGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(7) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(7) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> rushellGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(8) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(8) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> okGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(9) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(9) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> electroGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.filterElement:nth-child(10) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(10) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> wmfGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("#categoryFilterMoreBrands > div:nth-child(1) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("#categoryFilterMoreBrands > div:nth-child(1) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		controlador2.findElement(By.cssSelector("#categoryFilterViewMoreBrands")).click();
		Main.waitForPageLoad(controlador2);
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> tristarGoteo() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10000892 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("#categoryFilterMoreBrands > div:nth-child(2) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("#categoryFilterMoreBrands > div:nth-child(2) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		controlador2.findElement(By.cssSelector("#categoryFilterViewMoreBrands")).click();
		Main.waitForPageLoad(controlador2);
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> taurusTradicional() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10002237 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> jataTradicional() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10002237 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.filterElement:nth-child(2) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(2) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	public static ArrayList<Cafetera> menzTradicional() throws Exception{
		WebDriver controlador2 = inicioFirefox();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#categoryTree_10002237 > a:nth-child(1)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("a.filterElement:nth-child(2)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(3)")).click();
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("div.categoryFilter:nth-child(2) > div:nth-child(2) > select:nth-child(1) > option:nth-child(3)")).click();
		JavascriptExecutor jse = (JavascriptExecutor)controlador2;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait waitingScrollKrupsMonoMM = new WebDriverWait(controlador2, 10);
		waitingScrollKrupsMonoMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.brandsFilterElement:nth-child(1) > a:nth-child(2)")));
		controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)")).click();
		WebElement element = controlador2.findElement(By.cssSelector("div.brandsFilterElement:nth-child(3) > a:nth-child(2)"));
		if (!element.isDisplayed()) {				
			System.out.println("No est� el elemento en la p�gina en este momento");
			JavascriptExecutor js = (JavascriptExecutor) controlador2;
			js.executeScript("arguments[0].click();", element);
			} else 	element.click();;
		Main.waitForPageLoad(controlador2);	
		listaNom = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'product1Description')]"));
		listaPre = (ArrayList<WebElement>) controlador2.findElements(By.xpath("//*[contains(@class, 'meta-bigprices')]"));				
		Main.waitForPageLoad(controlador2);
		listaCafetera = Main.llenarListaMM(listaNom, listaPre, controlador2,0);
		controlador2.quit();
		return listaCafetera;	
	}
	
	
	public static WebDriver inicioFirefox(){
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
		Main.waitForPageLoad(controlador2);
		controlador2.findElement(By.cssSelector("#world_hogar-jardin > a:nth-child(1)")).click();
		WebDriverWait waitingCafeMM = new WebDriverWait(controlador2, 10);
		waitingCafeMM.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#category_hogar-jardin--ctg-cafe > a:nth-child(1)")));
		controlador2.findElement(By.cssSelector("#category_hogar-jardin--ctg-cafe > a:nth-child(1)")).click();
		return controlador2;
	}
	
}
