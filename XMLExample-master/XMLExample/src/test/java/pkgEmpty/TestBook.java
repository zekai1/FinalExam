package pkgEmpty;


import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.Catalog;
import pkgLibrary.BookException;
import pkgMain.XMLReader;

public class TestBook {

	@Test
	public void TestGetBook() throws BookException {

		XMLReader rdr = new XMLReader();
		Catalog cat = rdr.ReadCatalog();
		assertEquals("Maeve Ascendant", cat.getBook("bk103").getTitle());
	}

	@Test
	public void TestAddBook() throws BookException {

		XMLReader rdr = new XMLReader();
		Catalog cat = rdr.ReadCatalog();
		Book book = new Book("bk106",
				"Randall, Cynthia",
				"Lover Birds",
				"Romance",
				4.95,
				null,
				"When Carla meets Paul at an ornithology conference, tempers fly as feathers get ruffled.");
		try {

			cat.AddBook(book);
			fail();
		}
		catch (BookException e) {
			final String expected = "Book exists";
			assertEquals(expected, e.getMessage());
		}
	}
}