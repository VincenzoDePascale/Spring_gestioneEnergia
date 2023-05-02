package com.epicbe.gestioneenergia.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
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

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Comune> csvToComuni(MultipartFile file) {
		try {
			CSVParser csvParser = CSVParser.parse(file.getInputStream(), Charset.forName("UTF-8"), CSVFormat.DEFAULT.withFirstRecordAsHeader().withDelimiter(';'));

			List<Comune> comuni = new ArrayList<Comune>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
				csvParser.close();

			csvRecords.forEach(csvRecord -> {
				log.info(csvRecord.toString());
				//String idProv = csvRecord.get("idProv");
				//Long idCom = Long.parseLong(csvRecord.get("idCom"));
				//log.info(idProv);
				String comune = csvRecord.get("comune");
				String provincia = csvRecord.get("provincia");
				Comune c = new Comune(123l, comune, provincia);

				comuni.add(c);
			});

			log.info(comuni.size() + "");
			return comuni;
			
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}