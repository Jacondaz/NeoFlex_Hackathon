# Описание функций БД
## Функция добавления нового сотрудника
```
ff_hack_schema.ff_hack_create_employee
	(
		_login_employee,
		_password_employee,
		_last_name_employee,
		_first_name_employee,
		_patronymic_name_employee,
		_email_employee,
		_phone_employee,
    	_name_position),
		_name_role
	)
```
| Входные параметры | Описание | Входные параметры | Описание |
|-------------------|----------|--------------------|---------|
| _login_employee | Логин сотрудника | _password_employee | Хеш пароля сотрудника |
| _last_name_employee | Фамилия сотрудника | _first_name_employee | Имя сотрудника |
| _patronymic_name_employee | Отчество сотрудника | _email_employee | Электронная почта сотрудника |
| _phone_employee | Номер телефона сотрудника | _name_position | Наименование должности |
| _name_role | Наименование роли |

| Выходные параметры | Описание |
|--------------------|----------|
| 1 | Успешно добавлен |
| -1 | Общие ошибки, включая обработку СУБД нарушение ограничений |
| -2 | Отсутствует должность в БД
| -3 | Отсутствует роль в БД
| -4 | Данный логин занят кандидатом

## Функция добавления нового кандидата.
```
ff_hack_schema.ff_hack_create_candidate
	(
		_login_candidate,
		_password_candidate,
		_last_name_candidate,
		_first_name_candidate,
		_patronymic_name_candidate,
		_email_candidate,
		_phone_candidate
	)
```
| Входные параметры | Описание | Входные параметры | Описание |
|-------------------|----------|--------------------|---------|
| _login_candidate | Логин кандидата | _password_candidate | Хеш пароля кандидата |
| _last_name_candidate | Фамилия кандидата | _first_name_candidate | Имя кандидата |
| _patronymic_name_candidate | Отчество кандидата | _email_candidate | Электронная почта кандидата |
| _phone_candidate | Номер телефона кандидата | 

| Выходные параметры | Описание |
|--------------------|----------|
| 1 | Успешно добавлен |
| -1 | Общие ошибки, включая обработку СУБД нарушение ограничений |
| -4 | Данный логин занят кандидатом

# Описание процедур БД
## Процедура перезагрузки витрины данных
```
ff_hack_schema_dm.ff_hack_briefings_dm_reload()
```
Процедура наполняет витрину данных *ff_hack_schema_dm.ff_hack_briefings_dm*.