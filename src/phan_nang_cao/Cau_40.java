package phan_nang_cao;

import java.util.Scanner;

public class Cau_40 {
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
		System.out.println("Nhập số phần tử của mảng A: ");
		int N = sc.nextInt();
		System.out.println("Nhập mảng A :");
		int A[] = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		int dem = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < j; j++) {
				if (isPrime(gcd(i, j))) {
					dem ++;
				}
			}
		}
		System.out.println("Đáp án");
		System.out.println(dem );
		System.out.println("Hết");
	}
}
