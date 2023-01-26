
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        // write your answer here
        // The Most populated city of each Continent
        final Predicate<Entry<String, Optional<City>>> isPresent = entry -> entry.getValue().isPresent();
        final BiConsumer<String, Optional<City>> printEntry =
                (k,v) -> {
                    City city = v.get();
                    System.out.println(k + ": City [ name= " + city.getName() + ", population= " + city.getPopulation() + " ]");
                };
        Collector<City, ?, Map<String, Optional<City>>> groupingHighPopulatedCitiesByContinent = Collectors.groupingBy(city -> countryDao.findCountryByCode(city.getCountryCode()).getContinent(), Collectors.maxBy(Comparator.comparing(City::getPopulation)));
        Map<String, Optional<City>> highPopulatedCitiesByContinent = countryDao.findAllCountries()
                .stream()
                .flatMap(country -> country.getCities().stream())
                .collect(groupingHighPopulatedCitiesByContinent);
        highPopulatedCitiesByContinent.forEach(printEntry);
    }

}
