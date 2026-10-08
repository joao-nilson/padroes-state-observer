package padroescomportamentais.satellite;

public class LocationStateBA extends LocationState {

    private LocationStateBA() {};
    private static LocationStateBA instance = new LocationStateBA();
    public static LocationStateBA getInstance() {
        return instance;
    }

    public String getName() {
        return "Bahia";
    }

    public boolean moveToMG(Location location) {
        location.setState(LocationStateFactory.create("MG"));
        return true;
    }
}
