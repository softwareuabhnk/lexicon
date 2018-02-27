package lendinglib.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import lendinglib.models.Book;

public class ImprovingArrays {

	public static void main(String[] args) {

		ArrayList<String> myArrayList = new ArrayList<String>();
		HashSet<String> myHashSet = new HashSet<String>();

		myArrayList.add("first Item");
		myArrayList.add("second Item");
		myArrayList.add("third Item");
		boolean result = myArrayList.add("forth Item");

		System.out.println(result);
		System.out.println(myArrayList.size());

		for (int i = 0; i < myArrayList.size(); i++) {
			System.out.println(myArrayList.get(i));
		}

		myArrayList.remove(1);
		myArrayList.add("fifth Item");
		myArrayList.add(1, "sixth Item");

		for (int i = 0; i < myArrayList.size(); i++) {
			System.out.println(myArrayList.get(i));
		}

		myHashSet.add("first Item");
		myHashSet.add("second Item");
		myHashSet.add("third Item");
		myHashSet.add("fourth Item");
		System.out.println(myHashSet.size());
		myHashSet.remove("second Item");
		System.out.println(myHashSet.size());

		Iterator<String> myIterator = myHashSet.iterator();

		while (myIterator.hasNext()) {
			String nextString = myIterator.next();
			System.out.println(nextString);
		}

		HashMap<String, Book> myHashMap = new HashMap<String, Book>();
		Book book1 = new Book("1", "First Book", null, null, null, 299);
		Book book2 = new Book("2", "Second Book", null, null, null, 299);
		Book book3 = new Book("3", "Third Book", null, null, null, 299);
		Book book4 = new Book("4", "Fourth Book", null, null, null, 299);
		myHashMap.put(book1.getTitle(), book1);
		myHashMap.put(book2.getTitle(), book2);
		myHashMap.put(book3.getTitle(), book3);
		myHashMap.put(book4.getTitle(), book4);

		System.out.println(myHashMap.size());

		myHashMap.remove(book3.getTitle());
		System.out.println(myHashMap.size());

		myHashMap.put(book3.getTitle(), book3);

		Iterator<Book> myValues = myHashMap.values().iterator();

		while (myValues.hasNext()) {

			Book nextBook = myValues.next();
			System.out.println(nextBook.getTitle());

		}
	}

}
