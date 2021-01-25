package сontacts;

public class ContactsList {


    Contact[] contacts = new Contact[10];
    int size = 0;

    public Contact[] Contactprint() {

        return contacts;

    }

    public int getSize() {
        return size;
    }

    public void add(Contact p) {


        if (size < contacts.length) {
            contacts[size] = p;

        }

        {
            Contact[] cont = contacts; // получили ссылку на наш массив
            Contact[] bufferpoin = new Contact[cont.length + (cont.length + (cont.length / 2))]; //  вполтора раз больше;
            System.arraycopy(cont, 0, bufferpoin, 0, cont.length); // с помощью копи мы копируем с одного массива
            bufferpoin[bufferpoin.length - 1] = p;
            contacts = bufferpoin;
        }

        size++;
    }


    public void remove(int index) {
        Contact[] poin = contacts; // получили ссылку на наш массив
        Contact[] bufferpoin = new Contact[poin.length - 1];
        System.arraycopy(poin, 0, bufferpoin, 0, index); // копируем ДО нашего элемент
        int countresult = poin.length - 1 - index;
        System.arraycopy(poin, index + 1, bufferpoin, index, countresult);
        System.out.println("Т" + bufferpoin.length);
        contacts = bufferpoin;
        size--;
    }


    public void set(int index, Contact point) {

        if (index >= 0 && index < contacts.length) {
            contacts[index] = point;
        }


    }


}
