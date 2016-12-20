import java.util.NoSuchElementException;

/**
 * Created by cmartin on 20.12.16.
 */
public class GenericMap<K extends Comparable, V>
{
    private SortedList<Map> list;

    public GenericMap()
    {
        this.list = new SortedList<>();
    }

    public void insert(K key, V value)
    {
        list.insert(new Map(key, value));
    }

    public V find(K key)
    {
        Map m = list.find(new Map(key));

        if (m == null) {
            throw new ElementNotFoundException(key);
        }

        return m.value;
    }

    private class Map implements Comparable<Map>
    {
        private K key;
        private V value;

        public Map(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public Map(K key)
        {
            this.key = key;
            this.value = null;
        }

        @Override
        public int compareTo(Map other)
        {
            return key.compareTo(other.key);
        }
    }
}
