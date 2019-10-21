package org.zerock.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.service.SampleService;



@WebServlet("/sampleA")
public class SampleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SampleController() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("GET........");
		
		req.getRequestDispatcher("/WEB-INF/views/input.jsp")
		.forward(req,  resp);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 잘못된 상황
		
		
		//어디로 포워드?? 리스트 페이지 만들기
		System.out.println("POST....");
		String str = req.getParameter("text");
		
		System.out.println("str" + str);
		
		SampleService.INSTANCE.add(str);
		
		resp.sendRedirect("/list?msg=success");
		
//		req.setAttribute("list", SampleService.INSTANCE.getList());
//		
//		req.getRequestDispatcher("/WEB-INF/views/list.jsp")
//		.forward(req, resp);
		
		
		
		
	}
	

}
