package service;

import сontacts.Contact;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryContactsService implements ContactsService {

    List<Contact> contactsList = new LinkedList();


    @Override
    public void remove(int index) {
        contactsList.remove(index);

    }

    @Override
    public void add(Contact contact) {
        contactsList.add(contact);
    }

    @Override
    public String getContactsWhereNameStartsWith(String startOfName) {

        String newlistnames = contactsList.stream().map(s -> s.name).
                filter(s->s.startsWith(startOfName)).
                collect(Collectors.joining(", "));

        if(newlistnames.length()>0){
            return newlistnames;
        }

        return null;
    }

    @Override
    public String getPartsPhone(String startOfName) {

        String newlistphone = contactsList.stream().map(s -> s.phone).
                filter(s->s.contains(startOfName)).
                collect(Collectors.joining(", "));

        if(newlistphone.length()>0){
            return newlistphone;
        }

        return null;
    }


    public boolean check(Contact contact) {
        System.out.println(contact.phone);
        return contact.phone.matches("\\+380\\d{9}");
    }


}
