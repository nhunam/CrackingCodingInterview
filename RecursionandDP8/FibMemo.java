package RecursionandDP8;

public class FibMemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibMemo fib = new FibMemo();
		System.out.println(fib.fibo(7));
		System.out.println(fib.fibdp(7));
	}
	
	int fibo(int n) {
		return fibo(n, new int[n+1]);
	}
	
	int fibo(int i, int[] memo) {
		if (i == 0 || i == 1) return i;
		if(memo[i] == 0) {
			memo[i] = fibo(i-1, memo) + fibo(i-2, memo);
		}
		return memo[i];
	}

	int fibdp(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i < n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		
		return memo[n-1] + memo[n-2];
	}
}
