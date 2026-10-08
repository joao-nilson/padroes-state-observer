package padroescomportamentais.satellite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SatelliteTest {

    @Test
    void shouldNotifySatellite() {
        Location location = new Location();
        Satellite satellite = new Satellite("Satellite 1");
        satellite.track(location);
        location.moveToMG();
        assertEquals("Satellite 1: location changed to Minas Gerais", satellite.getLastNotification());
    }

    @Test
    void shouldNotifySatellites() {
        Location location = new Location();
        Satellite satellite1 = new Satellite("Satellite 1");
        Satellite satellite2 = new Satellite("Satellite 2");
        satellite1.track(location);
        satellite2.track(location);
        location.moveToRJ();
        assertEquals("Satellite 1: location changed to Rio de Janeiro", satellite1.getLastNotification());
        assertEquals("Satellite 2: location changed to Rio de Janeiro", satellite2.getLastNotification());
    }

    @Test
    void shouldKeepLastNotificationAfterSeveralMoves() {
        Location location = new Location();
        Satellite satellite = new Satellite("Satellite 1");
        satellite.track(location);
        location.moveToMG();
        location.moveToBA();
        assertEquals("Satellite 1: location changed to Bahia", satellite.getLastNotification());
    }

    @Test
    void shouldNotNotifyWhenMoveIsInvalid() {
        Location location = new Location(); // SP
        Satellite satellite = new Satellite("Satellite 1");
        satellite.track(location);
        location.moveToBA();
        assertNull(satellite.getLastNotification());
    }

    @Test
    void shouldNotNotifySatelliteNotTracking() {
        Location location = new Location();
        Satellite satellite = new Satellite("Satellite 1");
        location.moveToRJ();
        assertNull(satellite.getLastNotification());
    }

    @Test
    void shouldNotifyOnlyTheTrackedLocation() {
        Location location1 = new Location();
        Location location2 = new Location();
        Satellite satellite1 = new Satellite("Satellite 1");
        Satellite satellite2 = new Satellite("Satellite 2");
        satellite1.track(location1);
        satellite2.track(location2);
        location1.moveToRJ();
        assertEquals("Satellite 1: location changed to Rio de Janeiro", satellite1.getLastNotification());
        assertNull(satellite2.getLastNotification());
    }

    @Test
    void shouldStopNotifyingAfterBeingRemoved() {
        Location location = new Location();
        Satellite satellite = new Satellite("Satellite 1");
        satellite.track(location);
        location.moveToRJ();
        location.deleteObserver(satellite);
        location.moveToMG();
        assertEquals("Satellite 1: location changed to Rio de Janeiro", satellite.getLastNotification());
    }
}
