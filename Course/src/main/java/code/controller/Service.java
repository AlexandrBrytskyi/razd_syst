package code.controller;


import code.model.Valuta;
import code.model.ValutaType;

import java.util.List;

public interface Service {

    Valuta putNewValuta(Valuta valuta);

    List<Valuta> getAllValuta();

    List<Valuta> getAllValutaForDecade(int decade);

    List<Valuta> getValutaForDecade(ValutaType type, int decade);

    double getAverageCourseForDecade(ValutaType type, int decade);

    boolean removeValuta(Valuta valuta);

    void registerTable(code.view.Table table);


}
