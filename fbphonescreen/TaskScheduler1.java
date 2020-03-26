/*
 * 
 * 
 */

package fbphonescreen;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tasks = {1, 1, 2, 1};
		int[] tasks2 = {1, 1, 2, 2, 1};
		int[] nums2 = {1,1,2,1,2,2,1,1};
		System.out.println(taskScheduler(nums2, 2));
		System.out.println(totalTime(nums2, 2));
		String s = "abc";
		char[] cs = s.toCharArray(); 
	}
	
	static int taskScheduler(int[] tasks, int interval) {
		if (tasks.length == 0) return 0;
		if (tasks.length == 1) return 1;
		int totalTime = 0, idle = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < tasks.length; i++) {
			if(map.containsKey(tasks[i])) {
				int index = map.get(tasks[i]);
				if (i - index == 1) idle +=2;
				if (i - index == 2) idle +=1;
			}
			map.put(tasks[i], i);
		}
		
		totalTime = tasks.length + idle;
		return totalTime;
	}
	
	public static int totalTime(int[] tasks, int n) {
		  int time = 0;

		  Map<Integer, Integer> map = new HashMap<>();

		  for (int i = 0; i < tasks.length; i++) {
		    int idle = 0;

		    if (map.containsKey(tasks[i])) {
		      int len = time - map.get(tasks[i]);
		      idle = Math.max(n - len, 0);
		    }

		    time += (idle + 1);
		    map.put(tasks[i], time);
		  }

		  return time;
		}

}
