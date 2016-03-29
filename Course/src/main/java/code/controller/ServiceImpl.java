package code.controller;

import code.dao.Dao;
import code.model.Valuta;
import code.model.ValutaType;
import code.view.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.*;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    Map<Integer, Table> tables = new HashMap<Integer, Table>();

    @Autowired
    @Qualifier("dao")
    private Dao dao;

    @Override
    public Valuta putNewValuta(Valuta valuta) {
        Valuta added = dao.putNewValuta(valuta);
        tables.get(defineDecade(valuta.getAddedTime())).updateUI();
        return added;
    }

    private Integer defineDecade(LocalDate addedTime) {
        long val = LocalDate.now().getLong(ChronoField.DAY_OF_YEAR) - addedTime.getLong(ChronoField.DAY_OF_YEAR);
        if (val <= 10) {
            return 1;
        } else {
            if (val <= 20 && val > 10) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    @Override
    public List<Valuta> getAllValuta() {
        return dao.getAllValuta();
    }

    @Override
    public List<Valuta> getAllValutaForDecade(int decade) {
        return dao.getAllValutaForDecade(decade);
    }

    @Override
    public List<Valuta> getValutaForDecade(ValutaType type, int decade) {
        return dao.getValutaForDecade(type, decade);
    }


    @Override
    public double getAverageCourseForDecade(ValutaType type, int decade) {
        List<Valuta> valutas = getValutaForDecade(type, decade);
        double sum = 0;
        for (Valuta valuta : valutas) {
            sum += valuta.getCourseValue();
        }
        return sum / valutas.size();
    }

    @Override
    public boolean removeValuta(Valuta valuta) {
        return dao.removeValuta(valuta);
    }

    @Override
    public void registerTable(Table table) {
        tables.put(table.getDecade(), table);
    }
}
