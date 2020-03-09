use crm_interactive;

create table interactive_record
(
  id             int auto_increment
    primary key,
  contact_id     bigint       null,
  visit_id       bigint       null,
  data_source    varchar(100) null,
  happen_time    datetime     null,
  personnel      varchar(100) null,
  event          varchar(100) null,
  event_type     varchar(100) null,
  event_type_sub varchar(100) null,
  employee_id    varchar(100) null,
  unit_id        varchar(100) null,
  shop_id        varchar(100) null,
  creator        varchar(100) null,
  sale_phone     varchar(100) null,
  receipt_number varchar(100) null,
  cdate          datetime     null
);
