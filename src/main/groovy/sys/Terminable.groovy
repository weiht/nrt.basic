package sys

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;

interface Terminable {
	@Column("begin_time")
	Date getBeginTime();
	void setBeginTime(Date time);
	@Column("end_time")
	Date getEndTime();
	void setEndTime(Date time);
}
