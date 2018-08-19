package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * 权限表
 * @author NewBies
 *
 */
@Table(name = "authority")
public class Authority {

	/**
	 * 权限ID
	 */
	@Id(name = "authority_id", type = "varchar", length = 50)
	private String authorityId;
	
	/**
	 * 权限名
	 */
	@Column(name = "authority_name", type = "varchar", length = 50)
	private String authorityName;

	public String getAuthorityId() {
		return authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
}
