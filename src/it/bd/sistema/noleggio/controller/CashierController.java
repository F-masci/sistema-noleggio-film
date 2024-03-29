package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.exception.cli.ContinueCliException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.exception.cli.SelectionNotValidException;
import it.bd.sistema.noleggio.view.CashierView;
import it.bd.sistema.noleggio.view.EmployeeView;

public class CashierController implements Controller {

    @Override
    public void start() {

        Controller controller;

        while(true) {
            try {
                int selection = CashierView.printCashierMenu();

                switch (selection) {
                    case 1 -> controller = new ClockInOutController();
                    case 2 -> controller = new WorkingHoursListController();
                    case 3 -> controller = new RegisterClientController();
                    case 4 -> controller = new ClientListController();
                    case 5 -> controller = new RemoveClientController();
                    case 6 -> controller = new InsertClientAddressController();
                    case 7 -> controller = new RemoveClientAddressController();
                    case 8 -> controller = new RegisterRentalController();
                    case 9 -> controller = new RegisterReturnController();
                    case 10 -> controller = new RentalListController();
                    default -> throw new SelectionNotValidException();
                }

                controller.start();

            } catch (EscCliException e) {
                return;
            } catch(SelectionNotValidException e) {
                EmployeeView.showErrorMessage(e);
            } catch(ContinueCliException ignored) {}
        }
    }

}
