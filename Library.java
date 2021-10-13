//Daniel Martinez
//pledge: I pledge my honor that I have abided by the Stevens Honor System
package specialassignment1;
import java.util.*;

public class Library extends SLL {
	//data fields TO-DO
	SLL<ArrayList<Book>> shelves;


	/**
	 * Create library with empty shelves, but 26 shelves from A-Z
	 */
	public Library() {
		shelves = new SLL<>();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i<alphabet.length(); i++){
			shelves.addFirst(new ArrayList<>(),alphabet.charAt(i));
		}

	}
	
	/**
	 * Add Book -- put in node with matching character of the first letter
	 * of author last name (ie. JK Rowling goes in R)
	 */
	public void addBook(Book aBook) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int index = alphabet.indexOf(aBook.getAuthorLastName().toUpperCase().charAt(0));
		ArrayList<Book> temp = shelves.getAt(index);
		for(int i=0; i<temp.size(); i++){
			if(temp.get(i).getTitle().equalsIgnoreCase(aBook.getTitle()) && temp.get(i).getAuthorFirstName().equalsIgnoreCase(aBook.getAuthorFirstName()) && temp.get(i).getAuthorLastName().equalsIgnoreCase(aBook.getAuthorLastName())){
				throw new IllegalArgumentException("addBook: Book already in shelve");
			}
		}
		shelves.getAt(index).add(aBook);
	}
	
	/**
	 * Returns true if the book was successfully found and removed 
	 * @param title
	 * @param last
	 * @param first
	 * @return
	 */
	public boolean removeBook(String title, String last, String first) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int index = alphabet.indexOf(last.toUpperCase().charAt(0));
		ArrayList<Book> temp = shelves.getAt(index);
		for(int i=0; i<temp.size(); i++){
			if(temp.get(i).getTitle().equalsIgnoreCase(title) && temp.get(i).getAuthorFirstName().equalsIgnoreCase(first) && temp.get(i).getAuthorLastName().equalsIgnoreCase(last)){
				temp.remove(i);
				return true;
			}
		}
		throw new IllegalStateException("removeBook: book not in shelves");
	}
	/**
	 * Gets all the books from a particular author
	 * @param last
	 * @param first
	 */
	public ArrayList<Book> getAuthorsBook(String last, String first) {
		ArrayList<Book> result = new ArrayList<>();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int index = alphabet.indexOf(last.toUpperCase().charAt(0));
		ArrayList<Book> temp = shelves.getAt(index);
		for(int i=0; i<temp.size();i++){
			if(temp.get(i).getAuthorFirstName().equalsIgnoreCase(first) && temp.get(i).getAuthorLastName().equalsIgnoreCase(last)){
				result.add(temp.get(i));
			}
		}
		if(result.size() == 0){
			throw new IllegalStateException("getAuthorsBook: author has no books");
		}
		return result;
	}
	
	public ArrayList<String> getAllTitles() {
		ArrayList<String> result = new ArrayList<>();
		for(int i=0; i<26; i++){
			for(int j=0; j<shelves.getAt(i).size(); j++){
				result.add(shelves.getAt(i).get(j).getTitle());
			}
		}
		if(result.size()==0){
			throw new IllegalStateException("getAllTittles: shelves are empty");
		}
		return result;
	}
	
	/**
	 * Create toString method to show all of the inputs
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0; i<26; i++){
			s.append(alphabet.charAt(i) + ": ");
			for(int j=0; j<shelves.getAt(i).size();j++){
				if(j==shelves.getAt(i).size()-1){
					s.append(shelves.getAt(i).get(j).getTitle());
				}else{
					s.append(shelves.getAt(i).get(j).getTitle() + ", ");
				}
			}
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String[] args){
		Library l1 = new Library();
		Book b1 = new Book("The Assignment", "Xu", "Connie", 195);
		Book b2 = new Book("The Special Assignment", "McCreesh", "Micheal", 210);
		Book b3 = new Book("CS284", "Bonelli","Eduardo", 202);
		l1.addBook(b1);
		l1.addBook(b2);
		l1.addBook(b3);
		System.out.println(l1);


		ArrayList<String> allTitles = l1.getAllTitles();
		for(int i=0; i<allTitles.size(); i++){
			System.out.println(allTitles.get(i));
		}

	}
}


