

import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.WorldMapView;

public class MapView extends Event {
    public WorldMapView worldMapView;
    public SplitPane splitPane;

    /**
     * Function to initialize UI components of MapView to enable for testing.
     * Must be called right after initialization of MapView object
     */
    public void initUIComponents(){
        worldMapView = new WorldMapView();
        splitPane = new SplitPane();
        VBox display = new VBox(new Label("Display Information"));
        splitPane.getItems().add(display);
    }
    public void updateDisplay() {

    }

}
