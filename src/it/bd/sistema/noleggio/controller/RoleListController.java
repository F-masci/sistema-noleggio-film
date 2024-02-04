package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.bean.FilmCopyBean;
import it.bd.sistema.noleggio.bean.RoleBean;
import it.bd.sistema.noleggio.dao.FilmCopyListProcedureDAO;
import it.bd.sistema.noleggio.dao.RoleListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.model.Role;
import it.bd.sistema.noleggio.view.FilmCopyListView;
import it.bd.sistema.noleggio.view.FilmListView;
import it.bd.sistema.noleggio.view.RoleListView;

import java.util.ArrayList;
import java.util.List;

public class RoleListController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                RoleBean bean = RoleListView.roleList();
                RoleListProcedureDAO dao = new RoleListProcedureDAO();
                List<RoleBean> res = new ArrayList<>();
                Employee employee = new Employee(bean.getEmployee());
                List<Role> roles = dao.roleList(employee);
                for (Role r : roles) {
                    res.add(new RoleBean(
                            r.getEmployee().getCf(),
                            r.getStart(),
                            r.getEnd(),
                            r.getRole()
                    ));
                }
                RoleListView.printList(res);
                return;
            } catch (DaoException e) {
                RoleListView.showErrorMessage(e);
            } catch (EscCliException ignored) {
                return;
            }
        }
    }

}
