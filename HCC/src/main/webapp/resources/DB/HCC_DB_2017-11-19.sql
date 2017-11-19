-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.2.6-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- hcc_db 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `hcc_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hcc_db`;

-- 테이블 hcc_db.hcc_blame_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_blame_tb` (
  `blame_seq` int(11) NOT NULL COMMENT '게시판 시퀀스',
  `blame_code` int(11) NOT NULL COMMENT '게시판 구분 코드',
  `blame_gubun` char(1) NOT NULL COMMENT '게시판 종류',
  `blame_type` char(1) DEFAULT NULL COMMENT '신고 유형',
  `blame_content` text DEFAULT NULL COMMENT '신고내용',
  `blame_reg_seq` int(11) NOT NULL COMMENT '신고자 seq',
  `blame_reg_date` datetime DEFAULT NULL COMMENT '신고일시',
  PRIMARY KEY (`blame_seq`,`blame_code`,`blame_reg_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='신고 테이블';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_diagno_case_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_diagno_case_tb` (
  `diagno_case_seq` char(1) NOT NULL COMMENT '진료과목 구분(내과:A, 신경과:B, 정신건강의학과:C, 외과:D, 정형외과:E, 성형외과:F, 흉부외과:G, 성형외과:H, 소아청소년과:I, 안과:J, 이비인후과:K, 피부과:L, 비뇨기과:M, 마취통증의학과:N, 영상진단의학과:O, 가정의학과:P, 병리과:Q, 산부인과:R, 신경외과:S, 외과:T, 재활의학과:U, 심장혈관병원:V, 암관련과:W, X, Y, Z)',
  `diagno_case_pmage` int(2) NOT NULL COMMENT '진료과목 구분에 따라 ±되는 수',
  `diagno_case_text` text NOT NULL COMMENT '진료과목 구분에 따라 출력되는 텍스트',
  PRIMARY KEY (`diagno_case_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='자가진단결과';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_fmb_reply_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_fmb_reply_tb` (
  `fmb_seq` int(11) NOT NULL COMMENT '의사&환자 게시판 시퀀스',
  `fmb_reply_seq` int(11) NOT NULL COMMENT '댓글 시퀀스',
  `fmb_reply_subseq` int(11) NOT NULL COMMENT '대댓글 시퀀스',
  `fmb_reply_comment` text NOT NULL COMMENT '댓글 내용',
  `fmb_reply_blame_cnt` int(10) DEFAULT 0 COMMENT '신고 수',
  `fmb_reply_reg_seq` int(11) DEFAULT NULL COMMENT '등록자 seq',
  `fmb_reply_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  `fmb_reply_upd_seq` int(11) DEFAULT NULL COMMENT '수정자 seq',
  PRIMARY KEY (`fmb_seq`,`fmb_reply_seq`,`fmb_reply_subseq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='의사&환자 게시판 댓글';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_fmb_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_fmb_tb` (
  `fmb_seq` int(11) NOT NULL AUTO_INCREMENT COMMENT '의사&환자 게시판 시퀀스',
  `fmb_title` varchar(100) NOT NULL COMMENT '제목',
  `fmb_content` text NOT NULL COMMENT '내용',
  `fmb_type` char(1) NOT NULL DEFAULT 'P' COMMENT '게시판 구분(환자:P, 의사:D, 공지:N)',
  `fmb_status` char(1) NOT NULL DEFAULT 'N' COMMENT '게시여부(활성화:Y, 비활성화:N)',
  `fmb_cnt` int(10) DEFAULT 0 COMMENT '조회수',
  `fmb_like_cnt` int(10) DEFAULT 0 COMMENT '좋아요 수',
  `fmb_unlike_cnt` int(10) DEFAULT 0 COMMENT '싫어요 수',
  `fmb_blame_cnt` int(10) DEFAULT 0 COMMENT '신고 수',
  `fmb_reg_seq` int(11) DEFAULT NULL COMMENT '등록자 seq',
  `fmb_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  `fmb_upd_date` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`fmb_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='의사&환자 게시판';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_hospital_info_reply_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_hospital_info_reply_tb` (
  `hospital_info_seq` int(11) NOT NULL COMMENT '병원정보 게시판 시퀀스',
  `hospital_info_reply_seq` int(11) NOT NULL COMMENT '댓글 시퀀스',
  `hospital_info_reply_subseq` int(11) NOT NULL COMMENT '대댓글 시퀀스',
  `hospital_info_reply_comment` text DEFAULT NULL COMMENT '댓글 내용',
  `hospital_info_reply_status` char(1) NOT NULL DEFAULT 'Y' COMMENT '게시여부(활성화:Y, 비활성화:N)',
  `hospital_info_reply_blame_cnt` int(10) DEFAULT NULL COMMENT '신고 수',
  `hospital_info_reply_reg_seq` int(11) DEFAULT NULL COMMENT '등록자 seq',
  `hospital_info_reply_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  `hospital_info_reply_upd_date` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`hospital_info_seq`,`hospital_info_reply_seq`,`hospital_info_reply_subseq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='병원정보 게시판 댓글';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_hospital_info_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_hospital_info_tb` (
  `hospital_info_seq` int(11) NOT NULL AUTO_INCREMENT COMMENT '병 후기 게시판 시퀀스',
  `hospital_info_title` varchar(100) NOT NULL COMMENT '제목',
  `hospital_info_content` text DEFAULT NULL COMMENT '내용',
  `hospital_info_score` double(3,1) DEFAULT 0.0 COMMENT '병원 평점',
  `hospital_info_class` char(1) NOT NULL DEFAULT 'A' COMMENT '진료과목 구분(내과:A, 신경과:B, 정신건강의학과:C, 외과:D, 정형외과:E, 성형외과:F, 흉부외과:G, 성형외과:H, 소아청소년과:I, 안과:J, 이비인후과:K, 피부과:L, 비뇨기과:M, 마취통증의학과:N, 영상진단의학과:O, 가정의학과:P, 병리과:Q, 산부인과:R, 신경외과:S, 외과:T, 재활의학과:U, 심장혈관병원:V, 암관련과:W, X, Y, Z)',
  `hospital_info_type` char(1) NOT NULL DEFAULT 'A' COMMENT '게시판 구분(성인:A, 소아:C)',
  `hospital_info_status` char(1) NOT NULL DEFAULT 'Y' COMMENT '게시여부(활성화:Y, 비활성화:N)',
  `hospital_info_cnt` int(10) DEFAULT 0 COMMENT '조회수',
  `hospital_info_like_cnt` int(10) DEFAULT 0 COMMENT '좋아요 수',
  `hospital_info_unlike_cnt` int(10) DEFAULT 0 COMMENT '싫어요 수',
  `hospital_info_blame_cnt` int(10) DEFAULT 0 COMMENT '신고 수',
  `hospital_info_reg_seq` int(11) DEFAULT NULL COMMENT '등록자 seq',
  `hospital_info_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  `hospital_info_upd_date` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`hospital_info_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='병원정보 게시판';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_hospital_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_hospital_tb` (
  `hospital_seq` int(11) NOT NULL AUTO_INCREMENT COMMENT '병원 시퀀스',
  `hospital_name` varchar(20) NOT NULL COMMENT '병원명',
  `hospital_tel` varchar(16) DEFAULT NULL COMMENT '병원 전화번호',
  `hospital_addr` varchar(200) DEFAULT '-' COMMENT '병원주소',
  `hospital_reg_seq` int(11) DEFAULT NULL COMMENT '등록자 seq',
  `hospital_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  `hospital_upd_seq` int(11) DEFAULT NULL COMMENT '수정자 seq',
  `hospital_upd_date` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`hospital_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='병원 테이블';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_illness_reply_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_illness_reply_tb` (
  `illness_seq` int(11) NOT NULL COMMENT '병 후기 게시판 시퀀스',
  `illness_reply_seq` int(11) NOT NULL COMMENT '댓글 시퀀스',
  `illness_reply_subseq` int(11) NOT NULL COMMENT '대댓글 시퀀스',
  `illness_reply_comment` text NOT NULL COMMENT '댓글 내용',
  `illness_reply_blame_cnt` int(10) DEFAULT 0 COMMENT '신고 수',
  `illness_reply_reg_seq` int(11) DEFAULT NULL COMMENT '등록자 seq',
  `illness_reply_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  `illness_reply_upd_date` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`illness_seq`,`illness_reply_seq`,`illness_reply_subseq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='병에 대한 후기 게시판 댓글';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_illness_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_illness_tb` (
  `illness_seq` int(11) NOT NULL AUTO_INCREMENT COMMENT '병 후기 게시판 시퀀스',
  `illness_title` varchar(100) NOT NULL COMMENT '제목',
  `illness_content` text NOT NULL COMMENT '내용',
  `illness_type` char(1) NOT NULL DEFAULT 'I' COMMENT '게시판 구분(완치:C, 진행중:I)',
  `illness_status` char(1) NOT NULL DEFAULT 'N' COMMENT '게시여부(활성화:Y, 비활성화:N)',
  `illness_cnt` int(10) DEFAULT 0 COMMENT '조회수',
  `illness_like_cnt` int(10) DEFAULT 0 COMMENT '좋아요 수',
  `illness_unlike_cnt` int(10) DEFAULT 0 COMMENT '싫어요 수',
  `illness_blame_cnt` int(10) DEFAULT 0 COMMENT '신고 수',
  `illness_reg_seq` int(11) DEFAULT NULL COMMENT '등록자 seq',
  `illness_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  `illness_upd_date` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`illness_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='병에 대한 후기 게시판';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_like_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_like_tb` (
  `like_seq` int(11) NOT NULL COMMENT '게시판 시퀀스',
  `like_code` int(11) NOT NULL COMMENT '게시판 구분 코드',
  `like_gubun` char(1) NOT NULL COMMENT '게시판 종류',
  `like_reg_seq` int(11) NOT NULL COMMENT '등록자 seq',
  `like_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  PRIMARY KEY (`like_seq`,`like_code`,`like_reg_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='좋아요 테이블';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_notice_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_notice_tb` (
  `notice_seq` int(11) NOT NULL AUTO_INCREMENT COMMENT '공지 시퀀스',
  `notice_title` varchar(100) DEFAULT NULL COMMENT '제목',
  `notice_content` text DEFAULT NULL COMMENT '내용',
  `notice_type` char(1) NOT NULL DEFAULT 'N' COMMENT '게시판 구분(환자:P, 의사:D, 공지:N)',
  `notice_status` char(1) NOT NULL DEFAULT 'Y' COMMENT '게시여부(활성화:Y, 비활성화:N)',
  `notice_cnt` int(10) DEFAULT NULL COMMENT '조회수',
  `notice_like_cnt` int(10) DEFAULT NULL COMMENT '좋아요 수',
  `notice_unlike_cnt` int(10) DEFAULT NULL COMMENT '싫어요 수',
  `notice_blame_cnt` int(10) DEFAULT NULL COMMENT '신고 수',
  `notice_reg_seq` int(11) DEFAULT NULL COMMENT '등록자 seq',
  `notice_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  `notice_upd_date` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`notice_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='공지사항';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_self_diagno_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_self_diagno_tb` (
  `self_diagno_uer_seq` int(11) NOT NULL COMMENT '유저 번호',
  `self_diagno_date` datetime NOT NULL COMMENT '날짜',
  `self_diagno_sep` varchar(10) NOT NULL COMMENT '진단 구분(면역력, 관절, 피부, 혈관, 간, 뱃살',
  `self_diagno_q1` char(1) NOT NULL COMMENT '질문1에 대한 답(O, X)',
  `self_diagno_q2` char(1) NOT NULL COMMENT '질문2에 대한 답(O, X)',
  `self_diagno_q3` char(1) NOT NULL COMMENT '질문3에 대한 답(O, X)',
  `self_diagno_q4` char(1) NOT NULL COMMENT '질문4에 대한 답(O, X)',
  `self_diagno_q5` char(1) NOT NULL COMMENT '질문5에 대한 답(O, X)',
  `self_diagno_q6` char(1) NOT NULL COMMENT '질문6에 대한 답(O, X)',
  `self_diagno_q7` char(1) NOT NULL COMMENT '질문7에 대한 답(O, X)',
  `self_diagno_q8` char(1) NOT NULL COMMENT '질문8에 대한 답(O, X)',
  `self_diagno_q9` char(1) NOT NULL COMMENT '질문9에 대한 답(O, X)',
  `self_diagno_q10` char(1) NOT NULL COMMENT '질문10에 대한 답(O, X)',
  `self_diagno_result` char(1) NOT NULL COMMENT '결과 케이스(A~E, 케이스에 따라 나이±)',
  PRIMARY KEY (`self_diagno_uer_seq`,`self_diagno_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='자가진단';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_unlike_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_unlike_tb` (
  `unlike_seq` int(11) NOT NULL COMMENT '게시판 시퀀스',
  `unlike_code` int(11) NOT NULL COMMENT '게시판 구분 코드',
  `unlike_gubun` char(1) NOT NULL COMMENT '게시판 종류',
  `unlike_reg_seq` int(11) NOT NULL COMMENT '등록자 seq',
  `unlike_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  PRIMARY KEY (`unlike_seq`,`unlike_code`,`unlike_reg_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='싫어요 테이블';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 hcc_db.hcc_user_tb 구조 내보내기
CREATE TABLE IF NOT EXISTS `hcc_user_tb` (
  `user_seq` int(11) NOT NULL AUTO_INCREMENT COMMENT '사용자 시퀀스',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '사용자 아이디',
  `user_pw` varchar(100) NOT NULL COMMENT '사용자 패스워드',
  `user_kind` char(1) NOT NULL DEFAULT 'U' COMMENT '회원 구분(관리자:A, 일반유저:U, 의사:D)',
  `user_gender` char(1) NOT NULL DEFAULT 'U' COMMENT '회원 구분(관리자:A, 일반유저:U, 의사:D)',
  `user_name` varchar(20) NOT NULL COMMENT '사용자 이름',
  `user_birth` int(6) NOT NULL COMMENT '생년월일',
  `user_phone` varchar(16) DEFAULT NULL COMMENT '전화번호',
  `user_email` varchar(30) NOT NULL COMMENT '이메일',
  `user_apply` char(1) NOT NULL DEFAULT 'N' COMMENT '약관동의(동의:Y, 미동의:N)',
  `user_blame_cnt` int(2) NOT NULL COMMENT '신고횟수',
  `user_status` char(1) NOT NULL DEFAULT 'N' COMMENT '사용자상태(활성화:Y, 비활성화:N)',
  `user_reg_seq` int(11) DEFAULT NULL COMMENT '등록자 seq',
  `user_reg_date` datetime DEFAULT NULL COMMENT '등록일시',
  `user_upd_seq` int(11) DEFAULT NULL COMMENT '수정자 seq',
  `user_upd_date` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='회원 정보';

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
