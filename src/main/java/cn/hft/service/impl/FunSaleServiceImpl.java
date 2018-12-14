package cn.hft.service.impl;

import cn.hft.dao.IFunSaleDao;
import cn.hft.dao.impl.FunSaleDaoImpl;
import cn.hft.entity.FunSale;
import cn.hft.service.IFunSaleService;

import java.util.List;

public class FunSaleServiceImpl implements IFunSaleService {
    IFunSaleDao funSaleDao = new FunSaleDaoImpl();
    /**
     * 查询所有列表
     * @return
     */
    @Override
    public List<FunSale> findAll() {
        return funSaleDao.findAll();
    }
    /**
     * 根据saleId查询结果
     * @param saleID 房源ID
     * @return
     */
    @Override
    public FunSale findById(Integer saleID) {
        return findById(saleID);
    }
    /**
     * 根saleID修改对对象
     * @param funSale 房源对象
     */
    @Override
    public void updateByFunSale(FunSale funSale) {
        funSaleDao.updateByFunSale(funSale);
    }
    /**
     * 添加出售房源
     * @param funSale
     */
    @Override
    public void insert(FunSale funSale) {
        funSaleDao.insert(funSale);
    }
    /**
     *根据住建Sale_id删除出售房源数据
     * @param saleID
     */
    @Override
    public void deleteById(Integer saleID) {
        funSaleDao.deleteById(saleID);
    }
}
