package padroescomportamentais.satellite;

public abstract class LocationState {

    public abstract String getName();

    public boolean moveToSP(Location location) {
        return false;
    }

    public boolean moveToRJ(Location location) {
        return false;
    }

    public boolean moveToMG(Location location) {
        return false;
    }

    public boolean moveToBA(Location location) {
        return false;
    }
}
