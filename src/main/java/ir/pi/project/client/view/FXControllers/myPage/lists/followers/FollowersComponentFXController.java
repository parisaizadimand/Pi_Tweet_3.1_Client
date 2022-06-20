package ir.pi.project.client.view.FXControllers.myPage.lists.followers;

import ir.pi.project.client.listener.EventListener;
import ir.pi.project.client.view.ImageConvertor;
import ir.pi.project.shared.event.myPageEvents.lists.followers.DeleteFollowerEvent;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class FollowersComponentFXController {

    EventListener listener;
    VBox content;
    ImageConvertor imageConvertor=new ImageConvertor();

    @FXML
    AnchorPane pane;

    @FXML
    Label usernameLabel;

    @FXML
    Circle profileCircle;


    public void setListener(EventListener listener) { this.listener = listener; }

    public void setContent(VBox content) {
        this.content = content;
    }


    public void delete(){
        listener.listen(new DeleteFollowerEvent(usernameLabel.getText()));
        content.getChildren().remove(pane);
    }

    public void update(String follower,String imageInByte){
        usernameLabel.setText(follower);
        setProfileImage(imageInByte);
    }

    public void setProfileImage(String imageInString){
        if(!imageInString.equals("empty")) {
            Image image = SwingFXUtils.toFXImage(imageConvertor.toBufferedImage(imageInString), null);
            profileCircle.setFill(new ImagePattern(image));
        }
        else
            profileCircle.setFill(Color.BLACK);
    }

}
