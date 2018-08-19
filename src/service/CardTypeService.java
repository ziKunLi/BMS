package service;

import java.util.List;

import dao.BaseJDBCDao;
import enity.CardType;

public class CardTypeService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public List<CardType> query(){
		return BaseJDBCDao.select(CardType.class, "select * from card_type");
	}
	
	public CardType modifyQuery(String id){
		return BaseJDBCDao.selectByKey(CardType.class, "id", id);
	}
	

	/**
	 * 修改数据
	 * @param bookCase
	 * @return
	 */
    public boolean update(CardType cardType){
	    return BaseJDBCDao.update(cardType);
	}
    
    /**
     * 删除一种证件类型
     * @param cardType
     * @return
     */
    public boolean delete(CardType cardType){
    	return BaseJDBCDao.delete(cardType);
    }
    
    /**
     * 添加一种证件类型
     * @param cardType
     * @return
     */
    public boolean add(CardType cardType){
    	return BaseJDBCDao.add(cardType);
    }
}
