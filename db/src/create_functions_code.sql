-- Функция добавления сотрудника.
CREATE OR REPLACE FUNCTION ff_hack_schema.ff_hack_create_employee
	(
		_login_employee				VARCHAR(30),
		_password_employee			VARCHAR(256),
		_last_name_employee			VARCHAR(30),
		_first_name_employee		VARCHAR(20),
		_patronymic_name_employee	VARCHAR(20),
		_email_employee				VARCHAR(40),
		_phone_employee				VARCHAR(20),
    	_name_position				VARCHAR(256),
		_name_role 					VARCHAR(30)
	)
	RETURNS INTEGER AS
	
	$$
	DECLARE
		-- Значения res:
		-- 1 - Успешно добавлен.
		-- -1 - Общие ошибки.
		-- -2 - Отсутствует должность в БД.
		-- -3 - Отсутствует роль в БД.
		-- -4 - Данный логин занят кандидатом.
		res			INTEGER;
		err_code	TEXT;
		msg_text	TEXT;
		flag_ex_np	INTEGER;
		flag_ex_nr	INTEGER;
		flag_ex_l	INTEGER;

	BEGIN
		flag_ex_np := (SELECT 1 FROM ff_hack_schema.ff_hack_positions WHERE _name_position = name_position);
		IF (flag_ex_np IS NULL)
			THEN
				res := -2;
				RAISE INFO 'Наименование должности |%| отсутствует в БД. Добавление невозможно.',
					_name_position;
				RETURN res;
		END IF;
		flag_ex_nr := (SELECT 1 FROM ff_hack_schema.ff_hack_roles WHERE _name_role = name_role);
		IF (flag_ex_nr IS NULL)
			THEN
				res := -3;
				RAISE INFO 'Наименование роли |%| отсутствует в БД. Добавление невозможно.',
					_name_role;
				RETURN res;
		END IF;
		flag_ex_l := (SELECT 1 FROM ff_hack_schema.ff_hack_candidates WHERE _login_employee = login_candidate);
		IF (flag_ex_l)
			THEN
				res := -4;
				RAISE INFO 'Логин |%| занят кандидатом. Добавление невозможно.',
					_login_employee;
				RETURN res;
		END IF;

		INSERT INTO ff_hack_schema.ff_hack_employees
		VALUES (
			_login_employee,
			_password_employee,
			_last_name_employee,
			_first_name_employee,
			NULLIF (_patronymic_name_employee, ''),
			_email_employee,
			_phone_employee,
    		(SELECT id_position FROM ff_hack_schema.ff_hack_positions WHERE _name_position = name_position),
			(SELECT id_role FROM ff_hack_schema.ff_hack_roles WHERE _name_role = name_role) 	
		);
			
		RAISE INFO 'Добавление пользователя с логином |%| успешно произведено.',
					_login_employee;
		res := 1;
		RETURN res;
		
		EXCEPTION
			WHEN others
				THEN
					res := -1;
					GET STACKED DIAGNOSTICS
	    				err_code := RETURNED_SQLSTATE,
						msg_text := MESSAGE_TEXT;
					RAISE NOTICE 'Код ошибки: %;  Сообщение: %.', 
	   					err_code, msg_text;
		
		RETURN res;
	END;
	$$

    LANGUAGE plpgsql;


