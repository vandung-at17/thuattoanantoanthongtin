package phan_co_ban;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cau_12 {
	static Scanner sc = new Scanner(System.in);
	
	// Sàng số nguyên tố 
	static List<Integer> sieve (int n) {
		List<Integer> str = new ArrayList<Integer>();
		int prime[]= new int [n+1];
		for (int i = 0; i < prime.length; i++) {
			prime[i]= 1;
		}
		prime[0] = prime [1]= 0;
		for (int i = 0; i <Math.sqrt(prime.length) ; i++) {
			if (prime[i]==1) {
				for (int j = i*i; j < prime.length; j+=i) {
					prime[j] = 0;
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			if (prime[i]==1) {
				str.add(i);
			}
		}
		return str;
	}
	
	//Kiểm tra số nguyên tố
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
		System.out.println("Nhập số N từ bàn phím:");
		int N = sc.nextInt();
		List<Integer> str = sieve(N);
		for (int i = 0; i < str.size()-4; i++) {
			int sum = 0;
			for (int j = i; j < (i+4) ; j++) {
				sum = sum +str.get(j);
			}
			if (sum < N) {
				if (isPrime(sum)) {
					System.out.println("Đáp án: ");
					for (int j = i; j < (i+4) ; j++) {
						System.out.println(str.get(j));
					}
				}
			}
		}
		System.out.println("Hết");
	}
}
