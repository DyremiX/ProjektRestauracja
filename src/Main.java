import Restauracja.Restauracja;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("zapis.txt");
        Restauracja restauracja1 = null;
        if (file.exists()) {
            System.out.println("Wczytuje dane restauracji z pliku");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            restauracja1 = (Restauracja) objectInputStream.readObject();
            objectInputStream.close();
        }else{
            System.out.println("Tworze nowa restauracje");
            restauracja1 = new Restauracja(1,"Krakow, ul. Kwiatowa 6", "Prawie MCdonlad", 4);
        }

        restauracja1.aktywuj();

        FileOutputStream fileOutputStream = new FileOutputStream("zapis.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(restauracja1);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
