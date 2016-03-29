package code.dao;

import code.model.Valuta;
import code.model.ValutaType;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository("dao")
public class DaoImpl implements Dao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOGGER = Logger.getLogger(DaoImpl.class);

    @Override
    public Valuta putNewValuta(Valuta valuta) {
        try {
            sessionFactory.getCurrentSession().save(valuta);
            return valuta;
        } catch (Throwable e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Valuta> getAllValuta() {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Valuta.class).list();
        } catch (Throwable e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Valuta> getValutaForDecade(ValutaType type, int decade) {
        try {
            LocalDate dateUp;
            LocalDate dateDown;
            if (decade < 1 || decade > 3) {
                return null;
            } else {
                dateUp = getUpDate(decade);
                dateDown = getDownDate(decade);
            }
            return sessionFactory.getCurrentSession().createCriteria(Valuta.class)
                    .add(Restrictions.eq("type", type))
                    .add(Restrictions.between("addedTime", dateDown, dateUp)).list();
        } catch (Throwable e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Valuta> getAllValutaForDecade(int decade) {
        try {
            LocalDate dateUp;
            LocalDate dateDown;
            if (decade < 1 || decade > 3) {
                return null;
            } else {
                dateUp = getUpDate(decade);
                dateDown = getDownDate(decade);
            }
            return sessionFactory.getCurrentSession().createCriteria(Valuta.class)
                    .add(Restrictions.between("addedTime", dateDown, dateUp)).list();
        } catch (Throwable e) {
            LOGGER.error(e);
        }
        return null;
    }

    private LocalDate getDownDate(int decade) {
        if (decade == 1) return LocalDate.now().minusDays(10);
        if (decade == 2) return LocalDate.now().minusDays(20);
        if (decade == 3) return LocalDate.now().minusDays(30);
        return null;
    }

    private LocalDate getUpDate(int decade) {
        if (decade == 1) return LocalDate.now();
        if (decade == 2) return LocalDate.now().minusDays(10);
        if (decade == 3) return LocalDate.now().minusDays(20);
        return null;
    }

    @Override
    public boolean removeValuta(Valuta valuta) {
        try {
            sessionFactory.getCurrentSession().delete(valuta);
            return true;
        } catch (Throwable e) {
            LOGGER.error(e);
        }
        return false;
    }
}
