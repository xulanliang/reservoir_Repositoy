package com.dse.reservoir.core.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.entity.TreeNode;
import com.dse.common.enums.DelFlag;
import com.dse.common.enums.Status;
import com.dse.common.util.ConvertUtils;
import com.dse.reservoir.api.pojo.entity.Example;
import com.dse.reservoir.api.pojo.vo.ExampleVO;
import com.dse.reservoir.core.dao.ExampleDao;
import com.dse.service.api.baseplatform.entity.pojo.sys.Dictionary;
import com.dse.service.api.baseplatform.vo.pojo.sys.DictionaryVO;
import org.hibernate.Criteria;
import org.hibernate.criterion.InExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zhoujc on 2016-3-3.
 */
@Repository("exampleDao")
public class ExampleDaoImpl extends BaseDao<Example, String> implements ExampleDao {




    public List<Dictionary> listDictionaryByPidsAndStatus(List<String> pids, Status status) throws Exception {
        if (pids != null && pids.size() > 0) {
            Map<String, Object> params = new HashMap<String, Object>();
            StringBuilder hql = new StringBuilder(" select");
            hql.append(" o")
                    .append(" from Dictionary o")
                    .append(" where o.delFlag = (:delFlagUn) ");
            if (status != null) {
                hql.append(" and o.status = (:status)");
                params.put("status", status);
            }
            /*每个in语句不能超过1000条，防止超过1000条*/
            hql.append(" and (");
            int totle = pids.size();
            int count = pids.size() / 1000 + 1;
            for (int i = 0; i < count; i++) {
                hql.append(" o.pid in (:pids" + i + ")");
                if (i != count - 1) hql.append(" or");
                params.put("pids" + i, pids.subList(i * 1000, i * 1000 + 1000 > totle ? totle : i * 1000 + 1000));
            }
            //数据字典增加排序 author:zhouy,date:20160810
            hql.append(" ) ");
            hql.append("order by o.orderIndex");
            params.put("delFlagUn", DelFlag.DEL_FLAG_UN);
            return getSession().createQuery(hql.toString()).setProperties(params).list();
        }
        return null;
    }

    @Override
    public List<Dictionary> listAllDictionaryByPidsAndStatus(List<String> pids, Status status) throws Exception {
        List<Dictionary> children = listDictionaryByPidsAndStatus(pids, status);
        List<Dictionary> allChildren = new ArrayList<Dictionary>(children);
        if (children != null && children.size() > 0) {
            List<Dictionary> grandChildren = listAllDictionaryByPidsAndStatus(ConvertUtils.convertElementPropertyToList(children, "id"), status);
            if (grandChildren != null && grandChildren.size() > 0) {
                allChildren.addAll(grandChildren);
            }
            return allChildren;
        }
        return null;
    }






    @Override
    public EasyUiPage listDictionary(ExampleVO dictionaryVO, EasyUiPage easyUiPage) throws Exception {
        String key = dictionaryVO.getKey();
        List<String> pids = dictionaryVO.getPids();
        Criteria criteria = createCriteria().add(Restrictions.eq("delFlag", DelFlag.DEL_FLAG_UN));
        if (pids != null && pids.size() > 1000) {
            int totle = pids.size();
            int count = pids.size() / 1000 + 1;
            InExpression criterions[];
            criterions = new InExpression[count];
            int flag = 0;
            for (int i = 0; i < count; i++) {
                criterions[flag++] = (InExpression) Restrictions.in("id", pids.subList(i * 1000, i * 1000 + 1000 > totle ? totle : i * 1000 + 1000));
            }
            criteria.add(Restrictions.or(criterions));
        } else if (pids != null && pids.size() > 0) {
            criteria.add(Restrictions.in("id", pids));
        }

        if (key != null && !"".equals(key)) {
            String keys[] = key.split(" ");
            SimpleExpression criterions[];
            criterions = new SimpleExpression[2 * keys.length];
            int count = 0;
            for (int i = 0; i < keys.length; i++) {
                criterions[count++] = Restrictions.like("name", "%" + keys[i] + "%");
                criterions[count++] = Restrictions.like("code", "%" + keys[i] + "%");
            }
            criteria.add(Restrictions.or(criterions));
        }

        criteria.addOrder(Order.asc("pid"));
        criteria.addOrder(Order.asc("orderIndex"));

        return   findEasyUiPageByCriteria(criteria, easyUiPage);

    }


    @Override
    public Boolean removeDictionaryByIds(List<String> ids) throws Exception {
        if (ids != null && ids.size() > 0) {
            Map<String, Object> params = new HashMap<String, Object>();
            StringBuilder hql = new StringBuilder("update Dictionary d set d.delFlag = (:delFlagIn) where d.id in (:ids)");
            params.put("delFlagIn", DelFlag.DEL_FLAG_IN);
            params.put("ids", ids);
            if (updateByHql(hql.toString(), params) > 0) {
                return true;
            } else
                return false;
        } else
            return false;
    }





}