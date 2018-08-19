package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;

/**
 * 参数表
 * @author NewBies
 */
@Table(name = "parameter")
public class Parameter {
	
	/**
	 * 办证费用
	 */
	@Column(name = "cost", type = "int", length=10)
    private int cost;
	
	/**
	 * ID
	 */
	@Id(name = "id", type = "Integer", length=10)
    private Integer id;
	
	/**
	 * 有效期限
	 */
	@Column(name = "validity", type = "int", length=10)
    private int validity;
    public Parameter(){
    }
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public int getValidity() {
        return validity;
    }
}

