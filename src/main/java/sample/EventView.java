package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Label;


public class EventView
{

    private EventController controller;

    private Stage appStage;
    @FXML  private Label messaggio_errore_login;



    public void setStage(Stage stage) {appStage = stage;}
    public void setController(EventController controller){this.controller=controller;}


    public void logOut(ActionEvent actionEvent)
    {
        try
        {
            appStage.close();
            controller.start(new Stage());
        } catch (IOException e) {e.printStackTrace();}
          catch (Exception e)   {e.printStackTrace();}
    }

    public void Autentica(ActionEvent actionEvent)
    {
        try
        {
            controller.Accedi("", "");

            FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("Home.fxml"));

            Parent home = loader.load();
            Scene homescreen = new Scene(home);

            appStage.hide();
            appStage.setX(100);
            appStage.setY(100);
            appStage.setWidth(1000);
            appStage.setHeight(600);
            appStage.setMinWidth(820);
            appStage.setMinHeight(400);

            appStage.setScene(homescreen);
            appStage.show();
            appStage.setTitle("Event Manager 17");

            EventView newview=loader.getController();
            newview.setController(this.controller);
            newview.setStage(this.appStage);
            controller.setVista(newview);
        }
        catch (IOException e) {}//setta messaggio errore}
       catch (Exception e)     {messaggio_errore_login.setText(e.getMessage());}//}

    }
}