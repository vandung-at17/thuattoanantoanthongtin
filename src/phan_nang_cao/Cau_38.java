package phan_nang_cao;

import java.util.Scanner;

public class Cau_38 {
	 static Scanner sc = new Scanner(System.in);

	    private static int Euclide_morong(int n, int p) {
	        int x2 = 1, x1 = 0, y2 = 0, y1 = 1;
	        int a = n,b = p;
	        while (b > 0) {
	            // π β π/π , π β π β ππ, π₯ β π₯2 β ππ₯1 , π¦ β π¦2 β ππ¦1
	            int q = a / b;
	            int r = a % b;
	            int x = x2 - q * x1;
	            int y = y2 - q * y1;
	            // π β π, π β π, π₯2 β π₯1 , π₯1 β π₯, π¦2 β π¦1 , π¦1 β π¦
	            a = b;
	            b = r;
	            x2 = x1;
	            x1 = x;
	            y2 = y1;
	            y1 = y;
	        }

	        // truong hop x2 nho hon 0 cong voi b den khi duong thi thoi
	        // while (x2 < 0) {
	        //     x2 = x2 + p;
	        // }

	        return x2;
	    }
	    public static void main(String[] args) {
			System.out.println("NhαΊ­p sα» a :");
			int a = sc.nextInt();
			System.out.println("NhαΊ­p sα» p");
			int p = sc.nextInt();
			System.out.println("ΔΓ‘p Γ‘n: ");
			System.out.println(Euclide_morong(a, p));
		}
}
