import java.util.function.Function;


class Coefficients {
    private double a;
    private double b;
    private double c;

    public Coefficients(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}

class Roots {
    private double root1;
    private double root2;

    public Roots(double root1, double root2) {
        this.root1 = root1;
        this.root2 = root2;
    }

    public double getRoot1() {
        return root1;
    }

    public double getRoot2() {
        return root2;
    }
}

class QuadraticFunction implements Function<Coefficients, Roots> {
	public Roots apply(Coefficients coefs){
		double a = coefs.getA();
		double b = coefs.getB();
		double c = coefs.getC();
		double discriminant = b * b - 4 * a * c;
		if (discriminant < 0) {
			return new Roots(Double.NaN, Double.NaN);
		} else {
			double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
			double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
			return new Roots(root1, root2);
		}
		
	}
}
 
public class SquareRoot {

	public static Roots calcRoots(Coefficients coefs, Function<Coefficients, Roots> quadraticFunction) {
			return quadraticFunction.apply(coefs);
	}
    public static void main(String[] args) {
		if (args.length==3) {
			Coefficients quadratic = new Coefficients(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			System.out.println("Real roots: " + calcRoots(quadratic,new QuadraticFunction()).getRoot1() + " and " + calcRoots(quadratic,new QuadraticFunction()).getRoot2());
		}
		else{
			System.out.println("You Must Enter the Roots as Arguments in the following Order a b c");
		}
    }
}


