package padroescomportamentais.satellite;

public class LocationStateFactory {

    public static LocationState create(String code) {
        if (code == null) {
            throw new IllegalArgumentException("State not found");
        }
        switch (code.toUpperCase()) {
            case "SP":
                return LocationStateSP.getInstance();
            case "RJ":
                return LocationStateRJ.getInstance();
            case "MG":
                return LocationStateMG.getInstance();
            case "BA":
                return LocationStateBA.getInstance();
            default:
                throw new IllegalArgumentException("State not found");
        }
    }
}
