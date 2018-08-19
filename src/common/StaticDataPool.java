package common;

import java.util.HashMap;

import dto.Error;

/**
 * 静态常量池
 * @author NewBies
 *
 */
public class StaticDataPool {
	
	/**
	 * 当前登录用户
	 */
	public static String LOGIN_NAME;
	
	/**
	 * 当前登录账号
	 */
	public static String LOGIN_ID;
	
	/**
	 * 管理员数量
	 */
	public final static String MANAGER_SIZE = "managerSize";
	
	/**
	 * 书柜数量
	 */
	public final static String BOOKCASE_SIZE = "bookcaseSize";
	
	/**
	 * 书籍类型数量
	 */
	public final static String BOOK_TYPE_SIZE = "bookTypeSize";
	
	/**
	 * 书籍数量
	 */
	public final static String BOOK_SIZE = "bookSize";
	
	/**
	 * 图书借阅信息数量
	 */
	public final static String BOOK_BORROW_SIZE = "bookBorrowSize";
	
	/**
	 * 借书卡类型数量
	 */
	public final static String CARD_TYPE_SIZE = "cardTypeSize";
	
	/**
	 * 模糊查询查询到的书籍数量
	 */
	public final static String BOOK_QUERY_SIZE = "bookQuerySize";
	
	/**
	 * 读者数量
	 */
	public final static String READER_SIZE = "readerSize";
	
	/**
	 * 发生错误
	 */
	public final static String ERROR = "error";
	
	/**
	 * 全局的错误信息类
	 */
	public static Error ERRORDTO = new Error();
	
	/**
	 * 成功（一般用作查询信息成功）
	 */
	public final static String SUCCESS = "success";
	
	/**
	 * 添加删除修改成功
	 */
	public final static String OK = "ok";
	
	/**
	 * 操作类型（增删改查）
	 */
	public static int TYPE;
	
	/**
	 * 修改时查询出来的ID
	 */
	public static String modifyId;
	
	/**
	 * 用于全局的变量传递
	 */
	public static HashMap<String, Object> context = new HashMap<String, Object>();

}
