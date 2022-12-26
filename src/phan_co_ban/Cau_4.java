package phan_co_ban;

import java.util.Scanner;

public class Cau_4 {
	static Scanner sc = new Scanner(System.in);

	public static boolean check(int x) {
		if (x < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Nhập Số A :");
		int A = sc.nextInt();
		System.out.println("Nhập số B :");
		int B = sc.nextInt();
		if (A>0 && B>0) {
			for (int i = A; i <= B ; i++) {
				if (check(i)) {
					System.out.println(i+",");
				}
			}
		}else {
			System.out.println("Nhập A, B là số dương");
		}
	}
}
