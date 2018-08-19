package control;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import common.StaticDataPool;
import enity.Bookcase;
import service.BookcaseService;

/**
 * 书架设置接口
 * @author NewBies
 *
 */
public class BookcaseController extends ActionSupport{
	
	private BookcaseService bookcaseService = new BookcaseService();
	
	private Bookcase bookcase;
	
	private List<Bookcase> bookcases;
	
	/**
	 * 添加一个书架信息
	 * @return
	 */
	public String add(){
		int result = bookcaseService.insert(bookcase);
		if(result == 0){
			StaticDataPool.ERRORDTO.setInfo("该信息已存在！");
			return StaticDataPool.ERROR;
		}
		else if(result == 1){
			StaticDataPool.TYPE = 1;
			return StaticDataPool.OK;
		}
		else{
			StaticDataPool.ERRORDTO.setInfo("服务器开小差了~");
			return StaticDataPool.ERROR;
		}
	}
	
	/**
	 * 查询全部书架信息
	 * @return
	 */
	public String query(){
		bookcases = bookcaseService.query("1 = 1");
		if(bookcases != null){
			ActionContext.getContext().put(StaticDataPool.BOOKCASE_SIZE, bookcases.size());
		}
		else{
			ActionContext.getContext().put(StaticDataPool.BOOKCASE_SIZE, 0);
		}
		return StaticDataPool.SUCCESS;
	}
	
	public String modifyQuery(){
		System.out.println("bookcase.getId(): " + bookcase.getId());
		bookcase = bookcaseService.queryById(bookcase.getId());
		if(bookcase != null){
			return "modify";
		}
		return StaticDataPool.ERROR;
	}
	
	/**
	 * 修改书架信息
	 * @return
	 */
	public String modify(){
		
		if(!bookcaseService.update(bookcase)){
			StaticDataPool.ERRORDTO.setInfo("未知原因，修改失败！");
			return StaticDataPool.ERROR;
		}
		StaticDataPool.TYPE = 2;
		return StaticDataPool.OK;
	}
	
	/**
	 * 删除一个书架
	 * @return
	 */
	public String delete(){
		if(!bookcaseService.delete(bookcase)){
			StaticDataPool.ERRORDTO.setInfo("未知原因，删除失败");
			return StaticDataPool.ERROR;
		}
		StaticDataPool.TYPE = 3;
		return StaticDataPool.OK;
	}

	public Bookcase getBookcase() {
		return bookcase;
	}

	public List<Bookcase> getBookcases() {
		return bookcases;
	}

	public void setBookcase(Bookcase bookcase) {
		this.bookcase = bookcase;
	}

	public void setBookcases(List<Bookcase> bookcases) {
		this.bookcases = bookcases;
	}
}
