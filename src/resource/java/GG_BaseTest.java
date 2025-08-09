package resource.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.*;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.utils.CC_Parametros;
import test.java.previred.CC_Test;

public class GG_BaseTest {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeTest
    public void setupReport() {
        // Obtener fecha y hora para nombre de reporte
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HHmmss");

        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyyMMdd");

        String sufijo = fecha.format(formatoFecha) + "_" + hora.format(formatoHora);

        String rutaReporte = CC_Parametros.gloDir + File.separator + "reporte" + File.separator
                + "ReporteAutomatizacion_" + sufijo + ".html";

        htmlReporter = new ExtentHtmlReporter(rutaReporte);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Reporte Automatización");
        htmlReporter.config().setReportName("Resultado Pruebas Automatizadas");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester Automatizador", CC_Parametros.nombreAutomatizador);
        extent.setSystemInfo("Proyecto", CC_Parametros.nombreProyecto);
    }

    @BeforeMethod
    @Parameters({ "browserName" })
    public void setupDriver(String browserName, Method testMethod) {
        logger = extent.createTest(testMethod.getName());
        initializeDriver(browserName);

        driver.manage().window().maximize();
        driver.get(CC_Parametros.url);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        String methodName = result.getMethod().getMethodName();
        logger.assignAuthor(CC_Parametros.nombreAutomatizador);

        if (result.getStatus() == ITestResult.SUCCESS) {
            String logText = "Test Case: " + methodName + " PASSED";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, m);

            // Leer ruta imagen evidencia desde archivo txt
            String archivoPaso = CC_Parametros.gloDir + File.separator + "screenshots" + File.separator + "passed"
                    + File.separator + "Archivo_Paso.txt";
            File archivo = new File(archivoPaso);
            if (archivo.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                    String fileName = br.readLine();
                    if (fileName != null && !fileName.isEmpty()) {
                        logger.addScreenCaptureFromPath(fileName, methodName);
                    }
                }
            }
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String logText = "Test Case: " + methodName + " FAILED";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, m);
        } else if (result.getStatus() == ITestResult.SKIP) {
            String logText = "Test Case: " + methodName + " SKIPPED";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.AMBER);
            logger.log(Status.SKIP, m);
        }

        // Cerrar navegador después de cada test
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    public void finalizeReport() {
        extent.flush();
    }

    private void initializeDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Opciones para ejecución headless o modo incognito
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
                    "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage",
                    "--incognito", "--disable-blink-features=AutomationControlled");

            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

            if ("S".equals(CC_Test.gloVerFlujo)) { // Ver flujo en navegador
                driver = new ChromeDriver();
            } else {
                driver = new ChromeDriver(options);
            }
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            // Por defecto Chrome normal
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }
}
