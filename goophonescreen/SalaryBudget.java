/*
 * Give an array of salaries. The total salary has a budget. At the beginning, the total salary of employees is larger than the budget. It is required to find the number k, and reduce all the salaries larger than k to k, such that the total salary is exactly equal to the budget.

Example 1:

Input: salaries = [100, 300, 200, 400], budget = 800
Output: 250
Explanation: k should be 250, so the total salary after the reduction 100 + 250 + 200 + 250 is exactly equal to 800.
You can assume that solution always exists.
 */
package goophonescreen;

public class SalaryBudget {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalaryBudget sb = new SalaryBudget();
		int[] salaries = {100, 100, 500, 300, 200, 400};
		int budget = 1500;
		System.out.println(sb.salaryBudget(salaries, budget));
	}

	public int salaryBudget(int[] salaries, int budget) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < salaries.length; i++) {
			if (salaries[i] < min) min = salaries[i];
			if (salaries[i] > max) max = salaries[i];
		}
		//int mid = 0;
		while (min <= max) {
			int mid = (min + max)/2;
			if (budget == calBudget(salaries, mid)) 
				return mid;
			else 
			if (budget > calBudget(salaries, mid)) {
				min = mid + 1;
			} else
			if (budget < calBudget(salaries, mid)) {
				max = mid - 1;
			}
		}
		return -1;
	}
	
	public int calBudget(int[] salaries, int k) {
		int res = 0;
		for (int i = 0; i < salaries.length; i++) {
			if (salaries[i] > k) res += k;
			else
				res += salaries[i];
		}
		return res;
	}
}
