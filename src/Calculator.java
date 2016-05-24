
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Calculator</title>");
		out.println("</head>");
		out.println("<body>");

		String x = null;
		String y = null;
		Double xDouble = null;
		Double yDouble = null;

		if (request.getParameterMap().size() != 0) {
			x = request.getParameter("X");
			y = request.getParameter("Y");

			if (x == null) {
				out.println("<p>X parameter is not sent to server</p>");
			} else if (x.equals("")) {
				out.println("<p>X is empty</p>");
			} else {
				try {
					xDouble = Double.parseDouble(x);
				} catch (NumberFormatException nfe) {
					out.println("<p>X is not a number</p>");
				}
			}

			if (y == null) {
				out.println("<p>X parameter is not sent to server</p>");
			} else if (y.equals("")) {
				out.println("<p>Y is empty</p>");
			} else {
				try {
					yDouble = Double.parseDouble(y);
				} catch (NumberFormatException nfe) {
					out.println("<p>Y is not a number</p>");
				}
			}

			if (xDouble != null && yDouble != null) {
				DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
				String xDecimal = decimalFormat.format(xDouble);
				String yDecimal = decimalFormat.format(yDouble);

				if (request.getParameter("add") != null) {
					System.out.println(request.getParameter("add"));
					out.println(xDecimal + " + " + yDecimal + " = " + decimalFormat.format(xDouble + yDouble));
				} else if (request.getParameter("minus") != null) {
					out.println(xDecimal + " - " + yDecimal + " = " + decimalFormat.format(xDouble - yDouble));
				} else if (request.getParameter("multiply") != null) {
					out.println(xDecimal + " * " + yDecimal + " = " + decimalFormat.format(xDouble * yDouble));
				} else if (request.getParameter("divide") != null) {
					if (yDouble == 0) {
						out.println("Cannot divide by zero");
					} else {
						out.println(xDecimal + " / " + yDecimal + " = " + decimalFormat.format(xDouble / yDouble));
					}
				}
			}
		}

		out.println("<form action=\"Calculator\" method=\"get\">");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>X:</td>");

		if (xDouble == null) {
			out.println("<td><input type=\"text\" name=\"X\" size=\"20\"></td>");
		} else {
			out.println("<td><input type=\"text\" name=\"X\" value=" + xDouble + " size=\"20\"></td>");
		}

		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Y:</td>");

		if (yDouble == null) {
			out.println("<td><input type=\"text\" name=\"Y\" size=\"20\"></td>");
		} else {
			out.println("<td><input type=\"text\" name=\"Y\" value=" + yDouble + " size=\"20\"></td>");
		}

		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type=\"submit\" name=\"add\" value=\"+\">");
		out.println("<input type=\"submit\" name=\"minus\" value=\"-\">");
		out.println("<input type=\"submit\" name=\"multiply\" value=\"*\">");
		out.println("<input type=\"submit\" name=\"divide\" value=\"/\">");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
