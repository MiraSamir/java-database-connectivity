package dataTypes;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateType extends Type {
	
	@Override
	public boolean isValid(String value) {
		return (hasQuotes(value) && !isWhiteSpace(value) && isDate(value));
	}
	
	private static boolean isDate(String s) {
		String dateWithoutQuotes = s.replaceAll("^\'|^\"|\'$|\"$", "");
		if (dateWithoutQuotes == null || !dateWithoutQuotes.matches("\\d{4}-[01]\\d-[0-3]\\d"))
			return false;
		try {
			format.get().parse(s);
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}
	
	private boolean isWhiteSpace(String s) {
		String f = s.replaceAll("\\s", "");
		return (f.length() == 2);
	}
	
	@Override
	public int compare(String firstValue, String secondValue) throws ParseException {
		Date firstDate = (Date) castType(firstValue);
		Date secondDate = (Date) castType(secondValue);
		return firstDate.compareTo(secondDate);
		
	}
	
	@Override
	public Object castType(String value) throws ParseException {
		value = value.replaceAll("^\'|^\"|\'$|\"$", "");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(value);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		return sqlStartDate;
	}
	
	private static final ThreadLocal<SimpleDateFormat> format = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			df.setLenient(false);
			return df;
		}
	};
	
	//	
	public static void main(String[] args) throws ParseException {
		// 	Date date = new Date(0);
		//	String dd = date.toString();
		//	
		//		System.out.println(DateType.isDate("18-09-08"));
		String startDate = "1996-9-8";
		System.out.println(startDate.matches("\\d{4}-[01]\\d-[0-3]\\d"));
		//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		//		java.util.Date date = sdf1.parse(startDate);
		//		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
		//		System.out.println(sqlStartDate);
	}
	
}
