package service;

import java.util.List;

import dao.BaseJDBCDao;
import enity.BookType;
import utils.StringUtil;


public class BookTypeService {
	
	/**
	 * 查询数据
	 * @param condition
	 * @return
	 */
	public List<BookType> query(String condition){
		//个人自扫门前雪
		if(StringUtil.isNull(condition)){
			return null;
		}
		//过滤危险字符串
		condition = StringUtil.filterString(condition);
		return BaseJDBCDao.select(BookType.class, "select * from book_type where " + condition);
	}
	
	
	/**
	 * 用于修改的查询数据
	 * @param condition
	 * @return
	 */
	public BookType queryById(String id){
		return BaseJDBCDao.selectByKey(BookType.class, "id", id);
	}
	/**
	 * 添加数据
	 * @param bookCase
	 * @return
	 */
	public int insert(BookType bookType){
		List<BookType> bookTypes = BaseJDBCDao.select(BookType.class,
				"select * from book_type where type_name = '" + bookType.getTypeName()+ "'");
		if(bookTypes != null&& bookTypes.size() > 0){
			//该数据存在
			return 0;
		}
		else{
			//添加
			return BaseJDBCDao.add(bookType) ? 1:2;
		}
	}
	
	/**
	 * 修改数据
	 * @param bookCase
	 * @return
	 */
    public boolean update(BookType bookType){
	    return BaseJDBCDao.update(bookType);
	}
    
    /**
     * 删除数据
     * @param bookCase
     * @return
     */
    public boolean deleteById(String id){
    	BookType bookType = BaseJDBCDao.selectByKey(BookType.class, "id", id);
    	if(bookType != null){
    		return BaseJDBCDao.delete(bookType);
    	}
    	else{
    		return false;
    	}
    }
}
