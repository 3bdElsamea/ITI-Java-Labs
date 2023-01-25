class ComplexNumber<T extends Number> {
    private T real;
    private T imag;

    public ComplexNumber(T real, T imag) {
        this.real = real;
        this.imag = imag;
    }

    public T getReal() {
        return real;
    }

    public T getImag() {
        return imag;
    }
}

public class Complex {

    public static void main(String args[]) {
        if (args.length == 4 &&
                args[0].matches("-?\\d+(\\.\\d+)?") && args[1].matches("-?\\d+(\\.\\d+)?") &&
                args[2].matches("-?\\d+(\\.\\d+)?") && args[3].matches("-?\\d+(\\.\\d+)?")) {


        } else {
            System.out.println("Invalid Input");
        }
    }
}
