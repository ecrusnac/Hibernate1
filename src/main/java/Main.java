import model.Person;
import model.Hobbies;
import service.PersonService;
import service.HobbyService;

public class Main {

    public static void main(String[] args) {

        PersonService personService = new PersonService();
        HobbyService hobbyService = new HobbyService();

//        Person user = personService.findById(1);
//        Hobbies role = hobbyService.findById(1);

        System.out.println("All persons");
        personService.findById(1);
        System.out.println("All hobbies");
        //hobbyService.findAll();

    }
}
