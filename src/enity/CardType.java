package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * 证件类型表
 * @author NewBies
 *
 */
@Table(name = "card_type")
public class CardType {

	/**
	 * 证件类型编号
	 */
	@Id(name = "id", type = "varcahr", length = 4)
	private String  id;
	
	/**
	 * 证件类型名
	 */
	@Column(name = "name", type = "varchar", length = 16)
	private String name;
	
	/**
	 * 可借书数量
	 */
	@Column(name = "number", type = "int", length = 8)
	private int number;
	
	/**
	 * 可借天数
	 */
	@Column(name = "days", type = "int", length = 8)
	private int days;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public int getDays() {
		return days;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setDays(int days) {
		this.days = days;
	}
}
