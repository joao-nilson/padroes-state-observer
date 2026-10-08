package padroescomportamentais.satellite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationStateFactoryTest {

    @Test
    void shouldCreateSaoPaulo() {
        LocationState state = LocationStateFactory.create("SP");
        assertTrue(state instanceof LocationStateSP);
        assertEquals("São Paulo", state.getName());
    }

    @Test
    void shouldCreateRioDeJaneiro() {
        LocationState state = LocationStateFactory.create("RJ");
        assertTrue(state instanceof LocationStateRJ);
        assertEquals("Rio de Janeiro", state.getName());
    }

    @Test
    void shouldCreateMinasGerais() {
        LocationState state = LocationStateFactory.create("MG");
        assertTrue(state instanceof LocationStateMG);
        assertEquals("Minas Gerais", state.getName());
    }

    @Test
    void shouldCreateBahia() {
        LocationState state = LocationStateFactory.create("BA");
        assertTrue(state instanceof LocationStateBA);
        assertEquals("Bahia", state.getName());
    }

    @Test
    void shouldIgnoreCase() {
        assertTrue(LocationStateFactory.create("mg") instanceof LocationStateMG);
    }

    @Test
    void shouldReturnTheSameInstance() {
        assertSame(LocationStateFactory.create("SP"), LocationStateFactory.create("SP"));
    }

    @Test
    void shouldThrowExceptionForUnknownState() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> LocationStateFactory.create("XX"));
        assertEquals("State not found", e.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullState() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> LocationStateFactory.create(null));
        assertEquals("State not found", e.getMessage());
    }
}
