request.session.invalidate();
response.sendRedirect('login.html');
skipView = true;