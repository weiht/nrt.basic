package sys

import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;

interface Owned {
	String ownerId;
	String ownerGroupId;
	String ownerPermissions;
	String ownerGroupPermissions;
	String otherPermissions;
}
