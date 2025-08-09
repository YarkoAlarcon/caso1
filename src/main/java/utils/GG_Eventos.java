package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GG_Eventos {

	// .sendkeys()
	public static void writeOnInput(WebElement element, String value) {
		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			String nameInput = GG_Utils.inputName(element);

			if (element.isDisplayed() && element.isEnabled()) {
				int caracteres = element.getAttribute("value").toCharArray().length;
				for (int i = 0; i < caracteres; i++) {
					element.sendKeys(Keys.BACK_SPACE);
				}
				element.sendKeys(value);
				GG_Utils.outputInfo(" [evento] Se ha ingresado el texto '" + value + "' en el campo: " + nameInput);
			} else {
				GG_Utils.eventFailed(currentEvent,
						"[?] El campo '" + nameInput + "' no se encuentra habilitado o desplegado");
			}
		} catch (NoSuchElementException e) {
			String nameInput = GG_Utils.inputName(element);
			GG_Utils.eventFailed(currentEvent, "[?] El elemento '" + nameInput + "' no existe");
		}
	}

	// .click()
	public static void clickButton(WebElement element) {
		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
		if (element.isEnabled()) {
			String name = GG_Utils.buttonName(element);
			element.click();
			GG_Utils.outputInfo(" [evento] Se ha hecho clic en el boton: " + name);
		} else {
			String name = element.getAttribute("text");
			GG_Utils.eventFailed(currentEvent, "[?] El boton '" + name + "' no esta desplegado o habilitado");
		}
	}

	// .getText()
	public static String selectByText(WebElement element, String option) {
		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
		String name = GG_Utils.inputName(element);
		Select select = new Select(element);
		select.selectByVisibleText(option);

		if (select.getFirstSelectedOption().isSelected()) {
			String selectedOption = select.getFirstSelectedOption().getText();
			GG_Utils.outputInfo(
					" [evento] Se ha seleccionado la opcion '" + selectedOption + "' en la lista desplegable " + name);
			return selectedOption;
		} else {
			GG_Utils.eventFailed(currentEvent, "[?] La opcion requerida no pudo ser seleccionada");
			return null;
		}
	}

	// .executeScript()
	public static void clickJavaScript(WebDriver driver,WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String name = GG_Utils.buttonName(element);
		jse.executeScript("arguments[0].click()", element);
		GG_Utils.outputInfo(" [evento] Se hizo clic en el boton: " + name);
	}

	// manda un enter en un elemento especifico
	public static void actionEnterOnElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).sendKeys(Keys.ENTER).perform();
	}

	// Baja a las opciones no visibles, mediante el teclado
	public static void actionScroll(WebDriver driver,int nroDown) {
		Actions actions = new Actions(driver);

		try {
			for (int i = 0; i < nroDown; i++) {
				actions.sendKeys(Keys.DOWN).perform();
				Thread.sleep(300);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt(); // restaurar estado de interrupción
		}
	}

	// Scroll al elemento usando JS y clic en él
	public static void scrollToElementAndClick(WebDriver driver, WebElement element) {
		try {
			// Scroll al elemento usando JS
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			// Espera pequeña para asegurar que se vea (opcional)
			Thread.sleep(300);

			// Click en el elemento
			element.click();

			System.out.println("[evento] Se hizo scroll y clic en el elemento: " + element.toString());

		} catch (Exception e) {
			System.err.println("[ERROR] No se pudo hacer scroll y clic en el elemento: " + element.toString());
			e.printStackTrace();
		}
	}

	// subir archivo oculto
	public static void adjuntarArchivo(WebDriver driver, String idInput, String rutaAbsoluta) {
		try {
			WebElement fileInput = driver.findElement(By.id(idInput));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.display = 'block';", fileInput);
			fileInput.sendKeys(rutaAbsoluta);
			System.out.println("Archivo adjuntado correctamente: " + rutaAbsoluta);
		} catch (Exception e) {
			System.err.println("Error al adjuntar archivo: " + e.getMessage());
		}
	}
	
	public static void clickWithJS(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println("Error al hacer clic con JS: " + e.getMessage());
		}
	}
	
	public static void  validaObjetoIsSelect(WebDriver driver, WebElement element) {
		
		boolean isSelected = element.isSelected();

		if (isSelected) {
		    System.out.println("El objeto web está seleccionado.");
		} else {
		    System.out.println("El objeto web NO está seleccionado.");
		    Assert.assertTrue(isSelected, "El objeto web NO está seleccionado.");
		}

		
	}
	public static void adjuntarArchivoOculto(WebDriver driver, String idInput, String rutaAbsoluta) {
		try {
			WebElement fileInput = driver.findElement(By.id(idInput));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.display = 'block';", fileInput);
			fileInput.sendKeys(rutaAbsoluta);
			System.out.println("Archivo adjuntado correctamente: " + rutaAbsoluta);
		} catch (Exception e) {
			System.err.println("Error al adjuntar archivo: " + e.getMessage());
		}
	}
	public static void adjuntarArchivoConWebElement(WebDriver driver, WebElement element, String rutaAbsoluta) {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].style.display = 'block';", element);
	        element.sendKeys(rutaAbsoluta);
	        System.out.println("Archivo adjuntado correctamente: " + rutaAbsoluta);
	    } catch (Exception e) {
	        System.err.println("Error al adjuntar archivo con JS: " + e.getMessage());
	    }

	}
}
