package control;

import com.opensymphony.xwork2.ActionSupport;

import common.StaticDataPool;
import enity.Library;
import service.LibraryService;


public class LibraryController extends ActionSupport {
	
	private LibraryService libraryService = new LibraryService();
	
	private Library library;
	
	/**
	 * 得到图书馆信息
	 * @return
	 */
	public String getInfo(){
		System.out.println("test");
		library = libraryService.query();
		return "getInfo";
	}
	
	public String modifyInfo(){
		Library result = libraryService.query();
		if(result == null){
			library.setId(0);
		}
		else{
			library.setId(result.getId() + 1);
		}
		if(!libraryService.add(library)){
			StaticDataPool.ERRORDTO.setInfo("服务器开小差咯~");
			return StaticDataPool.ERROR;
		}
		return StaticDataPool.OK;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
}
