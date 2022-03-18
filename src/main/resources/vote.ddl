CREATE TABLE vote (
          user_id INT NOT NULL,
          article_id INT NOT NULL,
          type ENUM('UP', 'DOWN') NOT NULL,
          date DATETIME NOT NULL,
          PRIMARY KEY (user_id, article_id),
          FOREIGN KEY (user_id) REFERENCES user(id),
          FOREIGN KEY (article_id) REFERENCES article(id)
);