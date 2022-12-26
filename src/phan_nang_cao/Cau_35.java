package phan_nang_cao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Cau_35 {
	static Scanner sc = new Scanner(System.in);

	// Hàm phân tích thành dạng 𝑛 − 1 = 2^s*r
	Map<Integer, Integer> factor(Integer n) {
		Map<Integer, Integer> luu = new HashMap<Integer, Integer>();
		int s = 0;
		while ((n & 1) == 0) {
			s++;
			n = n / 2;
		}
		luu.put(s, n);
		return luu;
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
		System.out.println("Thuật toán kiểm tra xác suất Miller–Rabin");
		System.out.println("Thuật toán MILLER-RABIN(n,t) : ");
		System.out.println("Nhập số n : ");
		int n = sc.nextInt();
		System.out.println("Nhập số t : ");
		int t = sc.nextInt();
		System.out.println("Đáp Án : ");
		System.out.println(MILLER_RABIN(n, t));
	}
}