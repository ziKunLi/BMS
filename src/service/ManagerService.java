package service;

import java.util.ArrayList;
import java.util.List;

import dao.BaseJDBCDao;
import dto.ManagerDTO;
import enity.Authority;
import enity.Bookcase;
import enity.Manager;
import enity.ManagerAuthority;
import utils.StringUtil;

public class ManagerService {
	/**
	 * 查询数据
	 * 
	 * @param condition
	 * @return
	 */
	public List<ManagerDTO> query(String condition) {
		// 过滤危险字符串
		condition = StringUtil.filterString(condition);
		System.out.println("condition" + condition);
		// 个人自扫门前雪
		if (StringUtil.isNull(condition)) {
			return null;
		}
		List<Manager> managers = BaseJDBCDao.select(Manager.class,"select * from manager where " + condition);
		if(managers != null){
			List<ManagerDTO> managerDTOs = new ArrayList<ManagerDTO>();
			for(int i = 0; i < managers.size(); i++){
				ManagerDTO managerDTO = new ManagerDTO();
				managerDTO.setId(managers.get(i).getId());
				managerDTO.setName(managers.get(i).getName());
				//从管理员权限表中获取到管理员所拥有的权限ID
				List<ManagerAuthority> managerAuthorities = 
						BaseJDBCDao.select(ManagerAuthority.class,
								"select * from manager_authority where manager_id = " + managers.get(i).getId());
				if(managerAuthorities != null){
					for(int j = 0; j < managerAuthorities.size(); j++){
						//从权限表中通过权限ID获取到权限名
						String name = BaseJDBCDao.selectByKey(Authority.class,"authority_id", 
								managerAuthorities.get(j).getAuthorityId()).getAuthorityName();
						switch(name){
							case "系统设置":
								managerDTO.setSystemSet("是");
								break;
							case "读者管理":
								managerDTO.setReaderSet("是");
								break;
							case "图书管理":
								managerDTO.setBookSet("是");
								break;
							case "图书借还":
								managerDTO.setBorrowSet("是");
								break;
							case "系统查询":
								managerDTO.setSystemQuerySet("是");
								break;
							default:
								break;
						}
					}
				}
				managerDTOs.add(managerDTO);				
			}
			
			return managerDTOs;
		}
		return null;
	}

	/**
	 * 修改时应用的查询方法
	 * @param bookCase
	 * @return
	 */

	public ManagerDTO modifyQuery(String id) {	
		List<ManagerDTO> managerDTOs = query("manager_id = '" + id + "'");
		if(managerDTOs != null){
			return managerDTOs.get(0);
		}
		else{
			return null;
		}
	}

	/**
	 * 管理员身份验证
	 * 
	 * @param bookCase
	 * @return
	 */
	public Manager checkManager(Manager manager) {
		List<Manager> managers = BaseJDBCDao.select(Manager.class, "SELECT * FROM manager where manager_id='" + manager.getId() + "'");
		if(managers != null&&managers.size() > 0){
			return managers.get(0);
		}
		return null;
	}

	/**
	 * 更改口令时应用的查询方法
	 * 
	 * @param bookCase
	 * @return
	 */
	public Manager query_pwd(Manager manager) {
		return BaseJDBCDao.select(Manager.class, "SELECT * FROM manager WHERE name='" + manager.getName() + "'")
				.get(0);
	}

	/**
	 * 添加数据
	 * 
	 * @param bookCase
	 * @return
	 */

	public int insert(Manager manager) {
		List<Manager> managers = BaseJDBCDao.select(Manager.class,
				"SELECT * FROM manager WHERE name='" + manager.getName() + "'");
		if (managers != null && managers.size() > 0) {
			// 该数据已存在
			return 0;
		} else {
			// 添加
			return BaseJDBCDao.add(manager) ? 1 : 2;
		}
	}

	/**
	 * 设置管理员权限
	 * 
	 * @param bookCase
	 * @return
	 */

	public int update(ManagerDTO managerDTO) {
		System.out.println(managerDTO.getId());
		List<ManagerAuthority> managerAuthorities = 
				BaseJDBCDao.select(ManagerAuthority.class, 
						"select * from manager_authority where manager_id = '" + managerDTO.getId() + "'");
		if(managerAuthorities != null){
			for(int i = 0; i < managerAuthorities.size(); i++){
				boolean result = BaseJDBCDao.delete(managerAuthorities.get(i));
				if(!result){
					//删除权限时发生错误
					return 0;
				}
			}
		}
		if(managerDTO.getSystemSet().equals("1")){
			ManagerAuthority managerAuthority = new ManagerAuthority();
			managerAuthority.setAuthorityId("1");
			managerAuthority.setManagerId(managerDTO.getId());
			boolean result = BaseJDBCDao.add(managerAuthority);
			if(!result){
				//添加权限时发生错误
				return 2;
			}
		}
		if(managerDTO.getBookSet().equals("1")){
			ManagerAuthority managerAuthority = new ManagerAuthority();
			managerAuthority.setAuthorityId("2");
			managerAuthority.setManagerId(managerDTO.getId());
			boolean result = BaseJDBCDao.add(managerAuthority);
			if(!result){
				//添加权限时发生错误
				return 2;
			}
		}
		if(managerDTO.getBorrowSet().equals("1")){
			ManagerAuthority managerAuthority = new ManagerAuthority();
			managerAuthority.setAuthorityId("3");
			managerAuthority.setManagerId(managerDTO.getId());
			boolean result = BaseJDBCDao.add(managerAuthority);
			if(!result){
				//添加权限时发生错误
				return 2;
			}
		}
		if(managerDTO.getReaderSet().equals("1")){
			ManagerAuthority managerAuthority = new ManagerAuthority();
			managerAuthority.setAuthorityId("4");
			managerAuthority.setManagerId(managerDTO.getId());
			boolean result = BaseJDBCDao.add(managerAuthority);
			if(!result){
				//添加权限时发生错误
				return 2;
			}
		}
		if(managerDTO.getSystemQuerySet().equals("1")){
			ManagerAuthority managerAuthority = new ManagerAuthority();
			managerAuthority.setAuthorityId("5");
			managerAuthority.setManagerId(managerDTO.getId());
			boolean result = BaseJDBCDao.add(managerAuthority);
			if(!result){
				//添加权限时发生错误
				return 2;
			}
		}
				
		return 1;
	}

	/**
	 * 修改管理员密码
	 * 
	 * @param bookCase
	 * @return
	 */
	public boolean updatePwd(Manager manager) {
		return BaseJDBCDao.update(manager);
	}

	/**
	 * 删除数据
	 * 
	 * @param bookCase
	 * @return
	 */
	public boolean delete(Manager manager) {
		List<ManagerAuthority> managerAuthorities = 
				BaseJDBCDao.select(ManagerAuthority.class, 
						"select * from manager_authority where manager_id = '" + manager.getId() + "'");
		//先删除管理员拥有的权限
		if(managerAuthorities != null){
			for(int i = 0; i < managerAuthorities.size(); i++){
				boolean result = BaseJDBCDao.delete(managerAuthorities.get(i));
				if(!result){
					return false;
				}
			}
		}
		//然后删除该管理员的账号
		return BaseJDBCDao.delete(manager);
	}
}
