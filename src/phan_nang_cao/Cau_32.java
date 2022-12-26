package phan_nang_cao;

import java.util.Scanner;

public class Cau_32 {
	static Scanner sc = new Scanner(System.in);

	static int power(int x, int y, int mod) {
		if (y == 0)
			return 1;
		int temp = power(x, y / 2, mod) % mod;
		temp = (temp * temp) % mod;
		if (y % 2 == 1)
			temp = (temp * x) % mod;
		return temp;
	}
	
	static int gcd (int m , int n ) {
		if (m>0 && n>0) {
			while (m != n) {
				if (m > n) {
					m = m - n; 
				}else {
					n = n - m;
				}
			}
			if (m == 1) {
				return 1;
			}else {
				return 0;
			}
		}else {
			return 0;
		}
	}
	
	//Thuật toán Euclide mở rộng
	static int tinhd (int e, int phin) {
		int q, r, x, y , x1 = 0 , x2 = 1, y1= 1 , y2 = 0;
		while (e > 0) {
			q = phin / e;
			r = phin % e;
			x = x2 - x1*q;
			y = y2 - y1*q;
			phin = e;
			e= r; 
			x2 = x1;
			y2 = y1;
			x1 = x;
			y1 = y;
		}
		return (y2);
	}
	
	public static void main(String[] args) {
		System.out.println("Nhập số P :");
		int p = sc.nextInt();
		while (p <100 ) {
			p = sc.nextInt();
		}
		System.out.println("Nhập số Q :");
		int q = sc.nextInt();
		while (q> 500) {
			q = sc.nextInt();
		}
		int n = q * p;
		int phin = (p-1)*(q-1);
		System.out.println("Nhập số E :");
		int e = sc.nextInt();
		while (gcd(e, phin)==0) {
			System.out.println("Nhập lại số E :");
			e = sc.nextInt();
		}
		int d = tinhd(e, phin);
		System.out.println("d = "+ d);
		System.out.println("Nhập số SBD :");
		int SBD = sc.nextInt();
		int m =  SBD +123;
		System.out.println("Ta có bản mã c của thông điệp m ,(với m = SBD +123) :");
		int c =  power(m, e, n);
		System.out.println("c = "+ c);
		System.out.println("Giải mã thông điệp thông điệp :");
		m = power(c, d, n);
		System.out.println("m = "+ m);
	}
}
