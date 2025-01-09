package com.jbedu.member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jbedu.member.dao.MemberDao;
import com.jbedu.member.dto.MemberDto;

@SpringBootTest
public class MemberTest {

	@Autowired 
	private SqlSession sqlSession;
	
	@Test
	@DisplayName("모든 회원 목록 불러오기 테스트")	//테스트의 이름
	public void memberList() {
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		ArrayList<MemberDto> mDtos	= mDao.memberLitDao()	;
		
		for( MemberDto mDto : mDtos) {
			System.out.print(mDto.getMid()+"/");
			System.out.print(mDto.getMname()+"/");
			System.out.print(mDto.getMemail()+"/");
			System.out.print(mDto.getMage()+"/");
			System.out.print(mDto.getMdate()+"\n");
		}
	}
	
	@Test
	@DisplayName("회원 가입 테스트")
	public void memberInsert( ) {
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		mDao.joinMemberDao("black77", "12345", "홍칠칠", "444@abc.com", 32);
		
		memberList();
	}
	
	@Test
	@DisplayName("회원 삭제 테스트")
	public void memberDelete() {
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		mDao.memberDeleteDao("black77");
		
		memberList();
	}
	
}
