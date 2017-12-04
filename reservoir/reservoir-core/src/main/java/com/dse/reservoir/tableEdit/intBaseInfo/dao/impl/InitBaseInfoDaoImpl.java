package com.dse.reservoir.tableEdit.intBaseInfo.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.tableEdit.intBaseInfo.dao.InitBaseInfoDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by 许兰良 on 2017/7/7.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Repository("InitBaseInfoDaoI")
public class InitBaseInfoDaoImpl extends BaseDao implements InitBaseInfoDao {
    @Override
    public Object reservoirInfo() {
        StringBuffer str = new StringBuffer();
        str.append("select * from WR_PROJ_B b where b.proj_cd in (1,2)");
        return findBySqlWithMap(str.toString());
    }

    @Override
    public Object initSectionInfo() {
        StringBuffer str = new StringBuffer();
//        str.append("select wrm.rb_cd,wrm.proj_cd_one,wrb.proj_nm proj_nm2,wrm.proj_cd_two,wrm.rb_nm,wrbb.proj_nm,wrm.ts,nvl(wrm.item_cd,'') item_cd ,nvl(wrm.nt,'') nt " +
//                "   from WR_RB_M wrm inner join WR_PROJ_B wrb on wrm.proj_cd_one = wrb.proj_cd inner join WR_PROJ_B wrbb on wrm.proj_cd_two = wrbb.proj_cd where wrm.proj_cd_one in(1,2)");
        str.append("SELECT b.proj_cd,b.proj_nm FROM WR_PROJ_B b WHERE b.proj_cd IN(1,2)");
        return findBySqlWithMap(str.toString());
    }

    @Override
    public Object initSectionExtendInfo(String id) {
        ArrayList params = new ArrayList();
        StringBuffer str = new StringBuffer();

        str.append("SELECT * FROM WR_PROJ_B B WHERE 1=1");
        if(StringUtil.isNotEmpty(id)){
            str.append(" AND B.PROJ_CD LIKE ?");
            params.add(id+"0%");
            return findBySqlWithMap(str.toString(),params.toString());
        }else {
            str.append(" AND B.PROJ_CD !=1 AND B.PROJ_CD !=2 AND B.PROJ_CD !=3");
            return findBySqlWithMap(str.toString());
        }


    }

    @Override
    public Object initCcxmInfo() {
        String sql = "SELECT * FROM WR_ITEM_M M";
        return this.findBySqlWithMap(sql);
    }
}
