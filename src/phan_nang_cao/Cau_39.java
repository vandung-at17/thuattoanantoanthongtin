package phan_nang_cao;

import java.util.Random;
import java.util.Scanner;

public class Cau_39 {
	static Scanner sc = new Scanner(System.in);

	public static int gcd(int a, int b) {
		if (a == 0 || b == 0) {
			return a + b;
		}
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}

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

	public static void main(String[] args) {
		System.out.println("Nhập số phần tử của mảng A: ");
		int N = sc.nextInt();
		System.out.println("Nhập mảng A :");
		int A[] = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < i; j++) {
				if (isPrime(gcd(A[i], A[j]))) {
					System.out.println("Đáp án:");
					System.out.println("Cặp số " + "(" + A[i] + "," + A[j] + ")");
				}
			}
		}
		System.out.println("Hết");
	}
}
