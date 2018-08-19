package dto;

public class BookDetailDTO {
	
	private String code;
	
	private String bookName;
	
	private String bookTypeName;
	
	private String author;
	
	private String translator;
	
	private String publisher;
	
	private float price;
	
	private Integer pageNumber;
	
	private String bookcaseId;
	
	private String inTime;
	
	private String operator;

	public String getCode() {
		return code;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public String getAuthor() {
		return author;
	}

	public String getTranslator() {
		return translator;
	}

	public String getPublisher() {
		return publisher;
	}

	public float getPrice() {
		return price;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public String getBookcaseId() {
		return bookcaseId;
	}

	public String getInTime() {
		return inTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setBookcaseId(String bookcaseId) {
		this.bookcaseId = bookcaseId;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
