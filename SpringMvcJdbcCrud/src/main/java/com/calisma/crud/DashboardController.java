package com.calisma.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import props.CategoryProp;
import props.ProductProp;
import props.TableProp;
import util.DB;
import util.SessionUtil;

@Controller
public class DashboardController {

	DB db = new DB();
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model, HttpServletRequest req) {
		req.getSession().getAttribute("userMail");
		req.getSession().getAttribute("userName");
		model.addAttribute("catData" , catResult());  // kategoriler listelendi
		model.addAttribute("tableData" , tableResult());
		return SessionUtil.control(req, "dashboard");
	}
	

	// Kategoriler getirildi	
	public List<CategoryProp> catResult(){
		
		List<CategoryProp> ls = new ArrayList<CategoryProp>();
		
		try {
			
			String query = "SELECT * FROM `category`";
			PreparedStatement pre = db.connect(query);
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				
				int cid = rs.getInt("cid");
				String ctitle = rs.getString("ctitle");
				
				CategoryProp ct = new CategoryProp();
				ct.setCid(cid);
				ct.setCtitle(ctitle);
				
				ls.add(ct);
			}
			
		} catch (Exception e) {
			System.err.println("Sql error: " + e);
		}
		
		return ls;
	}
	

	// SELECT TABLE RESULT  -- Product and Category Props
	public List<TableProp> tableResult(){
	
	List<TableProp> tableList = new ArrayList<TableProp>();
	
	try {
		String query = "SELECT * FROM product p INNER JOIN category ct ON p.cid = ct.cid ORDER BY p.pid";
		PreparedStatement pre = db.connect(query); 
		ResultSet rs = pre.executeQuery();
		
		while(rs.next()) {
			
			TableProp tp = new TableProp();
			tp.setPid(rs.getInt("pid"));
			tp.setPname(rs.getString("pname"));
			tp.setPdesc(rs.getString("pdesc"));
			tp.setPprice(rs.getInt("pprice"));
			tp.setCtitle(rs.getString("ctitle"));
			tp.setCid(rs.getInt("cid"));
			
			tableList.add(tp);
		}
		
		
	} catch (Exception e) {
		System.err.println("TableResult err " + e);
	}
	
	return tableList;
}


	//INSERT
	@RequestMapping(value="/insertProduct", method = RequestMethod.POST)
	public String insert(ProductProp product) {
		
		try {
			String query = "INSERT INTO `product` (`pid`, `cid`, `pname`, `pdesc`, `pprice`) "
					+ "VALUES (NULL, ?, ?, ?, ?); ";
			PreparedStatement pre = db.connect(query);
			
			int cid = product.getCid();
			String pname = product.getPname();
			String pdesc = product.getPdesc();
			int pprice = product.getPprice();
			
			pre.setInt(1, cid);
			pre.setString(2, pname);
			pre.setString(3, pdesc);
			pre.setInt(4, pprice);
			
			pre.executeUpdate();
			
			
		} catch (Exception e) {
			System.err.println("Insert err " + e);
		}
		
		return "redirect:/dashboard";
	}
	
	//DELETE
	@RequestMapping(value="/delete/{pid}")
	public String delete(@PathVariable int pid) {
		
		try {
			String query = "DELETE FROM product WHERE pid = ?";
			PreparedStatement pre = db.connect(query);
			pre.setInt(1, pid);
			int statu = pre.executeUpdate();

			if (statu > 0) {
				System.out.println("Silme işlemi başarılı");
			} else {
				System.out.println("Silme işlemi hatalı");
			}
			
			
		} catch (Exception e) {
			System.err.println("Delete err " + e);
		}
		
		return "redirect:/dashboard";
	}
	
	
	
	
	
	
}

