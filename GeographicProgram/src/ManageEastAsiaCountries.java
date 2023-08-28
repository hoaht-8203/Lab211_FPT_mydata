import java.util.List;

public class ManageEastAsiaCountries {
    public static void main(String[] args) {
        EastAsiaCountries eastAsiaCountry = new EastAsiaCountries();
        EACountriesList eaCountriesList = new EACountriesList();
        String[] menuOptions = {"Enter the information for 11 countries in Southeast Asia", "Display already information", "Search the country according to the entered country's name", "Display the information increasing with the country name", "Exit"};

        while (true) {
            Menu.printMenu(menuOptions);
            int choice = Menu.getChoiceFromMenu(menuOptions);

            switch (choice) {
                case 1:
                    eaCountriesList.createEastAsiaCountries();
                    break;
                case 2:
                    EastAsiaCountries recentlyEnteredInformation = eaCountriesList.getRecentlyEnteredInformation();
                    eaCountriesList.displayEastAsiaCountries(recentlyEnteredInformation);
                    break;
                case 3:
                    eaCountriesList.getListInformationByName();
                    break;
                case 4:
                    List<EastAsiaCountries> eastAsiaCountriesList = eaCountriesList.sortInformationByAscendingOrder();
                    eaCountriesList.displayListEastAsiaCountries(eastAsiaCountriesList);
                    break;
                case 5: System.exit(0); break;
            }
        }
    }
}
