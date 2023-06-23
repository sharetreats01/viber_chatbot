alter table tb_message_template modify column created_at timestamp default now();
alter table tb_message_template modify column modified_at timestamp default now();

insert into tb_message_template (type, template, language, created_at, modified_at, version) VALUES ('WELCOME', '환영합니다! $${name}님 쉐어트리츠 챗봇입니다.', 'ko', default, default, 1);
insert into tb_message_template (type, template, language, created_at, modified_at, version) VALUES ('WELCOME', 'Welcome! $${name} I''m Share Treats Chatbot.', 'en', default, default, 1);
