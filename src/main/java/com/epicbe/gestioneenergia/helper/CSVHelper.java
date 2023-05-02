package com.epicbe.gestioneenergia.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.epicbe.gestioneenergia.model.Comune;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CSVHelper {
	public static String TYPE = "text/csv";
	// static String[] HEADERs = { "idProv", "idCom", "comune", "provincia" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Comune> csvToTutorials(MultipartFile file) {
		try {
			InputStream is = file.getInputStream();
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withFirstRecordAsHeader());

			List<Comune> comuni = new ArrayList<Comune>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			log.info(csvRecords.toString());

			for (CSVRecord csvRecord : csvRecords) {

				Long idProv = Long.parseLong(csvRecord.get("idProv"));
	    	Long idCom = Long.parseLong(csvRecord.get("idCom"));
				String comune = csvRecord.get("comune");
				String provincia = csvRecord.get("provincia");

				Comune c = Comune.builder()
	    			.codiceComune(idCom)
						.codiceProvincia(idProv).nome(comune).provincia(provincia).build();

				log.info("Ho un comune!!");
				comuni.add(c);
			}

			csvParser.close();
			return comuni;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}