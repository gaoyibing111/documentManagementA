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
	 * 閻ц缍嶆穱鈩冧紖閸滃瞼鏁ら幋鐑界崣鐠囦椒淇婇幁顖炵崣鐠囷拷non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		 String username = (String)token.getPrincipal();  				//瀵版鍩岄悽銊﹀煕閸氾拷
	     String password = new String((char[])token.getCredentials()); 	//瀵版鍩岀?鍡欑垳
		
	     if(null != username && null != password){
	    	 return new SimpleAuthenticationInfo(username, password, getName());
	     }else{
	    	 return null;
	     }
	     
	}
	
	/*
	 * 閹哄牊娼堥弻銉嚄閸ョ偠鐨熼崙鑺ユ殶, 鏉╂稖顢戦柎瀛樻綀娴ｅ棛绱︾?妯硅厬閺冪姷鏁ら幋椋庢畱閹哄牊娼堟穱鈩冧紖閺冩儼鐨熼悽锟界拹鐔荤煑閸︺劌绨查悽銊р柤鎼村繋鑵戦崘鍐茬暰閻€劍鍩涢惃鍕問闂傤喗甯堕崚鍓佹畱閺傝纭?non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

		System.out.println("========2");
		
		return null;
	}

}
