package control;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import common.StaticDataPool;
import enity.Borrow;
import service.BorrowService;

public class BorrowController extends ActionSupport{
	
	private BorrowService borrowService = new BorrowService();
	
	private Borrow borrow;
	
	private List<Borrow> borrows;
	
	public String borrowSort(){
		return StaticDataPool.SUCCESS;
	}
	
	/**
	 * 图书借阅
	 * @return
	 */
	public String borrow(){
		
		int result = borrowService.borrow(borrow);
		if(result == 0){
			StaticDataPool.ERRORDTO.setInfo("该书不存在！");
			return StaticDataPool.ERROR;
		}
		else if(result == 1){
			return StaticDataPool.SUCCESS;
		}
		else if(result == 2){
			StaticDataPool.ERRORDTO.setInfo("该书已被借出！");
			return StaticDataPool.ERROR;
		}
		else{
			return StaticDataPool.ERROR;
		}
	}
	
	/**
	 * 图书续借
	 * @return
	 */
	public String renew(){
		return StaticDataPool.ERROR;
	}
	
	/**
	 * 图书归还
	 * @return
	 */
	public String back(){
		return StaticDataPool.ERROR;
	}
	
	/**
	 * 借阅到期提醒
	 * @return
	 */
	public String remind(){
		return StaticDataPool.ERROR;
	}
	
	/**
	 * 借阅信息查询
	 * @return
	 */
	public String query(){
		borrows = borrowService.query();
		if(borrows != null){
			
		}
		return StaticDataPool.SUCCESS;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public List<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}
}