-- Создание процедуры перезагрузки витрины ff_hack_schema_dm.ff_hack_briefings_dm.
CREATE OR REPLACE PROCEDURE ff_hack_schema_dm.ff_hack_briefings_dm_reload()
	AS
	$$
		
	BEGIN
		-- Удалим содержимое ff_hack_schema_dm.ff_hack_briefings_dm.
		DELETE FROM ff_hack_schema_dm.ff_hack_briefings_dm;

		-- Перезагрузим данные в ff_hack_schema_dm.ff_hack_briefings_dm.
    	INSERT INTO ff_hack_schema_dm.ff_hack_briefings_dm
		SELECT
			b.name_briefing,
			(c.last_name_candidate || ' ' || LEFT(c.first_name_candidate, 1) || '. ' || LEFT(c.patronymic_name_candidate, 1) || '.') AS fullname_candidate,
			('{E-mail: ' || c.email_candidate || '; Phone: ' || c.phone_candidate || '}') AS candidate_contacts,
			cnf.name_conference,
			p.name_position,
			s.name_status,
			date_briefing,
			time_briefing,
			(e.last_name_employee || ' ' || LEFT(e.first_name_employee, 1) || '. ' || LEFT(e.patronymic_name_employee, 1) || '.') AS fullname_expert,
			('{E-mail: ' || e.email_employee || '; Phone: ' || e.phone_employee || '}') AS expert_contacts,
			(r.last_name_employee || ' ' || LEFT(r.first_name_employee, 1) || '. ' || LEFT(r.patronymic_name_employee, 1) || '.') AS fullname_recruiter,
			('{E-mail: ' || r.email_employee || '; Phone: ' || r.phone_employee || '}') AS recruiter_contacts
		FROM ff_hack_schema.ff_hack_briefings b
		JOIN ff_hack_schema.ff_hack_candidates c ON b.login_candidate = c.login_candidate
		JOIN ff_hack_schema.ff_hack_conferences cnf ON b.id_conference_briefing = cnf.id_conference
		JOIN ff_hack_schema.ff_hack_positions p ON b.id_position_candidate = p.id_position
		JOIN ff_hack_schema.ff_hack_statuses s ON b.id_status_briefing = s.id_status
		JOIN ff_hack_schema.ff_hack_employees e ON b.login_expert = e.login_employee
		JOIN ff_hack_schema.ff_hack_employees r ON b.login_recruiter = r.login_employee;
		
	END;
	$$
	LANGUAGE plpgsql;


-- Функция добавления кандидата.
CREATE OR REPLACE FUNCTION ff_hack_schema.ff_hack_create_candidate
	(
		_login_candidate			VARCHAR(30),
		_password_candidate			VARCHAR(256),
		_last_name_candidate		VARCHAR(30),
		_first_name_candidate		VARCHAR(20),
		_patronymic_name_candidate	VARCHAR(20),
		_email_candidate			VARCHAR(40),
		_phone_candidate			VARCHAR(20)
	)
	RETURNS INTEGER AS
	
	$$
	DECLARE
		-- Значения res:
		-- 1 - Успешно добавлен.
		-- -1 - Общие ошибки.
		-- -4 - Данный логин занят кандидатом.
	res			INTEGER;
	err_code	TEXT;
	msg_text	TEXT;
	flag_ex_l	INTEGER;

	BEGIN
		flag_ex_l := (SELECT 1 FROM ff_hack_schema.ff_hack_employees WHERE _login_candidate = login_employee);
		IF (flag_ex_l)
			THEN
				res := -4;
				RAISE INFO 'Логин |%| занят сотрудником. Добавление невозможно.',
					_login_employee;
				RETURN res;
		END IF;

		INSERT INTO ff_hack_schema.ff_hack_candidates
		VALUES (
			_login_candidate,
			_password_candidate,
			_last_name_candidate,
			_first_name_candidate,
			NULLIF (_patronymic_name_candidate, ''),
			_email_candidate,
			_phone_candidate
		);
		RAISE INFO 'Добавление пользователя |%| успешно произведено.', 
					_login_candidate;
		res := 1;
		RETURN res;
	
		EXCEPTION
			WHEN others
				THEN
					res := -1;
					GET STACKED DIAGNOSTICS
	    				err_code := RETURNED_SQLSTATE,
						msg_text := MESSAGE_TEXT;
					RAISE NOTICE 'Код ошибки: %;  Сообщение: %.', 
	   					err_code, msg_text;
		
		RETURN res;
	END;
$$
LANGUAGE plpgsql;