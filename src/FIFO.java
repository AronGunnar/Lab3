
import java.util.*;

public class FIFO implements Queue {

    ArrayDeque<Object> fifo = new ArrayDeque<>();
    int maximumSize = 0;

    public void add(Object o) {
        fifo.add(Objects.requireNonNullElse(o, "null"));
    }

    public void removeFirst() throws NoSuchElementException {
        if (fifo.size() > maximumSize) {
            maximumSize = fifo.size();
        }

        fifo.remove();
    }

    public Object first() throws NoSuchElementException {
        Object temp = fifo.peek();
        if (temp == null) {
            throw new NoSuchElementException();
        }
        return temp;
    }

    public int maxSize() {
        return maximumSize;
    }

    public boolean isEmpty() {
        return fifo.isEmpty();
    }

    public int size() {
        return fifo.size();
    }

    public boolean equals(Object f) {
        if (!f.getClass().equals(this.getClass())) { // Jämför listornas klass
            throw new ClassCastException();
        }

        ArrayList<Object> f_list = new ArrayList<>();
        ArrayDeque<Object> fifo_clone = fifo.clone();

        String temp = f.toString(); // Plockar ut värden från f
        while (temp.contains("(")) {
            temp = temp.substring(temp.indexOf("(") + 1);
            f_list.add(temp.substring(0, temp.indexOf(")")));
        }

        if (fifo.size() != f_list.size()) { // Jämför längden på listorna
            return false;
        }

        for (Object f_elem : f_list) { // Jämför elementen i listorna
            if (!Objects.equals(f_elem.toString(), Objects.requireNonNull(fifo_clone.poll()).toString())) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder out = new StringBuilder("Queue: ");
        for (Object elem : fifo) {
            if (elem == null) {
                out.append("(null) ");
            } else {
                out.append("(").append(elem).append(") ");
            }
        }
        return String.valueOf(out);
    }
}
