package test.java.previred;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.pageEvents.Enfermo_terminal;
import main.java.utils.GG_OpenCSV;
import main.java.utils.GG_Utils;

import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

//En esta clase se ejecutan los Pasos de la Pagina.
public class CU002_Enfermo_terminal extends CC_Test {

	@Test(enabled = true, dataProvider = "Data", priority = 1)
	public void Flujo_Sagcom(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo SAGCOM", "Validar el ingreso de una solicitud flujo sagcom");
		Enfermo_terminal.iniciarSesionEjecutivo(args[0], args[1], "1");// toma el dato del archivo de carga
		Enfermo_terminal.iniciarSolicitudEjecutivo(args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9],
				args[10], args[11], args[12], args[13], args[14], args[16], args[17], "2");
	}
	
    @DataProvider(name = "Data")
    public Object[][] cargarDatos() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 18)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom2.csv", 18);
    }
    
	@Test(enabled = true, dataProvider = "Data1", priority = 2)
	public void Flujo_Sagcom_Administrativo(String args[]) throws InterruptedException {
		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Administrativo", "Validar flujo perfil administrativo");
		Enfermo_terminal.iniciarSesionAdministrativo(args[18], args[19], "1");
		Enfermo_terminal.iniciarSolicitudAdministrativo(args[2],"2");
	}
	
    @DataProvider(name = "Data1")
    public Object[][] cargarDatos1() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 20)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom2.csv", 20);
    }
    
	@Test(enabled = true, dataProvider = "Data2", priority = 3)
	public void Flujo_Sagcom_Medico(String args[]) throws InterruptedException {
		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Medico", "Validar flujo perfil medico");
		Enfermo_terminal.iniciarSesionMedico(args[20], args[21], "1");
		Enfermo_terminal.iniciarSolicitudMedico(args[2], args[22], args[23], args[24], args[25], args[26], args[27],args[28], "2");
	}
	
    @DataProvider(name = "Data2")
    public Object[][] cargarDatos2() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 20)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom2.csv", 29);
    }
    
	@Test(enabled = true, dataProvider = "Data3", priority = 4)
	public void Flujo_Sagcom_Administrativo1(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Administrativo", "Validar flujo perfil administrativo");
		Enfermo_terminal.SesionAdministrativo2(args[18], args[19], "1");
		Enfermo_terminal.SolicitudAdministrativo2(args[2],"2");		
	}
	
    @DataProvider(name = "Data3")
    public Object[][] cargarDatos3() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 20)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom2.csv", 20);
    }
	
}
