package padroescomportamentais.satellite;

public class LocationStateRJ extends LocationState {

    private LocationStateRJ() {};
    private static LocationStateRJ instance = new LocationStateRJ();
    public static LocationStateRJ getInstance() {
        return instance;
    }

    public String getName() {
        return "Rio de Janeiro";
    }

    public boolean moveToSP(Location location) {
        location.setState(LocationStateFactory.create("SP"));
        return true;
    }

    public boolean moveToMG(Location location) {
        location.setState(LocationStateFactory.create("MG"));
        return true;
    }
}
