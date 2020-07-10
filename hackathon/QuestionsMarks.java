package hackathon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuestionsMarks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(QuestionsMarks.qm("acc?7??sss?3rr1??????5"));
	}
	
	static boolean qm(String str) {
		if (str.length() == 0) return false;
		char[] chs = str.toCharArray();
		boolean found = false;
		ArrayList<Integer> nums = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < chs.length; i++) {
			if (Character.isDigit(chs[i])) {
				int num = Character.getNumericValue(chs[i]);
				map.put(num, i);
				nums.add(num);
			}
		}
		int[] index = new int[2];
		for (int i = 0; i < nums.size(); i++) {
			int com = 10 - nums.get(i);
			if(map.containsKey(com) && map.get(com) != i) {
				found = true;
				index[0] = i;
				index[1] = map.get(com);
				break;
			}
		}
		if(found) {
			// check ??? between str
			int count = 0;
			for (int i = index[0]; i <= index[1]; i++) {
				if(chs[i] == '?')
					count++;
			}
			if(count == 3) return true;
		}
		return false;
	}
	
	

}
