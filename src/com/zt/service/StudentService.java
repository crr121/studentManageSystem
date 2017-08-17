package com.zt.service;

import java.util.List;

import com.zt.dao.StudentDAO;
import com.zt.entity.Student;

public class StudentService {
	private StudentDAO sd = new StudentDAO();
	private Student stu = null;
	private boolean flg ;
	/**
	 * ��ѯѧ��
	 * @return
	 */
	public List<Student> findAll(){
	List<Student> findAll = sd.findAll();
	return findAll;
	}
	/**
	 * ����id��ѯѧ��
	 */
	public Student findById(int id){
		stu= null;
		stu = sd.findById(id);
		return stu;
	}
	/**
	 * ���ѧ��
	 */
	public boolean save(Student student){
		return sd.save(student);
		
	}
	/**
	 * �޸�ѧ��
	 */
	public boolean update(Student student){
		boolean flg = sd.updateStudent(student);
	return flg;
	}
	/**
	 * ɾ��ѧ��
	 * @param id
	 * @return
	 */
	public void delStu(int id){
		//��ɾ��֮ǰ��Ҫ�Ȳ�ѯ��Ҫɾ����id�Ƿ������ݿ��д���
		//�����߼�����һ�㶼��service���洦��
		//Ȼ��ҳ���ֱ�ӵ���service�����ɾ����������
		stu = sd.findById(id);
		if(stu==null){
			System.out.println("��ѧ�������ڣ���");
			//��������ɾ�������������void����������
			//���������returnֻ��һ����������������
			return;
		}
		flg = sd.delStudent(id);
		if(flg){
			System.out.println("ɾ���ɹ�������");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
