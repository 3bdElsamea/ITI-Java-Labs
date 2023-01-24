class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }

}

class ExceptionMethods {
    public void firstMethod(int n) throws MyException {
        if (n == 1)
            throw new MyException("Method 1 Exception");
    }

    public void secondMethod(int n) throws MyException {
        if (n == 2)
            throw new MyException("Method 2 Exception");
    }

    public void thirdMethod(int n) throws MyException {
        if (n == 3)
            throw new MyException("Method 3 Exception");
    }
}

public class CallExceptions {
    // Calling Function
    public static void callMethod(int n) {
        ExceptionMethods exception = new ExceptionMethods();
        try {
            exception.firstMethod(n);
            exception.secondMethod(n);
            exception.thirdMethod(n);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally");
        }
    }

    public static void main(String[] args) {
        callMethod(1);
        callMethod(2);
        callMethod(3);
    }
}
