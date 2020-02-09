package Phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class PhonebookApplication {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        //initialize the process of parsing from XML to JSON
        ConvertXML_TO_JSON xmlContacts = new ConvertXML_TO_JSON();
        xmlContacts.parseEmployeesXML();

        //start the spring application api
        SpringApplication.run(PhonebookApplication.class, args);
    }

}
