package iterator;

public class Application {
    public static void main(String[] args) {
        MyArray array = new MyArray(new String[]{"3", "8", "3"});

        Iterator iterator = array.getAllIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}
