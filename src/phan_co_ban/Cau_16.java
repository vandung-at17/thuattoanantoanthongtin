package phan_co_ban;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cau_16 {
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
		System.out.println("Nhập N ");
		int N = sc.nextInt();
		List<Integer> str = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			int n = random.nextInt(30);
            str.add(n);
		} 
		for (Integer integer : str) {
			System.out.println(integer);
		}
		System.out.println("Đáp án:");
		for (Integer integer : str) {
			if (isPrime(integer)) {
				System.out.println(integer);
			}
		}
	}
}
