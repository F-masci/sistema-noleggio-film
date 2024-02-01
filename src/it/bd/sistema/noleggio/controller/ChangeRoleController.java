package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.ChangeRoleBean;
import it.bd.sistema.noleggio.dao.ChangeRoleProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.view.ChangeRoleView;

public class ChangeRoleController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                ChangeRoleBean bean = ChangeRoleView.changeRole();
                ChangeRoleProcedureDAO dao = new ChangeRoleProcedureDAO();
                Employee employee = new Employee(bean.getCf());
                dao.changeRole(
                        employee,
                        bean.getDate(),
                        bean.getRole()
                );
                ChangeRoleView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                ChangeRoleView.showErrorMessage(e);
            }
        }
    }

}
