package ikrah.io.springProject.dao;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<T> {
    T save(T t) throws FileNotFoundException;

    List<T> getAll() throws FileNotFoundException;

    Optional<T> findBy(Predicate<T> predicate);
}
