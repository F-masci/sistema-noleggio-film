package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.exception.InsertWorkingHoursException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.exception.cli.SelectionNotValidException;
import it.bd.sistema.noleggio.view.OwnerView;

public class OwnerController implements Controller {

    @Override
    public void start() {

        Controller controller;

        while(true) {
            try {
                int selection = OwnerView.printOwnerMenu();

                switch (selection) {
                    case 1 -> controller = new RegisterEmployeeController();
                    case 2 -> controller = new ChangeRoleController();
                    case 3 -> controller = new InsertWorkingHoursController();
                    case 4 -> controller = new MonthlyReportController();
                    case 5 -> controller = new YearlyReportController();
                    default -> throw new SelectionNotValidException();
                }

                controller.start();

            } catch (EscCliException e) {
                return;
            } catch(SelectionNotValidException e) {
                OwnerView.showErrorMessage(e);
            }
        }
    }
}
