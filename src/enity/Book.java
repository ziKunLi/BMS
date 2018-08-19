package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * 书籍表
 * @author NewBies
 *
 */
@Table(name = "book")
public class Book {
	
	/**
	 * 条形码
	 */
	@Id(name = "code",type = "varchar",length = 20)
	private String code;
	
	/**
	 * 所属的类型编号
	 */
	@Column(name = "type_id",type = "varchar",length = 10)
	private String typeId;
	
	/**
	 * 书籍名称
	 */
	@Column(name = "book_name",type = "varchar",length = 20)
    private String bookName;
    
	/**
	 * 作者
	 */
	@Column(name = "author",type = "varchar",length = 20)
    private String author;
    
	/**
	 * 译者
	 */
	@Column(name = "translator",type = "varchar",length = 20)
    private String translator;
    
	/**
	 * 出版社
	 */
	@Column(name = "publisher",type = "varchar",length = 20)
    private String publisher;
	
	/**
	 * 价格
	 */
	@Column(name = "price",type = "float",length = 10)
    private Float price;
    
	/**
	 * 页数
	 */
	@Column(name = "page",type = "int",length = 10)
    private int page;
    
	/**
	 * 所属书架编号
	 */
	@Column(name = "bookcase_id",type = "varchar",length = 20)
    private String bookcaseId;
    
	/**
	 * 入库时间
	 */
	@Column(name = "in_time",type = "varchar",length = 20)
    private String inTime;
    
	/**
	 * 操作员
	 */
	@Column(name = "operator",type = "varchar",length = 20)
    private String operator;
	
	/**
	 * 是否删除（软删除，删除图书，但保留记录）
	 */
	@Column(name = "is_delete",type = "bit",length = 1)
    private boolean isDelete;
	
	/**
	 * 是否被借出
	 */
	@Column(name = "is_borrowed", type = "bit", length = 1)
	private boolean isBorrowed;
    
	public String getTypeId() {
		return typeId;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTranslator() {
		return translator;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public int getPage() {
		return page;
	}

	public String getInTime() {
		return inTime;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public void setPage(int page) {
		this.page = page;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getCode() {
		return code;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getBookcaseId() {
		return bookcaseId;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setBookcaseId(String bookcaseId) {
		this.bookcaseId = bookcaseId;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}    
	
	
}
