package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import common.StaticDataPool;
import dao.BaseJDBCDao;
import enity.Book;
import enity.Borrow;

public class BorrowService {

	/**
	 * 查询所有图书的借阅信息
	 * @return
	 */
	public List<Borrow> query(){
		return BaseJDBCDao.select(Borrow.class, "select * from borrow where is_delete != 1");
	}
	
	/**
	 * 删除
	 * @param borrow
	 * @return
	 */
	public Boolean delete(Borrow borrow){
		borrow.setDelete(true);
		return BaseJDBCDao.update(borrow);
	}
	
	/**
	 * 借书
	 * @param borrow
	 * @return
	 */
	public int borrow(Borrow borrow){
		Book book = BaseJDBCDao.selectByKey(Book.class, "code", borrow.getBookCode());
		if(book == null){
			//您要借的书不存在
			return 0;
		}
		else if(book.isBorrowed()){
			//您要借的书已被借出
			return 2;
		}
		else{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			borrow.setBorrowTime(simpleDateFormat.format(new Date()));
			borrow.setOperator(StaticDataPool.LOGIN_ID);
			borrow.setBackTime("");
			borrow.setShouldBackTime("");
			borrow.setBookcaseId(book.getBookcaseId());
			borrow.setDelete(false);
			borrow.setIfBack(0);
			borrow.setCode(UUID.randomUUID().toString());
			book.setBorrowed(true);
			return BaseJDBCDao.add(borrow) ? 1:3;
		}
	}
	
//	public int back(){
//		
//	}
}
