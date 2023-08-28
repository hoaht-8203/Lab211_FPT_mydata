import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EACountriesList extends ArrayList<EastAsiaCountries> {
    public EACountriesList() {

    }

    public boolean isDuplicateId(String id) {
        for (EastAsiaCountries e : this) {
            if (e.getCountryCode().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void createEastAsiaCountries() {
        String countryCode = "";
        do {
            countryCode = Input.get_nonBlank_str("Enter country code: ");
        } while (isDuplicateId(countryCode));
        String countryName = Input.get_nonBlank_str("Enter country name: ");
        float totalArea = Input.get_float("Enter total Area: ", 0);
        String countryTerrain = Input.get_nonBlank_str("Enter terrain of country: ");
        EastAsiaCountries eastAsiaCountries = new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain);
        addCountryInformation(eastAsiaCountries);
    }

    public void addCountryInformation(EastAsiaCountries country) {
        this.add(country);
        System.out.println("Add new " + country.getCountryCode() + " country success!");
    }

    public EastAsiaCountries getRecentlyEnteredInformation() {
        return this.get(this.size()-1);
    }

    public List<EastAsiaCountries> searchInformationByName(String name) {
        List<EastAsiaCountries> eastAsiaCountriesList = new ArrayList<>();
        for (EastAsiaCountries e : this) {
            if (e.getCountryName().equalsIgnoreCase(name)) {
                eastAsiaCountriesList.add(e);
            }
        }

        return eastAsiaCountriesList;
    }

    public void getListInformationByName() {
        String countryName = Input.get_str("Enter country name to search: ");
        List<EastAsiaCountries> eastAsiaCountriesList = searchInformationByName(countryName);
        displayListEastAsiaCountries(eastAsiaCountriesList);
    }

    public List<EastAsiaCountries> sortInformationByAscendingOrder() {
        this.sort(new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries e1, EastAsiaCountries e2) {
                return e2.getCountryName().compareToIgnoreCase(e1.getCountryName());
            }
        });

        return this;
    }

    public void displayListEastAsiaCountries(List<EastAsiaCountries> eastAsiaCountries) {
        System.out.printf("%-15s %-15s %-15s %-15s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries e : eastAsiaCountries) {
            e.display();
        }
    }

    public void displayEastAsiaCountries(EastAsiaCountries eastAsiaCountries) {
        System.out.printf("%-15s %-15s %-15s %-15s\n", "ID", "Name", "Total Area", "Terrain");
        eastAsiaCountries.display();
    }
}
