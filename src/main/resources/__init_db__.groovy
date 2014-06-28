import org.nutz.dao.Dao;

import sys.auth.Login;
import sys.org.Organization;
import sys.org.OrganizationMembership;
import sys.org.OrganizationalUnit;
import sys.org.People;
import sys.registry.Entry;

__json__ = true;

Dao dao = applicationContext.getBean('dao');

def classes = [
	Login.class,
	Organization.class,
	OrganizationalUnit.class,
	People.class,
	OrganizationMembership.class,
	Entry.class
];

for (Class c: classes) {
	dao.create(c, true);
}

__json__ = classes;