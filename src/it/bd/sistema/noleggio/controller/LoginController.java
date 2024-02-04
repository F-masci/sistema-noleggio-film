package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.LoginBean;
import it.bd.sistema.noleggio.dao.LoginProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.LoginException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.User;
import it.bd.sistema.noleggio.utility.LoggedUser;
import it.bd.sistema.noleggio.view.GenericView;
import it.bd.sistema.noleggio.view.LoginView;

public class LoginController implements Controller {

    @Override
    public void start() {

        try {
            LoginBean bean = LoginView.login();
            LoginProcedureDAO dao = new LoginProcedureDAO();
            User loggedUser = dao.execute(bean.getUsername(), bean.getPassword());
            LoggedUser.setLoggedUser(loggedUser);
            ConnectionFactory.changeRole(loggedUser.getRole());

            Controller controller;

            switch(loggedUser.getRole()) {
                case OWNER -> controller = new OwnerController();
                case EMPLOYEE -> controller = new EmployeeController();
                case CASHIER -> controller = new CashierController();
                default -> throw new LoginException("Carica non valida");
            }

            controller.start();

        } catch (DaoException e) {
            GenericView.showErrorMessage(e);
        }


    }

}
