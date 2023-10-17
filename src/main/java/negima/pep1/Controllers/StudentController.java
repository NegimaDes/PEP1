package negima.pep1.Controllers;

import negima.pep1.Entities.Student;
import negima.pep1.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping
public class StudentController {
    @Autowired
    StudentService serv;

    @GetMapping
    public String student(){return "new-student";}

    @PostMapping
    public String save(@RequestParam("rut") String rut,
                       @RequestParam("lastnames") String lastnames,
                       @RequestParam("names") String names,
                       @RequestParam("born") LocalDate born,
                       @RequestParam("schoolType") String schoolType,
                       @RequestParam("school") String school,
                       @RequestParam("egress") int egress){
        Student newStudent = new Student(null, rut, lastnames, names, born, schoolType, school, egress);
        serv.save(newStudent);
        return "redirect:/students";
    }

    @GetMapping
    public String listStudents(Model model){
        List<Student> all = serv.getAll();
        model.addAttribute("students", all);
        return "show-students";
    }

}
