package sys.auth;

import java.security.*;
import org.necros.util.*;

class HashAlgorithms {
	private static final DEFAULT_ALGORITHM = MessageDigest.getInstance('md5');

	private static MessageDigest getAlgorithm(String algorithm) {
		if (algorithm == null || algorithm.isEmpty()) return DEFAULT_ALGORITHM;
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			return DEFAULT_ALGORITHM;
		}
	}

	static String hashPassword(String passwd, String salt, String algorithm) {
		MessageDigest md = getAlgorithm(algorithm);
		md.update(passwd == null ? new byte[0] : passwd.getBytes());
		md.update(salt == null ? new byte[0] : passwd.getBytes());
		return StringUtils.bytesToString(md.digest());
	}
}