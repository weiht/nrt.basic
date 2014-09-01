package sys.auth;

import data.*;
import org.slf4j.*;

class AuthService {
	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
	private dataAccess;

	private AuthService(DataAccess da) {
		this.dataAccess = da;
	}

	Login authenticate(String login, String passwd) {
		if (login == null || login.isEmpty()) return null;
		if (passwd == null || passwd.isEmpty()) return null;
		List result = dataAccess.queryNotTerminated(Login.class, new PropertyCriteria(
			name: 'loginName', value: login
		));
		logger.trace("Login result: {}", result);
		if (result == null || result.size() != 1) return null;
		Login l = result.get(0);
		if (l.password == null || l.password.isEmpty()) return null;
		String hashed = HashAlgorithms.hashPassword(passwd, l.salt, l.hashAlgorithm);
		if (hashed == null || hashed.isEmpty()) return null;
		if (hashed.equals(l.password)) return l;
		return null;
	}

	void hashPassword(Login l, String password) {
		l.password = HashAlgorithms.hashPassword(password, l.salt, l.hashAlgorithm);
	}

	static AuthService getInstance(def applicationContext) {
		return new AuthService(DataAccess.getInstance(applicationContext));
	}
}