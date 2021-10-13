package specialassignment1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void testBook(){
        Book b1 = new Book("The Way of Kings", "Sanderson", "Brandon", 1000);
        assertEquals(b1.getTitle(),"The Way of Kings");
        assertEquals(b1.getAuthorFirstName(), "Brandon");
        assertEquals(b1.getAuthorLastName(), "Sanderson");
        assertEquals(b1.getPageCount(), 1000);
        assertEquals(b1.checkoutBook("Daniel"), true);
        assertEquals(b1.checkoutBook("Robert"), true);
        assertEquals(b1.checkoutBook("Daniel"), false);
        assertEquals(b1.returnBook(), true);
        assertEquals(b1.checkoutBook("Daniel"), true);
        assertEquals(b1.toString(), "The Way of Kings by Brandon Sanderson");
    }
    @Test
    public void testLibrary(){
        Library l1 = new Library();
        Book b1 = new Book("The Way of Kings", "Sanderson", "Brandon", 1000);
        Book b2 = new Book("Words of Radiance", "Sanderson", "Brandon", 1200);
        Book b3 = new Book("The Hobbit", "Tolkien", "J.R.R", 300);
        Book b4 = new Book("A Game of Thrones", "Martin", "G.R.R", 700);
        l1.addBook(b1);
        l1.addBook(b2);
        l1.addBook(b3);
        l1.addBook(b4);
        ArrayList<Book> temp = new ArrayList<>();
        temp.add(b1);
        temp.add(b2);
        assertEquals(l1.getAuthorsBook("Sanderson", "Brandon"), temp);
        temp = new ArrayList<>();
        temp.add(b3);
        assertEquals(l1.getAuthorsBook("Tolkien", "J.R.R"), temp);

        ArrayList<String> temp2 = new ArrayList<>();
        temp2.add("A Game of Thrones");
        temp2.add("The Way of Kings");
        temp2.add("Words of Radiance");
        temp2.add("The Hobbit");
        assertEquals(l1.getAllTitles(),temp2);
        assertEquals(l1.removeBook("The Way of Kings", "Sanderson","Brandon"), true);
        temp2.remove(1);
        assertEquals(l1.getAllTitles(), temp2);



    }


}
