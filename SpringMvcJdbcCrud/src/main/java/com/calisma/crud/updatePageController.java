package com.calisma.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import props.TableProp;
import util.DB;
import util.SessionUtil;

@Controller
public class updatePageController {

	DB db = new DB();
	
	@RequestMapping(value="/updatePage/{pid}" , method = RequestMethod.GET)
	public String edit(@PathVariable int pid, Model model, HttpServletRequest req) {
		req.getSession().setAttribute("pid", pid);
		model.addAttribute("tablePro", tableResult(pid));
		model.addAttribute("catData", new DashboardController().catResult());
		return SessionUtil.control(req, "update");
	}
	
	// SELECT TABLE RESULT  -- Product and Category Props
		public TableProp tableResult(int pid){
		
		try {
			String query = "SELECT * FROM product p INNER JOIN category ct ON p.cid = ct.cid WHERE p.pid=?";
			PreparedStatement pre = db.connect(query); 
			pre.setInt(1, pid);
			ResultSet rs = pre.executeQuery();
			
			if(rs.next()) {
				
				TableProp tp = new TableProp();
				tp.setPid(rs.getInt("pid"));
				tp.setPname(rs.getString("pname"));
				tp.setPdesc(rs.getString("pdesc"));
				tp.setPprice(rs.getInt("pprice"));
				tp.setCtitle(rs.getString("ctitle"));
				tp.setCid(rs.getInt("cid"));
				
				return tp;
			}
			
			
		} catch (Exception e) {
			System.err.println("TableResult err " + e);
		}
		
		return null;
	}
		
		@RequestMapping(value="/productUpdate" , method = RequestMethod.POST)
		public String productUpdate(TableProp tp, HttpServletRequest req) {
			int pid = Integer.valueOf(""+req.getSession().getAttribute("pid"));
			
			try {
				String query= "UPDATE product SET pname=?, pdesc=?, pprice=?, cid=? WHERE pid=?";
				PreparedStatement pre = db.connect(query);
				pre.setString(1, tp.getPname());
				pre.setString(2, tp.getPdesc());
				pre.setInt(3, tp.getPprice());
				pre.setInt(4, tp.getCid());
				pre.setInt(5, pid);
				pre.executeUpdate();
				
				
			} catch (Exception e) {
				System.err.println("UPDATE err " + e);
			}
			
			return "redirect:/dashboard";
		}
}
