package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.ReportBean;
import it.bd.sistema.noleggio.bean.YearlyReportBean;
import it.bd.sistema.noleggio.dao.YearlyReportProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Report;
import it.bd.sistema.noleggio.view.ReportView;

import java.util.ArrayList;
import java.util.List;

public class YearlyReportController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                int year = ReportView.yearlyReport();
                YearlyReportProcedureDAO dao = new YearlyReportProcedureDAO();
                List<Report> reports = dao.yearlyReport(year);
                List<ReportBean> bean = new ArrayList<ReportBean>();
                for (Report r : reports) {
                    bean.add(new YearlyReportBean(
                            r.getName(),
                            r.getTime(),
                            r.getHours()
                    ));
                }
                ReportView.printReport(bean);
                return;
            } catch (EscCliException e) {
                return;
            } catch (DaoException e) {
                ReportView.showErrorMessage(e);
            }
        }
    }

}
