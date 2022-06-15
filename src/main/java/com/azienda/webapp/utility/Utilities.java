package com.azienda.webapp.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Spettacolo;
import com.azienda.webapp.entity.Utente;

public class Utilities {
	private static String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	public static String scriviSuFile(final Part part, String path) {

		String fileName = getFileName(part);
		try (OutputStream out = new FileOutputStream (new File(path + File.separator + fileName));
				InputStream fileContent = part.getInputStream();) {

			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = fileContent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			return fileName;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public static String creaEmailStaffAdmin(Utente utente) {
		String email = (utente.getNome()+utente.getCognome()+"@cinemacult.com").toLowerCase();
		return email;	
	}
	
	public static String creaPasswordStaffAdmin(Utente utente) {
		String password = utente.getNome().charAt(0)+"."+utente.getCognome()+"#000"+utente.getId();
		return password;	
	}
	
	public static boolean controlloNumCarta(String numeroCarta) {
		if(numeroCarta!=null && !numeroCarta.isEmpty() && numeroCarta.length()==12) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean controlloCvv(String cvv) {
		if(cvv!=null && !cvv.isEmpty() && cvv.length()==3) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean controlloScadenza(Date scadenza) {
		if(scadenza.after(Date.valueOf(LocalDate.now()))) {
			return true;
		}else {
			return false;
		}
	}
	public static List<Spettacolo> spettacoliAttivi(Film film){
		List<Spettacolo>spettacoli=film.getSpettacoli();
		List<Spettacolo>spettacoliAttivi=new ArrayList<Spettacolo>();
		for(Spettacolo spettacolo:spettacoli) {
			if(spettacolo.getData().compareTo(Date.valueOf(LocalDate.now()))>=0) {
				if(spettacolo.getOra().compareTo(Time.valueOf(LocalTime.now()))>=0||spettacolo.getData().compareTo(Date.valueOf(LocalDate.now()))>=0) {
					spettacoliAttivi.add(spettacolo);
				}
			}
		}
		return spettacoliAttivi;
	}



}
