package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.EmployeeBean;
import it.bd.sistema.noleggio.dao.RemoveEmployeeProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.view.RemoveEmployeeView;

import javax.naming.ldap.Control;

public class RemoveEmployeeController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                EmployeeBean bean = RemoveEmployeeView.removeEmployee();
                RemoveEmployeeProcedureDAO dao = new RemoveEmployeeProcedureDAO();
                dao.removeEmployee(new Employee(bean.getCf()));
                RemoveEmployeeView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                RemoveEmployeeView.showErrorMessage(e);
            }
        }
    }

}
