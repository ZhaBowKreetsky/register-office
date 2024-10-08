package register.dao;

import org.junit.Test;
import register.domain.Person;
import register.domain.PersonFemale;
import register.domain.PersonMale;

import java.util.List;

import static org.junit.Assert.*;

public class PersonDaoTest {

    @Test
    public void findPersons() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();

        persons.forEach(p -> {
            System.out.println("Name: " + p.getFirstName());
            System.out.println("Class Name: " + p.getClass().getName());
            System.out.println("Passport: " + p.getPassports().size());
            System.out.println("Birth Certificate: " + p.getBirthCertificate());
            if (p instanceof PersonMale) {
                System.out.println("Birth Certificates: " + ((PersonMale)p).getBirthCertificates().size());
                System.out.println("Marriage Certificates: " +  ((PersonMale)p).getMarriageCertificates().size());
            } else {
                System.out.println("Birth Certificates: " +  ((PersonFemale)p).getBirthCertificates().size());
                System.out.println("Marriage Certificates: " +  ((PersonFemale)p).getMarriageCertificates().size());
            }
        });
    }
}