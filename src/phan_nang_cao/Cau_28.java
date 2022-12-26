package phan_nang_cao;

import java.util.Scanner;

public class Cau_28 {
	static Scanner sc = new Scanner(System.in);

	static int gcd(int a, int b) {
		if (a < b)
			return gcd(b, a);
		if (a % b == 0)
			return b;
		return gcd(b, a % b);
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

	static Boolean isCarmichaelNumber(int n) {
		if (isPrime(n) == 1 || n < 2) {
			return false;
		}
		for (int b = 2; b < n; b++) {
			// Nếu "b" là nguyên tố cùng nhau với n
			if (gcd(b, n) == 1) {
				// Và pow(b, n-1)%n khác 1,
				// return false.
				if (power(b, n - 1, n) != 1)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Nhập số N : ");
		int N = sc.nextInt();
		int dem = 0;
		for (int i = 0; i < N; i++) {
			if (isCarmichaelNumber(i) == true) {
				System.out.println(i);
				dem++;
			}
		}
		System.out.println("Dap an");
		if (dem == 0) {
			System.out.println("Không tồn tại số");
		} else {
			System.out.println(dem);
		}
	}
}
