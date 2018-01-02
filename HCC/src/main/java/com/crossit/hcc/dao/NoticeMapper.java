package com.crossit.hcc.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.crossit.hcc.vo.LikeVO;
import com.crossit.hcc.vo.NoticeVO;
import com.crossit.hcc.vo.UnlikeVO;

@Service
@Configurable
public class NoticeMapper {

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<NoticeVO> getNoticeList(int start, int end) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", String.valueOf(start));
		params.put("param2", String.valueOf(end));

		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.NoticeMapper.getNoticeList", params);
	}

	public int getNoticeCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.NoticeMapper.getNoticeCount");
	}

	public void writeNotice(String title, String content, int regSeq) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("param1", title);
		params.put("param2", content);
		params.put("param3", regSeq);

		sqlSessionTemplate.insert("com.crossit.hcc.dao.NoticeMapper.writeNotice", params);
	}

	public NoticeVO getNoticeContent(String seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.NoticeMapper.getNoticeContent", seq);
	}

	public List<NoticeVO> getNoticeContentByUserSeq(String seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.NoticeMapper.getNoticeContentByUserSeq", seq);
	}

	public List<NoticeVO> getLikeNoticeContentByUserSeq(String seq) {
		// TODO Auto-generated method stub
		NoticeVO tmp;
		List<NoticeVO> notice_list = new ArrayList<NoticeVO>();
		List<LikeVO> like_seq = sqlSessionTemplate
				.selectList("com.crossit.hcc.dao.NoticeMapper.getLikeNoticeContentByUserSeq", seq);
		for (int i = 0; i < like_seq.size(); i++) {
			tmp = ((NoticeVO) sqlSessionTemplate.selectOne("com.crossit.hcc.dao.NoticeMapper.getNoticeContent",
					like_seq.get(i).getLike_seq()));

			if (tmp == null)
				continue;

			notice_list.add(tmp);

		}

		Collections.reverse(notice_list);// 거꾸로 뒤집기.

		return notice_list;
	}

	public void deleteNotice(String seq) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("com.crossit.hcc.dao.NoticeMapper.deleteNotice", seq);

	}

	public void updateNotice(String seq, String title, String content) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", seq);
		params.put("param2", title);
		params.put("param3", content);

		sqlSessionTemplate.update("com.crossit.hcc.dao.NoticeMapper.updateNotice", params);
	}

	public void updateHit(String seq) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("com.crossit.hcc.dao.NoticeMapper.updateHit", seq);
	}

	public LikeVO checkLike(String like_seq, String like_code, String like_reg_seq) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", like_seq);
		params.put("param2", like_code);
		params.put("param3", like_reg_seq);

		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.NoticeMapper.checkLike", params);
	}

	public UnlikeVO checkUnlike(String unlike_seq, String unlike_code, String unlike_reg_seq) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", unlike_seq);
		params.put("param2", unlike_code);
		params.put("param3", unlike_reg_seq);

		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.NoticeMapper.checkUnlike", params);
	}

	public void addLikeList(String like_seq, String like_code, String like_reg_seq) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", like_seq);
		params.put("param2", like_code);
		params.put("param3", like_reg_seq);

		sqlSessionTemplate.insert("com.crossit.hcc.dao.NoticeMapper.addLikeList", params);
	}

	public void updateNoticeLike(String like_seq) {
		// TODO Auto-generated method stub

		sqlSessionTemplate.update("com.crossit.hcc.dao.NoticeMapper.updateNoticeLike", like_seq);
	}

	public void addUnlikeList(String unlike_seq, String unlike_code, String unlike_reg_seq) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", unlike_seq);
		params.put("param2", unlike_code);
		params.put("param3", unlike_reg_seq);

		sqlSessionTemplate.insert("com.crossit.hcc.dao.NoticeMapper.addUnlikeList", params);
	}

	public void updateNoticeUnlike(String unlike_seq) {

		sqlSessionTemplate.update("com.crossit.hcc.dao.NoticeMapper.updateNoticeUnlike", unlike_seq);
	}

	public List<NoticeVO> getNoticeHitsList() {

		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.NoticeMapper.getNoticeHitsList");
	}
}
