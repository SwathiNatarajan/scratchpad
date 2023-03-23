package hash;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    static class Person {
        String name;
        int id;

        public Person(String name, int id) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        public String getName() {
            return this.name;
        }

        public static void main(String[] args) {
            Map<Person, String> map = new HashMap<>();
            Person p1 = new Person("Jon", 1);
            Person p2 = new Person("Jack", 2);

            map.put(p1, p1.getName());
            map.put(p2, p2.name);
            System.out.println(map.keySet());
            System.out.println(map.size());
        }
    }


}
