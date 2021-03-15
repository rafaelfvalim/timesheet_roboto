package br.com.homine.roboto.helper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateHelper {

	public static LocalDate dateToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
