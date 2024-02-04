package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.WorkingHoursBean;
import it.bd.sistema.noleggio.dao.RemoveWorkingHoursProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.view.InsertWorkingHoursView;
import it.bd.sistema.noleggio.view.RemoveWorkingHoursView;

public class RemoveWorkingHoursController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                WorkingHoursBean bean = RemoveWorkingHoursView.removeWorkingHoursView();
                Employee employee = new Employee(bean.getEmployee());
                RemoveWorkingHoursProcedureDAO dao = new RemoveWorkingHoursProcedureDAO();
                dao.removeWorkingHourse(employee, bean.getYear(), bean.getMonth());
                RemoveWorkingHoursView.printSuccessMessage();
                return;
            } catch (EscCliException e) {
                return;
            } catch (DaoException e) {
                RemoveWorkingHoursView.showErrorMessage(e);
            }
        }
    }

}
