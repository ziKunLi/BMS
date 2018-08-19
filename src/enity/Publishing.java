package enity;

import annotation.Column;
import annotation.Table;

/**
 * 出版表
 * @author NewBies
 *
 */
@Table(name = "publisher")
public class Publishing {
	
	/**
	 * 出版社ID
	 */
	@Column(name = "publisher_id", type = "varchar", length=10)
	private String publisher_id;
	
	/**
	 * 出版社名称
	 */
	@Column(name = "publisher_name", type = "varchar", length=10)
    private String publisher_name;

	public String getPublisher_id() {
		return publisher_id;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_id(String publisher_id) {
		this.publisher_id = publisher_id;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
}
