package phan_nang_cao;

import java.util.Random;
import java.util.Scanner;

public class Cau_34 {
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

	static String Fermat_checking (int n , int t) {
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
				return "Hợp số";
			}
		}
		return "Nguyên tố";
	}
	public static void main(String[] args) {
		System.out.println("thuật toán kiểm tra số nguyên tố Fermat");
		System.out.println("Thuật toán kiểm tra Fermat(n , t)");
		System.out.println("Nhập số n :");
		int n = sc.nextInt();
		System.out.println("Nhập số t :");
		int t = sc.nextInt();
		System.out.println(Fermat_checking(n, t));
	}
}
