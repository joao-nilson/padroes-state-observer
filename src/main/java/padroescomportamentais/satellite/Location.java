package padroescomportamentais.satellite;

import java.util.Observable;

public class Location extends Observable {

    private LocationState state;

    public Location() {
        this("SP");
    }

    public Location(String stateCode) {
        this.state = LocationStateFactory.create(stateCode);
    }

    public void setState(LocationState state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }

    public boolean moveToSP() {
        return state.moveToSP(this);
    }

    public boolean moveToRJ() {
        return state.moveToRJ(this);
    }

    public boolean moveToMG() {
        return state.moveToMG(this);
    }

    public boolean moveToBA() {
        return state.moveToBA(this);
    }

    public String getStateName() {
        return state.getName();
    }
}
