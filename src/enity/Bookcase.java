package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * ��ܣ�����Ϣ
 * @author NewBies
 *
 */
@Table (name = "book_case")
public class Bookcase {
	/**
	 * ��ܱ��
	 */
	@Id(name = "id",type = "varchar",length = 10)
    private String id;
	
	/**
	 * �������
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
