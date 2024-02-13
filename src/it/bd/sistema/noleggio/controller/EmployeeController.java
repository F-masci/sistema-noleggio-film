package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.exception.cli.SelectionNotValidException;
import it.bd.sistema.noleggio.view.EmployeeView;

public class EmployeeController implements Controller {

    @Override
    public void start() {

        Controller controller;

        while(true) {
            try {
                int selection = EmployeeView.printEmployeeMenu();

                switch (selection) {
                    case 1 -> controller = new ClockInOutController();
                    case 2 -> controller = new WorkingHoursListController();
                    default -> throw new SelectionNotValidException();
                }

                controller.start();

            } catch (EscCliException e) {
                return;
            } catch(SelectionNotValidException e) {
                EmployeeView.showErrorMessage(e);
            }
        }
    }

}
