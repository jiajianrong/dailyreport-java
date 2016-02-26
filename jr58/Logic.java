package jr58;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Logic {
	
	
	
	public static List list(HttpServletRequest req)   {
		
		String id;
		
		try {
			id = new String(req.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException("出错啦，哥们儿你用的是火星语吗？");
		}
        
        try {
			List list = IO.read(id);
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("出错啦，你丫不是我们公司的吧？");
		}
	}
	
	
	
	public static String add(HttpServletRequest req) {
		
		String id = null;
    	String name = null;
    	String date = null;
    	String content = null;
    	
    	try {
    		id = new String(req.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
        	name = new String(req.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        	date = new String(req.getParameter("date").getBytes("ISO8859-1"),"UTF-8");
        	content = new String(req.getParameter("content").getBytes("ISO8859-1"),"UTF-8");
    	} catch(UnsupportedEncodingException e) {
    		e.printStackTrace();
    		throw new RuntimeException("出错啦，哥们儿你用的是火星语吗？");
    	}
		
		
    	Report r = new Report(id,name,date,content);
    	
    	try {
			IO.write(r);
			return "{\"rtnCode\":\"0\"}";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("出错啦，你怎么连个表单都填不对啊？");
		}
	}
	
	
	
	public static String remove(HttpServletRequest req)   {
		
		String id = null;
    	String date = null;
    	
    	try {
    		id = new String(req.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
        	date = new String(req.getParameter("date").getBytes("ISO8859-1"),"UTF-8");
    	} catch(UnsupportedEncodingException e) {
    		e.printStackTrace();
    		throw new RuntimeException("出错啦，哥们儿你用的是火星语吗？");
    	}
        
        
    	List list = list(req);
    	
    	for ( int i=0; i<list.size(); i++ ) {
    		Report r = (Report)list.get(i);
    		if (r.getDate().equals(date)) {
    			list.remove(i);
    			break;
    		}
    	}
    	
    	
    	try {
			IO.write(id, list);
			return "{\"rtnCode\":\"0\"}";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("出错啦，你瞎删什么呢？");
		}
	}
	
	
	
    

	
	/**
	 * 注入测试数据
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
	}

}
