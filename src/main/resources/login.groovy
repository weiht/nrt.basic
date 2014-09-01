import sys.auth.*;

def parseLogin() {
	return [
		'loginName': request.getParameter('loginName'),
		'loginPassword': request.getParameter('loginPassword')
	];
}

def loginSuccessful(login) {
	AuthService authSvc = AuthService.getInstance(applicationContext);
	Login l = authSvc.authenticate(login.loginName, login.loginPassword);
	if (l != null) {
		request.session.setAttribute('__current_login__', l.id);
		return true;
	}
	return false;
}

String lid = request.session.getAttribute('__current_login__');
if (lid != null) {
	skipView = true;
	response.sendRedirect('index.html');
} else {
	login = parseLogin();
	if (loginSuccessful(login)) {
		skipView = true;
		response.sendRedirect('index.html');
	}
}