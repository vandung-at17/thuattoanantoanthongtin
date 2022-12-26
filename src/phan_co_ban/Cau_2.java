package phan_co_ban;

import java.util.Scanner;

public class Cau_2 {
	static Scanner sc = new Scanner(System.in);

	public static int kiemTraSoNguyenTo(int x) {
		if (x <= 1) {
			return 0;
		}
		for (int i = 2; i <=Math.sqrt(x); i++) {
			if (x % i == 0) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		System.out.println("Nhập số chữ số cần xét từ bàn phím");
		int N = sc.nextInt();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < N; i++) {
			str.append(9);
		}
		int s = Integer.valueOf(str.toString());
		for (int i = 2; i <= s; i++) {
			int kt = kiemTraSoNguyenTo(i);
			if (kt == 1) {
				System.out.println(i);
			}
		}
	}
}
