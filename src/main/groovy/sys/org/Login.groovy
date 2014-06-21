package sys.org

import org.nutz.dao.entity.annotation.Table;

import sys.TermedObject;

@Table("sys_logins")
class Login
extends TermedObject {
	String loginName;
	String password;
	String salt;
	String hashAlgorithm;
}
