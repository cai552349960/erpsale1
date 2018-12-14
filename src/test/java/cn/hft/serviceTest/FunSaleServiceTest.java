package cn.hft.serviceTest;

import cn.hft.entity.FunSale;
import cn.hft.service.IFunSaleService;
import cn.hft.service.impl.FunSaleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class FunSaleServiceTest {
    private IFunSaleService funSaleService = new FunSaleServiceImpl();

    @Test
    public void findAll() throws SQLException {
        List<FunSale> all = funSaleService.findAll();
        for (FunSale funSale : all) {
            System.out.println(funSale);
        }
    }
}

