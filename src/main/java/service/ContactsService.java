package service;

import сontacts.Contact;

import java.io.IOException;

public interface ContactsService {

    void remove(int contact) throws IOException;
    void add(Contact contact) throws IOException;
    String getContactsWhereNameStartsWith(String startOfName);
    String getPartsPhone(String startOfName);
    boolean check(Contact contact);

}
