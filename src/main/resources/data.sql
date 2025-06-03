-- MEMBER 데이터 (사용자 1명)
INSERT INTO member (id, name, email, password, role, birth_date, phone, created_at, updated_at)
VALUES (1, '홍길동', 'hong@example.com', 'securePassword123', 'USER', '1995-06-15', '010-1234-5678', NOW(), NOW());

INSERT INTO member (id, name, email, password, role, birth_date, phone, created_at, updated_at)
VALUES (2, '관리자', 'admin@admin.com', 'admin', 'ADMIN', '1995-06-15', '010-1234-5678', NOW(), NOW());-- 사용자 23명
INSERT INTO member (id, name, email, password, role, birth_date, phone, created_at, updated_at) VALUES
(3, '이수민', 'sumin.lee@example.com', 'pass1234', 'USER', '1994-01-01', '010-1000-0003', NOW(), NOW()),
(4, '박지훈', 'jihun.park@example.com', 'pass1234', 'USER', '1993-02-02', '010-1000-0004', NOW(), NOW()),
(5, '최예린', 'yerin.choi@example.com', 'pass1234', 'USER', '1992-03-03', '010-1000-0005', NOW(), NOW()),
(6, '정우성', 'woosung.jung@example.com', 'pass1234', 'USER', '1991-04-04', '010-1000-0006', NOW(), NOW()),
(7, '강서윤', 'seoyoon.kang@example.com', 'pass1234', 'USER', '1990-05-05', '010-1000-0007', NOW(), NOW()),
(8, '윤지호', 'jiho.yoon@example.com', 'pass1234', 'USER', '1992-06-06', '010-1000-0008', NOW(), NOW()),
(9, '한지민', 'jimin.han@example.com', 'pass1234', 'USER', '1993-07-07', '010-1000-0009', NOW(), NOW()),
(10, '서도영', 'doyoung.seo@example.com', 'pass1234', 'USER', '1994-08-08', '010-1000-0010', NOW(), NOW()),
(11, '조윤아', 'yoona.jo@example.com', 'pass1234', 'USER', '1990-09-09', '010-1000-0011', NOW(), NOW()),
(12, '배진우', 'jinwoo.bae@example.com', 'pass1234', 'USER', '1991-10-10', '010-1000-0012', NOW(), NOW()),
(13, '임나현', 'nahyun.lim@example.com', 'pass1234', 'USER', '1995-11-11', '010-1000-0013', NOW(), NOW()),
(14, '문세현', 'sehyun.moon@example.com', 'pass1234', 'USER', '1992-12-12', '010-1000-0014', NOW(), NOW()),
(15, '오하늘', 'haneul.oh@example.com', 'pass1234', 'USER', '1993-01-13', '010-1000-0015', NOW(), NOW()),
(16, '신유진', 'yujin.shin@example.com', 'pass1234', 'USER', '1994-02-14', '010-1000-0016', NOW(), NOW()),
(17, '김다온', 'daon.kim@example.com', 'pass1234', 'USER', '1991-03-15', '010-1000-0017', NOW(), NOW()),
(18, '남지섭', 'jiseob.nam@example.com', 'pass1234', 'USER', '1990-04-16', '010-1000-0018', NOW(), NOW()),
(19, '노유하', 'yuha.no@example.com', 'pass1234', 'USER', '1992-05-17', '010-1000-0019', NOW(), NOW()),
(20, '장예진', 'yejin.jang@example.com', 'pass1234', 'USER', '1993-06-18', '010-1000-0020', NOW(), NOW()),
(21, '백지웅', 'jiwoong.baek@example.com', 'pass1234', 'USER', '1994-07-19', '010-1000-0021', NOW(), NOW()),
(22, '양수아', 'sua.yang@example.com', 'pass1234', 'USER', '1995-08-20', '010-1000-0022', NOW(), NOW()),
(23, '하도현', 'dohyun.ha@example.com', 'pass1234', 'USER', '1990-09-21', '010-1000-0023', NOW(), NOW()),
(24, '권태윤', 'taeyoon.kwon@example.com', 'pass1234', 'USER', '1991-10-22', '010-1000-0024', NOW(), NOW()),
(25, '배나영', 'nayeong.bae@example.com', 'pass1234', 'USER', '1992-11-23', '010-1000-0025', NOW(), NOW());

