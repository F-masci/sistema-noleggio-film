package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.WorkingHoursBean;
import it.bd.sistema.noleggio.dao.ClockInOutProcedureDAO;
import it.bd.sistema.noleggio.dao.InsertWorkingHoursProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.WorkingHour;
import it.bd.sistema.noleggio.view.GenericView;
import it.bd.sistema.noleggio.view.InsertWorkingHoursView;

import java.util.ArrayList;
import java.util.List;

public class ClockInOutController implements Controller {

    @Override
    public void start() {
        try {
            ClockInOutProcedureDAO dao = new ClockInOutProcedureDAO();
            dao.clockInOut();
            GenericView.printSuccessMessage();
        } catch (DaoException e) {
            GenericView.showErrorMessage(e);
        }
    }

}
