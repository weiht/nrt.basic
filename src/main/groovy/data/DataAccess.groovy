package data;

import org.nutz.dao.*;
import org.necros.webmvc.util.*;
import org.nutz.dao.util.cri.*;

import sys.*;

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

	private def makeCriterion(Class<?> clazz, PropertyCriteria[] props) {
		def criterion = null;
		for (PropertyCriteria pc: props) {
			if (criterion == null)
				criterion = Cnd.where(pc.name, '=', pc.value);
			else
				criterion = criterion.and(pc.name, '=', pc.value);
		}
		if (Ordered.class.isAssignableFrom(clazz)) {
			if (criterion == null)
				criterion = Cnd.asc('displayOrder');
			else
				criterion = criterion.asc('displayOrder');
		}
		return criterion;
	}

	List query(Class<?> clazz, PropertyCriteria... props) {
		def criterion = makeCriterion(clazz, props);
		return dao.query(clazz, criterion);
	}

	List queryNotTerminated(Class<?> clazz, PropertyCriteria... props) {
		def criterion = makeCriterion(clazz, props);
		Date now = new Date();
		criterion = criterion.and(Cnd.exps(new IsNull('beginTime')).or('beginTime', '<=', now))
				.and(Cnd.exps(new IsNull('endTime')).or('endTime', '>=', now));
		return dao.query(clazz, criterion);
	}

	//TODO pagination
	//TODO Not termed query/pagination
}
