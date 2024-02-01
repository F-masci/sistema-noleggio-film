package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.RegisterEmployeeBean;
import it.bd.sistema.noleggio.dao.RegisterEmployeeProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.view.RegisterEmployeeView;

public class RegisterEmployeeController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                RegisterEmployeeBean bean = RegisterEmployeeView.registerEmployee();
                RegisterEmployeeProcedureDAO dao = new RegisterEmployeeProcedureDAO();
                dao.registerEmployee(
                        bean.getUsername(),
                        bean.getPassword(),
                        bean.getRole(),
                        bean.getStartDate(),
                        bean.getCf(),
                        bean.getName(),
                        bean.getPhone()
                );
                RegisterEmployeeView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                RegisterEmployeeView.showErrorMessage(e);
            }
        }
    }

}
