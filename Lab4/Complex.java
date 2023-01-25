import java.math.BigDecimal;

class ComplexNumber<T extends BigDecimal> {
    private T real;
    private T imaginary;

    public ComplexNumber(T _real, T _imaginary) {
        this.real = _real;
        this.imaginary = _imaginary;
    }

    public T getReal() {
        return real;
    }

    public T getImag() {
        return imaginary;
    }

    // Adding Method
    public ComplexNumber<T> addComplex(ComplexNumber<T> number) {
        return new ComplexNumber<T>((T) this.real.add(number.real), (T) this.imaginary.add(number.imaginary));
    }

    // Subtracting Method
    public ComplexNumber<T> subtractComplex(ComplexNumber<T> number) {
        return new ComplexNumber<T>((T) this.real.subtract(number.real),
                (T) this.imaginary.subtract(number.imaginary));
    }
}

public class Complex {

    public static void main(String args[]) {
        if (args.length == 4 &&
                args[0].matches("-?\\d+(\\.\\d+)?") && args[1].matches("-?\\d+(\\.\\d+)?") &&
                args[2].matches("-?\\d+(\\.\\d+)?") && args[3].matches("-?\\d+(\\.\\d+)?")) {
            BigDecimal real1 = new BigDecimal(args[0]);
            BigDecimal imaginary1 = new BigDecimal(args[1]);
            BigDecimal real2 = new BigDecimal(args[2]);
            BigDecimal imaginary2 = new BigDecimal(args[3]);

            ComplexNumber<BigDecimal> complex1 = new ComplexNumber<>(real1, imaginary1);
            ComplexNumber<BigDecimal> complex2 = new ComplexNumber<>(real2, imaginary2);

            ComplexNumber<BigDecimal> result = complex1.addComplex(complex2);
            System.out.println("Addition : " + result.getReal() + " + " + result.getImag() + "i");

            result = complex1.subtractComplex(complex2);
            System.out.println("Subtraction : " + result.getReal() + " + " + result.getImag() + "i");
        } else {
            System.out.println("Invalid Input");
        }
    }
}
