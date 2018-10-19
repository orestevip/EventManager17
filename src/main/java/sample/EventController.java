package sample;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
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
import java.util.ArrayList;

import static org.apache.batik.svggen.font.table.GlyfDescript.repeat;


public class EventController extends Application
{
    private EventView                vista;
    private FirebaseDatabase         database_reference=null;
    private ObservableList<EventDAO> eventi;



    public void setVista(EventView vista) {this.vista = vista;}

    public void Accedi(String user, String password ) throws Exception
    {

        if(database_reference==null)
        {

            org.apache.log4j.BasicConfigurator.configure();
            FileInputStream serviceAccount = new FileInputStream("target/classes/serviceAccountKey.json");//cerca chiave di servizio

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))  //prepara le opzioni per accedere
                    .setDatabaseUrl("https://tickatme-da8ea.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options); //fa partire il db
            database_reference = FirebaseDatabase.getInstance();

        }




        DatabaseReference user_ref=database_reference.getReference();


        /*user_ref.child("").addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
            public void onDataChange(DataSnapshot dataSnapshot)
         {

                boolean found=false;

                for (DataSnapshot ds : dataSnapshot.getChildren())
                if (ds.child("username").getValue(String.class).equals(user) && ds.child("password").getValue(String.class).equals(password))found=true;

                //if (found ==false)
            }
         @Override
            public void onCancelled(DatabaseError databaseError) {}
        });*/


            //non funziona perchè va in asyncrono



                //check credenziali per il login

        //riempe observable list
    }

    public ObservableList<EventDAO> getEventi()
    {
       if(eventi!=null) return eventi;
               else{return eventi;}
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

    public static void main(String[] args) {
        launch(args);
        BasicConfigurator.configure();
    }
}
