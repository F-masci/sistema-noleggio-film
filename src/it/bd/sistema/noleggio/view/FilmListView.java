package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.EmployeeBean;
import it.bd.sistema.noleggio.bean.FilmBean;

import java.util.List;

public class FilmListView extends GenericView {

    public static void printList(List<FilmBean> list) {
        println("--- FILM ---");
        for(FilmBean l: list) {
            print(l.getTitle() + " - " + l.getDirector() + " (" + l.getYear() + "), DVD " + l.getPrice().getDvd() + "€, Videocassetta " + l.getPrice().getVideotape() + "€");
            FilmBean original = l.getOriginal();
            if(original != null) {
                print(" | Remake di " + original.getTitle() + " - " + original.getDirector());
            }
            List<String> actorNames = l.getActorNames();
            List<String> actorSurnames = l.getActorSurnames();
            if(!actorNames.isEmpty() && !actorSurnames.isEmpty()) print(": ");
            for(int i = 0; i<actorNames.size() && i<actorSurnames.size(); i++) {
                print(actorNames.get(i) + " " + actorSurnames.get(i));
                if(i != actorNames.size()-1 && i != actorSurnames.size()-1) print(", ");
            }
            println("");
        }
    }

}
