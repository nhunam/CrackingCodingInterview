package ArrayAndString1;

public class URLify13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(urlIfy("Hello world    ", 12));
	}
	
	static String urlIfy(String s, int len) {
		return s.substring(0, len).replace(" ", "%20");
	}

}


