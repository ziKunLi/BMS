package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * 管理员权限表
 * @author NewBies
 *
 */
@Table(name = "manager_authority")
public class ManagerAuthority {
	
	/**
	 * 管理员ID
	 */
	@Id(name = "manager_id", type = "varchar", length = 11)
	private String managerId;
	
	/**
	 * 权限ID
	 */
	@Column(name = "authority_id", type = "varchar", length = 50)
	private String authorityId;

	public String getManagerId() {
		return managerId;
	}

	public String getAuthorityId() {
		return authorityId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

}
