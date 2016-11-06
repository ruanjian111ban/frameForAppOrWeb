package com.xiaoyu.modules.biz.users.service;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import com.xiaoyu.common.base.BaseService;
import com.xiaoyu.common.base.ResponseMapper;
import com.xiaoyu.modules.biz.users.dao.UserDao;
import com.xiaoyu.modules.biz.users.entity.User;
import com.google.common.collect.Maps;

/**
 * 2016年10月
 * 
 * @author xiaoyu
 * @description
 * @version 1.0
 */
@Service
public class UserService extends BaseService<UserDao, User> {
	

	private Map<String, Object> user2Map(User u) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("userId", u.getId());
		map.put("name", u.getName());
		map.put("password", u.getPassword());
		return map;
	}

	public String userInfo(HttpServletResponse response, String userId) {
		ResponseMapper mapper = new ResponseMapper();
		User u =  new User();
		u.setId(userId);
		User user = this.get(u);
	
		mapper.setDatas(this.user2Map(user));
		return mapper.getResultJson();
	}

	
}
