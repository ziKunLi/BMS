package utils;

public class StringUtil {
	
	/**
	 * �ж�һ���ַ����Ƿ�Ϊ��
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		if(str == null||str.trim().equals("")){
			return true;
		}
		return false;
	}
	
	public static boolean isRightId(String id){
		if(isNull(id)){
			return false;
		}
		//�жϳ���
		else if(id.length() != 11){
			return false;
		}
		else{
			//�ж��Ƿ�ȫΪ����
			for(int i = 0; i < id.length(); i++){
				try {
					Integer.parseInt(id.charAt(i) + "");
				} catch (Exception e) {
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * ת�봦��
	 * @param string
	 * @return
	 */
	public static String toChinese(String string) {
		try {
			//������stringΪnullʱ
			if (string == null) {	
				//������string��ֵΪ��
				string="";											
			} else {
				//���ַ���ת��ΪUTF-8����
				string = new String(string.getBytes("ISO-8859-1"), "UTF-8");	
				//ȥ���ַ�������β�ո�
				string = string.trim();								
			}
		} catch (Exception e) {
			//������string��ֵΪ��
			string="";												
		}
		//����ת������������string
		return string;												
	}

	/**
	 * ����Σ���ַ�
	 * @param string
	 * @return
	 */
	public static String filterString(String string){
		string=string.replaceAll(";","");
		string=string.replaceAll("&","&amp;");
		string=string.replaceAll("<","&lt;");
		string=string.replaceAll(">","&gt;");
		string=string.replaceAll("'","");
		string=string.replaceAll("--"," ");
		string=string.replaceAll("/","");
		string=string.replaceAll("%","");
		return string;
	}
}
