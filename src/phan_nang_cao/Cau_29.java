package phan_nang_cao;

import java.util.Scanner;

public class Cau_29 {
	static Scanner sc = new Scanner(System.in);

	static int gcd(int a, int b)
	{
	    if (a < b)
	        return gcd(b, a);
	    if (a % b == 0)
	        return b;
	    return gcd(b, a % b);
	}


	static int power(int x, int y, int mod)
	{
	    if (y == 0)
	        return 1;
	    int temp = power(x, y / 2, mod) % mod;
	    temp = (temp * temp) % mod;
	    if (y % 2 == 1)
	        temp = (temp * x) % mod;
	    return temp;
	}


	static Boolean isCarmichaelNumber(int n)
	{
	    for (int b = 2; b < n; b++) {
	        // Nếu "b" là nguyên tố cùng nhau với n
	        if (gcd(b, n) == 1)
	            // Và pow(b, n-1)%n khác 1,
	            // return false.
	            if (power(b, n - 1, n) != 1)
	                return false;
	    }
	    return true;
	}
	public static void main(String[] args) {
		int N = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (isCarmichaelNumber(i)) {
				sum = sum +i ;
			}
		}
		System.out.println("Dap an : " + sum);
	}
}
