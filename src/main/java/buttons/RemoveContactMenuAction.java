package buttons;

import java.io.*;

import сontacts.Contact;
import сontacts.ContactParser;
import menu.MenuAction;
import service.*;


public class RemoveContactMenuAction implements MenuAction {

    ContactParser contactParser = new ContactParser();

    CotactsNioServiceFile CotactsNioServiceFile;

    public RemoveContactMenuAction(CotactsNioServiceFile CotactsNioServiceFile) {
        this.CotactsNioServiceFile = CotactsNioServiceFile;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println("Введите контакт который желаете удалить");
        BufferedReader nam =  new  BufferedReader ( new InputStreamReader(System.in)); // get data
        String name = nam.readLine();
        String contact;
        try (BufferedReader br = new BufferedReader(new FileReader("Phone book.txt"))) {
            while ((contact = br.readLine()) != null) {

                if(contact.contains(name)){
                    Contact contact1 = contactParser.stringifyContact(contact);
                    CotactsNioServiceFile.remove(contact1);
                }
            }

        }

    }



    @Override
    public String getName() {
        return "Удалить контакт";

    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
