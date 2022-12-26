package phan_nang_cao;

import java.util.Scanner;

public class Cau_33 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int t, i, j, k, bt, at, qt, xt, yt, rt, xat, xbt, yat, ybt, check, checkb, gt, ct;
		t= i= j= k= bt= at= qt= xt= yt= rt= xat= xbt= yat= ybt= check= checkb= gt= ct= 0;
		System.out.println("Nhap truong huu han 2^t");
		t = sc.nextInt();
		int c[] = new int[10];
		int a[] = new int[10];
		int b[] = new int[10];
		int q[] = new int[10];
		int r[] = new int[10];
		int x[] = new int[10];
		int y[] = new int[10];
		int xa[] = new int[10];
		int xb[] = new int[10];
		int ya[] = new int[10];
		int yb[] = new int[10];
		int v[] = new int[10];
		int g[] = new int[10];

		// Reload
		for (i = 0; i <= 10; i++) {
			a[i] = 0;
			b[i] = 0;
			q[i] = 0;
			r[i] = 0;
			x[i] = 0;
			y[i] = 0;
			xa[i] = 0;
			xb[i] = 0;
			ya[i] = 0;
			yb[i] = 0;
			c[i] = 0;
			v[i] = 0;
			g[i] = 0;
		}
		gt = t;
		for (i = t; i >= 0; i--) {
			System.out.printf("Nhap a[%d]", i);
			a[i] = sc.nextInt();
			g[i] = a[i];
		}
		for (i = t; i >= 0; i--) {
			System.out.printf("Nhap b[%d]", i);
			b[i] = sc.nextInt();
		}
		for (i = 0; i <= 10; i++) {
			if (a[i] == 1)
				at = i;
			if (b[i] == 1)
				bt = i;
		}
		xa[0] = 0;
		xb[0] = 1;
		ya[0] = 1;
		yb[0] = ct = 0;
		xat = xbt = ybt = xt = qt = yt = yat = rt = check = 0;
		checkb = 1;
		while (checkb > 0) {

			for (i = at; i >= bt; i--) {
				q[i - bt] = a[i] * b[bt];
				for (k = i; k >= 0; k--) {
					if ((k - i + bt) >= 0)
						a[k] = a[k] - q[i - bt] * b[k - i + bt];
					else
						a[k] = a[k];
					if (a[k] < 0)
						a[k] = a[k] + 2;
				}
			}

			for (i = 0; i <= 5; i++) {
				if (a[i] == 1)
					at = i;
				if (q[i] == 1)
					qt = i;
			}

			for (i = 0; i <= t; i++) {
				r[i] = a[i];
				if (a[i] == 1)
					rt = i;
			}
			// Ham nhan
			if (xa[xat] == 0) {
				for (i = 0; i <= qt; i++)
					c[i] = 0;
			} else
				for (i = 0; i <= qt; i++) {
					for (j = 0; j <= xat; j++) {
						check = q[i] + xa[j];
						if (check == 2) {
							if (c[i + j] != 1)
								c[i + j] = 1;
							else
								c[i + j] = 0;
						}
					}
				}

			if ((qt + xat) >= gt) // ham so sanh
			{
				ct = qt + xat;
				for (i = ct; i >= gt; i--) {
					v[i - gt] = c[i] * g[gt];
					System.out.printf("\ni=%d gt=%d ct=%d. v[%d]=%d", i, gt, ct, i - gt, v[i - gt]);
					for (k = i; k >= 0; k--) {
						if ((k - i + gt) >= 0)
							c[k] = c[k] - v[i - gt] * g[k - i + gt];
						else
							c[k] = c[k];
						if (c[k] < 0)
							c[k] = c[k] + 2;
					}
				}
			}

			// Ham cong tru
			for (i = 0; i <= t; i++) {
				x[i] = (xb[i] - c[i]) % 2;
				if (x[i] < 0)
					x[i] = x[i] + 2;
			}
			// Reload
			for (i = 0; i <= 5; i++)
				c[i] = 0;
			if (ya[yat] == 0) {
				for (i = 0; i <= qt; i++)
					c[i] = 0;
			} else
				// Ham nhan
				for (i = 0; i <= qt; i++) {
					for (j = 0; j <= yat; j++) {
						check = q[i] + ya[j];
						if (check == 2) {
							if (c[i + j] != 1)
								c[i + j] = 1;
							else
								c[i + j] = 0;
						}
					}
				}

			if ((qt + yat) >= gt) // Dit con me ham so sanh
			{
				ct = qt + yat;
				for (i = ct; i >= gt; i--) {
					v[i - gt] = c[i] * g[gt];
					for (k = i; k >= 0; k--) {
						if ((k - i + gt) >= 0)
							c[k] = c[k] - v[i - gt] * g[k - i + gt];
						else
							c[k] = c[k];
						if (c[k] < 0)
							c[k] = c[k] + 2;
					}
				}
			}

			// Ham cong tru
			for (i = 0; i <= t; i++) {
				y[i] = (yb[i] - c[i]) % 2;
				if (y[i] < 0)
					y[i] = y[i] + 2;
			}

			for (i = 0; i <= bt; i++) {
				a[i] = b[i];
				if (b[i] == 1)
					at = i;
				if (y[i] == 1)
					yt = i;
				if (x[i] == 1)
					xt = i;

			}
			for (i = 0; i <= t; i++) {
				b[i] = r[i];
				if (r[i] == 1)
					bt = i;
			}

			for (i = 0; i <= t; i++) {
				xb[i] = xa[i];
				if (xa[i] == 1)
					xbt = i;
			}

			for (i = 0; i <= t; i++) {
				xa[i] = x[i];
				if (x[i] == 1)
					xat = i;
			}

			for (i = 0; i <= t; i++) {
				yb[i] = ya[i];
				if (ya[i] == 1)
					ybt = i;
			}

			for (i = 0; i <= t; i++) {
				ya[i] = y[i];
				if (y[i] == 1)
					yat = i;
			}

			// Reload
			for (i = 0; i <= 5; i++)
				c[i] = 0;

			if (b[bt] == 1)
				checkb = 1;
			else
				checkb = 0;
		}

		System.out.printf("\nHam y2(%d)=", ybt);
		for (i = ybt; i >= 0; i--) {
			if ((yb[i] == 1) && (i != 0)) {
				System.out.printf("x^%d", i);
				if ((i != 0) && (yb[0] != 0))
					System.out.printf(" + ");
			}
		}
		if (yb[0] == 1)
			System.out.printf("1\n");
	}
}
