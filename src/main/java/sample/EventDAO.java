package sample;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EventDAO {

    private SimpleStringProperty nome;
    private SimpleStringProperty luogo;
    private SimpleStringProperty data;
    private SimpleIntegerProperty capienza;
    private SimpleFloatProperty incasso;
    private SimpleFloatProperty prezzo;
    private SimpleIntegerProperty venduti;
    private SimpleIntegerProperty invenduti;

    public void create(String nome,String luogo,String data,int max_posti,float incasso,float prezzo)
    {
        this.nome=new SimpleStringProperty(nome);
        this.luogo =new SimpleStringProperty(luogo);
        this.data =new SimpleStringProperty(data);
        this.capienza =new SimpleIntegerProperty(max_posti);
        this.incasso =new SimpleFloatProperty(incasso);
        this.prezzo =new SimpleFloatProperty(prezzo);
        this.venduti =new SimpleIntegerProperty((int)(incasso/prezzo));
        this.invenduti =new SimpleIntegerProperty((int)(max_posti-(incasso/prezzo)));
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public String getLuogo() {
        return luogo.get();
    }

    public SimpleStringProperty luogoProperty() {
        return luogo;
    }

    public String getData() {
        return data.get();
    }

    public SimpleStringProperty dataProperty() {
        return data;
    }

    public int getCapienza() {
        return capienza.get();
    }

    public SimpleIntegerProperty capienzaProperty() {
        return capienza;
    }

    public float getIncasso() {
        return incasso.get();
    }

    public SimpleFloatProperty incassoProperty() {
        return incasso;
    }

    public float getPrezzo() {
        return prezzo.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public void setLuogo(String luogo) {
        this.luogo.set(luogo);
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public void setCapienza(int capienza) {
        this.capienza.set(capienza);
    }

    public void setIncasso(float incasso) {
        this.incasso.set(incasso);
    }

    public void setPrezzo(float prezzo) {
        this.prezzo.set(prezzo);
    }

    public void setVenduti(int venduti) {
        this.venduti.set(venduti);
    }

    public void setInvenduti(int invenduti) {
        this.invenduti.set(invenduti);
    }

    public SimpleFloatProperty prezzoProperty() {
        return prezzo;
    }

    public int getVenduti() {
        return venduti.get();
    }

    public SimpleIntegerProperty vendutiProperty() {
        return venduti;
    }

    public int getInvenduti() {
        return invenduti.get();
    }

    public SimpleIntegerProperty invendutiProperty() {
        return invenduti;
    }
}
