package service;

import java.util.List;

import dao.BaseJDBCDao;
import enity.Parameter;

public class ParameterService {
	/**
	 * 查询最新的一条数据
	 * @param condition
	 * @return
	 */
	public Parameter query(){
		
		List<Parameter> parameters = BaseJDBCDao.select(Parameter.class, "select * from parameter order by id desc limit 1");
		
		if(parameters == null || parameters.size() == 0){
			return null;
		} 
		
		return parameters.get(0); 
	}
	

	/**
	 * 修改数据（修改其实是添加了最新的信息，历史数据还是保存着的，所以这里的实际方法是ADD）
	 * @param bookCase
	 * @return
	 */
    public boolean update(Parameter parameter){
	    return BaseJDBCDao.add(parameter);
	}
}
