package сontacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactParser {


    public Contact stringifyContact(String contact) {
        Contact contact1 = null;
        String contacts = contact;
        Pattern pattern = Pattern.compile("([а-яА-я]+)().+(\\+380\\d{9})");
        Matcher matcher = pattern.matcher(contacts);
        while (matcher.find()) {
            contact1 = new Contact(matcher.group(1), Type.PHONE, matcher.group(3));
        }
        return contact1;
    }


    public String stringifyContact(Contact contact){
        String name = contact.name;
        String phone = contact.phone;
        return name + " [" + "type" + " :" + phone + "],"+"\n";

    }








}
