package menu;

import java.io.IOException;
import java.util.Scanner;

public class MenuPanel {


    MenuAction[] menuActions = new MenuAction[6];

    public MenuPanel(MenuAction action1, MenuAction action2,
                     MenuAction action3, MenuAction action4,
                     MenuAction action5, MenuAction action6) {
        menuActions[0] = action1;
        menuActions[1] = action2;
        menuActions[2] = action3;
        menuActions[3] = action4;
        menuActions[4] = action5;
        menuActions[5] = action6;
    }

    public void starting() throws IOException {
        getText();
        while (true) {
            int index = 1;

            for (MenuAction menuActio : menuActions) {
                System.out.println(index + ". " + menuActio.getName());
                index++;
            }
            System.out.println("------------------------------");

            Scanner scanner = new Scanner(System.in);
            int indexs = scanner.nextInt();
            boolean t = menuActions[indexs - 1].closeAfter();
            if (t) {
                break;
            }
            menuActions[indexs - 1].doAction();

        }


    }

    private void getText() {
        System.out.println("Выберите действие :");
    }


}
