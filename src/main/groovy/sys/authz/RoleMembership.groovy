package sys.authz

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import sys.TermedObject;

@Table("authz_role_memberships")
class RoleMembership
extends TermedObject {
	@Column("role_id") @ColDefine(width=36, notNull=true, update=false)
	String roleId;
	@Column("people_id") @ColDefine(width=36, notNull=true, update=false)
	String peopleId;
}
