package sys

import org.nutz.dao.entity.annotation.Column;

class TermedObject
extends BasicObject
implements Terminable {
	@Column("begin_time")
	Date beginTime;
	@Column("end_time")
	Date endTime;
}
