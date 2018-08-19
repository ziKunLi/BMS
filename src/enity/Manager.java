package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * 管理员表
 * @author NewBies
 *
 */
@Table(name = "Manager")
public class Manager{
	
	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	/**
	 * 管理员账号（电话）
	 */
	@Id(name = "manager_id",type="varchar",length = 11)
    private String managerId;
	
	/**
	 * 管理员名字
	 */
	@Column(name ="name", type= "varchar",length = 20)
    private String name;
	
	/**
	 * 管理员密码
	 */
	@Column(name ="pwd", type= "varchar",length = 20)
    private String pwd;
	
    public String getId() {
        return managerId;
    }

    public void setId(String managerId) {
        this.managerId = managerId;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }
}
