package control;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import common.StaticDataPool;
import enity.CardType;
import service.CardTypeService;

public class CardTypeController extends ActionSupport{
	
	private CardTypeService cardTypeService = new CardTypeService();
	
	private CardType cardType;
	
	private List<CardType> cardTypes;

	/**
	 * 添加类型
	 * @return
	 */
	public String add(){
		System.out.println(cardType.getId() + " | " + cardType.getDays() + " | "
							+ cardType.getName() + " | " + cardType.getNumber());
		if(cardTypeService.add(cardType)){
			StaticDataPool.TYPE = 1;
			return StaticDataPool.OK;
		}
		StaticDataPool.ERRORDTO.setInfo("未知原因，添加失败~");
		return StaticDataPool.ERROR;
	}
	
	/**
	 * 修改证件信息
	 * @return
	 */
	public String modify(){
		cardType.setId(StaticDataPool.modifyId);
		if(cardTypeService.update(cardType)){
			StaticDataPool.TYPE = 2;
			return StaticDataPool.OK;
		}
		StaticDataPool.ERRORDTO.setInfo("修改信息失败");
		return StaticDataPool.ERROR;
	}
	
	public String modifyQuery(){
		StaticDataPool.modifyId = cardType.getId() + "";
		cardType = cardTypeService.modifyQuery(cardType.getId() + "");
		return "modifyQuery";
	}
	
	/**
	 * 查询信息
	 * @return
	 */
	public String query(){
		cardTypes = cardTypeService.query();
		if(cardTypes != null){
			ActionContext.getContext().put(StaticDataPool.CARD_TYPE_SIZE, cardTypes.size());
		}
		else{
			ActionContext.getContext().put(StaticDataPool.CARD_TYPE_SIZE, 0);
		}
		return StaticDataPool.SUCCESS;
	}
	
	/**
	 * 删除信息
	 * @return
	 */
	public String delete(){
		if(cardTypeService.delete(cardType)){
			StaticDataPool.TYPE = 3;
			return StaticDataPool.OK;
		}
		StaticDataPool.ERRORDTO.setInfo("删除失败！");
		return StaticDataPool.ERROR;
	}

	public CardType getCardType() {
		return cardType;
	}

	public List<CardType> getCardTypes() {
		return cardTypes;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public void setCardTypes(List<CardType> cardTypes) {
		this.cardTypes = cardTypes;
	}
}
