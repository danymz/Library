package specialassignment1;
import java.util.LinkedList;
import java.util.Queue;

public class Book {
    //data fields here
    private String title;
    private String authorLastName;
    private String authorFirstName;
    private int pageCount;
    private Queue<String> checkout;


    /**
     * Create a book object
     * Create a randomly generated id
     */
    public Book(String title, String authorLastName, String authorFirstName, int pageCount) {
    	if(pageCount <=0){
    	    throw new IllegalArgumentException("Book: pageCount must be greater than 0");
        }
    	this.title = title;
    	this.authorLastName = authorLastName;
    	this.authorFirstName = authorFirstName;
    	this.pageCount = pageCount;
    	checkout = new LinkedList<>();
    }
    //GETTERS TO-DO
    public String getTitle() {
        return this.title;
    }
    public int getPageCount() {
        return this.pageCount;
    }
    public String getAuthorFirstName() {
        return this.authorFirstName;
    }
    public String getAuthorLastName() {
        return this.authorLastName;
    }

    public boolean checkoutBook(String name) {
        Queue<String> temp = new LinkedList<>();
        while(checkout.size()!=0){
            if(checkout.element().equalsIgnoreCase(name)){
                return false;
            }
            temp.add(checkout.remove());
        }
        checkout = temp;
        checkout.add(name);
        return true;
    }
    
    public boolean returnBook() {
    	if(checkout.size()==0){
    	    return false;
        }
    	checkout.remove();
    	return true;
    }
    
    public String toString() {
    	return title + " by " + authorFirstName + " " + authorLastName;
    }
}
