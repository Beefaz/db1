public class Main {

    public static void main(String[] args) {
	// write your code here
        //String name, String address, String city
        Airport airport = new Airport("Kauno oro uostas", "cepaixxl", "Karmelavoss g.");
        AirportDAO airportDAO = new AirportDAO();
        airportDAO.insert(airport);

        airportDAO.searchByName("Kauno oro uostas");
        //airportDAO.deleteById(1);
        airportDAO.update(airport, 2);
    }
}
