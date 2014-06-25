package sys.org

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import sys.Branched;
import sys.TermedObject;

@Table("org_organizational_units")
class OrganizationalUnit
extends TermedObject
implements Branched {
	@Column("org_id") @ColDefine(width=36, notNull=true, update=false)
	String organizationId;
	@Column("parent_id") @ColDefine(width=36, update=false)
	String parentId;
	@Column("unit_code") @ColDefine(width=10, notNull=true, update=false)
	String code;
	@Column("unit_code_path") @ColDefine(width=200, notNull=true, update=false)
	String codePath;
	@Column("alt_name") @ColDefine(width=200)
	String alternateName;
}
