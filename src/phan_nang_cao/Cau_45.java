package phan_nang_cao;

import java.util.Random;
import java.util.Scanner;

public class Cau_45 {
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

	static int miller_rabin(int n, int t) {
		int w = n - 1;
		int s = 0;
		while ((w & 1) == 0) {
			s++;
			w = w / 2;
		}
		int r = w;
		int min = 2;
		int max = n - 2;
		Random random = new Random();
		for (int i = 1; i <= t; i++) {
			int a = random.nextInt(max);
			while (a < min) {
				a = random.nextInt(max);
			}
			int y = power(a, r, n);
			if (y != 1 && y != n - 1) {
				int j = 1;
				while (j <= (s - 1) && y != (n - 1)) {
					y = power(y, 2, n);
					if (y == 1) {
						return 0;
					}
					j = j + 1;
				}
				if (y != n - 1) {
					return 0;
				}
			}
		}
		return 1;
	}

	static String MILLER_RABIN(int n, int t) {
		int w = n - 1;
		int s = 0;
		while ((w & 1) == 0) {
			s++;
			w = w / 2;
		}
		int r = w;
		int min = 2;
		int max = n - 2;
		Random random = new Random();
		for (int i = 1; i <= t; i++) {
			int a = random.nextInt(max);
			while (a < min) {
				a = random.nextInt(max);
			}
			int y = power(a, r, n);
			if (y != 1 && y != n - 1) {
				int j = 1;
				while (j <= (s - 1) && y != (n - 1)) {
					y = power(y, 2, n);
					if (y == 1) {
						return "Hợp Số";
					}
					j = j + 1;
				}
				if (y != n - 1) {
					return "Hợp Số";
				}
			}
		}
		return "Nguyên Tố ";
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
		System.out.println("Nhập số N :");
		int N = sc.nextInt();
		int A []= new int [N];
		System.out.println("Chương trình sinh một mảng số nguyên tố A");
		Random randoms = new Random();
		for (int i = 0; i < N; i++) {
			int phantu = randoms.nextInt(1000);
			while (miller_rabin(phantu, 3)== 0) {
				phantu = randoms.nextInt(1000);
			}
			A[i] = phantu;
		}
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
		int hieu= 999999999;
		for (int i = 0; i < A.length-1; i++) {
			if (hieu > Math.abs(A[i]-A[i+1])) {
				hieu = Math.abs(A[i]-A[i+1]);
			}
		}
		System.out.println("Min nhỏ nhất");
		System.out.println(hieu);
	}
}
