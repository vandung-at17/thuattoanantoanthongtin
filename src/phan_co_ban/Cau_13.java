package phan_co_ban;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cau_13 {
	static Scanner sc = new Scanner(System.in);

	static List<Integer> sieve(int n) {
		int prime[] = new int[n + 2];
		for (int i = 0; i < prime.length; i++) {
			prime[i] = 1;
		}
		prime[0] = prime[1] = 0;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (prime[i] == 1) {
				for (int j = i * i; j <= n; j += i) {
					prime[j] = 0;
				}
			}
		}
		List<Integer> str = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			if (prime[i] == 1) {
				str.add(i);
			}
		}
		return str;
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
		System.out.println("Nhập số N :");
		int N = sc.nextInt();
		List<Integer> sda = sieve(N);
		for (Integer integer : sda) {
			System.out.println(integer);
		}
		System.out.println("Đáp Án");
		for (int i = 0; i < sda.size(); i++) {
			for (int j = 0; j < sda.size(); j++) {
				if (isPrime(sda.get(i) + sda.get(j))) {
					if (isPrime(Math.abs(sda.get(i)-sda.get(j)))) {
						System.out.println("("+sda.get(i)+","+sda.get(j)+")");
					}
				}
			}
		}
	}
}
