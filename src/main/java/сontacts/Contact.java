package сontacts;

import lombok.Data;


@Data
public class Contact  {

    public String name;
    public String phone;
    Type type;


public Contact(String name, Type type, String phone) {
        this.name = name;
        this.phone = phone;
        this.type = type;
    }

    public String getName() {
        return name;
    }

}
