package buttons;

import сontacts.ContactParser;
import menu.MenuAction;
import service.*;

import java.io.IOException;

public class ReadAllContactsMenuAction implements MenuAction {
    ContactParser contactParser = new ContactParser();

    CotactsNioServiceFile CotactsNioServiceFile;

    public ReadAllContactsMenuAction(
            CotactsNioServiceFile CotactsNioServiceFile) {
        this.CotactsNioServiceFile = CotactsNioServiceFile;
    }

    @Override
    public void doAction() throws IOException {

        for (Object contacts : CotactsNioServiceFile.getAll()) {
            System.out.println(contacts);
        }
    }

    @Override
    public String getName() {
        return "Показать список телефонных номеров";

    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
