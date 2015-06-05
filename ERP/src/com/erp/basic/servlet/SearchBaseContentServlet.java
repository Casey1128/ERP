package com.erp.basic.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.BaseCompany;
import com.erp.basic.entity.BaseContent;
import com.erp.basic.service.BaseCompanyService;
import com.erp.basic.service.BaseContentService;
import com.erp.basic.service.impl.BaseCompanyServiceImpl;
import com.erp.basic.service.impl.BaseContentServiceImpl;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class SearchBaseContentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchBaseContentServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		if (pageSize == null || pageSize.equals("")) {
			pageSize = "3";
		}
		BaseDao baseDao=new BaseDao();
		
		String opt = request.getParameter("opt");
		if (opt != null && opt.equals("1")) {
			String code=request.getParameter("searchcode");
			String codename=request.getParameter("searchcodename");
			String category=request.getParameter("searchcategory");
			String sql1="",sql2="",sql3="";
			String sql="select categorycode,basecontent.code bcode,codename,"
					+ "compname,orderno,basecontent.remarks bremarks,basecontent.adduser badduser,basecontent.isshow bisshow  "
					+ " from basecompany join basecontent on basecompany.code=basecontent.compcode where 1=1 ";
			if(code!=null&&!code.equals("")){
				sql1=" and basecontent.code='"+code+"'";
			}if(codename!=null&&!codename.equals("")){
				sql2=" and codename like '%"+codename+"%'";
			}if(category!=null){
				sql3=" and categorycode='"+category+"'";
			}
			sql=sql+sql1+sql2+sql3+"order by baseContent.code desc";
			ResultSet rs=baseDao.executeQueryForPage(sql, Integer.parseInt(pageNo), Integer.parseInt(pageSize));
			PageBean pageBean=new PageBean();
			List<BaseCompany> bcList=new ArrayList<BaseCompany>();
			BaseCompany baseCompany=null;
			BaseContent baseContent=null;
			try {
				while(rs.next()){
					baseCompany=new BaseCompany();
					baseContent=new BaseContent();
					baseContent.setCategoryCode(rs.getString("categorycode"));
					baseContent.setCode(rs.getString("bcode"));
					baseContent.setCodeName(rs.getString("codename"));
					baseCompany.setCompName(rs.getString("compname"));
					baseContent.setOrderNo(rs.getString("orderno"));
					baseContent.setRemarks(rs.getString("bremarks"));
					baseContent.setAddUser(rs.getString("badduser"));
					baseContent.setIsShow(rs.getInt("bisshow"));
					baseCompany.setBaseContent(baseContent);
					bcList.add(baseCompany);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				baseDao.close();
			}
			pageBean.setData(bcList);
			String ssqqll="select count(*) from basecompany join basecontent on basecompany.code=basecontent.compcode where 1=1"+sql1+sql2+sql3;
			pageBean.setRecordCount(baseDao.executeTotalCount(ssqqll));
			BaseContentService baseContentService = new BaseContentServiceImpl();
			List<BaseContent> list = new ArrayList<BaseContent>();
			list = baseContentService.search();
			pageBean.setPageSize(Integer.parseInt(pageSize));
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("bcList", list);
			request.getSession().setAttribute("Bean", pageBean);
			request.getRequestDispatcher("/erpSystem/contentManagement.jsp")
					.forward(request, response);
			
			
		} else {
			BaseCompanyService baseCompanyService = new BaseCompanyServiceImpl();
			BaseContentService baseContentService = new BaseContentServiceImpl();
			PageBean pageBean = baseCompanyService.findAll(
					Integer.parseInt(pageNo), Integer.parseInt(pageSize));
			pageBean.setPageNo(Integer.parseInt(pageNo));
			List<BaseContent> list = new ArrayList<BaseContent>();
			list = baseContentService.search();
			pageBean.setPageSize(Integer.parseInt(pageSize));
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("bcList", list);
			request.getSession().setAttribute("Bean", pageBean);
			request.getRequestDispatcher("/erpSystem/contentManagement.jsp")
					.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
