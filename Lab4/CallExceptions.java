// Create My Own Exception
// Create a class that extends Exception
// Create a constructor for this class that takes a String argument and stores it inside the object with a String reference
// Create a method that prints out the stored String

// Create a class with a method that throws an exception of the type you just created
// In main(), call the method but place it inside a try-catch clause to catch the exception

// Call the method without using a try-catch clause, and observe the results    
//     }
// }
class MyException extends Exception {
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// class with three methods to call the exception
class ExceptionMethods {
    public void method1() throws MyException {
        throw new MyException("This is method 1");
    }

    public void method2() throws MyException {
        throw new MyException("This is method 2");
    }

    public void method3() throws MyException {
        throw new MyException("This is method 3");
    }
}

// main class that calls the last methods using try , catch and finally
public class CallExceptions {
    public static void main(String[] args) {
        ExceptionMethods exceptionMethods = new ExceptionMethods();
        try {
            exceptionMethods.method1();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("This is finally");
        }
        try {
            exceptionMethods.method2();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("This is finally");
        }
        try {
            exceptionMethods.method3();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("This is finally");
        }
    }
}
