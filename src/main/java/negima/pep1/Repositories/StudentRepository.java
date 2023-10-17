package negima.pep1.Repositories;

import negima.pep1.Entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    Optional<Student> findByRut(String rut);
}
