package control;

import com.opensymphony.xwork2.ActionSupport;

import common.StaticDataPool;
import enity.Parameter;
import service.ParameterService;

public class ParameterController extends ActionSupport {
	
	private ParameterService parameterService = new ParameterService();
	
	private Parameter parameter;
	
	private int id;
	
	public String query(){
		parameter = parameterService.query();
		if(parameter != null){
			id = parameter.getId();
		}
		System.out.println(id);
		return StaticDataPool.SUCCESS;
	}
	
	public String modify(){
		//如果版本号为空，那么设置为0，否者增加一个版本
		Parameter result = parameterService.query();
		if(result == null){
			parameter.setId(0);
		}
		else{
			parameter.setId(result.getId() + 1);
		}
		if(!parameterService.update(parameter)){
			StaticDataPool.ERRORDTO.setInfo("未知错误，更新失败");
			return StaticDataPool.ERROR;
		}
		return StaticDataPool.SUCCESS;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
}
