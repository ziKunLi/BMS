package dto;

public class BookborrowDTO {
	
	private String code;
	
	private String bookName;
	
	private String readerId;
	
	private String readerName;
	
	private String borrowTime;
	
	private String shouldBackTime;
	
	private String bookcaseId;
	
	private String price;

	public String getCode() {
		return code;
	}

	public String getBookName() {
		return bookName;
	}

	public String getReaderId() {
		return readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public String getBorrowTime() {
		return borrowTime;
	}

	public String getShouldBackTime() {
		return shouldBackTime;
	}

	public String getBookcaseId() {
		return bookcaseId;
	}

	public String getPrice() {
		return price;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public void setShouldBackTime(String shouldBackTime) {
		this.shouldBackTime = shouldBackTime;
	}

	public void setBookcaseId(String bookcaseId) {
		this.bookcaseId = bookcaseId;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
