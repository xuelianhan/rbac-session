/**
 * @see https://stackoverflow.com/questions/927358/how-do-i-undo-the-most-recent-local-commits-in-git
 * @see https://stackoverflow.com/questions/348170/how-to-undo-git-add-before-commit
 */
package org.ict.rbac;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {
	SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
	
	CustomRealm customRealm = new CustomRealm();

	@Before
	public void addUser() {
		String[] roles = new String[] {"admin", "manager"};
		simpleAccountRealm.addAccount("test", "test123", roles);
	}

	@Test
	public void testAuthentication() {
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		//defaultSecurityManager.setRealm(simpleAccountRealm);
		defaultSecurityManager.setRealm(customRealm);
		
		SecurityUtils.setSecurityManager(defaultSecurityManager); 
		Subject subject = SecurityUtils.getSubject(); 
		
		UsernamePasswordToken token = new UsernamePasswordToken("test", "test123", true);
		subject.login(token); 
		System.out.println("isAuthenticated:" + subject.isAuthenticated()); 
		
		boolean isManager = subject.hasRole("manager");
		boolean isUser = subject.hasRole("user");
		System.out.println("isManager:" + isManager + ", isUser:" + isUser); 
		boolean remembered = subject.isRemembered();
		System.out.println("remembered:" + remembered); 
		try {
			subject.checkRoles("admin", "manager");
			System.out.println("has roles of admin and manager"); 
		} catch(AuthorizationException e) {
			e.printStackTrace();
		}
		try {
			subject.checkPermission("admin:add");
			System.out.println("has perm of admin adding"); 
		} catch(AuthorizationException e) {
			e.printStackTrace();
		}
		
		subject.logout();
		System.out.println("isAuthenticated:" + subject.isAuthenticated());
	}
}
