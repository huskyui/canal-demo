
## canal接受方式
第一种tcp形式 ,第二种就是导入到消息队列中 去消费



## 配置canal消息到kafka
相关配置可以在官网上找到


# 几种类型
## ddl

### create

```sql
create table canal_test_tbl(
	id int(11) not null primary key auto_increment,
	name varchar(30) not null default '' COMMENT 'name',
	age int(11) not null default 0 comment 'age'
);
```

```json
{
  "data": null,
  "database": "test",
  "es": 1627228813000,
  "id": 5,
  "isDdl": true,
  "mysqlType": null,
  "old": null,
  "pkNames": null,
  "sql": "create table canal_test_tbl(\r\n\tid int(11) not null primary key auto_increment,\r\n\tname varchar(30) not null default '' COMMENT 'name',\r\n\tage int(11) not null default 0 comment 'age'\r\n)",
  "sqlType": null,
  "table": "canal_test_tbl",
  "ts": 1627228813988,
  "type": "CREATE"
}
```

### 其他

例如表结构修改等等，就不展示了

## dml

###  insert

```sql
insert into canal_test_tbl(name,age) values("huskyui",11),("adios",12);
```

```json
{
  "data": [
    {
      "id": "1",
      "name": "huskyui",
      "age": "11"
    },
    {
      "id": "2",
      "name": "adios",
      "age": "12"
    }
  ],
  "database": "test",
  "es": 1627229231000,
  "id": 6,
  "isDdl": false,
  "mysqlType": {
    "id": "int(11)",
    "name": "varchar(30)",
    "age": "int(11)"
  },
  "old": null,
  "pkNames": [
    "id"
  ],
  "sql": "",
  "sqlType": {
    "id": 4,
    "name": 12,
    "age": 4
  },
  "table": "canal_test_tbl",
  "ts": 1627229231849,
  "type": "INSERT"
}
```

### update

```json
update canal_test_tbl set age = 12 where name = 'huskyui';
```

```json
{
  "data": [
    {
      "id": "1",
      "name": "huskyui",
      "age": "12"
    }
  ],
  "database": "test",
  "es": 1627229378000,
  "id": 7,
  "isDdl": false,
  "mysqlType": {
    "id": "int(11)",
    "name": "varchar(30)",
    "age": "int(11)"
  },
  "old": [
    {
      "age": "11"
    }
  ],
  "pkNames": [
    "id"
  ],
  "sql": "",
  "sqlType": {
    "id": 4,
    "name": 12,
    "age": 4
  },
  "table": "canal_test_tbl",
  "ts": 1627229378842,
  "type": "UPDATE"
}
```

### delete

```sql
delete from canal_test_tbl where id = 1;
```

```sql
{
  "data": [
    {
      "id": "1",
      "name": "huskyui",
      "age": "12"
    }
  ],
  "database": "test",
  "es": 1627229948000,
  "id": 8,
  "isDdl": false,
  "mysqlType": {
    "id": "int(11)",
    "name": "varchar(30)",
    "age": "int(11)"
  },
  "old": null,
  "pkNames": [
    "id"
  ],
  "sql": "",
  "sqlType": {
    "id": 4,
    "name": 12,
    "age": 4
  },
  "table": "canal_test_tbl",
  "ts": 1627229949062,
  "type": "DELETE"
}
```

