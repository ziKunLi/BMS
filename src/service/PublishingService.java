package service;

import java.util.List;

import dao.BaseJDBCDao;
import utils.StringUtil;
import enity.Publishing;

public class PublishingService {

	/**
	 * 查询数据
	 * @param condition
	 * @return
	 */
	public List<Publishing> query(String condition){
		//个人自扫门前雪
		if(StringUtil.isNull(condition)){
			return BaseJDBCDao.select(Publishing.class,"select * from publisher where "+condition+"");
		}
		//过滤危险字符串
		condition = StringUtil.filterString(condition);
		return BaseJDBCDao.select(Publishing.class, "select * from publisher");
	}

}
