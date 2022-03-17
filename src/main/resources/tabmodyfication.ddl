ALTER TABLE article
    ADD user_id INT,
    ADD FOREIGN KEY (user_id) REFERENCES user(id);

UPDATE article SET article.user_id = 1 WHERE article.user_id = null;

ALTER TABLE article MODIFY COLUMN user_id INT NOT NULL;


