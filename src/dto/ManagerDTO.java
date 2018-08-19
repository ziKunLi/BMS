package dto;

public class ManagerDTO {

	private String id;
	
	private String name;
	
	private String systemSet;
	
	private String readerSet;
	
	private String bookSet;
	
	private String borrowSet;
	
	private String systemQuerySet;
	
	public ManagerDTO(){
		this.systemSet = "否";
		this.readerSet = "否";
		this.bookSet = "否";
		this.borrowSet = "否";
		this.systemQuerySet = "否";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSystemSet() {
		return systemSet;
	}

	public String getReaderSet() {
		return readerSet;
	}

	public String getBookSet() {
		return bookSet;
	}

	public String getBorrowSet() {
		return borrowSet;
	}

	public String getSystemQuerySet() {
		return systemQuerySet;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSystemSet(String systemSet) {
		this.systemSet = systemSet;
	}

	public void setReaderSet(String readerSet) {
		this.readerSet = readerSet;
	}

	public void setBookSet(String bookSet) {
		this.bookSet = bookSet;
	}

	public void setBorrowSet(String borrowSet) {
		this.borrowSet = borrowSet;
	}

	public void setSystemQuerySet(String systemQuerySet) {
		this.systemQuerySet = systemQuerySet;
	}
}
