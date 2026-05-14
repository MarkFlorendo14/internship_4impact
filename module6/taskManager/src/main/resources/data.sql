INSERT INTO users (Username, email, fname, lname, role)
VALUES ('alice', 'alice@example.com', 'Alice', 'Smith', 'USER');

INSERT INTO users (Username, email, fname, lname, role)
VALUES ('bob', 'bob@example.com', 'Bob', 'Jones', 'ADMIN');

INSERT INTO category (name, description) VALUES ('Development', 'Software Dev');
INSERT INTO category (name, description) VALUES ('Testing', 'QA and Testing');

INSERT INTO Task (title, status, priority, user_id, category_id, created_at)
VALUES ('Set up Docker environment', 'ONGOING', 'HIGH',
        (SELECT id FROM users WHERE Username = 'alice'),
        (SELECT id FROM category WHERE name = 'Development'),
        GETDATE());

INSERT INTO Task (title, status, priority, user_id, category_id, created_at)
VALUES ('Write unit tests', 'TODO', 'MEDIUM',
        (SELECT id FROM users WHERE Username = 'bob'),
        (SELECT id FROM category WHERE name = 'Testing'),
        GETDATE());