package control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import common.StaticDataPool;
import dto.BookDTO;
import dto.BookDetailDTO;
import dto.BookQueryDTO;
import enity.Book;
import enity.BookType;
import enity.Bookcase;
import enity.Publishing;
import service.BookService;
import service.BookTypeService;
import service.BookcaseService;
import service.PublishingService;

public class BookController extends ActionSupport {

	private BookService bookService = new BookService();
	
	private BookTypeService bookTypeService = new BookTypeService();
	
	private PublishingService publishingService = new PublishingService();
	
	private BookcaseService bookcaseService = new BookcaseService();

	private Book book;

	private List<Book> books;
	
	private List<BookDTO> bookDTOs;
	
	/**
	 * 图书类型
	 */
	private List<BookType> bookTypes;
	
	/**
	 * 出版社
	 */
	private List<Publishing> publishings;
	
	/**
	 * 书架
	 */
	private List<Bookcase> bookcases;
	
	/**
	 * 书籍的详细信息
	 */
	private BookDetailDTO bookDetailDTO;
	
	/**
	 * 模糊查询查询依据
	 */
	private int type;
	
	/**
	 * 模糊查询时查询的key
	 */
	private String key;
	
	/**
	 * 模糊查询结果
	 */
	private List<BookQueryDTO> bookQueryDTOs;
	
	/**
	 * 添加书籍信息时，应该提前查询到相关的信息，进行选择
	 * @return
	 */
	public String addQuery(){
		bookTypes = bookTypeService.query("1 = 1");
		publishings = publishingService.query("1 = 1");
		bookcases = bookcaseService.query("1 = 1");
		if(bookTypes == null||bookTypes.size() == 0){
			StaticDataPool.ERRORDTO.setInfo("图书类型信息不完整");
			return StaticDataPool.ERROR;
		}
		else if(publishings == null||publishings.size() == 0){
			StaticDataPool.ERRORDTO.setInfo("出版社信息不完整");
			return StaticDataPool.ERROR;
		}
		else if(bookcases == null||bookcases.size() == 0){
			StaticDataPool.ERRORDTO.setInfo("书架类型信息不完整");
			return StaticDataPool.ERROR;
		}
		return "canAdd";
	}

	/**
	 * 添加书籍信息
	 * @return
	 */
	public String add() {
		System.out.println(book.getBookcaseId());
		book.setOperator(StaticDataPool.LOGIN_ID);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		book.setInTime(simpleDateFormat.format(new Date()));
		int result = bookService.insert(book);
		if(result == 0){
			StaticDataPool.ERRORDTO.setInfo("该数据已存在，请勿重复添加！");
			return StaticDataPool.ERROR;
		}
		else if(result == 1){
			StaticDataPool.TYPE = 1;
			return StaticDataPool.SUCCESS;
		}
		else if(result == 2){
			StaticDataPool.ERRORDTO.setInfo("未知原因，添加失败~");
			return StaticDataPool.ERROR;
		}
		return StaticDataPool.ERROR;
	}

	/**
	 * 查询书籍信息
	 * 
	 * @return
	 */
	public String query() {
		bookDTOs = bookService.query("1 = 1");
		if (bookDTOs != null) {		
			ActionContext.getContext().put(StaticDataPool.BOOK_SIZE, bookDTOs.size());
		} else {
			ActionContext.getContext().put(StaticDataPool.BOOK_SIZE, 0);
		}
		return StaticDataPool.SUCCESS;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String modifyQuery() {
		StaticDataPool.modifyId = book.getCode();
		bookDetailDTO = bookService.modifyQuery(book.getCode());
		return StaticDataPool.SUCCESS;
	}

	/**
	 * 修改图书信息
	 * 
	 * @return
	 */
	public String modify() {
		if (bookService.update(book)) {
			StaticDataPool.TYPE = 2;
			return StaticDataPool.OK;
		}
		StaticDataPool.ERRORDTO.setInfo("未知错误，修改失败~");
		return StaticDataPool.ERROR;
	}

	/**
	 * 删除图书信息
	 * 
	 * @return
	 */
	public String delete() {
		if (bookService.delete(book)) {
			StaticDataPool.TYPE = 3;
			return StaticDataPool.SUCCESS;
		}
		StaticDataPool.ERRORDTO.setInfo("未知错误，删除失败~");
		return StaticDataPool.ERROR;
	}

	/**
	 * 查询图书详细信息
	 * 
	 * @return
	 */
	public String detail() {
		bookDetailDTO = bookService.getBookDetailDTO(book.getCode());
		if(bookDetailDTO != null){
			return StaticDataPool.SUCCESS;
		}
		StaticDataPool.ERRORDTO.setInfo("未知原因");
		return StaticDataPool.ERROR;
	}

	/**
	 * 模糊查询
	 * @return
	 */
	public String ifQuery() {
		System.out.println("type: " + type + " | key : " + key);
		bookQueryDTOs = bookService.ifQuery(type, key);
		if(bookQueryDTOs != null){
			ActionContext.getContext().put(StaticDataPool.BOOK_QUERY_SIZE, bookQueryDTOs.size());
		}
		else{
			ActionContext.getContext().put(StaticDataPool.BOOK_QUERY_SIZE, 0);
		}
		return "query";
	}


	public Book getBook() {
		return book;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public List<BookDTO> getBookDTOs() {
		return bookDTOs;
	}

	public List<BookType> getBookTypes() {
		return bookTypes;
	}

	public List<Publishing> getPublishings() {
		return publishings;
	}

	public List<Bookcase> getBookcases() {
		return bookcases;
	}

	public void setBookDTOs(List<BookDTO> bookDTOs) {
		this.bookDTOs = bookDTOs;
	}

	public void setBookTypes(List<BookType> bookTypes) {
		this.bookTypes = bookTypes;
	}

	public void setPublishings(List<Publishing> publishings) {
		this.publishings = publishings;
	}

	public void setBookcases(List<Bookcase> bookcases) {
		this.bookcases = bookcases;
	}

	public BookDetailDTO getBookDetailDTO() {
		return bookDetailDTO;
	}

	public void setBookDetailDTO(BookDetailDTO bookDetailDTO) {
		this.bookDetailDTO = bookDetailDTO;
	}

	public int getType() {
		return type;
	}

	public String getKey() {
		return key;
	}

	public List<BookQueryDTO> getBookQueryDTOs() {
		return bookQueryDTOs;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setBookQueryDTOs(List<BookQueryDTO> bookQueryDTOs) {
		this.bookQueryDTOs = bookQueryDTOs;
	}
}
