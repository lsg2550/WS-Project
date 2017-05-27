package gui;

import assets.icon.Icon;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Luis
 */
class DisplayStage {

    private final static Stage DISPLAY_STAGE = new Stage();

    protected static void init() {
        DISPLAY_STAGE.getIcons().add(Icon.STAGE_ICON);
        DISPLAY_STAGE.setResizable(true);

        DISPLAY_STAGE.setOnCloseRequest(e -> {
            DISPLAY_STAGE.setScene(null);
            DISPLAY_STAGE.setResizable(true);
        });
    }

    protected static void setResizable(boolean isResizable) { //Some scenes shouldn't be resized, this enables that.
        DISPLAY_STAGE.setResizable(isResizable);
    }

    protected static void setScene(Scene scene) {
        DISPLAY_STAGE.setScene(scene);
    }

    protected static void close() {
        DISPLAY_STAGE.close();
    }

    protected static void show() {
        DISPLAY_STAGE.show();
    }

}