-- 관리자 5명
INSERT INTO member (id, name, email, password, role, birth_date, phone, created_at, updated_at) VALUES
(26, '박지우', 'junsang.yoo@example.com', 'pass1234', 'USER', '1993-12-24', '010-1000-0026', NOW(), NOW()),
(27, '서민영', 'admin.haein@example.com', 'adminpw1', 'ADMIN', '1990-01-01', '010-2000-0027', NOW(), NOW()),
(28, '김건우', 'admin.soyeon@example.com', 'adminpw2', 'ADMIN', '1990-02-02', '010-2000-0028', NOW(), NOW()),
(29, '김승훈', 'admin.sihu@example.com', 'adminpw3', 'ADMIN', '1990-03-03', '010-2000-0029', NOW(), NOW()),
(30, '안제현', 'admin.haneul@example.com', 'adminpw4', 'ADMIN', '1990-04-04', '010-2000-0030', NOW(), NOW());

-- EMOTION 데이터 (30개)
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (1, 'JOY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (2, 'ANGRY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (3, 'SAD', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (4, 'ANXIETY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at)VALUES (5, 'HURT', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (6, 'EMBARRASSED', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (7, 'ANGRY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (8, 'JOY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (9, 'SAD', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (10, 'ANXIETY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (11, 'HURT', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (12, 'EMBARRASSED', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (13, 'ANGRY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (14, 'JOY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (15, 'SAD', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (16, 'ANXIETY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (17, 'HURT', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (18, 'EMBARRASSED', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (19, 'ANGRY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (20, 'JOY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (21, 'SAD', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (22, 'ANXIETY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (23, 'HURT', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (24, 'EMBARRASSED', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (25, 'ANGRY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (26, 'JOY', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (27, 'SAD', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (28, 'SAD', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (29, 'SAD', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (30, 'EMBARRASSED', NOW(), NOW());
INSERT INTO emotion (emotion_id, emotion_type, created_at, updated_at) VALUES (31, 'SAD', NOW(), NOW());

-- TRANSFORM_DIARY 데이터 (30개)
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (1, '오늘은 작고 소소한 일이 하루를 환하게 만들었다. 우연히 마주한 작은 기쁨이 마음을 간지럽혔고, 혼자 웃음이 새어 나왔다. 특별한 이유 없이 기분이 좋은 날이 있다는 건, 삶이 아직 따뜻하다는 증거 같았다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (2, '오늘은 억울한 감정이 하루 종일 나를 따라다녔다. 잘못한 사람은 따로 있는데, 내가 조용히 참아야 했고 결국 사과까지 하게 됐다. 겉으로는 아무렇지 않은 척했지만, 마음속 분노는 쉽게 가라앉지 않았다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (3, '오늘은 별일 없이 지나갔지만, 마음은 유독 무거웠다. 밝은 표정 뒤로 감춘 감정들이 하루 종일 나를 짓눌렀고, 사람들과의 대화조차 힘겹게 느껴졌다. 고요한 슬픔이 마음 안에 머물렀고, 나조차 내 마음을 이해하기 어려운 날이었다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (4, '발표를 앞둔 오늘 하루는 온몸이 긴장으로 굳어 있었다. 준비한 내용을 떠올리며 되뇌었지만, 막상 사람들 앞에 서자 모든 게 흐려졌다. 끝나고 나니 안도의 숨이 나왔고, 부족했더라도 그 자리에 선 나 자신이 자랑스러웠다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (5, '새로 구입한 책을 읽으며 오랜만에 집중하는 시간을 가졌습니다. 책 속의 문장들이 마음을 울렸고, 작은 위안을 얻을 수 있었습니다. 독서의 즐거움을 다시 한번 깨닫게 된 하루였습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (6, '갑작스러운 비로 인해 예정되었던 약속이 취소되어 실망스러운 하루를 보냈습니다. 창밖을 내다보며 허탈함을 느꼈지만, 이런 날도 필요한 휴식의 시간이라고 스스로를 위로하려 노력했습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (7, '오랜만에 가족들과 통화를 하며 따뜻한 대화를 나누었습니다. 평소에는 바쁘다는 이유로 소홀했던 관계가 생각나 마음이 무거웠지만, 앞으로는 자주 연락을 드려야겠다고 다짐했습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (8, '오늘은 평소보다 일찍 잠자리에 들려고 노력했습니다. 피로가 누적된 탓인지 쉽게 잠들 수 있었고, 아침에 개운하게 일어날 수 있었습니다. 충분한 수면의 중요성을 다시 한번 깨닫게 된 하루였습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (9, '오랜만에 요리를 도전했지만 생각보다 잘 되지 않아 실망스러웠습니다. 하지만 실패를 통해 배운 점도 많았고, 다음에는 더 잘할 수 있을 것이라는 자신감을 얻을 수 있었습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (10, '오늘은 하루 종일 비가 내려 우울한 기분이 들었습니다. 하지만 따뜻한 차 한 잔과 좋아하는 음악을 들으며 마음을 다스릴 수 있었습니다. 비오는 날에도 작은 즐거움을 찾을 수 있다는 것을 깨달았습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (11, '오랜만에 운동을 하여 몸과 마음이 상쾌해지는 것을 느꼈습니다. 땀을 흘리며 스트레스를 해소할 수 있어 좋았고, 앞으로 꾸준히 운동을 이어가야겠다는 다짐을 했습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (12, '오늘은 뜻밖의 선물을 받아 기쁜 하루를 보냈습니다. 소소한 관심과 정성이 더 큰 기쁨을 준다는 것을 다시 한번 깨닫게 되었습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (13, '오랜만에 집안 대청소를 하여 환경을 정리했습니다. 물건들을 정리하니 마음도 같이 정리되는 느낌이 들어 만족스러웠습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (14, '오늘은 평소보다 많은 사람들을 만나 소통하는 하루였습니다. 다양한 이야기를 나누며 새로운 관점을 얻을 수 있어 유익한 시간이었습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (15, '오랜만에 영화를 보며 감동적인 시간을 보냈습니다. 영화 속 메시지가 마음에 깊이 와닿아 오랫동안 생각에 잠기게 했습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (16, '오늘은 갑작스러운 계획 변경으로 인해 당황스러운 하루를 보냈습니다. 하지만 유연하게 대처하며 새로운 기회를 발견할 수 있었습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (17, '오랜만에 일기를 쓰며 하루를 돌아보는 시간을 가졌습니다. 마음을 정리하니 내일을 위한 에너지가 생기는 느낌이 들었습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (18, '오늘은 평소보다 조용히 혼자만의 시간을 보냈습니다. 조용한 시간 속에서도 마음의 평화를 찾을 수 있어 좋았습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (19, '오랜만에 새로운 레시피에 도전하여 요리를 해보았습니다. 결과는 생각보다 만족스러웠고, 작은 성취감을 느낄 수 있었습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (20, '오늘은 하루 종일 비가 내려 우울한 기분이 들었습니다. 하지만 따뜻한 차 한 잔과 좋아하는 음악을 들으며 마음을 다스릴 수 있었습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (21, '오랜만에 운동을 하여 몸과 마음이 상쾌해지는 것을 느꼈습니다. 땀을 흘리며 스트레스를 해소할 수 있어 좋았습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (22, '오늘은 뜻밖의 선물을 받아 기쁜 하루를 보냈습니다. 소소한 관심과 정성이 더 큰 기쁨을 준다는 것을 깨달았습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (23, '오랜만에 집안 대청소를 하여 환경을 정리했습니다. 물건들을 정리하니 마음도 같이 정리되는 느낌이 들었습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (24, '오늘은 평소보다 많은 사람들을 만나 소통하는 하루였습니다. 다양한 이야기를 나누며 새로운 관점을 얻을 수 있었습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (25, '오랜만에 영화를 보며 감동적인 시간을 보냈습니다. 영화 속 메시지가 마음에 깊이 와닿았습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (26, '오늘은 갑작스러운 계획 변경으로 인해 당황스러운 하루를 보냈습니다. 하지만 유연하게 대처하며 새로운 기회를 발견했습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (27, '오랜만에 일기를 쓰며 하루를 돌아보는 시간을 가졌습니다. 마음을 정리하니 내일을 위한 에너지가 생겼습니다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (28, '오늘 퇴근길, 버스 창밖을 바라보다 문득 울컥해졌다. 주변은 분주했지만 나만 정지된 듯한 느낌이 들었고, 마음속 공허함이 깊어졌다. 말 한마디 건넬 기운조차 없어, 그저 고요 속에 나를 숨기고 싶었다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (29, '하루 종일 휴대폰은 조용했고, 나는 그 침묵 속에서 점점 작아졌다. 누군가의 연락이 간절했던 건 아니지만, 그 어떤 관심도 닿지 않는 느낌이 서글펐다. 가만히 앉아 있는 것만으로도 눈물이 고였고, 괜찮지 않다는 걸 스스로 인정하고 싶지 않았다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (30, '회의 중 예상치 못한 질문을 받았고, 순간 머릿속이 새하얘졌다. 모두의 시선이 느껴졌고, 침착하려 했지만 말이 꼬였다. 말은 했지만 스스로도 낯설게 느껴졌고, 자리를 떠나고 싶을 만큼 당황스러운 순간이었다. 평정심을 되찾기까지 시간이 오래 걸렸다.', NOW(), NOW());
INSERT INTO transform_diary (transform_diary_id, content, created_at, updated_at) VALUES (31, '오늘은 이유 없이 마음이 내려앉는 하루였다. 특별한 사건이 있었던 것도 아니건만, 눈앞에 스치는 것들이 괜히 가슴을 먹먹하게 만들었다. 조용히 있으면 눈물이 나올 것 같았고, 아무 말도 하지 못한 채 하루를 보냈다. 나 자신에게조차 솔직해지기 어려운 날이었다.', NOW(), NOW());

-- DIARY_FEEDBACK 데이터 (30개)
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (1, '작은 기쁨을 알아차릴 수 있다는 건 마음이 열려 있다는 뜻이에요. 그런 순간을 느낀 당신은 오늘을 충분히 잘 살아낸 거예요. 그 기분, 오래 간직하길 바라요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (2, '화가 나는 건 당연해요. 감정을 억누르는 것보다, 이렇게 표현해주는 게 훨씬 건강한 방법이에요. 오늘 당신은 참아낸 게 아니라, 감정을 이해하려 애쓴 거예요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (3, '이유 없이 슬픈 날도 있어요. 그런 감정을 받아들이는 것만으로도 충분히 잘하고 있는 거예요. 오늘도 잘 버텨준 당신, 정말 고마워요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (4, '긴장했다는 건 그만큼 당신이 진심이었다는 뜻이에요. 떨리는 순간에도 끝까지 해낸 당신은 충분히 대단해요. 완벽보다 중요한 건 용기예요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (5, '독서는 마음의 양식입니다. 좋은 책과 함께하는 시간을 자주 가져보세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (6, '비오는 날은 우울할 수 있지만, 그 속에서도 작은 즐거움을 찾아보세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (7, '가족과의 대화는 소중합니다. 자주 연락드리세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (8, '충분한 수면은 건강의 기본입니다. 꾸준히 유지하세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (9, '요리는 실패를 통해 배우는 과정입니다. 다음에는 더 잘할 수 있을 거예요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (10, '비오는 날의 정취를 즐기며 마음의 안정을 찾아보세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (11, '운동은 신체적, 정신적 건강에 도움이 됩니다. 꾸준히 이어가세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (12, '소소한 선물도 큰 기쁨을 줍니다. 주변에 관심을 기울여보세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (13, '환경을 정리하면 마음도 정리됩니다. 자주 해보세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (14, '다양한 사람들과의 소통은 새로운 영감을 줍니다. 즐겁게 대화하세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (15, '영화는 삶의 교훈을 줍니다. 좋은 작품을 자주 감상하세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (16, '계획 변경은 새로운 기회입니다. 유연하게 대처하세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (17, '일기는 마음의 거울입니다. 꾸준히 작성해보세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (18, '혼자만의 시간도 소중합니다. 즐겁게 보내세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (19, '요리는 창의적인 활동입니다. 즐기면서 도전하세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (20, '비오는 날은 마음이 우울할 수 있습니다. 따뜻한 차 한 잔으로 위로하세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (21, '운동은 건강을 유지하는 가장 좋은 방법입니다. 꾸준히 하세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (22, '소소한 선물도 큰 기쁨을 줍니다. 주변에 관심을 기울여보세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (23, '환경을 정리하면 마음도 정리됩니다. 자주 해보세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (24, '다양한 사람들과의 소통은 새로운 영감을 줍니다. 즐겁게 대화하세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (25, '영화는 삶의 교훈을 줍니다. 좋은 작품을 자주 감상하세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (26, '계획 변경은 새로운 기회입니다. 유연하게 대처하세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (27, '일기는 마음의 거울입니다. 꾸준히 작성해보세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (28, '조용히 멈추고 싶은 날도 있어요. 그런 감정을 느낄 줄 아는 당신은 충분히 섬세하고 따뜻한 사람이에요. 감정을 억누르지 말고, 스스로에게도 조금 더 부드럽게 대해주세요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (29, '슬픔은 이유를 따지기보단 그냥 느껴지는 감정이에요. 오늘 같은 날은 눈물을 참지 않아도 괜찮아요. 당신의 조용한 마음에도 누군가는 닿기를 바라고 있을 거예요.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (30, '회의 중 예상치 못한 질문을 받았고, 순간 머릿속이 새하얘졌다. 모두의 시선이 느껴졌고, 침착하려 했지만 말이 꼬였다. 말은 했지만 스스로도 낯설게 느껴졌고, 자리를 떠나고 싶을 만큼 당황스러운 순간이었다. 평정심을 되찾기까지 시간이 오래 걸렸다.', 'LIKE', NOW(), NOW());
INSERT INTO diary_feedback (diary_feedback_id, content, user_reaction, created_at, updated_at) VALUES (31, '당신은 지금 스스로를 바라보고, 조용히 들여다보고 있어요. 그건 이미 잘 버티고 있다는 증거예요. 그냥 떠나고 싶다는 말은 도망이 아니라, 잠시 쉬고 싶다는 마음일지도 몰라요.', 'LIKE', NOW(), NOW());

-- DEPRESSION 데이터 (30개)
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (1, FALSE, 1, 1, 7, 16, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (2, FALSE, 8, 6, 15, 17, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (3, FALSE, 7, 6, 16, 18, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (4, TRUE, 5, 5, 17, 20, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (5, FALSE, 0.4, 0.3, 7, 6, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (6, TRUE, 0.6, 0.5, 13, 10, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (7, FALSE, 0.5, 0.4, 8, 7, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (8, FALSE, 0.1, 0.0, 4, 3, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (9, TRUE, 0.9, 0.8, 16, 13, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (10, TRUE, 0.7, 0.6, 14, 11, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (11, FALSE, 0.3, 0.2, 6, 5, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (12, FALSE, 0.2, 0.1, 5, 4, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (13, TRUE, 0.8, 0.7, 15, 12, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (14, FALSE, 0.4, 0.3, 7, 6, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (15, FALSE, 0.5, 0.4, 8, 7, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (16, TRUE, 0.6, 0.5, 13, 10, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (17, FALSE, 0.1, 0.0, 4, 3, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (18, TRUE, 0.9, 0.8, 16, 13, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (19, FALSE, 0.2, 0.1, 5, 4, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (20, TRUE, 0.7, 0.6, 14, 11, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (21, FALSE, 0.3, 0.2, 6, 5, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (22, FALSE, 0.4, 0.3, 7, 6, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (23, TRUE, 0.8, 0.7, 15, 12, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (24, FALSE, 0.5, 0.4, 8, 7, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (25, TRUE, 0.6, 0.5, 13, 10, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (26, FALSE, 0.1, 0.0, 4, 3, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (27, TRUE, 10, 8, 16, 19, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (28, TRUE, 10, 5, 20, 26, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (29, TRUE, 10, 7, 21, 18, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (30, TRUE, 7, 7, 13, 17, NOW(), NOW());
INSERT INTO depression (depression_id, result, emotion_score, depression_word_score, phq9score, gad7score, created_at, updated_at) VALUES (31, TRUE, 10, 6, 19, 20, NOW(), NOW());

-- DIARY 데이터 (30개)
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (1, 1, '오늘 진짜 별거 아닌 일인데 괜히 기분 좋았음. 편의점에서 마지막 하나 남은 내 최애 간식을 딱 집었을 때, 세상이 날 위해 준비한 선물 같았음. 누가 알아주지 않아도 혼자서 신났고, 괜히 하루가 반짝거렸음. 이런 작은 행복이 오래 갔으면 좋겠다.', '2025-06-01', 1, 1, 1, 1, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (2, 1, '오늘 진짜 열받았음. 분명 내 잘못 아닌데 이상하게 내가 사과하게 됐고, 말도 안 되는 상황인데 그냥 참고 넘겨야 했음. 웃으면서 넘기려고 했지만 속은 부글부글 끓었음. 괜히 혼자만 손해 본 기분, 하루 종일 머릿속에서 안 떠남.', '2025-06-02', 2, 2, 2, 2, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (3, 1, '오늘 발표하는 날이라 아침부터 심장이 계속 두근거렸음. 아무리 준비해도 무대 앞에 서니까 손이 떨리고 목이 마르더라. 머릿속이 하얘지는 느낌도 들었고, 다 끝나고 나서야 숨 좀 쉴 수 있었음. 잘했는진 모르겠지만, 어쨌든 해낸 것 같아 다행이었다.', '2025-06-03', 3, 3, 3, 3, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (4, 1, '오늘은 왜 이렇게 뭐 하나 하기 싫은지… 알람 끄고 계속 누워있었음. 밥도 먹기 귀찮고, 그냥 하루 종일 폰만 뒤적거렸네. 나 왜 이럴까?', '2025-06-04', 4, 4, 4, 4, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (5, 1, '새로 산 책 읽었는데 진짜 좋다. 작가가 쓴 문장 하나하나가 마음에 와닿아서 계속 생각나네. 오랜만에 머리도 식히고 기분도 전환된 기분.', '2025-05-05', 5, 5, 5, 5, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (6, 1, '오늘 약속 있었는데 비 와서 취소됐음. 계획한 거 다 틀어져서 기분 더러웠다. 창문 열고 비 내리는 거 보다가 그냥 잠들었네.', '2025-05-06', 6, 6, 6, 6, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (7, 1, '엄마랑 통화했는데 오랜만에 따뜻한 말씀 해주셔서 눈물 날 뻔. 평소엔 바빠서 연락도 잘 안 했는데… 앞으로는 자주 해야겠다.', '2025-05-07', 7, 7, 7, 7, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (8, 1, '오늘은 일찍 잠 자려고 노력했음. 피곤해서 그런지 금방 잠들었고, 아침에 좀 개운한 기분. 역시 수면이 최고야.', '2025-05-08', 8, 8, 8, 8, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (9, 1, '요리 도전했다가 완전 실패함. 레시피대로 했는데 왜 이렇게 맛이 없는지… 그래도 재밌었으니 됐음. 다음엔 더 잘해보자.', '2025-05-09', 9, 9, 9, 9, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (10, 1, '하루 종일 비 오니까 기분도 다운됨. 그냥 커피 마시면서 창밖 보다가 음악 듣고 있었는데, 좀 나아졌다.', '2025-05-10', 10, 10, 10, 10, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (11, 1, '오늘 운동 갔다 왔는데 기분 좋네. 땀 빼고 나니 머리도 맑아지는 느낌. 앞으로 자주 가야겠다.', '2025-05-11', 11, 11, 11, 11, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (12, 1, '친구가 선물해줘서 기분 좋았다. 별거 아닌데도 이런 거 받으면 진짜 행복함.', '2025-05-12', 12, 12, 12, 12, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (13, 1, '오늘 집 청소했다. 쓰레기 버리고 정리하니 기분이 상쾌해짐. 이제 좀 살만하네.', '2025-05-13', 13, 13, 13, 13, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (14, 1, '오늘 모임에서 새로운 사람들 만났는데 재밌었음. 다양한 이야기 듣다 보니 시간 가는 줄 몰랐네.', '2025-05-14', 14, 14, 14, 14, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (15, 1, '영화 봤는데 진짜 감동적이었음. 끝나고 한참 동안 여운이 남더라. 이런 영화 좋아.', '2025-05-15', 15, 15, 15, 15, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (16, 1, '갑자기 계획이 바뀌어서 당황스러웠음. 그래도 새로운 일정이 더 마음에 들 것 같아.', '2025-05-16', 16, 16, 16, 16, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (17, 1, '오랜만에 일기 써봤다. 적어놓고 보니 별거 아닌 일들인데, 그래도 마음이 정리되는 느낌.', '2025-05-17', 17, 17, 17, 17, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (18, 1, '하루 종일 아무것도 안 하고 혼자 조용히 보냈음. 가끔은 이런 날도 필요한 거 같아.', '2025-05-18', 18, 18, 18, 18, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (19, 1, '새로운 레시피로 요리해봤는데 생각보다 괜찮게 나옴. 뿌듯하네.', '2025-05-19', 19, 19, 19, 19, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (20, 1, '비 오니까 또 우울해졌다. 그래도 어제보다는 나은 거 같아.', '2025-05-20', 20, 20, 20, 20, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (21, 1, '운동 또 갔다 왔음. 이제 습관이 되어가는 거 같아. 좋은 변화인 듯.', '2025-05-21', 21, 21, 21, 21, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (22, 1, '오늘은 내가 친구한테 선물했는데, 반응이 좋아서 기분 좋았다.', '2025-05-22', 22, 22, 22, 22, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (23, 1, '또 청소했다. 이제 좀 더 깔끔해진 거 같아 만족스럽네.', '2025-05-23', 23, 23, 23, 23, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (24, 1, '새로운 사람들과 대화하니 재밌네. 다양한 생각을 접할 수 있어 좋다.', '2025-05-24', 24, 24, 24, 24, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (25, 1, '영화 또 봤는데 이번에도 좋았음. 요즘 영화 보는 게 최고의 힐링이야.', '2025-05-25', 25, 25, 25, 25, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (26, 1, '계획이 또 바뀌었지만, 이번엔 별로 신경 안 썼음. 유연해지는 중?', '2025-05-26', 26, 26, 26, 26, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (27, 1, '일기 쓰는 게 점점 습관이 되어간다. 오늘은 무슨 일이 있었더라…?', '2025-05-27', 27, 27, 27, 27, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (28, 1, '퇴근길에 버스 창밖을 보는데 괜히 눈물이 맺혔음. 바쁘게 걷는 사람들 속에 나만 멈춰 있는 기분이 들었고, 아무 말도 하기 싫어졌음. 웃으려고 해도 마음이 따라주지 않았고, 그냥 조용히 숨고 싶다는 생각만 들었음.', '2025-05-28', 28, 28, 28, 28, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (29, 1, '오늘 아무도 연락을 안 하니까 괜히 내가 필요 없는 사람처럼 느껴졌음. 누가 무시한 것도 아닌데, 조용한 핸드폰 화면 보면서 계속 마음이 가라앉았음. 스스로 괜찮다고 말해봤지만, 자꾸 외로움이 목 끝까지 차올랐음. 그냥 이유 없이 울고 싶은 날이었다.', '2025-05-29', 29, 29, 29, 29, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (30, 1, '오늘 회의에서 갑자기 내 의견을 물어보는 바람에 머릿속이 하얘졌음. 뭘 말해야 할지 생각도 안 나고, 다들 나만 쳐다보는 것 같아서 진짜 식은땀 났음. 대충 뭐라고 말은 했는데, 말 끝나고 나니까 내가 무슨 말을 했는지도 모르겠더라. 그냥 땅속으로 숨고 싶었다.', '2025-05-30', 30, 30, 30, 30, NOW(), NOW());
INSERT INTO diary (diary_id, member_id, content, written_date, emotion_id, transform_diary_id, diary_feedback_id, depression_id, created_at, updated_at) VALUES (31, 1, '오늘따라 괜히 마음이 무거웠다. 누가 상처 준 것도 없고, 별일 없었는데도 눈물이 맺히는 느낌이랄까. 음악 한 곡 듣다가 울컥하고, 창밖 풍경만 봐도 왠지 모르게 허전했다. 웃으려 해도 그게 잘 안 됐고, 그냥 하루 종일 마음이 축축했다. 말하고 싶지도 않고, 듣고 싶지도 않은 그런 날이었다.', '2025-05-31', 31, 31, 31, 31, NOW(), NOW());

INSERT INTO notice (notice_id, title, content, writer, created_at, updated_at) VALUES
(1, '서비스 점검 안내', '안정적인 서비스 제공을 위해 서버 점검이 진행됩니다.', '박지우', NOW(), NOW()),
(2, '신규 기능 출시', '오늘부터 감정 통계 차트를 확인할 수 있는 기능이 추가되었습니다.', '서민영', NOW(), NOW()),
(3, '앱 업데이트 공지', 'v1.2.0 버전으로 앱이 업데이트되었습니다. 최신 버전을 이용해주세요.', '김건우', NOW(), NOW()),
(4, '사용자 피드백 반영', '여러분의 소중한 의견을 반영하여 UI를 개선하였습니다.', '안제현', NOW(), NOW()),
(5, '데이터 복구 완료', '어제 발생한 서버 오류로 인한 데이터 복구가 완료되었습니다.', '김승훈', NOW(), NOW()),
(6, '공지사항 테스트', '이 글은 시스템 테스트용 공지입니다.', '박지우', NOW(), NOW()),
(7, '이벤트 당첨자 발표', '감사 이벤트 당첨자를 발표합니다. 자세한 내용은 링크를 참고해주세요.', '서민영', NOW(), NOW()),
(8, '로그인 오류 해결 안내', '일부 사용자에게 발생한 로그인 오류가 해결되었습니다.', '김건우', NOW(), NOW()),
(9, '개인정보 처리방침 변경', '개인정보 처리방침이 6월 1일부로 변경됩니다. 사전 확인 부탁드립니다.', '안제현', NOW(), NOW()),
(10, '서버 장애 복구 완료', '5월 25일 발생한 일시적 장애가 복구되어 정상적으로 이용 가능합니다.', '김승훈', NOW(), NOW()),
(11, '고객센터 운영시간 변경', '고객센터 운영시간이 오전 9시~오후 6시로 변경됩니다.', '김건우', NOW(), NOW()),
(12, '새로운 테마 적용 안내', '앱의 테마가 여름 테마로 변경되었습니다.', '서민영', NOW(), NOW()),
(13, '이용약관 개정 안내', '2025년 6월부터 적용될 새로운 이용약관을 안내드립니다.', '안제현', NOW(), NOW()),
(14, '주간 이용 통계 리포트', '이번 주 사용자 감정 통계를 공개합니다.', '박지우', NOW(), NOW()),
(15, '일기 작성 팁 공유', '더 효과적인 감정 분석을 위한 일기 작성 팁을 확인하세요.', '김건우', NOW(), NOW()),
(16, '사용자 인터뷰 모집', '앱 개선을 위한 사용자 인터뷰에 참여하실 분을 모집합니다.', '서민영', NOW(), NOW()),
(17, '버그 제보 감사 이벤트', '버그 제보해주신 분들께 감사의 선물을 드립니다.', '김승훈', NOW(), NOW()),
(18, '다크모드 기능 출시', '많은 요청이 있었던 다크모드 기능이 드디어 출시되었습니다.', '안제현', NOW(), NOW()),
(19, '서버 이전 작업 완료', '서버 이전 작업이 완료되어 서비스 안정성이 향상되었습니다.', '김건우', NOW(), NOW()),
(20, '앱 사용 가이드 업데이트', '초보자를 위한 앱 사용 가이드를 업데이트했습니다.', '박지우', NOW(), NOW()),
(21, '기능 요청 설문조사', '여러분이 원하는 기능을 설문을 통해 알려주세요.', '서민영', NOW(), NOW()),
(22, '모바일 최적화 개선', '모바일 환경에서 속도와 반응성을 개선했습니다.', '김승훈', NOW(), NOW()),
(23, '보안 업데이트 공지', '최근 보안 이슈에 대응한 패치를 적용했습니다.', '안제현', NOW(), NOW()),
(24, '앱 종료 일정 안내', '구버전 앱은 7월 1일부터 지원이 종료됩니다.', '김건우', NOW(), NOW()),
(25, '사용자 성장 통계 안내', '지난 한 달간의 사용자 성장 지표를 확인해보세요.', '박지우', NOW(), NOW()),
(26, '새로운 감정 추가 예정', '다양한 감정 인식을 위한 새로운 라벨이 추가될 예정입니다.', '김승훈', NOW(), NOW()),
(27, '웹버전 출시 예고', '곧 PC에서도 EchoLog를 사용할 수 있게 됩니다.', '서민영', NOW(), NOW()),
(28, '문의사항 응대 지연 안내', '현재 문의량 증가로 인해 답변이 지연되고 있습니다.', '안제현', NOW(), NOW()),
(29, '정기 점검 사전 안내', '6월 3일(월) 새벽 1시부터 3시까지 점검이 진행됩니다.', '김건우', NOW(), NOW()),
(30, '감정 데이터 시각화 기능', '감정 데이터를 그래프로 볼 수 있는 기능이 추가되었습니다.', '박지우', NOW(), NOW());


ALTER TABLE member AUTO_INCREMENT = 31;
ALTER TABLE diary AUTO_INCREMENT = 32;
ALTER TABLE emotion AUTO_INCREMENT = 32;
ALTER TABLE depression AUTO_INCREMENT = 32;
ALTER TABLE transform_diary AUTO_INCREMENT = 32;
ALTER TABLE diary_feedback AUTO_INCREMENT = 32;
ALTER TABLE notice AUTO_INCREMENT = 31;

