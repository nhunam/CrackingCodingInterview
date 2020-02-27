/* Leetcode 415 */
package ArrayAndString;

public class AddStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStrings("7123", "4567"));
	}

	public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i1 = num1.length()-1;
        int i2 = num2.length()-1;
        while(i1 >= 0 || i2 >= 0){
            int n1 = (i1 >= 0) ? Character.getNumericValue(num1.charAt(i1)) : 0;
            int n2 = (i2 >= 0) ? Character.getNumericValue(num2.charAt(i2)) : 0;
            sb.insert(0, (n1+n2+carry)%10);
            if(n1+n2+carry >=10)
            	carry = 1;
            else carry = 0;
            i1--;
            i2--;
        }
        if (carry == 1) {
        	sb.insert(0, "1");
        }
        return sb.toString();
    }
}
