package basic.sort;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionSortTest {
    public static void main(String[] args) {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(3, "66"));
        list.add(new Item(2, "77"));
        list.add(new Item(5, "33"));
        list.add(new Item(8, "44"));

        System.out.println(list);

        Collections.sort(list, (o1, o2) -> {
            return o1.itemId - o2.itemId;
        });
    }

    static class Item implements Comparable<Item> {
        int itemId;
        String itemNm;

        Item(int itemId, String itemNm) {
            this.itemId = itemId;
            this.itemNm = itemNm;
        }

        @Override
        public String toString() {
            return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
        }

        @Override
        public int compareTo(Item o) {
            return this.itemId - o.itemId; // natural ordering
        }
    }
}
