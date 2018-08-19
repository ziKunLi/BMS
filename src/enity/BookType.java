package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * 书籍类型表
 * @author NewBies
 *
 */
@Table (name = "book_type")
public class BookType {
	
	/**
	 * 可借天数
	 */
	@Column(name = "days",type = "int",length = 10)
    private int days;
	
	/**
	 * 类型编号
	 */
	@Id(name = "id",type= "varchar",length = 10)
    private String id;
	
	/**
	 * 类型名称
	 */
	@Column(name = "type_name",type = "varchar",length = 20)
    private String typeName;

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public String getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

}
