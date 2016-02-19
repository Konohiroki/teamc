import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;



public class orclTest{
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"scott","tiger");
			System.out.println("�ڑ�����");
			
			//select��
//			String sql="DROP TABLE threadstest";
//			String sql="CREATE TABLE threadstest(thread_id	NUMBER(3),thread_name	VARCHAR2(20),create_day	VARCHAR2(20))";
//			String sql="INSERT INTO threadstest VALUES(16, '�X���b�h', '2016/02/12')";
			String sql="SELECT * FROM threadstest";
			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);
			
			rs.next();
			String id = rs.getString(1);
			String name = rs.getString(2);
			String day = rs.getString(3);
			
			System.out.println(id+ "\t" +name+ "\t" +day);
			
			//Oracle����ؒf����
			cn.close();
			
			System.out.println("�ؒf����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("�N���X���Ȃ��݂����B");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗�O�݂����B");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

