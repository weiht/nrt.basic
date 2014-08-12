package data;

import org.nutz.dao.Dao;
import org.necros.webmvc.util.*;

import sys.ObjectBasics;
import sys.Touchable;

class DataAccess {
	private static Dao dao;
	private static SessionUtil sessionUtil;

	static synchronized DataAccess getInstance(def applicationContext) {
		if (dao == null) {
			dao = (Dao) applicationContext.getBean('dao');
			sessionUtil = (SessionUtil) applicationContext.getBean('sessionUtil');
		}
		return new DataAccess();
	}

	private String currentLogin() {
		String uid = sessionUtil.currentLogin;
		if (uid == null) uid = 'anonymous';
		return uid;
	}

	Object create(Object data) {
		if (data instanceof ObjectBasics) {
			data.id = UUID.randomUUID().toString();
		}
		if (data instanceof Touchable) {
			data.creatorId = currentLogin();
			data.createTime = new Date();
			//TODO Record touch log
		}
		dao.insert(data);
		return data;
	}

	Object read(Class<?> clazz, String id) {
		return dao.fetch(clazz, id);
	}

	Object update(Object data) {
		//TODO Read data and only modify properties that are modifiable.
		if (data instanceof Touchable) {
			data.updaterId = currentLogin();
			data.updateTime = new Date();
			//TODO Record touch log
		}
		dao.update(data);
		return data;
	}

	Object delete(Object data) {
		dao.delete(data);
	}
}
