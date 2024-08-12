-- Создание схемы витрины данных команды FF_Hack для проекта согласования календаря встреч.
CREATE SCHEMA IF NOT EXISTS ff_hack_schema_dm AUTHORIZATION "cnrprod1722884901-team-74157";
COMMENT ON SCHEMA ff_hack_schema_dm IS 'Схема витрины данных команды FF_Hack для проекта согласования календаря встреч.';

-- Создание сущности витрины данных.
CREATE TABLE IF NOT EXISTS ff_hack_schema_dm.ff_hack_briefings_dm
(
	dm_name_briefing 		VARCHAR(256)
							NOT NULL,
	dm_fullname_candidate 	VARCHAR(35)
							NOT NULL,
	dm_name_conference 		VARCHAR(256)
							NOT NULL,
	dm_candidate_contacts 	VARCHAR(256)
							NOT NULL,
	dm_name_position 		VARCHAR(256)
							NOT NULL,
	dm_name_status			VARCHAR(30)
							NOT NULL,
	dm_date_briefing 		DATE
							NOT NULL,
	dm_time_briefing		TIME
							NOT NULL,
	dm_fullname_expert		VARCHAR(35)
							NOT NULL,
	dm_expert_contacts		VARCHAR(256)
							NOT NULL,
	dm_fullname_recruiter	VARCHAR(35)
							NOT NULL,
	dm_recruitert_contacts	VARCHAR(256)
							NOT NULL
);

-- Назначение владельцем сущности витрины данных роли cnrprod1722884901-team-74157.
ALTER TABLE IF EXISTS ff_hack_schema_dm.ff_hack_briefings_dm OWNER to "cnrprod1722884901-team-74157";