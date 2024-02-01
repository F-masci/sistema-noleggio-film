package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.WorkingHoursBean;
import it.bd.sistema.noleggio.dao.InsertWorkingHoursProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.WorkingHour;
import it.bd.sistema.noleggio.view.InsertWorkingHoursView;

import java.util.ArrayList;
import java.util.List;

public class InsertWorkingHoursController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                WorkingHoursBean bean = InsertWorkingHoursView.insertWorkingHoursView();
                Employee employee = new Employee(bean.getEmployee());
                List<WorkingHour> hours = new ArrayList<>();
                List<String> h = bean.getHours();
                List<Integer> d = bean.getDays();
                for (int i = 0; i < h.size() && i < d.size(); i++) {
                    hours.add(new WorkingHour(
                            d.get(i),
                            h.get(i)
                    ));
                }
                InsertWorkingHoursProcedureDAO dao = new InsertWorkingHoursProcedureDAO();
                dao.insertWorkingHourse(employee, bean.getYear(), bean.getMonth(), hours);
                InsertWorkingHoursView.printSuccessMessage();
                return;
            } catch (EscCliException e) {
                return;
            } catch (DaoException e) {
                InsertWorkingHoursView.showErrorMessage(e);
            }
        }
    }

}
