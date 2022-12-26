package phan_nang_cao;

import java.util.Scanner;

public class Cau_31 {
	static Scanner sc = new Scanner(System.in);

	static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	static int sang(int l, int r) {
		int prime[] = new int[r - l + 2];
		for (int i = 0; i <= r - l + 1; i++) {
			prime[i] = 1;
		}
		for (int i = 2; i <= Math.sqrt(r); i++) {
			for (int j = max(i * i, (l + i - 1) / i * i); j <= r; j += i) {
				prime[j - l] = 0;
			}
		}
		int sum = 0;
		for (int i = max(l, 2); i <= r; i++) {
			if (prime[i - l] == 1) {
				sum = 0;
				sum = sum + i;
			}
		}
		return sum;
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
    public static int check (int lt , int masv) {
    	int ch = masv+ (masv-lt);
    	for (int i = masv; i < ch; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
    	return lt;
    }
    
    static long power(int x, int y, int mod)
	{
	    if (y == 0)
	        return 1;
	    long temp = (long)(power(x, y / 2, mod) % mod);
	    temp = (temp * temp) % mod;
	    if (y % 2 == 1)
	        temp = (temp * x) % mod;
	    return temp;
	}
	public static void main(String[] args) {
		System.out.println("Nhập mã sinh viên");
		int masv = sc.nextInt();
		System.out.println(check(sang(1, masv), masv));
		System.out.println("Nhập số báo danh SBD");
		int SBD = sc.nextInt();
		System.out.println("Đáp án");
		System.out.println(power(SBD, check(sang(1, masv), masv), 123456));
	}
}
