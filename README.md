# A simple spring boot api as a test case for experis
 This is a simple sprint boot api which would parse a XML file that contains contact details to JSON format.


## Getting Started
Once the application started running it would ask the user to chose which file he or she wants to select.
(Note: the xml file source should be already added to the root of the application). After the selection of the file 
the application will parse the xml file to Json and the output can be found in Json format as http api on address
http://localhost:8080/contacts/all


### Prerequisites
JDK, JVM and a IDE of the choise to run the sprint boot api application.


  
Sample input:
```
phonebook.xml file is arealdy included as a sample. Choose this file once window opens for file choser.


phonebook.xml:

<PhoneBook>
    <contact id="111">
        <FirstName>Hamid</FirstName>
        <LastName>Chilton</LastName>
        <email>Chilton@gmail.com</email>
        <phoneNo>0734556655</phoneNo>
    </contact>
    <contact id="222">
        <FirstName>Maria</FirstName>
        <LastName>Persson</LastName>
        <email>persson@gmail.com</email>
        <phoneNo>07554566</phoneNo>
    </contact>
    <contact id="333">
        <FirstName>Micheal</FirstName>
        <LastName>Clark</LastName>
        <email>clark@gmail.com</email>
        <phoneNo>07334567890</phoneNo>
    </contact>
</PhoneBook>


```
Sample output:
```
go to http://localhost:8080/contacts/all

the sample output of contacts in Json would be as following: 

[{"id":111,"firstName":"Hamid","lastName":"Chilton","email":"Chilton@gmail.com","phoneNo":734556655},
{"id":222,"firstName":"Maria","lastName":"Persson","email":"persson@gmail.com","phoneNo":7554566},
{"id":333,"firstName":"Micheal","lastName":"Clark","email":"clark@gmail.com","phoneNo":7334567890}]

## Built With
* IntelliJ IDEA - for development.

## Author

Hamid SIDDIQI


## Versioning

Only one version right now available now.


## Acknowledgments

* StackOverFlow, github, etc..
