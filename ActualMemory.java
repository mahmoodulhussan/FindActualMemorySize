import java.text.DecimalFormat;

public class ActualMemory {

	private static final Double CONVERSION = 1024.0;
	private static final Double OVERALL_SIZE = 0.93;
	private static final DecimalFormat FORMAT = new DecimalFormat("0.00");
	private static final DecimalFormat MB_FORMAT = new DecimalFormat("0");

	public static void main(String[] args) {
		
		System.out.println(actualMemorySize("32GB"));
		System.out.println(actualMemorySize("2GB"));
		System.out.println(actualMemorySize("512MB"));
	}
	
	public static String actualMemorySize(String mem) {
		
		
		if (mem == null || mem.lastIndexOf('B') != mem.length()-1) {
			return "Invalid string.";
		}
		
		String stringValue = mem.substring(0, mem.length()-2);
		String data = mem.substring(mem.length()-2);
		
		
		Double value;
		try {
			value = Double.parseDouble(stringValue);
		} catch (NumberFormatException e) {
			return "Please try a different value.";
		}
		
		value *= OVERALL_SIZE;
		
		if ((value < 1.00 && "GB".equals(data))) {
			value *= CONVERSION;
			data = "MB";
		}

		if ("MB".equals(data)) {
			return MB_FORMAT.format(value) + data;
		}
		
		return FORMAT.format(value)+data;
	}
	
}
