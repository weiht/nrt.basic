package sys

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;

class OwnedObject
extends BasicObject
implements Owned {
	@Column("owner_id") @ColDefine(notNull=true, width=36)
	String ownerId;
	@Column("owner_group_id") @ColDefine(width=36)
	String ownerGroupId;
	@Column("owner_permissions") @ColDefine(width=200)
	String ownerPermissions;
	@Column("owner_group_permissions") @ColDefine(width=200)
	String ownerGroupPermissions;
	@Column("other_permissions") @ColDefine(width=200)
	String otherPermissions;
}
