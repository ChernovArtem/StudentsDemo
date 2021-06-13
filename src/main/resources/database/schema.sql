drop table if exists students;
drop table if exists progress_handbook;

create table if not exists progress_handbook(
  id serial primary key,
  text varchar(255) not null
);

create table if not exists students(
  id serial primary key,
  fio varchar(255) not null,
  birthday date not null,
  progressid int,
  constraint fk_progress_student foreign key(progressid) references progress_handbook(id)
);