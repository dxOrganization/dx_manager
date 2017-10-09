/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.order.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.dx.order.entity.Order;

/**
 * 订单信息（充值）DAO接口
 * @author mzh143
 * @version 2017-10-09
 */
@MyBatisDao
public interface OrderDao extends CrudDao<Order> {
	
}