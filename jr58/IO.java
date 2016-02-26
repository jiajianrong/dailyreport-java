package jr58;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IO {
	
	
	/**
	 * 给某用户写(追加)数据
	 * @param r
	 * @throws Exception
	 */
	public static void write(Report r)  throws Exception {
		List list = read(r.getId());
		list.add(r);
		
		FileOutputStream fo = new FileOutputStream( "C:/dailyreport/report-" + r.getId() + ".ser" );   
        ObjectOutputStream so = new ObjectOutputStream(fo);   
  
        so.writeObject(list);   
        so.close();
	}
	
	
	
	/**
	 * 给某用户写(追加)数据
	 * @param r
	 * @throws Exception
	 */
	public static void write(String id, List list)  throws Exception {
		
		FileOutputStream fo = new FileOutputStream( "C:/dailyreport/report-" + id + ".ser" );   
        ObjectOutputStream so = new ObjectOutputStream(fo);   
  
        so.writeObject(list);   
        so.close();
	}
	
	
	
	/**
	 * 读某用户的数据，读不到的话返回空数组
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static List read(String id)  throws Exception {
		FileInputStream fi;
		try {
			fi = new FileInputStream( "C:/dailyreport/report-" + id + ".ser" );   
		} catch (FileNotFoundException e) {
			return new ArrayList();
		}
        ObjectInputStream si = new ObjectInputStream(fi);   
        
        List list = (List) si.readObject();   
        
        si.close();
        
        return list;
	}
    

	
	/**
	 * 注入测试数据
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
        write(new Report("5024","贾建容","2016-01-13","痴痴缠缠"));        
        System.out.println(read("5024"));
	}

}
