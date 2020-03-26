package BitManipulation5;

public class BinaryToString52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binToStr(0.5));
	}
	
	static String binToStr(double p) {
		if (p >=1 || p <=0)
			return "ERROR";
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		while (p != 0 && sb.length() <= 31){
			if (p < 1)
				p*=2;
			if (p >= 1) {
				sb.append("1");
				p -=1;
			}else {
				sb.append("0");
				p*=2;
			}
		}
		
		if (sb.length() == 32) return "ERROR";
		return sb.toString();
	}

	static String binToStr2(double p) {
		if (p >=1 || p <=0)
			return "ERROR";
		
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		while (p > 0){
			if(sb.length() >= 32) return "ERROR";
			
			double r =	p*2;
			if (r >= 1) {
				sb.append("1");
				p = r - 1;
			}else {
				sb.append("0");
				p=r;
			}
		}
		
		return sb.toString();
	}
}
