package com.hcl.demo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static LocalDate dateFormat(String date) {

		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(date, formatter);

	}

}
