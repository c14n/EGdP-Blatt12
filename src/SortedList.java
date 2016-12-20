/**
 * Created by cmartin on 20.12.16.
 */
public class SortedList<T extends Comparable>
{

    private Node root;

    public SortedList()
    {
        root = new Node();
    }

    public void insert(T item)
    {
        root.insert(item);
    }

    public T find(T query)
    {
        return root.find(query);
    }

    class Node
    {
        private T value;
        private Node lt;
        private Node gt;

        public Node()
        {
            value = null;
            lt = null;
            gt = null;
        }

        public Node(T item)
        {
            value = item;
            lt = null;
            gt = null;
        }

        public void insert(T item)
        {
            if (value == null) {
                value = item;
                return;
            }

            switch (Integer.signum(item.compareTo(value))) {
                case -1:
                    if (lt == null) {
                        lt = new Node(item);
                    } else {
                        lt.insert(item);
                    }
                    break;
                case 1:
                    if (gt == null) {
                        gt = new Node(item);
                    } else {
                        gt.insert(item);
                    }
                    break;
                default:
                    value = item;
            }
        }

        public T find(T query)
        {

            if (value == null) {
                return null;
            }

            switch (Integer.signum(query.compareTo(value))) {

                case -1:
                    return this.lt == null ? null : this.lt.find(query);

                case 1:
                    return this.gt == null ? null : this.gt.find(query);

                default:
                    return this.value;
            }
        }
    }
}
