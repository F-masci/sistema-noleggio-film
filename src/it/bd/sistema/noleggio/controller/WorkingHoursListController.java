package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.ReportBean;
import it.bd.sistema.noleggio.bean.WorkingHoursBean;
import it.bd.sistema.noleggio.bean.YearlyReportBean;
import it.bd.sistema.noleggio.dao.WorkingHoursListProcedureDAO;
import it.bd.sistema.noleggio.dao.YearlyReportProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.Report;
import it.bd.sistema.noleggio.model.WorkingHour;
import it.bd.sistema.noleggio.view.ReportView;
import it.bd.sistema.noleggio.view.WorkingHoursListView;

import java.util.ArrayList;
import java.util.List;

public class WorkingHoursListController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                WorkingHoursBean bean = WorkingHoursListView.workingHoursList();
                WorkingHoursListProcedureDAO dao = new WorkingHoursListProcedureDAO();
                Employee employee = new Employee(bean.getEmployee());
                List<WorkingHour> workingHours = dao.workingHoursList(employee, bean.getYear(), bean.getMonth());
                List<Integer> days = new ArrayList<>();
                List<String> hours = new ArrayList<>();
                for (WorkingHour w: workingHours) {
                    days.add(w.getDay());
                    hours.add(w.getHour());
                }
                WorkingHoursBean res = new WorkingHoursBean(employee.getCf(), bean.getYear(), bean.getMonth(), days, hours);
                WorkingHoursListView.printList(res);
                return;
            } catch (EscCliException e) {
                return;
            } catch (DaoException e) {
                WorkingHoursListView.showErrorMessage(e);
            }
        }
    }

}
