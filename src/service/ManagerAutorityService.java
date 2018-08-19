package service;

import java.util.ArrayList;
import java.util.List;

import dao.BaseJDBCDao;
import enity.Authority;
import enity.ManagerAuthority;
import utils.StringUtil;

public class ManagerAutorityService {

	/**
	 * 得到管理员拥有的权限
	 * @param managerId
	 * @return
	 */
	public List<String> getManagerAutority(String managerId){
		if(StringUtil.isNull(managerId)){
			return null;
		}
		managerId = StringUtil.filterString(managerId);
		//从权限表中获取到权限ID
		List<ManagerAuthority> managerAuthorities = BaseJDBCDao.select(ManagerAuthority.class,
				"select * from manager_authority where manager_id = " + managerId);
		if(managerAuthorities == null||managerAuthorities.size() == 0){
			return null;
		}
		else{
			List<String> autoritys = new ArrayList<String>();
			for(int i = 0 ; i < managerAuthorities.size(); i++){
				autoritys.add(BaseJDBCDao.selectByKey(Authority.class, 
						"authority_id", managerAuthorities.get(i).getAuthorityId()).getAuthorityName());
			}
			return autoritys;
		}
	}
}
