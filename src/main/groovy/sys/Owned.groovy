package sys

import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;

interface Owned {
	@Column("owner_id") @ColDefine(notNull=true, width=36)
	String getOwnerId();
	void setOwnerId(String id);
	@Column("owner_group_id") @ColDefine(width=36)
	String getOwnerGroupId();
	void setOwnerGroupId(String id);
	@Column("owner_permissions") @ColDefine(width=200)
	String getOwnerPermissions();
	void setOwnerPermissions(String perms);
	@Column("owner_group_permissions") @ColDefine(width=200)
	String getOwnerGroupPermissions();
	void setOwnerGroupPermissions(String perms);
	@Column("other_permissions") @ColDefine(width=200)
	String getOtherPermissions();
	void setOtherPermissions(String perms);
}
