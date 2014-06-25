package sys

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;

class BasicObject
implements ObjectBasics, Touchable {
	@Name @Column("obj_id") @ColDefine(width=36, update=false)
	String id;
	@Column("display_text") @ColDefine(width=200)
	String displayText;
	@Column("descriptions") @ColDefine(type=ColType.TEXT)
	String descriptions;
	@Column("creator_id") @ColDefine(notNull=true, width=36)
	String creatorId;
	@Column("create_time") @ColDefine(notNull=true, update=false)
	Date createTime;
	@Column("updater_id") @ColDefine(width=36)
	String updaterId;
	@Column("update_time")
	Date updateTime;
}
