package hackathon;

public class BinaryReversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 4567;
		String str = Integer.toBinaryString(i);
		StringBuilder sb = new StringBuilder(str);
		if (sb.length() <= 8)
			for (int j = 0; j < 8 - sb.length(); j++)
				sb.insert(0, '0');
		else if (sb.length() <= 16)
			for (int j = 0; j < 16 - sb.length(); j++)
				sb.insert(0, '0');
		sb.reverse();
		int res = Integer.parseInt(sb.toString(), 2);
		System.out.println(res);
	}
}
