package service;

import сontacts.Contact;
import сontacts.ContactParser;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InMemoryContactsServiceFile implements ContactsServiceFile {
    ContactParser contactParser = new ContactParser();

    String inputFileName = "Phone book.txt";


    @Override
    public List<Contact> getAll() {
        List<Contact> allContacts=new LinkedList();
        String contact;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            while ((contact = br.readLine()) != null) {
                Contact contact1 = contactParser.stringifyContact(contact);
                allContacts.add(contact1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allContacts;
    }

    @Override
    public void remove(Contact contact) throws IOException {
        List<String> repository = getStrings(contact.name);
        CleanFile();
        PushFile(repository);
    }


    private void CleanFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(inputFileName));
        bw.write(" ");
    }

    private void PushFile(List<String> repository) throws IOException {
        for (String s : repository) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputFileName, true))) {
                bw.write(s + "\n");
            }
        }
    }

    private List<String> getStrings(String cont) {
        String string = cont;
        String contacts = null;

        List<String> repository = new ArrayList();

        System.out.println("То слово которое ввели " + cont);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            while ((cont = br.readLine()) != null) {
                if (cont.contains(string)) {
                    contacts = cont;
                } else {
                    repository.add(cont);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        repository.remove(contacts);
        return repository;
    }


    @Override
    public void add(Contact contact) throws IOException {

        String string = contactParser.stringifyContact(contact);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputFileName, true))) {
            bw.write(string+"\n");
        }
    }

    @Override
    public List<Contact> getContactsWhereNameStartsWith(String startOfName) {
        List<Contact> list = new LinkedList<>();
        String contact;
        String startOfNa = startOfName;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            while ((contact = br.readLine()) != null) {

                if (contact.startsWith(startOfNa)) {
                    Contact contact1 = contactParser.stringifyContact(contact);
                    list.add(contact1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<Contact> getPartsPhone(String startOfphone) {
        List<Contact> list = new LinkedList<>();
        String contact;
        String phone = startOfphone;


        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            while ((contact = br.readLine()) != null) {
                if (contact.contains(phone)) {
                    Contact contact1 = contactParser.stringifyContact(contact);
                    list.add(contact1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


    public boolean check(Contact contact) {
        System.out.println(contact.phone);
        return contact.phone.matches("\\+380\\d{9}");
    }


}
