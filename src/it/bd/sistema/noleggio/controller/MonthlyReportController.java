package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.MonthlyReportBean;
import it.bd.sistema.noleggio.bean.ReportBean;
import it.bd.sistema.noleggio.dao.MonthlyReportProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Report;
import it.bd.sistema.noleggio.view.ReportView;

import java.util.ArrayList;
import java.util.List;

public class MonthlyReportController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                int month = ReportView.monthlyReport();
                int year = ReportView.yearlyReport();
                MonthlyReportProcedureDAO dao = new MonthlyReportProcedureDAO();
                List<Report> reports = dao.monthlyReport(year, month);
                List<ReportBean> bean = new ArrayList<ReportBean>();
                for (Report r : reports) {
                    bean.add(new MonthlyReportBean(
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
