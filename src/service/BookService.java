package service;

import java.util.ArrayList;
import java.util.List;

import dao.BaseJDBCDao;
import dto.BookDTO;
import dto.BookDetailDTO;
import dto.BookQueryDTO;
import enity.Book;
import enity.BookType;
import enity.Bookcase;
import enity.Publishing;
import utils.StringUtil;

public class BookService {
	/**
	 * 查询数据
	 * @param condition
	 * @return
	 */
	
	public List<BookDTO> query(String condition){
		//个人自扫门前雪
		if(StringUtil.isNull(condition)){
			return null;
		}
		
		//过滤危险字符串
		condition = StringUtil.filterString(condition);
		List<Book> books = BaseJDBCDao.select(Book.class, "select * from book where " + condition);
		if(books != null){
			List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
			for(int i = 0 ; i < books.size(); i ++){
				BookDTO bookDTO = new BookDTO();
				bookDTO.setBookName(books.get(i).getBookName());
				bookDTO.setCode(books.get(i).getCode());
				bookDTO.setPublisher(BaseJDBCDao.selectByKey(Publishing.class, "publisher_id", books.get(i).getPublisher()).getPublisher_name());
				bookDTO.setTypeName(BaseJDBCDao.selectByKey(BookType.class, "id",books.get(i).getTypeId() + "").getTypeName());
				bookDTO.setBookcaseName(BaseJDBCDao.selectByKey(Bookcase.class, "id", books.get(i).getBookcaseId()).getName());;
				bookDTOs.add(bookDTO);
			}
			return bookDTOs;
		}
		return null;
	}
	
	/**
	 * 修改时的查询
	 * @param code
	 * @return
	 */
	public BookDetailDTO modifyQuery(String code){
		Book book = BaseJDBCDao.selectByKey(Book.class, "code", code);
		if(book != null){
			BookDetailDTO bookDetailDTO = new BookDetailDTO();
			bookDetailDTO.setAuthor(book.getAuthor());
			bookDetailDTO.setBookcaseId(book.getBookcaseId());
			bookDetailDTO.setBookName(book.getBookName());
			bookDetailDTO.setBookTypeName(BaseJDBCDao.selectByKey(BookType.class, "id",book.getTypeId() + "").getTypeName());
			bookDetailDTO.setCode(book.getCode());
			bookDetailDTO.setPrice(book.getPrice());
			bookDetailDTO.setPageNumber(book.getPage());
			bookDetailDTO.setPublisher(BaseJDBCDao.selectByKey(Publishing.class, "publisher_id", book.getPublisher()).getPublisher_name());
			bookDetailDTO.setTranslator(book.getTranslator());
			return bookDetailDTO;
		}
		return null;
	}
	
	/**
	 * 添加数据
	 * @param bookCase
	 * @return
	 */
	public int insert(Book book){
		List<Book> books = BaseJDBCDao.select(Book.class,
				"select * from book where code = '" + book.getCode() + "'");
		if(books != null&& books.size() > 0){
			//该数据已存在
			return 0;
		}
		else{
			//添加
			return BaseJDBCDao.add(book) ? 1:2;
		}
	}
	
	/**
	 * 获取详细信息
	 * @param bookId
	 * @return
	 */
	public BookDetailDTO getBookDetailDTO(String bookCode){
		Book book = BaseJDBCDao.selectByKey(Book.class, "code", bookCode);
		if(book != null){
			BookDetailDTO bookDetailDTO = new BookDetailDTO();
			bookDetailDTO.setAuthor(book.getAuthor());
			bookDetailDTO.setBookcaseId(book.getBookcaseId());
			bookDetailDTO.setBookName(book.getBookName());
			String bookTypeName = BaseJDBCDao.selectByKey(BookType.class, "id", book.getTypeId()).getTypeName();
			bookDetailDTO.setBookTypeName(bookTypeName);
			bookDetailDTO.setCode(book.getCode());
			bookDetailDTO.setInTime(book.getInTime());
			bookDetailDTO.setOperator(book.getOperator());
			bookDetailDTO.setPageNumber(book.getPage());
			bookDetailDTO.setPrice(book.getPrice());
			bookDetailDTO.setPublisher(book.getPublisher());
			bookDetailDTO.setTranslator(book.getTranslator());
			return bookDetailDTO;
		}
		
		return null;
	}
	
	/**
	 * 模糊查询
	 * @param type
	 * @param key
	 * @return
	 */
	public List<BookQueryDTO> ifQuery(int type, String key){
		List<Book> books = null;
		switch(type){
			case 1:
				books = BaseJDBCDao.select(Book.class,"select * from book where code = '" + key + "'");
				break;
			case 2:
				List<BookType> bookTypes = BaseJDBCDao.select(BookType.class, "select * from book_type where type_name = '" + key + "'");
				if(bookTypes != null){
					books = BaseJDBCDao.select(Book.class, "select * from book where type_id = '" + bookTypes.get(0).getId() + "'");
				}
				break;
			case 3:
				books = BaseJDBCDao.select(Book.class, "select * from book where book_name = '" + key + "'");
				break;
			case 4:
				books = BaseJDBCDao.select(Book.class, "select * from book where author = '" + key + "'");
				break;
			case 5:
				books = BaseJDBCDao.select(Book.class, "select * from book where publisher = '" + key + "'");
				break;
			case 6:
				books = BaseJDBCDao.select(Book.class, "select * from book where bookcase_id = '" + key + "'");
				break;
			default:
				break;
		}
		return ifQuery(books);
	}
	
	private List<BookQueryDTO> ifQuery(List<Book> books){
		if(books != null){
			List<BookQueryDTO> bookQueryDTOs = new ArrayList<BookQueryDTO>();
			for(int i = 0; i < books.size(); i++){
				BookQueryDTO bookQueryDTO = new BookQueryDTO();
				bookQueryDTO.setCode(books.get(i).getCode());
				bookQueryDTO.setBookcaseId(books.get(i).getBookcaseId());
				bookQueryDTO.setBookName(books.get(i).getBookName());
				bookQueryDTO.setBookTypeName(BaseJDBCDao.selectByKey(BookType.class, "id", books.get(i).getTypeId()).getTypeName());
				bookQueryDTO.setPublisherName(books.get(i).getPublisher());
				bookQueryDTOs.add(bookQueryDTO);
			}
			return bookQueryDTOs;
		}
		return null;
	}
	
	/**
	 * 修改数据
	 * @param bookCase
	 * @return
	 */
    public boolean update(Book book){
	    return BaseJDBCDao.update(book);
	}
    
    /**
     * 删除数据
     * @param bookCase
     * @return
     */
    public boolean delete(Book book){
    	return BaseJDBCDao.delete(book);
    }
}
