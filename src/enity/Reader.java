package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * 读者表
 * @author NewBies
 *
 */
@Table(name = "reader")
public class Reader {
	
	/**
	 * 读者证件编号
	 */
	@Id(name = "id", type = "varchar", length=10)
    private String id;
	
	/**
	 * 读者生日
	 */
	@Column(name = "birthday", type = "varchar", length=20)
    private String birthday;
	
	/**
	 * 创建日期
	 */
	@Column(name = "create_date", type = "varchar", length=20)
    private String createDate;
	
	/**
	 * 邮箱
	 */
	@Column(name = "email", type = "varchar", length=20)
    private String email;
    
	/**
	 * 姓名
	 */
	@Column(name = "name", type = "varchar", length=20)
    private String name;
    
	/**
	 * 创建者
	 */
	@Column(name = "operator", type = "varchar", length=20)
    private String operator;
    
	/**
	 * 性别
	 */
	@Column(name = "sex", type = "varchar", length=20)
    private String sex;
    
	/**
	 * 电话
	 */
	@Column(name = "tel", type = "varchar", length=20)
    private String tel;
	
	/**
	 * 证件类型
	 */
	@Column(name = "card_type", type = "int", length = 4)
	private int cardType;
	
	/**
	 * 不可借书数量
	 */
	@Column(name = "book_number", type = "int", length = 8)
	private int bookNumber;
	
	/**
	 * 不可借书天数（实际借书天数应该为 ： 证件上的可借书天数  - 不可借书天数（这个是根据信誉额度来的））
	 */
	@Column(name = "days", type = "int", length = 8)
	private int days;
	
    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getOperator() {
        return operator;
    }

    public String getSex() {
        return sex;
    }

    public String getTel() {
        return tel;
    }

	public String getId() {
		return id;
	}

	public int getCardType() {
		return cardType;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public int getDays() {
		return days;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public void setDays(int days) {
		this.days = days;
	}
    
}
