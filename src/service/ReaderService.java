package service;

import java.util.List;

import dao.BaseJDBCDao;
import utils.StringUtil;
import enity.CardType;
import enity.Reader;

public class ReaderService {
	/**
	 * 查询数据
	 * @param condition
	 * @return
	 */
	public List<Reader> query(String condition){
		//个人自扫门前雪
		if(StringUtil.isNull(condition)){
			return null;
		}
		//过滤危险字符串
		condition = StringUtil.filterString(condition);
		return BaseJDBCDao.select(Reader.class, "select * from reader where " + condition);
	}
	
	public List<CardType> getCardTypes(){
		return BaseJDBCDao.select(CardType.class, "select * from card_type");
	}
	
	/**
	 * 用于修改的查询
	 * @param condition
	 * @return 
	 */
	public Reader modifyQuery(String id){
		return BaseJDBCDao.selectByKey(Reader.class, "id", id);
	}
	
	
	/**
	 * 添加数据
	 * @param bookCase
	 * @return
	 */
	public int insert(Reader reader){
		List<Reader> Readers = BaseJDBCDao.select(Reader.class,
				"SELECT * FROM tb_reader WHERE barcode=''");
		if(Readers != null&& Readers.size() > 0){
			//具有该名字的书已存在
			return 0;
		}
		else{
			//添加
			return BaseJDBCDao.add(reader) ? 1:2;
		}
	}
	
	/**
	 * 修改数据
	 * @param bookCase
	 * @return
	 */
    public boolean update(Reader reader){
	    return BaseJDBCDao.update(reader);
	}
    
    /**
     * 删除数据
     * @param bookCase
     * @return
     */
    public boolean delete(String id){
    	Reader reader = new Reader();
    	reader.setId(id);
    	return BaseJDBCDao.delete(reader);
    }
}
