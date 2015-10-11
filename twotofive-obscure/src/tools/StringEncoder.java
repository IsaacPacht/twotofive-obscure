package tools;

public class StringEncoder {
	static int radix = 35;
	static String[] strings = {
		"javax.script.ScriptEngineManager",
		"getEngineByName",
		"JavaScript",
		"javax.script.ScriptEngine",
		"eval",
		"f=new javax.swing.JFrame();f.show();javax.swing.JOptionPane.showConfirmDialog(f,'Obscure enough?');f.dispose();"
	};

	public static void main(String[] args) {
		for (String input : strings) {
			String output = encode(input);
			System.out.println(input + "/" + output);
		}
	}

	private static String encode(String input) {
		String firstHalf = "", secondHalf = "";
		for (byte b : input.getBytes()) {
			String s = Integer.toString(b, radix);
			if (s.length() < 2) s = "0" + s;
			firstHalf = firstHalf + s.charAt(0);
			secondHalf = s.charAt(1) + secondHalf;
		}
			
		String output = firstHalf + secondHalf;
		return output;
	}
}
