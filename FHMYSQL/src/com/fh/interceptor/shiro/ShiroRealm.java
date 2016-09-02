package com.fh.interceptor.shiro;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


/**
 * @author fh
 *  2015-3-6
 */
public class ShiroRealm extends AuthorizingRealm {

	/*
	 * 鐧诲綍淇℃伅鍜岀敤鎴烽獙璇佷俊鎭獙璇�non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		 String username = (String)token.getPrincipal();  				//寰楀埌鐢ㄦ埛鍚�
	     String password = new String((char[])token.getCredentials()); 	//寰楀埌瀵嗙爜
		
	     if(null != username && null != password){
	    	 return new SimpleAuthenticationInfo(username, password, getName());
	     }else{
	    	 return null;
	     }
	     
	}
	
	/*
	 * 鎺堟潈鏌ヨ鍥炶皟鍑芥暟, 杩涜閴存潈浣嗙紦瀛樹腑鏃犵敤鎴风殑鎺堟潈淇℃伅鏃惰皟鐢�璐熻矗鍦ㄥ簲鐢ㄧ▼搴忎腑鍐冲畾鐢ㄦ埛鐨勮闂帶鍒剁殑鏂规硶(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

		System.out.println("========2");
		
		return null;
	}

}
