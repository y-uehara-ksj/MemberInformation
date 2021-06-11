package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.aforce.bean.Information;

public class InformationDao extends Dao{
	
	public List<Information> search(String keyword) throws Exception {
		List<Information> list=new ArrayList<>();
		
		
		return list;
	}
	
	public int insert(Information information) throws Exception {
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
		"insert into members values(?, ?, ?, ?, ?, ?)");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		String memberNo = "A"+ sdf.format(date);
		st.setString (1,memberNo);
		System.out.println(information.getName());
		st.setString(2, information.getName());
		st.setInt(3, information.getAge());
		st.setInt(4, information.getBirthYear());
		st.setInt(5, information.getBirthMonth());
		st.setInt(6, information.getBirthDay());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	
}

