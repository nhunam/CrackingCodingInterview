package ArrayAndString1;

public class StringCompression16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StringCompression16.stringCompression("abbbbbcccaaa"));
	}
	
	public static String stringCompression(String s) {
		if (s.length() == 0) 
			return "";
		char[] charArr = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		char pre = charArr[0];
		sb.append(pre);
		for (int i = 1; i < charArr.length; i++) {
			if (charArr[i] == pre) {
				count++;
			}else {
				sb.append(count);
				sb.append(charArr[i]);
				pre = charArr[i];
				count = 1;
			}
		}
		sb.append(count);
		String result = (s.length() >= sb.toString().length()) ? sb.toString() : s;
		return result;
	}

}
