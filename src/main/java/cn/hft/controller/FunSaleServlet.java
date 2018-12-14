package cn.hft.controller;

import cn.hft.entity.FunSale;
import cn.hft.entity.Result;
import cn.hft.service.IFunSaleService;
import cn.hft.service.impl.FunSaleServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@WebServlet("/funSale/*")
public class FunSaleServlet extends BaseServlet {
    private IFunSaleService funSaleService = new FunSaleServiceImpl();

    public void findAll(HttpServletResponse response, HttpServletRequest request) throws IOException {
        List<FunSale> funSales = funSaleService.findAll();
        writeValue(funSales, response);
    }

    public void findBySaleId(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String saleId = request.getParameter("saleID");
        Integer saleIdInteger = saleId.compareToIgnoreCase(saleId);
        FunSale funSale = funSaleService.findById(saleIdInteger);
        writeValue(funSale, response);
    }

    public void updateByFunSale(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Result result = null;
        try {
            Enumeration<String> enu = request.getParameterNames();
            StringBuffer json = new StringBuffer("{");
            while(enu.hasMoreElements()){
                String paraName=(String)enu.nextElement();
                String parameterValue = request.getParameter(paraName);
                json.append("\"").append(paraName).append("\"").append(":").append("\"").append(parameterValue).append("\"").append(",");
            }
            String substring = json.substring(0, json.length());
            substring = substring + "}";
            ObjectMapper mapper = new ObjectMapper();
            FunSale funSale = mapper.readValue(substring, FunSale.class);
            funSaleService.updateByFunSale(funSale);
            result = new Result(111, "修改成功");
            writeValue(result,response);
        } catch (IOException e) {
            e.printStackTrace();
            result = new Result(000, "修改失败");
            writeValue(result,response);
        }


    }

    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = null;
        try {
            Enumeration<String> enu = request.getParameterNames();
            StringBuffer json = new StringBuffer("{");
            while(enu.hasMoreElements()){
                String paraName=(String)enu.nextElement();
                String parameterValue = request.getParameter(paraName);
                json.append("\"").append(paraName).append("\"").append(":").append("\"").append(parameterValue).append("\"").append(",");
            }
            String substring = json.substring(0, json.length());
            substring = substring + "}";
            ObjectMapper mapper = new ObjectMapper();
            FunSale funSale = mapper.readValue(substring, FunSale.class);
            funSaleService.insert(funSale);
            result = new Result(111, "添加成功");
            writeValue(result,response);
        } catch (IOException e) {
            e.printStackTrace();
            result = new Result(000, "添加失败");
            writeValue(result,response);
        }

    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = null;
        try {
            String saleID = request.getParameter("saleID");
            Integer saleId = saleID.compareToIgnoreCase(saleID);
            funSaleService.deleteById(saleId);
            result = new Result(111, "删除成功");
            writeValue(result,response);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(111, "删除失败");
            writeValue(result,response);
        }
    }

}
