package sys.auth

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import sys.TermedObject;

@Table("auth_logins")
class Login
extends TermedObject {
	@Column("login_name") @ColDefine(width=200, notNull=true)
	String loginName;
	@Column("hashed_password") @ColDefine(width=64, notNull=true)
	String password;
	@Column("password_salt") @ColDefine(width=10, notNull=true)
	String salt;
	@Column("password_hash_algorithm") @ColDefine(width=20)
	String hashAlgorithm;
}
