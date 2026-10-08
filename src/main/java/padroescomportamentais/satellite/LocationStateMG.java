package padroescomportamentais.satellite;

public class LocationStateMG extends LocationState {

    private LocationStateMG() {};
    private static LocationStateMG instance = new LocationStateMG();
    public static LocationStateMG getInstance() {
        return instance;
    }

    public String getName() {
        return "Minas Gerais";
    }

    public boolean moveToSP(Location location) {
        location.setState(LocationStateFactory.create("SP"));
        return true;
    }

    public boolean moveToRJ(Location location) {
        location.setState(LocationStateFactory.create("RJ"));
        return true;
    }

    public boolean moveToBA(Location location) {
        location.setState(LocationStateFactory.create("BA"));
        return true;
    }
}
