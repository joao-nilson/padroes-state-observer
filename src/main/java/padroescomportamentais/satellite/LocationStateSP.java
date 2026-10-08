package padroescomportamentais.satellite;

public class LocationStateSP extends LocationState {

    private LocationStateSP() {};
    private static LocationStateSP instance = new LocationStateSP();
    public static LocationStateSP getInstance() {
        return instance;
    }

    public String getName() {
        return "São Paulo";
    }

    public boolean moveToRJ(Location location) {
        location.setState(LocationStateFactory.create("RJ"));
        return true;
    }

    public boolean moveToMG(Location location) {
        location.setState(LocationStateFactory.create("MG"));
        return true;
    }
}
