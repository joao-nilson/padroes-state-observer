package padroescomportamentais.satellite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void shouldStartInSaoPaulo() {
        assertEquals("São Paulo", new Location().getStateName());
    }

    @Test
    void shouldStartInTheGivenState() {
        assertEquals("Bahia", new Location("BA").getStateName());
    }

    @Test
    void shouldNotCreateLocationWithUnknownState() {
        assertThrows(IllegalArgumentException.class, () -> new Location("XX"));
    }

    // ---- São Paulo: vizinhos: RJ e MG ----

    @Test
    void saoPauloShouldMoveToRioDeJaneiro() {
        Location location = new Location();
        assertTrue(location.moveToRJ());
        assertEquals("Rio de Janeiro", location.getStateName());
    }

    @Test
    void saoPauloShouldMoveToMinasGerais() {
        Location location = new Location();
        assertTrue(location.moveToMG());
        assertEquals("Minas Gerais", location.getStateName());
    }

    @Test
    void saoPauloShouldNotMoveToBahiaOrItself() {
        Location location = new Location();
        assertFalse(location.moveToBA());
        assertFalse(location.moveToSP());
        assertEquals("São Paulo", location.getStateName());
    }

    // ---- Rio de Janeiro: vizinhos: SP e MG ----

    @Test
    void rioDeJaneiroShouldMoveToSaoPauloAndMinasGerais() {
        Location location = new Location();
        location.moveToRJ();
        assertTrue(location.moveToSP());
        assertEquals("São Paulo", location.getStateName());
        location.moveToRJ();
        assertTrue(location.moveToMG());
        assertEquals("Minas Gerais", location.getStateName());
    }

    @Test
    void rioDeJaneiroShouldNotMoveToBahiaOrItself() {
        Location location = new Location();
        location.moveToRJ();
        assertFalse(location.moveToBA());
        assertFalse(location.moveToRJ());
        assertEquals("Rio de Janeiro", location.getStateName());
    }

    // ---- Minas Gerais: vizinhos: SP, RJ e BA ----

    @Test
    void minasGeraisShouldMoveToAllNeighbors() {
        Location location = new Location();
        location.moveToMG();
        assertTrue(location.moveToSP());
        assertEquals("São Paulo", location.getStateName());
        location.moveToMG();
        assertTrue(location.moveToRJ());
        assertEquals("Rio de Janeiro", location.getStateName());
        location.moveToMG();
        assertTrue(location.moveToBA());
        assertEquals("Bahia", location.getStateName());
    }

    @Test
    void minasGeraisShouldNotMoveToItself() {
        Location location = new Location();
        location.moveToMG();
        assertFalse(location.moveToMG());
        assertEquals("Minas Gerais", location.getStateName());
    }

    // ---- Bahia: vizinhos: MG ----

    @Test
    void bahiaShouldMoveToMinasGerais() {
        Location location = new Location();
        location.moveToMG();
        location.moveToBA();
        assertTrue(location.moveToMG());
        assertEquals("Minas Gerais", location.getStateName());
    }

    @Test
    void bahiaShouldNotMoveToSaoPauloRioDeJaneiroOrItself() {
        Location location = new Location();
        location.moveToMG();
        location.moveToBA();
        assertFalse(location.moveToSP());
        assertFalse(location.moveToRJ());
        assertFalse(location.moveToBA());
        assertEquals("Bahia", location.getStateName());
    }

    @Test
    void shouldFollowAFullTrip() {
        Location location = new Location();
        assertTrue(location.moveToRJ());
        assertTrue(location.moveToMG());
        assertTrue(location.moveToBA());
        assertEquals("Bahia", location.getStateName());
    }
}
