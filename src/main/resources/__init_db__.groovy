import org.nutz.dao.Dao;

import data.DataAccess;

import sys.auth.Login;
import sys.auth.AuthService;
import sys.authz.Module;
import sys.authz.ModuleOperation;
import sys.authz.Role;
import sys.authz.RolePrivilege;
import sys.authz.RoleMembership;
import sys.org.Organization;
import sys.org.OrganizationMembership;
import sys.org.OrganizationalUnit;
import sys.org.People;
import sys.registry.Entry;

__json__ = true;

Dao dao = applicationContext.getBean('dao');

def classes = [
	Login.class,
	Module.class,
	ModuleOperation.class,
	Role.class,
	RolePrivilege.class,
	RoleMembership.class,
	Organization.class,
	OrganizationalUnit.class,
	People.class,
	OrganizationMembership.class,
	Entry.class
];

for (Class c: classes) {
	dao.create(c, true);
}

Login l = new Login();
l.loginName = 'admin';
l.salt = 'admin';
l.hashAlgorithm = 'sha-1';
AuthService authSvc = AuthService.getInstance(applicationContext);
authSvc.hashPassword(l, 'nimda');
DataAccess da = DataAccess.getInstance(applicationContext);
da.create(l);

__json__ = l;
