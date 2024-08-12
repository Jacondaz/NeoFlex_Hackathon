-- Наполнение таблицы ff_hack_schema.ff_hack_statuses.
INSERT INTO ff_hack_schema.ff_hack_statuses (name_status) VALUES ('Состоялось');
INSERT INTO ff_hack_schema.ff_hack_statuses (name_status) VALUES ('Не состоялось');
INSERT INTO ff_hack_schema.ff_hack_statuses (name_status) VALUES ('Запланировано');
INSERT INTO ff_hack_schema.ff_hack_statuses (name_status) VALUES ('Отменено');

-- Наполнение таблицы ff_hack_schema.ff_hack_roles.
INSERT INTO ff_hack_schema.ff_hack_roles (name_role) VALUES ('Эксперт');
INSERT INTO ff_hack_schema.ff_hack_roles (name_role) VALUES ('Рекрутер (HR)');

-- Наполнение таблицы ff_hack_schema.ff_hack_positions.
INSERT INTO ff_hack_schema.ff_hack_positions (name_position, description_position) VALUES ('Data Engineer (Junior)', 'Специалист, который занимается построением и обслуживанием инфраструктуры для работы с данными, а также их предварительной обработкой.');
INSERT INTO ff_hack_schema.ff_hack_positions (name_position, description_position) VALUES ('Data Engineer (Middle)', 'Специалист, который занимается построением и обслуживанием инфраструктуры для работы с данными, а также их предварительной обработкой.');
INSERT INTO ff_hack_schema.ff_hack_positions (name_position, description_position) VALUES ('Data Engineer (Senior)', 'Специалист, который занимается построением и обслуживанием инфраструктуры для работы с данными, а также их предварительной обработкой.');
INSERT INTO ff_hack_schema.ff_hack_positions (name_position, description_position) VALUES ('Java Developer (Junior)', 'Специалист, который пишет, тестирует и поддерживает программы на языке Java.');
INSERT INTO ff_hack_schema.ff_hack_positions (name_position, description_position) VALUES ('Java Developer (Middle)', 'Специалист, который пишет, тестирует и поддерживает программы на языке Java.');
INSERT INTO ff_hack_schema.ff_hack_positions (name_position, description_position) VALUES ('Java Developer (Senior)', 'Специалист, который пишет, тестирует и поддерживает программы на языке Java.');
INSERT INTO ff_hack_schema.ff_hack_positions (name_position, description_position) VALUES ('DevOps Engineer (Junior)', 'Специалист, обеспечивающий автоматизацию процесса разработки продукта.');
INSERT INTO ff_hack_schema.ff_hack_positions (name_position, description_position) VALUES ('DevOps Engineer (Middle)', 'Специалист, обеспечивающий автоматизацию процесса разработки продукта.');
INSERT INTO ff_hack_schema.ff_hack_positions (name_position, description_position) VALUES ('DevOps Engineer (Senior)', 'Специалист, обеспечивающий автоматизацию процесса разработки продукта.');
INSERT INTO ff_hack_schema.ff_hack_positions (name_position, description_position) VALUES ('HR Specialist', 'Сотрудник отдела по управлению персоналом.');

-- Наполнение таблицы ff_hack_schema.ff_hack_candidates.
INSERT INTO ff_hack_schema.ff_hack_candidates
VALUES (
	'Ivanov_II',
	'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',
	'Иванов',
	'Иван',
	'Иванович',
	'Ivanod_II@mail.ru',
	'+79161234567'
);
INSERT INTO ff_hack_schema.ff_hack_candidates
VALUES (
	'Ivanov_IP',
	'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',
	'Иванов',
	'Иван',
	'Петрович',
	'Ivanod_IP@mail.ru',
	'+79161234561'
);
INSERT INTO ff_hack_schema.ff_hack_candidates
VALUES (
	'Ivanov_IM',
	'5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5',
	'Иванов',
	'Иван',
	'Михайлович',
	'Ivanod_IM@mail.ru',
	'+79161234562'
);
INSERT INTO ff_hack_schema.ff_hack_candidates
VALUES (
	'Petrov_IM',
	'8d30c678193105253b548f92bd2e972c39f192ae7cc3af3812c0d7b3bcc6e1ec',
	'Петров',
	'Иван',
	'Михайлович',
	'Petrov_IM@mail.ru',
	'+79161234563'
);

