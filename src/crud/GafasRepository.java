package crud;

public interface GafasRepository {
    Gafas insert(Gafas gafas);
    Gafas delete(int id);
    Gafas update(Gafas gafas);
    Gafas find(int id);

    void save(Gafas gafas);
}
