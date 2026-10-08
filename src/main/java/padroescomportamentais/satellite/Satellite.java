package padroescomportamentais.satellite;

import java.util.Observable;
import java.util.Observer;

public class Satellite implements Observer {

    private String name;
    private String lastNotification;

    public Satellite(String name) {
        this.name = name;
    }

    public String getLastNotification() {
        return this.lastNotification;
    }

    public void track(Location location) {
        location.addObserver(this);
    }

    public void update(Observable location, Object arg) {
        this.lastNotification = this.name + ": location changed to " + ((Location) location).getStateName();
        // System.out.println(this.lastNotification);
    }
}
