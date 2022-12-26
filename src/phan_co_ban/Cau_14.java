package phan_co_ban;

import java.util.Scanner;

public class Cau_14 {
	static Scanner sc = new Scanner(System.in);
	public static boolean isPrime(int n) {
	       if (n <= 1) {
	           return false;
	       }
	       for (int i = 2; i <= Math.sqrt(n); i++) {
	           if (n % i == 0) {
	               return false;
	           }
	       }
	       return true;
	   }
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			if (isPrime(i)) {
				StringBuffer buffer = new StringBuffer(String.valueOf(i));
				Integer x = Integer.valueOf(buffer.reverse().toString());
				int v = (int) Math.cbrt(x);
				if (v*v*v == x) {
					System.out.println(i);
				}
			}
		}
	}
}                                                                 