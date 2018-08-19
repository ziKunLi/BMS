package service;

import java.util.List;

import dao.BaseJDBCDao;
import enity.Library;

public class LibraryService {

	/**
	 * 查询数据
	 * @return
	 */
	public Library query(){
		List<Library> libraries = BaseJDBCDao.select(Library.class, "select * from library ORDER BY id DESC LIMIT 1");
		if(libraries == null||libraries.size() == 0){
			return null;
		}
		else{
			return libraries.get(0);
		} 
	}
	
	/**
	 * 修改数据（虽然是修改，但是之前的信息保存了，所以这里是ADD）
	 * @param bookCase
	 * @return
	 */
    public boolean add(Library library){
	    return BaseJDBCDao.add(library);
	}

}
