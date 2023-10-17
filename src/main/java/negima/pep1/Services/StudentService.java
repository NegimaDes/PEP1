package negima.pep1.Services;

import negima.pep1.Repositories.StudentRepository;
import negima.pep1.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    StudentRepository repo;

    public Student save(Student newOne){
        return repo.save(newOne);
    }

    public List<Student> getAll(){
        return (List<Student>) repo.findAll();
    }

    public Student getStudentByRut(String rut){
        return repo.findByRut(rut).orElse(null);
    }
}
