package com.github.hanyaeger.api.engine.entities.entity.shape.rectangle;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.google.inject.Injector;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RectangleEntityTest {
    private static final Location LOCATION = new Location(37, 37);
    public static final double ARC_HEIGHT = 1d;
    public static final double ARC_WIDTH = 2d;
    public static final double WIDTH = 3d;
    public static final double HEIGHT = 5d;

    private Rectangle rectangle;
    private Injector injector;
    private RectangleEntityImpl sut;

    @BeforeEach
    void setup() {
        rectangle = mock(Rectangle.class);
        injector = mock(Injector.class);

        sut = new RectangleEntityImpl(LOCATION);
    }

    @Test
    void settingValuesAfterDelegateIsSetDelegatesTheValues() {
        // Arrange
        sut.setShape(rectangle);
        sut.init(injector);

        // Act
        sut.setArcHeight(ARC_HEIGHT);
        sut.setArcWidth(ARC_WIDTH);
        sut.setWidth(WIDTH);
        sut.setHeight(HEIGHT);

        // Verify
        verify(rectangle).setVisible(true);
        verify(rectangle).setArcWidth(ARC_WIDTH);
        verify(rectangle).setArcHeight(ARC_HEIGHT);
        verify(rectangle).setWidth(WIDTH);
        verify(rectangle).setHeight(HEIGHT);
    }

    @Test
    void ifRectangleNotYetSetStrokeHeightIsStoredAndSetAtInit() {
        // Arrange

        // Act
        sut.setHeight(HEIGHT);
        sut.setShape(rectangle);
        sut.init(injector);

        // Verify
        verify(rectangle).setHeight(HEIGHT);
    }

    @Test
    void ifRectangleNotYetSetArcWidthIsStoredAndSetAtInit() {
        // Arrange
        sut.setArcWidth(ARC_WIDTH);
        sut.setShape(rectangle);

        // Act
        sut.init(injector);

        // Verify
        verify(rectangle).setArcWidth(ARC_WIDTH);
    }

    @Test
    void ifRectangleNotYetSetArcHeightIsStoredAndSetAtInit() {
        // Arrange
        sut.setArcHeight(ARC_HEIGHT);
        sut.setShape(rectangle);

        // Act
        sut.init(injector);

        // Verify
        verify(rectangle).setArcHeight(ARC_HEIGHT);
    }

    private class RectangleEntityImpl extends RectangleEntity {

        public RectangleEntityImpl(Location initialPosition) {
            super(initialPosition);
        }
    }
}
