package sys

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;

interface ObjectBasics {
	@Name @Column("obj_id") @ColDefine(width=36, update=false)
	String getId();
	void setId(String id);
	@Column("display_text") @ColDefine(width=200)
	String getDisplayText();
	void setDisplayText(String text);
	@Column("descriptions") @ColDefine(type=ColType.TEXT)
	String getDescriptions();
	void setDescriptions(String descs);
}
