package service;

import сontacts.Contact;

import java.io.IOException;
import java.util.List;

public interface ContactsServiceFile {

    List<Contact> getAll() throws IOException;
    void remove(Contact contact) throws IOException;
    void add(Contact contact) throws IOException;
    List<Contact> getContactsWhereNameStartsWith(String startOfName) throws IOException;
    List<Contact> getPartsPhone(String startOfName) throws IOException;
    boolean check(Contact contact);

}
