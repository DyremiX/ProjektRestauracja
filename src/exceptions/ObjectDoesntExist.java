package exceptions;

public class ObjectDoesntExist extends Exception{
    public ObjectDoesntExist(int n){
        super("Ekran/Przycisk o takim numerze nie istnieje!");
    }
}
