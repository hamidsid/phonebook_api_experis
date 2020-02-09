package Phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private ContactsRepository contactsRepository;

    @Autowired
    public DatabaseSeeder(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //this list of contacts should come from xml parsed
        ConvertXML_TO_JSON allContacts = new ConvertXML_TO_JSON();
        List<Contact> contacts;
        contacts = allContacts.getAllContacts();

        //store all contacts parsed from XML to repository
        contactsRepository.saveAll(contacts);
    }
}
