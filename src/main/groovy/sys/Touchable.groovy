package sys

import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;

interface Touchable {
	@Column("creator_id") @ColDefine(notNull=true, width=36)
	String getCreatorId();
	void setCreatorId(String id);
	@Column("create_time")
	Date getCreateTime();
	void setCreateTime(Date time);
	@Column("updater_id") @ColDefine(width=36)
	String getUpdaterId();
	void setUpdaterId(String id);
	@Column("update_time")
	Date getUpdateTime();
	void setUpdateTime(Date time);
}
