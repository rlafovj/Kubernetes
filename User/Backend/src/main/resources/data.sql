insert into users (username, password, name, phone, address, job) values ('qwerty', '1234', '홍길동', '011010101', 'Cairo', 'Thief');
insert into users (username, password, name, phone, address, job) values ('qwerty2', '1234', '전현석', '011010102', 'Seoul', 'Engineer');
insert into users (username, password, name, phone, address, job) values ('qwerty3', '1234', '임홍균', '011010103', 'Seoul', 'Engineer');
insert into users (username, password, name, phone, address, job) values ('qwerty4', '1234', '김동은', '011010104', 'Seoul', 'Engineer');
insert into users (username, password, name, phone, address, job) values ('qwerty5', '1234', '최은빈', '011010105', 'Seoul', 'Engineer');
insert into users (username, password, name, phone, address, job) values ('qwerty6', '1234', '이정재', '011010106', 'Wonju', 'Actor');
insert into users (username, password, name, phone, address, job) values ('qwerty7', '1234', '황정민', '011010107', 'Wonju', 'Actor');
insert into users (username, password, name, phone, address, job) values ('qwerty8', '1234', 'Erik', '011010108', 'Tokyo', 'Police');
insert into users (username, password, name, phone, address, job) values ('qwerty9', '1234', 'Daniel', '011010109', 'Tokyo', 'Chef');
insert into users (username, password, name, phone, address, job) values ('qwerty10', '1234', '김푸로', '011010111', 'Wonju', 'Gamer');
insert into users (username, password, name, phone, address, job) values ('qwerty11', '1234', '김연아', '011010121', 'Wonju', 'Athlete');
insert into users (username, password, name, phone, address, job) values ('qwerty12', '1234', '신동엽', '011010131', 'Tokyo', 'Comedian');
insert into users (username, password, name, phone, address, job) values ('qwerty13', '1234', '임우일', '011010141', 'Cairo', 'Comedian');
insert into users (username, password, name, phone, address, job) values ('qwerty14', '1234', '주현영', '011010151', 'Tokyo', 'Comedian');
insert into users (username, password, name, phone, address, job) values ('qwerty15', '1234', '이병헌', '011010161', 'Cairo', 'Actor');

INSERT INTO boards (board_name, board_type) values ('QnA', 'QnA');
INSERT INTO boards (board_name, board_type) values ('Review', 'Review');

INSERT INTO articles (title, content, writer, board_id)
SELECT 'Child, The', 'sit amet nulla quisque arcu libero rutrum ac lobortis vel dapibus at diam', users.id , boards.id
FROM users , boards
WHERE users.id = (SELECT id FROM users ORDER BY RAND() LIMIT 1) AND boards.id = (SELECT id FROM boards ORDER BY RAND() LIMIT 1);
INSERT INTO articles (title, content, writer, board_id)
SELECT 'Can i have?', 'Some Coffee? or any things?', users.id , boards.id
FROM users , boards
WHERE users.id = (SELECT id FROM users ORDER BY RAND() LIMIT 1) AND boards.id = (SELECT id FROM boards ORDER BY RAND() LIMIT 1);
INSERT INTO articles (title, content, writer, board_id)
SELECT 'Welcome to Seoul', 'Neo Seoul is best city in the world!', users.id , boards.id
FROM users , boards
WHERE users.id = (SELECT id FROM users ORDER BY RAND() LIMIT 1) AND boards.id = (SELECT id FROM boards ORDER BY RAND() LIMIT 1);
INSERT INTO articles (title, content, writer, board_id)
SELECT 'Docker is...', 'make human sick', users.id, boards.id
FROM users , boards
WHERE users.id = (SELECT id FROM users ORDER BY RAND() LIMIT 1) AND boards.id = (SELECT id FROM boards ORDER BY RAND() LIMIT 1);
INSERT INTO articles (title, content, writer, board_id)
SELECT 'Ola Amigos!', 'just kidding 저는 한국인이에요.', users.id, boards.id
FROM users , boards
WHERE users.id = (SELECT id FROM users ORDER BY RAND() LIMIT 1) AND boards.id = (SELECT id FROM boards ORDER BY RAND() LIMIT 1);