begin
  for i in (select table_name from user_tables) loop
    execute immediate 'drop table ' || i.table_name || ' cascade constraints';
  end loop;
end;;--

begin
  for i in (select sequence_name from user_sequences) loop
    execute immediate 'drop SEQUENCE ' || i.sequence_name;
  end loop;
end;;--

begin
  for i in (select trigger_name from user_triggers) loop
    execute immediate 'drop trigger ' || i.trigger_name;
  end loop;
end;;--