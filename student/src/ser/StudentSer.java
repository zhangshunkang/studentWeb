package ser;

import impl.StudentImpl;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;

public class StudentSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StudentSer() {
		super();
		System.out.println("---StudentSer()构造方法----");
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("----doPost------");
		String studentRequest = request.getParameter("studentRequest");
		StudentImpl studentImpl = new StudentImpl();
		System.out.println(request.getSession());
		if(studentRequest.equals("saveStudent")){
			request.setCharacterEncoding("UTF-8");
			Student student = new Student();
			student.setSno(request.getParameter("sno"));
			student.setSname(request.getParameter("sname"));
			student.setSsex(request.getParameter("ssex"));
			String sage = request.getParameter("sage");
			int age = Integer.parseInt(sage);
			student.setSage(age);
			student.setSaddress(request.getParameter("saddress"));
			//request.getSession().set
			//把学生记录放到会话中
			request.getSession().setAttribute("student", student);
			studentImpl.saveStudent(student);
			//System.out.println("xueshengbaocunchengong");
			//重定向到提示学生记录保存成功的JSP页面
			RequestDispatcher dispatcher = request.getRequestDispatcher("saveSuccess.jsp");
			dispatcher.forward(request, response);
		}
		else if(studentRequest.equals("queryStudent")) {
			request.setCharacterEncoding("UTF-8");
			String sname = request.getParameter("sname");
			request.getSession().setAttribute("sname", sname);
			ArrayList<Student> students = studentImpl.queryStudent(sname);
			//把数据从servlet传到JSP页面中
			request.setAttribute("students", students);
			//页面间跳转，servlet->jsp，此跳转是内部跳转，不能调到工程外的页面
			RequestDispatcher dispatcher = request.getRequestDispatcher("queryStudent.jsp");
			dispatcher.forward(request, response);
		}
		else if(studentRequest.equals("deleteStudent")) {
			request.setCharacterEncoding("UTF-8");
			String sno = request.getParameter("sno");
			request.getSession().setAttribute("sno", sno);
			studentImpl.deleteStudent(sno);
			//由于数据库改变，前台的页面要同步更新
			String sname = request.getSession().getAttribute("sname").toString();
			ArrayList<Student> students = studentImpl.queryStudent(sname);
			//把数据从servlet传到JSP页面中
			request.setAttribute("students", students);
			//页面间跳转，servlet->jsp，此跳转是内部跳转，不能调到工程外的页面
			RequestDispatcher dispatcher = request.getRequestDispatcher("queryStudent.jsp");
			dispatcher.forward(request, response);
		}
		else if(studentRequest.equals("updateStudent")) {
			request.setCharacterEncoding("UTF-8");
			//request.setCharacterEncoding("UTF-8");
			Student student = new Student();
			student.setSno(request.getParameter("sno"));
			student.setSname(request.getParameter("sname"));
			student.setSsex(request.getParameter("ssex"));
			String sage = request.getParameter("sage");
			int age = Integer.parseInt(sage);
			student.setSage(age);
			student.setSaddress(request.getParameter("saddress"));
			request.setAttribute("student", student);
			studentImpl.updateStudent(student);
			//重定向到更新成功的页面
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateSuccess.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		System.out.println("---init()初始化方法---");
	}

}
