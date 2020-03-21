/* Leetcode 415 but the string can be decimal */
package ArrayAndString1;

public class AddStrings2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "19.92";
		String num2 = "99.123";
		System.out.println(addStrings(num1, num2));
	}
	public static String addStrings(String num1, String num2) {
		String intpart1 = "", fracpart1 ="", intpart2="", fracpart2="";
		if(num1.split("\\.").length > 0) {
			intpart1 = num1.split("\\.")[0];
			fracpart1 = num1.split("\\.")[1];
		}else {
			intpart1 = num1;
		}
		
		if(num2.split("\\.").length > 0) {
			intpart2 = num2.split("\\.")[0];
			fracpart2 = num2.split("\\.")[1];
		}else {
			intpart2 = num2;
		}
		StringBuilder result = new StringBuilder();
		
		// add Fraction part
		if(fracpart1 == "" && fracpart2 == "")
			result.append(addInt(intpart1, intpart2, 0));
		else {
			if (fracpart1 == "") {
				result.append(fracpart2);
				result.insert(0, '.');
				result.insert(0, addInt(intpart1, intpart2, 0));
			}
			else if (fracpart2 == "") {
				result.append(fracpart1);
				result.insert(0, '.');
				result.insert(0, addInt(intpart1, intpart2, 0));
			}
			else {
				int maxLen = (fracpart1.length() >= fracpart2.length()) ? fracpart1.length() : fracpart2.length();
				int i = maxLen - 1;
				int carry = 0;
				while (i >=0) {
					int f1 = (i < fracpart1.length()) ? (fracpart1.charAt(i)-'0') : 0;
					int f2 = (i < fracpart2.length()) ? (fracpart2.charAt(i)-'0') : 0;
					result.insert(0, (f1+f2+carry)%10);
					carry = (f1+f2+carry)/10;
					i--;
				}
				
				result.insert(0, ".");
				result.insert(0, addInt(intpart1, intpart2, carry));
			}
				
		}
		return result.toString();
	}
	
	static String addInt(String num1, String num2, int carry) {
		StringBuilder sb = new StringBuilder();
        int i1 = num1.length()-1;
        int i2 = num2.length()-1;
        while(i1 >= 0 || i2 >= 0){
            int n1 = (i1 >= 0) ? num1.charAt(i1) - '0' : 0;
            int n2 = (i2 >= 0) ? num2.charAt(i2) - '0' : 0;
            sb.insert(0, (n1+n2+carry)%10);
            carry = (n1+n2+carry)/10;
            i1--;
            i2--;
        }
        if (carry == 1) {
        	sb.insert(0, "1");
        }
        return sb.toString();
	}
	
	
}
