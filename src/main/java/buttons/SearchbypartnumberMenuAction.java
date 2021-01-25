package buttons;

import menu.MenuAction;

import java.io.IOException;
import java.util.Scanner;
import service.*;


public class SearchbypartnumberMenuAction implements MenuAction {

    CotactsNioServiceFile CotactsNioServiceFile;

    public SearchbypartnumberMenuAction(CotactsNioServiceFile CotactsNioServiceFile) {
        this.CotactsNioServiceFile = CotactsNioServiceFile;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println(CotactsNioServiceFile.getPartsPhone(getchoice()));


    }

    private String getchoice() {
        System.out.println("Введите часть номера телефона");
        return new Scanner(System.in).nextLine();
    }



    @Override
    public String getName() {
        return "Поиск по части номера";

    }

    @Override
    public boolean closeAfter() {
        return false;
    }


}
