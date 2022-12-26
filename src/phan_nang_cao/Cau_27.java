package phan_nang_cao;

import java.util.Scanner;

public class Cau_27 {
	static Scanner sc = new Scanner(System.in);
	static int gcd (int a, int b) {
		if (a== 0||b ==0 ) {
			return a+b;
		}
		while (a != b) {
			if (a>b) {
				a = a-b;
			}else {
				b= b-a;
			}
		}
		return a;
	}
	public static int isPrime(int n) {
		if (n <= 1) {
			return 0;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args) {
		for (int i = 0; i <1000; i++) {
			for (int j = 0; j < i; j++) {
				if (isPrime(gcd(i, j))==1) {
					System.out.println("Cặp số (a,b) = "+ "("+j+","+i+")");
				}
			}
		}
	}
}
