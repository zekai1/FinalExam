package pkgLibrary;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

import pkgLibrary.Book;
import pkgMain.XMLReader;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	String id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	
	public Book getBook(String id) throws BookException {
		for (Book book : this.getBooks()) {
			if (book.getId().equals(id)) {
				return book;
			}
		}
		throw new BookException("book was not found.");
	}

	public void AddBook(Book b) throws BookException {
		if (this.getBook(b.getId()) == null) {
			this.books.add(b);
		}
		else {
			throw new BookException("Book exists");
		}
	}
}