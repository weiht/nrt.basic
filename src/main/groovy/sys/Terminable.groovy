package sys

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;

interface Terminable {
	Date beginTime;
	Date endTime;
}
