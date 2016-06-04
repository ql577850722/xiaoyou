package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xiaoyou.biz.IUserInfoBiz;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.UserInfoPO;

public class UserInfoBizImpl implements IUserInfoBiz {
	DBHelper db = new DBHelper();

	/**
	 * 用户登录
	 */
	public UserInfoPO login(UserInfoPO po) {
		String sql = "select * from userInfo where u_email=?  and u_pwd=?";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_email());
		params.add(po.getU_pwd());
		List<UserInfoPO> list = db.find(sql, params, UserInfoPO.class);
		if (null != list && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 用户注册
	 */
	public boolean register(UserInfoPO po) {
		String sql = "insert into userInfo values(seq_u_id.nextval,?,?,?,?,?,?,?,?,?,?,?,?,null,null,null,null,null,null,null,null,null,null)";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_name());
		params.add(po.getU_email());
		params.add(po.getU_pwd());
		params.add(po.getU_sex());
		params.add(po.getU_birth());
		params.add(po.getU_province());
		params.add(po.getU_city());
		params.add(po.getU_area());
		params.add(po.getU_school());
		params.add(po.getU_academy());
		params.add(po.getU_grade());
		params.add(po.getU_photo());
		int flag = db.update(sql, params);
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 找回密码
	 * 
	 * @see xiaoyou.biz.IUserInfoBiz#userPwdBack(xiaoyou.po.UserInfoPO)
	 */
	public boolean userPwdBack(UserInfoPO po) {
		String sql = "updata userInfo set u_pwd=？ where u_email=?";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_pwd());
		params.add(po.getU_email());
		int flag = db.update(sql, params);
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 验证呢称是否重复
	public boolean userNameReg(UserInfoPO po) {
		String sql = "select * from userInfo where u_name=?";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_name());
		List<Map<String, Object>> list = db.select(sql, params);
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 邮箱验证
	 * 
	 * @see xiaoyou.biz.IUserInfoBiz#userEmailReg(xiaoyou.po.UserInfoPO)
	 */
	public boolean userEmailReg(UserInfoPO po) {
		String sql = "select * from userInfo where u_email=?";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_email());
		List<Map<String, Object>> list = db.select(sql, params);
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 查询所有用户信息
	 */
	public List<Map<String, Object>> findAll(UserInfoPO po) {
		String sql = "select * from userInfo where u_email=?";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_email());
		List<Map<String, Object>> list = db.select(sql, params);
		return list;
	}

}
