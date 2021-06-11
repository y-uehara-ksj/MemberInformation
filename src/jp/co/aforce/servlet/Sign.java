package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Information;
import jp.co.aforce.dao.InformationDao;

@WebServlet(urlPatterns= {"/servlet/sign"})
public class Sign extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String url="../jsp/sign.jsp";
		
		Information information=new Information();
		
		try {
			
			
		
			//String name=request.getParameter("name");
			
			//int age=Integer.parseInt(request.getParameter("age"));
			//int birthYear=Integer.parseInt(request.getParameter("birthYear"));
			//int birthMonth=Integer.parseInt(request.getParameter("birthMonth"));
			//int birthDay=Integer.parseInt(request.getParameter("birthDay"));
			
			//InformationDao dao=new InformationDao();
			
			
			//information.setName(name);
			//information.setAge(age); 
			//information.setBirthYear(birthYear);
			//information.setBirthMonth(birthMonth);
			//information.setBirthDay(birthDay);
			
			if(request.getParameter("name")== null || request.getParameter("name").length()==0 ||
				request.getParameter("age")== null || request.getParameter("age").length()==0 || 
				request.getParameter("birthYear")==null ||request.getParameter("birthYear").length()==0 || 
				request.getParameter("birthMonth")==null || request.getParameter("birthMonth").length()==0 || 
				request.getParameter("birthDay")==null || request.getParameter("birthDay").length()==0) {
				
				information.setError("入力されていない項目があります");
				request.setAttribute("Information", information);
			} else {
				String name=request.getParameter("name");
				int age=Integer.parseInt(request.getParameter("age"));
				int birthYear=Integer.parseInt(request.getParameter("birthYear"));
				int birthMonth=Integer.parseInt(request.getParameter("birthMonth"));
				int birthDay=Integer.parseInt(request.getParameter("birthDay"));
				InformationDao dao=new InformationDao();
				
				information.setName(name);
				information.setAge(age); 
				information.setBirthYear(birthYear);
				information.setBirthMonth(birthMonth);
				information.setBirthDay(birthDay);
				int line=dao.insert(information);
				
				if (line>0) {
					url="../jsp/ok.jsp";
				} else {
					//url="../jsp/error.jsp";
					information.setError("登録に失敗しました");
					request.setAttribute("Informatoin", information);
				}
			
			}
			//if(age  null) {
				//information.setError("入力されていない項目があります");
				//request.setAttribute("Informatoin", information);	
			//}
			
			
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