-- Наполнение таблицы ff_hack_schema.ff_hack_conferences.
INSERT INTO ff_hack_schema.ff_hack_conferences (name_conference, description_conference)
VALUES ('Ознакомительная беседа', 'Конференция презентации кандидата');
INSERT INTO ff_hack_schema.ff_hack_conferences (name_conference, description_conference)
VALUES ('Функциональное собеседование', 'Первичное собеседование по теме');
INSERT INTO ff_hack_schema.ff_hack_conferences (name_conference, description_conference)
VALUES ('Техническое собеседование', 'Техническое собеседование по теме');

-- Наполнение таблицы ff_hack_schema.ff_hack_employees.
INSERT INTO ff_hack_schema.ff_hack_employees
VALUES (
	'Ivanov_PI',
	'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',
	'Иванов',
	'Петр',
	'Иванович',
	'Ivanod_PI@mail.ru',
	'+79161234517',
	2,
	0
);
INSERT INTO ff_hack_schema.ff_hack_employees
VALUES (
	'Ivanov_PP',
	'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',
	'Иванов',
	'Петр',
	'Петрович',
	'Ivanod_PP@mail.ru',
	'+79161234521',
	5,
	0
);
INSERT INTO ff_hack_schema.ff_hack_employees
VALUES (
	'Ivanov_PM',
	'5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5',
	'Иванов',
	'Петр',
	'Михайлович',
	'Ivanod_PM@mail.ru',
	'+79161234532',
	8,
	0
);
INSERT INTO ff_hack_schema.ff_hack_employees
VALUES (
	'Petrov_PM',
	'8d30c678193105253b548f92bd2e972c39f192ae7cc3af3812c0d7b3bcc6e1ec',
	'Петров',
	'Петр',
	'Михайлович',
	'Petrov_PM@mail.ru',
	'+79161234543',
	9,
	1
);
INSERT INTO ff_hack_schema.ff_hack_employees
VALUES (
	'Petrov_SM',
	'8d30c678193105253b548f92bd2e972c39f192ae7cc3af3812c0d7b3bcc6e1ec',
	'Петров',
	'Семен',
	'Михайлович',
	'Petrov_SM@mail.ru',
	'+79161234553',
	9,
	1
);

-- Наполнение таблицы ff_hack_schema.ff_hack_briefings.
INSERT INTO ff_hack_schema.ff_hack_briefings (
	name_briefing,
	id_conference_briefing,
	login_expert,
	login_candidate,
	id_position_candidate,
	login_recruiter,
	date_briefing,
	time_briefing,
	id_status_briefing
)
VALUES (
	'Тех. соб. QWE',
	2,
	'Ivanov_PI',
	'Petrov_IM',
	2,
	'Petrov_PM',
	'2024-09-01',
	'09:00',
	2
);
INSERT INTO ff_hack_schema.ff_hack_briefings (
	name_briefing,
	id_conference_briefing,
	login_expert,
	login_candidate,
	id_position_candidate,
	login_recruiter,
	date_briefing,
	time_briefing,
	id_status_briefing
)
VALUES (
	'Фун. соб. QWR',
	1,
	'Ivanov_PI',
	'Petrov_IM',
	2,
	'Petrov_PM',
	'2024-08-01',
	'15:00',
	0
);
INSERT INTO ff_hack_schema.ff_hack_briefings (
	name_briefing,
	id_conference_briefing,
	login_expert,
	login_candidate,
	id_position_candidate,
	login_recruiter,
	date_briefing,
	time_briefing,
	id_status_briefing
)
VALUES (
	'Тех. соб. QWR',
	2,
	'Ivanov_PP',
	'Ivanov_IM',
	5,
	'Petrov_SM',
	'2024-08-01',
	'16:00',
	3
);
INSERT INTO ff_hack_schema.ff_hack_briefings (
	name_briefing,
	id_conference_briefing,
	login_expert,
	login_candidate,
	id_position_candidate,
	login_recruiter,
	date_briefing,
	time_briefing,
	id_status_briefing
)
VALUES (
	'Тех. соб. QWR',
	2,
	'Ivanov_PP',
	'Ivanov_IM',
	5,
	'Petrov_SM',
	'2024-08-01',
	'14:00',
	3
);
INSERT INTO ff_hack_schema.ff_hack_briefings (
	name_briefing,
	id_conference_briefing,
	login_expert,
	login_candidate,
	id_position_candidate,
	login_recruiter,
	date_briefing,
	time_briefing,
	id_status_briefing
)
VALUES (
	'Фун. соб. QWR',
	1,
	'Ivanov_PP',
	'Ivanov_II',
	5,
	'Petrov_SM',
	'2024-08-02',
	'14:00',
	1
);