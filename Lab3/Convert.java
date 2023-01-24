import java.util.function.Function;

class CelsiusToFahrenheit implements Function<Double,Double>{
    public Double apply(Double celsius){
        return (celsius * 9 / 5) + 32;
    }
}

public class Convert {

	public static double convertTemperature(double celsius, Function<Integer, Double> converter) {
			return converter.apply(celsius);
	}

    public static void main(String[] args) {
		
		if (args.length == 1){
			
			Function<Integer, Double> celsiusToFahrenheit = new CelsiusToFahrenheit();
			
			System.out.println("Temperature in Fahrenheit : " + convertTemperature(Integer.parseInt(args[0]), celsiusToFahrenheit));
		
		}else{
			System.out.println("You Must Enter a Temperature to Convert");
		}
	}

}
