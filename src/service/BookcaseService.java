package service;

import java.util.List;

import dao.BaseJDBCDao;
import enity.Bookcase;
import utils.StringUtil;

public class BookcaseService {
	
	/**
	 * 查询数据
	 * @param condition
	 * @return
	 */
	public List<Bookcase> query(String condition){
		//个人自扫门前雪
		if(StringUtil.isNull(condition)){
			return null;
		}
		//过滤危险字符串
		condition = StringUtil.filterString(condition);
		return BaseJDBCDao.select(Bookcase.class, "select * from book_case where " + condition);
	}
	
	public Bookcase queryById(String id){
		return BaseJDBCDao.selectByKey(Bookcase.class, "id", id);
	}
	
	/**
	 * 添加数据
	 * @param bookCase
	 * @return
	 */
	public int insert(Bookcase bookCase){
		List<Bookcase> bookCases = BaseJDBCDao.select(Bookcase.class,
				"select * from book_case where name = '" + bookCase.getName() + "'");
		if(bookCases != null&& bookCases.size() > 0){
			//该数据已存在
			return 0;
		}
		else{
			//添加
			return BaseJDBCDao.add(bookCase) ? 1:2;
		}
	}
	
	/**
	 * 修改数据
	 * @param bookCase
	 * @return
	 */
    public boolean update(Bookcase bookCase){
	    return BaseJDBCDao.update(bookCase);
	}
    
    /**
     * 删除数据
     * @param bookCase
     * @return
     */
    public boolean delete(Bookcase bookCase){
    	return BaseJDBCDao.delete(bookCase);
    }
}
