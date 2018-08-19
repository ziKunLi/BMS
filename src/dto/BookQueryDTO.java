package dto;

public class BookQueryDTO {
	
	private String code;
	
	private String bookName;
	
	private String bookTypeName;
	
	private String publisherName;
	
	private String bookcaseId;

	public String getCode() {
		return code;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public String getBookcaseId() {
		return bookcaseId;
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

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public void setBookcaseId(String bookcaseId) {
		this.bookcaseId = bookcaseId;
	}
	
	
}
