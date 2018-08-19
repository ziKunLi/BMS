package utils;

public class StringUtil {
	
	/**
	 * 判断一个字符串是否为空
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
		//判断长度
		else if(id.length() != 11){
			return false;
		}
		else{
			//判断是否全为数字
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
	 * 转码处理
	 * @param string
	 * @return
	 */
	public static String toChinese(String string) {
		try {
			//当变量string为null时
			if (string == null) {	
				//将变量string赋值为空
				string="";											
			} else {
				//将字符串转换为UTF-8编码
				string = new String(string.getBytes("ISO-8859-1"), "UTF-8");	
				//去除字符串的首尾空格
				string = string.trim();								
			}
		} catch (Exception e) {
			//将变量string赋值为空
			string="";												
		}
		//返回转换后的输入变量string
		return string;												
	}

	/**
	 * 过滤危险字符
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
