package sys.registry

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import sys.Branched;
import sys.TermedObject;

@Table("sys_registry")
class Entry
extends TermedObject
implements Branched {
	@Column("parent_id") @ColDefine(width=36)
	String parentId;
	@Column("entry_code") @ColDefine(width=10, notNull=true)
	String code;
	@Column("entry_code_path") @ColDefine(width=200, notNull=true)
	String codePath;
	@Column("entry_content") @ColDefine(type=ColType.TEXT)
	String content;
}
