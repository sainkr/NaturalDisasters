package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnect.DBConnector;

public class UserDAO {
	// DB ���� ����
	private DBConnector dbConnector;
	private Connection conn;
	
	//  SQL ���� ��� ����
	private ResultSet rs;
	
	public UserDAO() {
		dbConnector = DBConnector.getInstance();
	}
	
	private boolean checkID(String id) {    //  ���̵� �ߺ�Ȯ��
		String sql = "select ID from USER_INFO where ID = ?";
		conn = dbConnector.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);    //  ���̵�
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return false;	//  ���̵� �ߺ�
			} else {
				return true;    //  ���̵� ��밡��
			}
		} catch (SQLException e) {    //  ����ó��
			System.err.println("UserDAO checkID SQLExceptoin error");
		} finally {    //  �ڿ�����
			try {
				if(conn != null) {conn.close();}
				if(pstmt != null) {pstmt.close();}
				if(rs != null) {rs.close();}
			} catch(SQLException e) {
				System.err.println("UserDAO checkID close SQLException error");
			}
		}
		return false;    //  DB ����
	}

	public String join(String id, String name, String phone, String password) {    //  ȸ������
		int result = 0;
		if(checkID(id)) {
			String sql = "insert into USER_INFO values(?, ?, ?, ?)";
			conn = dbConnector.getConnection();
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);    //  ���̵�
				pstmt.setString(2, name);    //  ��й�ȣ
				pstmt.setString(3, phone);    //  �̸�
				pstmt.setString(4, password);    //  �ڵ�����ȣ
				result = pstmt.executeUpdate();
			} catch (SQLException e) {    //  ����ó��
				System.err.println("UserDAO join SQLExceptoin error");
				result =  -1;    //  DB ����
			} finally {    //  �ڿ�����
				try {
					if(conn != null) {conn.close();}
					if(pstmt != null) {pstmt.close();}
				} catch(SQLException e) {
					System.err.println("UserDAO join close SQLException error");
				}
			}
		}
		if(result == 1) {
			return "JoinSuccess";
		} else if(result == 0) {
			return "AlreadyID";
		} else {
			return "DBError";
		}
	}
	
	public String login(String id, String password) {    //  �α���
		String sql = "select PASSWORD from USER_INFO where ID = ?";
		conn = dbConnector.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);    //  ���̵�
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(password)) {
					return "LoginSuccess";    //  �α��� ����
				} else {
					return "LoginFail";    //  ��й�ȣ ����
				}
			}
			return "NoID";    //  ���̵� ����
		} catch (SQLException e) {    //  ����ó��
			System.err.println("UserDAO login SQLExceptoin error");
		} finally {    //  �ڿ�����
			try {
				if(conn != null) {conn.close();}
				if(pstmt != null) {pstmt.close();}
				if(rs != null) {rs.close();}
			} catch(SQLException e) {
				System.err.println("UserDAO login close SQLException error");
			}
		}
		return "DBError";    //  DB ����
	}
	
	public String findPW(String id, String name, String phone) {    //  �н����� ã��
		String sql = "select ID from USER_INFO where ID = ? and NAME = ? and PHONE = ?";
		conn = dbConnector.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);    //  ���̵�
			pstmt.setString(2, name);    //  �̸�
			pstmt.setString(3, phone);    //  �ڵ�����ȣ
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return "FindPWSuccess";    //  �ش���̵� Ȯ�� ����, ��й�ȣ ���� ����
			}
			return "FindPWFail";    //  �ش���̵� Ȯ�� ����, ��й�ȣ ���� �Ұ�
		} catch (SQLException e) {    //  ����ó��
			System.err.println("UserDAO findPW SQLExceptoin error");
		} finally {    //  �ڿ�����
			try {
				if(conn != null) {conn.close();}
				if(pstmt != null) {pstmt.close();}
				if(rs != null) {rs.close();}
			} catch(SQLException e) {
				System.err.println("UserDAO findPW close SQLException error");
			}
		}
		return "DBError";    //  DB ����
	}
	
	public int newPW(String id, String newPassword, String phone) {    //  ���ο� ��й�ȣ ����(��й�ȣ �Ҿ������ ��)
		String sql = "update USER_INFO set PASSWORD = ? where ID = ? and PHONE = ?";
		conn = dbConnector.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);    //  ���ο� ��й�ȣ
			pstmt.setString(2, id);    //  ���̵�
			pstmt.setString(3, phone);    //  �ڵ�����ȣ
			return pstmt.executeUpdate();    //  ��й�ȣ ���� �Ϸ�
		} catch (SQLException e) {    //  ����ó��
			System.err.println("UserDAO newPW SQLExceptoin error");
		} finally {    //  �ڿ�����
			try {
				if(conn != null) {conn.close();}
				if(pstmt != null) {pstmt.close();}
			} catch(SQLException e) {
				System.err.println("UserDAO newPW close SQLException error");
			}
		}
		return -1;    //  DB ����
	}
	
	public String changePW(String id, String password, String newPassword) {    //  �н����� �ٲٱ�(������ ��й�ȣ ������ ��)
		int result = 0;
		if(!checkID(id)) {
			String sql = "update USER_INFO set PASSWORD = ? where ID = ? and PASSWORD = ?";
			conn = dbConnector.getConnection();
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newPassword);    //  �ٲ� ��й�ȣ
				pstmt.setString(2, id);    //  ���̵�
				pstmt.setString(3, password);    //  ���� ��й�ȣ
				result = pstmt.executeUpdate();    //  ��й�ȣ ���� �Ϸ�
			} catch (SQLException e) {    //  ����ó��
				System.err.println("UserDAO changePW SQLExceptoin error");
				result = -1;    //  DB ����
			} finally {    //  �ڿ�����
				try {
					if(conn != null) {conn.close();}
					if(pstmt != null) {pstmt.close();}
				} catch(SQLException e) {
					System.err.println("UserDAO changePW close SQLException error");
				}
			}
			if(result != 1) {
				result = -2;    //  ���� ��й�ȣ�� ��Ȯ���� ����
			}
		}
		
		if(result == 1) {
			return "ChangeSuccess";
		} else if(result == 0) {
			return "NoID";
		} else if(result == -2) {
			return "NotPW";
		} else {
			return "DBError";
		}
		
	}
}