package ejercicio7;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Piloto {
    String code;
    int driverid;
    String forename;
    String surname;
    Date dob;
    String nationality;
    int constructorid;
    String url;

    public Piloto(String code, String forename, String surname, Date dob, String nationality, int constructorid) {
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.constructorid = constructorid;
    }
}
