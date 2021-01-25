package menu;

import service.CotactsNioServiceFile;
import service.InMemoryContactsServiceFile;
import buttons.*;
import сontacts.Contact;
import сontacts.ContactBuffers;
import сontacts.Type;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class Menu {

    public static void main(String[] args) throws IOException {

        CotactsNioServiceFile contactsService = new CotactsNioServiceFile();
       MenuPanel menuPanel = new MenuPanel(
       new AddContactMenuAction(contactsService),
       new ReadAllContactsMenuAction(contactsService),
        new RemoveContactMenuAction(contactsService),
        new Exitprogram(contactsService),
         new SearchbypartnumberMenuAction(contactsService),
        new SearchbeginningnameMenuAction(contactsService));
        menuPanel.starting();



    }




    }


