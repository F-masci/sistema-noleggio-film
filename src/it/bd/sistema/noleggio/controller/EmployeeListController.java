package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.EmployeeBean;
import it.bd.sistema.noleggio.dao.EmployeeListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.view.EmployeeListView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListController implements Controller {

    @Override
    public void start() {
        try {
            EmployeeListProcedureDAO dao = new EmployeeListProcedureDAO();
            List<Employee> employees = dao.employeeList();
            List<EmployeeBean> bean = new ArrayList<>();
            for (Employee e : employees) {
                bean.add(new EmployeeBean(
                        e.getUsername(),
                        e.getRole().getRole(),
                        e.getCf(),
                        e.getName(),
                        e.getPhone()
                ));
            }
            EmployeeListView.printList(bean);
        } catch (DaoException e) {
            EmployeeListView.showErrorMessage(e);
        }    catch(EscCliException ignored) {}
    }

}
