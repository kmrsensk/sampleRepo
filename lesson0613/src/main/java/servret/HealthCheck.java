package servret;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HealthCheckLogic;
import model.Syori;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/jsp/healthCheck.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flg = true;
		String height;
		String weight;
		Syori h = new Syori();
		RequestDispatcher dis;
		//formに何も書かれなかった際の対処
		try {
			height= request.getParameter("height");
			weight = request.getParameter("weight");
			h.setHeight(Double.parseDouble(height));
			h.setWeight(Double.parseDouble(weight));
		} catch (Exception e) {
			String error ="";
			request.setAttribute("error",error);
			dis = request.getRequestDispatcher("WEB-INF/jsp/oneMore.jsp");
		}
		HealthCheckLogic hcl = new HealthCheckLogic();
		hcl.excute(h);
		//不正かどうかの判定
		flg = h.syoriMsg();
		// HTML出力
		if(flg) {
			//リクエストスコープ
			request.setAttribute("health",h);
			dis = request.getRequestDispatcher("WEB-INF/jsp/healthCheckResult.jsp");
		}else {
			String error =h.getErrorMsg();
			//リクエストスコープ
			request.setAttribute("error",error);
			dis = request.getRequestDispatcher("WEB-INF/jsp/oneMore.jsp");
		}
		dis.forward(request, response);
	}
}
