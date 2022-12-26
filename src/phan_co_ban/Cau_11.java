package phan_co_ban;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cau_11 {
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

	public static void main(String[] args) {
		System.out.println("Nhập số nguyên N từ bàn phím");
		int N = sc.nextInt();
		List<Integer> str = sang(1, N);
		int sum = 0;
		for (int i = 0; i < str.size(); i++) {
			sum = sum + str.get(i);
		}
		System.out.println("Đáp án");
		System.out.println(sum);
	}
}
