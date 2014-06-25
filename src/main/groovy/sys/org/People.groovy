package sys.org

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import sys.TermedObject;

@Table("org_people")
class People
extends TermedObject {
	@Column("org_id") @ColDefine(width=36, notNull=true, update=false)
	String organizationId;
	@Column("login_id") @ColDefine(width=36, notNull=true, update=false)
	String loginId;
	@Column("display_title") @ColDefine(width=200)
	String title;
}
