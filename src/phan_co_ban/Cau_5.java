package phan_co_ban;

import java.util.Scanner;

public class Cau_5 {
	static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	static void sang(int l, int r) {
		int prime[] = new int[r - l + 2];
		for (int i = 0; i <= r - l + 1; i++) {
			prime[i] = 1;
		}
		for (int i = 2; i <= Math.sqrt(r); i++) {
			for (int j = max(i * i, (l + i - 1)/i*i); j <= r; j += i) {
				prime[j - l] = 0;
			}
		}
		for (int i = max(l, 2); i <= r; i++) {
			if (prime[i - l] == 1) {
				System.out.printf("%d ", i);
			}
		}
	}

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Nhập số R L:");
		int l = sc.nextInt();
		int r = sc.nextInt();
		sang(l, r);
	}
}