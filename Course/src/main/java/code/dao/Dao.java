package code.dao;


import code.model.Valuta;
import code.model.ValutaType;

import java.util.List;

public interface Dao {

    Valuta putNewValuta(Valuta valuta);

    List<Valuta> getAllValuta();

    List<Valuta> getValutaForDecade(ValutaType type, int decade);

    List<Valuta> getAllValutaForDecade(int decade);

    boolean removeValuta(Valuta valuta);

}
