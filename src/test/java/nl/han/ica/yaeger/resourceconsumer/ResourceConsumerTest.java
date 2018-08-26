package nl.han.ica.yaeger.resourceconsumer;

import nl.han.ica.yaeger.exceptions.YaegerResourceNotAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResourceConsumerTest {

    static final String RESOURCE_EXISTING = "images/sprite-with-two-frames.png";
    static final String RESOURCE_NOT_EXISTING = "unavailable.png";

    ResourceConsumer resourceConsumer;

    @BeforeEach
    void setup() {
        resourceConsumer = new ResourceConsumer() {
        };
    }

    @Test
    void unavailableResourceReturnsCorrectException() {
        assertThrows(YaegerResourceNotAvailableException.class,
                () ->
                        resourceConsumer.createPathForResource(RESOURCE_NOT_EXISTING)
        );
    }

    @Test
    void thrownUnavailableResourceExceptionDisplaysCorrectMessage() {
        Throwable exception = assertThrows(YaegerResourceNotAvailableException.class,
                () -> resourceConsumer.createPathForResource(RESOURCE_NOT_EXISTING));

        assertEquals("Resource unavailable.png kan niet worden gevonden. Zorg ervoor dat dit bestand beschikbaar is in de resource/ directory.", exception.getMessage());
    }

    @Test
    void emptyResourceParameterReturnsEmptyString() {
        var path = resourceConsumer.createPathForResource("");

        assertEquals("", path);
    }

    @Test
    void nullResourceParameterReturnsEmptyString() {
        var path = resourceConsumer.createPathForResource(null);

        assertEquals("", path);
    }

    @Test
    void availableResourceReturnsExistingPath() {
        var path = resourceConsumer.createPathForResource(RESOURCE_EXISTING);

        assertTrue(path.startsWith("file:/"));
        assertTrue(path.endsWith(RESOURCE_EXISTING));
    }
}
