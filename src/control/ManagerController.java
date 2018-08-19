package control;

import service.ManagerAutorityService;
import service.ManagerService;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import common.StaticDataPool;
import dto.ManagerAddDTO;
import dto.ManagerDTO;
import enity.Manager;

public class ManagerController extends ActionSupport {

	private ManagerService managerService = new ManagerService();
	private ManagerAutorityService managerAutorityService = new ManagerAutorityService();
	/**
	 * 表单提交，数据传递时使用
	 */
	private Manager manager;
	/**
	 * 查询时传递给前台的数据
	 */
	private List<Manager> managers;
	/**
	 * 用于添加管理员
	 */
	private ManagerAddDTO managerAddDTO;
	
	/**
	 * 用于管理员查询
	 */
	private List<ManagerDTO> managerDTOs;
	
	/**
	 * 用于管理员权限设置
	 */
	private ManagerDTO managerDTO = new ManagerDTO();;
	
	/**
	 * 进行修改的管理员的ID
	 */
	private String modifyId;

	/**
	 * 管理员登录
	 * @return
	 */
	public String login() {
		Manager result = managerService.checkManager(manager);
		if(result == null){
			StaticDataPool.ERRORDTO.setInfo("用户不存在！");
			return StaticDataPool.ERROR;
		}
		else if(result.getPwd().equals(manager.getPwd())){
			manager = result;
			StaticDataPool.LOGIN_ID = manager.getId();
			StaticDataPool.LOGIN_NAME = manager.getName();
			List<String> managerAuthorities = managerAutorityService.getManagerAutority(manager.getId());
			if(managerAuthorities != null){
				System.out.println("拥有的权限数量 ： " + managerAuthorities.size());
				//为管理员添加权限
				for(int i = 0; i < managerAuthorities.size(); i++){
					StaticDataPool.context.put(managerAuthorities.get(i), 1);
				}
			}
			return query();
		}
		else{
			StaticDataPool.ERRORDTO.setInfo("密码错误");
			return StaticDataPool.ERROR;
		}
	}

	/**
	 * 添加账号
	 * @return
	 */
	public String add() {
		int result = managerService.insert(manager);
		if(result == 1){
			StaticDataPool.TYPE = 1;
			return StaticDataPool.OK;
		}
		else if(result == 0){
			StaticDataPool.ERRORDTO.setInfo("该账号已存在");
			return StaticDataPool.ERROR;
		}
		else{
			StaticDataPool.ERRORDTO.setInfo("服务器开小差了");
			return StaticDataPool.ERROR;
		}
	}

	/**
	 * 查询出所有的管理员
	 * @return
	 */
	public String query() {
		managerDTOs = managerService.query("1 = 1");
		if(managerDTOs != null){
			ActionContext.getContext().put(StaticDataPool.MANAGER_SIZE, managerDTOs.size());
		}
		else{
			System.out.println(ActionContext.getContext());
			ActionContext.getContext().put(StaticDataPool.MANAGER_SIZE, 0);
		}
		return StaticDataPool.SUCCESS;
	}

	/**
	 * 进行修改管理员权限的时候将会先跳转到这个界面，得到该管理员的先关信息
	 * @return
	 */
	public String modifyQuery() {
		modifyId = manager.getId();
		StaticDataPool.context.put("modifyId", modifyId);
		managerDTO = managerService.modifyQuery(manager.getId());
		ActionContext.getContext().put("managerDTO", managerDTO);
		return "modify";
	}

	/**
	 * 权限设置
	 * @return
	 */
	public String modify() {
		System.out.println(managerDTO.getBookSet() + " | " + managerDTO.getBorrowSet() + " | "
							+ managerDTO.getReaderSet() + " | " + managerDTO.getSystemQuerySet()
							+ managerDTO.getSystemSet());
		managerDTO.setId((String)StaticDataPool.context.get("modifyId"));
		int result = managerService.update(managerDTO);
		if(result != 1){
			return StaticDataPool.ERROR;
		}
		StaticDataPool.TYPE = 2;
		return StaticDataPool.OK;
	}

	public String queryPassword() {
		return StaticDataPool.ERROR;
	}

	public String modifyPassword() {
		return StaticDataPool.ERROR;
	}
	
	/**
	 * 删除一个管理员
	 * @return
	 */
	public String delete(){
		if(!managerService.delete(manager)){
			StaticDataPool.ERRORDTO.setInfo("删除失败");
			return StaticDataPool.ERROR;
		}
		StaticDataPool.TYPE = 3;
		return StaticDataPool.OK;
	}

	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public List<Manager> getManagers() {
		return managers;
	}

	public ManagerAddDTO getManagerAddDTO() {
		return managerAddDTO;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

	public void setManagerAddDTO(ManagerAddDTO managerAddDTO) {
		this.managerAddDTO = managerAddDTO;
	}

	public List<ManagerDTO> getManagerDTOs() {
		return managerDTOs;
	}

	public void setManagerDTOs(List<ManagerDTO> managerDTOs) {
		this.managerDTOs = managerDTOs;
	}

	public ManagerDTO getManagerDTO() {
		return managerDTO;
	}

	public void setManagerDTO(ManagerDTO managerDTO) {
		this.managerDTO = managerDTO;
	}

	public String getModifyId() {
		return modifyId;
	}

	public void setModifyId(String modifyId) {
		this.modifyId = modifyId;
	}
}
