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
import com.epicbe.gestioneenergia.model.Provincia;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CSVHelper {

	static Integer i = 0;
	public static String TYPE = "text/csv";

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Comune> csvToComuni(MultipartFile file) {
		try {
			CSVParser csvParser = CSVParser.parse(file.getInputStream(), Charset.forName("UTF-8"),
					CSVFormat.DEFAULT.withIgnoreHeaderCase().withSkipHeaderRecord().withDelimiter(';'));

			List<Comune> comuni = new ArrayList<Comune>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			csvParser.close();

			csvRecords.forEach(csvRecord -> {

				Comune c = new Comune();

				try {
					Long idCom = Long.parseLong(csvRecord.get(1));
					Long idProv = Long.parseLong(csvRecord.get(0));
					c.setCodiceComune(idCom);
					c.setCodiceProvincia(idProv);
					String comune = csvRecord.get(2);
					c.setNome(comune);
					String provincia = csvRecord.get(3);
					c.setProvincia(provincia);
					comuni.add(c);
				} catch (Exception e) {
					log.error(e.toString());
				}
			});

			log.info(comuni.size() + " comuni elaborati");
			return comuni;

		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
	
	
	public static List<Provincia> csvToProvince(MultipartFile file) {
		try {
			CSVParser csvParser = CSVParser.parse(file.getInputStream(), Charset.forName("UTF-8"),
					CSVFormat.DEFAULT.withIgnoreHeaderCase().withSkipHeaderRecord().withDelimiter(';'));

			List<Provincia> provs = new ArrayList<Provincia>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			csvParser.close();

			csvRecords.forEach(csvRecord -> {

				Provincia p = new Provincia();

				try {
					p.setSigla(csvRecord.get(0));
					p.setProvincia(csvRecord.get(1));
					p.setRegione(csvRecord.get(2));
					provs.add(p);
				} catch (Exception e) {
					log.error(e.toString());
				}
			});

			log.info(provs.size() + " province elaborate");
			return provs;

		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}