package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * 书架（柜）信息
 * @author NewBies
 *
 */
@Table (name = "book_case")
public class Bookcase {
	/**
	 * 书架编号
	 */
	@Id(name = "id",type = "varchar",length = 10)
    private String id;
	
	/**
	 * 书架名字
	 */
	@Column (name = "name",type= "varchar",length = 20 )
    private String name;
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
    		return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


}
