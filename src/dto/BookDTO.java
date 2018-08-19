package dto;

public class BookDTO {
	
	private String code;
	
	private String bookName;
	
	private String typeName;
	
	private String publisher;
	
	private String bookcaseName;

	public String getCode() {
		return code;
	}

	public String getBookName() {
		return bookName;
	}

	public String getTypeName() {
		return typeName;
	}
	
	public String getBookcaseName() {
		return bookcaseName;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public void setBookcaseName(String bookcaseName) {
		this.bookcaseName = bookcaseName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
