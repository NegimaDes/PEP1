package negima.pep1.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Integer rut;
    private String lastnames;
    private String names;
    private LocalDate born;
    private String schoolType;
    private String school;
    private int egress;

    public String rutToString(){
        String rutString = String.valueOf(this.rut);
        while(rutString.length() < 9) {
            rutString = "0" + rutString;
        }
        String part1 = rutString.substring(0,2);
        String part2 = rutString.substring(2,5);
        String part3 = rutString.substring(5,8);
        char checker = rutString.charAt(8);

        return part1 + "." + part2 + "." + part3 + "-" + checker;
    }

}
