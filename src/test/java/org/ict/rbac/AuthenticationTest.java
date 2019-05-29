
package org.ict.rbac;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @see https://stackoverflow.com/questions/927358/how-do-i-undo-the-most-recent-local-commits-in-git
 * @see https://stackoverflow.com/questions/348170/how-to-undo-git-add-before-commit
 */
public class AuthenticationTest {
	SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

	@Before
	public void addUser() {
		simpleAccountRealm.addAccount("test", "test123");
	}

	@Test
	public void testAuthentication() {

		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(simpleAccountRealm);
		
		SecurityUtils.setSecurityManager(defaultSecurityManager); 
		Subject subject = SecurityUtils.getSubject(); 
		
		UsernamePasswordToken token = new UsernamePasswordToken("test", "test123");
		subject.login(token); 
		System.out.println("isAuthenticated:" + subject.isAuthenticated()); 

		subject.logout();

		System.out.println("isAuthenticated:" + subject.isAuthenticated());
	}
}
