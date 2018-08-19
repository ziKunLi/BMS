package control;

import com.opensymphony.xwork2.ActionSupport;

import common.StaticDataPool;
import service.PublishingService;

/**
 * 出版信息接口
 * @author NewBies
 *
 */
public class PublishingController extends ActionSupport{
	
	private PublishingService publishingService = new PublishingService();
	
	public String query(){
		return StaticDataPool.ERROR;
	}
}
