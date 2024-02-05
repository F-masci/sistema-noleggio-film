package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.dao.ClientListProcedureDAO;
import it.bd.sistema.noleggio.dao.FilmListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.view.ClientListView;
import it.bd.sistema.noleggio.view.FilmListView;

import java.util.ArrayList;
import java.util.List;

public class ClientListController implements Controller {

    @Override
    public void start() {
        try {
            ClientListProcedureDAO dao = new ClientListProcedureDAO();
            List<Client> clients = dao.clientList();
            List<ClientBean> bean = new ArrayList<>();
            for (Client c: clients) {
                bean.add(new ClientBean(
                        c.getCard(),
                        c.getCf(),
                        c.getName(),
                        c.getSurname(),
                        c.getBirthDate(),
                        c.getAddress().getAddress(),
                        c.getAddress().getCap(),
                        c.getAddress().getNumber(),
                        c.getEmails(),
                        c.getPhones(),
                        c.getMobilePhones()
                ));
            }
            ClientListView.printList(bean);
        } catch (DaoException e) {
            ClientListView.showErrorMessage(e);
        }
    }

}
