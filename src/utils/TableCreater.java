package utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import enity.Authority;
import enity.Book;
import enity.BookType;
import enity.Bookcase;
import enity.Borrow;
import enity.CardType;
import enity.Library;
import enity.Manager;
import enity.ManagerAuthority;
import enity.Parameter;
import enity.Publishing;
import enity.Reader;
import utils.ConPool;
import utils.MyCon;

public class TableCreater {
	
	public static void main(String[] args){
//		System.out.println(createTable(Book.class));
//		System.out.println(createTable(Bookcase.class));
//		System.out.println(createTable(Borrow.class));
//		System.out.println(createTable(Library.class));
//		System.out.println(createTable(Manager.class));
//		System.out.println(createTable(Parameter.class));
//		System.out.println(createTable(Publishing.class));
//		System.out.println(createTable(Reader.class));
//		System.out.println(createTable(CardType.class));
//		System.out.println(createTable(Authority.class));
//		System.out.println(createTable(BookType.class));
		System.out.println(createTable(ManagerAuthority.class));
	}
	
	public static boolean createTable(Class<?> clazz){
		StringBuffer sql = new StringBuffer();
		sql.append("Create table ");
		Table table = (Table)clazz.getAnnotation(Table.class);
		if(table == null){
			return false;
		}
		else{
			sql.append(table.name() + "(\n");
		}
		
		Field[] fields = clazz.getDeclaredFields();
	    for(Field field : fields){
	       	//锟叫断革拷锟街讹拷锟斤拷锟角凤拷锟斤拷指锟斤拷锟斤拷注锟斤拷
	       	if(!field.isAnnotationPresent(Id.class)&&!field.isAnnotationPresent(Column.class)){
	       		continue;
	       	}
	       	if(field.isAnnotationPresent(Id.class)){
	       		Id id = field.getAnnotation(Id.class);
	       		sql.append("\t" + id.name() + " " + id.type() + " (" +id.length() +") primary key,\n");
	       	}
	       	else if(field.isAnnotationPresent(Column.class)){
	       		Column column = field.getAnnotation(Column.class);
	       		sql.append("\t" + column.name() + " " +column.type());
	       		if(!column.type().toLowerCase().equals("date")){
	       			sql.append(" (" + column.length() + ")");
	       		}
	       		if(!column.isNull()){
	       			sql.append(" not null,\n");
	       		}
	       	}
	    }
	    sql.setLength(sql.length() - 2);
       	sql.append("\n\t\t)");
	    System.out.println(sql);
		return execute(sql.toString());
	}
	
	/**
	 * 执锟叫非诧拷询锟斤拷sql锟斤拷锟�
	 * @param sql
	 * @return
	 */
	private static boolean execute(String sql) {

		try {
			// 锟斤拷取一锟斤拷锟斤拷锟接讹拷锟斤拷
			MyCon myCon = ConPool.getInstance().getCon();
			System.out.println(myCon);
			Connection connection = myCon.getConnection();
			System.out.println(connection);
			Statement statement = connection.createStatement();
			statement.execute(sql);
			// 锟斤拷锟斤拷使锟斤拷锟斤拷辖锟斤拷锟斤拷锟轿拷锟斤拷锟�
			ConPool.getInstance().setFree(myCon);
		} catch (SQLException e) {
			
			return false;
		}
		return true;
	}
}
