package phan_co_ban;

import java.util.Scanner;

public class Cau_3 {
	static Scanner sc = new Scanner(System.in);
	public static int demSoUoc(int x) {
		int dem = 0;
		for (int i = 1; i <= x; i++) {
			if (x%i == 0) {
				dem++;
			}
		}
		return dem;
	}
	public static void main(String[] args) {
		System.out.println("Nhập giá trị của N cần xét:");
		int N = sc.nextInt();
		int k = demSoUoc(N);//số ước nguyên tố của N
	}
}
