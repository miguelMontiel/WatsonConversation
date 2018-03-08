package com.ibm.conversacion;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CreadorCSV
{
	FileWriter filewriter;
	CSVPrinter csvprinter;
	CSVFormat csvformat = CSVFormat.DEFAULT.withRecordSeparator("\n");
	
	Simple simple = new Simple();
	
	String respuesta;
	String respuestaCortada;
	String respuestaWatson;
	
	void EscritorCSV(String archivos)
	{
		Reader in;
		int i = 1;
		
		try
		{	
			filewriter = new FileWriter("Respuesta.csv", true);
			csvprinter = new CSVPrinter(filewriter, csvformat);
			
			in = new FileReader(archivos);
			
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

			for (CSVRecord csvrecord : records)
			{
				System.out.println();
				System.out.println("-----------------------" + i++);

				respuesta = csvrecord.get(0).replace("\n", " ").replace("\r", " "); 

				int maxLength = (respuesta.length() < 2101)?respuesta.length():2101;
				respuestaCortada = respuesta.substring(0, maxLength);
				
				System.out.println("Lo que le voy a enviar al Watson: " + respuestaCortada);

				respuestaWatson = simple.Respuesta(respuestaCortada);
				
				csvprinter.print(respuestaWatson);
				csvprinter.printRecord(csvrecord);
			}
			System.out.println("Se creó el nuevo CSV");
			in.close();
		}
		catch (Exception e) { e.printStackTrace(); }
		finally
		{
			try
			{
				filewriter.flush();
				filewriter.close();
				csvprinter.close();
			}
			catch (IOException e) {	e.printStackTrace(); }
		}
	}
}
