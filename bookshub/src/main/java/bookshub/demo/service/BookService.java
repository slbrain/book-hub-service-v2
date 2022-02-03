package bookshub.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import bookshub.demo.dto.BookDto;
import bookshub.demo.dto.BookShopDto;

@Service
public class BookService{
	public  final List<BookDto> books = new ArrayList<BookDto>();
	
	public BookService(){
		
		List<BookShopDto> bookshops = new ArrayList<BookShopDto>();
		BookShopDto bookshop1 = new BookShopDto(1, "Vijitha Yapa Book Shop");
		BookShopDto bookshop2 = new BookShopDto(2, "Godage Book Shop");
	
		
		BookDto book1 = new BookDto(1,"Batman","Comic");
		bookshops.add(bookshop1);
		book1.setBookshops(bookshops);
		BookDto book2 = new BookDto(2,"Amazing Spider Man","Comic");
		book2.setBookshops(bookshops);
		BookDto book3 =	new BookDto(3,"The Incredible Hulk","Comic");
		book3.setBookshops(bookshops);
		
		bookshops.add(bookshop2);
		BookDto book4 = new BookDto(4,"Dracula","Horror");
		book4.setBookshops(bookshops);
		
		BookDto book5 = new BookDto(5,"House of Leaves","Horror");
		book5.setBookshops(bookshops);
		
		BookDto book6 = new BookDto(6,"The Name of the Wind","Fantacy");
		book6.setBookshops(bookshops);
		
		BookDto book7 = new BookDto(7,"The Fifth Season","Fantacy");
		book7.setBookshops(bookshops);
		
		BookDto book8 = new BookDto(8,"The Eye of the World","Fantacy");
		book8.setBookshops(bookshops);
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
		books.add(book7);
		books.add(book8);
		
		
	}
	
	public List<BookDto> getBooks(){
		
	
		return books;
		
	}
	
	public BookDto getBookByName(String name) {
		try {
			return  books.stream().filter(bk->bk.getName().startsWith(name)).findFirst().get();
		}catch(NoSuchElementException e) {
			return null;
		}
		
	}

	public BookDto create(BookDto bookDto) {
		books.add(bookDto);
		 return bookDto;
	}

	public BookDto update(BookDto bookDto) {
		BookDto existingBook=books.stream().filter(bk->bk.getIsbn()==bookDto.getIsbn()).findFirst().get();
	
		int indexToReplace = books.indexOf(existingBook);
		books.set(indexToReplace,bookDto);
		return bookDto;
	}

	public boolean delete(Integer isbn) {
		
		return books.removeIf(bk->bk.getIsbn()==isbn);
	}

}
