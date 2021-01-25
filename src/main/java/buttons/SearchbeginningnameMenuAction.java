package buttons;

import java.io.IOException;
import java.util.Scanner;

import menu.MenuAction;
import service.*;



public class SearchbeginningnameMenuAction implements MenuAction {

    CotactsNioServiceFile CotactsNioServiceFile;

    public SearchbeginningnameMenuAction(CotactsNioServiceFile CotactsNioServiceFile) {
        this.CotactsNioServiceFile = CotactsNioServiceFile;
    }

    @Override
    public void doAction() throws IOException {

        System.out.println(CotactsNioServiceFile.getContactsWhereNameStartsWith(getchoice()));

    }

    private String getchoice() {
        System.out.println("Введите часть имени для поиска");
        return new Scanner(System.in).nextLine();
    }

    private boolean checkname(String name, String choice) {

        return name.startsWith(choice);

    }

    @Override
    public String getName() {
        return "Поиск по началу имени";

    }

    @Override
    public boolean closeAfter() {
        return false;
    }

}
