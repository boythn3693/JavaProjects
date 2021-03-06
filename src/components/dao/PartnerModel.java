/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.entity.Partner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class PartnerModel {

    private static final String QUERY_PARTNER = "from Partner p";
    public static final String QUERY_GET_ALL_PARTNER = "from Partner p order by p.partnerId desc";

    public List runQueryPartner() {
        return QueryDB.GetInstance().runQuery(String.format(QUERY_PARTNER));
    }

    public Boolean insert(Object obj) {
        return QueryDB.GetInstance().save(obj);
    }

    public Boolean update(Object obj) {
        return QueryDB.GetInstance().update(obj);
    }

    public Boolean delete(Object obj) {
        return QueryDB.GetInstance().delete(obj);
    }

    public List<Partner> getListPartner() {
        return QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_ALL_PARTNER));
    }

    public Long countTable() {
        return QueryDB.GetInstance().countTable("select count (*) from Partner");
    }

    public Long countTableFilter(String filter, boolean isName, boolean isDescription, boolean isAddress, boolean isPhone, boolean isNDD) {
        String where = "";
        if (isName) {
            where += (where.equals("") == true) ? "where p.partnerName like '%" + filter + "%' " : "or p.partnerName like '%" + filter + "%' ";
        }
        if (isDescription) {
            where += (where.equals("") == true) ? "where p.description like '%" + filter + "%' " : "or p.description like '%" + filter + "%' ";
        }
        if (isAddress) {
            where += (where.equals("") == true) ? "where p.address like '%" + filter + "%' " : "or p.address like '%" + filter + "%' ";
        }
        if (isPhone) {
            where += (where.equals("") == true) ? "where p.numPhone like '%" + filter + "%' " : "or p.numPhone like '%" + filter + "%' ";
        }
        if (isNDD) {
            where += (where.equals("") == true) ? "where p.representFullname like '%" + filter + "%' " : "or p.representFullname like '%" + filter + "%' ";
        }
        //final String QUERY_GET_PARTNER = "from count (*) Partner p " + where;
        final String QUERY_GET_PARTNER = "select count (*) from Partner p " + where; //System.out.println(QUERY_GET_PARTNER);

        return QueryDB.GetInstance().countTable(QUERY_GET_PARTNER);
    }
    
    public Long countTableFilter2(String maDoiTac, String tenDoiTac, String nguoiDaiDien, String diaChi, String soDienThoai) {
        /*List<Partner> dsPartner = QueryDB.GetInstance().executeHQLQuery("from Partner");
        for (int i = 0; i < dsPartner.size(); i++) {
            System.out.println("Họ tên: " + dsPartner.get(i).getPartnerName());
        }*/
        
        //return (long)QueryDB.GetInstance().executeHQLQuery("select count (*) as soluong from Partner p where p.partnerName = 'Samsung'").getSingleResult();
        //String where = "";
        //List listPartner =  QueryDB.GetInstance().runQuery("from count (*) Partner p");
        //final String QUERY_GET_PARTNER = "from count (*) Partner p " + where;
        //return QueryDB.GetInstance().countTable(QUERY_GET_PARTNER);
        //for(int i=0;i<listPartner.size();i++){
            //System.out.println(listPartner.get(i));
        //}
        //long rs = 10;
        //return rs;
        
        //String where = "where 1=1";
        
        //if (!tenDoiTac.equals("")) {
            //where += " and p.partnerName ='" + tenDoiTac + "'";
        //}
        /*String where = "";
        */
        //final String QUERY_GET_PARTNER = "from count (*) Partner p " + where;

        //return QueryDB.GetInstance().countTable("from count (*) Partner p where PartnerName = 'Samsung'");
        long rs = 10;
        return rs;
    }

    public List<Partner> getListByPagination(List<Partner> list, int start, int end) {
        List<Partner> result = new ArrayList<Partner>();
        for (int i = start; i < end; i++) {
            result.add(list.get(i));
        }
        return result;
    }

    public List<Partner> getListPartnerFilter(String filter, boolean isName, boolean isDescription, boolean isAddress, boolean isPhone, boolean isNDD) {
        String where = "";
        if (isName) {
            where += (where.equals("") == true) ? "where p.partnerName like '%" + filter + "%' " : "or p.partnerName like '%" + filter + "%' ";
        }
        if (isDescription) {
            where += (where.equals("") == true) ? "where p.description like '%" + filter + "%' " : "or p.description like '%" + filter + "%' ";
        }
        if (isAddress) {
            where += (where.equals("") == true) ? "where p.address like '%" + filter + "%' " : "or p.address like '%" + filter + "%' ";
        }
        if (isPhone) {
            where += (where.equals("") == true) ? "where p.numPhone like '%" + filter + "%' " : "or p.numPhone like '%" + filter + "%' ";
        }
        if (isNDD) {
            where += (where.equals("") == true) ? "where p.representFullname like '%" + filter + "%' " : "or p.representFullname like '%" + filter + "%' ";
        }
        final String QUERY_GET_PARTNER = "from Partner p " + where;

        List<Partner> rs = QueryDB.GetInstance().executeHQLQuery(QUERY_GET_PARTNER);
        return rs;
    }
    
    public List<Partner> getListPartnerFilter2(String maDoiTac, String tenDoiTac, String nguoiDaiDien, String diaChi, String soDienThoai) {
        String where = "where 1=1";
        if (!maDoiTac.equals("")) {
            where += " and p.partnerId =" + maDoiTac;
        }
        if (!tenDoiTac.equals("")) {
            where += " and p.partnerName LIKE '%" + tenDoiTac + "%'";
        }
        if (!nguoiDaiDien.equals("")) {
            where += " and p.representFullname LIKE '%" + nguoiDaiDien + "%'";
        }
        if (!diaChi.equals("")) {
            where += " and p.address LIKE '%" + diaChi + "%'";
        }
        if (!soDienThoai.equals("")) {
            where += " and p.numPhone LIKE '%" + soDienThoai + "%'";
        }
        
        List<Partner> dsPartner = QueryDB.GetInstance().executeHQLQuery("from Partner");
        final String QUERY_GET_PARTNER = "from Partner p " + where;
        List<Partner> rs = QueryDB.GetInstance().executeHQLQuery(QUERY_GET_PARTNER);
        
        return rs;
    }

    public Partner getById(long id) {
        final String QUERY_GET_BY_ID = "FROM Partner p WHERE p.partnerId = '%s'";
        List<Partner> list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_BY_ID, id));
        if (list != null && list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return null;
    }
}
