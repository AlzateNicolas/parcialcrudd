package crud;

import java.io.*;
import java.util.*;

public class GafasFileRepository implements GafasRepository {
    private List<Gafas> gafasList;
    private final String FILE_NAME = "gafas.dat";

    public GafasFileRepository() {
        gafasList = new ArrayList<>();
        readFromFile();
    }

    @Override
    public Gafas insert(Gafas gafas) {
        gafasList.add(gafas);
        writeToFile();
        return gafas;
    }

    @Override
    public Gafas delete(int id) {
        Gafas gafas = find(id);
        if (gafas != null) {
            gafasList.remove(gafas);
            writeToFile();
        }
        return gafas;
    }

    @Override
    public Gafas update(Gafas gafas) {
        Gafas oldGafas = find(gafas.getId());
        if (oldGafas != null) {
            oldGafas.setTipo(gafas.getTipo());
            oldGafas.setPrecio(gafas.getPrecio());
            oldGafas.setMarca(gafas.getMarca());
            writeToFile();
        }
        return oldGafas;
    }

    @Override
    public Gafas find(int id) {
        for (Gafas gafas : gafasList) {
            if (gafas.getId() == id) {
                return gafas;
            }
        }
        return null;
    }

    @Override
    public void save(Gafas gafas) {
        // No es necesario implementar esto aquí
    }

    private void readFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                gafasList = (List<Gafas>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(gafasList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
