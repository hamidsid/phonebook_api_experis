package Phonebook;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertXML_TO_JSON {


    /**
     * Starts the process of Parsing contact details from the provided XML file to JSON format.
     *
     * @return the list of contacts in JSON format.
     */

    public List<Contact> parseEmployeesXML() throws ParserConfigurationException, SAXException, IOException {

        //Initialize a list of contacts
        List<Contact> contacts = new ArrayList<Contact>();
        Contact contact = null;

        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //calls the private method to chose the xml file
        String xmlFile = ConvertXML_TO_JSON.chooseFile();

        //Build Document
        Document document = builder.parse(new File(xmlFile));

        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

        //Get all contacts
        NodeList nList = document.getElementsByTagName("contact");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                //Create new Contact Object
                contact = new Contact();
                contact.setId(Integer.parseInt(eElement.getAttribute("id"))); //returns specific attribute
                contact.setFirstName(eElement.getElementsByTagName("FirstName").item(0).getTextContent());
                contact.setLastName(eElement.getElementsByTagName("LastName").item(0).getTextContent());
                contact.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
                contact.setPhoneNo(Long.parseLong(eElement.getElementsByTagName("phoneNo").item(0).getTextContent()));

                //Add contact to list
                contacts.add(contact);
            }
        }
        return contacts;
    }


    public List<Contact> getAllContacts() throws IOException, SAXException, ParserConfigurationException {
        return parseEmployeesXML();
    }

    /**
     * Opens a window dialog for the user to chose the demanded XML file which contains contact details
     *
     * @return The string which is the name of the file that the user has chosen.
     */
    private static String chooseFile() {
        FileDialog dialog = new FileDialog((Dialog) null, "Select XML file which contains phone book information");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        dialog.dispose();
        return dialog.getFile();
    }
}