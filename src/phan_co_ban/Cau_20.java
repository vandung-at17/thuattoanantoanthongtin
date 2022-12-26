package phan_co_ban;

import java.util.Scanner;

public class Cau_20 {
	static Scanner sc = new Scanner(System.in);
	static int UocChungLonNhat(int num1, int num2){
		while (num1 != num2) {
            if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
		return num2;
	}
	public static void main(String[] args) {
        System.out.println("Nhập :");
		int M = sc.nextInt();
		int N = sc.nextInt();
		int D = sc.nextInt();
		for (int i = M; i <= N; i++) {
			for (int j = M; j < N; j++) {
				if (UocChungLonNhat(i, j)==D) {
					System.out.println("Đáp án:");
					System.out.println("Số A : " + i);
					System.out.println("Số B : " + j);
				}
			}
		}
	}
}
