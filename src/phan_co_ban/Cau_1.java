package phan_co_ban;

import java.util.Scanner;

public class Cau_1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Nhập số tự nhiên N:");
		int N= sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int dem = 0;
		    for (int j = 1; j < i; j++) {
				if (i%j==0) {
					dem=dem+1;
				}
			}
		    if (dem==4) {
		    	System.out.print(i+";");
		    }
		}
	}
}
