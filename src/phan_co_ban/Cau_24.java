package phan_co_ban;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cau_24 {
	static Scanner sc = new Scanner(System.in);

	static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	static List<Integer> sang(int l, int r) {
		List<Integer> str = new ArrayList<Integer>();
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
				str.add(i);
			}
		}
		return str;
	}

	static boolean xetChinhPhuong(int n) {
		int x = (int) Math.sqrt(n);
		int y = n - x * x;
		if (y == 0) {
			return true;
		} else {
			int z = (int) Math.sqrt(y);
			if ((y - z * z) != 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static void main(String[] args) {
		int A = sc.nextInt();
		int B = sc.nextInt();
		List<Integer> str = sang(A, B);
		int dem = 0;
        for (Integer integer : str) {
			if (xetChinhPhuong(integer)) {
				dem++;
				System.out.println(dem);
			}
		}
	}
}
