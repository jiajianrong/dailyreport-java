package jr58;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WebApi extends HttpServlet {
	
    private static final long serialVersionUID = 1L;  
  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");  
        resp.setContentType( "application/json; charset=utf-8" ) ;  //设置响应页面字符编码  
        PrintWriter out = resp.getWriter() ;    
        
        
        String action = req.getParameter("action");
        
        
        
        //--------------------
        // 列出某id下的所有report
        //--------------------
        if ("list".equalsIgnoreCase(action)) {
        	
        	String rtn = Logic.list(req).toString();
        	out.write(jsonpWrap(req, rtn));
        }
        
        
        
        //--------------------
        // 新增report
        //--------------------
        else if ("add".equalsIgnoreCase(action)) {
        	
        	String rtn = Logic.add(req);
        	out.write(jsonpWrap(req, rtn));
        }
        
        
        
        
        // 删除report
        else if ("remove".equalsIgnoreCase(action)) {
        	
        	String rtn = Logic.remove(req);
        	out.write(jsonpWrap(req, rtn));
        }
        
        
        
        else {
        	String rtn = "{\"rtnCode\":\"-1\", \"errMsg\":\"action参数未识别\"}";
        	out.write(jsonpWrap(req, rtn));
        }
        
        
        
        out.flush();
        out.close() ;    
          
        
        
        
        
        //当此Servlet得到这个请求，可以选择自己处理，或者调用其他页面进行处理  
        //这里此Servlet将请求内容转给dealpage.jsp这个页面去处理请求。  
        //相当于本来表单提交给此servlet处理的，现在相当于做一个转向，让提交的表单给dealpage.jsp处理  
          
        //RequestDispatcher dispatcher = req.getRequestDispatcher("dealpage.jsp");  
        //dispatcher.forward(req, resp);  
          
        //super.doGet(req, resp);  
    }  
  
    @Override 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req,resp);
    }
    
    
    /**
     * Helper
     * @param req
     * @param str:   "[{\"id\":\"5024\", \"name\":\"贾建容\", \"date\":\"2016-01-13\", \"content\":\"痴痴缠缠\"}]"
     * @return
     */
    private static String jsonpWrap(HttpServletRequest req, String str) {
    	String callback = req.getParameter("callback");
    	return ( callback == null || "".equalsIgnoreCase(callback) ) ? str : callback + "(" + str + ")";
    }
}  