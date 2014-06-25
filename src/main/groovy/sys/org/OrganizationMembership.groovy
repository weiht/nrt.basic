package sys.org

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import sys.TermedObject;

@Table("org_organization_memberhips")
class OrganizationMembership
extends TermedObject {
	@Column("org_id") @ColDefine(width=36, notNull=true, update=false)
	String organizationId;
	@Column("unit_id") @ColDefine(width=36, notNull=true, update=false)
	String unitId;
	@Column("people_id") @ColDefine(width=36, notNull=true, update=false)
	String peopleId;
}
