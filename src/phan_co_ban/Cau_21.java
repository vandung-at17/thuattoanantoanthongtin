package phan_co_ban;

import java.util.Scanner;

public class Cau_21 {
	static Scanner sc = new Scanner(System.in);

	static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	static int sang(int l, int r) {
		int dem = 0;
		int prime[] = new int[r - l + 2];
		for (int i = 0; i <= r - l + 1; i++) {
			prime[i] = 1;
		}
		for (int i = 2; i <= Math.sqrt(r); i++) {
			for (int j = max(i * i, (l + i - 1) / i * i); j <= r; j += i) {
				prime[j - l] = 0;
			}
		}
		for (int i = max(l, 2); i < r; i++) {
			if (prime[i - l] == 1) {
				dem++;
			}
		}
		return dem;
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
		System.out.println("Nhập A :");
		int A = sc.nextInt();
		System.out.println("Nhập B :");
		int B = sc.nextInt();
		System.out.println("Đáp án: ");
		int dem = 0;
		for (int i = A; i <= B; i++) {
			if (isPrime(sang(1, i))==1) {
				dem++;
			}
		}
		System.out.println(dem);
	}
}
