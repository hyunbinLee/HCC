package com.crossit.hcc.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.crossit.hcc.vo.HCCFmbVO;

@Service
@Configurable
public class NoticeMapperImple implements NoticeMapper {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<HCCFmbVO> getNoticeList(int start, int end) {
		// TODO Auto-generated method stub	
		HashMap<String,String> params = new HashMap<String, String>();
		params.put("param1", String.valueOf(start));
		params.put("param2", String.valueOf(end));

		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.NoticeMapper.getNoticeList", params);
	}

	@Override
	public int getNoticeCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.NoticeMapper.getNoticeCount");
		}

	@Override
	public void writeNotice(String title, String content) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", title);
		params.put("param2", content);
		
		sqlSessionTemplate.insert("com.crossit.hcc.dao.NoticeMapper.writeNotice",params);
	}

	@Override
	public HCCFmbVO getNoticeContent(String seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.NoticeMapper.getNoticeContent", seq);
	}

	@Override
	public void deleteNotice(String seq) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("com.crossit.hcc.dao.NoticeMapper.deleteNotice", seq);
		
	}

	@Override
	public void updateNotice(String seq, String title, String content) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", seq);
		params.put("param2", title);
		params.put("param3", content);
		
		sqlSessionTemplate.update("com.crossit.hcc.dao.NoticeMapper.updateNotice", params);
	}
	
	
	@Override
	public void updateHit(String seq) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("com.crossit.hcc.dao.NoticeMapper.updateHit",seq);
	}
}
