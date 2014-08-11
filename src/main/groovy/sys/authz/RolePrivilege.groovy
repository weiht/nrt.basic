package sys.authz

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import sys.TermedObject;

@Table("authz_role_privileges")
class RolePrivilege
extends TermedObject {
	@Column("role_id") @ColDefine(width=36, notNull=true, update=false)
	String roleId;
	@Column("operation_id") @ColDefine(width=36, notNull=true, update=false)
	String operationId;
}
