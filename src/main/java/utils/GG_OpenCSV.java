package main.java.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class GG_OpenCSV {

	public static Object[][] getCSVParameters(String nombreCSV, int columnas)
			throws IOException, CsvValidationException {

		String ruta = CC_Parametros.gloDir + "\\data\\" + nombreCSV;
		List<Object[]> data = new ArrayList<>();

		try (CSVReader reader = new CSVReader(new FileReader(ruta))) {
			reader.readNext(); // Saltar encabezado (línea 1)
			String[] line = reader.readNext(); // Leer solo la segunda línea
			if (line != null && line.length >= columnas) {
				String[] trimmed = new String[columnas];
				System.arraycopy(line, 0, trimmed, 0, columnas);
				data.add(trimmed);
			}
		}

		Object[][] dataArray = new Object[data.size()][];
		return data.toArray(dataArray);
	}
}