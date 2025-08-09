package test.java.previred;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.pageEvents.Enfermo_terminal;
import main.java.utils.CC_Parametros;
import main.java.utils.GG_OpenCSV;
import main.java.utils.GG_Utils;
import resource.java.GG_BaseTest;

public class CC_Test extends GG_BaseTest {
	static int gloFilas = 0;
	public static String gloVerFlujo = "S";

	public static void OpenTxt() {
		OpenTxt();
		System.out.println("*** Archivo leído: " + CC_Parametros.gloDir + "\\data\\TotalCasosDePruebas.txt");
		System.out.println("*** Total Casos de Prueba a ejecutar: " + gloFilas + ".");

		if (gloVerFlujo.equalsIgnoreCase("S")) {
			System.out.println("*** La ejecución del Flujo será visible por pantalla.");
		} else {
			System.out.println("*** La ejecución del Flujo NO será visible por pantalla, se ejecutará en Background.");
		}

		File archivo = new File(CC_Parametros.gloDir + "\\data\\TotalCasosDePruebas.txt");

		gloFilas = 0;
		gloVerFlujo = "S";

		if (archivo.exists()) {
			try (FileReader fr = new FileReader(archivo); BufferedReader br = new BufferedReader(fr)) {

				// Línea 1: Comentario - se ignora
				br.readLine();

				// Línea 2: Cantidad de casos de prueba
				String linea = br.readLine();
				if (linea != null) {
					gloFilas = Integer.parseInt(linea.trim());
				}

				// Línea 3: Indicador S/N para ver flujo
				linea = br.readLine();
				if (linea != null) {
					gloVerFlujo = linea.trim();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Archivo no existe: " + archivo.getAbsolutePath());
		}
	}
}
