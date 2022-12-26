package phan_nang_cao;

import java.util.Scanner;

public class Cau_41 {
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

	public static void main(String[] args) {
		System.out.println("Nhập số a:");
		int a = sc.nextInt();
		while (a < 0) {
			System.out.println("Nhập số a>0");
			System.out.println("Nhập lại số a");
			a = sc.nextInt();
		}
		while (a > 1000) {
			System.out.println("Nhập số a<1000");
			System.out.println("Nhập lại số a");
			a = sc.nextInt();
		}
		System.out.println("Nhập số k:");
		int k = sc.nextInt();
		while (k < 0) {
			System.out.println("Nhập số k>0");
			System.out.println("Nhập lại số k");
			k = sc.nextInt();
		}
		while (k > 1000) {
			System.out.println("Nhập số k<1000");
			System.out.println("Nhập lại số k");
			a = sc.nextInt();
		}
		System.out.println("Nhập số n:");
		int n= sc.nextInt();
		while (n<a||n<k) {
			System.out.println("Nhập lại số n");
			n = sc.nextInt();
		}
		if (isPrime(power(a, k, n))) {
			System.out.println("Là Nguyên Tố");
		}else {
			System.out.println("Là Hợp Số");
		}
	}
}
