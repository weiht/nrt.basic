package sys.authz

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import sys.TermedObject;

@Table("authz_module_operations")
class ModuleOperation
extends TermedObject {
	@Column("module_id") @ColDefine(width=36, notNull=true)
	String moduleId;
}
