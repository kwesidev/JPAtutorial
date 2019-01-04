create table developers(

  id serial not null primary key,
  first_name varchar not null,
  last_name varchar not null
);
create table developer_projects(
  developer_id integer references developers(id) not null,
  project_id integer references projects(id) not null
);

create table projects(

 id serial primary key,
 title varchar not null
);
