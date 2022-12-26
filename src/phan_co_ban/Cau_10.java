package phan_co_ban;

import java.util.Scanner;

public class Cau_10 {
	static Scanner sc = new Scanner(System.in);

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
		System.out.println("Số cần nhập N");
		int N = sc.nextInt();
		int demngto = 0;
		int dem = 0;
		for (int i = 1; i <= N; i++) {
			// nếu number chia hết cho i thì in i ra màn hình
			if (N % i == 0) {
				dem++;
				if (isPrime(i) == 1) {
					demngto++;
				}
			}
		}
		System.out.println("Số ước nguyên của N " + dem);
		System.out.println("Số ước nguyên tố của N "+ demngto);
	}
}
