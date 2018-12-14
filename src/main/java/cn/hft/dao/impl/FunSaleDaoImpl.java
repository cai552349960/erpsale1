package cn.hft.dao.impl;

import cn.hft.dao.IFunSaleDao;
import cn.hft.entity.FunSale;
import cn.hft.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FunSaleDaoImpl implements IFunSaleDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<FunSale> findAll() {
        String sql = "select SALE_ID, SALE_SUBJECT ,BUILD_NAME, TRADE_ADDR, SALE_ROOM, SALE_INNERAREA, REGION_NAME, SECTION_NAME, UPDATE_TIME, SALE_TOTAL_PRICE, SALE_UNIT_PRICE from FUN_SALE";
        return jdbcTemplate.queryForList(sql, FunSale.class);
    }

    @Override
    public FunSale findById(Integer saleID) {
        String sql = "select SALE_ID, SALE_SUBJECT ,BUILD_NAME, TRADE_ADDR, SALE_ROOM, SALE_INNERAREA, REGION_NAME, SECTION_NAME, UPDATE_TIME, SALE_TOTAL_PRICE, SALE_UNIT_PRICE from FUN_SALE where SALE_ID=?";
        return jdbcTemplate.queryForObject(sql, FunSale.class, saleID);
    }

    @Override
    public void updateByFunSale(FunSale funSale) {
        try {
            String sql = "update FUN_SALE set  SALE_SUBJECT=? BUILD_NAME=? TRADE_ADDR=? SALE_ROOM=? SALE_INNERAREA=? REGION_NAME=? SECTION_NAME=? UPDATE_TIME=? SALE_TOTAL_PRICE=? SALE_UNIT_PRICE=? wherer SALE_ID=? ";
            jdbcTemplate.update(sql, funSale.getSaleSubject(), funSale.getBuildName(), funSale.getTradeAddr(), funSale.getSaleRoom(), funSale.getSaleInnerarea(), funSale.getRegionName(), funSale.getSectionName(), funSale.getUpdateTime(), funSale.getSaleTotalPrice(), funSale.getSaleUnitPrice());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(FunSale funSale) {
        try {
            String sql = "insert into Fun_SALE(COMP_ID,CITY_ID,DEPT_ID,CREATION_TIME,SALE_NO,SALE_USEAGE,SALE_SUBJECT,NUMERIC,SALE_SOURCE,SALE_EXPLRTH,BUILD_NAME,TRADE_ADDR,SALE_ROOM,SALE_INNERAREA,REGION_NAME,SECTION_NAME,UPDATE_TIME,SALE_TOTAL_PRICE,SALE_UNIT_PRICE,SALE_CONSIGN,SALE_MAP,PLATE_TYPE,SALE_STATUS,INFO_TYPE,SHARE_FLAG,RED_FLAG,FROM_PUBLIC,SALE_ID_OLD,HOUSE_BARGAIN,PANORAMA_MAP,YOUYOU_DEAL,IS_SALE_LEASE,HOUSE_SITUATION,OLD_TRUE_FLAG) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            jdbcTemplate.update(sql, funSale.getCompID(), funSale.getCityID(), funSale.getDeptID(), funSale.getCreationTime(), funSale.getSaleNo(), funSale.getSaleUseage(), funSale.getSaleUseage(), funSale.getNumeric(), funSale.getSaleSource(), funSale.getSaleExplrth(), funSale.getBuildName(), funSale.getTradeAddr(),
                    funSale.getSaleRoom(), funSale.getSaleInnerarea(), funSale.getRegionName(), funSale.getSectionName(), funSale.getUpdateTime(), funSale.getSaleTotalPrice(), funSale.getSaleUnitPrice(), funSale.getSaleConsign(), funSale.getSaleMap(), funSale.getPlateType(), funSale.getSaleStatus(),
                    funSale.getInfoType(), funSale.getShareFlag(), funSale.getRedFlag(), funSale.getFromPublic(), funSale.getSaleIdOld(), funSale.getHouseBargain(), funSale.getPanoramaMap(), funSale.getYouyouDeal(), funSale.getIsSaleLease(), funSale.getHouseSituation(), funSale.getOldTrueFlag());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(Integer saleID) {
        try {
            String sql = "delete from FUN_SALE where SALE_ID=?";
            jdbcTemplate.update(sql, saleID);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
