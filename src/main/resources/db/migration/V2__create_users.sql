
CREATE TABLE users (
  user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR (45) NOT NULL,
  password VARCHAR (64) NOT NULL,
  role VARCHAR (45) NOT NULL,
  enabled TINYINT DEFAULT NULL
);

INSERT INTO users (username,password,role,enabled)
VALUES
('user','$2a$10$ihQhNS3rzR62VD9YTUvYo.2tbelux1DcIYxluqOLkFLgzlINGRJ1G','ROLE_USER', 1);

