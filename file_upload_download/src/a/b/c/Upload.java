package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uploadPath = request.getSession().getServletContext().getRealPath("./upload");
		int size = 10*1024*1024;
		
		String name="";
		String subject="";
		String filename="";
		String origfilename="";
		try {
			
			MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath, size,"utf-8", new DefaultFileRenamePolicy());
			
			name=multipartRequest.getParameter("name");
			subject=multipartRequest.getParameter("subject");
			
			Enumeration<?> enumeration = multipartRequest.getFileNames();
			String file = (String)enumeration.nextElement();
			filename = multipartRequest.getFilesystemName(file);
			origfilename = multipartRequest.getOriginalFileName(file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		
		printWriter.println("<head><link rel='stylesheet' type='text/css' href='./css/layout.css'></head>");
		printWriter.println("<div class='input_group'> 이름 : " + name + "</div>");
		printWriter.println("<div class='input_group'> 제목 : " + subject + "</div>");
		String file_name = filename;
	
		file_name = URLEncoder.encode(file_name, "UTF-8");
		printWriter.println("<div class='input_group'> 파일명 : "+"<a href='./Download?file_name=" + file_name +"'>"+ origfilename +"</a></div>");
	}
}
