CREATE TABLE developers(
  id serial NOT  NULL PRIMARY KEY,
  first_name VARCHAR NOT  NULL,
  last_name VARCHAR NOT NULL
);
CREATE TABLE projects(
 id serial PRIMARY KEY,
 title VARCHAR NOT  NULL
);

CREATE TABLE developer_projects(
  developer_id INTEGER REFERENCES developers(id) NOT NULL,
  project_id INTEGER REFERENCES projects(id) NOT NULL
);


