package Phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration

@RequestMapping(value = "/contacts")
public class PhonebookController {
    private ContactsRepository contactsRepository;

    @Autowired
    public PhonebookController(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List all() {
        return this.contactsRepository.findAll();
    }

    @RequestMapping(value = "/searchByNumber/{number}", method = RequestMethod.GET)
    public List getByNumber(@PathVariable Long number) {
        return this.contactsRepository.findAll().stream().filter(x -> x.getPhoneNo() == number).collect(Collectors.toList());
    }

    @RequestMapping(value = "/searchByName/{name}", method = RequestMethod.GET)
    public List getByName(@PathVariable String name) {
        return this.contactsRepository.findAll().stream().filter(x -> x.getFirstName().equals(name)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/searchByLastName/{lastName}", method = RequestMethod.GET)
    public List getByLastName(@PathVariable String lastName) {
        return this.contactsRepository.findAll().stream().filter(x -> x.getLastName().equals(lastName)).collect(Collectors.toList());
    }
}
