package hackathon;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inp = {"1, 3, 4, 4, 7, 13", "1, 2, 4, 4, 13, 15"};
		String[] inp1 = {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"};
		FindIntersection fi = new FindIntersection();
		System.out.println(fi.findIntersection(inp));
		System.out.println(fi.findIntersection(inp1));
	}
	
	public String findIntersection(String[] strArr) {
		StringBuilder res = new StringBuilder();
		String str1 = strArr[0];
		String str2 = strArr[1];
		
		String[] arr1 = str1.split(",");
		if(arr1.length > 0)
			for(int i = 0; i < arr1.length; i++) {
				if(str2.indexOf(arr1[i]) != -1)
					res.append(arr1[i]).append(",");
			}
		
		if(res.length() == 0) return "false";
		res.setLength(res.length() - 1);
		return res.toString();
	}

}
