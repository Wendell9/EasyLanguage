import java.util.Scanner;
public class MainClass{ 
public static void write(String a) {
	System.out.println(a);
}

public static double soma(double a, double b) {
	double resultado;
	resultado = a+b;
	return resultado;
}

	public static void main(String args[]) {
				double x;
		x = soma(1, 2);
		write("oi");
		System.out.println(x);

	}
}
