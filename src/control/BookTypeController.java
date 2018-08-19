package control;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import common.StaticDataPool;
import enity.BookType;
import service.BookTypeService;

public class BookTypeController extends ActionSupport {
	
	private BookTypeService bookTypeService = new BookTypeService();
	
	private BookType bookType;
	
	private List<BookType> bookTypes;
	
	/**
	 * 添加书籍类型
	 * @return
	 */
	public String add(){
		int result = bookTypeService.insert(bookType);
		if(result == 0){
			StaticDataPool.ERRORDTO.setInfo("该类型已存在，请勿重复添加");
		}
		else if(result == 1){
			StaticDataPool.TYPE = 1;
			return StaticDataPool.OK;
		}
		StaticDataPool.ERRORDTO.setInfo("服务器开小差了~");
		return StaticDataPool.ERROR;
	}
	
	/**
	 * 查询书籍类型
	 * @return
	 */
	public String query(){
		bookTypes = bookTypeService.query(" 1 = 1");
		if(bookTypes != null){
			ActionContext.getContext().put(StaticDataPool.BOOK_TYPE_SIZE, bookTypes.size());
		}
		else{
			ActionContext.getContext().put(StaticDataPool.BOOK_TYPE_SIZE, 0);
		}
		return StaticDataPool.SUCCESS;
	}
	
	/**
	 * 修改时进行查询
	 * @return
	 */
	public String modifyQuery(){
		bookType = bookTypeService.queryById(bookType.getId());
		if(bookType != null){
			return "modifyQuery";
		}
		return StaticDataPool.ERROR;
	}
	
	/**
	 * 修改书籍类型
	 * @return
	 */
	public String modify(){
		System.out.println(bookType.getId() + " | " + bookType.getTypeName() + " | " +bookType.getDays());
		if(!bookTypeService.update(bookType)){
			StaticDataPool.ERRORDTO.setInfo("未知错误，更新失败~");
			return StaticDataPool.ERROR;
		}
		else{
			StaticDataPool.TYPE = 2;
			return StaticDataPool.OK;
		}
	}
	
	/**
	 * 删除书籍类型
	 * @return
	 */
	public String delete(){
		if(!bookTypeService.deleteById(bookType.getId())){
			StaticDataPool.ERRORDTO.setInfo("未知错误，删除失败~");
			return StaticDataPool.ERROR;
		}
		else{
			StaticDataPool.TYPE = 3;
			return StaticDataPool.OK;
		}
	}

	public BookType getBookType() {
		return bookType;
	}

	public List<BookType> getBookTypes() {
		return bookTypes;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public void setBookTypes(List<BookType> bookTypes) {
		this.bookTypes = bookTypes;
	}
}
