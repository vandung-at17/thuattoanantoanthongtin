package phan_nang_cao;

import java.util.Random;
import java.util.Scanner;

public class Cau_42 {
	static Scanner sc = new Scanner(System.in);

	// Thuật toán bình phương có lặp
	static int power(int x, int y, int mod) {
		if (y == 0)
			return 1;
		int temp = power(x, y / 2, mod) % mod;
		temp = (temp * temp) % mod;
		if (y % 2 == 1)
			temp = (temp * x) % mod;
		return temp;
	}

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

	static int Fermat_checking (int n , int t) {
		int min = 2;
		int max = n-2;
		Random random = new Random();
		for (int i = 1; i <= t ; i++) {
			int a = random.nextInt(max);
			while (a<min) {
				a = random.nextInt(max);
			}
			int r = power(a, n-1, n);
			if (r !=1 ) {
				return 0;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println("Nhập số a:");
		int a = sc.nextInt();
		while (a < 0) {
			System.out.println("Nhập số a>0");
			System.out.println("Nhập lại số a");
			a = sc.nextInt();
		}
		while (a > 100) {
			System.out.println("Nhập số a<100");
			System.out.println("Nhập lại số a");
			a = sc.nextInt();
		}
		System.out.println("Đáp án");
		for (int p = 1; p < 1000; p++) {
			for (int q = 1; q < 1000; q++) {
				if (isPrime(p)) {
					if (isPrime(q)) {
						if (Fermat_checking(power(a, p, q),3)==1) {
							System.out.println("(a, p, q) :" + "(" + a + "," + p + "," + q + ")");
						}
					}
				}	
			}
		}
	}
}
