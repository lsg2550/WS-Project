package gui;

import assets.icon.Icon;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Luis
 */
class DisplayAbout {

    private static Scene scene;

    protected static void init() {
        //Root
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        //Node - Column - Row
        ImageView imageView = new ImageView(Icon.STAGE_ICON);
        imageView.setFitHeight(32.0);
        imageView.setFitWidth(32.0);
        Text info = new Text("Made by Luis"
                + "\nGitHub: @lsg2550"
                + "\nCurrent OS: " + System.getProperty("os.name"));
        info.setTextAlignment(TextAlignment.CENTER);

        //Children
        root.getChildren().addAll(imageView, info);
        scene = new Scene(root, 100, 100);
    }

    protected static Scene getScene() {
        return scene;
    }
}
