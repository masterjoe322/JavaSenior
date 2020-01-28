package cn.sdnu.generic.test.demo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 8:37 PM
 */
public class DAO<T> {

    private Map<String, T> map;

    public DAO () {
        map = new HashMap<String, T>();
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {
        Set<String> strings = map.keySet();
        ArrayList<T> objects = new ArrayList<>();
        for (String string : strings) {
            T t = map.get(string);
            objects.add(t);
        }
        return objects;
    }

    public void delete(String id) {
        map.remove(id);
    }


}
