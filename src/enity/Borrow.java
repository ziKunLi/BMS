package enity;


import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * 借阅表
 * @author NewBies
 *
 */
@Table(name = "borrow")
public class Borrow{
	
	/**
	 * 借书号
	 */
	@Id(name = "code",type= "varchar",length=50)
    private String code;
	
	/**
	 * 书籍ID
	 */
	@Column(name = "book_code",type= "varchar",length=20)
    private String bookCode;
	
	/**
	 * 借阅时间
	 */
	@Column(name = "borrow_time",type= "varchar",length=20)
    private String borrowTime;
	
	/**
	 * 实际归还时间
	 */
	@Column(name = "back_time",type= "varchar",length=20)
    private String backTime;
	
	/**
	 * 应该归还时间
	 */
	@Column(name = "should_back_time", type = "varchar", length = 20)
	private String  shouldBackTime;
	
	/**
	 * 是否归还
	 */
	@Column(name = "if_back",type= "int",length=10)
    private int ifBack;
	
	/**
	 * 操作人
	 */
	@Column(name = "operator",type= "varchar",length=20)
    private String operator;
	
	/**
	 * 书架Id
	 */
	@Column(name = "bookcase_id",type= "varchar",length=20)
    private String bookcaseId;
	
	/**
	 * 借阅者证件号码
	 */
	@Column(name = "card_no",type= "varchar",length=20)
    private String cardNo;
	
	/**
	 * 读者姓名
	 */
	@Column(name = "reader_name",type= "varchar",length=20)
    private String readerName;
	
	/**
	 * 软删除
	 */
	@Column(name = "id_delete",type = "bit", length = 1)
	private boolean isDelete;

	public String getBackTime() {
		return backTime;
	}

	public String getBorrowTime() {
		return borrowTime;
	}

	public int getIfBack() {
		return ifBack;
	}

	public String getOperator() {
		return operator;
	}

	public String getReaderName() {
		return readerName;
	}
	
	public void setBackTime(String backTime) {
		this.backTime = backTime;
	}
	
	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public void setIfBack(int ifBack) {
		this.ifBack = ifBack;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getCode() {
		return code;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getShouldBackTime() {
		return shouldBackTime;
	}

	public void setShouldBackTime(String shouldBackTime) {
		this.shouldBackTime = shouldBackTime;
	}

	public String getBookcaseId() {
		return bookcaseId;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setBookcaseId(String bookcaseId) {
		this.bookcaseId = bookcaseId;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
}
