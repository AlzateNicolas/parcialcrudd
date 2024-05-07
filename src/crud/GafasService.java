package crud;

public class GafasService {
    private GafasRepository repository;

    public GafasService(GafasRepository repository) {
        this.repository = repository;
    }

    public Gafas createGafas(int id, String tipo, double precio, String marca) {
        // Validar los datos de entrada (por ejemplo, asegurarse de que el ID no esté duplicado)
        Gafas gafas = new Gafas(id, tipo, precio, marca);
        try {
            return repository.insert(gafas); // Lógica para insertar las gafas en la base de datos
        } catch (Exception e) {
            // Manejar excepciones (por ejemplo, registro duplicado)
            return false;
        }
    }

    public Gafas findGafas(int id) {
        try {
            return repository.find(id); // Lógica para buscar las gafas por ID
        } catch (Exception e) {
            // Manejar excepciones (por ejemplo, gafas no encontradas)
            return null;
        }
    }

    public boolean deleteGafas(int id) {
        try {
            return repository.delete(id); // Lógica para eliminar las gafas por ID
        } catch (Exception e) {
            // Manejar excepciones (por ejemplo, gafas no encontradas)
            return false;
        }
    }

    public boolean updateGafas(int id, String tipo, double precio, String marca) {
        // Validar los datos de entrada
        Gafas gafas = new Gafas(id, tipo, precio, marca);
        try {
            return repository.update(gafas); // Lógica para actualizar las gafas por ID
        } catch (Exception e) {
            // Manejar excepciones (por ejemplo, gafas no encontradas)
            return false;
        }
    }
}
