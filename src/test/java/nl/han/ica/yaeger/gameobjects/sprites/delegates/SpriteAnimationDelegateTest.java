package nl.han.ica.yaeger.gameobjects.sprites.delegates;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nl.han.ica.yaeger.resourceconsumer.ResourceConsumer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpriteAnimationDelegateTest implements ResourceConsumer {

    @Mock
    private ImageView imageViewMock;

    @Mock
    private Image imageMock;

//    @Test
//    public void viewPortIsSetOnCreationTest() {
//
//        // Setup
//        when(imageViewMock.getImage()).thenReturn(imageMock);
//        when(imageMock.getWidth()).thenReturn(75d);
//        when(imageMock.getHeight()).thenReturn(32d);
//
//        // Test
//        var spriteAnimationDelegate = new SpriteAnimationDelegate(imageViewMock, 2);
//
//        // Verify
//        verify(imageViewMock).setViewport(any(Rectangle2D.class));
//    }
}
