package enity;

import annotation.Column;
import annotation.Id;
import annotation.Table;


@Table(name = "Library")
public class Library {
	/**
	 * 地点
	 */
	@Column(name ="address", type= "varchar",length = 20)
    private String address;
	
	/**
	 * 馆长
	 */
	@Column(name ="curator", type= "varchar",length = 20)
    private String curator;
	
	/**
	 * 邮箱
	 */
	@Column(name ="email", type= "varchar",length = 20)
    private String email;
	
	/**
	 * 版本号
	 */
	@Id(name ="id", type= "int",length = 11)
    private Integer id;
	
	/**
	 * 简介
	 */
	@Column(name ="introduce", type= "varchar",length = 255)
    private String introduce;
	
	/**
	 * 图书馆名字
	 */
	@Column(name ="library_name", type= "varchar",length = 20)
    private String libraryName;
	
	/**
	 * 联系电话
	 */
	@Column(name ="tel", type= "varchar",length = 11)
    private String tel;
	
	/**
	 * 建管时间
	 */
	@Column(name ="create_date", type= "varchar",length = 20)
    private String createDate;
	
	/**
	 * 图书馆官网网址
	 */
	@Column(name ="url", type= "varchar",length = 20)
    private String url;
	
    public Library(){
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public String getCurator() {
        return curator;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String getTel() {
        return tel;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getUrl() {
        return url;
    }

}
