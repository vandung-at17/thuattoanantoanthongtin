package phan_co_ban;

import java.util.Scanner;

public class Cau_23 {
	static Scanner sc = new Scanner(System.in);
	static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	static int sang(int l, int r) {
		int sum = 0;
		int prime[] = new int[r - l + 2];
		for (int i = 0; i <= r - l + 1; i++) {
			prime[i] = 1;
		}
		for (int i = 2; i <= Math.sqrt(r); i++) {
			for (int j = max(i * i, (l + i - 1) / i * i); j <= r; j += i) {
				prime[j - l] = 0;
			}
		}
		for (int i = max(l, 2); i <= r; i++) {
			if (prime[i - l] == 1) {
				sum = sum + i;
			}
		}
		return sum;
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
    public static void main(String[] args) {
		System.out.println("Nhập:");
		int A = sc.nextInt();
		int B = sc.nextInt();
		if (isPrime(sang(A,B))) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
