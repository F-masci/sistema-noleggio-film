package it.bd.sistema.noleggio.utility;

import java.util.List;

public class FormatListProcedure {

    public static String createListFromStrings(List<String> list) {
        StringBuilder res = new StringBuilder();
        for(String t: list) {
            res.append(t).append(";");
        }
        return res.toString();
    }

    public static String createListFromLongs(List<Long> list) {
        StringBuilder res = new StringBuilder();
        for(Long t: list) {
            res.append(t).append(";");
        }
        return res.toString();
    }
    
}
