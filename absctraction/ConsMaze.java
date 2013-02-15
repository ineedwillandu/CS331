package absctraction;

public class ConsMaze {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cons a, b, c, d;
		a = new Cons();
		b = new Cons();
		c = new Cons();
		d = new Cons();
		a.i = 1;
		b.i = 2;
		d.i = 4;
		c.i = 3;
		a.cdr = b;
		b.cdr = c;
		c.cdr = d;
		d.cdr = a;
		
	}

}
