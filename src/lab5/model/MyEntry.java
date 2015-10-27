package lab5.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */
public class MyEntry implements Map.Entry<Integer, Integer> ,Serializable {
    private Integer key;
    private Integer value;

    public MyEntry(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return key;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Integer setValue(Integer value) {
        Integer old = this.value;
        this.value = value;
        return old;
    }
}
