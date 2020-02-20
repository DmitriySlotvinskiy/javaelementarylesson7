package com.slotvinskiy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//3. Есть List объектов у каждого из которых 2 поля: int и String.
// Удалить те у которых значения int повторяются(оставить по одному из дубликатов).
public class Task3 {

    public static void main(String[] args) {

        List<Entry> list = new ArrayList<>();
        list.add(new Entry(1, "One"));
        list.add(new Entry(2, "Two"));
        list.add(new Entry(3, "Three"));
        list.add(new Entry(4, "Four"));
        list.add(new Entry(5, "Five"));
        list.add(new Entry(2, "Second Two"));
        list.add(new Entry(3, "Second Three"));
        System.out.println(list);
        Set<Entry> set = new TreeSet<>(list);
        list = new ArrayList<>(set);
        System.out.println(list);
    }

    private static class Entry implements Comparable {
        private int id;
        private String string;

        public Entry(int id, String string) {
            this.id = id;
            this.string = string;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "{" + id + ":" + string + "}";
        }

        @Override
        public int compareTo(Object o) {
            if (getClass() != o.getClass()) return 0;
            o = (Entry) o;
            if (this.id == ((Entry) o).getId()) {
                return 0;
            } else if (this.id > ((Entry) o).getId()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}


