package main.java.pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//import main.java.pageObjects.CC_Localizadores_Enfermo_Terminal2;
import main.java.pageObjects.CC_Localizadores_Enfermo_Terminal2;
import main.java.utils.GG_ElementFetch;
import main.java.utils.GG_Eventos;
import main.java.utils.GG_Utils;
import main.java.utils.GG_Validations;
import test.java.previred.CC_Test;
import main.java.utils.CC_Parametros;
import java.io.File; // Importa la clase File para manejar rutas de archivo
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

//En esta clase se ejecutan los Pasos de la Pagina.
public class Enfermo_terminal extends CC_Test {

	public Enfermo_terminal(WebDriver driver) {
		CC_Test.driver = driver;
	}

	// iniciar sesion perfil ejecutivo
	public static void iniciarSesionEjecutivo(String usuario, String contrasena, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			Thread.sleep(1000);

			// Se escribe el Nombre del Usuario
			WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputUsuario);
			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
			GG_Eventos.writeOnInput(inputNombreUsuarioElement, usuario);

			Thread.sleep(300);

			// Se escribe la Contrasena
			WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputContrasena);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			GG_Eventos.writeOnInput(inputContrasenaElement, contrasena);

			Thread.sleep(300);

			// Click en boton ingresar
			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnIngresar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			GG_Eventos.clickButton(buttonIniciarSesionElement);

			Thread.sleep(200);

			// Verifica si se llego a la segunda pantalla.
			WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.validaLoginExitoso);
			wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
			String textoPagina = labelPaginaElement.getText();

			GG_Validations.trueBooleanCondition(
					textoPagina.equalsIgnoreCase("Sistema de Apoyo a la Gestión de las Comisiones Médicas"),
					"Se ha ingresado correctamente a la pagina: " + textoPagina,
					"No se ha ingresado correctamente a la pagina: ", currentEvent);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	/* Flujo: Ingresar a nueva solicitud */
	// Ingresar a nueva solicitud
	public static void iniciarSolicitudEjecutivo(String rut, String ninstitucion, String fecharecep, String nombressoli,
			String primerapesoli, String segundoapesoli, String fechanac, String profesion, String nmovil, String nfijo,
			String direccion, String nrodire, String fechainafp, String personavalidaafiliado,
			String afeccionoenfermedad, String xNumero) 
	{

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			// Se ingresa el rut del Usuario
			WebElement inputrutsolElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputRutSolicitante);
			wait.until(ExpectedConditions.visibilityOf(inputrutsolElement));
			GG_Eventos.writeOnInput(inputrutsolElement, rut);
			Thread.sleep(200);

			// Click en boton comenzar
			WebElement buttoncomenzarElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnComenzar);
			wait.until(ExpectedConditions.elementToBeClickable(buttoncomenzarElement));
			GG_Eventos.clickButton(buttoncomenzarElement);

			Thread.sleep(200);

			// Verifica si se llego a pantalla. Ingresar una solicitud
			WebElement labelPaginasolicitudElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.validaCrearNuevaSolicitud);
			wait.until(ExpectedConditions.visibilityOf(labelPaginasolicitudElement));
			String textoPagina = labelPaginasolicitudElement.getText();

			GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Ingreso de Nueva Solicitud"),
					"Se ha ingresado correctamente a la pagina: " + textoPagina,
					"No se ha ingresado correctamente a la pagina: ", currentEvent);

			Thread.sleep(200);

			// 1. Información del solicitante
			// click para elegir tipo de solicitud
			WebElement tiposolicitud = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickOptTipoSolicitud)));
			tiposolicitud.click();

			// Selecciona opcion tipo solicitud
			WebElement tiposolicitudopcion = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optTipoSolicitud)));
			tiposolicitudopcion.click();
			// Thread.sleep(1000);

			// Se escribe el Nº Interno Institución
			WebElement inputninstitucionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.nroInstitucion);
			wait.until(ExpectedConditions.visibilityOf(inputninstitucionElement));
			GG_Eventos.writeOnInput(inputninstitucionElement, ninstitucion);

			// Click en boton buscar
			WebElement buttonbuscarrSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnBuscar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonbuscarrSesionElement));
			GG_Eventos.clickButton(buttonbuscarrSesionElement);
			Thread.sleep(2000);

			// Click en botón Enfermo Terminal
			WebElement buttonenfermoterminal = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.optEnfermoTerminal);
			wait.until(ExpectedConditions.elementToBeClickable(buttonenfermoterminal));
			GG_Eventos.clickButton(buttonenfermoterminal);
			Thread.sleep(300);

			WebElement buttonArchivoSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.buttonArchivo);
			wait.until(ExpectedConditions.elementToBeClickable(buttonArchivoSesionElement));
			GG_Eventos.clickButton(buttonArchivoSesionElement);
			Thread.sleep(3000);
			
			try {
			    Robot robot = new Robot();

			    // 1️⃣ Esperar a que aparezca el diálogo de archivos
			    Thread.sleep(2000);

			    // 2️⃣ Ruta de la carpeta (desde CC_Parametros)
			    String rutaCarpeta = new File("CC_Logs_2p//").getAbsolutePath();

			    // Copiar ruta al portapapeles
			    StringSelection seleccionRuta = new StringSelection(rutaCarpeta);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccionRuta, null);

			    // 3️⃣ Ctrl + L para seleccionar barra de dirección
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_L);
			    robot.keyRelease(KeyEvent.VK_L);
			    robot.keyRelease(KeyEvent.VK_CONTROL);
			    Thread.sleep(300);

			    // 4️⃣ Ctrl + V para pegar la ruta
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);
			    Thread.sleep(300);

			    // 5️⃣ Enter para ir a la carpeta
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);
			    System.out.println("Ruta abierta: " + rutaCarpeta);

			    // 6️⃣ Esperar carga de carpeta
			    Thread.sleep(1500);

			    // 7️⃣ Nombre del archivo
			    String nombreArchivo = "Documento.pdf";
			    StringSelection seleccionArchivo = new StringSelection(nombreArchivo);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccionArchivo, null);

			    // 8️⃣ Mover el foco al campo "Nombre de archivo"
			    // Si el foco está en la lista de archivos, bastan 2 TABs
			    for (int i = 0; i < 7; i++) {
			        robot.keyPress(KeyEvent.VK_TAB);
			        robot.keyRelease(KeyEvent.VK_TAB);
			        Thread.sleep(200);
			    }

			    // 9️⃣ Pegar el nombre del archivo
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);
			    Thread.sleep(300);

			    // 🔟 Enter para abrir el archivo
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);

			    System.out.println("Archivo cargado: " + nombreArchivo);

			} catch (AWTException | InterruptedException e) {
			    e.printStackTrace();
			}



			
			Thread.sleep(5000);	

			// Se ingresa Fecha de recepción de solicitud en AFP
			WebElement fecharecepElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.fechaRecepcionAfp);
			wait.until(ExpectedConditions.visibilityOf(fecharecepElement));
			GG_Eventos.writeOnInput(fecharecepElement, fecharecep);

			// Se ingresa Nombres
			WebElement nombressoliElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.nombreSolicitante);
			wait.until(ExpectedConditions.visibilityOf(nombressoliElement));
			GG_Eventos.writeOnInput(nombressoliElement, nombressoli);

			// Se ingresa Primer Apellido
			WebElement primerapesoliElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.primerApellidoSolicitante);
			wait.until(ExpectedConditions.visibilityOf(primerapesoliElement));
			GG_Eventos.writeOnInput(primerapesoliElement, primerapesoli);

			// Se ingresa Segundo Apellido
			WebElement segundoapesoliElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.segundoApellidoSolicitante);
			wait.until(ExpectedConditions.visibilityOf(segundoapesoliElement));
			GG_Eventos.writeOnInput(segundoapesoliElement, segundoapesoli);

			// Se ingresa Fecha de nacimiento
			WebElement fechanacElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.fechaNacimiento);
			wait.until(ExpectedConditions.visibilityOf(fechanacElement));
			GG_Eventos.writeOnInput(fechanacElement, fechanac);
			Actions enter = new Actions(driver);
			enter.sendKeys(Keys.ENTER).perform();
			Thread.sleep(300);

			// clickeamos sexo
			WebElement tiposex = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickOptTipoSexo)));
			tiposex.click();

			// Seleccionar masculino_femenino
			WebElement tiposexo = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optTipoSexo)));
			tiposexo.click();

			// clickeamos Estado Civil
			WebElement estadocivil = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickOptEstadoCivil)));
			estadocivil.click();

			WebElement tipoestadocivil = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optEstadoCivil)));
			tipoestadocivil.click();

			// Se ingresa Profesión o actividad
			WebElement profesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.profesion);
			wait.until(ExpectedConditions.visibilityOf(profesionElement));
			GG_Eventos.writeOnInput(profesionElement, profesion);

			// Click Ingrese correo electrónico
			WebElement btnmail = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optEmail)));
			btnmail.click();

			// Se ingresa Teléfono móvil
			WebElement numovil = elementFetch.getWebElement("XPATH", CC_Localizadores_Enfermo_Terminal2.numeroMovil);
			wait.until(ExpectedConditions.visibilityOf(numovil));
			GG_Eventos.writeOnInput(numovil, nmovil);

			// Se ingresa Teléfono móvil
			Thread.sleep(300);

			WebElement optcheckFijo = driver.findElement(By.id("isNoTieneTelefonoFijo"));
			optcheckFijo.click();
			Thread.sleep(300);

			// Nivel Educacional
			WebElement educa = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickOptNivelEducacional)));
			educa.click();

			WebElement educa2 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optNivelEducacional)));
			educa2.click();

			// Region
			WebElement region = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickOptRegion)));
			region.click();

			WebElement regionopcion = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optRegion)));
			regionopcion.click();

			// Provincia
			WebElement provincia = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickOptProvincia)));
			provincia.click();

			WebElement provinciaopcion = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optProvincia)));
			provinciaopcion.click();

			// Comuna
			WebElement comuna = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickOptComuna)));
			comuna.click();

			// Baja a las opciones no visibles, mediante el teclado
			Actions actions = new Actions(driver);
			boolean found = false;

			for (int i = 0; i < 16; i++) {
				actions.sendKeys(Keys.DOWN).perform();
				Thread.sleep(300);}

			// Se activa el Scroll hasta llegar a Rancagua
			WebElement option = driver.findElement(By.xpath(CC_Localizadores_Enfermo_Terminal2.optComuna));

			// Scroll al elemento usando JS
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);

			// Clic en la opción Rancagua
			option.click();

			// Se ingresa Dirección; Calle
			WebElement dire = elementFetch.getWebElement("XPATH", CC_Localizadores_Enfermo_Terminal2.direccion);
			wait.until(ExpectedConditions.visibilityOf(dire));
			GG_Eventos.writeOnInput(dire, direccion);

			// Se ingresa numeral de la dirección
			WebElement nrodir = elementFetch.getWebElement("XPATH", CC_Localizadores_Enfermo_Terminal2.nroDireccion);
			wait.until(ExpectedConditions.visibilityOf(nrodir));
			GG_Eventos.writeOnInput(nrodir, nrodire);

			// Click en boton continuar
			WebElement btncontinuar1 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnContinuar);
			wait.until(ExpectedConditions.elementToBeClickable(btncontinuar1));
			GG_Eventos.clickButton(btncontinuar1);

			// 2. Antecedentes Laborales y Previsionales
			// Situación laboral
			WebElement situlaboral = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickSituacionLaboral)));
			situlaboral.click();

			WebElement situlaboral1 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optSituacionLaboral)));
			situlaboral1.click();

			// Institución de salud
			WebElement instsalud = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickInstitucionSalud)));
			instsalud.click();

			WebElement instsalud1 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optInstitucionSalud)));
			instsalud1.click();

			// Se ingresa Fecha de afiliación al sistema AFP
			WebElement fechaafp = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.fechaAfiliacionAfp);
			wait.until(ExpectedConditions.visibilityOf(fechaafp));
			GG_Eventos.writeOnInput(fechaafp, fechainafp);
			Actions enterafp = new Actions(driver);
			enterafp.sendKeys(Keys.ENTER).perform();
			Thread.sleep(300);

			// Click ¿Ha realizado cambio de AFP el afiliado?
			WebElement cambioafp = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.opcCambioAfp)));
			cambioafp.click();

			// Click Se encuentra pensionado por la ley 16.744
			WebElement ley16744 = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.opcMutualidad)));
			ley16744.click();

			// Click ¿Cuenta con cobertura del SIS el solicitante?
			WebElement consis = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.coberturaSis)));
			consis.click();

			// Subir Arvhivo Documento de cobertura del solicitante
			
			//GG_Eventos.adjuntarArchivoOculto(driver, CC_Localizadores_Enfermo_Terminal2.doccobersis, "C:\\Ejemplo1.pdf");

			Thread.sleep(300);

			WebElement buttonArchivo1SesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.doccobersis);
			wait.until(ExpectedConditions.elementToBeClickable(buttonArchivo1SesionElement));
			GG_Eventos.clickButton(buttonArchivo1SesionElement);
			
			Thread.sleep(3000);
			
			try {
			    Robot robot = new Robot();

			    // Espera breve para asegurar que se abra el diálogo de archivos
			    Thread.sleep(2000);

			    // Nombre del archivo a cargar (puede ser solo el nombre si ya estás en el directorio correcto)
			    String nombreArchivo1 = "Documento.pdf";  // o la ruta completa

			    // Copiar al portapapeles
			    StringSelection seleccion1 = new StringSelection(nombreArchivo1);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion1, null);

			    // Ctrl + V
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    Thread.sleep(200);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);

			    Thread.sleep(500);

			    // Presionar Enter
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);

			    System.out.println("Archivo cargado automáticamente: " + nombreArchivo1);

			} catch (AWTException | InterruptedException e) {
			    e.printStackTrace();
			}
			
			// Click ¿Está actualmente acogido a una licencia médica el solicitante?
			WebElement limed = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.conLicencia)));
			limed.click();

			// Click btn continuar para ir a Otros datos de la solicitud
			WebElement btnContinuar2 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.btnContinuarPaso2)));
			btnContinuar2.click();
			Thread.sleep(500);

			// 3. Otros datos de la solicitud
			// Click Quién verifica la incapacidad
			WebElement verifiincapacidad = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.verifiincapacidadcermedi)));
			verifiincapacidad.click();
			
			Thread.sleep(300);

			WebElement buttonArchivo2SesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.doccertimedico);
			wait.until(ExpectedConditions.elementToBeClickable(buttonArchivo2SesionElement));
			GG_Eventos.clickButton(buttonArchivo2SesionElement);

			// Subir Documento Certificado médico
			Thread.sleep(3000);
			
			try {
			    Robot robot = new Robot();

			    // Espera breve para asegurar que se abra el diálogo de archivos
			    Thread.sleep(2000);

			    // Nombre del archivo a cargar (puede ser solo el nombre si ya estás en el directorio correcto)
			    String nombreArchivo2 = "Documento.pdf";  // o la ruta completa

			    // Copiar al portapapeles
			    StringSelection seleccion2 = new StringSelection(nombreArchivo2);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion2, null);

			    // Ctrl + V
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    Thread.sleep(200);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);

			    Thread.sleep(500);

			    // Presionar Enter
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);

			    System.out.println("Archivo cargado automáticamente: " + nombreArchivo2);

			} catch (AWTException | InterruptedException e) {
			    e.printStackTrace();
			}
			//GG_Eventos.adjuntarArchivoOculto(driver, CC_Localizadores_Enfermo_Terminal2.doccertimedico,"C:\\Ejemplo2.pdf");

			// Nombre de la persona que verificó la identidad del afiliado en AFP
			WebElement inputPersonaValidaAfiliado = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.nombrePerVerificaIdentidadAfiliado);
			wait.until(ExpectedConditions.visibilityOf(inputPersonaValidaAfiliado));
			GG_Eventos.writeOnInput(inputPersonaValidaAfiliado, personavalidaafiliado);

			// ¿Requiere representación de un tercero?
			WebElement representanteTercero = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.requiereTercero)));
			representanteTercero.click();

			// Ha sufrido algún accidente del trabajo o enfermedad profesional
			WebElement sufridoaccidenteoenfermedad = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.sufreaccidenteoenfermedad)));
			sufridoaccidenteoenfermedad.click();

			// Principal afección o enfermedad por la que solicita este beneficio
			WebElement inputafeccionoenfermedad = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.nombreafeccionoenfermedad);
			wait.until(ExpectedConditions.visibilityOf(inputafeccionoenfermedad));
			GG_Eventos.writeOnInput(inputafeccionoenfermedad, afeccionoenfermedad);

			// Ingrese el porcentaje de cargo del afiliado a la Administradora del arancel
			WebElement selectporcentaje = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.opcionporcentaje)));
			selectporcentaje.click();

			// Click btn continuar para ir a Adjuntar Antecedentes Médicos y otros
			WebElement btnContinuar3 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.btnContinuarPaso3)));
			btnContinuar3.click();
			Thread.sleep(500);

			// 4. Adjuntar Antecedentes Médicos y otros
			// Incorporar otros antecedentes
			WebElement incorotrosantecedentes = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.otrosantecedente)));
			incorotrosantecedentes.click();
			Thread.sleep(500);

			// Nombre del documento
			WebElement Nombredocumento = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clicknomnbredocumento)));
			Nombredocumento.click();

			WebElement Nombredocumento1 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optnombredocumento)));
			Nombredocumento1.click();

			WebElement buttonArchivo3SesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.buttonArchivo);
			wait.until(ExpectedConditions.elementToBeClickable(buttonArchivo3SesionElement));
			GG_Eventos.clickButton(buttonArchivo3SesionElement);
			
			try {
			    Robot robot = new Robot();

			    // Espera breve para asegurar que se abra el diálogo de archivos
			    Thread.sleep(2000);

			    // Nombre del archivo a cargar (puede ser solo el nombre si ya estás en el directorio correcto)
			    String nombreArchivo3 = "Documento.pdf";  // o la ruta completa

			    // Copiar al portapapeles
			    StringSelection seleccion3 = new StringSelection(nombreArchivo3);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion3, null);

			    // Ctrl + V
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    Thread.sleep(200);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);

			    Thread.sleep(500);

			    // Presionar Enter
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);

			    System.out.println("Archivo cargado automáticamente: " + nombreArchivo3);

			} catch (AWTException | InterruptedException e) {
			    e.printStackTrace();
			}
			// Subir Adjuntar Certificado
			GG_Eventos.adjuntarArchivoOculto(driver, CC_Localizadores_Enfermo_Terminal2.doccertimedico2,
					"C:\\Ejemplo3.pdf");

			// Click btn continuar para ir a confirmación
			WebElement btnContinuar4 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.btnContinuarPaso4)));
			btnContinuar4.click();
			Thread.sleep(500);

			// 5. Confirmación
			// Presionar Finalizar
			WebElement btnfinalizar = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.btnfinalizar)));
			btnfinalizar.click();
			Thread.sleep(500);

			// Presionar botonera aceptar Nueva Solicitud
			WebElement btnaceptarsolcitud = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.aceptarsolcitud)));
			btnaceptarsolcitud.click();

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	// iniciar sesion para camino feliz sagcom perfil administrativo
	public static void iniciarSesionAdministrativo(String adm, String pass, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			Thread.sleep(1000);

			// Se escribe el Nombre del Usuario
			WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputUsuarioadm);
			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
			GG_Eventos.writeOnInput(inputNombreUsuarioElement, adm);

			Thread.sleep(300);

			// Se escribe la Contrasena
			WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputContrasenaamd);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			GG_Eventos.writeOnInput(inputContrasenaElement, pass);

			Thread.sleep(300);

			// Click en boton ingresar
			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnIngresar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			GG_Eventos.clickButton(buttonIniciarSesionElement);

			Thread.sleep(200);

			// Verifica si se llego a la segunda pantalla.
			WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.validaLoginExitosoFlujoAdm);
			wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
			String textoPagina = labelPaginaElement.getText();

			GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Perfil Administrativo"),
					"Se ha ingresado correctamente a la pagina: " + textoPagina,
					"No se ha ingresado correctamente a la pagina: ", currentEvent);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	// Ingresar a nueva solicitud perfil administrativo
	public static void iniciarSolicitudAdministrativo(String rut, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			// Click en boton "Mi Trabajo Administrativo"
			WebElement opcionMiTrabajoAdm = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcMiTrabajoAdministrativo);
			wait.until(ExpectedConditions.elementToBeClickable(opcionMiTrabajoAdm));
			GG_Eventos.clickButton(opcionMiTrabajoAdm);

			// Click en opcion Análisis de admisibilidad
			WebElement opcionDeAdmisibilidad = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.analisisAdmisibilidad);
			wait.until(ExpectedConditions.elementToBeClickable(opcionDeAdmisibilidad));
			GG_Eventos.clickButton(opcionDeAdmisibilidad);
			Thread.sleep(1000);

			// Click en text box de Rut a buscar
			WebElement opcrutbuscar = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickopcrutbuscar)));
			opcrutbuscar.click();
			Thread.sleep(300);

			// Se ingresa el rut del solicitante a buscar
			WebElement inputrutsolBuscar = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.rutSolicitanteBuscar);
			wait.until(ExpectedConditions.visibilityOf(inputrutsolBuscar));
			GG_Eventos.writeOnInput(inputrutsolBuscar, rut);
			Thread.sleep(90000);

			// Click en la lupa buscar
			WebElement opcionBuscar = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcionLupaBuscar);
			wait.until(ExpectedConditions.elementToBeClickable(opcionBuscar));
			GG_Eventos.clickButton(opcionBuscar);
			Thread.sleep(5000);

			// Click en la opcion ver mas
			WebElement opcVerMas = elementFetch.getWebElement("XPATH", CC_Localizadores_Enfermo_Terminal2.opcionVerMas);
			wait.until(ExpectedConditions.elementToBeClickable(opcVerMas));
			GG_Eventos.clickButton(opcVerMas);
			Thread.sleep(5000);

			GG_Eventos.actionScroll(driver, 33);

			// Click en Admisibilidad del caso - 1er Documento - Si, Aprobar
			WebElement opcclicksiprobar1 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.clicksiprobar1);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar1));
			GG_Eventos.clickButton(opcclicksiprobar1);
			Thread.sleep(300);

			// Click en Admisibilidad del caso - 2do Documento - Si, Aprobar
			WebElement opcclicksiprobar2 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.clicksiprobar2);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar2));
			GG_Eventos.clickButton(opcclicksiprobar2);
			Thread.sleep(300);

			// Click en Admisibilidad del caso - 3er Documento - Si, Aprobar
			WebElement opcclicksiprobar3 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.clicksiprobar3);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar3));
			GG_Eventos.clickButton(opcclicksiprobar3);
			Thread.sleep(300);
			
			// Click en Admisibilidad del caso - 4er Documento - Si, Aprobar
			WebElement opcclicksiprobar4 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.clicksiprobar4);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar4));
			GG_Eventos.clickButton(opcclicksiprobar4);
			Thread.sleep(300);
			
			// Click en Admisibilidad del caso - 3er Documento - Si, Aprobar
			WebElement opcclickaprobardoc = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.clickAprobardoc);
			wait.until(ExpectedConditions.elementToBeClickable(opcclickaprobardoc));
			GG_Eventos.clickButton(opcclickaprobardoc);
			Thread.sleep(300);
			
			//GG_Eventos.actionScroll(driver, 3);
			
			// Click btn Confirmar Expediente del Caso
			WebElement btnConfirmarexpecaso = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnContinuarexpedientecaso);
			wait.until(ExpectedConditions.elementToBeClickable(btnConfirmarexpecaso));
			GG_Eventos.clickButton(btnConfirmarexpecaso);
		
			Thread.sleep(800);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	// iniciar sesion para camino feliz sagcom medico
	public static void iniciarSesionMedico(String medico, String password, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			Thread.sleep(1000);

			// Se escribe el Nombre del Usuario Medico
			WebElement inputMedicoElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputUsuariomedicopresi);
			wait.until(ExpectedConditions.visibilityOf(inputMedicoElement));
			GG_Eventos.writeOnInput(inputMedicoElement, medico);

			Thread.sleep(300);

			// Se escribe la Contrasena
			WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputContrasenamedicopresi);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			GG_Eventos.writeOnInput(inputContrasenaElement, password);

			Thread.sleep(300);

			// Click en boton ingresar
			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnIngresar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			GG_Eventos.clickButton(buttonIniciarSesionElement);

			Thread.sleep(200);

			// Verifica si se llego a la segunda pantalla.
			WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.validaLoginExitosoFlujoMedico);
			wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
			String textoPagina = labelPaginaElement.getText();

			GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Perfil Médico Presidente"),
					"Se ha ingresado correctamente a la pagina: " + textoPagina,
					"No se ha ingresado correctamente a la pagina: ", currentEvent);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	// Ingresar a nueva solicitud perfil medico
	public static void iniciarSolicitudMedico(String rutparabuscar, String comentarios1,String comentarios2, String pulso, String presion,
			String talla, String peso, String buscarcodigocie10, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			// Click en boton "Mi Trabajo"
			WebElement opcionMiTrabajomedpresi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcMiTrabajomedicopresidente);
			wait.until(ExpectedConditions.elementToBeClickable(opcionMiTrabajomedpresi));
			GG_Eventos.clickButton(opcionMiTrabajomedpresi);

			GG_Eventos.actionScroll(driver, 30);
			
			// Click en opcion Análisis de admisibilidad
			WebElement opcionexpediente = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcExpedientes);
			wait.until(ExpectedConditions.elementToBeClickable(opcionexpediente));
			GG_Eventos.clickButton(opcionexpediente);
			Thread.sleep(9000);

			// Click en text box Rut a buscar
			WebElement opcrutbuscarmedpresi = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickopcrutbuscarmedpresi)));
			opcrutbuscarmedpresi.click();
			Thread.sleep(300);

			// Se ingresa el rut del solicitante a buscar
			WebElement inputrutBuscarmedpresi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.rutSolicitanteBuscarmedipre);
			wait.until(ExpectedConditions.visibilityOf(inputrutBuscarmedpresi));
			GG_Eventos.writeOnInput(inputrutBuscarmedpresi, rutparabuscar);
			Thread.sleep(9000);

			// Click en la lupa buscar
			WebElement opcionBuscarmedpresi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcionLupaBuscarmedpresi);
			wait.until(ExpectedConditions.elementToBeClickable(opcionBuscarmedpresi));
			GG_Eventos.clickButton(opcionBuscarmedpresi);
			Thread.sleep(5000);

			// Click en la opcion ver mas
			WebElement opcVerMasmedpresi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcionVerMasmedpresi);
			wait.until(ExpectedConditions.elementToBeClickable(opcVerMasmedpresi));
			GG_Eventos.clickButton(opcVerMasmedpresi);
			Thread.sleep(5000);

			// Click en la opcion ver mas
			WebElement opcevaluacionmedpresi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcevaluacionmedica);
			wait.until(ExpectedConditions.elementToBeClickable(opcevaluacionmedpresi));
			GG_Eventos.clickButton(opcevaluacionmedpresi);
			Thread.sleep(2000);

			GG_Eventos.actionScroll(driver, 8);

			// ingresa comentario en Antecedentes personales y/o laborales y/o mórbidos
			WebElement inputAntecedentespersonales = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.Inputantecedentesper);
			wait.until(ExpectedConditions.visibilityOf(inputAntecedentespersonales));
			GG_Eventos.writeOnInput(inputAntecedentespersonales, comentarios1);

			// Cursa con licencia médica - NO
			WebElement opccursalicenciamedica = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.cursalicenciamedica);
			wait.until(ExpectedConditions.elementToBeClickable(opccursalicenciamedica));
			GG_Eventos.clickButton(opccursalicenciamedica);

			// ingresa comentario en Anamnesis y cronología de la evolución
			WebElement inputAnamnesisycronologia = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputAnamnesisycronolo);
			wait.until(ExpectedConditions.visibilityOf(inputAnamnesisycronologia));
			GG_Eventos.writeOnInput(inputAnamnesisycronologia, comentarios1);

			// ingresa comentario en Tratamiento actual o reciente
			WebElement inputratamientoactual = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputtratamientoactual);
			wait.until(ExpectedConditions.visibilityOf(inputratamientoactual));
			GG_Eventos.writeOnInput(inputratamientoactual, comentarios1);

			// ingresa comentario Otros Tratamientos
			WebElement inputotrotratamiento = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputotrostratamientos);
			wait.until(ExpectedConditions.visibilityOf(inputotrotratamiento));
			GG_Eventos.writeOnInput(inputotrotratamiento, comentarios1);

			// ingresa comentario Seleccione las Actividades Esenciales interferidas
			WebElement inputoactividadesescenciales = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputcomentarioEscenciales);
			wait.until(ExpectedConditions.visibilityOf(inputoactividadesescenciales));
			GG_Eventos.writeOnInput(inputoactividadesescenciales, comentarios1);

			// ingresa comentario Seleccione las Actividades Domésticas interferidas
			WebElement inputcomentariosdomesticos = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputcomentariosdomesticos);
			wait.until(ExpectedConditions.visibilityOf(inputcomentariosdomesticos));
			GG_Eventos.writeOnInput(inputcomentariosdomesticos, comentarios1);

			// ingresa comentario Seleccione las Actividades de Desplazamiento interferidas
			WebElement inputcomentariosdesplazamiento = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputcomentarioDesplazamiento);
			wait.until(ExpectedConditions.visibilityOf(inputcomentariosdesplazamiento));
			GG_Eventos.writeOnInput(inputcomentariosdesplazamiento, comentarios1);

			// ingresa comentario Seleccione las Actividades de Desplazamiento interferidas
			WebElement inputcomentariosociales = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputcomentariosociales);
			wait.until(ExpectedConditions.visibilityOf(inputcomentariosociales));
			GG_Eventos.writeOnInput(inputcomentariosociales, comentarios1);

			// Sospecha de invalidez previa - NO
			WebElement opcsospechainvalidez = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.sospechainvalidez);
			wait.until(ExpectedConditions.elementToBeClickable(opcsospechainvalidez));
			GG_Eventos.clickButton(opcsospechainvalidez);

			// Botonera Guardar Evaluación Médica
			WebElement btnguardarevaluacionmedica = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnguardarevamedica);
			wait.until(ExpectedConditions.elementToBeClickable(btnguardarevaluacionmedica));
			GG_Eventos.clickButton(btnguardarevaluacionmedica);

			// ingresa en Examen Físico - Pulso
			WebElement inputExFisicopulso = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputpulsaciones);
			wait.until(ExpectedConditions.visibilityOf(inputExFisicopulso));
			GG_Eventos.writeOnInput(inputExFisicopulso, pulso);

			// ingresa en Examen Físico - Presión
			WebElement inputExFisicopresion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputpresion);
			wait.until(ExpectedConditions.visibilityOf(inputExFisicopresion));
			GG_Eventos.writeOnInput(inputExFisicopresion, presion);

			// ingresa en Examen Físico - Talla
			WebElement inputExFisicotalla = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputalla);
			wait.until(ExpectedConditions.visibilityOf(inputExFisicotalla));
			GG_Eventos.writeOnInput(inputExFisicotalla, talla);

			// ingresa en Examen Físico - Peso
			WebElement inputExFisicopeso = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputpeso);
			wait.until(ExpectedConditions.visibilityOf(inputExFisicopeso));
			GG_Eventos.writeOnInput(inputExFisicopeso, peso);

			// ingresa comentario Examen Físico - Impedimentos a considerar
			//WebElement inputExfisicoimpedimentoconsiderar = elementFetch.getWebElement("XPATH",
			//		CC_Localizadores_Enfermo_Terminal2.impedimentoconsiderar);
			//wait.until(ExpectedConditions.visibilityOf(inputExfisicoimpedimentoconsiderar));
			//GG_Eventos.writeOnInput(inputExfisicoimpedimentoconsiderar, comentarios1);

			// Botonera Guardar Examen Físico
			WebElement btnguardarexamenfisico = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnguardaexamenfisico);
			wait.until(ExpectedConditions.elementToBeClickable(btnguardarexamenfisico));
			GG_Eventos.clickButton(btnguardarexamenfisico);

			// Acción a seguir - Cierre de caso
			WebElement optplanaccion = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickOptplanaccion)));
			optplanaccion.click();

			WebElement clicckplanaccion = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optclicckplanaccion)));
			clicckplanaccion.click();

			// ingresa comentario Argumentos, configuración, menoscabos y comentario final
			WebElement inputplanaccioncomentarioFinal = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputcomentariofinal);
			wait.until(ExpectedConditions.visibilityOf(inputplanaccioncomentarioFinal));
			GG_Eventos.writeOnInput(inputplanaccioncomentarioFinal, comentarios1);
			Thread.sleep(1000);

			GG_Eventos.actionScroll(driver, 8);

			// ¿Existen impedimentos configurados del mismo capítulo que afectan la misma
			// área de AVD y se... - NO
			WebElement opcAVD = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcconfiguracionAVD);
			wait.until(ExpectedConditions.elementToBeClickable(opcAVD));
			GG_Eventos.clickButton(opcAVD);
			Thread.sleep(1000);

			// Botonera Configurar y Agregar Impedimentos
			WebElement btnconfiagreimpe = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnconfiguraragregarimpedimento);
			wait.until(ExpectedConditions.elementToBeClickable(btnconfiagreimpe));
			GG_Eventos.clickButton(btnconfiagreimpe);
			Thread.sleep(500);

			// Botonera agregar Otro Impedimento
			WebElement btnotroimpedimento = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnagregarotroimpedimento);
			wait.until(ExpectedConditions.elementToBeClickable(btnotroimpedimento));
			GG_Eventos.clickButton(btnotroimpedimento);
			Thread.sleep(1000);

			// ingresa comentario en Plan de Acción - Configurar y Agregar Impedimentos
			WebElement inputotroimpedimentoagregarnuevoimpedimento = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputagregarimpedimento);
			wait.until(ExpectedConditions.visibilityOf(inputotroimpedimentoagregarnuevoimpedimento));
			GG_Eventos.writeOnInput(inputotroimpedimentoagregarnuevoimpedimento, comentarios2);
			Thread.sleep(2000);

			// Seleccionar en Configuración la opción NO - Así habilita los campos Clase y
			// rango
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			WebElement cie10Switch = wait.until(ExpectedConditions.elementToBeClickable(By.id("isCie10")));
			cie10Switch.click();
			String estado = cie10Switch.getAttribute("aria-checked");
			if (!"true".equals(cie10Switch.getAttribute("aria-checked"))) {
				cie10Switch.click(); // Encenderlo si está apagado
			}

			// Click en menú desplegable de Clase
			WebElement optplanaccionmenuclase = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickOptmenuclase)));
			optplanaccionmenuclase.click();
			// Seleccionar Clase de valor "IV"
			WebElement clickplanaccionmenuclase = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optclickmenuclase)));
			clickplanaccionmenuclase.click();

			// Click en menú desplegable de Rango
			WebElement optplanaccionmenurango = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickOptmenurango)));
			optplanaccionmenurango.click();
			// Seleccionar Clase de valor "Alto"
			WebElement clickplanaccionmenurango = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.optclickmenurango)));
			clickplanaccionmenurango.click();
			Thread.sleep(2000);

			// Botonera Agregar Otro Impedimento
			WebElement btnagregarotroimpedimento = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnagregarimpedimento);
			wait.until(ExpectedConditions.elementToBeClickable(btnagregarotroimpedimento));
			GG_Eventos.clickButton(btnagregarotroimpedimento);
			Thread.sleep(3000);

			// ¿Existen impedimentos configurados del mismo capítulo que afectan la misma
			// área de AVD y se... - NO
			WebElement opcAVD2 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcconfiguracionAVD);
			wait.until(ExpectedConditions.elementToBeClickable(opcAVD2));
			GG_Eventos.clickButton(opcAVD2);

			GG_Eventos.actionScroll(driver, 8);

			// Asignar cie 10
			WebElement opclinkasignarcie10 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcasignarcie10);
			wait.until(ExpectedConditions.elementToBeClickable(opclinkasignarcie10));
			GG_Eventos.clickButton(opclinkasignarcie10);
			Thread.sleep(2000);

			// Filtrar en Asignar código cie10
			WebElement inputbusquedacodigocie10 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputcodigocie10);
			wait.until(ExpectedConditions.visibilityOf(inputbusquedacodigocie10));
			GG_Eventos.writeOnInput(inputbusquedacodigocie10, buscarcodigocie10);

			// Presionar lupa de Asignar código cie10
			WebElement opcionlupacie10 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.optlupacie10);
			wait.until(ExpectedConditions.elementToBeClickable(opcionlupacie10));
			GG_Eventos.clickButton(opcionlupacie10);
			Thread.sleep(1000);

			// click en cabecera llamada Nombre
			WebElement clickcabeceranombre = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickencabeceranombre)));
			clickcabeceranombre.click();
			Thread.sleep(300);

			// Asignar código cie10 - O22 COMPLICACIONES VENOSAS DEL EMBARAZO
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement btnradio = driver.findElement(By.cssSelector("tr[data-row-key='1'] input.ant-radio-input"));
			btnradio.click();

			// Botonera Asignar cie10
			WebElement btnasignarciel0 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnagregarasignarcie10codigo);
			wait.until(ExpectedConditions.elementToBeClickable(btnasignarciel0));
			GG_Eventos.clickButton(btnasignarciel0);

			// Invalidez Previa - NO
			WebElement opcinvalidezprevi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcinvalidezprevia);
			wait.until(ExpectedConditions.elementToBeClickable(opcinvalidezprevi));
			GG_Eventos.clickButton(opcinvalidezprevi);
			Thread.sleep(500);

			// Botonera Guardar Plan de Acción
			WebElement btnguardaplanaccion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnguardarplandeaccion);
			wait.until(ExpectedConditions.elementToBeClickable(btnguardaplanaccion));
			GG_Eventos.clickButton(btnguardaplanaccion);
			Thread.sleep(1500);

			// Botonera Enviar a Sesión
			WebElement btnenviarsesion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnenviarasesion);
			wait.until(ExpectedConditions.elementToBeClickable(btnenviarsesion));
			GG_Eventos.clickButton(btnenviarsesion);
			Thread.sleep(1500);

			// Cerrar Sesion Perfil Administrador
			WebElement perfilPresidenteMedico = driver
					.findElement(By.cssSelector("div.ant-col.ant-col-xs-0.ant-col-md-18 span"));
			perfilPresidenteMedico.click();
			Thread.sleep(500);
			WebElement cerrarSesionPresiMedico = driver.findElement(By.xpath("//a[text()='Cerrar sesión']"));
			cerrarSesionPresiMedico.click();
			Thread.sleep(800);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	// iniciar sesion para camino feliz sagcom perfil administrativo 1
	public static void SesionAdministrativo2(String usuarioadm, String contrasenaadm, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			Thread.sleep(1000);

			// Se escribe el Nombre del Usuario
			WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputUsuario2);
			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
			GG_Eventos.writeOnInput(inputNombreUsuarioElement, usuarioadm);

			Thread.sleep(300);

			// Se escribe la Contrasena
			WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.inputContrasena2);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			GG_Eventos.writeOnInput(inputContrasenaElement, contrasenaadm);

			Thread.sleep(300);

			// Click en boton ingresar
			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btnIngresaadm2);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			GG_Eventos.clickButton(buttonIniciarSesionElement);

			Thread.sleep(200);

			// Verifica si se llego a la segunda pantalla.
			WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.validaLoginExitosoFlujoAdm);
			wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
			String textoPagina = labelPaginaElement.getText();

			GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Perfil Administrativo"),
					"Se ha ingresado correctamente a la pagina: " + textoPagina,
					"No se ha ingresado correctamente a la pagina: ", currentEvent);

			Thread.sleep(3000);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}

	}

	// Ingresar a nueva solicitud perfil administrativo
	public static void SolicitudAdministrativo2 (String rut, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			// Click en los tres "..." punto del menú
			WebElement buttonbtntrespuntos = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btntrespuntos);
			wait.until(ExpectedConditions.elementToBeClickable(buttonbtntrespuntos));
			GG_Eventos.clickButton(buttonbtntrespuntos);
			Thread.sleep(200);

			// Click en opción Sesiones"
			WebElement opcoptsesiones = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.optsesiones);
			wait.until(ExpectedConditions.elementToBeClickable(opcoptsesiones));
			GG_Eventos.clickButton(opcoptsesiones);

			// Click en botonera para la Crear Tabla
			WebElement opcioncreartablas = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btncreartabla);
			wait.until(ExpectedConditions.elementToBeClickable(opcioncreartablas));
			GG_Eventos.clickButton(opcioncreartablas);
			Thread.sleep(1000);

			// Click calendario de fecha para Crear Tabla
			WebElement opccalendariocreatabla = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.clickcalendariocreatabla)));
			opccalendariocreatabla.click();
			Thread.sleep(1000);

			// Seleccionar Ahora en calendario
			WebElement btnahoracalendario = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal2.btncalendarioahora)));
			btnahoracalendario.click();
			Thread.sleep(1000);

			GG_Eventos.actionScroll(driver, 10);

			// Click en Expedientes de calificación / reevaluación CMR
			WebElement opcexpedientecali = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.opcexpedientecalificacion);
			wait.until(ExpectedConditions.elementToBeClickable(opcexpedientecali));
			GG_Eventos.clickButton(opcexpedientecali);
			Thread.sleep(500);

			// Presiona ícono Filtro
			WebElement btniconofiltro = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.botoniconofiltro);
			wait.until(ExpectedConditions.elementToBeClickable(btniconofiltro));
			GG_Eventos.clickButton(btniconofiltro);

			// Ingresa rut en Filtro del búsqueda
			WebElement inputrutfiltroadm = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.rutfiltroadm);
			wait.until(ExpectedConditions.visibilityOf(inputrutfiltroadm));
			GG_Eventos.writeOnInput(inputrutfiltroadm, rut);
			Thread.sleep(90000);


			// Click en Filtrar
			WebElement clickfiltraricono = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.clickfiltrarut);
			wait.until(ExpectedConditions.elementToBeClickable(clickfiltraricono));
			GG_Eventos.clickButton(clickfiltraricono);
			Thread.sleep(2000);

			GG_Eventos.actionScroll(driver, 10);

			// Click en check box
			WebDriverWait wait4 = new WebDriverWait(driver, 10);
			WebElement clickencheckbox = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label.ant-checkbox-wrapper")));
			clickencheckbox.click();
			Thread.sleep(1000);

			// Click en botonera Crear Tabla Sesion
			WebElement clickencreatablasesion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Enfermo_Terminal2.btncreatablasesion);
			wait.until(ExpectedConditions.elementToBeClickable(clickencreatablasesion));
			GG_Eventos.clickButton(clickencreatablasesion);
			Thread.sleep(500);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
}
