package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.exception.InsertWorkingHoursException;
import it.bd.sistema.noleggio.exception.cli.ContinueCliException;
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
                    case 2 -> controller = new EmployeeListController();
                    case 3 -> controller = new RemoveEmployeeController();
                    case 4 -> controller = new ChangeRoleController();
                    case 5 -> controller = new RoleListController();
                    case 6 -> controller = new InsertWorkingHoursController();
                    case 7 -> controller = new WorkingHoursListController();
                    case 8 -> controller = new RemoveWorkingHoursController();
                    case 9 -> controller = new MonthlyReportController();
                    case 10 -> controller = new YearlyReportController();
                    case 11 -> controller = new InsertFilmController();
                    case 12 -> controller = new FilmListController();
                    case 13 -> controller = new RemoveFilmController();
                    case 14 -> controller = new InsertSectorController();
                    case 15 -> controller = new SectorListController();
                    case 16 -> controller = new RemoveSectorController();
                    case 17 -> controller = new InsertFilmCopyController();
                    case 18 -> controller = new FilmCopyListController();
                    case 19 -> controller = new RemoveFilmCopyController();
                    default -> throw new SelectionNotValidException();
                }

                controller.start();

            } catch (EscCliException e) {
                return;
            } catch(SelectionNotValidException e) {
                OwnerView.showErrorMessage(e);
            } catch(ContinueCliException ignored) {}
        }
    }
}
