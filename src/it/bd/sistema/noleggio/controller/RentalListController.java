package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.exception.cli.SelectionNotValidException;
import it.bd.sistema.noleggio.view.EmployeeView;
import it.bd.sistema.noleggio.view.RentalListView;

public class RentalListController implements Controller {

    @Override
    public void start() {

        Controller controller;

        while(true) {
            try {
                int selection = RentalListView.printRentalListMenu();

                switch (selection) {
                    case 1 -> controller = new CurrentRentalListController();
                    case 2 -> controller = new ExpiredRentalListController();
                    case 3 -> controller = new FilmCopyRentalListController();
                    case 4 -> controller = new ClientRentalListController();
                    case 5 -> controller = new FilmRentalListController();
                    default -> throw new SelectionNotValidException();
                }

                controller.start();
                return;
            } catch (EscCliException e) {
                return;
            } catch(SelectionNotValidException e) {
                EmployeeView.showErrorMessage(e);
            }
        }
    }

}
