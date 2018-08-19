package control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import common.StaticDataPool;
import enity.CardType;
import enity.Reader;
import service.ReaderService;

public class ReaderController extends ActionSupport {
	
	private ReaderService readerService = new ReaderService();
	
	private Reader reader;
	
	private List<Reader> readers;
	
	private String modifyId;
	
	private List<CardType> cardTypes;
	
	public String addQuery(){
		cardTypes = readerService.getCardTypes();
		if(cardTypes == null||cardTypes.size() == 0){
			StaticDataPool.ERRORDTO.setInfo("请先录入证件信息");
			return StaticDataPool.ERROR;
		}
		return "addQuery";		
	}

	/**
	 * 添加读者信息
	 * @return
	 */
	public String add(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		reader.setCreateDate(format.format(new Date()));
		reader.setOperator(StaticDataPool.LOGIN_ID);
		int result = readerService.insert(reader);
		if(result == 0){
			StaticDataPool.ERRORDTO.setInfo("该读者已存在！");
			return StaticDataPool.ERROR;
		}
		else if(result == 1){
			StaticDataPool.TYPE = 1;
			return StaticDataPool.OK;
		}
		else{
			StaticDataPool.ERRORDTO.setInfo("服务器开小差咯~");
			return StaticDataPool.ERROR;
		}
	}
	
	/**
	 * 查询读者信息
	 * @return
	 */
	public String query(){
		readers = readerService.query("1 = 1");
		if(readers != null){
			ActionContext.getContext().put(StaticDataPool.READER_SIZE, readers.size());
		}
		else{
			ActionContext.getContext().put(StaticDataPool.READER_SIZE, 0);
		}
		return StaticDataPool.SUCCESS;
	}
	
	/**
	 * 修改读者时的查询
	 * @return
	 */
	public String modifyQuery(){
		modifyId = reader.getId();
		reader = readerService.modifyQuery(modifyId);
		if(reader != null){
		
			return StaticDataPool.SUCCESS;
		}
		return StaticDataPool.ERROR;
	}
	
	public String modify(){
		if(readerService.update(reader)){
			StaticDataPool.TYPE = 2;
			return StaticDataPool.OK;
		}
		return StaticDataPool.ERROR;
	}
	
	public String delete(){
		if(readerService.delete(reader.getId())){
			StaticDataPool.TYPE = 3;
			return StaticDataPool.OK;
		}
		return StaticDataPool.ERROR;
	}
	
	public String getDetail(){
		return StaticDataPool.ERROR;
	}

	public Reader getReader() {
		return reader;
	}

	public List<Reader> getReaders() {
		return readers;
	}

	public List<CardType> getCardTypes() {
		return cardTypes;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}

	public void setCardTypes(List<CardType> cardTypes) {
		this.cardTypes = cardTypes;
	}
}
