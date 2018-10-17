package sample;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.intellij.ide.ui.EditorOptionsTopHitProvider;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;

import java.io.FileInputStream;
import java.io.IOException;

public class EventController extends Application {

    private EventView                vista;
    private FirebaseDatabase         database_reference;
    private ObservableList<EventDAO> eventi;


    public void setVista(EventView vista) {this.vista = vista;}

    public void Autentica(String user, String password) throws Exception
    {
        FileInputStream serviceAccount = new FileInputStream("target/classes/serviceAccountKey.json");//cerca chiave di servizio

        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))  //prepara le opzioni per accedere
            .setDatabaseUrl("https://tickatme-da8ea.firebaseio.com")
            .build();

        FirebaseApp.initializeApp(options); //fa partire il db
        database_reference=FirebaseDatabase.getInstance();


        //check credenziali per il login

        //riempe observable list
    }

    public ObservableList<EventDAO> getEventi()
    {
       if(eventi!=null) return eventi;
               else{return eventi;}
    }


    public static void main(String[] args) {
        launch(args);
        BasicConfigurator.configure();
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {

        FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("Login.fxml"));
        Parent root = loader.load();

        vista=loader.getController();
        vista.setStage(primaryStage);
        vista.setController(this);

        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 467, 525));
        primaryStage.setMinHeight(450);
        primaryStage.setMinWidth(350);
        primaryStage.getIcons().add(new Image("Logo.png"));

        primaryStage.show();

    }

}
