package phan_co_ban;

import java.util.Scanner;

public class Cau_17 {
	static Scanner sc = new Scanner(System.in);

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
		System.out.println("Nhap ");
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
        for (int x = 0;; x++) {
    		int z = A * x * x + B * x + C;
    		if (x==C) {
    			x++;
    		}
    		if (isPrime(z)) {
    			System.out.println(x);
    			break;
    		}
		}
	}
}
